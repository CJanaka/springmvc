package com.springmvc.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springmvc.model.Merchant;



@Repository
public class MerchantImpl implements MerchantDao {

	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public long save(Merchant merchant) {
		sessionFactory.getCurrentSession().save(merchant);
		return merchant.getMerchantId();
	}

	@Override
	public Merchant get(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Merchant> list() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(long id, Merchant merchant) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(long id) {
		// TODO Auto-generated method stub

	}

}
