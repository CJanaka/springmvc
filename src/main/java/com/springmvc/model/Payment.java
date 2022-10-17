package com.springmvc.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity(name = "payment")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long paymentId;
	@JsonFormat(pattern="yyyy-MM-dd")
	private LocalDate paymentDate;
	private double amount;
	@ManyToOne
	private Customer customer;
	@ManyToOne
	private Merchant merchant;
	
	public Payment() {
		super();
	}

	public Payment(LocalDate paymentDate, double amount, Customer customer, Merchant merchant) {
		this.paymentDate = paymentDate;
		this.amount = amount;
		this.customer = customer;
		this.merchant = merchant;
	}

	public long getPaymentId() {
		return paymentId;
	}

	public void setPaymentId(long paymentId) {
		this.paymentId = paymentId;
	}

	public LocalDate getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(LocalDate paymentDate) {
		this.paymentDate = paymentDate;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Merchant getMerchant() {
		return merchant;
	}

	public void setMerchant(Merchant merchant) {
		this.merchant = merchant;
	}

	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", paymentDate=" + paymentDate + ", amount=" + amount + ", customer="
				+ customer + ", merchant=" + merchant + "]";
	}

	
}
