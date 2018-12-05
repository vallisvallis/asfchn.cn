package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.NewsMapper;
import com.mengmaclub.model.News;
import com.mengmaclub.service.NewsService;
@Service
public class NewsServiceImpl implements NewsService {
	@Autowired
	private NewsMapper newsMapper;
	public int deleteByPrimaryKey(Integer id) {
		
		return newsMapper.deleteByPrimaryKey(id);
	}

	public int insert(News record) {
		
		return newsMapper.insert(record);
	}

	public int insertSelective(News record) {
		
		return newsMapper.insertSelective(record);
	}

	public News selectByPrimaryKey(Integer id) {
		
		return newsMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(News record) {
		
		return newsMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKeyWithBLOBs(News record) {
		
		return newsMapper.updateByPrimaryKeyWithBLOBs(record);
	}

	public int updateByPrimaryKey(News record) {
		
		return newsMapper.updateByPrimaryKey(record);
	}

	public List<News> findAll() {
		
		return newsMapper.findAll();
	}

	public List<News> findNews() {
		// TODO Auto-generated method stub
		return newsMapper.findNews();
	}

	public List<News> findReport() {
		// TODO Auto-generated method stub
		return newsMapper.findReport();
	}

}
