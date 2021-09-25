package com.mrsac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.ModPermissionBean;

@Repository
public interface ModPermissionDao extends JpaRepository<ModPermissionBean, Long> {

	
	@Query(value="SELECT * FROM tbl_module_permission WHERE applied_by = :applier_id" , nativeQuery = true)
	public List<ModPermissionBean> getModPermissionData(@Param("applier_id") String applier_id);
	
	@Query(value="SELECT * FROM tbl_module_permission WHERE pr_id = :pr_id" , nativeQuery = true)
	public ModPermissionBean getdataById(@Param("pr_id") long pr_id); 
	
	@Modifying(clearAutomatically = true)
	@Query(value="delete  FROM tbl_module_permission WHERE pr_id = :pr_id" , nativeQuery = true)
	public void deleteDataById(@Param("pr_id") long pr_id);
	
	@Query(value="SELECT count(*) FROM tbl_module_permission WHERE sevarthnum = :sevarthNum and mod_id = :mod_id " , nativeQuery = true)
	public int isRecordAvailable(@Param("sevarthNum") int sevarthNum , @Param("mod_id") int mod_id);
	
	@Query(value="SELECT pr_id FROM tbl_module_permission WHERE sevarthnum = :sevarthNum and mod_id = :mod_id " , nativeQuery = true)
	public String RecordAvailableIds(@Param("sevarthNum") int sevarthNum , @Param("mod_id") int mod_id);
	
//	@Query(value="SELECT * FROM tbl_module_permission a inner join master_module_tbl b on  a.mod_id = b.module_id where b.category='Data Entry' and a.sevarthnum=:sevarthNum and a.per_dataentry = 1 " , nativeQuery = true)
//	public List<ModPermissionBean> getDataModuleEntryByUser(@Param("sevarthNum") String sevarthNum);
	
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_module_tbl b on  a.mod_id = b.module_id where  a.sevarthnum=:sevarthNum " , nativeQuery = true)
	public List<ModPermissionBean> getDataViewByUser(@Param("sevarthNum") String sevarthNum);
	
	
//	@Query(value="SELECT * FROM tbl_module_permission a inner join master_module_tbl b on  a.mod_id = b.module_id where b.category='Data Entry' and a.sevarthnum=:sevarthNum and a.per_validate = 1 " , nativeQuery = true)
//	public List<ModPermissionBean> getDataValidationByUser(@Param("sevarthNum") String sevarthNum);

	@Query(value="SELECT * FROM tbl_module_permission a inner join master_module_tbl b  on a.mod_id = b.module_id where a.sevarthnum = :sevarthNum", nativeQuery = true)
    public List<ModPermissionBean> getModuleBysevarthId(@Param("sevarthNum") String sevarthNum);
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_module_tbl b  on a.mod_id = b.module_id where a.mod_id = :modid", nativeQuery = true)
	public List<ModPermissionBean> getPermiByModId(@Param("modid") int modid);

	// filter queries
	@Query(value="SELECT usrid FROM master_sss_users where usr_rank =:usr_rank ", nativeQuery = true)
	public List<Integer> getAllUsrId(@Param("usr_rank") String usr_rank);
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_sss_users b  on  a.sevarthnum = b.usrid   where b.usr_rank =:usr_rank AND a.mod_id = :mod_id", nativeQuery = true)
	public List<ModPermissionBean> getAllRankPermission(@Param("usr_rank") String usr_rank ,@Param("mod_id") int mod_id );
	
