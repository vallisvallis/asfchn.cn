package com.mengmaclub.service;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.web.multipart.MultipartFile;

import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;

public interface HxPeopleService {
	int deleteByPrimaryKey(Integer id);

	int insert(HxPeople record);

	int insertSelective(HxPeople record);

	HxPeople selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(HxPeople record);

	int updateByPrimaryKey(HxPeople record);

	List<HxPeople> findAll();

	int showNum();
	List<HxPeople> findBySnInOne(String Sn);
	List<HxPeople> findWhoFeed();

	HxTeam findBelongTeam(int id);

	HxPeople findPeopleByName(String peoplename);
	HxPeople findPeopleByNameAndCertNum(String name,String cert);
	List<HxPeople> findinpage(@Param("num1") int num1, @Param("num2") int num2);
	List<HxPeople> selectByCertPeople(HxPeople people);
	List<HxPeople> findWhoNotFeed();
	HxPeople findPeopleByCertNum(String cert);
	Integer findPeopleCertNumIsExist(String certNum);
	HxPeople findBySn(String sn);
//	 public List<HxPeople> importExcel(MultipartFile file);//导入

	
	
	//void importExcelInfo(InputStream in, MultipartFile file)throws Exception;
}
