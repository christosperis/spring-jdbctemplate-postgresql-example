package com.codehub.spring.jdbcpostgresql.service;

import com.codehub.spring.jdbcpostgresql.model.Customer;

public interface CustomerSimpleJdbcService {

    void insert(Customer cust);
    void getCustomerById(long cust_id);

}
