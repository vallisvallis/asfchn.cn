package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.FeeMapper;
import com.mengmaclub.model.Fee;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.service.FeeService;
@Service
public class FeeServiceImpl implements FeeService {
@Autowired
	private FeeMapper feemapper;
	
	public int deleteByPrimaryKey(Integer id) {
		
		return feemapper.deleteByPrimaryKey(id);
	}

	public int insert(Fee record) {
		
		return feemapper.insert(record);
	}

	public int insertSelective(Fee record) {
		
		return feemapper.insertSelective(record);
	}

	public Fee selectByPrimaryKey(Integer id) {
		
		return feemapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(Fee record) {
		
		return feemapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(Fee record) {
		
		return feemapper.updateByPrimaryKey(record);
	}

	public List<Fee> findAll() {
		
		return feemapper.findAll();
	}

	public List<Fee> findOldApply(int team) {
		
		return feemapper.findOldApply(team);
	}

	public List<Fee> findNeedToConfirm() {
		
		return feemapper.findNeedToConfirm();
	}

	public List<Fee> findTeam() {
		
		return feemapper.findTeam();
	}

	public List<Fee> findPeople() {
		
		return feemapper.findPeople();
	}

	@Override
	public List<HxPeople> findThisTeamPeopleWhoIsProToSendHx() {
		// TODO Auto-generated method stub
		return feemapper.findThisTeamPeopleWhoIsProToSendHx();
	}

	@Override
	public List<Fee> findFeeByPeopleId(int peopleId) {
		// TODO Auto-generated method stub
		return feemapper.findFeeByPeopleId(peopleId);
	}

	@Override
	public List<Fee> findNeedToConfirmAboutPeople() {
		// TODO Auto-generated method stub
		return feemapper.findNeedToConfirmAboutPeople();
	}

}
