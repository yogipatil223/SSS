package com.mrsac.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrsac.bean.UnitsBean;
import com.mrsac.service.UnitService;

@Controller
@RequestMapping("/UnitRest")
public class UnitRest {
  
	@Autowired
	UnitService service;
	
	@GetMapping("/getBranches")
	@ResponseBody
	public List<UnitsBean> getBranches(){
		return service.getBranchesServ();
	}
	
	@GetMapping("/getLevel1Data")
	@ResponseBody
	public List<UnitsBean> getLevel1Data(@RequestParam String branch){
				
		return  service.getDataForFirstLevel(branch);
		
	}
	
	@GetMapping("/getLevel2Data")
	@ResponseBody
	public List<UnitsBean> getLevel2Data(@RequestParam String branch,@RequestParam String level1){				
		return  service.getDataForSecondLevel(level1, branch);		
	}
	
	@GetMapping("/getPoliceStation")
	@ResponseBody
	public List<UnitsBean> getPoliceStation(@RequestParam String level2){	
		
		return  service.getPoliceStationServ(level2);	
	}
	
}
