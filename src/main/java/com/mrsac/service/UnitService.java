package com.mrsac.service;

import java.util.List;

import org.springframework.data.repository.query.Param;

import com.mrsac.bean.UnitsBean;

public interface UnitService {

	public List<UnitsBean> getBranchesServ();
	public List<UnitsBean> getDataForFirstLevel(String branch);
	public List<UnitsBean> getDataForSecondLevel(String level1,String branch );
	public List<UnitsBean> getPoliceStationServ(@Param("level2") String level2 );
}
