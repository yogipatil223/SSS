package com.mrsac.dao;

import java.util.LinkedList;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.ModPermissionBean;

import com.mrsac.bean.UsersBean;

@Repository
public interface UsersDao extends JpaRepository<UsersBean, Integer> {

//	@Query(value="select * from master_sss_users where rank_status = 1 OR user_type ='Module Admin' or user_type='Super Admin' order by priority ",nativeQuery = true)
	@Query(value="select sevarth_no from master_sss_users  order by priority ",nativeQuery = true)
	public List<String> getUserDetails();
	
	@Query(value="select * from master_sss_users where (sevarth_no = :sevarth_no or sevarth_id =:sevarth_no ) and password = :password and status = 'enable' ",nativeQuery = true)
	public UsersBean getSpecificUser(@Param("sevarth_no") String sevarth_no , @Param("password") String password);
	
	@Query(value="select * from master_sss_users where sevarth_no =:sevarth_no", nativeQuery = true)
	public UsersBean getDetailByMobileNum(@Param("sevarth_no") String sevarth_no );
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update master_sss_users set password =:password where sevarth_no =:mobile_num" ,nativeQuery = true)
	public void updateUsrPassword(@Param("mobile_num") String mobile_num,@Param("password") String password);
	
	@Query(value="select a.usrid from master_sss_users a where sevarth_no =:sevarthnum" , nativeQuery=true)
	public int getUserIdByName(@Param("sevarthnum") String sevarthnum);
	
	//select * from master_sss_users where creator_name =:creatorSevarthNum
	@Query(value = "select * from master_sss_users " , nativeQuery = true)
	public List<UsersBean> getSevarthNum(@Param("creatorSevarthNum") String creatorSevarthNum);
	
	
	
	//read user by the user type
	@Query(value = "select * from master_sss_users where user_type in ('Module Admin','Unit User','GIS Viewer','Desk Officer','Viewer')" , nativeQuery = true)
	public List<UsersBean> readUserFromModuleAdmin();
	
	@Query(value = "select * from master_sss_users where user_type in ('Unit User','Viewer','Data Entry Operator')" , nativeQuery = true)
	public List<UsersBean> readUserFromUnitAdmin();
	
	@Query(value = "select * from master_sss_users where user_type in ('Module Admin','GIS Viewer','Desk Officer','Super Admin')" , nativeQuery = true)
	public List<UsersBean> readUserFromSuperAdmin();
	
	
	//-------------------------------
	
	@Query(value = "select * from master_sss_users where sevarth_no =:sevarthNum" , nativeQuery = true)
	public List<UsersBean> getuserBySevarth(@Param("sevarthNum") String sevarthNum);
	
	@Query(value = "select usr_id from master_sss_users where sevarth_no =:sevarthNum" , nativeQuery = true)
	public int getUserIdBySevarth(@Param("sevarthNum") String sevarthNum );
	
	@Query(value="select * from master_sss_users where sevarth_no =:sevarthNum and password = :oldpaaword", nativeQuery = true)
	public UsersBean getDetailBySevarth(@Param("sevarthNum") String sevarthNum ,@Param("oldpaaword") String oldpaaword);
	
	@Query(value="select max(priority) from master_sss_users where usr_rank =:usr_rank", nativeQuery = true)
	public int getMaxRankValue(@Param("usr_rank") String usr_rank);
	
	@Query(value="select visit_status from master_sss_users where  (sevarth_no = :userid or sevarth_id =:userid ) ", nativeQuery = true)
	public int getVisitCodeStatus(@Param("userid") String userid);
	
	@Modifying(clearAutomatically = true)
	@Query(value="update master_sss_users set password =:newPassword ,profile_code=:profileCode,visit_status = 1   where  (sevarth_no = :userId or sevarth_id =:userId ) ", nativeQuery = true)
	public void updateProfileCode(@Param("userId") String userId,@Param("profileCode") String profileCode, @Param("newPassword") String newPassword );
	
