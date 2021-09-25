package com.mrsac.rest;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrsac.bean.ModuleHitsUserBean;
import com.mrsac.service.LoginHistoryServ;

@Controller
@RequestMapping("/LoginHistoryRest")
public class LoginHistoryRest {

	@Autowired
	LoginHistoryServ service;
	
	@PostMapping("/saveModHitsLog")
	@ResponseBody
	public void saveModHitsLog(@RequestBody ModuleHitsUserBean bean,HttpSession session) {
		System.out.println("hi");
		System.out.println(bean);
		Date date  = new Date();
		Timestamp sqlTS = new Timestamp(date.getTime());
		String hit_time_date = sqlTS.toString();
		bean.setHit_time_date(hit_time_date);
		int attemptedId =  (int)session.getAttribute("attemptedId");
		long attempt_idl = (long) attemptedId;
		bean.setAttempt_id(attempt_idl);
		service.saveModHitsLogServ(bean);
	}
	
}
