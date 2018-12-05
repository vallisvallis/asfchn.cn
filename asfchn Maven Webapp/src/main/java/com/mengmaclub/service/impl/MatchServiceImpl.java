package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.MatchMapper;
import com.mengmaclub.model.Match;
import com.mengmaclub.service.MatchService;
@Service
public class MatchServiceImpl implements MatchService {
	@Autowired
	private MatchMapper matchMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		
		return matchMapper.deleteByPrimaryKey(id);
	}

	
	public int insert(Match record) {
		
		return matchMapper.insert(record);
	}

	
	public int insertSelective(Match record) {
		
		return matchMapper.insertSelective(record);
	}

	
	public Match selectByPrimaryKey(Integer id) {
		
		return matchMapper.selectByPrimaryKey(id);
	}

	
	public int updateByPrimaryKeySelective(Match record) {
		
		return matchMapper.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(Match record) {
		
		return matchMapper.updateByPrimaryKey(record);
	}

	
	public List<Match> findAll() {
	
		return matchMapper.findAll();
	}

}
