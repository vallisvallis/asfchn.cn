package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.MatchListMapper;
import com.mengmaclub.model.MatchList;
import com.mengmaclub.service.MatchListService;
@Service
public class MatchListServiceImpl implements MatchListService {
	@Autowired
	private MatchListMapper matchListMapper;
	
	public int deleteByPrimaryKey(Integer id) {
		
		return matchListMapper.deleteByPrimaryKey(id);
	}

	public int insert(MatchList record) {
		
		return matchListMapper.insert(record);
	}

	public int insertSelective(MatchList record) {
		
		return matchListMapper.insertSelective(record);
	}

	public MatchList selectByPrimaryKey(Integer id) {
		
		return matchListMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(MatchList record) {
		
		return matchListMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(MatchList record) {
		
		return matchListMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(MatchList record) {
		
		return matchListMapper.updateByPrimaryKey(record);
	}

	public List<MatchList> findAll() {
		
		return matchListMapper.findAll();
	}

}
