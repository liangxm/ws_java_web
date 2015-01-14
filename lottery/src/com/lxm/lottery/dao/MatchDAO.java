package com.lxm.lottery.dao;

import java.util.List;

import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.model.Match;

public interface MatchDAO {

	public int insert(Match match) throws MatchDaoException;

	public int update(String pk, Match match) throws MatchDaoException;
	
	public int delete(String pk) throws MatchDaoException;
	
	public List<Match> findAll() throws MatchDaoException;
	
	public List<Match> findDaliyMatchs() throws MatchDaoException;
	
	public Match findByPrimaryKey(String pk) throws MatchDaoException;
}
