package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.CustomerDao;
import com.springmvc.model.Customer;


@Service
@Transactional(readOnly = true)
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerDao customerDao;
	
	@Override
	@Transactional
	public long save(Customer customer) {
		return customerDao.save(customer);
	}

	@Override
	public Customer get(long id) {
		return customerDao.get(id);
	}

	@Override
	public List<Customer> list() {
		return customerDao.list();
	}

	@Override
	public void update(long id, Customer customer) {
		customerDao.update(id, customer);
	}


}
