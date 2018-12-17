package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;

public interface HxTeamService {
	int deleteByPrimaryKey(Integer id);

	int insert(HxTeam record);

	int insertSelective(HxTeam record);

	HxTeam selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(HxTeam record);

	int updateByPrimaryKeyWithBLOBs(HxTeam record);

	int updateByPrimaryKey(HxTeam record);

	List<HxTeam> findAll();

	int showNum();

	List<HxTeam> findWhofeed();

	List<HxTeam> findFlyTeam();

	List<HxTeam> findTrainTeam();
	List<HxPeople> findPeopleThisTeam(int id);
	List<HxTeam> findNotPay();
	List<HxPeople> findPeopleThisTeamWhoPay(int blongteam);
	List<HxPeople> findPeopleThisTeamWhoNotPay(int blongteam);
}