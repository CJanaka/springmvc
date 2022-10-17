package com.springmvc.service;

import java.util.List;

import com.springmvc.model.Merchant;


public interface MerchantService {

	   long save(Merchant merchant);
	   Merchant get(long id);
	   List<Merchant> list();
	   void update(long id, Merchant merchant);
}
