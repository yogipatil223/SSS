package com.mrsac.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrsac.bean.UnitManagementBean;
import com.mrsac.service.UnitManagementService;

@Controller
@RequestMapping("/UnitManagementRest")
public class UnitManagementRest {

	@Autowired
	UnitManagementService service;
	
	@PostMapping("/saveRoneRecordRest")
	@ResponseBody
	public UnitManagementBean saveRoneRecordRest(@RequestBody UnitManagementBean bean) {
		String mode = "insert";
		if(bean.getId()!= 0) {
			 mode = "update";
		}
		return service.saveRoneRecordServ(bean,mode);
	}
	
	@GetMapping("/getRoneAllRecords")
	@ResponseBody
	public List<UnitManagementBean> getRoneAllRecords(){
		return service.getRoneAllRecordsServ();
	}
	
	@GetMapping("/getRoneRecordsById")
	@ResponseBody
	public UnitManagementBean getRoneRecordsById(@RequestParam("id") int id){
		return service.getRoneRecordByIdServ(id);
	}
	
	
	@GetMapping("/deleteRoneRecordsById")
	@ResponseBody
	public String deleteRoneRecordsById(@RequestParam("id") int id){
		return service.deleteRoneRecordServ(id);
	}
	
	@GetMapping("/getUnitNameByLevel3")
	@ResponseBody
	public String getUnitNameByLevel3(@RequestParam("level3") String level3) {
		System.out.println("level3========"+level3);
		System.out.println(service.getUnitNameByLevelThreeServ(level3));
		return service.getUnitNameByLevelThreeServ(level3);
	}

	
}
