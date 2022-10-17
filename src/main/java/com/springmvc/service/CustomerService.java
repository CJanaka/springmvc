package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Customer;



public interface CustomerService {

	   long save(Customer customer);
	   Customer get(long id);
	   List<Customer> list();
	   void update(long id, Customer customer);
}
