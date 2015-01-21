package com.lxm.lottery.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import com.lxm.lottery.dao.MatchDAO;
import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.jdbc.DBConnection;
import com.lxm.lottery.model.Match;

public class MatchDAOImpl implements MatchDAO {

	private static final String INSERT = "insert into wangyi_match(buyEndTime,gid,guestName,guestTeamURL,hid,hint,hostName,hostRankInfo,hostTeamURL,isMyFocusOn,leagueColor,leagueName,leagueURL,lid,matchCode,matchDate,mid,mixBidCounts,mixBidScore,mixHotCounts,mixStatus,singleMixStatus,spTabMix,startTime,status,visitRankInfo,zxAnalysisURL) values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "update wangyi_match set hostRankInfo=?,lid=?,`mid`=?,mixBidCounts=?,mixBidScore=?,mixHotCounts=?,mixStatus=?,singleMixStatus=?,spTabMix=?,status=?,visitRankInfo=? where matchCode = ?";
	private static final String DELETE = "delete from wangyi_match where matchCode = ";
	private static final String SELECT_ALL = "select * from wangyi_match";
	private static final String SELECT_DALIY = "select * from wangyi_match where date_format(LEFT(matchCode,8),'%Y%m%d')=date_format(current_date,'%Y%m%d')";
	private static final String SELECT_PRE_DAY = "select * from wangyi_match where DATE_ADD(date_format(LEFT(matchCode,8),'%Y%m%d'),INTERVAL 0 DAY) = DATE_ADD(date_format(current_date,'%Y%m%d'),INTERVAL -1 DAY)";
	private static final String SELECT_BY_PK = "select * from wangyi_match where matchCode = ";
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;

