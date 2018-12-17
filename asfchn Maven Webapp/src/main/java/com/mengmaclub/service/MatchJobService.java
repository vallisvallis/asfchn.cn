package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.MatchJob;


public interface MatchJobService {
	  int deleteByPrimaryKey(Integer id);

	    int insert(MatchJob record);

	    int insertSelective(MatchJob record);

	    MatchJob selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(MatchJob record);

	    int updateByPrimaryKey(MatchJob record);
	    List<MatchJob> findAll();
}
