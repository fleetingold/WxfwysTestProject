package com.wxfwys.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
@Getter
@AllArgsConstructor
public class PersonEntity {
    @PrimaryKey
    private final int id;
    private final String name;
    private final int age;
}
