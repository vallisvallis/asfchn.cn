package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.News;

public interface NewsMapper {
	
	int deleteByPrimaryKey(Integer id);

	int insert(News record);

	int insertSelective(News record);

	News selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(News record);

	int updateByPrimaryKeyWithBLOBs(News record);

	int updateByPrimaryKey(News record);

	List<News> findAll();
	
	List<News> findNews();

	List<News> findReport();
}