package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.HxTeamMapper;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;
import com.mengmaclub.service.HxTeamService;

@Service
public class HxTeamServiceImpl implements HxTeamService {

	@Autowired
	private HxTeamMapper hxTeamMapper;

	
	public int deleteByPrimaryKey(Integer id) {

		return hxTeamMapper.deleteByPrimaryKey(id);
	}

	
	public int insert(HxTeam record) {

		return hxTeamMapper.insert(record);
	}

	
	public int insertSelective(HxTeam record) {

		return hxTeamMapper.insertSelective(record);
	}

	
	public HxTeam selectByPrimaryKey(Integer id) {

		return hxTeamMapper.selectByPrimaryKey(id);
	}

	
	public int updateByPrimaryKeySelective(HxTeam record) {

		return hxTeamMapper.updateByPrimaryKeySelective(record);
	}

	
	public int updateByPrimaryKey(HxTeam record) {

		return hxTeamMapper.updateByPrimaryKey(record);
	}

	
	public List<HxTeam> findAll() {

		return hxTeamMapper.findAll();
	}


	public int showNum() {
		
		return hxTeamMapper.showNum();
	}


	public List<HxTeam> findWhofeed() {
		
		return hxTeamMapper.findWhofeed();
	}


	public int updateByPrimaryKeyWithBLOBs(HxTeam record) {
		
		return hxTeamMapper.updateByPrimaryKeyWithBLOBs(record);
	}


	public List<HxTeam> findFlyTeam() {
		
		return hxTeamMapper.findFlyTeam();
	}


	public List<HxTeam> findTrainTeam() {
		
		return hxTeamMapper.findTrainTeam();
	}


	public List<HxPeople> findPeopleThisTeam(int id) {
		
		return hxTeamMapper.findPeopleThisTeam( id);
	}


	public List<HxTeam> findNotPay() {
		// TODO Auto-generated method stub
		return hxTeamMapper.findNotPay();
	}


	public List<HxPeople> findPeopleThisTeamWhoPay(int blongteam) {
		// TODO Auto-generated method stub
		return hxTeamMapper.findPeopleThisTeamWhoPay(blongteam);
	}


	public List<HxPeople> findPeopleThisTeamWhoNotPay(int blongteam) {
		// TODO Auto-generated method stub
		return hxTeamMapper.findPeopleThisTeamWhoNotPay(blongteam);
	}

}
