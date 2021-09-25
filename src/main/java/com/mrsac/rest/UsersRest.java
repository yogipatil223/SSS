package com.mrsac.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
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

import com.mrsac.bean.UsersBean;
import com.mrsac.service.ModpermissionService;
import com.mrsac.service.UsersService;


@Controller
@RequestMapping("/UsersRest")
public class UsersRest {

	@Autowired
	UsersService service;
	
	@Autowired
	ModpermissionService permService; 
	
	@GetMapping("/getusers")
	@ResponseBody
	public List<String> getAllUserList(){		
		return service.readUsersList();		
	}
	
	@GetMapping("/getMobileNum")
	@ResponseBody
	public String getMobileNum(@RequestParam String sevarth_no , @RequestParam String pass,HttpSession session ,HttpServletRequest request) throws NoSuchAlgorithmException, IOException {
		UsersBean bean = new UsersBean();
		try {
		String encryptPass = toHexString(getSHA(pass));		
		 bean = service.getSpecificUserServ(sevarth_no, encryptPass);
		session.setAttribute("userBean",bean );
		session.setMaxInactiveInterval(-1);
		
				
		//URL url = new URL("http://117.240.213.118:6080/MahaPoliceService/Resource/OTP/" +bean.getMobile_num());
		//URL url = new URL("http://m2.mrsac.org.in:8080/MahaPoliceService/Resource/OTP/" +bean.getMobile_num());
		URL url = new URL("http://localhost:9090/MahaPoliceUserService/rest/Resource/OTP/" +bean.getMobile_num());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
		}
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		String output;
		String mob = "";
		String otp = "";
		while ((output = br.readLine()) != null) {
			System.out.println(output);
			JSONObject obj = new JSONObject(output);
			mob = obj.getString("MobileNumber");
			otp = obj.getString("OtpSent");

			System.out.println(otp);
			session.setAttribute("OTP", otp);
		    session.setAttribute("MobileNum",bean.getMobile_num());
		}
//		session.setAttribute("OTP", "123456");
//	    session.setAttribute("MobileNum","9923980411");
		
		}catch(Exception e) {
			
		}
		return bean.getMobile_num();
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
	    
	@GetMapping("/getUserDataFromSession") 
	@ResponseBody
	public UsersBean getUserDataFromSession(HttpSession session) {
		
		UsersBean bean = (UsersBean) session.getAttribute("userBean");
	System.out.println("-------"+bean.getSevarth_no()+"------------------");
		return bean;
	}
	
	@PostMapping("/saveUsers") 
	@ResponseBody
	public String saveUserData(@RequestBody UsersBean bean) throws NoSuchAlgorithmException, JSONException, IOException {
		UsersBean res = null;
		String result = "false";
		if(bean.getUsrid() == 0) {
			Date date = new Date();
			bean.setCreated_on(date.toString());
			bean.setPassword(toHexString(getSHA(bean.getSevarth_no())));
			res = service.saveUserServ(bean);
			if(res.getUsrid() > 0) {
				result = "true";
				//sendCredentials(res.getUsrid());
			}
		}else {
			Date date = new Date();
			bean.setModified_on(date.toString());
			res = service.saveUserServ(bean);
			if(res.getUsrid() > 0) {
				result = "true";
				//updateCredentials(res.getUsrid());
			}
		}
		
		return result;
	}
	
	@GetMapping("/getSevarthNumbers") 
	@ResponseBody
	public List<UsersBean> getSevarthNumbers(@RequestParam String sevarthNum) {
		
		return service.getSevarthNumServ(sevarthNum);
	}
	   
	 
	
	@GetMapping("/getUserBySevarthNumber") 
	@ResponseBody
	public List<UsersBean> getUserBySevarthNumber(@RequestParam String sevarthNum) {		
		return service.getuserBySevarthServ(sevarthNum);
	}
	

