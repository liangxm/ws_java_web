package com.lxm.lottery.extractor.test;

import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.lxm.lottery.dao.MatchDAO;
import com.lxm.lottery.dao.impl.MatchDAOImpl;
import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.html.HttpRequest;
import com.lxm.lottery.model.Match;
import com.lxm.lottery.service.MatchService;
import com.lxm.lottery.service.impl.MatchServiceImpl;
import com.lxm.lottery.util.StringUtils;

public class JsonTest {

	@Test
	public void test1(){
		try {  
			String loadData=HttpRequest.sendGet("http://caipiao.163.com/order/preBet_jclqNewMixAllAjax.html", "cache=1420787380503&betDate=2015-01-21");
			JSONObject jo = new JSONObject(loadData);
			//WYData data = new WYData();
			//JsonHelper.toJavaBean(data, jo.toString());
			//JSONObject obj = data.getMatchList();
			JSONObject obj = jo.getJSONObject("matchList");
			MatchDAO matchDao = new MatchDAOImpl();
            @SuppressWarnings("unchecked")
			Iterator<String> it = obj.keys();  
            while (it.hasNext()) {  
                String key = it.next();  
                JSONObject value = obj.getJSONObject(key);  
                Match match = new Match();
                //JsonHelper.toJavaBean(match, value.toString());
                match.setBuyEndTime(value.getLong("buyEndTime"));
				match.setGid(StringUtils.isInteger(value.getString("gid"))?value.getInt("gid"):0);
				match.setGuestName(value.getString("guestName"));
				match.setGuestTeamURL(value.getString("guestTeamURL"));
				match.setHid(StringUtils.isInteger(value.getString("hid"))?value.getInt("hid"):0);
				match.setHint(value.getString("hint"));
				match.setHostName(value.getString("hostName"));
				match.setHostRankInfo(value.getString("hostRankInfo"));
				match.setHostTeamURL(value.getString("hostTeamURL"));
				match.setMyFocusOn(value.getBoolean("isMyFocusOn"));
				match.setLeagueColor(value.getString("leagueColor"));
				match.setLeagueName(value.getString("leagueName"));
				match.setLeagueURL(value.getString("leagueURL"));
				match.setLid(StringUtils.isInteger(value.getString("lid"))?value.getInt("lid"):0);
				match.setMatchCode(value.getString("matchCode"));
				match.setMatchDate(value.getLong("matchDate"));
				match.setMid(StringUtils.isInteger(value.getString("mid"))?value.getInt("mid"):0);
				match.setMixBidCounts(new JSONArray(value
						.getString("mixBidCounts")));
				match.setMixBidScore(value.getString("mixBidScore"));
				match.setMixHotCounts(new JSONArray(value.getString("mixHotCounts")));
				match.setMixStatus(new JSONArray(value.getString("mixStatus")));
				match.setSingleMixStatus(new JSONArray(value.getString("singleMixStatus")));
				match.setSpTabMix(new JSONArray(value.getString("spTabMix")));
				match.setStartTime(value.getLong("startTime"));
				match.setStatus(value.getInt("status"));
				match.setVisitRankInfo(value.getString("visitRankInfo"));
				match.setZxAnalysisURL(value.getString("zxAnalysisURL"));
                if(matchDao.findByPrimaryKey(match.getMatchCode())!=null)
                	matchDao.update(match);
                else
                	matchDao.insert(match);
            }  
        } catch (JSONException e) {  
            e.printStackTrace();  
        } catch (MatchDaoException e) {
			e.printStackTrace();
		}  
	}
	
	@Test
	public void test2(){
		MatchService matchService = new MatchServiceImpl();
		List<Match> matchlist = matchService.getDaliyRecommend("2015-01-17");
		for(Match match:matchlist){
			System.out.println(match.getMatchCode());
		}
	}
}
