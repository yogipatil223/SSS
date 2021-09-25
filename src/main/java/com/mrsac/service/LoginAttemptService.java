package com.mrsac.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mrsac.bean.LoginAttemptBean;

public interface LoginAttemptService {

	public LoginAttemptBean setLoginAttempt(LoginAttemptBean bean);
	public void logoutUserServ(String end_session , int attempt_id);
	public List<LoginAttemptBean> getLoginHistoryServ(String date);
	public List<LoginAttemptBean> getLoginHistoryByDate(String fromDate , String toDate);
	
}
