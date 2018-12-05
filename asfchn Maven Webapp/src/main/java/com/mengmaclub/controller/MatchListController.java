package com.mengmaclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.MatchList;
import com.mengmaclub.service.MatchListService;

@Controller
@RequestMapping("/")
public class MatchListController {
	@Autowired
	private MatchListService matchListService;

	/**
	 * 1.显示所有项目
	 * 
	 * @return
	 */
	@RequestMapping("getAllMatchList")
	public String getAllMatchList(Model model) {
		List<MatchList> matchList = matchListService.findAll();
		model.addAttribute("matchList", matchList);
		return "allMatchList";
	}
	/**
	 * 2.显示单个项目
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("getMatchList")
	public String getMatchList(int id, Model model) {
		model.addAttribute("matchList", matchListService.selectByPrimaryKey(id));
		return "editMatchList";
	}
	/**
	 * 3.分页查询
	 * 
	 * @return
	 */
	@RequestMapping("matchListInfo")
	public String getAllMatchList(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 100);
		List<MatchList> allMatchList = matchListService.findAll();
		PageInfo page = new PageInfo(allMatchList, 100);
		model.addAttribute("pageInfo", page);
		return "matchListManager";
	}
@RequestMapping("showThisMatchList")
	public String showThisMatchList(int id,Model model){
		MatchList matchList=matchListService.selectByPrimaryKey(id);
		model.addAttribute("matchList", matchList);
		return "showThisMatchList";
	}
	
@RequestMapping("updateMatchListbutton")
public String changeMatchList(Model model,MatchList matchList){
	matchListService.updateByPrimaryKeySelective(matchList);
	matchList=matchListService.selectByPrimaryKey(matchList.getId());
	System.out.println("修改后的项目为："+matchList);
	return "redirect:/marchListInfo";
}
	
	/**
	 * 4.显示比赛项目列表
	 * 
	 * @param mdoel
	 * @param matchList
	 * @return
	 */
	@RequestMapping("addMatchList")
	public String addMatchList(Model mdoel, MatchList matchList) {
		if (matchList != null) {
			matchListService.insertSelective(matchList);
			return "redirect:/matchListInfo";
		}
		return "error";
	}

	/**
	 * 5.跳转到项目添加页面
	 * 
	 * @return
	 */
	@RequestMapping("toAddMatchList")
	public String toAddMatchList() {
		return "addMatchList";

	}

	/**
	 * 6.删除单个项目
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/deMatchList")
	public String delMatchList(int id, Model model) {
		model.addAttribute("matchList", matchListService.deleteByPrimaryKey(id));
		return "redirect:/matchListInfo";
	}

	/**
	 * 7.更新项目列表
	 * 
	 * @param model
	 * @param matchList
	 * @return
	 */
	@RequestMapping("updateMatchList")
	public String UpdateMatchList(Model model, MatchList matchList) {
		Integer i = matchListService.updateByPrimaryKeySelective(matchList);
		if (i != null) {
			matchList = matchListService.selectByPrimaryKey(matchList.getId());
			model.addAttribute("marchList", matchList);
			return "redirect:/marchListInfo";
		}
		return "error";
	}
}
