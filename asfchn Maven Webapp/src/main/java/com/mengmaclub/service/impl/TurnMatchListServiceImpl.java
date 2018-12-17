package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mengmaclub.mapper.TurnmatchlistMapper;
import com.mengmaclub.model.Turnmatchlist;
import com.mengmaclub.service.TurnMatchListService;
@Service
public class TurnMatchListServiceImpl implements TurnMatchListService {
	@Autowired
	private TurnmatchlistMapper turnMatchListMapper;
	
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Turnmatchlist record) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.insert(record);
	}

	@Override
	public int insertSelective(Turnmatchlist record) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.insertSelective(record);
	}

	@Override
	public Turnmatchlist selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Turnmatchlist record) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Turnmatchlist record) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Turnmatchlist> findAll() {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findAll();
	}

	@Override
	public Turnmatchlist findByJpId(int joinPeopleId) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findByJpId(joinPeopleId);
	}

	@Override
	public List<Turnmatchlist> findThisGageThisTurn(int gage, int turn) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findThisGageThisTurn(gage, turn);
	}

	@Override
	public List<Turnmatchlist> findWhereIsMyListGagePeople(int gage,
			int matchlist) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findWhereIsMyListGagePeople(gage, matchlist);
	}

	@Override
	public List<Turnmatchlist> findMySameturn(int gage, int matchlist, int turn) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findMySameturn(gage, matchlist, turn);
	}

	@Override
	public Turnmatchlist findNoOne(int gage, int matchlist, int turn) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findNoOne(gage, matchlist, turn);
	}

	@Override
	public Turnmatchlist findNoOnein2(int gage, int matchlist, int turn) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findNoOnein2(gage, matchlist, turn);
	}

	@Override
	public List<Turnmatchlist> findMySameturnin2(int gage, int matchlist,
			int turn) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findMySameturnin2(gage, matchlist, turn);
	}

	@Override
	public List<Turnmatchlist> all(int matchlist) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.all(matchlist);
	}

	@Override
	public Turnmatchlist findBySnJid(String sn, int jid) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findBySnJid(sn, jid);
	}

	@Override
	public List<Turnmatchlist> findWhoJoinThisMatchThisListAndHasConfirm(int matchid, int matchlist, int gageid) {
		// TODO Auto-generated method stub
		return turnMatchListMapper.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchlist, gageid);
	}

}
