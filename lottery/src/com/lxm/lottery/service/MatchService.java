package com.lxm.lottery.service;

import java.util.List;

import org.json.JSONObject;

import com.lxm.lottery.model.Match;

public interface MatchService {

	  public abstract int addMatch(JSONObject paramJSONObject);

	  public abstract int updateMatch(Match paramMatch);

	  public abstract int deleteMatch(String paramString);

	  public abstract List<Match> findAll();

	  public abstract List<Match> findDaliyMatchs();

	  public abstract Match findByPrimaryKey(String paramString);

	  public abstract List<Match> getDaliyMatchList();

	  public abstract List<Match> getYesterdayMatchList();
	  
	  public abstract List<Match> getMatchListByDate(String dateStr);
	  
	  public abstract List<Match> getDaliyRecommend(String dateStr);
}
