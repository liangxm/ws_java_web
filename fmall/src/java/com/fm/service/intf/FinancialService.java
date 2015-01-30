package com.fm.service.intf;

import java.util.List;

import com.fm.dao.intf.comn.PageResult;
import com.fm.domain.pojo.Financial;

/**
 * 理财产品service层接口
 * @author lxm
 * @date 2013-10-12 22:40:06 
 */
public interface FinancialService {

    /** 
     * 查询整表总记录数 
     * @return 整表总记录数 
     */  
    public abstract int count();
    
    /**
     * 插入一条记录
     */
    public abstract void insert(Financial entity); 
    
    /**
     * 更新一条记录
     * @param param
     * @return
     */
    public abstract int update(Object param); 
    
    /**
     * 通过主键获取一条记录
     * @param primaryKey
     * @return
     */
    public abstract Financial get(String primaryKey);
    
    /**
     * 通过主键删除一条记录
     * @param primaryKey
     * @return
     */
    public abstract int delete(String primaryKey);
    
    /**
     * 获取全部记录
     * @return 全部记录实体对象的List
     */
    public abstract List<Financial> select();
    
    
    /** 
     * 按条件查询记录，并处理成分页结果 
     * @param param 查询条件参数，包括WHERE条件、分页条件、排序条件 
     * @return PaginationResult对象，包括（符合条件的）总记录数、页实体对象List等 
     */ 
    public abstract PageResult<Financial> selectPagination(Object param);
}
