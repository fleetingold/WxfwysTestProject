package com.wxfwys.dao;

import com.wxfwys.entity.PersonEntity;

import java.util.List;

public interface UserRepository extends CrudRepository<PersonEntity, Long> {

    long deleteByLastname(String lastname);

    List<PersonEntity> removeByLastname(String lastname);

    long countByLastname(String lastname);
}