	@Query(value="SELECT usrid FROM master_sss_users where usr_rank =:usr_rank and level1 like :joinCode%", nativeQuery = true)
	public List<Integer> getUsrIdsByAllBranch(@Param("usr_rank") String usr_rank,@Param("joinCode") String joinCode);
	
	
	@Query(value="SELECT usrid FROM master_sss_users where usr_rank =:usr_rank and (level3 like %:joinCode% OR level3 like :joinCodeTwo%)", nativeQuery = true)
	public List<Integer> getUsrIdsByAllBranchOther(@Param("usr_rank") String usr_rank,@Param("joinCode") String joinCode , @Param("joinCodeTwo") String joinCodeTwo);
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_sss_users b  on  a.sevarthnum = b.usrid where b.usr_rank =:usr_rank  and b.level1 like :joinCode% AND a.mod_id = :mod_id", nativeQuery = true)
	public List<ModPermissionBean> getModPermByAllBranch(@Param("usr_rank") String usr_rank,@Param("joinCode") String joinCode , @Param("mod_id") int mod_id );
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_sss_users b  on  a.sevarthnum = b.usrid where b.usr_rank =:usr_rank  and (b.level3 like %:joinCode% OR b.level3 like :joinCodeTwo%  ) AND a.mod_id = :mod_id", nativeQuery = true)
	public List<ModPermissionBean> getModPermByAllBranchOther(@Param("usr_rank") String usr_rank,@Param("joinCode") String joinCode , @Param("mod_id") int mod_id, @Param("joinCodeTwo") String joinCodeTwo );
	
	@Query(value="SELECT usrid FROM master_sss_users where usr_rank =:usr_rank and level1 = :level1 and level2 = :level2 and level3 = :level3 ", nativeQuery = true)
	public List<Integer> getUsrIdsByAllLevels(@Param("usr_rank") String usr_rank,@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3);
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_sss_users b  on  a.sevarthnum = b.usrid  where b.usr_rank =:usr_rank  and b.level1 = :level1 and b.level2 = :level2 and b.level3 = :level3 AND a.mod_id = :mod_id", nativeQuery = true)
	public List<ModPermissionBean> getPermByAllLevels(@Param("usr_rank") String usr_rank,@Param("level1") String level1,@Param("level2") String level2,@Param("level3") String level3 , @Param("mod_id") int mod_id );
	
	@Query(value="SELECT usrid FROM master_sss_users where usr_rank =:usr_rank and level1 = :level1 and level2 = :level2  ", nativeQuery = true)
	public List<Integer> getUsrIdsByAllLevelOneTwo(@Param("usr_rank") String usr_rank,@Param("level1") String level1,@Param("level2") String level2);
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_sss_users b  on  a.sevarthnum =b.usrid  where b.usr_rank =:usr_rank  and b.level1 = :level1 and b.level2 = :level2 AND a.mod_id = :mod_id", nativeQuery = true)
	public List<ModPermissionBean> getModPerByLevelOneTwo(@Param("usr_rank") String usr_rank,@Param("level1") String level1,@Param("level2") String level2 , @Param("mod_id") int mod_id );
	
	@Query(value="SELECT usrid FROM master_sss_users where usr_rank =:usr_rank  and level3 = :level3  ", nativeQuery = true)
	public List<Integer> getUsrIdsByAllLevelOneThree(@Param("usr_rank") String usr_rank,@Param("level3") String level3);
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_sss_users b  on  a.sevarthnum = b.usrid where b.usr_rank =:usr_rank   and b.level3 = :level3 AND a.mod_id = :mod_id", nativeQuery = true)
	public List<ModPermissionBean> getModPerByLevelOneThree(@Param("usr_rank") String usr_rank,@Param("level3") String level3 , @Param("mod_id") int mod_id );
	
	@Query(value="SELECT usrid FROM master_sss_users where usr_rank =:usr_rank and level1 = :level1   ", nativeQuery = true)
	public List<Integer> getUsrIdsByAllLevelOne(@Param("usr_rank") String usr_rank,@Param("level1") String level1);
	
	@Query(value="SELECT * FROM tbl_module_permission a inner join master_sss_users b  on  a.sevarthnum = b.usrid  where b.usr_rank =:usr_rank  and b.level1 = :level1 AND a.mod_id = :mod_id", nativeQuery = true)
	public List<ModPermissionBean> getModPermByLevelOne(@Param("usr_rank") String usr_rank,@Param("level1") String level1 , @Param("mod_id") int mod_id );
	
	/*----without module filters-----*/
	@Query(value="SELECT b.module_name FROM tbl_module_permission a inner join master_module_tbl b  on a.mod_id = b.module_id where a.sevarthnum = :userId", nativeQuery = true)
	public List<String> getModuleByUserId(@Param("userId") int userId);
	
	

	
}
