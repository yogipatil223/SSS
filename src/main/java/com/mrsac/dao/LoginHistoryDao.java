package com.mrsac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.ModuleHitsUserBean;

@Repository
public interface LoginHistoryDao extends JpaRepository<ModuleHitsUserBean, Long> {

}
