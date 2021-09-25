package com.mrsac.service;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsac.bean.FilterBean;
import com.mrsac.bean.ModPermissionBean;
import com.mrsac.bean.ModuleBean;
import com.mrsac.bean.UsersBean;
import com.mrsac.dao.ModPermissionDao;

@Service
public class ModPermissionServiceImpl implements ModpermissionService {

	@Autowired
	ModPermissionDao dao;
	
	@Override
	@Transactional
	public String saveModPermission(ModPermissionBean bean) {
		String res = "false";
		ModPermissionBean result = dao.save(bean);
		if(result.getMod_id() > 0) {
			res = "true";
		}
	
		return res;
	}
	
	@Override
	@Transactional
	public List<ModPermissionBean> getModPermissionDataServ(String applier_id){
		return dao.getModPermissionData(applier_id);
	}
	
	@Override
	@Transactional
	public ModPermissionBean getDataBypermIdServ(long permId) {
		return dao.getdataById(permId);
	}
	
	@Override
	@Transactional
	public String deleteDataById(long permId) {
		String result = "false";
		try {
			dao.deleteDataById(permId);
			result = "true";
		}catch(Exception e) {
			System.out.println();
		}
		return result;
	}
	
//	@Override
//	@Transactional
//	public int isRecordAvailable(String sevarthNum , int mod_id) {
//		return dao.isRecordAvailable(sevarthNum, mod_id)(sevarthNum, mod_id);
//	}
	@Override
	@Transactional
	public int isRecordAvailable(int sevarthNum , int mod_id) {
		return dao.isRecordAvailable(sevarthNum, mod_id);
	}
	
//	@Override
//	@Transactional
//	public List<ModPermissionBean> getDataModuleEntryByUserServ(String sevarthNum){
//		return dao.getDataModuleEntryByUser(sevarthNum);
//	}
	
	@Override
	@Transactional
	public List<ModPermissionBean> getDataViewByUserServ(String sevarthNum){
		return dao.getDataViewByUser(sevarthNum);
	}
	
//	@Override
//	@Transactional
//	public List<ModPermissionBean> getDataValidationByUserServ(String sevarthNum){
//		return dao.getDataValidationByUser(sevarthNum);
//	}
	
	@Override
	@Transactional
	public List<ModPermissionBean> getModuleBysevarthIdServ(String sevarthId){
		return dao.getModuleBysevarthId(sevarthId);
	}
	
	@Override
	@Transactional
	public List<ModPermissionBean> getPermiByModIdServ(int modid){
		return dao.getPermiByModId(modid);
	}
	
	
	@Override
	@Transactional
	public String  getUsrIdByFilterServ(FilterBean bean){
		List<Integer> result = null;
		String modPermissionResult = "false";
		try {
			
			if("NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
				result = dao.getAllUsrId(bean.getUsr_rank());	
				
				
			}else if(("Commissionerate".equalsIgnoreCase(bean.getBranch()) || "Range".equalsIgnoreCase(bean.getBranch()) ) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
				result = dao.getUsrIdsByAllBranch(bean.getUsr_rank(),bean.getJoinCode());
				
				
			}
				else if(!"Commissionerate".equalsIgnoreCase(bean.getBranch()) && !"Range".equalsIgnoreCase(bean.getBranch())  && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
				result = dao.getUsrIdsByAllBranchOther(bean.getUsr_rank(),bean.getJoinCode(),bean.getJoinCode());
				
				
			}
			
			
			else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
				
				result = dao.getUsrIdsByAllLevels(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2(), bean.getLevel3());
				
				
			}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
				result = dao.getUsrIdsByAllLevelOneTwo(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2());
				
				
			}else if( "NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
				
				result = dao.getUsrIdsByAllLevelOneThree(bean.getUsr_rank(),  bean.getLevel3());
				
				
			}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
				
				result = dao.getUsrIdsByAllLevelOne(bean.getUsr_rank(), bean.getLevel1());
				
			}
			
			modPermissionResult =	insertUpdatePermission(result ,  bean);
