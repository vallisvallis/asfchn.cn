package com.mengmaclub.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengmaclub.model.JoinMatchTeam;
import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.Match;
import com.mengmaclub.model.MatchGroup;
import com.mengmaclub.model.MatchJob;
import com.mengmaclub.model.MatchList;
import com.mengmaclub.service.JoinMatchTeamPeopleService;
import com.mengmaclub.service.JoinMatchTeamService;
import com.mengmaclub.service.MatchGroupService;
import com.mengmaclub.service.MatchJobService;
import com.mengmaclub.service.MatchListService;
import com.mengmaclub.service.MatchService;

@Controller
@RequestMapping("/")
public class MatchController {

	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchListService matchListService;
@Autowired
	private MatchGroupService matchGroupService;
@Autowired
private MatchJobService matchJobService;
@Autowired
private JoinMatchTeamService joinMatchTeamService;
@Autowired
private JoinMatchTeamPeopleService joinMatchTeamPeopleService;
	/**
	 * 1.显示所有
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("getAllMatch")
	public String getAllMatch(Model model) {
		List<Match> matchList = matchService.findAll();
		model.addAttribute("matchList", matchList);
		return "allMatch";
	}

	/**
	 * 2.显示单个比赛
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/getMatch")
	public String getMatch(int id, Model model) {
		model.addAttribute("match", matchService.selectByPrimaryKey(id));
		return "editMatch";
	}

	/**
	 * 3.分页查询
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("matchInfo")
	public String getMatch(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 100);
		List<Match> matchList = matchService.findAll();
		PageInfo page = new PageInfo(matchList, 100);
		for (Match match : matchList) {
			System.out.println(match.toString());
		}
		List<JoinMatchTeam> joinMatchTeams =joinMatchTeamService.findAllWhichIsYes();
		int num=joinMatchTeams.size();
		model.addAttribute("num",num);
		model.addAttribute("pageInfo", page);
		return "allMatch";
	}
@RequestMapping("showMatchInTeam")
	public String showMatchInTeam(int id,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model){
	PageHelper.startPage(pn, 100);
	List<Match> matchList = matchService.findAll();
	PageInfo page = new PageInfo(matchList, 100);
	for (Match match : matchList) {
		System.out.println(match.toString());
	}
	model.addAttribute("pageInfo", page);
		
		return "allMatchInTeam";
	}
	@RequestMapping("shouwThisMatchInTeam")
public String shouwThisMatchInTeam(int id,Model model){
Match match=	matchService.selectByPrimaryKey(id);
model.addAttribute("match", match);
	return "shouwThisMatchInTeam";
}
	
	@RequestMapping("showthismatchteam")
	public String showthismatchteam(int id,Model model){
		
		List<JoinMatchTeam> joinMatchTeams =joinMatchTeamService.findthismatchteam(id);
		model.addAttribute("joinMatchTeams", joinMatchTeams);
		return "showthismatchteam";
	}
	@RequestMapping("showthismatchpeople")
	public String showthismatchpeople(int id,Model model){
		
		List<JoinMatchTeamPeople> joinMatchTeamPeoples =joinMatchTeamPeopleService.findThisMatchjoinPeople(id);
		model.addAttribute("joinMatchTeamPeoples", joinMatchTeamPeoples);
		return "showthismatchpeople";
	}
@RequestMapping("showThisMatch")
public String showThisMatch(int id,Model model){
	Match match=matchService.selectByPrimaryKey(id);
	List<JoinMatchTeam> joinMatchTeams =joinMatchTeamService.findthismatchteam(id);
	List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findThisMatchjoinPeople(id);
	int nump=joinMatchTeamPeoples.size();
	int num=joinMatchTeams.size();
	model.addAttribute("num",num);
	model.addAttribute("nump",nump);
	model.addAttribute("match", match);
	return "showThisMatch";
}
	// /**
	// * 4.添加比赛
	// *
	// * @param model
	// * @param match
	// * @return
	// */
	// @RequestMapping("addMatch")
	// public String addMatch(Model model, Match match) {
	// if (match != null) {
	// matchService.insertSelective(match);
	// return "redirect:/Match";
	// }
	// return "error";
	// }
	//
	// /**
	// * 5.跳转到比赛添加页面
	// *
	// * @return
	// */
	// @RequestMapping("toAddMatch")
	// public String toAddMatch() {
	// return "addMatch";
	// }

