package com.mrsac.rest;



import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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

import com.mrsac.bean.ModuleBean;
import com.mrsac.service.ModuleManageService;

@Controller
@RequestMapping("/ModuleRest")
public class ModuleRest {

	@Autowired
	 ModuleManageService service;
	
	
	@PostMapping("/saveModule")
	@ResponseBody
	public String saveModule(@RequestBody ModuleBean bean) throws NoSuchAlgorithmException {
		 Date date = new Date();
		 bean.setCreatedon(date.toString());
		 
		 if(bean.getModule_id() == 0) {	
		 String mod_key = bean.getModule_name() + "Y09E5HM";
		 
		 String encryptModKey = toHexString(getSHA(mod_key));
		 bean.setMod_key(encryptModKey);
		 }
		return service.saveModuleServ(bean);
	}
	
	@GetMapping("/getModuleData")
	@ResponseBody
	public List<ModuleBean> getModuleData(){
		return service.getModuledata();
	}
	
	@GetMapping("/deleteModule")
	@ResponseBody
	public String deleteModule(@RequestParam int mod_id){
		return service.deleteModule(mod_id);
	}
	
	 public static byte[] getSHA(String input) throws NoSuchAlgorithmException 
	    {  
	        
	        MessageDigest md = MessageDigest.getInstance("SHA-256"); 
	        return md.digest(input.getBytes(StandardCharsets.UTF_8));  
	    } 
	    
	    public static String toHexString(byte[] hash) 
	    { 	        
	        BigInteger number = new BigInteger(1, hash);  	  	       
	        StringBuilder hexString = new StringBuilder(number.toString(16));  	  	      
	        while (hexString.length() < 32)  
	        {  
	            hexString.insert(0, '0');  
	        }  
	  
	        return hexString.toString();  
	    } 
	
	
}
