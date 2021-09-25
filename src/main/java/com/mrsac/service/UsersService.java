package com.mrsac.service;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.data.repository.query.Param;

import com.mrsac.bean.FilterBean;

import com.mrsac.bean.UsersBean;

public interface UsersService {

	public List<String> readUsersList();
	public UsersBean getSpecificUserServ(String sevarth_no, String password);
	public UsersBean getDetailByMobileNumServ(String sevarth_no);
	public String updatePasswordServ(String mobileNum , String password);
	public int getUserIdByNameServ(String sevarthNum);
	public UsersBean saveUserServ(UsersBean bean) throws JSONException, IOException;
	public List<UsersBean> getSevarthNumServ( String creatorSevarthNum);
	public List<UsersBean> getuserBySevarthServ( String sevarthNum);
	public UsersBean getDetailBySevarthServ( String sevarthNum, String oldpaaword );
	public int getMaxRankValueServ(String usr_rank);
	public int getVisitCodeStatusServ(String userid);
	public String updateProfileCodeServ(String userId,String profileCode, String newPassword);
	public String getProfileCodeServ( String userId, String profileCode);
	public String resetUsrPasswordServ( String profile_code, String password ,  int user_id );
	public List<UsersBean> getUsersByBranchWiseServ(FilterBean bean);
	public List<UsersBean> readUsersFromAdminServ(String userType);
	public List<Object> readUserCountFilterServ(FilterBean bean);
	public List<Object[]> getUserInfoFilterServ(FilterBean bean);
	public List<Object> readUserTypeGroupFilterServ(FilterBean bean);
}
