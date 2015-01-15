package com.lxm.lottery.dao;
import java.sql.SQLException;

/**
 * DAO (J2EE Pattern)
 *
 * @param object type
 */
public abstract class DAO<T> {
    
    public abstract T find(T obj) throws SQLException;
    
    public abstract T create(T obj) throws SQLException;

    public abstract void update(T obj) throws SQLException;

    public abstract void delete(T obj) throws SQLException;
}