	@GetMapping("/getUserIdBySevarth") 
	@ResponseBody
	public int getUserIdBySevarth(@RequestParam String sevarthNum) {		
		return service.getUserIdByNameServ(sevarthNum);
	}
	
	
public void sendCredentials(int id) throws JSONException, IOException {
		
	try {
		String changePasswordUrl = "http://183.87.32.146:9090/SSS/renewPassword";
		String mainUrl = "http://localhost:9090/MahaPoliceUserService/rest/Resource/sendCredentials?id="+id+"&changePasswordUrl="+changePasswordUrl;
		//String mainUrl = "http://localhost:8080/MahaPoliceUserService/rest/Resource/sendCredentials?id="+id+"&changePasswordUrl="+changePasswordUrl;
	
		URL url = new URL(mainUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		String output = "";
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		while ((output = br.readLine()) != null) {
			
		}
	}catch(Exception e) {
		
	}
	}
	
	
	public void updateCredentials(int id) throws IOException {
		try {
		String mainUrl = "http://localhost:9090/MahaPoliceUserService/rest/Resource/updateCredentials?id="+id; 
		//String mainUrl = "http://localhost:8080/MahaPoliceUserService/rest/Resource/updateCredentials?id="+id; 
		
		URL url = new URL(mainUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		String output = "";
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		while ((output = br.readLine()) != null) {
			
		}
		}catch(Exception e) {
			
		}
	}
	
	@GetMapping("/getMaxRankValue")
	@ResponseBody
	public int getMaxRankValue(@RequestParam String usr_rank  ) {
		return service.getMaxRankValueServ(usr_rank);
	}
	
	@GetMapping("/resetUsrPassword")
	@ResponseBody
	public String resetUsrPassword(@RequestParam  int user_id ,@RequestParam  String mobile_num  ) {
		  String output = "false";
           
		try {
			 Random r = new Random();
	           int Result = 100000 + r.nextInt(900000);
	           String profile_code = Result + "";
	           Random r1 = new Random();
	           int ResultTwo = 100000 + r1.nextInt(900000);
	           String password = ResultTwo + "";	
	           String encryptPass = toHexString(getSHA(password));	
	           output =	service.resetUsrPasswordServ(profile_code, encryptPass, user_id);
	           resetCredentials(user_id,password,profile_code,mobile_num);
	           
		}catch(Exception e) {
			System.out.println("Exception in UserRest in resetUsrPassword()="+e);
		}
		return output;
		
	}
	
	
	public void resetCredentials(int id , String password ,  String profile_code, String mobile_num ) throws IOException {
		try {
		String mainUrl = "http://localhost:9090/MahaPoliceUserService/rest/Resource/resetCredentials?id="+id+"&password="+password+"&profile_code="+profile_code+"&mobile_num="+mobile_num; 
		//String mainUrl = "http://localhost:8080/MahaPoliceUserService/rest/Resource/updateCredentials?id="+id; 
		
		URL url = new URL(mainUrl);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		String output = "";
		BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));
		while ((output = br.readLine()) != null) {
			
		}
		}catch(Exception e) {
			
		}
	}
	
	@PostMapping("/getusersDataBranchWise")
	@ResponseBody
	public List<UsersBean> getusersDataBranchWise(@RequestBody FilterBean bean) {
		
		return  service.getUsersByBranchWiseServ(bean);
	
	}
	
	@GetMapping("/readUsersByAdmin")
	@ResponseBody
    public List<UsersBean> readUsersByAdmin(@RequestParam("userType") String userType) {
		
		return  service.readUsersFromAdminServ(userType);
	
	}
	
	@PostMapping("/getUserCountByFilter")
	@ResponseBody
	public List<Object> getUserCountByFilter(@RequestBody FilterBean bean){
		
		return service.readUserCountFilterServ(bean);
	}
	
	@PostMapping("/getUserDetailByFilter")
	@ResponseBody
	public List<Object[]> getUserDetailByFilter(@RequestBody FilterBean bean){
		
		List<Object[]> result = service.getUserInfoFilterServ(bean);
		for(int i = 0;i<result.size();i++) {
		 System.out.println(result.get(i)[8]);
		 List<String> modObj = permService.getModuleByUserIdServ( (int) result.get(i)[8]);
		 result.get(i)[8]=modObj;
		}
		
		return result;
	}
	
	@PostMapping("/getUserTypeCountByFilter")
	@ResponseBody
	public List<Object> getUserTypeCountByFilter(@RequestBody FilterBean bean){
		
		return service.readUserTypeGroupFilterServ(bean);
	}
	
}
