package com.mrsac.rest;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrsac.bean.FilterBean;
import com.mrsac.bean.ModPermissionBean;
import com.mrsac.service.ModpermissionService;

@Controller
@RequestMapping("/ModPermissionRest")
public class ModPermissionRest {

	@Autowired
	ModpermissionService service;
	
	@PostMapping("/saveModPermission")
	@ResponseBody
	public String saveModPermission(@RequestBody ModPermissionBean bean) {
		Date date  = new Date();
		String result = "false";
		bean.setApplied_on(date.toString());
		int isAvailable = 0;
		isAvailable = service.isRecordAvailable(bean.getSevarthnum(), bean.getMod_id());
		
		
		if(isAvailable == 0 || bean.getPr_id() > 0 ) {
			result = service.saveModPermission(bean);
		}else {
			result = "false";
		}
		return result;
	}
	
	@GetMapping("/getModPermissionData")
	@ResponseBody
	public List<ModPermissionBean> getModPermissionData(@RequestParam String applier_id){
		return service.getModPermissionDataServ(applier_id);
	}
	
	@GetMapping("/getDataById")
	@ResponseBody
	public ModPermissionBean getDataById(@RequestParam long permId) {
		return service.getDataBypermIdServ(permId);
	}
	
	@GetMapping("/deleteDataByIds")
	@ResponseBody
	public String deleteDataById(@RequestParam long permId) {
		
		return service.deleteDataById(permId);
		
	}
	
//	@GetMapping("/getDataModuleEntryByUser")
//	@ResponseBody
//	public List<ModPermissionBean> getDataModuleEntryByUser(@RequestParam String sevarthNum){
//		return service.getDataModuleEntryByUserServ(sevarthNum) ;
//	}
	
	@GetMapping("/getDataViewByUser")
	@ResponseBody
	public List<ModPermissionBean> getDataViewByUser(@RequestParam String sevarthNum){
		return service.getDataViewByUserServ(sevarthNum);
	}
	
//	@GetMapping("/getDataValidationByUser")
//	@ResponseBody
//	public List<ModPermissionBean> getDataValidationByUser(@RequestParam String sevarthNum){
//		return service.getDataValidationByUserServ(sevarthNum);
//	}
	
	
	@GetMapping("/getModuleBysevarthId")
	@ResponseBody
	 public List<ModPermissionBean>  getModuleBysevarthId(@RequestParam String SevarthId){
		return service.getModuleBysevarthIdServ(SevarthId);
	}
	
	@GetMapping("/getPermiByModId")
	@ResponseBody
	public List<ModPermissionBean> getPermiByModId(@RequestParam int modid){
		return service.getPermiByModIdServ(modid);
	}
	
	@PostMapping("/saveModPermissionBulk")
	@ResponseBody
	public String saveModPermissionBulk(@RequestBody FilterBean bean) {
		String updateResult = "false";
		 
		try {
			Date date  = new Date();			
			bean.setApplied_on(date.toString());
			updateResult = service.getUsrIdByFilterServ(bean);
			
		}catch(Exception e) {
			System.out.println("Exception in ModPermissionRest in saveModPermissionBulk()="+e);
		}
		
		return updateResult;
	}
	
	@PostMapping("/getBulkUpdatedRecords")
	@ResponseBody
	public List<ModPermissionBean> getBulkUpdatedRecords(@RequestBody FilterBean bean) {
		
		return  service.updatedUserListServ(bean);
	
	}
	
	@PostMapping("/saveUserPermBySelect")
	@ResponseBody
	public String saveUserPermBySelect(@RequestBody List<ModPermissionBean> beanArr) {
		
		return service.saveUserPermBySelectServ(beanArr);
	}
	
	
	
	
}
