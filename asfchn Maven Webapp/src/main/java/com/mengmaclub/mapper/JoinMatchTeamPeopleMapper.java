package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.Match;
import com.mengmaclub.model.MatchList;

public interface JoinMatchTeamPeopleMapper{
    int deleteByPrimaryKey(Integer id);
    int insert(JoinMatchTeamPeople record);
    int insertSelective(JoinMatchTeamPeople record);
    JoinMatchTeamPeople selectByPrimaryKey(Integer id);
    int updateByPrimaryKeySelective(JoinMatchTeamPeople record);
    int updateByPrimaryKey(JoinMatchTeamPeople record);
    //查询所有参赛人员
    List<JoinMatchTeamPeople> findAll();
    //查询所有该会员单位的参赛人员
    List<JoinMatchTeamPeople> findThisTeamJoinPeople(int teamid);
    //查询所有该赛事的参赛人员
    List<JoinMatchTeamPeople> findThisMatchjoinPeople(int matchid);
    //查询所有该比赛队伍的参赛人员
    List<JoinMatchTeamPeople> findthisjoinTeamPeople(int joinTeamid);
    //查询该比赛该项目改组别的参赛人员
    List<JoinMatchTeamPeople> showSelectPeople(int matchId,int matchListId,int matchgroup);
    int deleteJoinPeoplewhoisNoConfirm(Integer id);
    //查询该项目的参赛人员
    List<JoinMatchTeamPeople> showthismatchListpeopleScore(int matchlistid);
    //查找我的队友（一般用于钻石300三人接力）
    List<JoinMatchTeamPeople> findmyfriend(int matchid,int gageid,int jtid);
    //查找单人
    JoinMatchTeamPeople findme(int peopleid);
    //查看团体项目的人数
    List<JoinMatchTeamPeople> findteammatch();
    //这次比赛这次项目参加了多少人   
    List<JoinMatchTeamPeople> showPeopleWhoJoinThisMatchAndThisMatchList(int matchId,int matchListId);
    //查看谁有资格参加比赛
    List<JoinMatchTeamPeople>  findwhocanjoinexam();
    List<JoinMatchTeamPeople> findthisTeamwhojoinlist8(int matchid,int jtid);
    //查看？比赛参加？项目的人
    List<JoinMatchTeamPeople> findThisMatchThisMatchlist(int matchid,int matchlistid);
    //查看这次比赛参加钻石300的人
    List<JoinMatchTeamPeople> findList8(int matchid);
    //<!-- 查找此队伍中的领队 --> 输入参赛队伍的id
    List<JoinMatchTeamPeople> findjob2(int jtid);
    //<!-- 查找此队伍中的教练 --> 输入参赛队伍的id
    List<JoinMatchTeamPeople> findjob1(int jtid);
    //<!-- 查找此队伍中的运动员 --> 输入参赛队伍的id
    List<JoinMatchTeamPeople> findjob3(int jtid);
    //查询参赛人员在此次比赛中参加多少个项目，主要作用是判断是否是兼项，如果
    List<JoinMatchTeamPeople> findmes(int jpid,int matchid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatch(int jtid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatchSmall(int jtid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatchMiddle(int jtid);
    List<JoinMatchTeamPeople>  findwhoisTeamMatchHigh(int jtid);
}