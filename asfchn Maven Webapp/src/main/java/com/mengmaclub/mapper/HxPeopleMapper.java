package com.mengmaclub.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;

public interface HxPeopleMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(HxPeople record);

	int insertSelective(HxPeople record);

	HxPeople selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(HxPeople record);

	int updateByPrimaryKey(HxPeople record);

	List<HxPeople> findAll();

	int showNum();

	List<HxPeople> findWhoFeed();

	HxTeam findBelongTeam(int id);

	HxPeople findPeopleByName(String peopleName);
	HxPeople findPeopleByCertNum(String cert);
	HxPeople findPeopleByNameAndCertNum(String name,String cert);
	
	List<HxPeople> findBySnInOne(String Sn);
	List<HxPeople> findinpage(@Param("num1") int num1, @Param("num2") int num2);
	Integer findPeopleCertNumIsExist(String certNum);
	/**
	 * 通过身份证号查询数据 功能描述: <br>
	 * 〈功能详细描述〉
	 * 
	 * @param record
	 * @return
	 * @see [相关类/方法](可选)
	 * @since [产品/模块版本](可选)
	 */
	List<HxPeople> selectByCertPeople(HxPeople record);
	List<HxPeople> findWhoNotFeed();
	HxPeople findBySn(String sn);
}