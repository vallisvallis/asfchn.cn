package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Referee;

public interface RefereeService {
	
	int deleteByPrimaryKey(Integer id);

	int insert(Referee record);

	int insertSelective(Referee record);

	Referee selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Referee record);

	int updateByPrimaryKey(Referee record);
	
	List<Referee> findAll();
}
