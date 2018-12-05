package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.MatchGroup;

public interface MatchGroupService {
	int deleteByPrimaryKey(Integer id);

	int insert(MatchGroup record);

	int insertSelective(MatchGroup record);

	MatchGroup selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(MatchGroup record);

	int updateByPrimaryKey(MatchGroup record);

	List<MatchGroup> findAll();
}
