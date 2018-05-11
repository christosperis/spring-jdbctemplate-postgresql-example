package com.codehub.spring.jdbcpostgresql.dao;

import com.codehub.spring.jdbcpostgresql.model.Customer;

public interface CustomerSimpleJdbcDao {

    public void insert(Customer customer);
    public Customer findById(long id);

}
