package com.codehub.spring.jdbcpostgresql;

import com.codehub.spring.jdbcpostgresql.model.Customer;
import com.codehub.spring.jdbcpostgresql.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@SpringBootApplication
@ComponentScan("com.codehub.spring.jdbcpostgresql")
public class SpringJdbcTemplatePostgreSqlApplication implements CommandLineRunner {

	@Autowired
	CustomerService cusService;

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcTemplatePostgreSqlApplication.class, args);
	}

	@Override
	public void run(String... strings) throws Exception {
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

		// Insert a List of Customer to DB
		List<Customer> customers = new ArrayList<Customer>();
		customers.add(cus_2);
		customers.add(cus_3);
		cusService.insertBatch(customers);

		// Load All Customer and display
		cusService.loadAllCustomer();

		// Get Customer By Id
		System.out.println("=============Get Customer By Id");
		cusService.getCustomerById(Long.valueOf(cus_1_id));

		// Get Customer's name by Id
		System.out.println("=============Get Customer Name by Id");
		cusService.getCustomerNameById(cus_2_id);

		// Get Total Customers in DB
		System.out.println("=============Get Total Number Customer");
		cusService.getTotalNumerCustomer();

		System.out.println("#######################################");
		System.out.println("Done!!!");
		System.out.println("#######################################");

	}
}
