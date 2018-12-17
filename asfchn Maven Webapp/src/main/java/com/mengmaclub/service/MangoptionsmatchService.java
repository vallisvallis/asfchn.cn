package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Mangoptionsmatch;

public interface MangoptionsmatchService {
	
	int deleteByPrimaryKey(Integer id);

    int insert(Mangoptionsmatch record);

    int insertSelective(Mangoptionsmatch record);

    Mangoptionsmatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mangoptionsmatch record);

    int updateByPrimaryKey(Mangoptionsmatch record);
    
   List< Mangoptionsmatch>  findBySn(String sn);
    List<Mangoptionsmatch> findWhereIsMyListGagePeople(int gage,int matchlist);
    Mangoptionsmatch findByjid(int jid);
    List<Mangoptionsmatch> findAll();
    Mangoptionsmatch findBySnJid(String sn,int jid);
    List<Mangoptionsmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid,int matchlistid,int gageid);
}
