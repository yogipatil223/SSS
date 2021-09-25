package com.mrsac.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.UnitsBean;

@Repository
public interface UnitDao extends JpaRepository<UnitsBean, Integer> {

	@Query(value="SELECT * FROM `master_unit_table_r1` WHERE branch != '' GROUP BY branch" , nativeQuery = true)
	public List<UnitsBean>  getBranches();
	
	@Query(value="SELECT * FROM smahapolice.master_unit_table_r1 where  level1 like '%RGCM%' group by level1" , nativeQuery = true)
	public List<UnitsBean> getCommissionerates();
	
	@Query(value="SELECT * FROM smahapolice.master_unit_table_r1 where  level1 like 'RGIG%' group by level1",nativeQuery = true)
	public List<UnitsBean> getRanges();
	
	@Query(value="SELECT * FROM smahapolice.master_unit_table_r1 where branch=:branch",nativeQuery = true)
	public List<UnitsBean> getOthers(@Param("branch") String branch );
	
	@Query(value="SELECT * FROM smahapolice.master_unit_table_r1 where  level1 =:level1 and zone_n !='null'  group by zone_n  ",nativeQuery = true)
	public List<UnitsBean> getZones(@Param("level1") String level1 );
	
	@Query(value="SELECT *  FROM smahapolice.master_unit_table_r1  where level1 =:level1 group by dtename ",nativeQuery = true)
	public List<UnitsBean> getdistrict(@Param("level1") String level1 );
	
	@Query(value="SELECT *  FROM smahapolice.master_unit_table_r1  where level2 =:level2 group by ps_name ",nativeQuery = true)
	public List<UnitsBean> getPoliceStation(@Param("level2") String level2 );
	
	
}
