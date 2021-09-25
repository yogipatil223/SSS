package com.mrsac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.ModuleBean;

@Repository
public interface ModuleManageDao extends JpaRepository<ModuleBean, Integer> {

}
