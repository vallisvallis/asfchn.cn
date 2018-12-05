package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.Matchlist1;

public interface Matchlist1Mapper {
	// 成绩单
	int deleteByPrimaryKey(Integer id);

	// 添加成绩单
	int insert(Matchlist1 record);

	// 添加成绩单
	int insertSelective(Matchlist1 record);

	// 查询单个成绩单
	Matchlist1 selectByPrimaryKey(Integer id);

	// 更新成绩单
	int updateByPrimaryKeySelective(Matchlist1 record);

	// 更新成绩单
	int updateByPrimaryKey(Matchlist1 record);

	//
	List<Matchlist1> listpeoplefindBypeopleid(int id);

	Matchlist1 findByPeople(int peopleid);

	List<Matchlist1> findAll();
}