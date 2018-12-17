package com.mengmaclub.mapper;

import com.mengmaclub.model.Hx;

public interface HxMapper {
	int deleteByPrimaryKey(Integer manager);

	int insert(Hx record);

	int insertSelective(Hx record);

	Hx selectByPrimaryKey(Integer manager);

	int updateByPrimaryKeySelective(Hx record);

	int updateByPrimaryKey(Hx record);
}