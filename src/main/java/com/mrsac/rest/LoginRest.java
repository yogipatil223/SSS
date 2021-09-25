package com.mrsac.rest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrsac.bean.UsersBean;
import com.mrsac.service.UsersService;

@Controller

public class LoginRest {

	@Autowired
	UsersService service;
	
	@RequestMapping("/")
	public String loginPage() {
		
		
		//return "Dashboard";
	 	return "login";
	}
	
	@RequestMapping("/loginPage")	  
	public String login(HttpSession session,HttpServletRequest request ) {
		
	 String otp =	request.getParameter("enteredOtp");
		
    	String res = "login";
    		if( otp.equalsIgnoreCase((String) session.getAttribute("OTP"))) {
    			UsersBean usrBean = new UsersBean();
    			usrBean = (UsersBean) session.getAttribute("userBean");    			
    			int visit_status = service.getVisitCodeStatusServ(usrBean.getSevarth_no());
    			if(visit_status == 0) {
    				res = "register";
    				session.removeAttribute("OTP");
    			}else {
    			
    			res = "Dashboard";
    			session.removeAttribute("OTP");
    			}
    		}else {
    			request.setAttribute("otpStatus", "wrong OTP");
    		
    		}
    	return res;
	}
	
	@RequestMapping("/registrationPage")
	public String registrationPage() {
		return "register";
	}
	
	@RequestMapping("/setProfileCode")	
	public String setProfileCode(HttpServletRequest request,HttpSession session ) throws NoSuchAlgorithmException {
		String redirectTo="";
		String pass =  request.getParameter("password");
		String encryptPass = toHexString(getSHA(pass));
		String profileCode = request.getParameter("profileCode");
		String result = "false";		
		UsersBean usrBean = new UsersBean();
		usrBean = (UsersBean) session.getAttribute("userBean");   
		
		result = service.updateProfileCodeServ(usrBean.getSevarth_no(), profileCode, encryptPass);
		if("true".equalsIgnoreCase(result)) {
			redirectTo = "Dashboard";
		}else {
			redirectTo = "login";
		}
		return redirectTo;
		
	}
	
	
	
	
	@RequestMapping("/loginPageBelowSp")	  
	public String loginPageBelowSp(HttpServletRequest request,HttpSession session ) throws NoSuchAlgorithmException {
		
		UsersBean bean = new UsersBean();
		String sevarth_no =  request.getParameter("sevarthid");
		String pass =  request.getParameter("password");
		String encryptPass = toHexString(getSHA(pass));		
		String res = "login";
		try {
		 bean = service.getSpecificUserServ(sevarth_no, encryptPass);
		
		 session.setAttribute("userBean",bean );
		session.setMaxInactiveInterval(-1);	 
		
    	
    		if( bean.getUsrid() > 0) {
    			if(bean.getRank_status() == 1 || "Module Admin".equalsIgnoreCase(bean.getUser_type())) {
    				
    				res = "login"; 
    			}else {
    				
    				UsersBean usrBean = new UsersBean();
        			usrBean = (UsersBean) session.getAttribute("userBean");    			
        			int visit_status = service.getVisitCodeStatusServ(usrBean.getSevarth_no());
        			if(visit_status == 0) {
        				res = "register";
        				session.removeAttribute("OTP");
        			}else {
        			
        			res = "Dashboard";        			
        			}
    				    			    			
    			}
    		}else {
    			request.setAttribute("validUser", "Incorrect Username or Paasword");
    		
    		}
		}catch(Exception e) {
			res = "login";
			request.setAttribute("validUser", "Incorrect Username or Paasword");
		}
    	return res;
	}
	
	
	
	
	@RequestMapping("/forgotPage")
	public String forgotPage() {
		return "forgotPassword";
		//return "login";
	}
	
	@RequestMapping("/renewPassword")
	public String reNewPassword() {
		return "renewPassword";
	}
	
	@PostMapping("/getProfileCodeBySevarth")
	public String getProfileCodeBySevarth(HttpServletRequest request,HttpSession session) throws NoSuchAlgorithmException {
		String result = "forgotPassword";
		String sevarth_no = request.getParameter("sevarth_no");
		String password = request.getParameter("password");			
		String encryptPass = toHexString(getSHA(password));
		try {
		UsersBean bean =  service.getDetailByMobileNumServ(sevarth_no);
		if(sevarth_no.equalsIgnoreCase(bean.getSevarth_no()) ||  sevarth_no.equalsIgnoreCase(bean.getSevarth_id())) {
		result = "profileCode";
		session.setAttribute("userId", sevarth_no);
		session.setAttribute("PassProfile", encryptPass);
		
		}
		}catch(Exception e) {
			result = "forgotPassword";
		}
		return result;
	}
	

