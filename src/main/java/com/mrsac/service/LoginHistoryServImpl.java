package com.mrsac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsac.bean.ModuleHitsUserBean;
import com.mrsac.dao.LoginHistoryDao;

@Service
public class LoginHistoryServImpl implements LoginHistoryServ{

	@Autowired
	LoginHistoryDao dao;
	
	@Override
	@Transactional
	public void saveModHitsLogServ(ModuleHitsUserBean bean) {
		dao.save(bean);
	}
	
}
