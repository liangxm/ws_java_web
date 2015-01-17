package com.lxm.lottery.dao;

import java.util.List;

import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.model.Match;

public interface MatchDAO {

	public abstract int insert(Match paramMatch) throws MatchDaoException;

	public abstract int update(Match paramMatch) throws MatchDaoException;

	public abstract int delete(String paramString) throws MatchDaoException;

	public abstract List<Match> findAll() throws MatchDaoException;

	public abstract List<Match> findDaliyMatchs() throws MatchDaoException;

	public abstract List<Match> findYesterdayMatchs() throws MatchDaoException;
	
	public abstract List<Match> findMatchsByDate(String dateStr) throws MatchDaoException;

	public abstract Match findByPrimaryKey(String paramString)
			throws MatchDaoException;

	public abstract void release();
}
