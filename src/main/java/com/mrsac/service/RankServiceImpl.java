package com.mrsac.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mrsac.bean.RankBean;
import com.mrsac.dao.RankDao;

@Service
public class RankServiceImpl implements RankService {

	@Autowired
	RankDao dao;
	
	@Transactional
	@Override
	public List<RankBean> getRanks(){
	    return dao.findAll();
	}
	
}
