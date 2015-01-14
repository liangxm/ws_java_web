package com.lxm.lottery.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.lxm.lottery.dao.MatchDAO;
import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.jdbc.DataSource;
import com.lxm.lottery.model.Match;

public class MatchDAOImpl implements MatchDAO {
	
	private static final String INSERT = "";
	private static final String UPDATE = "";
	private static final String DELETE = "";
	private static final String SELECT_ALL = "";
	private static final String SELECT_BY_PK = "";

	@Override
	public int insert(Match match) throws MatchDaoException {
		return -1;
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
		result = DataSource.getInstance().update(DELETE);
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
					match.setBuyEndTime(rs.getString(""));
					matchs.add(match);
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DataSource.close(rs);
		return matchs;
	}

	@Override
	public Match findByPrimaryKey(String pk) throws MatchDaoException {
		Match match = null;
		ResultSet rs = DataSource.getInstance().query(SELECT_BY_PK);
		if (rs != null) {
			try {
				while (rs.next()) {
					match = new Match();
					match.setBuyEndTime(rs.getString(""));
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		DataSource.close(rs);
		return match;
	}

}
