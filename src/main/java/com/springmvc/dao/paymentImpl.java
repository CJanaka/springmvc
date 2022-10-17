package com.springmvc.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.springmvc.model.Payment;

@Repository
public class paymentImpl implements PaymentDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Payment payment) {
		sessionFactory.getCurrentSession().save(payment);
		return payment.getPaymentId();
	}

	@Override
	public Payment get(long id) {
		return sessionFactory.getCurrentSession().get(Payment.class, id);
	}

	@Override
	public List<Payment> list() {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder criteriaBuilder = session.getCriteriaBuilder();
		CriteriaQuery<Payment> criteriaQuery = criteriaBuilder.createQuery(Payment.class);
		Root<Payment> root = criteriaQuery.from(Payment.class);
		criteriaQuery.select(root);
		Query<Payment> query = session.createQuery(criteriaQuery);
		return query.getResultList();
	}

	@Override
	public List<Payment> getByAmount(double amount) {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Payment> criteriaQuery = cb.createQuery(Payment.class);
		Root<Payment> root = criteriaQuery.from(Payment.class);
		criteriaQuery.select(root).where(cb.equal(root.get("amount"), amount));
		Query<Payment> query = session.createQuery(criteriaQuery);
		List<Payment> results = query.getResultList();
		return results;
	}

	@Override
	public List<Payment> getByDate(LocalDate date) {

		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Payment> criteriaQuery = cb.createQuery(Payment.class);
		Root<Payment> root = criteriaQuery.from(Payment.class);
	
		criteriaQuery.select(root).where(cb.equal(root.get("paymentDate"), date));
		Query<Payment> query = session.createQuery(criteriaQuery);
		List<Payment> results = query.getResultList();
		return results;
	}

	@Override
	public List<Payment> getByMerchantId(long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Payment> criteriaQuery = cb.createQuery(Payment.class);
		Root<Payment> root = criteriaQuery.from(Payment.class);
		criteriaQuery.select(root).where(cb.equal(root.get("merchant").get("merchantId"), id));
		Query<Payment> query = session.createQuery(criteriaQuery);
		List<Payment> results = query.getResultList();
		return results;
	}

	@Override
	public List<Payment> getByCustomerId(long id) {
		Session session = sessionFactory.getCurrentSession();
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Payment> criteriaQuery = cb.createQuery(Payment.class);
		Root<Payment> root = criteriaQuery.from(Payment.class);
		criteriaQuery.select(root).where(cb.equal(root.get("customer").get("customerId"), id));
		Query<Payment> query = session.createQuery(criteriaQuery);
		List<Payment> results = query.getResultList();
		return results;
	}
}
