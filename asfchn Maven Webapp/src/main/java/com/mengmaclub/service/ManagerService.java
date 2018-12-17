package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Manager;

public interface ManagerService {
	int deleteByPrimaryKey(Integer id);

	int insert(Manager record);

	int insertSelective(Manager record);

	Manager selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Manager record);

	int updateByPrimaryKey(Manager record);

	List<Manager> findAll();
}
