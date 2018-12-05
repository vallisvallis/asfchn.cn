package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.RefereeMapper;
import com.mengmaclub.model.Referee;
import com.mengmaclub.service.RefereeService;
@Service
public class RefereeServiceImpl implements RefereeService {
	@Autowired
	private RefereeMapper refereeMapper;
	
	@Override
	public int deleteByPrimaryKey(Integer id) {
		
		return refereeMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(Referee record) {
		
		return refereeMapper.insert(record);
	}

	@Override
	public int insertSelective(Referee record) {
		
		return refereeMapper.insertSelective(record);
	}

	@Override
	public Referee selectByPrimaryKey(Integer id) {
		
		return refereeMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(Referee record) {
		
		return refereeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(Referee record) {
		
		return refereeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Referee> findAll() {
		
		return refereeMapper.findAll();
	}

}
