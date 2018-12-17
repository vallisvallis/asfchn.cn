package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.Matchlist1Mapper;
import com.mengmaclub.model.Matchlist1;
import com.mengmaclub.service.MatchList1Service;
@Service
public class MatchList1ServiceImpl implements MatchList1Service {
	@Autowired
	private Matchlist1Mapper matchlist1Mapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return matchlist1Mapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Matchlist1 record) {
		
		return matchlist1Mapper.insert(record);
	}

	@Override
	public int insertSelective(Matchlist1 record) {
		
		return matchlist1Mapper.insertSelective(record);
	}

	@Override
	public Matchlist1 selectByPrimaryKey(Integer id) {
		
		return matchlist1Mapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Matchlist1 record) {
		
		return matchlist1Mapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Matchlist1 record) {
		
		return matchlist1Mapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Matchlist1> listpeoplefindBypeopleid(int id) {
		// TODO Auto-generated method stub
		return matchlist1Mapper.listpeoplefindBypeopleid(id);
	}

	@Override
	public Matchlist1 findByPeople(int peopleid) {
		// TODO Auto-generated method stub
		return matchlist1Mapper.findByPeople(peopleid);
	}

	@Override
	public List<Matchlist1> findAll() {
		// TODO Auto-generated method stub
		return matchlist1Mapper.findAll();
	}

	

}
