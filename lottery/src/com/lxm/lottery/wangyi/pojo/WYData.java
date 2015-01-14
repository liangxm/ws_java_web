package com.lxm.lottery.wangyi.pojo;

import org.json.JSONObject;
/**
 * source data from 163
 * @author lianxiao
 *
 */
public class WYData {

	private String isDispJclqSingleFix;
	private String gameId;
	private String gameEn;
	private JSONObject matchList;

	public String getIsDispJclqSingleFix() {
		return isDispJclqSingleFix;
	}

	public void setIsDispJclqSingleFix(String isDispJclqSingleFix) {
		this.isDispJclqSingleFix = isDispJclqSingleFix;
	}

	public String getGameId() {
		return gameId;
	}

	public void setGameId(String gameId) {
		this.gameId = gameId;
	}

	public String getGameEn() {
		return gameEn;
	}

	public void setGameEn(String gameEn) {
		this.gameEn = gameEn;
	}

	public JSONObject getMatchList() {
		return matchList;
	}

	public void setMatchList(JSONObject matchList) {
		this.matchList = matchList;
	}

}
