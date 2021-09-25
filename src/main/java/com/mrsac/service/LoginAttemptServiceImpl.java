package com.mrsac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsac.bean.LoginAttemptBean;
import com.mrsac.dao.LoginAttemptDao;

@Service
public class LoginAttemptServiceImpl implements LoginAttemptService {

	@Autowired
	LoginAttemptDao dao;
	
	@Override
	@Transactional
	public LoginAttemptBean setLoginAttempt(LoginAttemptBean bean) {
		LoginAttemptBean beanOne =	dao.save(bean);
		return beanOne;
	}
	
	@Override
	@Transactional
	public void logoutUserServ(String end_session , int attempt_id) {
		 dao.logoutUser(end_session, attempt_id);
	}
	
	@Override
	@Transactional
	public List<LoginAttemptBean> getLoginHistoryServ(String date){
		return dao.getLoginHistoryCurrentMonth(date);
	}
	
	@Override
	@Transactional
	public List<LoginAttemptBean> getLoginHistoryByDate(String fromDate , String toDate){
		return dao.getLoginHistoryMonthWise(fromDate, toDate);
	}
	
}
