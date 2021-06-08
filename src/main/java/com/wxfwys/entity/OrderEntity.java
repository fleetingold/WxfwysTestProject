package com.wxfwys.entity;

import lombok.Data;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.Column;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

//import lombok.Getter;
//import lombok.Setter;
//import lombok.EqualsAndHashCode;
//@Getter
//@Setter
//@EqualsAndHashCode
@Data
@Table(value = "")
public class OrderEntity {
    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 0, name = "tenant_id")
    String tenantId;

    @PrimaryKeyColumn(type = PrimaryKeyType.PARTITIONED, ordinal = 1, name = "sequence_id")
    String sequenceId;

    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED, ordinal = 2, name = "order_id")
    Long orderId;

    @Column(value = "order_code")
    String orderCode;

    @Override
    public String toString() {
        return "OrderEntity { " +
                "tenantId: " + tenantId +
                ",sequenceId: " + sequenceId +
                ",orderId: " + orderId +
                ",orderCode: " + orderCode +
                " }";
    }
}
