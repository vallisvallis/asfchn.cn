package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.WithfriendmatchMapper;
import com.mengmaclub.model.Withfriendmatch;
import com.mengmaclub.service.WithfriendmatchService;
@Service
public class WithfriendmatchServiceImpl implements WithfriendmatchService {
	@Autowired
	private WithfriendmatchMapper withfriendmatchMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Withfriendmatch record) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.insert(record);
	}

	@Override
	public int insertSelective(Withfriendmatch record) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.insertSelective(record);
	}

	@Override
	public Withfriendmatch selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Withfriendmatch record) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Withfriendmatch record) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.updateByPrimaryKey(record);
	}

	@Override
	public Withfriendmatch findByJpId(int joinPeoplId) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.findByJpId(joinPeoplId);
	}

	@Override
	public List<Withfriendmatch> findWhereIsMyListGagePeople(int gage,
			int matchlist) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.findWhereIsMyListGagePeople(gage, matchlist);
	}

	@Override
	public List<Withfriendmatch> findMyfriend(String myteamfriend) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.findMyfriend(myteamfriend);
	}

	@Override
	public List<Withfriendmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid, int listid, int gageid) {
		// TODO Auto-generated method stub
		return withfriendmatchMapper.findWhoJoinThisMatchThisListAndHasConfirm(matchid, listid, gageid);
	}

}