	@Query(value="select profile_code from master_sss_users where  (sevarth_no = :userId or sevarth_id =:userId ) and profile_code = :profileCode  ", nativeQuery = true)
	public String getProfileCode(@Param("userId") String userId,@Param("profileCode") String profileCode);
	
	
	@Modifying(clearAutomatically = true)
	@Query(value = "update master_sss_users set password =:password ,profile_code = :profile_code, visit_status = 0   where usrid =:user_id" ,nativeQuery = true)
	public void resetUsrPassword(@Param("profile_code") String profile_code,@Param("password") String password , @Param("user_id") int user_id );
	
	// module bulk permission
	
	@Query(value="SELECT * FROM  master_sss_users b  where b.usr_rank =:usr_rank ", nativeQuery = true)
	public List<UsersBean> getAllUserDetail(@Param("usr_rank") String usr_rank  );
		
	
	@Query(value="SELECT * FROM  master_sss_users b  where b.usr_rank =:usr_rank  and b.level1 like :joinCode% ", nativeQuery = true)
	public List<UsersBean> getUsersAllBranch(@Param("usr_rank") String usr_rank,@Param("joinCode") String joinCode );
	
	@Query(value="SELECT * FROM  master_sss_users b  where b.usr_rank =:usr_rank  and (b.level3 like %:joinCode% OR b.level3 like :joinCodeTwo%  ) ", nativeQuery = true)
	public List<UsersBean> getUsersAllBranchOther(@Param("usr_rank") String usr_rank,@Param("joinCode") String joinCode , @Param("joinCodeTwo") String joinCodeTwo );
	
	
	
	@Query(value="SELECT * FROM  master_sss_users b    where b.usr_rank =:usr_rank  and b.level1 = :level1 and b.level2 = :level2 and b.level3 = :level3 ", nativeQuery = true)
	public List<UsersBean> getUsersAllLevels(@Param("usr_rank") String usr_rank,@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3  );
	
	
	
	@Query(value="SELECT * FROM  master_sss_users b   where b.usr_rank =:usr_rank  and b.level1 = :level1 and b.level2 = :level2 ", nativeQuery = true)
	public List<UsersBean> getUsersLevelOneTwo(@Param("usr_rank") String usr_rank,@Param("level1") String level1,@Param("level2") String level2  );
	
	
	
	@Query(value="SELECT * FROM  master_sss_users b   where b.usr_rank =:usr_rank   and b.level3 = :level3 ", nativeQuery = true)
	public List<UsersBean> getUsersLevelOneThree(@Param("usr_rank") String usr_rank,@Param("level3") String level3  );
	
	
	
	@Query(value="SELECT * FROM  master_sss_users b    where b.usr_rank =:usr_rank  and b.level1 = :level1", nativeQuery = true)
	public List<UsersBean> getUsersLevelOne(@Param("usr_rank") String usr_rank,@Param("level1") String level1  );
	
