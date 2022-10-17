package com.springmvc.dao;

import java.util.List;

import com.springmvc.model.Merchant;



public interface MerchantDao {

	   long save(Merchant merchant);
	   Merchant get(long id);
	   List<Merchant> list();
	   void update(long id, Merchant merchant);
	   void delete(long id);
}
