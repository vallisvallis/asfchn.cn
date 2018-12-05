package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.Mangoptionsmatch;
import com.mengmaclub.model.Twoptionsmatch;

public interface MangoptionsmatchMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Mangoptionsmatch record);

    int insertSelective(Mangoptionsmatch record);

    Mangoptionsmatch selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Mangoptionsmatch record);

    int updateByPrimaryKey(Mangoptionsmatch record);
    
    List<Mangoptionsmatch>  findBySn(String sn);
    List<Mangoptionsmatch> findWhereIsMyListGagePeople(int gage,int matchlist);
    Mangoptionsmatch findByjid(int jid);
    List<Mangoptionsmatch> findAll();
    Mangoptionsmatch findBySnJid(String sn,int jid);
    List<Mangoptionsmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid,int matchlistid,int gageid);
}