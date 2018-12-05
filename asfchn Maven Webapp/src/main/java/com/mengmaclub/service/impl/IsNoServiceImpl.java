package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.IsNoMapper;
import com.mengmaclub.model.IsNo;
import com.mengmaclub.service.IsNoService;
@Service
public class IsNoServiceImpl implements IsNoService {
@Autowired
	private IsNoMapper isNoMapper;
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return isNoMapper.deleteByPrimaryKey(id);
	}

	public int insert(IsNo record) {
		// TODO Auto-generated method stub
		return isNoMapper.insert(record);
	}

	public int insertSelective(IsNo record) {
		// TODO Auto-generated method stub
		return isNoMapper.insertSelective(record);
	}

	public IsNo selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return isNoMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(IsNo record) {
		// TODO Auto-generated method stub
		return isNoMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(IsNo record) {
		// TODO Auto-generated method stub
		return isNoMapper.updateByPrimaryKey(record);
	}

	public List<IsNo> findAll() {
		// TODO Auto-generated method stub
		return isNoMapper.findAll();
	}

}
