package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.Manager;

public interface ManagerMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Manager record);

	int insertSelective(Manager record);

	Manager selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Manager record);

	int updateByPrimaryKey(Manager record);
	//查看所有管理者
	
	List<Manager> findAll();
}