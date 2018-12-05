package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Matchlist1;

public interface MatchList1Service {
	  int deleteByPrimaryKey(Integer id);

	    int insert(Matchlist1 record);

	    int insertSelective(Matchlist1 record);

	    Matchlist1 selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Matchlist1 record);

	    int updateByPrimaryKey(Matchlist1 record);
	    List<Matchlist1> listpeoplefindBypeopleid(int id);
	   
	    List<Matchlist1> findAll();
		Matchlist1 findByPeople(int peopleid);
		
}
