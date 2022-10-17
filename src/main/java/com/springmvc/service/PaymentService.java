package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Payment;

public interface PaymentService {

	long save(Payment payment);
	Payment get(long id);
	List<Payment> list();
	List<Payment> getByCustomerId(long id);
	List<Payment> getByMerchantId(long id);
	List<Payment> getByAmount(double amount);
	List<Payment> getByDate(String date);
	
}