//		if("true".equalsIgnoreCase(response)) {
//			
//		if("NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
//				
//					
//				modPermissionResult = dao.getAllRankPermission(bean.getUsr_rank());
//				
//			}else if(!"NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
//				
//				
//				modPermissionResult = dao.getModPermByAllBranch(bean.getUsr_rank(),bean.getJoinCode(), bean.getMod_id());
//				
//			}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
//				
//				
//				modPermissionResult = dao.getPermByAllLevels(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2(), bean.getLevel3(), bean.getMod_id());
//				
//			}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
//				
//				
//				modPermissionResult = dao.getModPerByLevelOneTwo(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2(), bean.getMod_id());
//				
//			}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
//				
//				
//				modPermissionResult = dao.getModPerByLevelOneThree(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel3(), bean.getMod_id());
//				
//			}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
//				
//				
//				modPermissionResult = dao.getModPermByLevelOne(bean.getUsr_rank(), bean.getLevel1(), bean.getMod_id());
//			}
//			
//		}
			
			
		}catch(Exception e){
			System.out.println("Exception in ModPermissionDao in getUsrIdByFilterServ="+e);
		}
		return modPermissionResult;
	}
	
	
	
	public String insertUpdatePermission(List<Integer> userIdList , FilterBean bean) {
		String result = "false";
		try {
		for(int i = 0 ; i < userIdList.size() ; i++) {
			ModPermissionBean modBean =  new ModPermissionBean();
			System.out.println(userIdList.get(i)+"==="+bean.getMod_id());
			 String isValAvailable = dao.RecordAvailableIds(userIdList.get(i), bean.getMod_id());
			
			 Date date  = new Date();
			 if(isValAvailable !=null) {
				 
				 System.out.println("not null");
				 modBean.setPr_id(Integer.parseInt(isValAvailable));
				 modBean.setSevarthnum(userIdList.get(i));
				 modBean.setMod_id( bean.getMod_id());
				 modBean.setPer_view(bean.getPer_view());	
				 modBean.setPer_validate(bean.getPer_validate());	
				 modBean.setPer_dataentry(bean.getPer_dataentry());
				 modBean.setPer_desk(bean.getDeskOfficer());
				 modBean.setPer_gis(bean.getGisViewer()); 
			     modBean.setApplied_by(bean.getApplied_by());		
				 modBean.setApplied_on(date.toString());   
				    	
				 dao.save(modBean);
			 }else {
								 
				 modBean.setSevarthnum(userIdList.get(i));				
				 modBean.setMod_id( bean.getMod_id());				 
				 modBean.setPer_view(bean.getPer_view());	
				 modBean.setPer_validate(bean.getPer_validate());	
				 modBean.setPer_dataentry(bean.getPer_dataentry());
				 modBean.setPer_desk(bean.getDeskOfficer());
				 modBean.setPer_gis(bean.getGisViewer()); 
			     modBean.setApplied_by(bean.getApplied_by());		
				 modBean.setApplied_on(date.toString());   
				    					
				 dao.save(modBean);
		
			 }
			 result = "true";
			
		}
		}catch(Exception e) {
			System.out.println("Exception in modPermissionServiceImpl()="+e);
			result = "false";
		}
		
		return result;
	}
	
	
	@Override
	@Transactional
	public List<ModPermissionBean> updatedUserListServ(FilterBean bean){
		
		List<ModPermissionBean> modPermissionResult = null; 
		
		if("NULL".equalsIgnoreCase(bean.getBranch()) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			modPermissionResult = dao.getAllRankPermission(bean.getUsr_rank(),bean.getMod_id());
			
		}else if(("Commissionerate".equalsIgnoreCase(bean.getBranch()) || "Range".equalsIgnoreCase(bean.getBranch()) ) && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			modPermissionResult = dao.getModPermByAllBranch(bean.getUsr_rank(),bean.getJoinCode(), bean.getMod_id());
			
		}
		else if(!"Commissionerate".equalsIgnoreCase(bean.getBranch()) && !"Range".equalsIgnoreCase(bean.getBranch())  && "NULL".equalsIgnoreCase(bean.getLevel1()) && "NULL".equalsIgnoreCase(bean.getLevel2()) && "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			modPermissionResult = dao.getModPermByAllBranchOther(bean.getUsr_rank(),bean.getJoinCode(), bean.getMod_id(),bean.getJoinCode());
			
			
		}
				
		else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			modPermissionResult = dao.getPermByAllLevels(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2(), bean.getLevel3(), bean.getMod_id());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  !"NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			modPermissionResult = dao.getModPerByLevelOneTwo(bean.getUsr_rank(), bean.getLevel1(), bean.getLevel2(), bean.getMod_id());
			
		}else if( "NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  !"NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			modPermissionResult = dao.getModPerByLevelOneThree(bean.getUsr_rank(), bean.getLevel3(), bean.getMod_id());
			
		}else if( !"NULL".equalsIgnoreCase(bean.getLevel1()) &&  "NULL".equalsIgnoreCase(bean.getLevel2()) &&  "NULL".equalsIgnoreCase(bean.getLevel3())) {
			
			
			modPermissionResult = dao.getModPermByLevelOne(bean.getUsr_rank(), bean.getLevel1(), bean.getMod_id());
		}
		
		return modPermissionResult;
		
	}
	
	

	@Override
	@Transactional
	public String saveUserPermBySelectServ(List<ModPermissionBean> beanArr) {
		
		String result = "false";
		try {
			for(int i = 0 ; i<beanArr.size();i++) {
				ModPermissionBean bean = new ModPermissionBean();
				bean = beanArr.get(i);
				 Date date  = new Date();				 
				bean.setApplied_on(date.toString());
				String pr_id = dao.RecordAvailableIds(bean.getSevarthnum(), bean.getMod_id());
				 if(pr_id != null) {
					 bean.setPr_id(Integer.parseInt(pr_id));
				 }
				 dao.save(bean);
			}
			result = "true";
						
		}catch(Exception e) {
			System.out.println("Exception in ModPermServiceImpl in saveUserPermBySelect()="+e);
		}
		return result;
	}
	
	@Override
	@Transactional
	public List<String> getModuleByUserIdServ(int userId){
		
		return dao.getModuleByUserId(userId);
	}
	
}
