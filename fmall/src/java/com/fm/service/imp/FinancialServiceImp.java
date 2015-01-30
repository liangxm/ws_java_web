package com.fm.service.imp;

import java.util.List;

import com.fm.dao.intf.FinancialDao;
import com.fm.dao.intf.comn.PageResult;
import com.fm.domain.pojo.Financial;
import com.fm.service.intf.FinancialService;
/**
 * 理财产品Service层实现
 * @author lxm
 * @date 2013-10-12 22:43:40
 */
public class FinancialServiceImp implements FinancialService {
	
	FinancialDao financialDao;
	

	public FinancialDao getFinancialDao() {
		return financialDao;
	}

	public void setFinancialDao(FinancialDao financialDao) {
		this.financialDao = financialDao;
	}

	@Override
	public int count() {
		return this.financialDao.count();
	}

	@Override
	public void insert(Financial entity) {
		this.financialDao.insert(entity);
	}

	@Override
	public int update(Object param) {
		return financialDao.update(param);
	}

	@Override
	public Financial get(String primaryKey) {
		return financialDao.get(primaryKey);
	}

	@Override
	public int delete(String primaryKey) {
		return financialDao.delete(primaryKey);
	}

	@Override
	public List<Financial> select() {
		return financialDao.select();
	}

	@Override
	public PageResult<Financial> selectPagination(Object param) {
		return financialDao.selectPagination(param);
	}

}
