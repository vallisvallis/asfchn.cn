package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.Match;

public interface MatchMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Match record);

	int insertSelective(Match record);

	Match selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Match record);

	int updateByPrimaryKeyWithBLOBs(Match record);

	int updateByPrimaryKey(Match record);

	List<Match> findAll();
}