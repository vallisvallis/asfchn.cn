package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.FeeTypeMapper;
import com.mengmaclub.model.FeeType;
import com.mengmaclub.service.FeeTypeService;
@Service
public class FeeTypeServiceImpl implements FeeTypeService {
@Autowired
	private FeeTypeMapper feetypeMapper;
	public int deleteByPrimaryKey(Integer id) {
		
		return feetypeMapper.deleteByPrimaryKey(id);
	}

	public int insert(FeeType record) {
		
		return feetypeMapper.insert(record);
	}

	public int insertSelective(FeeType record) {
		
		return feetypeMapper.insertSelective(record);
	}

	public FeeType selectByPrimaryKey(Integer id) {
		
		return feetypeMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(FeeType record) {
		
		return feetypeMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(FeeType record) {
		
		return feetypeMapper.updateByPrimaryKey(record);
	}

	public List<FeeType> findAll() {
		
		return feetypeMapper.findAll();
	}

}
