package com.mengmaclub.mapper;

import java.util.List;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;
public interface HxTeamMapper {
	//根据主键删除
	int deleteByPrimaryKey(Integer id);
	//添加会员单位对象
	int insert(HxTeam record);
	//
	int insertSelective(HxTeam record);
	//查找单个会员单位 根据ID
	HxTeam selectByPrimaryKey(Integer id);
	//更新一个会员单位 （会员单位对象）
	int updateByPrimaryKeySelective(HxTeam record);
	//
	int updateByPrimaryKeyWithBLOBs(HxTeam record);
	//更新一个会员单位（会员单位对象）
	int updateByPrimaryKey(HxTeam record);
	//返回List  查找所有会员单位
	List<HxTeam> findAll();
	int showNum();
	//查看谁缴费了
	List<HxTeam> findWhofeed();
	//查找飞行营地
	List<HxTeam> findFlyTeam();
	//查找训练单位
	List<HxTeam> findTrainTeam();
	//
	List<HxPeople> findPeopleThisTeam(int id);
	//查看谁没有付费
	List<HxTeam> findNotPay();
	//在该会员单位查找谁教了费用
	List<HxPeople> findPeopleThisTeamWhoPay(int blongteam);
	//在该会员单位查找谁没教费用
	List<HxPeople> findPeopleThisTeamWhoNotPay(int blongteam);	
}