package com.mengmaclub.service;

import java.util.List;

import com.mengmaclub.model.News;

public interface NewsService {
	int deleteByPrimaryKey(Integer id);

	int insert(News record);

	int insertSelective(News record);

	News selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(News record);

	int updateByPrimaryKeyWithBLOBs(News record);

	int updateByPrimaryKey(News record);

	List<News> findAll();
	List<News> findNews();
	List<News>	findReport();
}