	/**
	 * 6.更新比赛
	 * 
	 * @param model
	 * @param match
	 * @return
	 */
	@RequestMapping("updateMatch")
	public String UpdateMatch(Model model, Match match) {
		Integer i = matchService.updateByPrimaryKeySelective(match);
		if (i != null) {
			match = matchService.selectByPrimaryKey(match.getId());
			model.addAttribute("match", match);
			return "redirect:/matchInfo";
		}
		return "/error";
	}
	@RequestMapping("delMatch")
	public String deleteMatch(int id, Model model) {
		System.out.println(id);
		model.addAttribute("match", matchService.deleteByPrimaryKey(id));
		return "redirect:/matchInfo";
	}
	@RequestMapping("matchList")
	public String matchListIndex(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		List<Match> matchlist = matchService.findAll();

		PageHelper.startPage(pn, 5);

		PageInfo page = new PageInfo(matchlist, 5);
		for (Match match : matchlist) {
			System.out.println(match.toString());
		}
		model.addAttribute("pageInfo", page);

		return "allMatchInIndex";
	}
	// 增加赛事部分
	// 增加赛事"跳转到增加赛事"
	@RequestMapping("toAddMatch")
	public String toAddMatch() {
		return "addMatchFirstStep";
	}

	
	public Date getDate(String time) throws Exception{
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date=sdf.parse(time);	
		return date;
	}
	// 执行第一步并且跳转到第二步 (添加名称，开始时间，结束时间，开始报名时间，结束报名时间)
	@RequestMapping("addMatchFirstStepButton")
	public String addMatchFirstStep(Match match,Model model,String start,String end,String startReport,String endReport) throws Exception{		
	if (start!="" && start.length()!=0) {
		Date startTime=getDate(start);
		match.setStarttime(startTime);
	}
	if (end!="" && end.length()!=0) {
		Date endTime=getDate(end);
		match.setEndtime(endTime);
	}
	if (startReport!="" && startReport.length()!=0) {
		Date startReportTime=getDate(startReport);
		match.setAddtime(startReportTime);
	}
	if (endReport!="" && endReport.length()!=0) {
		Date endReportTime=getDate(endReport);
		match.setEdittime(endReportTime);
	}
		Date push =new Date();
		match.setPushtime(push);
		System.out.println(match.toString());
		matchService.insertSelective(match);
		int id=0;
		for (Match matchTest : matchService.findAll()) {
		if (matchTest.getName().equals(match.getName())) {
			id=matchTest.getId();
		}	
		}
		System.out.println(id);
		Match matchToAdd =matchService.selectByPrimaryKey(id);
		model.addAttribute("matchToAdd", matchToAdd);	
		
		List<MatchList> allMatchList=matchListService.findAll();
		model.addAttribute("allMatchList", allMatchList);
		List<MatchGroup> allMatchGroups=matchGroupService.findAll();
		model.addAttribute("allMatchGroups", allMatchGroups);
		List<MatchJob> allMatchJobs=matchJobService.findAll();
		model.addAttribute("allMatchJobs", allMatchJobs);
		return "addMatchSecondStep";
	}

	// 执行第二步并且跳转到成功失败页面（需要的项目,组别、职务、及职务的最大数）
@RequestMapping("addMatchSecondStepButton")
	public String addMachSecondStep(String matchList,String matchGroup,String matchJob,String num, int id, Model model,@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
	System.out.println("此比赛所支持的项目"+matchList);
	System.out.println("此比赛所支持的组别"+matchGroup);
	System.out.println("此比赛所支持的职务"+matchJob);
	System.out.println("此比赛所支持的职务的最大数"+num);
	System.out.println("此比赛的id"+id);
	//将项目、组别信息添加入比赛
	Match match=matchService.selectByPrimaryKey(id);
	match.setSupportlist(matchList);
	match.setSupportgroup(matchGroup);
	match.setSupportjob(matchJob+";"+num);
	matchService.updateByPrimaryKeySelective(match);
	Match matchNew=matchService.selectByPrimaryKey(id);
	System.out.println(matchNew);
//	String[] a=matchList.split(",");
//	for (String string : a) {
//		System.out.println(string);
//	}	
//		List<Match> allMatchList = matchService.findAll();
//
//		matchService.selectByPrimaryKey(match.getId());
//		for (Match match2 : allMatchList) {
//
//		}
		return getMatch(pn, model);
	}
@RequestMapping("updateMatchInHX")
public String updateMatch(Model model,Match match,String start,String end,String startReport,String endReport) throws Exception{
	if (start!="" && start.length()!=0) {
		Date startTime=getDate(start);
		match.setStarttime(startTime);
	}
	if (end!="" && end.length()!=0) {
		Date endTime=getDate(end);
		match.setEndtime(endTime);
	}
	if (startReport!="" && startReport.length()!=0) {
		Date startReportTime=getDate(startReport);
		match.setAddtime(startReportTime);
	}
	if (endReport!="" && endReport.length()!=0) {
		Date endReportTime=getDate(endReport);
		match.setEdittime(endReportTime);
	}
		Date push =new Date();
		match.setPushtime(push);
	matchService.updateByPrimaryKeySelective(match);
	return "redirect:/matchInfo";
	
}	


//
//	// 判断比赛是否增加成功
//	public String isAddMatchSuccess() {
//		if (true) {
//			return "success";
//		}
//		return "fail";
//	}
	//
	// @RequestMapping("checkTest")
	// public String checkTest(String fruit,Model model){
	// System.out.println(fruit);
	// model.addAttribute("fruit", fruit);
	// return "chekTest2";
	// }

}
