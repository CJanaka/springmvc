package com.springmvc.dao;

import java.time.LocalDate;
import java.util.List;

import com.springmvc.model.Payment;

public interface PaymentDao {

	long save(Payment payment);
	Payment get(long id);
	List<Payment> list();
	List<Payment> getByAmount(double amount);
	List<Payment> getByMerchantId(long id);
	List<Payment> getByCustomerId(long id);
	List<Payment> getByDate(LocalDate date);
}
