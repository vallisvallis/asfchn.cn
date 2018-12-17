package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.JoinMatchTeam;

public interface JoinMatchTeamService {
	int deleteByPrimaryKey(Integer id);

	int insert(JoinMatchTeam record);

	int insertSelective(JoinMatchTeam record);

	JoinMatchTeam selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(JoinMatchTeam record);

	int updateByPrimaryKey(JoinMatchTeam record);

	List<JoinMatchTeam> findAll();
	 List<JoinMatchTeam> findAllWhichIsYes();
	 List<JoinMatchTeam> findAllWhichIsYesin18();
	 List<JoinMatchTeam> findAllWhichIsNo();
	 List<JoinMatchTeam> findMyTeamWhichIsYes(int teamid);
	   List<Integer> showIdWhoNotConfirm();
	   List<JoinMatchTeam> findthismatchteam(int matchid);
	   List<JoinMatchTeam> findMyteamInthisMatch(int teamid);
}
