package com.mrsac.service;

import java.util.List;

import com.mrsac.bean.UnitManagementBean;

public interface UnitManagementService {
	
	public UnitManagementBean saveRoneRecordServ(UnitManagementBean bean ,String mode);
	public List<UnitManagementBean> getRoneAllRecordsServ();
	public UnitManagementBean getRoneRecordByIdServ(int id);
	public String deleteRoneRecordServ(int id);
	public String getUnitNameByLevelThreeServ(String level3);
}
