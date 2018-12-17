package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.MatchGroupMapper;
import com.mengmaclub.model.MatchGroup;
import com.mengmaclub.service.MatchGroupService;
@Service
public class MatchGroupServiceImpl implements MatchGroupService {
@Autowired
	private MatchGroupMapper matchGroupMapper;
	public int deleteByPrimaryKey(Integer id) {
		
		return matchGroupMapper.deleteByPrimaryKey(id);
	}

	public int insert(MatchGroup record) {
		
		return matchGroupMapper.insert(record);
	}

	public int insertSelective(MatchGroup record) {
		
		return matchGroupMapper.insertSelective(record);
	}

	public MatchGroup selectByPrimaryKey(Integer id) {
		
		return matchGroupMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(MatchGroup record) {
		
		return matchGroupMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MatchGroup record) {
		
		return matchGroupMapper.updateByPrimaryKey(record);
	}

	public List<MatchGroup> findAll() {
		
		return matchGroupMapper.findAll();
	}

}
