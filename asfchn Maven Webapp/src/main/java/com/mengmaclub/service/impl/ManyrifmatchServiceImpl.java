package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.ManyrifmatchMapper;
import com.mengmaclub.model.Manyrifmatch;
import com.mengmaclub.service.ManyrifmatchService;
@Service
public class ManyrifmatchServiceImpl implements ManyrifmatchService {
	@Autowired
	private ManyrifmatchMapper manyrifmatchMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Manyrifmatch record) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.insert(record);
	}

	@Override
	public int insertSelective(Manyrifmatch record) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.insertSelective(record);
	}

	@Override
	public Manyrifmatch selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Manyrifmatch record) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Manyrifmatch record) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.updateByPrimaryKey(record);
	}

	@Override
	public Manyrifmatch findByJpId(int jtid) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.findByJpId(jtid);
	}

	@Override
	public List<Manyrifmatch> findWhereIsMyListGagePeople(int gage,
			int matchlist) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.findWhereIsMyListGagePeople(gage, matchlist);
	}

	@Override
	public List<Manyrifmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid, int matchlist, int gageid) {
		// TODO Auto-generated method stub
		return manyrifmatchMapper.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchlist, gageid);
	}

}
