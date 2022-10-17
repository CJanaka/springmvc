package com.springmvc.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.springmvc.dao.MerchantDao;
import com.springmvc.model.Merchant;

@Service
@Transactional(readOnly = true)
public class MerchantServiceImpl implements MerchantService{

	@Autowired
	private MerchantDao mearchantDao;
	
	@Override
	@Transactional
	public long save(Merchant merchant) {
		return mearchantDao.save(merchant);
	}

	@Override
	public Merchant get(long id) {
		return mearchantDao.get(id);
	}

	@Override
	public List<Merchant> list() {
		return mearchantDao.list();
	}

	@Override
	public void update(long id, Merchant merchant) {
		mearchantDao.update(id, merchant);
	}

}
