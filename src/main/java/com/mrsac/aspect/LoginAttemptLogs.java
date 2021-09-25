package com.mrsac.aspect;


import java.net.UnknownHostException;
import java.sql.Timestamp;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.mrsac.bean.LoginAttemptBean;
import com.mrsac.service.LoginAttemptService;
import com.mrsac.service.UsersService;

@Aspect
@Component
public class LoginAttemptLogs {

	@Autowired
	UsersService usersService;
	
	@Autowired
	LoginAttemptService attemptService;
	
	@After("execution (* com.mrsac.rest.UsersRest.getMobileNum(..)) ")
	public void setLoginAttempt( JoinPoint joinPoint ) throws UnknownHostException {				
		System.out.println(joinPoint.getArgs());
		Object[] obj = joinPoint.getArgs();
		String sevarthNum = (String) obj[0];
		try {
	   int userId =	usersService.getUserIdByNameServ(sevarthNum);
	
	   HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
	   HttpSession session = request.getSession();

	   Date date = new Date(); 
	   
	 //  Date date  = new Date();
		Timestamp sqlTS = new Timestamp(date.getTime());
		String starsession = sqlTS.toString();
	   
	   LoginAttemptBean bean = new LoginAttemptBean();
	   bean.setUsr_id(userId);
	   bean.setIp_address(request.getRemoteAddr());
	   bean.setStart_session(starsession);
	   bean.setEnd_session("NA");
	   
	   LoginAttemptBean beanOne = attemptService.setLoginAttempt(bean);
	   int attemptId = (int) beanOne.getAttempt_id();
	   session.setAttribute("attemptedId", attemptId); 
	    System.out.println(session.getAttribute("attemptedId"));
		}catch(Exception e) {
			
		}
	}
	
	@Before("execution (* com.mrsac.rest.LoginRest.logout(..))")
	public void updateSessionEnd() {
		try {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		HttpSession session = request.getSession();
		int attemptedId = (int) session.getAttribute("attemptedId");
		Date date = new Date(); 
		Timestamp sqlTS = new Timestamp(date.getTime());
		String endsession = sqlTS.toString();
		attemptService.logoutUserServ(endsession, attemptedId);
		}catch(Exception e) {
			
		}
	}
	
	
	@After("execution (* com.mrsac.rest.LoginRest.loginPageBelowSp(..)) ")
	public void setOtherLoginAttempt(JoinPoint joinPoint) throws UnknownHostException {
		System.out.println(joinPoint.getArgs());
		Object[] obj = joinPoint.getArgs();
		HttpServletRequest paramRequest = (HttpServletRequest) obj[0];
		String sevarthNum =  paramRequest.getParameter("sevarthid");
		try {
		 int userId =	usersService.getUserIdByNameServ(sevarthNum);
			
		   HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		   HttpSession session = request.getSession();

		   Date date = new Date();   
		   Timestamp sqlTS = new Timestamp(date.getTime());
			String startsession = sqlTS.toString();
		   LoginAttemptBean bean = new LoginAttemptBean();
		   bean.setUsr_id(userId);
		   bean.setIp_address(request.getRemoteAddr());
		   bean.setStart_session(startsession);
		   bean.setEnd_session("NA");
		   
		   LoginAttemptBean beanOne = attemptService.setLoginAttempt(bean);
		   int attemptId = (int) beanOne.getAttempt_id();
		   session.setAttribute("attemptedId", attemptId); 
		    System.out.println(session.getAttribute("attemptedId"));
		}catch(Exception e) {
			
		}
	}
	
	@After("execution (* com.mrsac.rest.LoginRest.loginMPIS(..)) ")
	public void setOtherLoginAttemptMPIS(JoinPoint joinPoint) throws UnknownHostException {
		System.out.println(joinPoint.getArgs());
		Object[] obj = joinPoint.getArgs();
		HttpServletRequest paramRequest = (HttpServletRequest) obj[0];
		String sevarthNum =  paramRequest.getParameter("sevarth_id");
		try {
		 int userId =	usersService.getUserIdByNameServ(sevarthNum);
			
		   HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
		   HttpSession session = request.getSession();

		   Date date = new Date();    
		   Timestamp sqlTS = new Timestamp(date.getTime());
			String startsession = sqlTS.toString();
		   LoginAttemptBean bean = new LoginAttemptBean();
		   bean.setUsr_id(userId);
		   bean.setIp_address(request.getRemoteAddr());
		   bean.setStart_session(startsession);
		   bean.setEnd_session("NA");
		   
		   LoginAttemptBean beanOne = attemptService.setLoginAttempt(bean);
		   int attemptId = (int) beanOne.getAttempt_id();
		   session.setAttribute("attemptedId", attemptId); 
		    System.out.println(session.getAttribute("attemptedId"));
		}catch(Exception e) {
			
		}
	}
	
}
