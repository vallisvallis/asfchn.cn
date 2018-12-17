package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.JoinMatchTeam;

public interface JoinMatchTeamMapper {
	
    int deleteByPrimaryKey(Integer id);

    int insert(JoinMatchTeam record);

    int insertSelective(JoinMatchTeam record);

    JoinMatchTeam selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JoinMatchTeam record);

    int updateByPrimaryKey(JoinMatchTeam record);
    //查询所有
    List<JoinMatchTeam> findAll();
    //查看哪些队伍是合法的
    List<JoinMatchTeam> findAllWhichIsYes();
    //确认在（）中比赛的队伍
    List<JoinMatchTeam> findAllWhichIsYesin18();
    //查看那些队伍没有经过审核
    List<JoinMatchTeam> findAllWhichIsNo();
   
    List<JoinMatchTeam> findMyTeamWhichIsYes(int teamid);
    //查看哪些报名队伍还没有确认
    List<Integer> showIdWhoNotConfirm();
    
    List<JoinMatchTeam> findthismatchteam(int matchid);
    
    List<JoinMatchTeam> findMyteamInthisMatch(int teamid);
}