package com.mrsac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsac.bean.UnitManagementBean;
import com.mrsac.dao.UnitManagementDao;

@Service
public class UnitManagementServiceImpl implements UnitManagementService{

	@Autowired
	UnitManagementDao dao;
	
	@Override
	@Transactional
	public UnitManagementBean saveRoneRecordServ(UnitManagementBean bean,String mode) {
		UnitManagementBean result = null;
		try {
			
			result = dao.save(bean);
			
			if(mode.equalsIgnoreCase("update")) {
				dao.rone_update_sync(bean.getId());
			}
		}catch(Exception e) {
			System.out.println("Exception in UnitManagementServiceImpl in saveRoneRecordServ()="+e);
		}
		return result;
	}
	
	@Override
	@Transactional
	public List<UnitManagementBean> getRoneAllRecordsServ() {
		
		return dao.findAll();
	}
	
	@Override
	@Transactional
	public UnitManagementBean getRoneRecordByIdServ(int id) {
		return dao.getRecordById(id);		
	}
	
	@Override
	@Transactional
	public String deleteRoneRecordServ(int id) {
		String result = "false";
		try {
			
			dao.deleteById(id);
			dao.rone_delete_sync(id);
			result = "true";
		}catch(Exception e) {
			System.out.println("Exception in UnitManagementServiceImpl in deleteRoneRecordServ()="+e);
		}
		return result;
	}
	
	public String getUnitNameByLevelThreeServ(String level3) {
		return dao.getUnitNameByLevelThree(level3);
		
	}
	
}
