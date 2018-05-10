package com.codehub.spring.jdbcpostgresql.dao;

import java.util.List;

import com.codehub.spring.jdbcpostgresql.model.Customer;

public interface CustomerDao {
	void insert(Customer cus);
	void insertBatch(List<Customer> customers);
	List<Customer> loadAllCustomer();
	Customer findCustomerById(long cust_id);
	String findNameById(long cust_id);
	int getTotalNumberCustomer();
}
