package com.springmvc.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Customer;

@Repository
public class CustomerImpl implements CustomerDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Customer customer) {
		sessionFactory.getCurrentSession().save(customer);
		return customer.getCustomerId();
	}

	@Override
	public Customer get(long id) {
		return sessionFactory.getCurrentSession().get(Customer.class, id);
	}

	@Override
	public List<Customer> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Customer> criteriaQuery = criteriaBuilder.createQuery(Customer.class);
		Root<Customer> root = criteriaQuery.from(Customer.class);
		criteriaQuery.select(root);
		Query<Customer> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public void update(long id, Customer customer) {
		Session session = sessionFactory.getCurrentSession();
		Customer existingCustomer = session.byId(Customer.class).load(id);
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setContact(customer.getContact());
		existingCustomer.setCustomerName(customer.getCustomerName());
		session.flush();
	}

	@Override
	public void delete(long id) {
		Customer existingCustomer = sessionFactory.getCurrentSession().byId(Customer.class).load(id);
		sessionFactory.getCurrentSession().delete(existingCustomer);
	}

}
