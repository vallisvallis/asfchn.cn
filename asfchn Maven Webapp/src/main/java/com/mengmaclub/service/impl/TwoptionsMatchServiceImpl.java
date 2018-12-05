package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.mengmaclub.mapper.TwoptionsmatchMapper;
import com.mengmaclub.model.Twoptionsmatch;
import com.mengmaclub.service.TwoptionsMatchService;
@Service
public class TwoptionsMatchServiceImpl implements TwoptionsMatchService {
	@Autowired
	private TwoptionsmatchMapper twoptionsMatchMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Twoptionsmatch record) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.insert(record);
	}

	@Override
	public int insertSelective(Twoptionsmatch record) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.insertSelective(record);
	}

	@Override
	public Twoptionsmatch selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Twoptionsmatch record) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.updateByPrimaryKeySelective(record)
				;
	}

	@Override
	public int updateByPrimaryKey(Twoptionsmatch record) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Twoptionsmatch> findBySn(String sn) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.findBySn(sn)
				;
	}

	@Override
	public Twoptionsmatch findBySnJid(String sn, int jid) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.findBySnJid(sn, jid);
	}

	@Override
	public List<Twoptionsmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid, int matchListid, int gageid) {
		// TODO Auto-generated method stub
		return twoptionsMatchMapper.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchListid, gageid);
	}

	
}
