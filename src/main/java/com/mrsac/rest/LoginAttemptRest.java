package com.mrsac.rest;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrsac.bean.LoginAttemptBean;

import com.mrsac.service.LoginAttemptService;

@Controller
@RequestMapping("/LoginAttemptRest")
public class LoginAttemptRest {
	
	@Autowired
	LoginAttemptService service ;
	
	@GetMapping("/getLoginHistory")
	@ResponseBody
	public List<LoginAttemptBean> getLoginHistory(){
		
		 long currentDateTime = System.currentTimeMillis();
	      Date currentDate = new Date(currentDateTime);
	     
	      DateFormat planDateFormat = new SimpleDateFormat("yyyy-MM");
	      String date=planDateFormat.format(currentDate);
		System.out.println("date="+date);
		return service.getLoginHistoryServ(date);
	}
	
	@GetMapping("/getLoginHistoryMonthWise")
	@ResponseBody
	public List<LoginAttemptBean> getLoginHistoryMonthWise(@RequestParam("fromDate") String fromDate , @RequestParam("toDate") String toDate ){
		return service.getLoginHistoryByDate(fromDate, toDate);
	}

}
