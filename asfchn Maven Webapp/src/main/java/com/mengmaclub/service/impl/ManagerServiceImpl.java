package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.ManagerMapper;
import com.mengmaclub.model.Manager;
import com.mengmaclub.service.ManagerService;
@Service
public class ManagerServiceImpl implements ManagerService {
	@Autowired
	private ManagerMapper managerMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		
		return managerMapper.deleteByPrimaryKey(id);
	}

	public int insert(Manager record) {
		
		return managerMapper.insert(record);
	}

	public int insertSelective(Manager record) {
		
		return managerMapper.insertSelective(record);
	}

	public Manager selectByPrimaryKey(Integer id) {
		
		return managerMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Manager record) {
		
		return managerMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Manager record) {
		
		return managerMapper.updateByPrimaryKey(record);
	}

	public List<Manager> findAll() {
		
		return managerMapper.findAll();
	}

}
