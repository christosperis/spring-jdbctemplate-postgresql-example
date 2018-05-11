package com.codehub.spring.jdbcpostgresql.service.impl;

import com.codehub.spring.jdbcpostgresql.dao.CustomerDao;
import com.codehub.spring.jdbcpostgresql.dao.CustomerSimpleJdbcDao;
import com.codehub.spring.jdbcpostgresql.model.Customer;
import com.codehub.spring.jdbcpostgresql.service.CustomerSimpleJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CustomerSimpleJdbcServiceImpl implements CustomerSimpleJdbcService {

    @Autowired
    CustomerSimpleJdbcDao customerSimpleJdbcDao;

    @Override
    public void insert(Customer cus) {
        customerSimpleJdbcDao.insert(cus);
    }

    @Override
    public void getCustomerById(long cust_id) {
        Customer cust = customerSimpleJdbcDao.findById(cust_id);
        System.out.println(cust);
    }
}
