package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Fee;
import com.mengmaclub.model.HxPeople;

public interface FeeService {
	int deleteByPrimaryKey(Integer id);

	List<Fee> findOldApply( int team);

	int insert(Fee record);

	int insertSelective(Fee record);

	Fee selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Fee record);

	int updateByPrimaryKey(Fee record);
	List<Fee> findNeedToConfirmAboutPeople();
	List<Fee> findAll();
	List<Fee> findNeedToConfirm();
	List<Fee> findTeam();
	List<Fee> findPeople();
	List<HxPeople> findThisTeamPeopleWhoIsProToSendHx();
	List <Fee> findFeeByPeopleId(int peopleId);
}
