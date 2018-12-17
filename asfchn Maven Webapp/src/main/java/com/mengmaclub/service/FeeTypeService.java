package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.FeeType;

public interface FeeTypeService {
	int deleteByPrimaryKey(Integer id);

	int insert(FeeType record);

	int insertSelective(FeeType record);

	FeeType selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(FeeType record);

	int updateByPrimaryKey(FeeType record);

	List<FeeType> findAll();
}
