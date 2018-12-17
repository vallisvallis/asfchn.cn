package com.mengmaclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengmaclub.model.FeeType;
import com.mengmaclub.service.FeeService;
import com.mengmaclub.service.FeeTypeService;
@Controller
@RequestMapping("/")
public class FeeTypeController {
	@Autowired
	private FeeTypeService feeTypeService;
	/**
	 * 1.
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("getAllFeeType")
	public String getAllFeeType(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 100);
		List<FeeType> feeTypes = feeTypeService.findAll();
		
		PageInfo page = new PageInfo(feeTypes, 5);
		model.addAttribute("pageInfo", page);		
		return "allFeeType";
	}

//	 * 
//	 * @param list
//	 * @param model
//	 * @return
//	 */
//	@RequestMapping("1")
//	public String editAllFeeType(List<FeeType> list, Model model) {
//		for (FeeType feeType : list) {
//			feeTypeService.updateByPrimaryKeySelective(feeType);
//		}
//		List<FeeType> FeeTypeList = feeTypeService.findAll();
//		model.addAttribute("FeeTypeList", FeeTypeList);
//		return "getAllFeeType";
//	}
@RequestMapping("toUpdateFeeType")
	public String updateFeeType(int id,Model model){	
	FeeType feetype=feeTypeService.selectByPrimaryKey(id);	
	model.addAttribute("feetype", feetype);
		return "UpdateFeeType";
	}
	

@RequestMapping("UpdateFeeType")
public String updateFeeType(FeeType feeType,Model model){	
	feeTypeService.updateByPrimaryKeySelective(feeType);
	return "redirect:/getAllFeeType";
}
	
	/**
	 * 跳转到费用增加页面
	 * @return
	 */
	@RequestMapping("toAddFeeType")
	public String toAddFeeType() {
		return "addfeeType";
	}
/**
 * 增加费用
 * @param model
 * @param feeType
 * @return
 */
	@RequestMapping("addFeeType")
	public String addFeeType(Model model,FeeType feeType) {
		System.out.println(feeType.toString());
		
		
		feeTypeService.insertSelective(feeType);
		return "redirect:/getAllFeeType";
	}
/**
 * 删除费用
 * @param id
 * @param model
 * @return
 */
	@RequestMapping("delFeeType")
	public String deleteFeeType(int id, Model model) {
		model.addAttribute("FeeType", feeTypeService.deleteByPrimaryKey(id));
		return "redirect:/getAllFeeType";
	}
	
	
	
	
	
	
}
