package com.mengmaclub.service;

import java.util.List;


import com.mengmaclub.model.Turnmatchlist;

public interface TurnMatchListService {
	  int deleteByPrimaryKey(Integer id);

	    int insert(Turnmatchlist record);

	    int insertSelective(Turnmatchlist record);

	    Turnmatchlist selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Turnmatchlist record);

	    int updateByPrimaryKey(Turnmatchlist record);
	    List<Turnmatchlist> findAll();
	    
	    Turnmatchlist findByJpId(int joinPeopleId);
	    List<Turnmatchlist> findThisGageThisTurn(int gage,int turn);
	    List<Turnmatchlist> findWhereIsMyListGagePeople(int gage,int matchlist);
	    List<Turnmatchlist>  findMySameturn(int gage,int matchlist,int turn);
	    List<Turnmatchlist>  findMySameturnin2(int gage,int matchlist,int turn);
	    Turnmatchlist findNoOne(int gage,int matchlist,int turn);
	    Turnmatchlist findNoOnein2(int gage,int matchlist,int turn);
	    List<Turnmatchlist> all(int matchlist);
	    Turnmatchlist findBySnJid(String sn,int jid);
	    List<Turnmatchlist> findWhoJoinThisMatchThisListAndHasConfirm(int matchid,int matchlist,int gageid);
}
