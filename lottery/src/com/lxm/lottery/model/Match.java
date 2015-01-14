package com.lxm.lottery.model;

import org.json.JSONArray;

public class Match {

	private Long buyEndTime;
	private int gid;
	private String guestName;
	private String guestTeamURL;
	private int hid;
	private String hint;
	private String hostName;
	private String hostRankInfo;
	private String hostTeamURL;
	private boolean isMyFocusOn;
	private String leagueColor;
	private String leagueName;
	private String leagueURL;
	private int lid;
	private String matchCode;
	private Long matchDate;
	private int mid;
	private JSONArray mixBidCounts;
	private String mixBidScore;
	private JSONArray mixHotCounts;
	private JSONArray mixStatus;
	private JSONArray singleMixStatus;
	private JSONArray spTabMix;
	private Long startTime;
	private int status;
	private String visitRankInfo;
	private String zxAnalysisURL;

	public Long getBuyEndTime() {
		return buyEndTime;
	}

	public void setBuyEndTime(Long buyEndTime) {
		this.buyEndTime = buyEndTime;
	}

	public int getGid() {
		return gid;
	}

	public void setGid(int gid) {
		this.gid = gid;
	}

	public String getGuestName() {
		return guestName;
	}

	public void setGuestName(String guestName) {
		this.guestName = guestName;
	}

	public String getGuestTeamURL() {
		return guestTeamURL;
	}

	public void setGuestTeamURL(String guestTeamURL) {
		this.guestTeamURL = guestTeamURL;
	}

	public int getHid() {
		return hid;
	}

	public void setHid(int hid) {
		this.hid = hid;
	}

	public String getHint() {
		return hint;
	}

	public void setHint(String hint) {
		this.hint = hint;
	}

	public String getHostName() {
		return hostName;
	}

	public void setHostName(String hostName) {
		this.hostName = hostName;
	}

	public String getHostRankInfo() {
		return hostRankInfo;
	}

	public void setHostRankInfo(String hostRankInfo) {
		this.hostRankInfo = hostRankInfo;
	}

	public String getHostTeamURL() {
		return hostTeamURL;
	}

	public void setHostTeamURL(String hostTeamURL) {
		this.hostTeamURL = hostTeamURL;
	}

	public boolean isMyFocusOn() {
		return isMyFocusOn;
	}

	public void setMyFocusOn(boolean isMyFocusOn) {
		this.isMyFocusOn = isMyFocusOn;
	}

	public String getLeagueColor() {
		return leagueColor;
	}

	public void setLeagueColor(String leagueColor) {
		this.leagueColor = leagueColor;
	}

	public String getLeagueName() {
		return leagueName;
	}

	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}

	public String getLeagueURL() {
		return leagueURL;
	}

	public void setLeagueURL(String leagueURL) {
		this.leagueURL = leagueURL;
	}

	public int getLid() {
		return lid;
	}

	public void setLid(int lid) {
		this.lid = lid;
	}

	public String getMatchCode() {
		return matchCode;
	}

	public void setMatchCode(String matchCode) {
		this.matchCode = matchCode;
	}

	public Long getMatchDate() {
		return matchDate;
	}

	public void setMatchDate(Long matchDate) {
		this.matchDate = matchDate;
	}

	public int getMid() {
		return mid;
	}

	public void setMid(int mid) {
		this.mid = mid;
	}

	public JSONArray getMixBidCounts() {
		return mixBidCounts;
	}

	public void setMixBidCounts(JSONArray mixBidCounts) {
		this.mixBidCounts = mixBidCounts;
	}

	public String getMixBidScore() {
		return mixBidScore;
	}

	public void setMixBidScore(String mixBidScore) {
		this.mixBidScore = mixBidScore;
	}

	public JSONArray getMixHotCounts() {
		return mixHotCounts;
	}

	public void setMixHotCounts(JSONArray mixHotCounts) {
		this.mixHotCounts = mixHotCounts;
	}

	public JSONArray getMixStatus() {
		return mixStatus;
	}

	public void setMixStatus(JSONArray mixStatus) {
		this.mixStatus = mixStatus;
	}

	public JSONArray getSingleMixStatus() {
		return singleMixStatus;
	}

	public void setSingleMixStatus(JSONArray singleMixStatus) {
		this.singleMixStatus = singleMixStatus;
	}

	public JSONArray getSpTabMix() {
		return spTabMix;
	}

	public void setSpTabMix(JSONArray spTabMix) {
		this.spTabMix = spTabMix;
	}

	public Long getStartTime() {
		return startTime;
	}

	public void setStartTime(Long startTime) {
		this.startTime = startTime;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public String getVisitRankInfo() {
		return visitRankInfo;
	}

	public void setVisitRankInfo(String visitRankInfo) {
		this.visitRankInfo = visitRankInfo;
	}

	public String getZxAnalysisURL() {
		return zxAnalysisURL;
	}

	public void setZxAnalysisURL(String zxAnalysisURL) {
		this.zxAnalysisURL = zxAnalysisURL;
	}

}
