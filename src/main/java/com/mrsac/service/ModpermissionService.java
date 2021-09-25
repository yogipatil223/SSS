package com.mrsac.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mrsac.bean.FilterBean;
import com.mrsac.bean.ModPermissionBean;

public interface ModpermissionService {

	public String saveModPermission(ModPermissionBean bean);
	public List<ModPermissionBean> getModPermissionDataServ(String applier_id);
	public ModPermissionBean getDataBypermIdServ(long permId);
	public String deleteDataById(long permId);
	//public int isRecordAvailable(String sevarthNum , int mod_id);
	//public List<ModPermissionBean> getDataModuleEntryByUserServ(String sevarthNum);
	public List<ModPermissionBean> getDataViewByUserServ(String sevarthNum);
	//public List<ModPermissionBean> getDataValidationByUserServ(String sevarthNum);
	public List<ModPermissionBean> getModuleBysevarthIdServ(String sevarthId);
	public List<ModPermissionBean> getPermiByModIdServ(int modid);
	public int isRecordAvailable(int sevarthnum, int mod_id);
	public String  getUsrIdByFilterServ(FilterBean bean);
	public List<ModPermissionBean> updatedUserListServ(FilterBean bean);
	public String saveUserPermBySelectServ(List<ModPermissionBean> beanArr);
	public List<String> getModuleByUserIdServ(int userId);
}
