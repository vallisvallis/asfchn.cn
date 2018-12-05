package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.Withfriendmatch;

public interface WithfriendmatchService {
	 int deleteByPrimaryKey(Integer id);

	    int insert(Withfriendmatch record);

	    int insertSelective(Withfriendmatch record);

	    Withfriendmatch selectByPrimaryKey(Integer id);

	    int updateByPrimaryKeySelective(Withfriendmatch record);

	    int updateByPrimaryKey(Withfriendmatch record);
	    Withfriendmatch findByJpId(int joinPeoplId);
	    List<Withfriendmatch> findWhereIsMyListGagePeople(int gage,int matchlist);
	    List<Withfriendmatch> findMyfriend(String myteamfriend);
	    List<Withfriendmatch> findWhoJoinThisMatchThisListAndHasConfirm(int matchid,int listid,int gageid);
}