	//------------------ user count ------
	
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', usr_rank,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 GROUP BY a.usr_rank , a.level3 ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserCountAll();
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf,b.ps_name) AS 'level3', usr_rank,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1 like :joinCode% GROUP BY a.usr_rank , a.level3 ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserCountAllBranch(@Param("joinCode") String joinCode);
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', usr_rank,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level3 like :joinCode% GROUP BY a.usr_rank , a.level3 ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserCountBranchOther(@Param("joinCode") String joinCode);
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', usr_rank,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1 and a.level2=:level2 and a.level3 =:level3  GROUP BY a.usr_rank  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserCountAllLevels(@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' ,b.cp_sp_rpf, b.ps_name) AS 'level3', usr_rank,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1 and a.level2=:level2   GROUP BY a.usr_rank , a.level3 ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserCountAllOneTwo(@Param("level1") String level1,@Param("level2") String level2 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', usr_rank,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level3=:level3   GROUP BY a.usr_rank  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserCountAllOneThree(@Param("level3") String level3 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', usr_rank,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1   GROUP BY a.usr_rank, a.level3  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserCountAllOne(@Param("level1") String level1 );
	//--------------------------
	
	// user detail filterwise , also used to get Assigned modules
	
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3',a.usr_rank,a.first_name,a.middle_name,a.last_name,sevarth_id,mobile_num,a.user_type,a.usrid  FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object[]> readUserDetailAll();
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3',a.usr_rank,a.first_name,a.middle_name,a.last_name,sevarth_id,mobile_num,a.user_type,a.usrid  FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1 like :joinCode%   ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object[]> readUserDetailAllBranch(@Param("joinCode") String joinCode);
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3',a.usr_rank, a.first_name,a.middle_name,a.last_name,sevarth_id,mobile_num,a.user_type,a.usrid  FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level3 like :joinCode%   ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object[]> readUserDetailBranchOther(@Param("joinCode") String joinCode);
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3',a.usr_rank,  a.first_name,a.middle_name,a.last_name,sevarth_id,mobile_num,a.user_type,a.usrid  FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1 and a.level2=:level2 and a.level3 =:level3  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object[]> readUserDetailLevels(@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' ,b.cp_sp_rpf, b.ps_name) AS 'level3',a.usr_rank,   a.first_name,a.middle_name,a.last_name,sevarth_id,mobile_num,a.user_type,a.usrid  FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1 and a.level2=:level2   ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object[]> readUserDetailAllOneTwo(@Param("level1") String level1,@Param("level2") String level2 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3',a.usr_rank,  a.first_name,a.middle_name,a.last_name,sevarth_id,mobile_num,a.user_type,a.usrid  FROM master_sss_users a,master_unit_table_r1 b WHERE    a.level3 = b.Level3 and a.level3=:level3     ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object[]> readUserDetailAllOneThree(@Param("level3") String level3 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3',a.usr_rank,  a.first_name,a.middle_name,a.last_name,sevarth_id,mobile_num,a.user_type,a.usrid  FROM master_sss_users a,master_unit_table_r1 b WHERE    a.level3 = b.Level3 and a.level1=:level1  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object[]> readUserDetailAllOne(@Param("level1") String level1 );
	
	
	//user detail group by usertype
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', a.user_type,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 GROUP BY a.user_type , a.level3 ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserTypeCountAll();
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', a.user_type,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1 like :joinCode% GROUP BY a.user_type , a.level3 ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserTypeCountAllBranch(@Param("joinCode") String joinCode);
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', a.user_type,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level3 like :joinCode% GROUP BY a.user_type, a.level3  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserTypeCountBranchOther(@Param("joinCode") String joinCode);
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', a.user_type,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1 and a.level2=:level2 and a.level3 =:level3  GROUP BY a.user_type  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserTypeCountAllLevels(@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' ,b.cp_sp_rpf, b.ps_name) AS 'level3', a.user_type,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1 and a.level2=:level2   GROUP BY a.user_type, a.level3  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserTypeCountAllOneTwo(@Param("level1") String level1,@Param("level2") String level2 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', a.user_type,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level3=:level3   GROUP BY a.user_type  ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserTypeCountAllOneThree(@Param("level3") String level3 );
	
	@Query(value="SELECT IF(b.JURISDICTION = 'Commissionarate' OR b.JURISDICTION = 'SP',b.cp_sp_rpf, b.ps_name) AS 'level3', a.user_type,COUNT(*) AS 'priority' FROM master_sss_users a,master_unit_table_r1 b WHERE   a.level3 = b.Level3 and a.level1=:level1   GROUP BY a.user_type , a.level3 ORDER BY a.level3",nativeQuery = true)
	public LinkedList<Object> readUserTypeCountAllOne(@Param("level1") String level1 );
	
	// Assinged user module
	
	
}
