package com.mrsac.service;

import java.util.List;

import com.mrsac.bean.ModuleBean;

public interface ModuleManageService {

	public String saveModuleServ(ModuleBean bean);
	public List<ModuleBean> getModuledata();
	public String deleteModule(int mod_id);
}
