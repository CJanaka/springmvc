package com.springmvc.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.PaymentDao;
import com.springmvc.model.Payment;

@Service
@Transactional(readOnly = true)
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	private PaymentDao paymentDao;

	@Override
	@Transactional
	public long save(Payment payment) {
		payment.setPaymentDate(LocalDate.now());
		return paymentDao.save(payment);
	}

	@Override
	public Payment get(long id) {
		return paymentDao.get(id);
	}

	@Override
	public List<Payment> getByCustomerId(long id) {
		return paymentDao.getByCustomerId(id);
	}

	@Override
	public List<Payment> getByMerchantId(long id) {
		return paymentDao.getByMerchantId(id);
	}

	@Override
	public List<Payment> getByDate(String dte) {
		LocalDate date = LocalDate.parse(dte);
		return paymentDao.getByDate(date);
	}

	@Override
	public List<Payment> getByAmount(double amount) {
		return paymentDao.getByAmount(amount);
	}

	@Override
	public List<Payment> list() {
		return paymentDao.list();
	}

}
