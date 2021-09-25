package com.mrsac.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mrsac.bean.RankBean;

@Repository
public interface RankDao extends JpaRepository<RankBean,Integer> {

}