    @PostMapping("/sendOtpForgotPass")
	public String sendOtpForgotPass(HttpServletRequest request,HttpSession session , HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
		String result = "forgotPassword";
    	String validateMob = "Wrong Profile Code";
    	String sevarth_no = request.getParameter("sevarth_no");
		String password = request.getParameter("password");			
		String encryptPass = toHexString(getSHA(password));
		
		//String encryptPass = (String) session.getAttribute("PassProfile");	
		String profileCode = request.getParameter("profileCode");
		
	   String returnProfileCode =	service.getProfileCodeServ(sevarth_no, profileCode);
		UsersBean bean =  service.getDetailByMobileNumServ(sevarth_no);
		try {
			if(returnProfileCode.equalsIgnoreCase(profileCode)) {
		if(sevarth_no.equalsIgnoreCase(bean.getSevarth_no())) {
			
			//183.87.32.146:9090
    	URL url = new URL("http://localhost:9090/MahaPoliceUserService/rest/Resource/OTP/" +bean.getMobile_num());
			//URL url = new URL("http://117.240.213.118:6080/MahaPoliceService/Resource/OTP/" +bean.getMobile_num());
		  
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
				
				JSONObject obj = new JSONObject(output);
				mob = obj.getString("MobileNumber");
				otp = obj.getString("OtpSent");
				session.setAttribute("OTPForgotPass", otp);
			    session.setAttribute("newPassword", encryptPass);
			    session.setAttribute("mobile_num",bean.getSevarth_no());
			    validateMob = "Mobile number is valid . please enter Otp";
			}
			result = "updatePassword";
		}
			}
		}catch(Exception e) {
			result = "forgotPassword";
		}
		request.setAttribute("validateMob", validateMob);
	
		return result;
	}
	
    @PostMapping("/loginMPIS")
    public String loginMPIS(HttpServletRequest request,HttpSession session , HttpServletResponse response){
    	
    	String res = "Error";
    	String sevarth_no = request.getParameter("sevarth_id");
    	String mod_key =  request.getParameter("mod_key");
    	UsersBean bean =  service.getDetailByMobileNumServ(sevarth_no);
    	try {
    	if(sevarth_no.equalsIgnoreCase(bean.getSevarth_no()) && "2da7a9440659ef3dfa02e7a9c29ac19afe6d6066f897d5b7bce1fd49c071a9b6".equalsIgnoreCase(mod_key)) {
    		res = "Dashboard";
    		session.setAttribute("userBean",bean );
    	}
    	}catch(Exception e) {
    		res = "Error";
    	}
    	
    	return res;
    }
    
    	
	
	@PostMapping("/updatePassword")
	public String updatePassword(HttpServletRequest request,HttpSession session) {
		
       	String validateMob = "Invalid OTP";
		String result = "forgotPassword";
		String otp =  request.getParameter("enteredOtp");		
	    String newPassword =  (String) session.getAttribute("newPassword");
	    String mobile_num =  (String) session.getAttribute("mobile_num");
	    request.setAttribute("validateMob", validateMob);
	    if(otp.equalsIgnoreCase((String) session.getAttribute("OTPForgotPass"))) {	    	
	    	service.updatePasswordServ(mobile_num,newPassword);
	    	result = "login";
	    	session.removeAttribute("OTPForgotPass");
	    	session.removeAttribute("newPassword");
	    	session.removeAttribute("mobile_num");
	    }
	    return result;
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
	
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("userBean"); 
		session.removeAttribute("attemptedId"); 
		session.invalidate();
		
		return "login";
	}
	
	 
	 @PostMapping("/sendOtpChangePass")
		public String sendOtpChangePass(HttpServletRequest request,HttpSession session , HttpServletResponse response) throws NoSuchAlgorithmException, IOException {
			String result = "renewPassword";
	    	String validateMob = "Invalid Old Password";
			String sevarthNum = request.getParameter("sevarthNum");
			String password = request.getParameter("oldpassword");
			String newpassword = request.getParameter("newpassword");
			String encryptPassNew = toHexString(getSHA(newpassword));
			String encryptPassOld = toHexString(getSHA(password)); 
			UsersBean bean =  service.getDetailBySevarthServ(sevarthNum,encryptPassOld);
			try {
			if(sevarthNum.equalsIgnoreCase(bean.getSevarth_no())) {
				
			//	URL url = new URL("http://localhost:8084/MahaPoliceUserService/rest/Resource/OTP/" +bean.getMobile_num());
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
					
					JSONObject obj = new JSONObject(output);
					mob = obj.getString("MobileNumber");
					otp = obj.getString("OtpSent");

				
					session.setAttribute("OTPForgotPass", otp);
				    session.setAttribute("newPassword", encryptPassNew);
				    session.setAttribute("mobile_num",bean.getSevarth_no());
				    validateMob = "Sevarth number is valid . please enter Otp";
				}
				result = "updatePassword";
			}
			}catch(Exception e) {
				
			}
			request.setAttribute("validateMob", validateMob);
		
			return result;
		}
	
	
}
