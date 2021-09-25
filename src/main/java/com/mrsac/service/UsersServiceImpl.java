package com.mrsac.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsac.bean.FilterBean;
import com.mrsac.bean.ModPermissionBean;

import com.mrsac.bean.UsersBean;
import com.mrsac.dao.UsersDao;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	UsersDao dao;
	
	@Override
	@Transactional
	public List<String> readUsersList(){
		return dao.getUserDetails();
	}
	
	@Override
	@Transactional
	public UsersBean getSpecificUserServ(String sevarth_no, String password ) {
		return dao.getSpecificUser(sevarth_no, password);
	}
	
	@Override
	@Transactional
	public UsersBean getDetailByMobileNumServ(String sevarth_no) {
		return dao.getDetailByMobileNum(sevarth_no);
	}
	
	@Override
	@Transactional
	public String updatePasswordServ(String mobileNum , String password) {
		
		String result = "false";
		try {
	    dao.updateUsrPassword(mobileNum, password);
	    result = "true";
		}catch(Exception e) {
			
			System.out.println("Exception in UsersServiceImpl in updatePasswordServ()="+e);
		}
		return result;
	}
	
	@Override
	@Transactional
	public int getUserIdByNameServ(String sevarthNum) {
		return dao.getUserIdByName(sevarthNum);
	}
	
	@Override
	@Transactional
	public UsersBean saveUserServ(UsersBean bean) throws JSONException, IOException {
				
		UsersBean res = dao.save(bean);			
		return res;
	}
	
	@Override
	@Transactional
	public List<UsersBean> getSevarthNumServ( String creatorSevarthNum){
		List<UsersBean> result = new ArrayList<>();		
		result = dao.getSevarthNum(creatorSevarthNum);
		return result;
	}
	
	@Override
	@Transactional
	public List<UsersBean> getuserBySevarthServ( String sevarthNum){			
		return dao.getuserBySevarth(sevarthNum);
	}
	
	@Override
	@Transactional
	public UsersBean getDetailBySevarthServ( String sevarthNum,String oldpaaword ) {
		return dao.getDetailBySevarth(sevarthNum,oldpaaword);
	}
	
	@Override
	@Transactional
	public int getMaxRankValueServ(String usr_rank) {
		return dao.getMaxRankValue(usr_rank);
		
	}
	
	@Override
	@Transactional
	public int getVisitCodeStatusServ(String userid) {
		return dao.getVisitCodeStatus(userid);
	}
	
	@Override
	@Transactional
	public String updateProfileCodeServ(String userId,String profileCode, String newPassword ) {
		String result = "false";
		try {
	    dao.updateProfileCode(userId, profileCode, newPassword);
	    result = "true";
		}catch(Exception e) {
			
			System.out.println("Exception in UsersServiceImpl in updateProfileCodeServ()="+e);
		}
		return result;		
	
	}
	
	@Override
	@Transactional
	public String getProfileCodeServ( String userId, String profileCode) {
		return dao.getProfileCode(userId, profileCode);
	}
	
	@Override
	@Transactional
	public String resetUsrPasswordServ( String profile_code, String password ,  int user_id ) {
		
		String result = "false";
		try {
	    dao.resetUsrPassword(profile_code, password, user_id);
	    result = "true";
		}catch(Exception e) {
			
			System.out.println("Exception in UsersServiceImpl in resetUsrPassword()="+e);
		}
		return result;	
		
	}
	
	@Override
	@Transactional
	public List<UsersBean> getUsersByBranchWiseServ(FilterBean bean){
		
List<UsersBean> Result = null; 
		
		if("NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.getAllUserDetail(bean.getUsr_rank());
			
		}else if(("Commissionerate".equalsIgnoreCase(bean.getBranch()) || "Range".equalsIgnoreCase(bean.getBranch()) ) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.getUsersAllBranch(bean.getUsr_rank(),bean.getJoinCode());			 
			
		}
		else if(!"Commissionerate".equalsIgnoreCase(bean.getBranch()) && !"Range".equalsIgnoreCase(bean.getBranch())  && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
						
			Result = dao.getUsersAllBranchOther(bean.getUsr_rank(),bean.getJoinCode(),bean.getJoinCode());
			
		}
						
		else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
				
			Result = dao.getUsersAllLevels(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2(), bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
								
			Result = dao.getUsersLevelOneTwo(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2());
			
		}else if( "NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			Result = dao.getUsersLevelOneThree(bean.getUsr_rank(), bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
		
			Result = dao.getUsersLevelOne(bean.getUsr_rank(), bean.getLevel1());
		}
		
		return Result;
	
	}
	
	@Override
	@Transactional
	public List<UsersBean> readUsersFromAdminServ(String userType){
		List<UsersBean> result = null;
		try {
			if("Module Admin".equalsIgnoreCase(userType)) {
				result = dao.readUserFromModuleAdmin();
			}else if("Unit User".equalsIgnoreCase(userType)) {
				result = dao.readUserFromUnitAdmin();
			}else if("Super Admin".equalsIgnoreCase(userType)) {
				result = dao.readUserFromSuperAdmin();
			}			
			
		}catch(Exception e) {
			
		}
		return result;
	}
	
	@Override
	@Transactional
	public List<Object> readUserCountFilterServ(FilterBean bean){
		List<Object> Result = null; 
		

		if("NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserCountAll();
			
		}else if(("Commissionerate".equalsIgnoreCase(bean.getBranch()) || "Range".equalsIgnoreCase(bean.getBranch()) ) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserCountAllBranch(bean.getJoinCode());	 
			
		}
		else if(!"Commissionerate".equalsIgnoreCase(bean.getBranch()) && !"Range".equalsIgnoreCase(bean.getBranch())  && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
			
			Result = dao.readUserCountBranchOther(bean.getJoinCode());
			
		}
						
		else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserCountAllLevels(bean.getLevel1(), bean.getLevel2(), bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
					
		
			Result = dao.readUserCountAllOneTwo(bean.getLevel1(), bean.getLevel2());
			
		}else if( "NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserCountAllOneThree( bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserCountAllOne(bean.getLevel1());
		}
		
		
		return Result;
	}
	
	
	@Override
	@Transactional
	public List<Object[]> getUserInfoFilterServ(FilterBean bean){
		
		List<Object[]> Result = null; 
		

		if("NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
		
			Result = dao.readUserDetailAll();
			
		}else if(("Commissionerate".equalsIgnoreCase(bean.getBranch()) || "Range".equalsIgnoreCase(bean.getBranch()) ) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			System.out.println("All user count range and commossionerate");
			Result = dao.readUserDetailAllBranch(bean.getJoinCode());	 
			
		}
		else if(!"Commissionerate".equalsIgnoreCase(bean.getBranch()) && !"Range".equalsIgnoreCase(bean.getBranch())  && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
			System.out.println("All user count not range and commossionerate");
			Result = dao.readUserDetailBranchOther(bean.getJoinCode());
			
		}
						
		else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			System.out.println("selected level 1 2 3");
			Result = dao.readUserDetailLevels(bean.getLevel1(), bean.getLevel2(), bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
					
			System.out.println("selected level 1 2 ");
			Result = dao.readUserDetailAllOneTwo(bean.getLevel1(), bean.getLevel2());
			
		}else if( "NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			System.out.println("selected level 3 only");
			Result = dao.readUserDetailAllOneThree( bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			System.out.println("selected level 1 only");
			Result = dao.readUserDetailAllOne(bean.getLevel1());
		}
		return Result;
		
	}
	
	@Override
	@Transactional
	public List<Object> readUserTypeGroupFilterServ(FilterBean bean){
		List<Object> Result = null; 
		
if("NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserTypeCountAll();
			
		}else if(("Commissionerate".equalsIgnoreCase(bean.getBranch()) || "Range".equalsIgnoreCase(bean.getBranch()) ) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserTypeCountAllBranch(bean.getJoinCode());	 
			
		}
		else if(!"Commissionerate".equalsIgnoreCase(bean.getBranch()) && !"Range".equalsIgnoreCase(bean.getBranch())  && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
			
			Result = dao.readUserTypeCountBranchOther(bean.getJoinCode());
			
		}
						
		else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserTypeCountAllLevels(bean.getLevel1(), bean.getLevel2(), bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
					
		
			Result = dao.readUserTypeCountAllOneTwo(bean.getLevel1(), bean.getLevel2());
			
		}else if( "NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserTypeCountAllOneThree( bean.getLevel3());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			Result = dao.readUserTypeCountAllOne(bean.getLevel1());
		}
	
		
		return Result;
	}
	
	
}
