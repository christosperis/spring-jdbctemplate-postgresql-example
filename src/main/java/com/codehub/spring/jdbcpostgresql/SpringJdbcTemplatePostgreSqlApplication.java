package com.codehub.spring.jdbcpostgresql;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import com.codehub.spring.jdbcpostgresql.service.CustomerService;
import com.codehub.spring.jdbcpostgresql.service.CustomerSimpleJdbcService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import com.codehub.spring.jdbcpostgresql.model.Customer;

@SpringBootApplication
@ComponentScan("com.codehub.spring.jdbcpostgresql")
public class SpringJdbcTemplatePostgreSqlApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("customerSimpleJdbcServiceImpl")
	CustomerSimpleJdbcService cusService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplatePostgreSqlApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {
		/*
		 * Create Customer
		 */
		Random r = new Random();

		// Customer 1
		Customer cus_1 = new Customer();
		Long cus_1_id = r.nextLong();
		cus_1.setCustId(cus_1_id);
		cus_1.setName("demoCustomer_1");
		cus_1.setAge(30);

		// Customer 2
		Customer cus_2 = new Customer();
		Long cus_2_id = r.nextLong();
		cus_2.setCustId(cus_2_id);
		cus_2.setName("demoCustomer_2");
		cus_2.setAge(30);

		// Customer 3
		Customer cus_3 = new Customer();
		Long cus_3_id = r.nextLong();
		cus_3.setCustId(cus_3_id);
		cus_3.setName("demoCustomer_2");
		cus_3.setAge(30);

		// Insert a customer to DB
		cusService.insert(cus_1);
		cusService.insert(cus_2);
		cusService.insert(cus_3);


		// Get Customer By Id
		System.out.println("=============Get Customer By Id");
		cusService.getCustomerById(Long.valueOf(cus_1_id));

		// Get Customer's name by Id
		System.out.println("=============Get Customer Name by Id");
		cusService.getCustomerById(cus_2_id);

		// Get Total Customers in DB
		System.out.println("=============Get Total Number Customer");
		cusService.getCustomerById(cus_3_id);

		System.out.println("#######################################");
		System.out.println("Done!!!");
		System.out.println("#######################################");
	}
}
