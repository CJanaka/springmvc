package com.springmvc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springmvc.model.Merchant;
import com.springmvc.model.Payment;
import com.springmvc.service.MerchantService;
import com.springmvc.service.PaymentService;
import com.springmvc.model.Customer;
import com.springmvc.service.CustomerService;

@RestController
@RequestMapping("api/v1")
public class PaymentController {

	@Autowired
	private CustomerService customerService;

	@Autowired
	private PaymentService paymentService;

	@Autowired
	private MerchantService merchantService;
	
	//Add Customer
	@PostMapping("/customer")
	public long saveCustomer(@RequestBody Customer customer) {
		return customerService.save(customer);
	}

	//Get Customer By Id
	@GetMapping("/customer/{id}")
	public Customer getCustomer(@PathVariable("id") long customerId) {
		return customerService.get(customerId);
	}
	
	//Get All Customers
	@GetMapping("/all-customers")
	public List<Customer> getAllCustomers() {
		return customerService.list();
	}

	//Update Customer
	@PutMapping("/customer/{id}")
	public void updateCustomer(@PathVariable("id") long customerId, @RequestBody Customer customer) {
		customerService.update(customerId, customer);
	}
	
	//Add Merchant
	@PostMapping("/merchant")
	public long saveMerchant(@RequestBody Merchant merchant) {
		return merchantService.save(merchant);
	}
	
	//Update Merchant
	@PutMapping("/merchant/{id}")
	public long updateMerchant(@PathVariable("id") long customerId, @RequestBody Merchant merchant) {
		return merchantService.save(merchant);
	}

	//Get Merchant By Id
	@GetMapping("/merchant/{id}")
	public Merchant getMerchant(@PathVariable("id") long customerId) {
		return merchantService.get(customerId);
	}
	
	//Get All Merchant
	@GetMapping("/all-merchants")
	public List<Merchant> getAllMerchants() {
		return merchantService.list();
	}

	//Add Payment
	@PostMapping("/payment")
	public long savePayment(@RequestBody Payment payment) {
		return paymentService.save(payment);
	}

	//Get All Payments
	@GetMapping("/all-payments")
	public List<Payment> list() {
		return paymentService.list();
	}

	//Get Payment By Amount
	@GetMapping("/payment-byamount/{amount}")
	public List<Payment> getPaymentByAmount(@PathVariable("amount") double amount) {
		return paymentService.getByAmount(amount);
	}

	//Get Payments By Customer Id
	@GetMapping("/get-by-customer/{id}")
	public List<Payment> getByCustomer(@PathVariable("id") long customerId) {
		return paymentService.getByCustomerId(customerId);
	}

	//Get Payments By Merchant Id
	@GetMapping("/get-by-merchant/{id}")
	public List<Payment> getByMerchantId(@PathVariable("id") long merchantId) {
		return paymentService.getByMerchantId(merchantId);
	}

	//Get Payments By Date
	@GetMapping("/get-by-date/{date}")
	public List<Payment> getByCustomer(@PathVariable("date") String date) {
		return paymentService.getByDate(date);
	}

}
