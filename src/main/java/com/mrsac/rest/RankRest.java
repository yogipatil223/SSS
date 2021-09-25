package com.mrsac.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrsac.bean.RankBean;
import com.mrsac.service.RankService;

@Controller
@RequestMapping("/RankRest")
public class RankRest {

	@Autowired
	RankService service;
	
	@GetMapping("/findAllRanks")
	@ResponseBody
	public List<RankBean> findAllRanks(){
		return service.getRanks();
	}
}
