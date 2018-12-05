package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.MangoptionsmatchMapper;
import com.mengmaclub.model.Mangoptionsmatch;
import com.mengmaclub.service.MangoptionsmatchService;
@Service
public class MangoptionsmatchServiceImpl implements MangoptionsmatchService {
	@Autowired
	private MangoptionsmatchMapper  mangoptionsmatchMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Mangoptionsmatch record) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.insert(record);
	}

	@Override
	public int insertSelective(Mangoptionsmatch record) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.insertSelective(record);
	}

	@Override
	public Mangoptionsmatch selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Mangoptionsmatch record) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Mangoptionsmatch record) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Mangoptionsmatch> findBySn(String sn) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.findBySn(sn);
	}

	@Override
	public List<Mangoptionsmatch> findWhereIsMyListGagePeople(int gage,
			int matchlist) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.findWhereIsMyListGagePeople(gage, matchlist);
	}

	@Override
	public Mangoptionsmatch findByjid(int jid) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.findByjid(jid);
	}

	@Override
	public List<Mangoptionsmatch> findAll() {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.findAll();
	}

	@Override
	public Mangoptionsmatch findBySnJid(String sn, int jid) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.findBySnJid(sn, jid);
	}

	@Override
	public List<Mangoptionsmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid, int matchlistid, int gageid) {
		// TODO Auto-generated method stub
		return mangoptionsmatchMapper.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchlistid, gageid);
	}

}
