package com.mrsac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsac.bean.ModuleBean;
import com.mrsac.dao.ModuleManageDao;

@Service
public class ModuleManageServiceImpl implements ModuleManageService{

	@Autowired
	ModuleManageDao dao;
	
	@Override
	@Transactional
	public String saveModuleServ(ModuleBean bean) {
		String result = "false";
		ModuleBean res = dao.save(bean);
		if(res.getModule_id() > 0) {
			result = "true";
		}
		return result;
	}
	
	@Override
	@Transactional
	public List<ModuleBean> getModuledata(){		
		return dao.findAll();
	}
	
	@Override
	@Transactional
	public String deleteModule(int mod_id) {
		String result= "false";
		try {
			dao.deleteById(mod_id);
			result = "true";
		}catch(Exception e) {
			System.out.println("Exception in ModuleManageServiceImpl in deleteModule()="+e);
		}
		return result;
	}
	
}
