package com.mengmaclub.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.JoinMatchTeamPeopleMapper;
import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.service.JoinMatchTeamPeopleService;

@Service
public class JoinMatchTeamPeopleServiceImpl implements
		JoinMatchTeamPeopleService {
	@Autowired
	private JoinMatchTeamPeopleMapper joinMatchTeamPeopleMapper;

	public int deleteByPrimaryKey(Integer id) {
		return joinMatchTeamPeopleMapper.deleteByPrimaryKey(id);
	}

	public int insert(JoinMatchTeamPeople record) {
		return joinMatchTeamPeopleMapper.insert(record);
	}

	public int insertSelective(JoinMatchTeamPeople record) {
		return joinMatchTeamPeopleMapper.insertSelective(record);
	}

	public JoinMatchTeamPeople selectByPrimaryKey(Integer id) {
		return joinMatchTeamPeopleMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(JoinMatchTeamPeople record) {
		return joinMatchTeamPeopleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(JoinMatchTeamPeople record) {
		return joinMatchTeamPeopleMapper.updateByPrimaryKey(record);
	}
	public List<JoinMatchTeamPeople> findAll() {
		return joinMatchTeamPeopleMapper.findAll();
	}

	public List<JoinMatchTeamPeople> findThisTeamJoinPeople(int teamid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findThisTeamJoinPeople(teamid);
	}

	@Override
	public List<JoinMatchTeamPeople> findThisMatchjoinPeople(int matchid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findThisMatchjoinPeople(matchid);
	}

	@Override
	public List<JoinMatchTeamPeople> findthisjoinTeamPeople(int joinTeamid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findthisjoinTeamPeople(joinTeamid);
	}

	@Override
	public List<JoinMatchTeamPeople> showSelectPeople(
			@Param("matchid") int matchId,
			@Param("matchListId") int matchListId,
			@Param("matchgroup") int matchgroup) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.showSelectPeople(matchId, matchListId,
				matchgroup);
	}

	@Override
	public int deleteJoinPeoplewhoisNoConfirm(Integer id) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.deleteJoinPeoplewhoisNoConfirm(id);
	}

	@Override
	public List<JoinMatchTeamPeople> showthismatchListpeopleScore(
			int matchlistid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper
				.showthismatchListpeopleScore(matchlistid);
	}

	
	@Override
	public JoinMatchTeamPeople findme(int peopleid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findme(peopleid);
	}

	@Override
	public List<JoinMatchTeamPeople> findteammatch() {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findteammatch();
	}

	@Override
	public List<JoinMatchTeamPeople> showPeopleWhoJoinThisMatchAndThisMatchList(
			int matchId, int matchListId) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper
				.showPeopleWhoJoinThisMatchAndThisMatchList(matchId,
						matchListId);
	}

	@Override
	public List<JoinMatchTeamPeople> findwhocanjoinexam() {
		
		return joinMatchTeamPeopleMapper.findwhocanjoinexam();
	}

	@Override
	public List<JoinMatchTeamPeople> findThisMatchThisMatchlist(int matchid,
			int matchlistid) {
		
		return joinMatchTeamPeopleMapper.findThisMatchThisMatchlist(matchid, matchlistid);
	}

	@Override
	public List<JoinMatchTeamPeople> findList8(int matchid) {

		return joinMatchTeamPeopleMapper.findList8(matchid);
	}

	@Override
	public List<JoinMatchTeamPeople> findjob2(int jtid) {
	
		return joinMatchTeamPeopleMapper.findjob2(jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findjob1(int jtid) {
	
		return joinMatchTeamPeopleMapper.findjob1(jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findjob3(int jtid) {
		
		return joinMatchTeamPeopleMapper.findjob3(jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findmes(int jtid,int matchid) {
		
		return joinMatchTeamPeopleMapper.findmes(jtid,matchid);
	}

	@Override
	public List<JoinMatchTeamPeople> findwhoisTeamMatch(int jtid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findwhoisTeamMatch(jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findmyfriend(int matchid, int gageid, int jtid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findmyfriend(matchid, gageid, jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findthisTeamwhojoinlist8(int matchid, int jtid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findthisTeamwhojoinlist8(matchid, jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findwhoisTeamMatchSmall(int jtid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findwhoisTeamMatchSmall(jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findwhoisTeamMatchMiddle(int jtid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findwhoisTeamMatchMiddle(jtid);
	}

	@Override
	public List<JoinMatchTeamPeople> findwhoisTeamMatchHigh(int jtid) {
		// TODO Auto-generated method stub
		return joinMatchTeamPeopleMapper.findwhoisTeamMatchHigh(jtid);
	}

}
