package com.wxfwys.dao.impl;

import com.wxfwys.dao.PersonDao;
import com.wxfwys.entity.PersonEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.cassandra.core.CassandraTemplate;
import org.springframework.data.cassandra.core.query.Criteria;
import org.springframework.data.cassandra.core.query.Query;

public class PersonDaoImpl implements PersonDao {

    @Autowired
    protected CassandraTemplate cassandraTemplate;

    public void insert(PersonEntity personEntity) {
        cassandraTemplate.insert(personEntity);
    }

    public PersonEntity selectOneById(int id) {
        return cassandraTemplate.selectOneById(Query.query(Criteria.where("id").is(id)), PersonEntity.class);
    }
}
