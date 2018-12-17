package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.MatchJobMapper;
import com.mengmaclub.model.MatchJob;
import com.mengmaclub.service.MatchJobService;
@Service
public class MatchJobServiceImpl implements MatchJobService {
@Autowired
	private MatchJobMapper matchJobMapper;
	public int deleteByPrimaryKey(Integer id) {
		
		return matchJobMapper.deleteByPrimaryKey(id);
	}

	public int insert(MatchJob record) {
		
		return matchJobMapper.insert(record);
	}

	public int insertSelective(MatchJob record) {
		
		return matchJobMapper.insertSelective(record);
	}

	public MatchJob selectByPrimaryKey(Integer id) {
		
		return matchJobMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(MatchJob record) {
		
		return matchJobMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(MatchJob record) {
		
		return matchJobMapper.updateByPrimaryKey(record);
	}

	public List<MatchJob> findAll() {
		
		return matchJobMapper.findAll();
	}

}
