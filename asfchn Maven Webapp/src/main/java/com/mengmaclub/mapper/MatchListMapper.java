package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.MatchList;

public interface MatchListMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(MatchList record);

	int insertSelective(MatchList record);

	MatchList selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(MatchList record);

	int updateByPrimaryKeyWithBLOBs(MatchList record);

	int updateByPrimaryKey(MatchList record);

	List<MatchList> findAll();
}