	public int insert(Match match) throws MatchDaoException {
		int result = -1;
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			this.ps = this.conn.prepareStatement(INSERT);
			this.conn.setAutoCommit(false);
			this.ps.setLong(1, match.getBuyEndTime().longValue());
			this.ps.setInt(2, match.getGid());
			this.ps.setString(3, match.getGuestName());
			this.ps.setString(4, match.getGuestTeamURL());
			this.ps.setInt(5, match.getHid());
			this.ps.setString(6, match.getHint());
			this.ps.setString(7, match.getHostName());
			this.ps.setString(8, match.getHostRankInfo());
			this.ps.setString(9, match.getHostTeamURL());
			this.ps.setBoolean(10, match.isMyFocusOn());
			this.ps.setString(11, match.getLeagueColor());
			this.ps.setString(12, match.getLeagueName());
			this.ps.setString(13, match.getLeagueURL());
			this.ps.setInt(14, match.getLid());
			this.ps.setString(15, match.getMatchCode());
			this.ps.setLong(16, match.getMatchDate().longValue());
			this.ps.setInt(17, match.getMid());
			this.ps.setString(18, match.getMixBidCounts().toString());
			this.ps.setString(19, match.getMixBidScore());
			this.ps.setString(20, match.getMixHotCounts().toString());
			this.ps.setString(21, match.getMixStatus().toString());
			this.ps.setString(22, match.getSingleMixStatus().toString());
			this.ps.setString(23, match.getSpTabMix().toString());
			this.ps.setLong(24, match.getStartTime().longValue());
			this.ps.setInt(25, match.getStatus());
			this.ps.setString(26, match.getVisitRankInfo());
			this.ps.setString(27, match.getZxAnalysisURL());
			result = this.ps.executeUpdate();
			this.conn.commit();
		} catch (SQLException e) {
			throw new MatchDaoException("get connection error! "
					+ e.getMessage());
		}
		return result;
	}

	public int update(Match match) throws MatchDaoException {
		int result = -1;
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			this.ps = this.conn.prepareStatement(UPDATE);
			this.conn.setAutoCommit(false);
			this.ps.setString(1, match.getHostRankInfo());
			this.ps.setInt(2, match.getLid());
			this.ps.setInt(3, match.getMid());
			this.ps.setString(4, match.getMixBidCounts().toString());
			this.ps.setString(5, match.getMixBidScore());
			this.ps.setString(6, match.getMixHotCounts().toString());
			this.ps.setString(7, match.getMixStatus().toString());
			this.ps.setString(8, match.getSingleMixStatus().toString());
			this.ps.setString(9, match.getSpTabMix().toString());
			this.ps.setInt(10, match.getStatus());
			this.ps.setString(11, match.getVisitRankInfo());
			this.ps.setString(12, match.getMatchCode());
			result = this.ps.executeUpdate();
			this.conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public int delete(String pk) throws MatchDaoException {
		int result = -1;
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			result = this.conn.createStatement().executeUpdate(
					DELETE + "'" + pk + "'");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public List<Match> findAll() throws MatchDaoException {
		List<Match> matchs = new ArrayList<Match>();
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			this.rs = this.conn.createStatement().executeQuery(SELECT_ALL);
			if (this.rs != null)
				try {
					while (this.rs.next()) {
						Match match = new Match();
						match.setBuyEndTime(Long.valueOf(this.rs
								.getLong("buyEndTime")));
						match.setGid(this.rs.getInt("gid"));
						match.setGuestName(this.rs.getString("guestName"));
						match.setGuestTeamURL(this.rs.getString("guestTeamURL"));
						match.setHid(this.rs.getInt("hid"));
						match.setHint(this.rs.getString("hint"));
						match.setHostName(this.rs.getString("hostName"));
						match.setHostRankInfo(this.rs.getString("hostRankInfo"));
						match.setHostTeamURL(this.rs.getString("hostTeamURL"));
						match.setMyFocusOn(this.rs.getBoolean("isMyFocusOn"));
						match.setLeagueColor(this.rs.getString("leagueColor"));
						match.setLeagueName(this.rs.getString("leagueName"));
						match.setLeagueURL(this.rs.getString("leagueURL"));
						match.setLid(this.rs.getInt("lid"));
						match.setMatchCode(this.rs.getString("matchCode"));
						match.setMatchDate(Long.valueOf(this.rs
								.getLong("matchDate")));
						match.setMid(this.rs.getInt("mid"));
						match.setMixBidCounts(new JSONArray(this.rs
								.getString("mixBidCounts")));
						match.setMixBidScore(this.rs.getString("mixBidScore"));
						match.setMixHotCounts(new JSONArray(this.rs
								.getString("mixHotCounts")));
						match.setMixStatus(new JSONArray(this.rs
								.getString("mixStatus")));
						match.setSingleMixStatus(new JSONArray(this.rs
								.getString("singleMixStatus")));
						match.setSpTabMix(new JSONArray(this.rs
								.getString("spTabMix")));
						match.setStartTime(Long.valueOf(this.rs
								.getLong("startTime")));
						match.setStatus(this.rs.getInt("status"));
						match.setVisitRankInfo(this.rs
								.getString("visitRankInfo"));
						match.setZxAnalysisURL(this.rs
								.getString("zxAnalysisURL"));
						matchs.add(match);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return matchs;
	}

	public Match findByPrimaryKey(String pk) throws MatchDaoException {
		Match match = null;
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			this.rs = this.conn.createStatement().executeQuery(
					SELECT_BY_PK + "'" + pk + "'");
			if (this.rs != null)
				try {
					while (this.rs.next()) {
						match = new Match();
						match.setBuyEndTime(Long.valueOf(this.rs
								.getLong("buyEndTime")));
						match.setGid(this.rs.getInt("gid"));
						match.setGuestName(this.rs.getString("guestName"));
						match.setGuestTeamURL(this.rs.getString("guestTeamURL"));
						match.setHid(this.rs.getInt("hid"));
						match.setHint(this.rs.getString("hint"));
						match.setHostName(this.rs.getString("hostName"));
						match.setHostRankInfo(this.rs.getString("hostRankInfo"));
						match.setHostTeamURL(this.rs.getString("hostTeamURL"));
						match.setMyFocusOn(this.rs.getBoolean("isMyFocusOn"));
						match.setLeagueColor(this.rs.getString("leagueColor"));
						match.setLeagueName(this.rs.getString("leagueName"));
						match.setLeagueURL(this.rs.getString("leagueURL"));
						match.setLid(this.rs.getInt("lid"));
						match.setMatchCode(this.rs.getString("matchCode"));
						match.setMatchDate(Long.valueOf(this.rs
								.getLong("matchDate")));
						match.setMid(this.rs.getInt("mid"));
						match.setMixBidCounts(new JSONArray(this.rs
								.getString("mixBidCounts")));
						match.setMixBidScore(this.rs.getString("mixBidScore"));
						match.setMixHotCounts(new JSONArray(this.rs
								.getString("mixHotCounts")));
						match.setMixStatus(new JSONArray(this.rs
								.getString("mixStatus")));
						match.setSingleMixStatus(new JSONArray(this.rs
								.getString("singleMixStatus")));
						match.setSpTabMix(new JSONArray(this.rs
								.getString("spTabMix")));
						match.setStartTime(Long.valueOf(this.rs
								.getLong("startTime")));
						match.setStatus(this.rs.getInt("status"));
						match.setVisitRankInfo(this.rs
								.getString("visitRankInfo"));
						match.setZxAnalysisURL(this.rs
								.getString("zxAnalysisURL"));
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return match;
	}

	public List<Match> findDaliyMatchs() throws MatchDaoException {
		List<Match> matchs = new ArrayList<Match>();
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			this.rs = this.conn.createStatement().executeQuery(SELECT_DALIY);
			if (this.rs != null)
				try {
					while (this.rs.next()) {
						Match match = new Match();
						match.setBuyEndTime(Long.valueOf(this.rs
								.getLong("buyEndTime")));
						match.setGid(this.rs.getInt("gid"));
						match.setGuestName(this.rs.getString("guestName"));
						match.setGuestTeamURL(this.rs.getString("guestTeamURL"));
						match.setHid(this.rs.getInt("hid"));
						match.setHint(this.rs.getString("hint"));
						match.setHostName(this.rs.getString("hostName"));
						match.setHostRankInfo(this.rs.getString("hostRankInfo"));
						match.setHostTeamURL(this.rs.getString("hostTeamURL"));
						match.setMyFocusOn(this.rs.getBoolean("isMyFocusOn"));
						match.setLeagueColor(this.rs.getString("leagueColor"));
						match.setLeagueName(this.rs.getString("leagueName"));
						match.setLeagueURL(this.rs.getString("leagueURL"));
						match.setLid(this.rs.getInt("lid"));
						match.setMatchCode(this.rs.getString("matchCode"));
						match.setMatchDate(Long.valueOf(this.rs
								.getLong("matchDate")));
						match.setMid(this.rs.getInt("mid"));
						match.setMixBidCounts(new JSONArray(this.rs
								.getString("mixBidCounts")));
						match.setMixBidScore(this.rs.getString("mixBidScore"));
						match.setMixHotCounts(new JSONArray(this.rs
								.getString("mixHotCounts")));
						match.setMixStatus(new JSONArray(this.rs
								.getString("mixStatus")));
						match.setSingleMixStatus(new JSONArray(this.rs
								.getString("singleMixStatus")));
						match.setSpTabMix(new JSONArray(this.rs
								.getString("spTabMix")));
						match.setStartTime(Long.valueOf(this.rs
								.getLong("startTime")));
						match.setStatus(this.rs.getInt("status"));
						match.setVisitRankInfo(this.rs
								.getString("visitRankInfo"));
						match.setZxAnalysisURL(this.rs
								.getString("zxAnalysisURL"));
						matchs.add(match);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return matchs;
	}

	public List<Match> findYesterdayMatchs() throws MatchDaoException {
		List<Match> matchs = new ArrayList<Match>();
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			this.rs = this.conn.createStatement().executeQuery(SELECT_PRE_DAY);
			if (this.rs != null)
				try {
					while (this.rs.next()) {
						Match match = new Match();
						match.setBuyEndTime(Long.valueOf(this.rs
								.getLong("buyEndTime")));
						match.setGid(this.rs.getInt("gid"));
						match.setGuestName(this.rs.getString("guestName"));
						match.setGuestTeamURL(this.rs.getString("guestTeamURL"));
						match.setHid(this.rs.getInt("hid"));
						match.setHint(this.rs.getString("hint"));
						match.setHostName(this.rs.getString("hostName"));
						match.setHostRankInfo(this.rs.getString("hostRankInfo"));
						match.setHostTeamURL(this.rs.getString("hostTeamURL"));
						match.setMyFocusOn(this.rs.getBoolean("isMyFocusOn"));
						match.setLeagueColor(this.rs.getString("leagueColor"));
						match.setLeagueName(this.rs.getString("leagueName"));
						match.setLeagueURL(this.rs.getString("leagueURL"));
						match.setLid(this.rs.getInt("lid"));
						match.setMatchCode(this.rs.getString("matchCode"));
						match.setMatchDate(Long.valueOf(this.rs
								.getLong("matchDate")));
						match.setMid(this.rs.getInt("mid"));
						match.setMixBidCounts(new JSONArray(this.rs
								.getString("mixBidCounts")));
						match.setMixBidScore(this.rs.getString("mixBidScore"));
						match.setMixHotCounts(new JSONArray(this.rs
								.getString("mixHotCounts")));
						match.setMixStatus(new JSONArray(this.rs
								.getString("mixStatus")));
						match.setSingleMixStatus(new JSONArray(this.rs
								.getString("singleMixStatus")));
						match.setSpTabMix(new JSONArray(this.rs
								.getString("spTabMix")));
						match.setStartTime(Long.valueOf(this.rs
								.getLong("startTime")));
						match.setStatus(this.rs.getInt("status"));
						match.setVisitRankInfo(this.rs
								.getString("visitRankInfo"));
						match.setZxAnalysisURL(this.rs
								.getString("zxAnalysisURL"));
						matchs.add(match);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}

		return matchs;
	}

	public List<Match> findMatchsByDate(String dateStr)
			throws MatchDaoException {
		List<Match> matchs = new ArrayList<Match>();
		try {
			if (this.conn == null || this.conn.isClosed())
				this.conn = DBConnection.getConnection();
			this.rs = this.conn
					.createStatement()
					.executeQuery(
							"select * from wangyi_match where date_format(LEFT(matchCode,8),'%Y%m%d')=date_format('"
									+ dateStr + "','%Y%m%d')");
			if (this.rs != null)
				try {
					while (this.rs.next()) {
						Match match = new Match();
						match.setBuyEndTime(Long.valueOf(this.rs
								.getLong("buyEndTime")));
						match.setGid(this.rs.getInt("gid"));
						match.setGuestName(this.rs.getString("guestName"));
						match.setGuestTeamURL(this.rs.getString("guestTeamURL"));
						match.setHid(this.rs.getInt("hid"));
						match.setHint(this.rs.getString("hint"));
						match.setHostName(this.rs.getString("hostName"));
						match.setHostRankInfo(this.rs.getString("hostRankInfo"));
						match.setHostTeamURL(this.rs.getString("hostTeamURL"));
						match.setMyFocusOn(this.rs.getBoolean("isMyFocusOn"));
						match.setLeagueColor(this.rs.getString("leagueColor"));
						match.setLeagueName(this.rs.getString("leagueName"));
						match.setLeagueURL(this.rs.getString("leagueURL"));
						match.setLid(this.rs.getInt("lid"));
						match.setMatchCode(this.rs.getString("matchCode"));
						match.setMatchDate(Long.valueOf(this.rs
								.getLong("matchDate")));
						match.setMid(this.rs.getInt("mid"));
						match.setMixBidCounts(new JSONArray(this.rs
								.getString("mixBidCounts")));
						match.setMixBidScore(this.rs.getString("mixBidScore"));
						match.setMixHotCounts(new JSONArray(this.rs
								.getString("mixHotCounts")));
						match.setMixStatus(new JSONArray(this.rs
								.getString("mixStatus")));
						match.setSingleMixStatus(new JSONArray(this.rs
								.getString("singleMixStatus")));
						match.setSpTabMix(new JSONArray(this.rs
								.getString("spTabMix")));
						match.setStartTime(Long.valueOf(this.rs
								.getLong("startTime")));
						match.setStatus(this.rs.getInt("status"));
						match.setVisitRankInfo(this.rs
								.getString("visitRankInfo"));
						match.setZxAnalysisURL(this.rs
								.getString("zxAnalysisURL"));
						matchs.add(match);
					}
				} catch (SQLException e) {
					e.printStackTrace();
				} catch (JSONException e) {
					e.printStackTrace();
				}
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		return matchs;
	}

	public void release() {
		DBConnection.close(this.conn, this.ps, this.rs);
	}
}
