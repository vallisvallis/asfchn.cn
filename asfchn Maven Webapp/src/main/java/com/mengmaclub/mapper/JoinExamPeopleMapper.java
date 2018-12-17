package com.mengmaclub.mapper;

import java.util.List;

import com.mengmaclub.model.JoinExamPeople;

public interface JoinExamPeopleMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(JoinExamPeople record);

    int insertSelective(JoinExamPeople record);

    JoinExamPeople selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(JoinExamPeople record);

    int updateByPrimaryKey(JoinExamPeople record);
    JoinExamPeople findBySn(String sn);
    JoinExamPeople findById(int id);
    List<JoinExamPeople> findWhoIsNeedConfirm();
    List<JoinExamPeople> findWhoHasConfirm();
}