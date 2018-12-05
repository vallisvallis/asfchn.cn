package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.JoinMatchTeamMapper;
import com.mengmaclub.model.JoinMatchTeam;
import com.mengmaclub.service.JoinMatchTeamService;
@Service
public class JoinMatchTeamServiceImpl implements JoinMatchTeamService {

	@Autowired
	private JoinMatchTeamMapper joinMatchTeamMapper;
	public int deleteByPrimaryKey(Integer id) {
		
		return joinMatchTeamMapper.deleteByPrimaryKey(id);
	}

	public int insert(JoinMatchTeam record) {
		
		return joinMatchTeamMapper.insert(record);
	}

	public int insertSelective(JoinMatchTeam record) {
		
		return joinMatchTeamMapper.insertSelective(record);
	}

	public JoinMatchTeam selectByPrimaryKey(Integer id) {
		
		return joinMatchTeamMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(JoinMatchTeam record) {
		
		return joinMatchTeamMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(JoinMatchTeam record) {
		
		return joinMatchTeamMapper.updateByPrimaryKey(record);
	}

	public List<JoinMatchTeam> findAll() {
		
		return joinMatchTeamMapper.findAll();
	}

	@Override
	public List<JoinMatchTeam> findAllWhichIsYes() {
		// TODO Auto-generated method stub
		return joinMatchTeamMapper.findAllWhichIsYes();
	}

	@Override
	public List<JoinMatchTeam> findAllWhichIsNo() {
		// TODO Auto-generated method stub
		return joinMatchTeamMapper.findAllWhichIsNo();
	}

	@Override
	public List<JoinMatchTeam> findMyTeamWhichIsYes(int teamid) {
		// TODO Auto-generated method stub
		return joinMatchTeamMapper.findMyTeamWhichIsYes(teamid);
	}

	@Override
	public List<Integer> showIdWhoNotConfirm() {
		// TODO Auto-generated method stub
		return joinMatchTeamMapper.showIdWhoNotConfirm();
	}

	@Override
	public List<JoinMatchTeam> findAllWhichIsYesin18() {
		// TODO Auto-generated method stub
		return joinMatchTeamMapper.findAllWhichIsYesin18();
	}

	@Override
	public List<JoinMatchTeam> findthismatchteam(int matchid) {
		// TODO Auto-generated method stub
		return joinMatchTeamMapper.findthismatchteam(matchid);
	}

	@Override
	public List<JoinMatchTeam> findMyteamInthisMatch(int teamid) {
		// TODO Auto-generated method stub
		return joinMatchTeamMapper.findMyteamInthisMatch(teamid);
	}

}
