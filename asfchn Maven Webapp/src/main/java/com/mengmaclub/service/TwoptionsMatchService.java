package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Twoptionsmatch;

public interface TwoptionsMatchService {
	 int deleteByPrimaryKey(Integer id);

	    int insert(Twoptionsmatch record);

	    int insertSelective(Twoptionsmatch record);

	    Twoptionsmatch selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Twoptionsmatch record);

	    int updateByPrimaryKey(Twoptionsmatch record);
	
	   // List<Twoptionsmatch> findWhereIsMyListGagePeople(int gage,int matchlist);
	    List< Twoptionsmatch> findBySn(String sn);
	    Twoptionsmatch findBySnJid(String sn,int jid);
	    List<Twoptionsmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid,int matchListid,int gageid);
}
