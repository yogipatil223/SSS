package com.mrsac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.query.Procedure;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.UnitManagementBean;

@Repository
public interface UnitManagementDao extends JpaRepository<UnitManagementBean,Integer> {

	@Procedure(name = "rone_update_sync")
    void rone_update_sync(@Param("ids") int ids);
	
	@Query(value = "select * from master_unit_table_r1 where id=:id",nativeQuery = true)
	public UnitManagementBean getRecordById(@Param("id") int id);
	
	@Procedure(name = "rone_delete_sync")
    void rone_delete_sync(@Param("ids") int ids);

	@Query(value="select if(cp_sp_rpf = '' or cp_sp_rpf is NULL,ps_name,cp_sp_rpf ) as unit from master_unit_table_r1 where level3 = :level3 limit 0,1", nativeQuery = true)
	public String getUnitNameByLevelThree(@Param("level3") String level3);
	
}
