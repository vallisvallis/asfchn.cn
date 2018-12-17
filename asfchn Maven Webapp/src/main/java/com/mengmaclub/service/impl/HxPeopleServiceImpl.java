package com.mengmaclub.service.impl;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.mengmaclub.mapper.HxPeopleMapper;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;
import com.mengmaclub.service.HxPeopleService;


@Service
public class HxPeopleServiceImpl implements HxPeopleService {

	@Autowired
	private HxPeopleMapper hxpeopleMapper;

	public int deleteByPrimaryKey(Integer id) {

		return hxpeopleMapper.deleteByPrimaryKey(id);
	}

	public int insert(HxPeople record) {

		return hxpeopleMapper.insert(record);
	}

	public int insertSelective(HxPeople record) {

		return hxpeopleMapper.insertSelective(record);
	}

	public HxPeople selectByPrimaryKey(Integer id) {

		return hxpeopleMapper.selectByPrimaryKey(id);
	}

	public int updateByPrimaryKeySelective(HxPeople record) {

		return hxpeopleMapper.updateByPrimaryKeySelective(record);
	}

	public int updateByPrimaryKey(HxPeople record) {

		return hxpeopleMapper.updateByPrimaryKey(record);
	}

	public List<HxPeople> findAll() {

		return hxpeopleMapper.findAll();
	}

	public int showNum() {

		return hxpeopleMapper.showNum();
	}

	public List<HxPeople> findWhoFeed() {

		return hxpeopleMapper.findWhoFeed();
	}

	public HxTeam findBelongTeam(int id) {

		return hxpeopleMapper.findBelongTeam(id);
	}

	public HxPeople findPeopleByName(String peoplename) {
		
		return hxpeopleMapper.findPeopleByName(peoplename);
	}

	public List<HxPeople> selectByCertPeople(HxPeople people) {
		return hxpeopleMapper.selectByCertPeople(people);
	}

	@Override
	public List<HxPeople> findWhoNotFeed() {
		// TODO Auto-generated method stub
		return hxpeopleMapper.findWhoNotFeed();
	}

	@Override
	public HxPeople findPeopleByNameAndCertNum(String name, String cert) {
		// TODO Auto-generated method stub
		return hxpeopleMapper.findPeopleByNameAndCertNum(name, cert);
	}

	@Override
	public HxPeople findPeopleByCertNum(String cert) {
		// TODO Auto-generated method stub
		return hxpeopleMapper.findPeopleByCertNum(cert);
	}

	@Override
	public Integer findPeopleCertNumIsExist(String certNum) {
		// TODO Auto-generated method stub
		return hxpeopleMapper.findPeopleCertNumIsExist(certNum);
	}

	@Override
	public HxPeople findBySn(String sn) {
		// TODO Auto-generated method stub
		return hxpeopleMapper.findBySn(sn);
	}

	@Override
	public List<HxPeople> findBySnInOne(String Sn) {
		// TODO Auto-generated method stub
		return hxpeopleMapper.findBySnInOne(Sn);
	}

	@Override
	public List<HxPeople> findinpage(@Param("num1") int num1, @Param("num2") int num2) {
		// TODO Auto-generated method stub
		return hxpeopleMapper.findinpage(num1, num2);
	}

//	@Override
//	public List<HxPeople> importExcel(MultipartFile file) {
//		// TODO Auto-generated method stub
//		return null;
//	}
	
//	//public void importExcelInfo(InputStream in, MultipartFile file) throws Exception{  
//	    List<List<Object>> listob = ExcelUtil.getBankListByExcel(in,file.getOriginalFilename());  
//	   // List<Salarymanage> salaryList = new ArrayList<Salarymanage>(); 
//	    List<HxPeople> hxPeopleList=new ArrayList<HxPeople>();
//	    //遍历listob数据，把数据放到List中  
//	    for (int i = 0; i < listob.size(); i++) {  
//	        List<Object> ob = listob.get(i);  
//	        HxPeople hxPeople=new HxPeople();
//	        
//	        hxPeople.setName(String.valueOf(ob.get(2)));
//	        
////	        Salarymanage salarymanage = new Salarymanage();  
////	        //设置编号  
////	        salarymanage.setSerial(SerialUtil.salarySerial());  
////	        //通过遍历实现把每一列封装成一个model中，再把所有的model用List集合装载  
////	        salarymanage.setAdminId(adminId);  
////	        salarymanage.setCompany(String.valueOf(ob.get(1)));  
////	        salarymanage.setNumber(String.valueOf(ob.get(2)));  
////	        salarymanage.setName(String.valueOf(ob.get(3)));  
////	        salarymanage.setSex(String.valueOf(ob.get(4)));  
////	        salarymanage.setCardName(String.valueOf(ob.get(5)));  
////	        salarymanage.setBankCard(String.valueOf(ob.get(6)));  
////	        salarymanage.setBank(String.valueOf(ob.get(7)));  
////	        //object类型转Double类型  
////	        salarymanage.setMoney(Double.parseDouble(ob.get(8).toString()));  
////	        salarymanage.setRemark(String.valueOf(ob.get(9)));  
////	        salarymanage.setSalaryDate(salaryDate);  
////	        salaryList.add(salarymanage);
//	        hxPeopleList.add(hxPeople);
//	        hxpeopleMapper.insertSelective(hxPeople);
//	    }  
//	    //批量插入  
////	    salarymanageDao.insertInfoBatch(salaryList); 
//	    
//	}  
	
}
