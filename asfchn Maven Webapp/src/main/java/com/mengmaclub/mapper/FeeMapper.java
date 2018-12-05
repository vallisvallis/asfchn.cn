package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.Fee;
import com.mengmaclub.model.HxPeople;

public interface FeeMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Fee record);
	
	List<Fee> findOldApply(int team);

	int insertSelective(Fee record);

	Fee selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Fee record);

	int updateByPrimaryKey(Fee record);

	List<Fee> findAll();
	List<Fee> findNeedToConfirm();
	List<Fee> findNeedToConfirmAboutPeople();
	
	List<Fee> findTeam();
	List<Fee> findPeople();
	
	List<HxPeople> findThisTeamPeopleWhoIsProToSendHx();
	List <Fee> findFeeByPeopleId(int peopleId);
}