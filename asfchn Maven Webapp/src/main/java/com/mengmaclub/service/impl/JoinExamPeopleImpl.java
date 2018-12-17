package com.mengmaclub.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mengmaclub.mapper.JoinExamPeopleMapper;
import com.mengmaclub.model.JoinExamPeople;
import com.mengmaclub.service.JoinExamPeopleService;
@Service
public class JoinExamPeopleImpl implements JoinExamPeopleService {
@Autowired
	private JoinExamPeopleMapper joinExamPeopleMapper;
	@Override
	public int deleteByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.deleteByPrimaryKey(id);
	}

	@Override
	public int insert(JoinExamPeople record) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.insert(record);
	}

	@Override
	public int insertSelective(JoinExamPeople record) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.insertSelective(record);
	}

	@Override
	public JoinExamPeople selectByPrimaryKey(Integer id) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.selectByPrimaryKey(id);
	}

	@Override
	public int updateByPrimaryKeySelective(JoinExamPeople record) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateByPrimaryKey(JoinExamPeople record) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.updateByPrimaryKey(record);
	}

	@Override
	public JoinExamPeople findBySn(String sn) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.findBySn(sn);
	}

	@Override
	public JoinExamPeople findById(int id) {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.findById(id);
	}

	@Override
	public List<JoinExamPeople> findWhoIsNeedConfirm() {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.findWhoIsNeedConfirm();
	}

	@Override
	public List<JoinExamPeople> findWhoHasConfirm() {
		// TODO Auto-generated method stub
		return joinExamPeopleMapper.findWhoHasConfirm();
	}

}
