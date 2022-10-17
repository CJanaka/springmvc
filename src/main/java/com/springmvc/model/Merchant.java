package com.springmvc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long merchantId;
	private int contactNo;
	private String merchantName;
	private String merchantAddress;

	public Merchant() {
		super();
	}

	public Merchant(long merchantId, int contactNo, String merchantName, String merchantAddress) {
		super();
		this.merchantId = merchantId;
		this.contactNo = contactNo;
		this.merchantName = merchantName;
		this.merchantAddress = merchantAddress;
	}

	public long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(long merchantId) {
		this.merchantId = merchantId;
	}

	public int getContactNo() {
		return contactNo;
	}

	public void setContactNo(int contactNo) {
		this.contactNo = contactNo;
	}

	public String getMerchantName() {
		return merchantName;
	}

	public void setMerchantName(String merchantName) {
		this.merchantName = merchantName;
	}

	public String getMerchantAddress() {
		return merchantAddress;
	}

	public void setMerchantAddress(String merchantAddress) {
		this.merchantAddress = merchantAddress;
	}

}
