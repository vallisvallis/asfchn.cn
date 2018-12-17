package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Manyrifmatch;

public interface ManyrifmatchService {
	 int deleteByPrimaryKey(Integer id);

	    int insert(Manyrifmatch record);

	    int insertSelective(Manyrifmatch record);

	    Manyrifmatch selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Manyrifmatch record);

	    int updateByPrimaryKey(Manyrifmatch record);
	    Manyrifmatch findByJpId(int jtid);
	    List<Manyrifmatch> findWhereIsMyListGagePeople(int gage,int matchlist);
	    List<Manyrifmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid,int matchlist,int gageid);
}
