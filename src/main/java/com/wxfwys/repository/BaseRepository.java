package com.wxfwys.repository;

import org.springframework.data.cassandra.core.query.Query;

import java.io.Serializable;
import java.util.List;

public interface BaseRepository<T> {

    /**
     * 按主键查询
     * @param id
     * @return
     */
    T getById(Serializable id);

    /**
     * 按条件查询对象
     * @param query
     * @return
     */
    T getObj(Query query);

    /**
     * 按条件查询列表
     * @param query
     * @return
     */
    List<T> listObjs(Query query);
}
