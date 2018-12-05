package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Match;

public interface MatchService {
	int deleteByPrimaryKey(Integer id);

	int insert(Match record);

	int insertSelective(Match record);

	Match selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Match record);

	int updateByPrimaryKey(Match record);

	List<Match> findAll();
}