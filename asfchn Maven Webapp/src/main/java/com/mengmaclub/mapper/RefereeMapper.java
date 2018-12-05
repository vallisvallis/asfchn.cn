package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.Referee;

public interface RefereeMapper {
	//删除裁判
    int deleteByPrimaryKey(Integer id);
//添加裁判
    int insert(Referee record);
//添加裁判
    int insertSelective(Referee record);
//选择裁判
    Referee selectByPrimaryKey(Integer id);
//更新裁判（直接更新）
    int updateByPrimaryKeySelective(Referee record);
//更新裁判
    int updateByPrimaryKey(Referee record);
   //查询所有裁判
    List<Referee> findAll();
}