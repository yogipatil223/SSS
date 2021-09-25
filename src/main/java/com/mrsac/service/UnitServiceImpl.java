package com.mrsac.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import com.mrsac.bean.UnitsBean;
import com.mrsac.dao.UnitDao;

@Service
public class UnitServiceImpl implements UnitService {

	@Autowired
	UnitDao dao;
	
	@Override
	@Transactional
	public List<UnitsBean> getBranchesServ(){
		return dao.getBranches();
	}
	
	@Override
	@Transactional
	public List<UnitsBean> getDataForFirstLevel(String branch){
		List<UnitsBean> result = new ArrayList<UnitsBean>();	
		try {
			if(branch.equalsIgnoreCase("Commissionerate")) {
				result = dao.getCommissionerates();
			}else if(branch.equalsIgnoreCase("Range")) {
				result = dao.getRanges();
			}else{
				result = dao.getOthers(branch);
			}			
		}catch(Exception e) {
			System.out.println("Exception in UnitServiceImpl in getDataForFirstLevel()= "+e);
		}		
		return result;
	}
	
	@Override
	@Transactional
	public List<UnitsBean> getDataForSecondLevel(String level1,String branch ){
		List<UnitsBean> result = new ArrayList<UnitsBean>();	
		try {
			if(branch.equalsIgnoreCase("Commissionerate")) {
				result = dao.getZones(level1);
			}else if(branch.equalsIgnoreCase("Range")) {
				result = dao.getdistrict(level1);
			}
			
		}catch(Exception e) {
			System.out.println("Exception in UnitServiceImpl in getDataForSecondLevel()= "+e);
		}
		return result;
	}
	
	@Override
	@Transactional
	public List<UnitsBean> getPoliceStationServ(String level2){
		return dao.getPoliceStation(level2);
	}
	
}
