package com.lxm.lottery.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lxm.lottery.dao.MatchDAO;
import com.lxm.lottery.dao.impl.MatchDAOImpl;
import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.model.Match;
import com.lxm.lottery.service.MatchService;
import com.lxm.lottery.util.StringUtils;

public class MatchServiceImpl implements MatchService {

	private MatchDAO matchDao;

	public MatchServiceImpl() {
		this.matchDao = new MatchDAOImpl();
	}

	public List<Match> getDaliyMatchList() {
		List<Match> list = null;
		try {
			list = this.matchDao.findDaliyMatchs();
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return list;
	}

	public int addMatch(JSONObject jo) {
		int result = -1;
		try {
			JSONObject obj = jo.getJSONObject("matchList");

			@SuppressWarnings("unchecked")
			Iterator<String> it = obj.keys();
			while (it.hasNext()) {
				String key = (String) it.next();
				JSONObject value = obj.getJSONObject(key);
				Match match = new Match();
				match.setBuyEndTime(Long.valueOf(value.getLong("buyEndTime")));
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
				match.setMatchDate(Long.valueOf(value.getLong("matchDate")));
				match.setMid(StringUtils.isInteger(value.getString("mid"))?value.getInt("mid"):0);
				match.setMixBidCounts(new JSONArray(value
						.getString("mixBidCounts")));
				match.setMixBidScore(value.getString("mixBidScore"));
				match.setMixHotCounts(new JSONArray(value
						.getString("mixHotCounts")));
				match.setMixStatus(new JSONArray(value.getString("mixStatus")));
				match.setSingleMixStatus(new JSONArray(value
						.getString("singleMixStatus")));
				match.setSpTabMix(new JSONArray(value.getString("spTabMix")));
				match.setStartTime(Long.valueOf(value.getLong("startTime")));
				match.setStatus(value.getInt("status"));
				match.setVisitRankInfo(value.getString("visitRankInfo"));
				match.setZxAnalysisURL(value.getString("zxAnalysisURL"));
				if (this.matchDao.findByPrimaryKey(match.getMatchCode()) != null)
					result += this.matchDao.update(match);
				else
					result += this.matchDao.insert(match);
			}
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return result;
	}

	public int updateMatch(Match match) {
		int result = -1;
		try {
			result = this.matchDao.update(match);
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return result;
	}

	public int deleteMatch(String pk) {
		int result = -1;
		try {
			result = this.matchDao.delete(pk);
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return result;
	}

	public List<Match> findAll() {
		List<Match> matchList = null;
		try {
			matchList = this.matchDao.findAll();
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return matchList;
	}

	public List<Match> findDaliyMatchs() {
		List<Match> matchList = null;
		try {
			matchList = this.matchDao.findDaliyMatchs();
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return matchList;
	}

	public Match findByPrimaryKey(String pk) {
		Match match = null;
		try {
			match = this.matchDao.findByPrimaryKey(pk);
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return match;
	}

	public List<Match> getYesterdayMatchList() {
		List<Match> matchList = null;
		try {
			matchList = this.matchDao.findYesterdayMatchs();
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return matchList;
	}

	@Override
	public List<Match> getMatchListByDate(String dateStr) {
		List<Match> matchList = null;
		try {
			matchList = this.matchDao.findMatchsByDate(dateStr);
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return matchList;
	}

	@Override
	public List<Match> getDaliyRecommend(String dateStr) {
		List<Match> matchList = null;
		List<Match> recommendList = null;
		try {
			if(dateStr!=null)
				matchList = this.matchDao.findMatchsByDate(dateStr);
			else
				matchList = this.matchDao.findDaliyMatchs();
			recommendList = new ArrayList<Match>();
			for(Match match:matchList){
				JSONArray spTabMix = match.getSpTabMix();
				double guestRate1 = spTabMix.getJSONArray(0).getDouble(0);
				double hostRate1 = spTabMix.getJSONArray(0).getDouble(1);
				
				double guestRate2 = spTabMix.getJSONArray(2).getDouble(1);
				double hostRate2 = spTabMix.getJSONArray(2).getDouble(0);
				//主胜
				if(hostRate1<guestRate1 && hostRate2<guestRate2){
					match.setZxAnalysisURL("88888888");
					recommendList.add(match);
				}else if(hostRate1>guestRate1 && hostRate2>guestRate2){//主负
					match.setZxAnalysisURL("4444");
					recommendList.add(match);
				}
			}
		} catch (MatchDaoException e) {
			e.printStackTrace();
		} catch (JSONException e) {
			e.printStackTrace();
		} finally {
			this.matchDao.release();
		}
		return recommendList;
	}

}
