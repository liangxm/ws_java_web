package com.lxm.lottery.servlet;

import java.util.Iterator;
import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lxm.lottery.dao.MatchDAO;
import com.lxm.lottery.dao.impl.MatchDAOImpl;
import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.html.HttpRequest;
import com.lxm.lottery.model.Match;

/**
 * Servlet implementation class WYExtractor
 */
public class WYExtractor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private static final int delay = 1000*5;
	private static final int minutes = 1000*3;
	
	@Override
	public void init() throws ServletException {  
		super.init();
		timer = new Timer();
		timer.schedule(new ExtractorService(), delay, minutes);
    }
	
	@Override
	public void destroy() {
		super.destroy();
		timer.cancel();
	}
	
	class ExtractorService extends TimerTask {

		@Override
		public void run() {
			try {
				System.out.println("data extractor runing");
				String loadData = HttpRequest
						.sendGet(
								"http://caipiao.163.com/order/preBet_jclqNewMixAllAjax.html",
								"cache=1420787380503&betDate=");
				JSONObject jo = new JSONObject(loadData);
				// WYData data = new WYData();
				// JsonHelper.toJavaBean(data, jo.toString());
				// JSONObject obj = data.getMatchList();
				JSONObject obj = jo.getJSONObject("matchList");
				MatchDAO matchDao = new MatchDAOImpl();
				@SuppressWarnings("unchecked")
				Iterator<String> it = obj.keys();
				while (it.hasNext()) {
					String key = it.next();
					JSONObject value = obj.getJSONObject(key);
					Match match = new Match();
					// JsonHelper.toJavaBean(match, value.toString());
					match.setBuyEndTime(value.getLong("buyEndTime"));
					match.setGid(value.getInt("gid"));
					match.setGuestName(value.getString("guestName"));
					match.setGuestTeamURL(value.getString("guestTeamURL"));
					match.setHid(value.getInt("hid"));
					match.setHint(value.getString("hint"));
					match.setHostName(value.getString("hostName"));
					match.setHostRankInfo(value.getString("hostRankInfo"));
					match.setHostTeamURL(value.getString("hostTeamURL"));
					match.setMyFocusOn(value.getBoolean("isMyFocusOn"));
					match.setLeagueColor(value.getString("leagueColor"));
					match.setLeagueName(value.getString("leagueName"));
					match.setLeagueURL(value.getString("leagueURL"));
					match.setLid(value.getInt("lid"));
					match.setMatchCode(value.getString("matchCode"));
					match.setMatchDate(value.getLong("matchDate"));
					match.setMid(value.getInt("mid"));
					match.setMixBidCounts(new JSONArray(value
							.getString("mixBidCounts")));
					match.setMixBidScore(value.getString("mixBidScore"));
					match.setMixHotCounts(new JSONArray(value
							.getString("mixHotCounts")));
					match.setMixStatus(new JSONArray(value.getString("mixStatus")));
					match.setSingleMixStatus(new JSONArray(value
							.getString("singleMixStatus")));
					match.setSpTabMix(new JSONArray(value.getString("spTabMix")));
					match.setStartTime(value.getLong("startTime"));
					match.setStatus(value.getInt("status"));
					match.setVisitRankInfo(value.getString("visitRankInfo"));
					match.setZxAnalysisURL(value.getString("zxAnalysisURL"));
					if (matchDao.findByPrimaryKey(match.getMatchCode()) != null)
						continue;
					matchDao.insert(match);
				}
			} catch (JSONException e) {
				e.printStackTrace();
			} catch (MatchDaoException e) {
				e.printStackTrace();
			}
		}
	}
	
}
