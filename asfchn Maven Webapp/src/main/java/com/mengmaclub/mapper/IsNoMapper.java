package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.IsNo;

public interface IsNoMapper {

	int deleteByPrimaryKey(Integer id);

    int insert(IsNo record);

    int insertSelective(IsNo record);

    IsNo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(IsNo record);

    int updateByPrimaryKey(IsNo record);
    
    List<IsNo> findAll();
}