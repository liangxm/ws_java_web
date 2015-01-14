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
import com.lxm.lottery.jdbc.ConnectionPool;
import com.lxm.lottery.jdbc.DataSource;
import com.lxm.lottery.model.Match;

public class MatchDAOImpl implements MatchDAO {

	private static final String INSERT = "insert into wangyi_match(buyEndTime,gid,guestName,guestTeamURL,hid,hint,hostName,hostRankInfo,hostTeamURL,isMyFocusOn,leagueColor,leagueName,leagueURL,lid,matchCode,matchDate,mid,mixBidCounts,mixBidScore,mixHotCounts,mixStatus,singleMixStatus,spTabMix,startTime,status,visitRankInfo,zxAnalysisURL)"
			+ " values (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	private static final String UPDATE = "";
	private static final String DELETE = "delete from wangyi_match where matchCode = ";
	private static final String SELECT_ALL = "select * from wangyi_match";
	private static final String SELECT_BY_PK = "select * from wangyi_match where matchCode = ";

	@Override
	public int insert(Match match) throws MatchDaoException {
		int result = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		try {
			conn = ConnectionPool.getInstance().getConnection();
			ps = conn.prepareStatement(INSERT);
			conn.setAutoCommit(false);
			ps.setLong(1, match.getBuyEndTime());
			ps.setInt(2, match.getGid());
			ps.setString(3, match.getGuestName());
			ps.setString(4, match.getGuestTeamURL());
			ps.setInt(5, match.getHid());
			ps.setString(6, match.getHint());
			ps.setString(7, match.getHostName());
			ps.setString(8, match.getHostRankInfo());
			ps.setString(9, match.getHostTeamURL());
			ps.setBoolean(10, match.isMyFocusOn());
			ps.setString(11, match.getLeagueColor());
			ps.setString(12, match.getLeagueName());
			ps.setString(13, match.getLeagueURL());
			ps.setInt(14, match.getLid());
			ps.setString(15, match.getMatchCode());
			ps.setLong(16, match.getMatchDate());
			ps.setInt(17, match.getMid());
			ps.setString(18, match.getMixBidCounts().toString());
			ps.setString(19, match.getMixBidScore());
			ps.setString(20, match.getMixHotCounts().toString());
			ps.setString(21, match.getMixStatus().toString());
			ps.setString(22, match.getSingleMixStatus().toString());
			ps.setString(23, match.getSpTabMix().toString());
			ps.setLong(24, match.getStartTime());
			ps.setInt(25, match.getStatus());
			ps.setString(26, match.getVisitRankInfo());
			ps.setString(27, match.getZxAnalysisURL());
			result = ps.executeUpdate();
			conn.commit(); 
		} catch (SQLException e) {
			throw new MatchDaoException("get connection error! "+e.getMessage());
		} finally {
			DataSource.close(conn, ps, null);
		}
		return result;
	}

	@Override
	public int update(String pk, Match match) throws MatchDaoException {
		int result = -1;
		result = DataSource.getInstance().update(UPDATE);
		return result;
	}

	@Override
	public int delete(String pk) throws MatchDaoException {
		int result = -1;
		result = DataSource.getInstance().update(DELETE+"'"+pk+"'");
		return result;
	}

	@Override
	public List<Match> findAll() throws MatchDaoException {
		List<Match> matchs = new ArrayList<Match>();
		ResultSet rs = DataSource.getInstance().query(SELECT_ALL);
		if (rs != null) {
			try {
				while (rs.next()) {
					Match match = new Match();
					match.setBuyEndTime(rs.getLong("buyEndTime"));
					match.setGid(rs.getInt("gid"));
					match.setGuestName(rs.getString("guestName"));
					match.setGuestTeamURL(rs.getString("guestTeamURL"));
					match.setHid(rs.getInt("hid"));
					match.setHint(rs.getString("hint"));
					match.setHostName(rs.getString("hostName"));
					match.setHostRankInfo(rs.getString("hostRankInfo"));
					match.setHostTeamURL(rs.getString("hostTeamURL"));
					match.setMyFocusOn(rs.getBoolean("isMyFocusOn"));
					match.setLeagueColor(rs.getString("leagueColor"));
					match.setLeagueName(rs.getString("leagueName"));
					match.setLeagueURL(rs.getString("leagueURL"));
					match.setLid(rs.getInt("lid"));
					match.setMatchCode(rs.getString("matchCode"));
					match.setMatchDate(rs.getLong("matchDate"));
					match.setMid(rs.getInt("mid"));
					match.setMixBidCounts(new JSONArray(rs
							.getString("mixBidCounts")));
					match.setMixBidScore(rs.getString("mixBidScore"));
					match.setMixHotCounts(new JSONArray(rs.getString("mixHotCounts")));
					match.setMixStatus(new JSONArray(rs.getString("mixStatus")));
					match.setSingleMixStatus(new JSONArray(rs.getString("singleMixStatus")));
					match.setSpTabMix(new JSONArray(rs.getString("spTabMix")));
					match.setStartTime(rs.getLong("startTime"));
					match.setStatus(rs.getInt("status"));
					match.setVisitRankInfo(rs.getString("visitRankInfo"));
					match.setZxAnalysisURL(rs.getString("zxAnalysisURL"));
					matchs.add(match);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		DataSource.close(null, null, rs);
		return matchs;
	}

	@Override
	public Match findByPrimaryKey(String pk) throws MatchDaoException {
		Match match = null;
		ResultSet rs = DataSource.getInstance().query(SELECT_BY_PK+"'"+pk+"'");
		if (rs != null) {
			try {
				while (rs.next()) {
					match = new Match();
					match.setBuyEndTime(rs.getLong("buyEndTime"));
					match.setGid(rs.getInt("gid"));
					match.setGuestName(rs.getString("guestName"));
					match.setGuestTeamURL(rs.getString("guestTeamURL"));
					match.setHid(rs.getInt("hid"));
					match.setHint(rs.getString("hint"));
					match.setHostName(rs.getString("hostName"));
					match.setHostRankInfo(rs.getString("hostRankInfo"));
					match.setHostTeamURL(rs.getString("hostTeamURL"));
					match.setMyFocusOn(rs.getBoolean("isMyFocusOn"));
					match.setLeagueColor(rs.getString("leagueColor"));
					match.setLeagueName(rs.getString("leagueName"));
					match.setLeagueURL(rs.getString("leagueURL"));
					match.setLid(rs.getInt("lid"));
					match.setMatchCode(rs.getString("matchCode"));
					match.setMatchDate(rs.getLong("matchDate"));
					match.setMid(rs.getInt("mid"));
					match.setMixBidCounts(new JSONArray(rs
							.getString("mixBidCounts")));
					match.setMixBidScore(rs.getString("mixBidScore"));
					match.setMixHotCounts(new JSONArray(rs.getString("mixHotCounts")));
					match.setMixStatus(new JSONArray(rs.getString("mixStatus")));
					match.setSingleMixStatus(new JSONArray(rs.getString("singleMixStatus")));
					match.setSpTabMix(new JSONArray(rs.getString("spTabMix")));
					match.setStartTime(rs.getLong("startTime"));
					match.setStatus(rs.getInt("status"));
					match.setVisitRankInfo(rs.getString("visitRankInfo"));
					match.setZxAnalysisURL(rs.getString("zxAnalysisURL"));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		DataSource.close(null, null, rs);
		return match;
	}

}
