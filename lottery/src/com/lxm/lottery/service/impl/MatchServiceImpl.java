package com.lxm.lottery.service.impl;

import java.util.List;

import com.lxm.lottery.dao.MatchDAO;
import com.lxm.lottery.dao.impl.MatchDAOImpl;
import com.lxm.lottery.exception.MatchDaoException;
import com.lxm.lottery.model.Match;
import com.lxm.lottery.service.MatchService;

public class MatchServiceImpl implements MatchService {
	
	private MatchDAO matchDao;
	
	public MatchServiceImpl(){
		matchDao = new MatchDAOImpl();
	}

	@Override
	public List<Match> getDaliyMatchList() {
		List<Match> list = null;
		try {
			list = matchDao.findDaliyMatchs();
		} catch (MatchDaoException e) {
			e.printStackTrace();
		}
		return list;
	}

}
