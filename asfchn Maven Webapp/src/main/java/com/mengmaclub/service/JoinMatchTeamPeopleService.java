package com.mengmaclub.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mengmaclub.model.JoinMatchTeamPeople;

public interface JoinMatchTeamPeopleService {
	int deleteByPrimaryKey(Integer id);

    int insert(JoinMatchTeamPeople record);

    int insertSelective(JoinMatchTeamPeople record);

    JoinMatchTeamPeople selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JoinMatchTeamPeople record);

    int updateByPrimaryKey(JoinMatchTeamPeople record);
    List<JoinMatchTeamPeople> findAll();
    List<JoinMatchTeamPeople> findThisTeamJoinPeople(int teamid);
    List<JoinMatchTeamPeople> findThisMatchjoinPeople(int matchid);
    List<JoinMatchTeamPeople> findthisjoinTeamPeople(int joinTeamid);
    List<JoinMatchTeamPeople> showSelectPeople(@Param("matchid")int matchId, @Param("matchListId")int matchListId,@Param("matchgroup")int matchgroup);
    int deleteJoinPeoplewhoisNoConfirm(Integer id);
    List<JoinMatchTeamPeople> showthismatchListpeopleScore(int matchlistid);
    List<JoinMatchTeamPeople> findmyfriend(int matchid,int gageid,int jtid);
    JoinMatchTeamPeople findme(int peopleid);
    List<JoinMatchTeamPeople> findteammatch();
  //这次比赛这次项目参加了多少人
    List<JoinMatchTeamPeople> showPeopleWhoJoinThisMatchAndThisMatchList(int matchId,int matchListId);
    List<JoinMatchTeamPeople>  findwhocanjoinexam();
    //查看？比赛参加？项目的人
    List<JoinMatchTeamPeople> findThisMatchThisMatchlist(int matchid,int matchlistid);
    List<JoinMatchTeamPeople> findList8(int matchid);
    List<JoinMatchTeamPeople> findjob2(int jtid);
    List<JoinMatchTeamPeople> findjob1(int jtid);
    List<JoinMatchTeamPeople> findjob3(int jtid);
    List<JoinMatchTeamPeople> findmes(int jtid,int matchid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatch(int jtid);
    List<JoinMatchTeamPeople> findthisTeamwhojoinlist8(int matchid,int jtid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatchSmall(int jtid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatchMiddle(int jtid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatchHigh(int jtid);
}
