package com.mengmaclub.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.ibatis.annotations.Param;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.tags.form.FormTag;

import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;
import com.mengmaclub.model.JoinMatchTeam;
import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.Mangoptionsmatch;
import com.mengmaclub.model.Manyrifmatch;
import com.mengmaclub.model.Match;
import com.mengmaclub.model.MatchGroup;
import com.mengmaclub.model.MatchList;
import com.mengmaclub.model.Matchlist1;
import com.mengmaclub.model.Turnmatchlist;
import com.mengmaclub.model.Twoptionsmatch;
import com.mengmaclub.model.Withfriendmatch;
import com.mengmaclub.service.HxPeopleService;
import com.mengmaclub.service.HxTeamService;
import com.mengmaclub.service.JoinMatchTeamPeopleService;
import com.mengmaclub.service.JoinMatchTeamService;
import com.mengmaclub.service.MangoptionsmatchService;
import com.mengmaclub.service.ManyrifmatchService;
import com.mengmaclub.service.MatchGroupService;
import com.mengmaclub.service.MatchList1Service;
import com.mengmaclub.service.MatchListService;
import com.mengmaclub.service.MatchService;
import com.mengmaclub.service.RefereeService;
import com.mengmaclub.service.TurnMatchListService;
import com.mengmaclub.service.TwoptionsMatchService;
import com.mengmaclub.service.WithfriendmatchService;
import com.mengmaclub.util.Arith;

@Controller
public class RefereeController {
	// 此控制器 只处理 裁判业务 登录，扫码，打分，

	@Autowired
	private RefereeService refereeService;// 裁判服务
	@Autowired
	private JoinMatchTeamPeopleService joinMatchTeamPeopleService;
	@Autowired
	private MatchListService matchListService;
	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchGroupService matchGroupService;
	@Autowired
	private MatchList1Service matchList1Service;
	@Autowired
	private HxTeamService hxTeamService;
	@Autowired
	private JoinMatchTeamService joinMatchTeamService;
	@Autowired
	private TurnMatchListService turnMatchListService;
	@Autowired
	private TwoptionsMatchService twoptionsMatchService;
	@Autowired
	private HxPeopleService hxPeopleService;
	@Autowired
	private MangoptionsmatchService mangoptionsmatchService;
	@Autowired
	private WithfriendmatchService withfriendmatchService;
	@Autowired
	private ManyrifmatchService manyrifmatchService;
	
	DecimalFormat df = new DecimalFormat("######0.00");
	DecimalFormat fmortdouble = new DecimalFormat("0.00");

	/**
	 * 显示所有比赛
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("showMatchInReferee")
	public String showMatchInReferee(Model model, String rid) {
		List<Match> matchs = matchService.findAll();
		/*
		 * 参赛人员资格校验程序
		 */
		// getTeamname();// 6.14更新
		// setTurn(21, 29, 1, 2);
		// //
		// setTurn(21, 29, 3, 3);
		// setTurn(21, 29, 4, 1);
		// setTurn(21, 29, 5, 1);
		// setTurn(21, 29, 6, 1);
		// //
		// setTurn(21, 27, 1, 1);
		// setTurn(21, 27, 3, 2);
		// setTurn(21, 27, 4, 1);
		// setTurn(21, 27, 5, 1);
		// setTurn(21, 26, 1, 1);程前
		// setTurn(21, 26, 3, 1);
		// setTurn(21, 26, 4, 1);
		// setTurn(21, 26, 5, 1);
		// setTurn(21, 31, 3, 1);
		// setTurn(21, 31, 5, 1);
		// setTurn(21, 17, 3, 1);
		// setTurn(21, 17, 5, 1);
		// setTurn(21, 18, 1, 1);
		// bornMangList();
		// docalc();
		// doMatchList8(21);// 3人接力
		// addNum(21);//编号程序
		// sortTurnTwo();//换算分测试
		// setconfirm();
	 //bornAllJpscoreList();
		model.addAttribute("matchs", matchs);
		model.addAttribute("rid", rid);
		return "showMatchInRefereeTest";
	}
	@RequestMapping("bornAllJpscoreList")
	public void bornAllJpscoreList(int matchid) {
//		int matchidddd=Integer.parseInt(matchid);
		//addNum(matchid);
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&执行一次&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		int i = 0;
		int a = 0;
		int j = 1;
		doMatchList8(matchid);
		List<JoinMatchTeamPeople> alljJoinMatchTeamPeoples = joinMatchTeamPeopleService.findThisMatchjoinPeople(matchid);
		System.out.println("======================= 此消息只能执行一次"+alljJoinMatchTeamPeoples.size()+"=========================================");
		for (JoinMatchTeamPeople joinMatchTeamPeople : alljJoinMatchTeamPeoples) {
			if (joinMatchTeamPeople.getJoinmatchlist() == null) {
				joinMatchTeamPeople.setJoinmatchlist(0);
			}
			if (joinMatchTeamPeople.getIsteammatchlist() == null || joinMatchTeamPeople.getIsteammatchlist() == ""
					|| joinMatchTeamPeople.getIsteammatchlist().equals("")
					|| joinMatchTeamPeople.getIsteammatchlist().length() == 0) {
				joinMatchTeamPeople.setIsteammatchlist("0");
			}
			if( (joinMatchTeamPeople.getGage()==null )||(joinMatchTeamPeople.getGage() != 1 && joinMatchTeamPeople.getGage() != 2&&
					joinMatchTeamPeople.getGage() != 3 && joinMatchTeamPeople.getGage() != 4&&
					joinMatchTeamPeople.getGage() != 5 && joinMatchTeamPeople.getGage() != 6)) {
				joinMatchTeamPeople.setGage(7);
			}
			if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
					|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
					|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
					|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
					|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 20 || joinMatchTeamPeople.getJoinmatchlist() == 30) {
				Twoptionsmatch twoptionsmatch = new Twoptionsmatch();
				twoptionsmatch.setJoingage(joinMatchTeamPeople.getGage());
				twoptionsmatch.setJoinlist(joinMatchTeamPeople.getJoinmatchlist());
				twoptionsmatch.setJoinpeopleid(joinMatchTeamPeople.getId());
				twoptionsmatch.setName(joinMatchTeamPeople.getName());
				twoptionsmatch.setSn(joinMatchTeamPeople.getPeoplesn());
				twoptionsmatch.setIsteammatch(Integer.parseInt(joinMatchTeamPeople.getIsteammatchlist()));
				twoptionsmatch.setTeamname(joinMatchTeamPeople.getTeamname());
				twoptionsmatch.setJoinmatch(joinMatchTeamPeople.getMatchid());
				twoptionsmatch.setNum(joinMatchTeamPeople.getScore2());
				twoptionsMatchService.insertSelective(twoptionsmatch);
			} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
					|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
					|| joinMatchTeamPeople.getJoinmatchlist() == 13 || joinMatchTeamPeople.getJoinmatchlist() == 14) {
				Mangoptionsmatch mangoptionsmatch = new Mangoptionsmatch();
				mangoptionsmatch.setJoingage(joinMatchTeamPeople.getGage());
				mangoptionsmatch.setJoinlist(joinMatchTeamPeople.getJoinmatchlist());
				mangoptionsmatch.setJoinpeopleid(joinMatchTeamPeople.getId());
				mangoptionsmatch.setName(joinMatchTeamPeople.getName());
				mangoptionsmatch.setSn(joinMatchTeamPeople.getPeoplesn());
				mangoptionsmatch.setIsteammatch(Integer.parseInt(joinMatchTeamPeople.getIsteammatchlist()));
				mangoptionsmatch.setTeamname(joinMatchTeamPeople.getTeamname());
				mangoptionsmatch.setJoinmatch(joinMatchTeamPeople.getMatchid());
				mangoptionsmatch.setNum(joinMatchTeamPeople.getScore2());
				mangoptionsmatchService.insertSelective(mangoptionsmatch);
			} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
					|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
					|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
					|| joinMatchTeamPeople.getJoinmatchlist() == 18
			) {
				Turnmatchlist turnmatchlist = new Turnmatchlist();
				turnmatchlist.setJoingage(joinMatchTeamPeople.getGage());
				turnmatchlist.setTurn1(1);
				turnmatchlist.setTurn2(2);
				turnmatchlist.setJoinlist(joinMatchTeamPeople.getJoinmatchlist());
				turnmatchlist.setJoinpeopleid(joinMatchTeamPeople.getId());
				turnmatchlist.setName(joinMatchTeamPeople.getName());
				turnmatchlist.setSn(joinMatchTeamPeople.getPeoplesn());
				turnmatchlist.setIsteammatch(Integer.parseInt(joinMatchTeamPeople.getIsteammatchlist()));
				turnmatchlist.setTeamname(joinMatchTeamPeople.getTeamname());
				turnmatchlist.setJoinmatch(joinMatchTeamPeople.getMatchid());
				turnmatchlist.setNum(joinMatchTeamPeople.getScore2());
				turnMatchListService.insertSelective(turnmatchlist);
				
				
				//setTurn1(joinMatchTeamPeople.getMatchid(),  joinMatchTeamPeople.getJoinmatchlist() ,  joinMatchTeamPeople.getGage(), 2);//turn为批次
				//setTurn2(joinMatchTeamPeople.getMatchid(),  joinMatchTeamPeople.getJoinmatchlist() ,  joinMatchTeamPeople.getGage(), 2);
				// 生成批次	
				// *
			}else if(joinMatchTeamPeople.getJoinmatchlist() == 9 || joinMatchTeamPeople.getJoinmatchlist() == 25
					|| joinMatchTeamPeople.getJoinmatchlist() == 34 ){
				Manyrifmatch manyrifmatch= new Manyrifmatch();
				manyrifmatch.setJoinpeopleid(joinMatchTeamPeople.getId());
				manyrifmatch.setJoingage(joinMatchTeamPeople.getGage());
				manyrifmatch.setJoinlist(joinMatchTeamPeople.getJoinmatchlist());
				manyrifmatch.setJoinmatch(joinMatchTeamPeople.getMatchid());
				manyrifmatch.setName(joinMatchTeamPeople.getName());
				manyrifmatch.setSn(joinMatchTeamPeople.getPeoplesn());
				manyrifmatch.setIsteammatch(Integer.parseInt(joinMatchTeamPeople.getIsteammatchlist()));
				manyrifmatch.setTeamname(joinMatchTeamPeople.getTeamname());
				manyrifmatch.setJoinmatch(joinMatchTeamPeople.getMatchid());
				manyrifmatch.setNum(joinMatchTeamPeople.getScore2());
				manyrifmatchService.insertSelective(manyrifmatch);
				
				
			}
			System.out.println("此人生成完毕" + i);
			i++;
		}
		System.out.println("生成完毕共:" + i + "人");
	}

	public void addNum(int matchid) {
		List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService.findThisMatchjoinPeople(matchid);
		int i = 1;
		for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {

			if (i < 10) {
				joinMatchTeamPeople.setScore2("00" + i);
				i++;
			} else if (i < 100 && i >= 10) {
				joinMatchTeamPeople.setScore2("0" + i);
				i++;
			} else if (i >= 100) {
				joinMatchTeamPeople.setScore2(Integer.toString(i));
				i++;
			}
			joinMatchTeamPeopleService.updateByPrimaryKeySelective(joinMatchTeamPeople);
		}
	}
	/**
	 * 显示此比赛的所有项目
	 * 
	 * @param match
	 * @param model
	 * @return
	 */
	@RequestMapping("showThisMatchListInReferee")
	public String showThisMatchListInReferee(Match match, Model model, String rid) {
		System.out.println(match.getId());
		match = matchService.selectByPrimaryKey(match.getId());
		match.getSupportlist();
		System.out.println(match.getSupportlist());
		List<MatchList> thisMatchMatchLists = new ArrayList<>();
		if (match.getSupportlist() != "" && match.getSupportlist().length() != 0) {
			String list = match.getSupportlist();
			if (list.contains(",")) {
				String[] supportList = list.split(",");
				for (int i = 0; i < supportList.length; i++) {
					System.out.println(supportList[i]);
					MatchList thisMatchSupportMatchList = matchListService
							.selectByPrimaryKey(Integer.parseInt(supportList[i]));
					thisMatchMatchLists.add(thisMatchSupportMatchList);
					System.out.println("此比赛中项目为：（单个显示）" + thisMatchSupportMatchList.toString());
				}
			}
		}
		model.addAttribute("thisMatchMatchLists", thisMatchMatchLists);
		model.addAttribute("match", match.getId());
		model.addAttribute("rid", rid);
		return "showThisMatchListInReferee";
	}
	/**
	 * 显示该项目的组别
	 * 
	 * @param id
	 * @param matchId
	 * @param model
	 * @return
	 */
	@RequestMapping("showThisMatchListAllGroup")
	public String showThisMatchListAllGroup(int id, int matchId, Model model, String rid) {
		System.out.println(id);
		System.out.println(matchId);
		List<MatchGroup> thisMatchGroups = matchGroupService.findAll();
		model.addAttribute("thisMatchGroups", thisMatchGroups);
		model.addAttribute("matchListId", id);
		model.addAttribute("matchId", matchId);
		model.addAttribute("rid", rid);
		// **
		return "showThisMatchListAllGroup";
	}
	/**
	 * 显示该组别的运动员
	 * 
	 * @param matchid
	 * @param matchListId
	 * @param matchgroup
	 * @param model
	 * @return
	 */

	@RequestMapping("showJoinPeopleWhoHasSelect")
	public String showJoinPeopleWhoHasSelect(@Param("matchid") int matchid, @Param("matchListId") int matchListId,
			@Param("matchgroup") int matchgroup, Model model, String rid) {
		System.out.println(matchid);
		System.out.println(matchListId);
		System.out.println(matchgroup);
		List<JoinMatchTeamPeople> peopleWhoHasSelect = joinMatchTeamPeopleService.showSelectPeople(matchid, matchListId,
				matchgroup);
		model.addAttribute("peopleWhoHasSelect", peopleWhoHasSelect);
		model.addAttribute("rid", rid);
		// if (matchListId == 26 || matchListId == 17 || matchListId == 18
		// || matchListId == 27 || matchListId == 29 || matchListId == 31) {
		// return "pleaseinputturn";
		//}
		return "showJoinPeopleWhoHasSelect";
	}

	public void getTeamname() {
		/*
		 * 删除不合法的参赛会员
		 */
		List<Integer> whichTeamisNoConfirm = joinMatchTeamService.showIdWhoNotConfirm();
		List<JoinMatchTeam> aa = joinMatchTeamService.findAll();
		List<Integer> bb = new ArrayList<>();
		for (JoinMatchTeam joinMatchTeam : aa) {
			bb.add(joinMatchTeam.getId());
		}
		List<JoinMatchTeam> cc = joinMatchTeamService.findAllWhichIsYes();
		for (JoinMatchTeam joinMatchTeam : cc) {
			bb.remove(joinMatchTeam.getId());
		}
		for (Integer in : bb) {
			joinMatchTeamService.deleteByPrimaryKey(in);
			System.out.println("删除不合法队伍");
		}
		for (Integer integer : whichTeamisNoConfirm) {
			System.out.println("不合格的队伍id为：" + integer);
			joinMatchTeamPeopleService.deleteJoinPeoplewhoisNoConfirm(integer);
			System.out.println("删除成功");
		}
		for (JoinMatchTeam joinMatchTeam : cc) {
			if (joinMatchTeam.getTeamname() == joinMatchTeam.getBlongteamname()
					|| joinMatchTeam.getTeamname().equals(joinMatchTeam.getBlongteamname())) {
				joinMatchTeam.setTeamname("");
				joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
			}
		}
		List<JoinMatchTeamPeople> all = joinMatchTeamPeopleService.findAll();
		for (JoinMatchTeamPeople joinMatchTeamPeople : all) {
			JoinMatchTeam joinMatchTeam = joinMatchTeamService
					.selectByPrimaryKey(joinMatchTeamPeople.getJoinwhichjointeam());
			if (joinMatchTeam == null) {
				joinMatchTeamPeopleService.deleteByPrimaryKey(joinMatchTeamPeople.getId());
				System.out.println("删除不合法的会员");
			}

		}

		//
		List<JoinMatchTeamPeople> lists = joinMatchTeamPeopleService.findAll();
		for (JoinMatchTeamPeople joinMatchTeamPeople : lists) {
			System.out.println(joinMatchTeamPeople.getId());
			HxTeam hxTeam = hxTeamService.selectByPrimaryKey(joinMatchTeamPeople.getTeamid());
			System.out.println("此人的会员单位为" + hxTeam.getFullname());
			if (hxTeam.getFullname() == "" || hxTeam.getFullname().equals("") || hxTeam.getFullname().equals(null)) {
				System.out.println(hxTeam.getId());
				String teamname = "非法会员单位";
				joinMatchTeamPeople.setTeamname(teamname);
				joinMatchTeamPeopleService.updateByPrimaryKeySelective(joinMatchTeamPeople);
			} else {
				String teamname = hxTeam.getFullname();
				joinMatchTeamPeople.setTeamname(teamname);
				joinMatchTeamPeopleService.updateByPrimaryKeySelective(joinMatchTeamPeople);
			}
		}
	}

	/**
	 * 
	 * 准备扫码
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("redayQr")
	public String readyQr(int id, Model model, String rid) {
		JoinMatchTeamPeople joinMatchTeamPeople = joinMatchTeamPeopleService.selectByPrimaryKey(id);
		model.addAttribute("joinMatchTeamPeople", joinMatchTeamPeople);
		model.addAttribute("rid", rid);
		return "startQr";
	}

	/**
	 * 开始扫码
	 * 
	 * @param str
	 * @param model
	 * @param jpid
	 * @return
	 */
	@RequestMapping("StartQr")
	public String Qr(String str, Model model, int jpid, String rid) {
		String needcut = "60390c7e429e38e8449519011a24f79d";
		String[] ineed;
		int id = 0;
		if (str.contains(needcut)) {
			ineed = str.split("!");
			id = Integer.parseInt(ineed[0]);
			System.out.println("此人的id为" + id);
			if (id == 1475268423) {
				return startMarking(jpid, model, rid);
			}
			if (jpid != id) {
				JoinMatchTeamPeople joinMatchTeamPeople = joinMatchTeamPeopleService.selectByPrimaryKey(jpid);
				model.addAttribute("joinMatchTeamPeople", joinMatchTeamPeople);
				return "qrError";
			}
		}
		return startMarking(id, model, rid);
	}
	@RequestMapping("StrightQr")
	public String StrightQr(String str, String rid, Model model) {
		String needcut = "60390c7e429e38e8449519011a24f79d";
		String[] ineed;
		int id = 0;
		if (str.contains(needcut)) {
			ineed = str.split("!");
			id = Integer.parseInt(ineed[0]);
			if (id == 1475268423) {
				return "nothisPeople";
			}
			System.out.println("此人的jpid为" + id);
			JoinMatchTeamPeople joinMatchTeamPeople = joinMatchTeamPeopleService.selectByPrimaryKey(id);
			if (joinMatchTeamPeople == null || joinMatchTeamPeople.getJoinmatchlist() == null) {
				return "nothisPeople";
			}
		}
		model.addAttribute("rid", rid);
		return startMarking(id, model, rid);
	}
	/**
	 * 开始打分（第一轮）
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("startMarking")
	// 10.14 新项目集成
	public String startMarking(int id, Model model, String rid) {
		System.out.println(id);
		JoinMatchTeamPeople thisJoinMatchTeamPeople = joinMatchTeamPeopleService.selectByPrimaryKey(id);
		int matchListId = thisJoinMatchTeamPeople.getJoinmatchlist();
		model.addAttribute("thisJoinMatchTeamPeople", thisJoinMatchTeamPeople);
		model.addAttribute("rid", rid);
		System.out.println("裁判的id为" + rid);
		// 10月的比赛在这里跳转
		String markingUrl;
		// 新项目发送道页面上
		Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(thisJoinMatchTeamPeople.getPeoplesn(),
				thisJoinMatchTeamPeople.getId());
		model.addAttribute("twoptionsmatch", twoptionsmatch);// √
		Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService.findBySnJid(thisJoinMatchTeamPeople.getPeoplesn(),
				thisJoinMatchTeamPeople.getId());
		model.addAttribute("mangoptionsmatch", mangoptionsmatch);// √
		Turnmatchlist turnmatchlist = turnMatchListService.findByJpId(thisJoinMatchTeamPeople.getId());
		model.addAttribute("turnmatchlist", turnmatchlist);
		Withfriendmatch withfriendmatch = withfriendmatchService.findByJpId(thisJoinMatchTeamPeople.getId());
		model.addAttribute("withfriendmatch", withfriendmatch);// √
		Manyrifmatch manyrifmatch = manyrifmatchService.findByJpId(thisJoinMatchTeamPeople.getId());
		model.addAttribute("manyrifmatch", manyrifmatch); // √
		markingUrl = "markingOnMatchList" + matchListId;
		/*
		 * 在这里加上成绩判断，如果两轮都有成绩，禁止再次打分
		 */
		if (thisJoinMatchTeamPeople.getJoinmatchlist() == 1 || thisJoinMatchTeamPeople.getJoinmatchlist() == 2
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 3 || thisJoinMatchTeamPeople.getJoinmatchlist() == 4
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 6 || thisJoinMatchTeamPeople.getJoinmatchlist() == 7
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 32 || thisJoinMatchTeamPeople.getJoinmatchlist() == 33
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 19
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 20|| thisJoinMatchTeamPeople.getJoinmatchlist() == 30) {

			Twoptionsmatch twoptionsmatchxx = twoptionsMatchService.findBySnJid(twoptionsmatch.getSn(), id);

			if ((twoptionsmatchxx.getOneroundisconfirm() == 2) && (twoptionsmatchxx.getTworoundisconfirm() == 2)) {
				model.addAttribute("twoptionsmatch", twoptionsmatchxx);
				return "twoptionsmatchhasMarking";
			}
		} else if (thisJoinMatchTeamPeople.getJoinmatchlist() == 5 || thisJoinMatchTeamPeople.getJoinmatchlist() == 10
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 11 || thisJoinMatchTeamPeople.getJoinmatchlist() == 12
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 13
				|| thisJoinMatchTeamPeople.getJoinmatchlist() == 14) {
			Mangoptionsmatch mangoptionsmatchxx = mangoptionsmatchService.findBySnJid(mangoptionsmatch.getSn(), id);
			if ((mangoptionsmatchxx.getOneroundisconfirm() == 2) && (mangoptionsmatchxx.getTworoundisconfirm() == 2)) {
				model.addAttribute("mangoptionsmatchxx", mangoptionsmatchxx);
				return "mangoptionsmatchhasMarking";
			}

		}

		return markingUrl;
	}

	/*
	 * 确认分数
	 */
	@RequestMapping("confirmScore")
	public String confirmScore(String str, // 二维码
			Model model, String joinpeopleid, // 参赛人员id
			String peopleid, // 会员id
			String rid, // 裁判id
			String scoreid// 成绩单id
	) {
		System.err.println("开始执行成绩确认程序");
		System.out.println(str);
		String needcut = "60390c7e429e38e8449519011a24f79d";
		String[] ineed;
		int strid = 0;
		int jid = Integer.parseInt(joinpeopleid);
		if (str.contains(needcut)) {
			ineed = str.split("!");
			strid = Integer.parseInt(ineed[0]);
			System.out.println("确认界面二维码解析后此人的参赛人员中的id为" + strid);
		}

		JoinMatchTeamPeople joinMatchTeamPeople = joinMatchTeamPeopleService.selectByPrimaryKey(jid);
		if (strid == 1475268423 || strid == jid) {
			/*
			 * 分析这个人的参赛项目
			 */
			/*
			 * 单轮单参数项目
			 */
			if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
					|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
					|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
					|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
					|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 20 || joinMatchTeamPeople.getJoinmatchlist() == 30) {
				/*10个
				 * 查找此人的成绩单
				 */
				System.out.println("此项目是单轮但参数项目");
				System.out.println("开始执行单轮但项目打分");
				Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
						jid);
				/*
				 * 判断是第几轮
				 */
				if (twoptionsmatch.getOneroundisconfirm() == 1 || twoptionsmatch.getOneroundisconfirm() == 0) {
					twoptionsmatch.setOneroundisconfirm(2);
				} else if (twoptionsmatch.getOneroundisconfirm() == 2 || twoptionsmatch.getTworoundisconfirm() == 1
						|| twoptionsmatch.getTworoundisconfirm() == 0) {
					twoptionsmatch.setTworoundisconfirm(2);
				}
				twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatch);
			} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
					|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
					|| joinMatchTeamPeople.getJoinmatchlist() == 13 || joinMatchTeamPeople.getJoinmatchlist() == 14) {
				/*6个
				 * 查找此人的成绩单
				 */
				System.out.println("此项目是单轮多参数项目");
				System.out.println("开始执行单轮多参数项目打分");
				Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService
						.findBySnJid(joinMatchTeamPeople.getPeoplesn(), jid);
				/*
				 * 判断是第几轮
				 */
				System.out.println("开始确认成绩");
				if (mangoptionsmatch.getOneroundisconfirm() == 1 || mangoptionsmatch.getOneroundisconfirm() == 0) {
					System.out.println("开始确认第一轮的成绩");
					mangoptionsmatch.setOneroundisconfirm(2);
				} else if (mangoptionsmatch.getOneroundisconfirm() == 2 || mangoptionsmatch.getTworoundisconfirm() == 1
						|| mangoptionsmatch.getTworoundisconfirm() == 0) {
					System.out.println("开始确认第二轮的成绩");
					mangoptionsmatch.setTworoundisconfirm(2);
				}
				System.out.println("上面如果没有确认信息，测确认失败");
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch);
			}else if(joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
					|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
					|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
					|| joinMatchTeamPeople.getJoinmatchlist() == 18 ){
				/*7个
				 * 查找此人的成绩单
				 */
				System.out.println("此项目批次项目");
				System.out.println("开始执行单轮多参数项目打分");
				Turnmatchlist turnmatchlist = turnMatchListService
						.findBySnJid(joinMatchTeamPeople.getPeoplesn(), jid);
				/*
				 * 判断是第几轮
				 */
				System.out.println("开始确认成绩");
				if (turnmatchlist.getOneroundisconfirm() == 1 || turnmatchlist.getOneroundisconfirm() == 0) {
					System.out.println("开始确认第一轮的成绩");
					turnmatchlist.setOneroundisconfirm(2);
				} else if (turnmatchlist.getOneroundisconfirm() == 2 || turnmatchlist.getTworoundisconfirm() == 1
						|| turnmatchlist.getTworoundisconfirm() == 0) {
					System.out.println("开始确认第二轮的成绩");
					turnmatchlist.setTworoundisconfirm(2);
				}
				System.out.println("上面如果没有确认信息，测确认失败");
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlist);
			}else if(joinMatchTeamPeople.getJoinmatchlist() == 8){
				
				/*1个
				 * 查找此人的成绩单
				 */
				System.out.println("此项目批次项目");
				System.out.println("开始执行单轮多参数项目打分");
			 Withfriendmatch withfriendmatch=withfriendmatchService.findByJpId(jid);
				/*
				 * 判断是第几轮
				 */
				System.out.println("开始确认成绩");
				if (withfriendmatch.getOneroundisconfirm() == 1 || withfriendmatch.getOneroundisconfirm() == 0) {
					System.out.println("开始确认第一轮的成绩");
					withfriendmatch.setOneroundisconfirm(2);
				} else if (withfriendmatch.getOneroundisconfirm() == 2 || withfriendmatch.getTworoundisconfirm() == 1
						|| withfriendmatch.getTworoundisconfirm() == 0) {
					System.out.println("开始确认第二轮的成绩");
					withfriendmatch.setTworoundisconfirm(2);
				}
				System.out.println("上面如果没有确认信息，测确认失败");
				withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch);
				
				
				
				
				
				
			}else if(joinMatchTeamPeople.getJoinmatchlist() == 9 || joinMatchTeamPeople.getJoinmatchlist() == 25){
				System.out.println("此项目批次项目");
				System.out.println("开始执行多裁判多参数项目打分");
				Manyrifmatch manyrifmatch=manyrifmatchService.findByJpId(jid);
				System.out.println("开始确认成绩");
				 manyrifmatch.setTworoundisconfirm(2);//确认
				System.out.println("上面如果没有确认信息，测确认失败");
				manyrifmatchService.updateByPrimaryKeySelective(manyrifmatch);
				
				
			}
		} else {
			model.addAttribute("joinMatchTeamPeople", joinMatchTeamPeople);
			return "qrError2";
		}
		return "scoreSuccess";
	}
	/**
	 * 裁判扫码直接打分
	 * 
	 * @param str
	 * @param model
	 * @return
	 */
	@RequestMapping("readAndMarking")
	public String readAndMarking(String refereeid, Model model) {
		System.out.println(refereeid);
		model.addAttribute("rid", refereeid);
		return "readAndMarking";
	}
	public String thisPeopleHasMarked(int id, Model model) {
		List<Matchlist1> ml1 = matchList1Service.listpeoplefindBypeopleid(id);
		for (Matchlist1 matchlist1 : ml1) {
			if (matchlist1.getScore1() != null && matchlist1.getScore2() != null && matchlist1.getScore3() != null) {
				return "这个人已经打过分了";
			}
		}
		return "去打分";
	}
	/*
	 * 项目更新 锁分9个 此程序管理的项目有 1.红雀 2.蓝翔 3.小飞龙4.创新号 7.米奇一号 32.东风一号 33.小力士伞降 20.水火箭30
	 * 6. 蓝3
	 */
	@RequestMapping("getMarking1")
	public String getMarking1(Twoptionsmatch twoptionsmatch, int joinpeopleid, Model model) {
		System.err.println("开始执行单轮但参数项目打分程序");
		// 校验程序，对输入的内容经行 校验
		// 判断这个成绩是哪一轮的
		// twoptionsmatch.getOneroundisconfirm(); 0为 无，1为打分未确认，2为打分已确认
		Twoptionsmatch twoptionsmatchss = twoptionsMatchService.findBySnJid(twoptionsmatch.getSn(), joinpeopleid);
		System.out.println("页面上传来的值：" + twoptionsmatch);
		System.out.println("数据中的值" + twoptionsmatchss);
		if (twoptionsmatchss.getOneroundisconfirm() == null || twoptionsmatchss.getOneroundisconfirm() == 0) {// 说明未打成绩
			twoptionsmatchss.setOneroundrid(twoptionsmatch.getOneroundrid());
			twoptionsmatchss.setOneroundisconfirm(1);
			twoptionsmatchss.setScoreone(twoptionsmatch.getScoreone());
			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatchss);
		} else {
			Twoptionsmatch twoptionsmatchPerToWriteTwo = twoptionsMatchService.findBySnJid(twoptionsmatch.getSn(),
					joinpeopleid);
			twoptionsmatchPerToWriteTwo.setScoretwo(twoptionsmatch.getScoretwo());
			twoptionsmatchPerToWriteTwo.setTworoundrid(twoptionsmatch.getTworoundrid());
			twoptionsmatchPerToWriteTwo.setTworoundisconfirm(1);
			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatchPerToWriteTwo);
		}
		Twoptionsmatch twoptionsmatchWhoNeedtoConfirm = twoptionsMatchService.findBySnJid(twoptionsmatch.getSn(),
				joinpeopleid);
		
		sort(twoptionsmatchWhoNeedtoConfirm);
		Twoptionsmatch twoptionsmatchWhoNeedtoConfirm1 = twoptionsMatchService.findBySnJid(twoptionsmatch.getSn(),
				joinpeopleid);
		model.addAttribute("twoptionsmatchWhoNeedtoConfirm", twoptionsmatchWhoNeedtoConfirm1);
		System.err.println("单轮但参数项目打分程序执行完毕");
		return "twoptionsmatchMarkingsuccess";
	}

	/*
	 * 
	 * 此程序管理的项目有 5. 蓝翔2 10.美利达 11.天戈 12.没嘉兴 13.双江共轴 14.空中展示
	 */

	public void bornMangList() {
		List<JoinMatchTeamPeople> jplist = joinMatchTeamPeopleService.findThisMatchThisMatchlist(21, 10);
		for (JoinMatchTeamPeople join : jplist) {
			Mangoptionsmatch mangoptionsmatch = new Mangoptionsmatch();
			mangoptionsmatch.setName(join.getName());
			mangoptionsmatch.setJoinpeopleid(join.getId());
			mangoptionsmatch.setJoingage(join.getGage());
			mangoptionsmatch.setJoinlist(join.getJoinmatchlist());
			mangoptionsmatch.setSn(join.getPeoplesn());
			// Mangoptionsmatch mangoptionsmatchx = calculate(mangoptionsmatch);
			mangoptionsmatchService.insertSelective(mangoptionsmatch);
		}

	}

	public void docalc() {
		List<Mangoptionsmatch> allM = mangoptionsmatchService.findAll();
		for (Mangoptionsmatch mangoptionsmatch : allM) {
			if (mangoptionsmatch.getJoinlist() == 10) {
				Mangoptionsmatch mangoptionsmatchx = calculate(mangoptionsmatch);
				mangoptionsmatchService.insertSelective(mangoptionsmatchx);
			}
		}
	}
	@RequestMapping("getMarking2")
	public String getMarking2(Mangoptionsmatch mangoptionsmatch, int joinpeopleid, Model model) {
		// 开始执行单轮多参数项目
		Mangoptionsmatch mangoptionsmatchss = mangoptionsmatchService.findBySnJid(mangoptionsmatch.getSn(),
				joinpeopleid);
		System.out.println("页面上传来的值：" + mangoptionsmatch);
		System.out.println("数据库中的值：" + mangoptionsmatchss);
		if (mangoptionsmatchss.getOneroundisconfirm() == null || mangoptionsmatchss.getOneroundisconfirm() == 0) {// 说明未打成绩
			System.out.println("此信息只有再打第一轮的时候才会出现");
			mangoptionsmatchss.setScore1one(mangoptionsmatch.getScore1one());
			mangoptionsmatchss.setScore2one(mangoptionsmatch.getScore2one());
			mangoptionsmatchss.setScore3one(mangoptionsmatch.getScore3one());
			mangoptionsmatchss.setScore4one(mangoptionsmatch.getScore4one());
			mangoptionsmatchss.setScore5one(mangoptionsmatch.getScore5one());
			mangoptionsmatchss.setScore6one(mangoptionsmatch.getScore6one());
			mangoptionsmatchss.setScore7one(mangoptionsmatch.getScore7one());
			mangoptionsmatchss.setScore8one(mangoptionsmatch.getScore8one());
			mangoptionsmatchss.setScore9one(mangoptionsmatch.getScore9one());
			mangoptionsmatchss.setScore10one(mangoptionsmatch.getScore10one());
			mangoptionsmatchss.setOneroundrid(mangoptionsmatch.getOneroundrid());
			mangoptionsmatchss.setOneroundisconfirm(1);
			System.out.println("第一轮更新前：" + mangoptionsmatchss);
			mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatchss);
		} else {
			System.out.println("此信息只有再打第二轮的时候才会出现");
			Mangoptionsmatch mangoptionsmatchPerToWriteTwo = mangoptionsmatchService
					.findBySnJid(mangoptionsmatch.getSn(), joinpeopleid);
			mangoptionsmatchPerToWriteTwo.setScore1two(mangoptionsmatch.getScore1two());
			mangoptionsmatchPerToWriteTwo.setScore2two(mangoptionsmatch.getScore2two());
			mangoptionsmatchPerToWriteTwo.setScore3two(mangoptionsmatch.getScore3two());
			mangoptionsmatchPerToWriteTwo.setScore4two(mangoptionsmatch.getScore4two());
			mangoptionsmatchPerToWriteTwo.setScore5two(mangoptionsmatch.getScore5two());
			mangoptionsmatchPerToWriteTwo.setScore6two(mangoptionsmatch.getScore6two());
			mangoptionsmatchPerToWriteTwo.setScore7two(mangoptionsmatch.getScore7two());
			mangoptionsmatchPerToWriteTwo.setScore8two(mangoptionsmatch.getScore8two());
			mangoptionsmatchPerToWriteTwo.setScore9two(mangoptionsmatch.getScore9two());
			mangoptionsmatchPerToWriteTwo.setScore10two(mangoptionsmatch.getScore10two());
			mangoptionsmatchPerToWriteTwo.setTworoundrid(mangoptionsmatch.getTworoundrid());
			mangoptionsmatchPerToWriteTwo.setTworoundisconfirm(1);
			System.out.println("第二轮更新前：" + mangoptionsmatchPerToWriteTwo);
			mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatchPerToWriteTwo);
		}
		
		Mangoptionsmatch mangoptionsmatchWhoNeedtoConfirm = mangoptionsmatchService
				.findBySnJid(mangoptionsmatch.getSn(), joinpeopleid);
		sort(mangoptionsmatchWhoNeedtoConfirm);
		Mangoptionsmatch mangoptionsmatchWhoNeedtoConfirm1 = mangoptionsmatchService
				.findBySnJid(mangoptionsmatch.getSn(), joinpeopleid);
		model.addAttribute("mangoptionsmatchWhoNeedtoConfirm", mangoptionsmatchWhoNeedtoConfirm1);
		return "mangoptionsmatchMarkingsuccess";
	}

	public Mangoptionsmatch rankCalculate(Mangoptionsmatch mangoptionsmatch) {
		// sortclacs
		int gage = mangoptionsmatch.getJoingage();
		int matchlist = mangoptionsmatch.getJoinlist();
		List<Mangoptionsmatch> findWhereIsMyListGagePeople = mangoptionsmatchService.findWhereIsMyListGagePeople(gage,
				matchlist);
		for (Mangoptionsmatch mangoptionsmatch3 : findWhereIsMyListGagePeople) {
			System.out.println("准备排名的list");
			System.out.println("rank：" + mangoptionsmatch3.getName() + "排名" + mangoptionsmatch3.getRank() + "第一轮分数"
					+ mangoptionsmatch3.getScorefinalone() + "第二轮分数" + mangoptionsmatch3.getScorefinaltwo() + "总分数"
					+ mangoptionsmatch3.getScorefinal());
		}
		findWhereIsMyListGagePeople = sortclacs(findWhereIsMyListGagePeople);
		System.out.println("更新前：" + mangoptionsmatch.getName() + "第一轮分数" + mangoptionsmatch.getScorefinalone() + "第二轮分数"
				+ mangoptionsmatch.getScorefinaltwo() + "总分数" + mangoptionsmatch.getScorefinal());
		System.out.println("出现此文字说明遍历成功" + findWhereIsMyListGagePeople.size());
		for (Mangoptionsmatch mangoptionsmatch2 : findWhereIsMyListGagePeople) {
			System.out.println("出现此文字说明遍历成功");
			System.out.println("rank：" + mangoptionsmatch2.getName() + "排名" + mangoptionsmatch2.getRank() + "第一轮分数"
					+ mangoptionsmatch2.getScorefinalone() + "第二轮分数" + mangoptionsmatch2.getScorefinaltwo() + "总分数"
					+ mangoptionsmatch2.getScorefinal());
			// mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch2);
			if (mangoptionsmatch.getSn() == (mangoptionsmatch2.getSn())) {
				System.out.println("排序程序结果显示此人：" + mangoptionsmatch);
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch2);
			}

		}
		System.out.println("第二次计算后的更新前：" + mangoptionsmatch.getName() + "第一轮分数" + mangoptionsmatch.getScorefinalone()
				+ "第二轮分数" + mangoptionsmatch.getScorefinaltwo() + "总分数" + mangoptionsmatch.getScorefinal());

		mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch);

		// mangoptionsmatch =
		// mangoptionsmatchService.findBySn(mangoptionsmatch.getSn());
		System.out.println("第二次计算后的更新后：" + mangoptionsmatch.getName() + "第一轮分数" + mangoptionsmatch.getScorefinalone()
				+ "第二轮分数" + mangoptionsmatch.getScorefinaltwo() + "总分数" + mangoptionsmatch.getScorefinal());
		return mangoptionsmatch;
	}

	/*
	 * 时间转换程序
	 */
	public Turnmatchlist changetime(Turnmatchlist turnmatchlist, String min1, String second1, String min2,
			String second2, String min3, String second3, String min4, String second4) {
		System.out.println("getJoinpeopleid============" + turnmatchlist.getJoinpeopleid());
		JoinMatchTeamPeople jfirst = joinMatchTeamPeopleService.selectByPrimaryKey(turnmatchlist.getJoinpeopleid());
		System.out.println("=========" + jfirst);
		if (jfirst.getJoinmatchlist() == 23 || jfirst.getJoinmatchlist() == 26 || jfirst.getJoinmatchlist() == 27
				|| jfirst.getJoinmatchlist() == 31) {
			/*
			 * 第一轮的留空时间
			 */
			double minOne = 0;
			double secondOne = 0;
			double onesky = 0;
			try {
				minOne = Double.parseDouble(min1);
			} catch (Exception e) {
				// TODO: handle exception
				minOne = 0;
			}
			try {
				secondOne = Double.parseDouble(second1);

			} catch (Exception e) {
				// TODO: handle exception
				secondOne = 0;
			}
			onesky = minOne * 60 + secondOne;
			turnmatchlist.setOneturnskytime(Double.toString(onesky));// 将分秒转换为秒
			/*
			 * 第二轮的留空时间
			 */
			double minTwo = 0;
			double secondTwo = 0;
			double Twosky = 0;
			try {
				minTwo = Double.parseDouble(min2);
			} catch (Exception e) {
				// TODO: handle exception
				minTwo = 0;
			}
			try {
				secondTwo = Double.parseDouble(second2);

			} catch (Exception e) {
				// TODO: handle exception
				secondTwo = 0;
			}
			Twosky = minTwo * 60 + secondTwo;
			turnmatchlist.setTwoturnskytime(Double.toString(Twosky));// 将分秒转换为秒

		} else if (jfirst.getJoinmatchlist() == 29) {
			/*
			 * 第一轮的留空时间和动力时间
			 */
			double minOne = 0;
			double secondOne = 0;
			double onesky = 0;
			double minpower = 0;
			double secondpower = 0;
			double onePower = 0;
			try {
				minOne = Double.parseDouble(min1);
			} catch (Exception e) {
				// TODO: handle exception
				minOne = 0;
			}
			try {
				secondOne = Double.parseDouble(second1);

			} catch (Exception e) {
				// TODO: handle exception
				secondOne = 0;
			}

			try {
				minpower = Double.parseDouble(min3);

			} catch (Exception e) {
				// TODO: handle exception
				minpower = 0;
			}
			try {
				secondpower = Double.parseDouble(second3);

			} catch (Exception e) {
				// TODO: handle exception
				secondpower = 0;
			}
			onesky = minOne * 60 + secondOne;
			onePower = minpower * 60 + secondpower;
			turnmatchlist.setOneturnskytime(Double.toString(onesky));// 将分秒转换为秒
			turnmatchlist.setOneturnpowertime(Double.toString(onePower));// 动力世家

			/*
			 * 第二轮的留空时间和动力时间
			 */
			double mintwo = 0;
			double secondtwo = 0;
			double twosky = 0;
			double minpower2 = 0;
			double secondpower2 = 0;
			double twoPower = 0;
			try {

				mintwo = Double.parseDouble(min2);
			} catch (Exception e) {

				mintwo = 0;
			}
			try {
				secondtwo = Double.parseDouble(second2);

			} catch (Exception e) {

				secondtwo = 0;
			}

			try {
				minpower2 = Double.parseDouble(min4);

			} catch (Exception e) {

				minpower2 = 0;
			}
			try {
				secondpower2 = Double.parseDouble(second4);

			} catch (Exception e) {

				secondpower2 = 0;
			}
			System.out.println("min4" + min2);
			System.out.println("mintwo" + mintwo);
			System.out.println("secondtwo" + secondtwo);
			twosky = mintwo * 60 + secondtwo;
			twoPower = minpower2 * 60 + secondpower2;
			turnmatchlist.setTwoturnskytime(Double.toString(twosky));// 将分秒转换为秒
			turnmatchlist.setTwoturnpowertime(Double.toString(twoPower));// 动力世家
		} else if (jfirst.getJoinmatchlist() == 17 || jfirst.getJoinmatchlist() == 18) {

			double firstfly = 0;
			double secondfly = 0;
			double thirdfly = 0;
			double finalfly = 0;

			double time1M = 0;
			double time1S = 0;
			try {
				time1M = Double.parseDouble(min1);
			} catch (Exception e) {
				time1M = 0;
			}
			try {
				time1S = Double.parseDouble(second1);
			} catch (Exception e) {
				time1S = 0;
			}
			firstfly = time1M * 60 + time1S;
			turnmatchlist.setOneturnpointmeter(Double.toString(firstfly));
			double time2M = 0;
			double time2S = 0;
			try {
				time2M = Double.parseDouble(min2);
			} catch (Exception e) {
				time2M = 0;
			}
			try {
				time2S = Double.parseDouble(second2);
			} catch (Exception e) {
				time2S = 0;
			}
			secondfly = time2M * 60 + time2S;
			turnmatchlist.setOneturnpowertime(Double.toString(secondfly));

			double time3M = 0;
			double time3S = 0;
			try {
				time3M = Double.parseDouble(min3);
			} catch (Exception e) {
				time3M = 0;
			}
			try {
				time3S = Double.parseDouble(second3);
			} catch (Exception e) {
				time3S = 0;
			}
			thirdfly = time3M * 60 + time3S;
			turnmatchlist.setOneturnskytime((Double.toString(thirdfly)));

			double time4M = 0;
			double time4S = 0;
			try {
				time4M = Double.parseDouble(min4);
			} catch (Exception e) {
				time4M = 0;
			}
			try {
				time4S = Double.parseDouble(second4);
			} catch (Exception e) {
				time4S = 0;
			}
			finalfly = time4M * 60 + time4S;
			turnmatchlist.setTwoturnpowertime(Double.toString(finalfly));
		}
		return turnmatchlist;
	}

	public void setconfirm() {
		List<Turnmatchlist> list = turnMatchListService.findAll();
		for (Turnmatchlist turnmatchlist : list) {
		//	turnmatchlist.setIsconfirm(0);
			turnMatchListService.updateByPrimaryKeySelective(turnmatchlist);
		}

	}

	/*
	 * 此程序管理的项目有23.26.27.29.31.17.18
	 */
	@RequestMapping("getMarking3")
	// 需要批次的比赛
	public String getMarking3(Turnmatchlist turnmatchlist, String min1, String second1, String min2, String second2,
			String min3, String second3, String min4, String second4, int joinpeopleid, String rid, Model model) {
		/*
		 * 此项目在赛前就已经创建好成绩单
		 */
		// setTurn(21, turnmatchlist.getJoinlist(), turnmatchlist.getJoingage(),
		// turnmatchlist.getTurn());
		System.out.println(turnmatchlist);
		turnmatchlist = changetime(turnmatchlist, min1, second1, min2, second2, min3, second3, min4, second4);
	
		Turnmatchlist turnmatchlistss=turnMatchListService.findBySnJid(turnmatchlist.getSn(), joinpeopleid);
		System.out.println("页面上传来的值：" + turnmatchlist);
		System.out.println("数据中的值" + turnmatchlistss);
		if (turnmatchlistss.getOneroundisconfirm() == null || turnmatchlistss.getOneroundisconfirm() == 0) {// 说明未打成绩
			System.out.println("第一轮分数");
			turnmatchlistss.setOneroundisconfirm(1);
			turnmatchlistss.setOneroundrid(turnmatchlist.getOneroundrid());//第一轮裁判
			turnmatchlistss.setOneturnpointmeter(turnmatchlist.getOneturnpointmeter());//定点距离
			turnmatchlistss.setOneturnpowertime(turnmatchlist.getOneturnpowertime());//动力时间
			turnmatchlistss.setOneturnscore(turnmatchlist.getOneturnscore());//第一轮原始分
			turnmatchlistss.setOneturnskytime(turnmatchlist.getOneturnskytime());//留空时间
			turnMatchListService.updateByPrimaryKeySelective(turnmatchlistss);
		} else {
			System.out.println("第二轮分数");
			Turnmatchlist turnmatchlistPerToWriteTwo=turnMatchListService.findBySnJid(turnmatchlistss.getSn(), joinpeopleid);
			turnmatchlistPerToWriteTwo.setTworoundisconfirm(1);
			turnmatchlistPerToWriteTwo.setTworoundrid(turnmatchlist.getTworoundrid());//第一轮裁判
			turnmatchlistPerToWriteTwo.setTwoturnpointmeter(turnmatchlist.getTwoturnpointmeter());//定点距离
			turnmatchlistPerToWriteTwo.setTwoturnpowertime(turnmatchlist.getTwoturnpowertime());//动力时间
			turnmatchlistPerToWriteTwo.setTwoturnscore(turnmatchlist.getTwoturnscore());//第一轮原始分
			turnmatchlistPerToWriteTwo.setTwoturnskytime(turnmatchlist.getTwoturnskytime());//留空时间
			turnMatchListService.updateByPrimaryKeySelective(turnmatchlistPerToWriteTwo);
//			Twoptionsmatch twoptionsmatchPerToWriteTwo = twoptionsMatchService.findBySnJid(twoptionsmatch.getSn(),
//					joinpeopleid);
//			twoptionsmatchPerToWriteTwo.setScoretwo(twoptionsmatch.getScoretwo());
//			twoptionsmatchPerToWriteTwo.setTworoundrid(twoptionsmatch.getTworoundrid());
//			twoptionsmatchPerToWriteTwo.setTworoundisconfirm(1);
//			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatchPerToWriteTwo);
			
		}
		Turnmatchlist turnmatchlistWhoNeedtoConfirm = turnMatchListService.findBySnJid(turnmatchlist.getSn(), joinpeopleid);
		sort(turnmatchlistWhoNeedtoConfirm);
		Turnmatchlist turnmatchlistWhoNeedtoConfirm1 = turnMatchListService.findBySnJid(turnmatchlist.getSn(), joinpeopleid);
		System.out.println("打分完毕的值"+turnmatchlistWhoNeedtoConfirm);
		model.addAttribute("turnmatchlistWhoNeedtoConfirm", turnmatchlistWhoNeedtoConfirm1);
		System.err.println("批次项目打分程序执行完毕");
		
		
//		model.addAttribute("joinMatchTeamPeople", joinMatchTeamPeople);
//		model.addAttribute("turnmatchlist", turnmatchlistxx);
//		model.addAttribute("hxPeople", hxpeople);
//		model.addAttribute("min1", min1);
//		model.addAttribute("min2", min2);
//		model.addAttribute("min3", min3);
//		model.addAttribute("min4", min4);
//		model.addAttribute("second1", second1);
//		model.addAttribute("second2", second2);
//		model.addAttribute("second3", second3);
//		model.addAttribute("second4", second4);
		return "thisPeopleScorehasturn";
	}

	/*
	 * 先生成 成绩单
	 */
	public void doMatchList8(int matchid) {
	List<JoinMatchTeam> joinMatchTeams=joinMatchTeamService.findthismatchteam(matchid);
	int i=0;
	int j=1;
	for (JoinMatchTeam joinMatchTeam : joinMatchTeams) {
		List<JoinMatchTeamPeople> thisTeamPeolewhojoinlist8=joinMatchTeamPeopleService.findthisTeamwhojoinlist8(matchid, joinMatchTeam.getId());
		for (JoinMatchTeamPeople joinMatchTeamPeople : thisTeamPeolewhojoinlist8) {
			Withfriendmatch withfriendmatch=new Withfriendmatch();
			if (i==3) {
				i=0;
				j++;
			}
			if (thisTeamPeolewhojoinlist8.size()<=3) {
			withfriendmatch.setMyteamfriend(Integer.toString(j));
			i++;
			}else if(thisTeamPeolewhojoinlist8.size()>3 && thisTeamPeolewhojoinlist8.size()<=6){
				withfriendmatch.setMyteamfriend(Integer.toString(j));
				i++;	
				
			}else if(thisTeamPeolewhojoinlist8.size()>6 && thisTeamPeolewhojoinlist8.size()<=9){
				withfriendmatch.setMyteamfriend(Integer.toString(j));
				i++;
				
			}else if(thisTeamPeolewhojoinlist8.size()>9 && thisTeamPeolewhojoinlist8.size()<=12){
				withfriendmatch.setMyteamfriend(Integer.toString(j));
				i++;
				
			}
			int isteam=0;
			int gage=0;
			try {
				
				gage=	joinMatchTeamPeople.getGage();
			} catch (Exception e) {
				// TODO: handle exception
				gage=0;
			}
			try {
				Integer.parseInt(joinMatchTeamPeople.getIsteammatchlist());
			} catch (Exception e) {
				// TODO: handle exception
				isteam=0;
			}
			withfriendmatch.setJoingagae(gage);
			withfriendmatch.setJoinmatch(joinMatchTeamPeople.getMatchid());
			withfriendmatch.setJoinlist(joinMatchTeamPeople.getJoinmatchlist());
			withfriendmatch.setJoinpeopleid(joinMatchTeamPeople.getId());
			withfriendmatch.setIsteammatch(isteam);
			withfriendmatch.setName(joinMatchTeamPeople.getName());
			withfriendmatch.setNum(joinMatchTeamPeople.getScore2());
			withfriendmatch.setTeamname(joinMatchTeamPeople.getTeamname());
			withfriendmatch.setSn(joinMatchTeamPeople.getPeoplesn());
			
			
			
			
			
			withfriendmatchService.insertSelective(withfriendmatch);
		}
		
	}

	}

	/*
	 * 第8個項目
	 */
	@RequestMapping("getMarking4")
	// 8.三人接力
	public String getMarking4(Withfriendmatch withfriendmatch, int joinpeopleid, Model model) {
		
	
		Withfriendmatch withfriendmatchss=withfriendmatchService.findByJpId(joinpeopleid);
		System.out.println("页面传来的值"+withfriendmatch);
		System.out.println("数据库中的值"+withfriendmatchss);
		if (withfriendmatchss.getOneroundisconfirm()==null ||withfriendmatchss.getOneroundisconfirm()==0) {
			List<Withfriendmatch> myfriends=withfriendmatchService.findMyfriend(withfriendmatchss.getMyteamfriend());
			for (Withfriendmatch meorfriend : myfriends) {
				System.out.println("执行第一轮");
				meorfriend.setOneroundrid(withfriendmatch.getOneroundrid());
				meorfriend.setOneroundisconfirm(1);
				meorfriend.setScoreone(withfriendmatch.getScoreone());
				System.out.println("第一轮的时间："+withfriendmatch.getScoreone());
				withfriendmatchService.updateByPrimaryKeySelective(meorfriend);
			}
		}else {
			Withfriendmatch withfriendmatchPertoWriteTwo=withfriendmatchService.findByJpId(joinpeopleid);
			List<Withfriendmatch> myfriends=withfriendmatchService.findMyfriend(withfriendmatchPertoWriteTwo.getMyteamfriend());
			for (Withfriendmatch meorfriend : myfriends) {
				System.out.println("执行第二轮");
				meorfriend.setScoretwo(withfriendmatch.getScoretwo());
				meorfriend.setTworoundrid(withfriendmatch.getTworoundrid());
				meorfriend.setTworoundisconfirm(1);
				Withfriendmatch temp=calculate(meorfriend);
				meorfriend.setFinalscore(temp.getFinalscore());
				withfriendmatchService.updateByPrimaryKeySelective(meorfriend);
			}
		
		}
		Withfriendmatch withfriendmWhoNeedtoConfirm=withfriendmatchService.findByJpId(joinpeopleid);
		sort(withfriendmWhoNeedtoConfirm);
		Withfriendmatch withfriendmWhoNeedtoConfirm1 = withfriendmatchService.findByJpId(joinpeopleid);
		
		List<Withfriendmatch> we=withfriendmatchService.findMyfriend(withfriendmatchss.getMyteamfriend());
		model.addAttribute("withfriendmWhoNeedtoConfirm", withfriendmWhoNeedtoConfirm1);
		model.addAttribute("we", we);
		System.err.println("单轮但参数项目打分程序执行完毕");
		return "thisPeopleScorehaswithfriend";
	}
	/*
	 * 多裁判项目 9.25.34
	 */
	@RequestMapping("getMarking5")
	// 多个裁判的 9. 25，34
	public String getMarking5(Manyrifmatch manyrifmatch, int joinpeopleid, Model model) {
		
		Manyrifmatch manyrifmatchss=manyrifmatchService.findByJpId(joinpeopleid);
		System.out.println("页面传来的值"+manyrifmatch);
		System.out.println("数据库中的值"+manyrifmatchss);
		
			manyrifmatchss.setOneroundrid(manyrifmatch.getOneroundrid());
			
			
				/*
				 * 有一个裁判打分了用7 2个是8 3个是9 4个是10 5个是11
				 */
				if (manyrifmatchss.getOneroundisconfirm()==null ||manyrifmatchss.getOneroundisconfirm()==0) {
					
				
				manyrifmatchss.setOneroundisconfirm(7);//第一个裁判
				System.out.println("执行第一个裁判的打分");
				//第一轮分数 
				manyrifmatchss.setScore1one1rid(manyrifmatch.getScore1one1rid());
				manyrifmatchss.setScore2one1rid(manyrifmatch.getScore2one1rid());
				manyrifmatchss.setScore3one1rid(manyrifmatch.getScore3one1rid());
				manyrifmatchss.setScore4one1rid(manyrifmatch.getScore4one1rid());
				manyrifmatchss.setScore5one1rid(manyrifmatch.getScore5one1rid());
				manyrifmatchss.setScore6one1rid(manyrifmatch.getScore6one1rid());
				manyrifmatchss.setScore7one1rid(manyrifmatch.getScore7one1rid());
				manyrifmatchss.setScore8one1rid(manyrifmatch.getScore8one1rid());
				manyrifmatchss.setScore9one1rid(manyrifmatch.getScore9one1rid());
				manyrifmatchss.setScore10one1rid(manyrifmatch.getScore10one1rid());
				
				manyrifmatchss.setScore1two1rid(manyrifmatch.getScore1two1rid());
				manyrifmatchss.setScore2two1rid(manyrifmatch.getScore2two1rid());
				manyrifmatchss.setScore3two1rid(manyrifmatch.getScore3two1rid());
				manyrifmatchss.setScore4two1rid(manyrifmatch.getScore4two1rid());
				manyrifmatchss.setScore5two1rid(manyrifmatch.getScore5two1rid());
				manyrifmatchss.setScore6two1rid(manyrifmatch.getScore6two1rid());
				manyrifmatchss.setScore7two1rid(manyrifmatch.getScore7two1rid());
				manyrifmatchss.setScore8two1rid(manyrifmatch.getScore8two1rid());
				manyrifmatchss.setScore9two1rid(manyrifmatch.getScore9two1rid());
				manyrifmatchss.setScore10two1rid(manyrifmatch.getScore10two1rid());
				}else if (manyrifmatchss.getOneroundisconfirm()==7) {
					
					manyrifmatchss.setOneroundisconfirm(8);//第二个裁判
					System.out.println("执行第2个裁判的打分");
					//第一轮分数 
					manyrifmatchss.setScore1one2rid(manyrifmatch.getScore1one1rid());
					manyrifmatchss.setScore2one2rid(manyrifmatch.getScore2one1rid());
					manyrifmatchss.setScore3one2rid(manyrifmatch.getScore3one1rid());
					manyrifmatchss.setScore4one2rid(manyrifmatch.getScore4one1rid());
					manyrifmatchss.setScore5one2rid(manyrifmatch.getScore5one1rid());
					manyrifmatchss.setScore6one2rid(manyrifmatch.getScore6one1rid());
					manyrifmatchss.setScore7one2rid(manyrifmatch.getScore7one1rid());
					manyrifmatchss.setScore8one2rid(manyrifmatch.getScore8one1rid());
					manyrifmatchss.setScore9one2rid(manyrifmatch.getScore9one1rid());
					manyrifmatchss.setScore10one2rid(manyrifmatch.getScore10one1rid());
					//第二轮分数
					manyrifmatchss.setScore1two2rid(manyrifmatch.getScore1two1rid());
					manyrifmatchss.setScore2two2rid(manyrifmatch.getScore2two1rid());
					manyrifmatchss.setScore3two2rid(manyrifmatch.getScore3two1rid());
					manyrifmatchss.setScore4two2rid(manyrifmatch.getScore4two1rid());
					manyrifmatchss.setScore5two2rid(manyrifmatch.getScore5two1rid());
					manyrifmatchss.setScore6two2rid(manyrifmatch.getScore6two1rid());
					manyrifmatchss.setScore7two2rid(manyrifmatch.getScore7two1rid());
					manyrifmatchss.setScore8two2rid(manyrifmatch.getScore8two1rid());
					manyrifmatchss.setScore9two2rid(manyrifmatch.getScore9two1rid());
					manyrifmatchss.setScore10two2rid(manyrifmatch.getScore10two1rid());
					
				}else if(manyrifmatchss.getOneroundisconfirm()==8){
					manyrifmatchss.setOneroundisconfirm(9);//第三个裁判
					System.out.println("执行第3个裁判的打分");
					//第一轮分数 
					manyrifmatchss.setScore1one3rid(manyrifmatch.getScore1one1rid());
					manyrifmatchss.setScore2one3rid(manyrifmatch.getScore2one1rid());
					manyrifmatchss.setScore3one3rid(manyrifmatch.getScore3one1rid());
					manyrifmatchss.setScore4one3rid(manyrifmatch.getScore4one1rid());
					manyrifmatchss.setScore5one3rid(manyrifmatch.getScore5one1rid());
					manyrifmatchss.setScore6one3rid(manyrifmatch.getScore6one1rid());
					manyrifmatchss.setScore7one3rid(manyrifmatch.getScore7one1rid());
					manyrifmatchss.setScore8one3rid(manyrifmatch.getScore8one1rid());
					manyrifmatchss.setScore9one3rid(manyrifmatch.getScore9one1rid());
					manyrifmatchss.setScore10one3rid(manyrifmatch.getScore10one1rid());
					//第二轮分数
					manyrifmatchss.setScore1two3rid(manyrifmatch.getScore1two1rid());
					manyrifmatchss.setScore2two3rid(manyrifmatch.getScore2two1rid());
					manyrifmatchss.setScore3two3rid(manyrifmatch.getScore3two1rid());
					manyrifmatchss.setScore4two3rid(manyrifmatch.getScore4two1rid());
					manyrifmatchss.setScore5two3rid(manyrifmatch.getScore5two1rid());
					manyrifmatchss.setScore6two3rid(manyrifmatch.getScore6two1rid());
					manyrifmatchss.setScore7two3rid(manyrifmatch.getScore7two1rid());
					manyrifmatchss.setScore8two3rid(manyrifmatch.getScore8two1rid());
					manyrifmatchss.setScore9two3rid(manyrifmatch.getScore9two1rid());
					manyrifmatchss.setScore10two3rid(manyrifmatch.getScore10two1rid());
				}
				
			
			
			manyrifmatchService.updateByPrimaryKeySelective(manyrifmatchss);
		
		
		Manyrifmatch manyrifmatchWhoNeedtoConfirm=manyrifmatchService.findByJpId(joinpeopleid);
		sort(manyrifmatchWhoNeedtoConfirm);
		
		Manyrifmatch manyrifmatchWhoNeedtoConfirm1 = manyrifmatchService.findByJpId(joinpeopleid);
		model.addAttribute("manyrifmatchWhoNeedtoConfirm", manyrifmatchWhoNeedtoConfirm1);
		System.err.println("单轮但参数项目打分程序执行完毕");
		
		
		
		return "thisPeopleScorehaswithmanyrid";
	}

	Double comp(double a, double b, double c)

	{

		return a >= b ? (a >= c ? (b >= c ? b : c) : a) : (a >= c ? a : (b >= c ? c : b));

	}

	public List<Manyrifmatch> sortclacsss(List<Manyrifmatch> list) {
		Collections.sort(list, new Comparator<Manyrifmatch>() {

			@Override
			public int compare(Manyrifmatch o1, Manyrifmatch o2) {

				int i = (int) Double.parseDouble(o1.getScorefinal()) - (int) Double.parseDouble(o2.getScorefinal());
				if (i == 0) {
					return Integer.parseInt(o1.getScorefinal()) - Integer.parseInt(o2.getScorefinal());
				}
				return i;

			}
		}

		);

		int i = list.size();
		for (Manyrifmatch manyrifmatch : list) {
			manyrifmatch.setRank(i);
			manyrifmatchService.updateByPrimaryKeySelective(manyrifmatch);
			System.out.println("開始排名：" + "名字：" + manyrifmatch.getName() + "分數：" + manyrifmatch.getScorefinal());
			i--;
		}

		return list;
	}

	public Manyrifmatch rankculate(Manyrifmatch manyrifmatch) {
		int gage = manyrifmatch.getJoingage();
		int matchlist = manyrifmatch.getJoinlist();
		List<Manyrifmatch> findWhereIsMyListGagePeople = manyrifmatchService.findWhereIsMyListGagePeople(gage,
				matchlist);
		// 此项目排序
		sortclacsss(findWhereIsMyListGagePeople);
		manyrifmatch = manyrifmatchService.findByJpId(manyrifmatch.getJoinpeopleid());

		return manyrifmatch;
	}

	public Manyrifmatch calculate(Manyrifmatch manyrifmatch) {
		if (manyrifmatch.getJoinlist() == 9) {
			// 3个裁判去掉最高 去掉最低 取中间
			Double score1, score2, score3, score4, score5;
			Double score6, score7, score8, score9, score10;

			score1 = comp(Double.parseDouble(manyrifmatch.getScore1one1rid()),
					Double.parseDouble(manyrifmatch.getScore1one2rid()),
					Double.parseDouble(manyrifmatch.getScore1one3rid()));
			score2 = comp(Double.parseDouble(manyrifmatch.getScore2one1rid()),
					Double.parseDouble(manyrifmatch.getScore2one2rid()),
					Double.parseDouble(manyrifmatch.getScore2one3rid()));
			score3 = comp(Double.parseDouble(manyrifmatch.getScore3one1rid()),
					Double.parseDouble(manyrifmatch.getScore3one2rid()),
					Double.parseDouble(manyrifmatch.getScore3one3rid()));
			score4 = comp(Double.parseDouble(manyrifmatch.getScore4one1rid()),
					Double.parseDouble(manyrifmatch.getScore4one2rid()),
					Double.parseDouble(manyrifmatch.getScore4one3rid()));
			score5 = comp(Double.parseDouble(manyrifmatch.getScore5one1rid()),
					Double.parseDouble(manyrifmatch.getScore5one2rid()),
					Double.parseDouble(manyrifmatch.getScore5one3rid()));

			manyrifmatch.setScoreoneturn(Double.toString(score1 + score2 + score3 + score4 + score5));

			score6 = comp(Double.parseDouble(manyrifmatch.getScore1two1rid()),
					Double.parseDouble(manyrifmatch.getScore1two2rid()),
					Double.parseDouble(manyrifmatch.getScore1two3rid()));
			score7 = comp(Double.parseDouble(manyrifmatch.getScore2two1rid()),
					Double.parseDouble(manyrifmatch.getScore2two2rid()),
					Double.parseDouble(manyrifmatch.getScore2two3rid()));
			score8 = comp(Double.parseDouble(manyrifmatch.getScore3two1rid()),
					Double.parseDouble(manyrifmatch.getScore3two2rid()),
					Double.parseDouble(manyrifmatch.getScore3two3rid()));
			score9 = comp(Double.parseDouble(manyrifmatch.getScore4two1rid()),
					Double.parseDouble(manyrifmatch.getScore4two2rid()),
					Double.parseDouble(manyrifmatch.getScore4two3rid()));
			score10 = comp(Double.parseDouble(manyrifmatch.getScore5two1rid()),
					Double.parseDouble(manyrifmatch.getScore5two2rid()),
					Double.parseDouble(manyrifmatch.getScore5two3rid()));

			manyrifmatch.setScoretwoturn(Double.toString(score6 + score7 + score8 + score9 + score10));

			manyrifmatch.setScore6one1rid(Double.toString(score1));
			manyrifmatch.setScore7one1rid(Double.toString(score2));
			manyrifmatch.setScore8one1rid(Double.toString(score3));
			manyrifmatch.setScore9one1rid(Double.toString(score4));
			manyrifmatch.setScore10one1rid(Double.toString(score5));
			manyrifmatch.setScore6two1rid(Double.toString(score6));
			manyrifmatch.setScore7two1rid(Double.toString(score7));
			manyrifmatch.setScore8two1rid(Double.toString(score8));
			manyrifmatch.setScore9two1rid(Double.toString(score9));
			manyrifmatch.setScore10two1rid(Double.toString(score10));
			manyrifmatch.setScorefinal(Double.toString(
					score1 + score2 + score3 + score4 + score5 + score6 + score7 + score8 + score9 + score10));
			manyrifmatchService.updateByPrimaryKeySelective(manyrifmatch);
		} else if (manyrifmatch.getJoinlist() == 25) {
			Double score1, score2, score3, score4, score5;
			Double score6, score7, score8, score9, score10;
			Double score11, score12, score13, score14, score15;
			Double score16, score17, score18, score19, score20;
			score1 = comp(Double.parseDouble(manyrifmatch.getScore1one1rid()),
					Double.parseDouble(manyrifmatch.getScore1one2rid()),
					Double.parseDouble(manyrifmatch.getScore1one3rid()));
			score2 = comp(Double.parseDouble(manyrifmatch.getScore2one1rid()),
					Double.parseDouble(manyrifmatch.getScore2one2rid()),
					Double.parseDouble(manyrifmatch.getScore2one3rid()));
			score3 = comp(Double.parseDouble(manyrifmatch.getScore3one1rid()),
					Double.parseDouble(manyrifmatch.getScore3one2rid()),
					Double.parseDouble(manyrifmatch.getScore3one3rid()));
			score4 = comp(Double.parseDouble(manyrifmatch.getScore4one1rid()),
					Double.parseDouble(manyrifmatch.getScore4one2rid()),
					Double.parseDouble(manyrifmatch.getScore4one3rid()));
			score5 = comp(Double.parseDouble(manyrifmatch.getScore5one1rid()),
					Double.parseDouble(manyrifmatch.getScore5one2rid()),
					Double.parseDouble(manyrifmatch.getScore5one3rid()));
			score6 = comp(Double.parseDouble(manyrifmatch.getScore6one1rid()),
					Double.parseDouble(manyrifmatch.getScore6one2rid()),
					Double.parseDouble(manyrifmatch.getScore6one3rid()));
			score7 = comp(Double.parseDouble(manyrifmatch.getScore7one1rid()),
					Double.parseDouble(manyrifmatch.getScore7one2rid()),
					Double.parseDouble(manyrifmatch.getScore7one3rid()));
			score8 = comp(Double.parseDouble(manyrifmatch.getScore8one1rid()),
					Double.parseDouble(manyrifmatch.getScore8one2rid()),
					Double.parseDouble(manyrifmatch.getScore8one3rid()));
			score9 = comp(Double.parseDouble(manyrifmatch.getScore9one1rid()),
					Double.parseDouble(manyrifmatch.getScore9one2rid()),
					Double.parseDouble(manyrifmatch.getScore9one3rid()));
			score10 = comp(Double.parseDouble(manyrifmatch.getScore10one1rid()),
					Double.parseDouble(manyrifmatch.getScore10one2rid()),
					Double.parseDouble(manyrifmatch.getScore10one3rid()));

			manyrifmatch.setScoreoneturn(Double.toString(score1 * 2 + score2 + score3 * 3 + score4 * 2 + score5 * 2
					+ score6 * 3 + score7 * 3 + score8 * 3 + score9 * 2 + score10 * 3));

			score11 = comp(Double.parseDouble(manyrifmatch.getScore1two1rid()),
					Double.parseDouble(manyrifmatch.getScore1two2rid()),
					Double.parseDouble(manyrifmatch.getScore1two3rid()));
			score12 = comp(Double.parseDouble(manyrifmatch.getScore2two1rid()),
					Double.parseDouble(manyrifmatch.getScore2two2rid()),
					Double.parseDouble(manyrifmatch.getScore2two3rid()));
			score13 = comp(Double.parseDouble(manyrifmatch.getScore3two1rid()),
					Double.parseDouble(manyrifmatch.getScore3two2rid()),
					Double.parseDouble(manyrifmatch.getScore3two3rid()));
			score14 = comp(Double.parseDouble(manyrifmatch.getScore4two1rid()),
					Double.parseDouble(manyrifmatch.getScore4two2rid()),
					Double.parseDouble(manyrifmatch.getScore4two3rid()));
			score15 = comp(Double.parseDouble(manyrifmatch.getScore5two1rid()),
					Double.parseDouble(manyrifmatch.getScore5two2rid()),
					Double.parseDouble(manyrifmatch.getScore5two3rid()));
			score16 = comp(Double.parseDouble(manyrifmatch.getScore6two1rid()),
					Double.parseDouble(manyrifmatch.getScore6two2rid()),
					Double.parseDouble(manyrifmatch.getScore6two3rid()));
			score17 = comp(Double.parseDouble(manyrifmatch.getScore7two1rid()),
					Double.parseDouble(manyrifmatch.getScore7two2rid()),
					Double.parseDouble(manyrifmatch.getScore7two3rid()));
			score18 = comp(Double.parseDouble(manyrifmatch.getScore8two1rid()),
					Double.parseDouble(manyrifmatch.getScore8two2rid()),
					Double.parseDouble(manyrifmatch.getScore8two3rid()));
			score19 = comp(Double.parseDouble(manyrifmatch.getScore9two1rid()),
					Double.parseDouble(manyrifmatch.getScore9two2rid()),
					Double.parseDouble(manyrifmatch.getScore9two3rid()));
			score20 = comp(Double.parseDouble(manyrifmatch.getScore10two1rid()),
					Double.parseDouble(manyrifmatch.getScore10two2rid()),
					Double.parseDouble(manyrifmatch.getScore10two3rid()));

			manyrifmatch.setScoretwoturn(Double.toString(score11 * 2 + score12 + score13 * 3 + score14 * 2 + score15 * 2
					+ score16 * 3 + score17 * 3 + score18 * 3 + score19 * 2 + score20 * 3));

			// manyrifmatch.setScore6one1rid(Double.toString(score1));
			// manyrifmatch.setScore7one1rid(Double.toString(score2));
			// manyrifmatch.setScore8one1rid(Double.toString(score3));
			// manyrifmatch.setScore9one1rid(Double.toString(score4));
			// manyrifmatch.setScore10one1rid(Double.toString(score5));
			// manyrifmatch.setScore6two1rid(Double.toString(score6));
			// manyrifmatch.setScore7two1rid(Double.toString(score7));
			// manyrifmatch.setScore8two1rid(Double.toString(score8));
			// manyrifmatch.setScore9two1rid(Double.toString(score9));
			// manyrifmatch.setScore10two1rid(Double.toString(score10));
			manyrifmatch.setScorefinal(
					Double.toString(score1 * 2 + score2 + score3 * 3 + score4 * 2 + score5 * 2 + score6 * 3 + score7 * 3
							+ score8 * 3 + score9 * 2 + score10 * 3 + score11 * 2 + score12 + score13 * 3 + score14 * 2
							+ score15 * 2 + score16 * 3 + score17 * 3 + score18 * 3 + score19 * 2 + score20 * 3));
			manyrifmatchService.updateByPrimaryKeySelective(manyrifmatch);

		} else if (manyrifmatch.getJoinlist() == 34) {
			Double score1, score2, score3, score4, score5;
			Double score6, score7, score8, score9, score10;
			Double score11, score12, score13, score14, score15;
			Double score16, score17, score18, score19, score20;
			Double score21, score22, score23, score24, score25, score26, score27, score28, score29, score30, score31,
					score32;
			score1 = comp(Double.parseDouble(manyrifmatch.getScore1one1rid()),
					Double.parseDouble(manyrifmatch.getScore1one2rid()),
					Double.parseDouble(manyrifmatch.getScore1one3rid()));
			score2 = comp(Double.parseDouble(manyrifmatch.getScore2one1rid()),
					Double.parseDouble(manyrifmatch.getScore2one2rid()),
					Double.parseDouble(manyrifmatch.getScore2one3rid()));
			score3 = comp(Double.parseDouble(manyrifmatch.getScore3one1rid()),
					Double.parseDouble(manyrifmatch.getScore3one2rid()),
					Double.parseDouble(manyrifmatch.getScore3one3rid()));
			score4 = comp(Double.parseDouble(manyrifmatch.getScore4one1rid()),
					Double.parseDouble(manyrifmatch.getScore4one2rid()),
					Double.parseDouble(manyrifmatch.getScore4one3rid()));
			score5 = comp(Double.parseDouble(manyrifmatch.getScore5one1rid()),
					Double.parseDouble(manyrifmatch.getScore5one2rid()),
					Double.parseDouble(manyrifmatch.getScore5one3rid()));
			score6 = comp(Double.parseDouble(manyrifmatch.getScore6one1rid()),
					Double.parseDouble(manyrifmatch.getScore6one2rid()),
					Double.parseDouble(manyrifmatch.getScore6one3rid()));
			score7 = comp(Double.parseDouble(manyrifmatch.getScore7one1rid()),
					Double.parseDouble(manyrifmatch.getScore7one2rid()),
					Double.parseDouble(manyrifmatch.getScore7one3rid()));
			score8 = comp(Double.parseDouble(manyrifmatch.getScore8one1rid()),
					Double.parseDouble(manyrifmatch.getScore8one2rid()),
					Double.parseDouble(manyrifmatch.getScore8one3rid()));
			score9 = comp(Double.parseDouble(manyrifmatch.getScore9one1rid()),
					Double.parseDouble(manyrifmatch.getScore9one2rid()),
					Double.parseDouble(manyrifmatch.getScore9one3rid()));
			score10 = comp(Double.parseDouble(manyrifmatch.getScore10one1rid()),
					Double.parseDouble(manyrifmatch.getScore10one2rid()),
					Double.parseDouble(manyrifmatch.getScore10one3rid()));
			score11 = comp(Double.parseDouble(manyrifmatch.getScore11one1rid()),
					Double.parseDouble(manyrifmatch.getScore11one2rid()),
					Double.parseDouble(manyrifmatch.getScore11one3rid()));
			score12 = comp(Double.parseDouble(manyrifmatch.getScore12one1rid()),
					Double.parseDouble(manyrifmatch.getScore12one2rid()),
					Double.parseDouble(manyrifmatch.getScore12one3rid()));
			score13 = comp(Double.parseDouble(manyrifmatch.getScore13on1erid()),
					Double.parseDouble(manyrifmatch.getScore13one2rid()),
					Double.parseDouble(manyrifmatch.getScore13one3rid()));
			score14 = comp(Double.parseDouble(manyrifmatch.getScore14one1rid()),
					Double.parseDouble(manyrifmatch.getScore14one2rid()),
					Double.parseDouble(manyrifmatch.getScore14one3rid()));
			score15 = comp(Double.parseDouble(manyrifmatch.getScore15one1rid()),
					Double.parseDouble(manyrifmatch.getScore15one2rid()),
					Double.parseDouble(manyrifmatch.getScore15one3rid()));
			score16 = comp(Double.parseDouble(manyrifmatch.getScore16one1rid()),
					Double.parseDouble(manyrifmatch.getScore16one2rid()),
					Double.parseDouble(manyrifmatch.getScore16one3rid()));
			manyrifmatch.setScoreoneturn(Double.toString(score1 * 1 + score2 * 2 + score3 * 8 + score4 * 6 + score5 * 2
					+ score6 * 6 + score7 * 12 + score8 * 12 + score9 * 14 + score10 * 7 + score11 * 18 + score12 * 10
					+ score13 * 10 + score14 * 10 + score15 * 8 + score16 * 5));

			score17 = comp(Double.parseDouble(manyrifmatch.getScore1two1rid()),
					Double.parseDouble(manyrifmatch.getScore1two2rid()),
					Double.parseDouble(manyrifmatch.getScore1two3rid()));
			score18 = comp(Double.parseDouble(manyrifmatch.getScore2two1rid()),
					Double.parseDouble(manyrifmatch.getScore2two2rid()),
					Double.parseDouble(manyrifmatch.getScore2two3rid()));
			score19 = comp(Double.parseDouble(manyrifmatch.getScore3two1rid()),
					Double.parseDouble(manyrifmatch.getScore3two2rid()),
					Double.parseDouble(manyrifmatch.getScore3two3rid()));
			score20 = comp(Double.parseDouble(manyrifmatch.getScore4two1rid()),
					Double.parseDouble(manyrifmatch.getScore4two2rid()),
					Double.parseDouble(manyrifmatch.getScore4two3rid()));
			score21 = comp(Double.parseDouble(manyrifmatch.getScore5two1rid()),
					Double.parseDouble(manyrifmatch.getScore5two2rid()),
					Double.parseDouble(manyrifmatch.getScore5two3rid()));
			score22 = comp(Double.parseDouble(manyrifmatch.getScore6two1rid()),
					Double.parseDouble(manyrifmatch.getScore6two2rid()),
					Double.parseDouble(manyrifmatch.getScore6two3rid()));
			score23 = comp(Double.parseDouble(manyrifmatch.getScore7two1rid()),
					Double.parseDouble(manyrifmatch.getScore7two2rid()),
					Double.parseDouble(manyrifmatch.getScore7two3rid()));
			score24 = comp(Double.parseDouble(manyrifmatch.getScore8two1rid()),
					Double.parseDouble(manyrifmatch.getScore8two2rid()),
					Double.parseDouble(manyrifmatch.getScore8two3rid()));
			score25 = comp(Double.parseDouble(manyrifmatch.getScore9two1rid()),
					Double.parseDouble(manyrifmatch.getScore9two2rid()),
					Double.parseDouble(manyrifmatch.getScore9two3rid()));
			score26 = comp(Double.parseDouble(manyrifmatch.getScore10two1rid()),
					Double.parseDouble(manyrifmatch.getScore10two2rid()),
					Double.parseDouble(manyrifmatch.getScore10two3rid()));
			score27 = comp(Double.parseDouble(manyrifmatch.getScore11two1rid()),
					Double.parseDouble(manyrifmatch.getScore11two2rid()),
					Double.parseDouble(manyrifmatch.getScore11two3rid()));
			score28 = comp(Double.parseDouble(manyrifmatch.getScore12two1rid()),
					Double.parseDouble(manyrifmatch.getScore12two2rid()),
					Double.parseDouble(manyrifmatch.getScore12two3rid()));
			String temp = manyrifmatch.getScore13two1rid();
			if (manyrifmatch.getScore13two1rid() == "" || manyrifmatch.getScore13two1rid().equals(null)
					|| manyrifmatch.getScore13two1rid() == null) {
				// manyrifmatch.setScore13two1rid("0");
				temp = "0";
			}
			score29 = comp(Double.parseDouble("0"), Double.parseDouble(manyrifmatch.getScore13two2rid()),
					Double.parseDouble(manyrifmatch.getScore13two3rid()));
			score30 = comp(Double.parseDouble(manyrifmatch.getScore14two1rid()),
					Double.parseDouble(manyrifmatch.getScore14two2rid()),
					Double.parseDouble(manyrifmatch.getScore14two3rid()));
			score31 = comp(Double.parseDouble(manyrifmatch.getScore15two1rid()),
					Double.parseDouble(manyrifmatch.getScore15two2rid()),
					Double.parseDouble(manyrifmatch.getScore15two3rid()));
			score32 = comp(Double.parseDouble(manyrifmatch.getScore16two1rid()),
					Double.parseDouble(manyrifmatch.getScore16two2rid()),
					Double.parseDouble(manyrifmatch.getScore16two3rid()));
			manyrifmatch.setScoretwoturn(Double.toString(score17 * 1 + score18 * 2 + score19 * 8 + score20 * 6
					+ score21 * 2 + score22 * 6 + score23 * 12 + score24 * 12 + score25 * 14 + score26 * 7
					+ score27 * 18 + score28 * 10 + score29 * 10 + score30 * 10 + score31 * 8 + score32 * 5));
			// manyrifmatch.setScore6one1rid(Double.toString(score1));
			// manyrifmatch.setScore7one1rid(Double.toString(score2));
			// manyrifmatch.setScore8one1rid(Double.toString(score3));
			// manyrifmatch.setScore9one1rid(Double.toString(score4));
			// manyrifmatch.setScore10one1rid(Double.toString(score5));
			// manyrifmatch.setScore6two1rid(Double.toString(score6));
			// manyrifmatch.setScore7two1rid(Double.toString(score7));
			// manyrifmatch.setScore8two1rid(Double.toString(score8));
			// manyrifmatch.setScore9two1rid(Double.toString(score9));
			// manyrifmatch.setScore10two1rid(Double.toString(score10));
			manyrifmatch.setScorefinal(Double.toString(score1 * 1 + score2 * 2 + score3 * 8 + score4 * 6 + score5 * 2
					+ score6 * 6 + score7 * 12 + score8 * 12 + score9 * 14 + score10 * 7 + score11 * 18 + score12 * 10
					+ score13 * 10 + score14 * 10 + score15 * 8 + score16 * 5 + score17 * 1 + score18 * 2 + score19 * 8
					+ score20 * 6 + score21 * 2 + score22 * 6 + score23 * 12 + score24 * 12 + score25 * 14 + score26 * 7
					+ score27 * 18 + score28 * 10 + score29 * 10 + score30 * 10 + score31 * 8 + score32 * 5));
			manyrifmatchService.updateByPrimaryKeySelective(manyrifmatch);

		}

		return manyrifmatch;
	}

	/*
	 * 程序更新
	 * 
	 * 算分系统， 此程序用来计算第一种项目类型的 计算得分
	 */
	public Twoptionsmatch calculate(Twoptionsmatch twoptionsmatch) {

		// if (condition) {
		//
		// }
		//
		//
		double score1;
		double score2;
		try {// 中文校验
			score1 = Double.parseDouble(twoptionsmatch.getScoreone());
		} catch (Exception e) {

			score1 = 0;
		}
		try {
			score2 = Double.parseDouble(twoptionsmatch.getScoretwo());
		} catch (Exception e) {

			score2 = 0;
		}
		double scorefinal = score1 + score2;
		twoptionsmatch.setFinalscore(Double.toString(scorefinal));
		if (twoptionsmatch.getJoinlist() == 20) {

			if (score1 > 30) {
				score1 = 30;
			}
			if (score2 > 30) {
				score2 = 30;
			}
			scorefinal = score1 + score2;

			twoptionsmatch.setFinalscore(Double.toString(scorefinal));

		} else {

			scorefinal = score1 + score2;
			System.out.println(twoptionsmatch.getName() + "最终的结果为：" + scorefinal);
			twoptionsmatch.setFinalscore(Double.toString(scorefinal));
		}

		return twoptionsmatch;
	}

	public List<Mangoptionsmatch> sortclacs(List<Mangoptionsmatch> list) {
		Collections.sort(list, new Comparator<Mangoptionsmatch>() {

			@Override
			public int compare(Mangoptionsmatch o1, Mangoptionsmatch o2) {
				int i = 0;
				if (Double.parseDouble(o1.getScorefinal()) - Double.parseDouble(o2.getScorefinal()) > 0) {
					i = -1;
					return i;
				} else if (Double.parseDouble(o1.getScorefinal()) - Double.parseDouble(o2.getScorefinal()) == 0) {

				} else if (Double.parseDouble(o1.getScorefinal()) - Double.parseDouble(o2.getScorefinal()) > 0) {
					i = 1;
					return i;
				}

				return i;

			}
		}

		);

		int i = list.size();
		System.out.println("list.size" + list.size());
		for (Mangoptionsmatch mangoptionsmatch : list) {
			mangoptionsmatch.setRank(i);
			System.out.println("排名中：" + mangoptionsmatch.getName() + "rank:" + mangoptionsmatch.getRank() + "第一轮分数"
					+ mangoptionsmatch.getScorefinalone() + "第二轮分数" + mangoptionsmatch.getScorefinaltwo() + "总分数"
					+ mangoptionsmatch.getScorefinal());
			mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch);
			System.out.println("開始排名：" + "名字：" + mangoptionsmatch.getName() + "分數：" + mangoptionsmatch.getScorefinal()
					+ "排名" + mangoptionsmatch.getRank());
			i--;
		}

		return list;
	}

	public List<Twoptionsmatch> sortclac(List<Twoptionsmatch> list) {

		Collections.sort(list, new Comparator<Twoptionsmatch>() {

			@Override
			public int compare(Twoptionsmatch o1, Twoptionsmatch o2) {

				int i = (int) Double.parseDouble(o1.getFinalscore()) - (int) Double.parseDouble(o2.getFinalscore());
				if (i == 0) {
					return Integer.parseInt(o1.getFinalscore()) - Integer.parseInt(o2.getFinalscore());
				}
				return i;
			}
		}
		);
		int i = list.size();
		System.err.println("次组别有人数为：" + i);
		for (Twoptionsmatch twoptionsmatch : list) {
			twoptionsmatch.setRank(i);
			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatch);
			System.out.println("開始排名：" + "名字：" + twoptionsmatch.getName() + "分數：" + twoptionsmatch.getFinalscore());
			i--;
		}
		return list;
	}
	/*
	 * 有批次的最終排名
	 */
//	public List<Turnmatchlist> sortTurnmatchlistclac(List<Turnmatchlist> list) {
//
//		Collections.sort(list, new Comparator<Turnmatchlist>() {
//
//			@Override
//			public int compare(Turnmatchlist o1, Turnmatchlist o2) {
//				double score1 = Double.parseDouble(o1.getScoreinoneturn());
//				double score2 = Double.parseDouble(o1.getScoreintwoturn());
//				double score3 = Double.parseDouble(o2.getScoreinoneturn());
//				double score4 = Double.parseDouble(o2.getScoreintwoturn());
//				double score1best = 0;
//				double score2best = 0;
//				int i = (int) Double.parseDouble(o1.getScore()) - (int) Double.parseDouble(o2.getScore());
//				if (i == 0) {
//					if (score1 > score2) {
//						score1best = score1;
//					} else if (score1 < score2) {
//						score1best = score2;
//					} else {
//						score1best = score1;
//					}
//					if (score3 > score4) {
//						score2best = score3;
//					} else if (score3 < score4) {
//						score2best = score4;
//					} else {
//						score2best = score3;
//					}
//					return (int) (score1best - score2best);
//				}
//				return i;
//
//			}
//		});
//		int i = list.size();
//		for (Turnmatchlist turnmatchlist : list) {
//			turnmatchlist.setRank(i);
//			turnMatchListService.updateByPrimaryKeySelective(turnmatchlist);
//			System.out.println("開始排名：" + "名字：" + turnmatchlist.getName() + "分數：" + turnmatchlist.getScore());
//			i--;
//		}
//
//		return list;
//
//	}

	public Withfriendmatch calculate(Withfriendmatch withfriendmatch) {
		System.out.println(withfriendmatch);
		String score1string = withfriendmatch.getScoreone();
		String score2string = withfriendmatch.getScoretwo();
		String[] score1old = null;
		String[] score2old = null;
		double score1 = 0;
		double score2 = 0;
		double score11 = 0;
		double score12 = 0;

		if (score1string.contains("+")) {
			score1old = score1string.split("\\+");
			if (score1old[1].endsWith("a") || score1old[1].endsWith("A") || score1old[1].endsWith("B")
					|| score1old[1].endsWith("b") || score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
				if (score1old[1].endsWith("a") || score1old[1].endsWith("A")) {
					score11 = 0.1;

				} else if (score1old[1].endsWith("B") || score1old[1].endsWith("b")) {
					score11 = 0.2;
				} else if (score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
					score11 = 0.3;
				}

				score1 = Double.parseDouble(score1old[0]) + score11;

			}
		} else if (!score1string.contains("+")) {

			score1 = Double.parseDouble(score1string);

		}
		if (score2string.contains("+")) {
			score2old = score2string.split("\\+");
			if (score2old[1].endsWith("a") || score2old[1].endsWith("A") || score2old[1].endsWith("B")
					|| score2old[1].endsWith("b") || score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
				if (score2old[1].endsWith("a") || score2old[1].endsWith("A")) {
					score12 = 0.1;

				} else if (score2old[1].endsWith("B") || score2old[1].endsWith("b")) {
					score12 = 0.2;
				} else if (score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
					score12 = 0.3;
				}

				score2 = Double.parseDouble(score2old[0]) + score12;
			}
		} else if (!score2string.contains("+")) {
			score2 = Double.parseDouble(score2string);

		}

		withfriendmatch.setFinalscore(Double.toString(score1 + score2));

		return withfriendmatch;
	}

//	public List<Withfriendmatch> sort(Withfriendmatch withfriendmatch){
//		List<Withfriendmatch>  withfriendmatchs=withfriendmatchService.findWhoJoinThisMatchThisListAndHasConfirm(withfriendmatch.getJoinmatch(), withfriendmatch.getJoinlist(), withfriendmatch.getJoingagae());
//		List<Withfriendmatch> withfriendmatchsneedTosort=new ArrayList<Withfriendmatch>();
//		String tempFriendId=null;
//	//	int i=0;
////		for (Withfriendmatch withfriendmatch2 : withfriendmatchs) {
////			if (withfriendmatch2.getMyteamfriend().endsWith(tempFriendId)) {
////				
////			}
////			tempFriendId=withfriendmatch2.getMyteamfriend();
////		}
//		for (Withfriendmatch withfriendmatch2 : withfriendmatchs) {
//			String score1string = withfriendmatch2.getScoreone();
//			String score2string = withfriendmatch2.getScoretwo();
//			String[] score1old = null;
//			String[] score2old = null;
//			double score1 = 0;
//			double score2 = 0;
//			double score11 = 0;
//			double score12 = 0;
//
//			if (score1string.contains("+")) {
//				score1old = score1string.split("\\+");
//				if (score1old[1].endsWith("a") || score1old[1].endsWith("A") || score1old[1].endsWith("B")
//						|| score1old[1].endsWith("b") || score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
//					if (score1old[1].endsWith("a") || score1old[1].endsWith("A")) {
//						score11 = 0.1;
//
//					} else if (score1old[1].endsWith("B") || score1old[1].endsWith("b")) {
//						score11 = 0.2;
//					} else if (score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
//						score11 = 0.3;
//					}
//
//					score1 = Double.parseDouble(score1old[0]) + score11;
//		
//				}
//			} else if (!score1string.contains("+")) {
//
//				score1 = Double.parseDouble(score1string);
//
//			}
//			withfriendmatch2.setScoreonebytranslate(score1);
//			if (score2string.contains("+")) {
//				score2old = score2string.split("\\+");
//				if (score2old[1].endsWith("a") || score2old[1].endsWith("A") || score2old[1].endsWith("B")
//						|| score2old[1].endsWith("b") || score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
//					if (score2old[1].endsWith("a") || score2old[1].endsWith("A")) {
//						score12 = 0.1;
//
//					} else if (score2old[1].endsWith("B") || score2old[1].endsWith("b")) {
//						score12 = 0.2;
//					} else if (score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
//						score12 = 0.3;
//					}
//
//					score2 = Double.parseDouble(score2old[0]) + score12;
//				}
//			} else if (!score2string.contains("+")) {
//				score2 = Double.parseDouble(score2string);
//
//			}
//			withfriendmatch2.setScoretwobytranslate(score2);
//			withfriendmatch2.setFinalscore(Double.toString(score1 + score2));
//			withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch2);
//			
//		}
//		Collections.sort(withfriendmatchs);
//		int i = 1;
//		for (Withfriendmatch withfriendmatch2 : withfriendmatchs) {
//			if (withfriendmatchs.size() >= 8) {
//				if ((i <= Math.ceil((withfriendmatchs.size() * 0.15)))) {
//					withfriendmatch2.setReward("一等奖");
//				} else if (i > (withfriendmatchs.size() * 0.15) && i <= Math.ceil((withfriendmatchs.size() * 0.3))) {
//					withfriendmatch2.setReward("二等奖");
//				} else if (i > (withfriendmatchs.size() * 0.3) && i <= Math.ceil((withfriendmatchs.size() * 0.6))) {
//					withfriendmatch2.setReward("三等奖");
//				} else if (i > Math.ceil((withfriendmatchs.size() * 0.6))) {
//					withfriendmatch2.setReward("");
//				}
//			}
//			withfriendmatch2.setRank(i);
//			i++;
//			withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch2);
//		}
//		withfriendmatchs = withfriendmatchService.findWhoJoinThisMatchThisListAndHasConfirm(withfriendmatch.getJoinmatch(),
//				withfriendmatch.getJoinlist(), withfriendmatch.getJoingagae());
//		return withfriendmatchs;
//	}
	public List<Withfriendmatch> sortclacss(List<Withfriendmatch> list) {
		Collections.sort(list, new Comparator<Withfriendmatch>() {

			@Override
			public int compare(Withfriendmatch o1, Withfriendmatch o2) {

				int i = (int) Double.parseDouble(o1.getFinalscore()) - (int) Double.parseDouble(o2.getFinalscore());
				if (i == 0) {
					return Integer.parseInt(o1.getFinalscore()) - Integer.parseInt(o2.getFinalscore());
				}
				return i;

			}
		}

		);

		int i = (list.size() / 3);
		for (Withfriendmatch withfriendmatch : list) {
			int j = 0;
			withfriendmatch.setRank(i);
			withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch);
			System.out.println("開始排名：" + "名字：" + withfriendmatch.getName() + "分數：" + withfriendmatch.getFinalscore());
			if (j == 2) {
				i--;
			}
			j++;
		}

		return list;
	}

	public Withfriendmatch rankcalculate(Withfriendmatch withfriendmatch) {

		int gage = withfriendmatch.getJoingagae();
		int matchlist = withfriendmatch.getJoinlist();
		List<Withfriendmatch> findWhereIsMyListGagePeople = withfriendmatchService.findWhereIsMyListGagePeople(gage,
				matchlist);
		// 此项目排序
		sortclacss(findWhereIsMyListGagePeople);
		withfriendmatch = withfriendmatchService.findByJpId(withfriendmatch.getJoinpeopleid());

		return withfriendmatch;

	}

	/*
	 * 算分系统，此程序用来计算第二种项目类型的 计算得分
	 */
	public Mangoptionsmatch calculate(Mangoptionsmatch mangoptionsmatch) {
		JoinMatchTeamPeople joinMatchTeamPeople = joinMatchTeamPeopleService
				.selectByPrimaryKey(mangoptionsmatch.getJoinpeopleid());
		if (joinMatchTeamPeople.getJoinmatchlist() == 5) {
			/*
			 * 蓝翔二号
			 */
			double score1 = 0;// 第一轮
								// 往
			double score2 = 0;// 第一轮
								// 饭
			double score3 = 0;// 第二轮
								// 往
			double score4 = 0;// 第二轮
								// 返
								// 中文校验
			try {
				score1 = Double.parseDouble(mangoptionsmatch.getScore1one());
			} catch (Exception e) {

				score1 = 0;
			}

			try {
				score2 = Double.parseDouble(mangoptionsmatch.getScore2one());
			} catch (Exception e) {

				score2 = 0;
			}
			try {
				score3 = Double.parseDouble(mangoptionsmatch.getScore1two());
			} catch (Exception e) {

				score3 = 0;
			}
			try {
				score4 = Double.parseDouble(mangoptionsmatch.getScore2two());
			} catch (Exception e) {

				score4 = 0;
			}

			double score5 = score1 + score2 + score3 + score4;// 总成绩
			mangoptionsmatch.setScorefinalone(Double.toString(score1 + score2));
			mangoptionsmatch.setScorefinaltwo(Double.toString(score3 + score4));
			mangoptionsmatch.setScorefinal(Double.toString(score5));

			System.out.println("此人：" + mangoptionsmatch);
		} else if (joinMatchTeamPeople.getJoinmatchlist() == 10) {
			/*
			 * 10.“美利达”遥控飞机追逐赛
			 */
			double score1 = 0;// 第一轮
								// 圈
			double score2 = 0;// 第一轮
								// 秒
			double score3 = 0;// 第二轮
								// 圈
			double score4 = 0;// 第二轮
								// 秒
			try {
				score1 = Double.parseDouble(mangoptionsmatch.getScore1one());
			} catch (Exception e) {
				// TODO: handle exception
				score1 = 0;
			}

			try {
				score2 = Double.parseDouble(mangoptionsmatch.getScore2one());
			} catch (Exception e) {
				// TODO: handle exception
				score2 = 0;
			}
			try {
				score3 = Double.parseDouble(mangoptionsmatch.getScore1two());
			} catch (Exception e) {
				// TODO: handle exception
				score3 = 0;
			}
			try {
				score4 = Double.parseDouble(mangoptionsmatch.getScore2two());
			} catch (Exception e) {
				// TODO: handle exception
				score4 = 0;
			}

			String score5 = Double.toString(score1) + "+" + Double.toString(score3);
			mangoptionsmatch.setScorefinalone(Double.toString(score2));
			mangoptionsmatch.setScorefinaltwo(Double.toString(score4));
			mangoptionsmatch.setScorefinal(score5);
			mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch);
		} else if (joinMatchTeamPeople.getJoinmatchlist() == 11) {
			/*
			 * 11.“天戈”遥控直升机障碍赛
			 */

			double score1 = 0;// 第一轮
								// 起飞
			double score2 = 0;// 第一轮
								// 穿越山洞
			double score3 = 0;// 第一轮
								// 穿越时空隧道
			double score4 = 0;// 第一轮
								// 高台停机观景
			double score5 = 0;// 第一轮
								// 飞越高山
			double score6 = 0;// 第一轮
								// 着陆
			double score7 = 0;// 第一轮
								// 时间
			double score8 = 0;// 第二轮
								// 起飞
			double score9 = 0;// 第二轮
								// 穿越山洞
			double score10 = 0;// 第二轮 穿越时空隧道
			double score11 = 0;// 第二轮 高台停机观景
			double score12 = 0;// 第二轮 飞越高山
			double score13 = 0;// 第二轮 着陆
			double score14 = 0;// 第二轮 时间

			try {
				score1 = Double.parseDouble(mangoptionsmatch.getScore1one());

			} catch (Exception e) {
				// TODO: handle exception
				score1 = 0;
			}

			try {
				score2 = Double.parseDouble(mangoptionsmatch.getScore2one());
			} catch (Exception e) {
				// TODO: handle exception
				score2 = 0;
			}
			try {
				score3 = Double.parseDouble(mangoptionsmatch.getScore3one());
			} catch (Exception e) {
				// TODO: handle exception
				score3 = 0;
			}
			try {
				score4 = Double.parseDouble(mangoptionsmatch.getScore4one());
			} catch (Exception e) {
				// TODO: handle exception
				score4 = 0;
			}
			try {
				score5 = Double.parseDouble(mangoptionsmatch.getScore5one());
			} catch (Exception e) {
				// TODO: handle exception
				score5 = 0;

			}

			try {
				score6 = Double.parseDouble(mangoptionsmatch.getScore6one());
			} catch (Exception e) {
				// TODO: handle exception
				score6 = 0;
			}
			try {
				score7 = Double.parseDouble(mangoptionsmatch.getScore7one());
			} catch (Exception e) {
				// TODO: handle exception
				score7 = 0;
			}
			try {
				score8 = Double.parseDouble(mangoptionsmatch.getScore1two());
			} catch (Exception e) {
				// TODO: handle exception
				score8 = 0;
			}
			try {
				score9 = Double.parseDouble(mangoptionsmatch.getScore2two());
			} catch (Exception e) {
				// TODO: handle exception
				score9 = 0;
			}

			try {
				score10 = Double.parseDouble(mangoptionsmatch.getScore3two());
			} catch (Exception e) {
				// TODO: handle exception
				score10 = 0;
			}
			try {
				score11 = Double.parseDouble(mangoptionsmatch.getScore4two());
			} catch (Exception e) {
				// TODO: handle exception
				score11 = 0;
			}
			try {
				score12 = Double.parseDouble(mangoptionsmatch.getScore5two());
			} catch (Exception e) {
				// TODO: handle exception
				score12 = 0;
			}
			try {
				score13 = Double.parseDouble(mangoptionsmatch.getScore6two());
			} catch (Exception e) {
				// TODO: handle exception
				score13 = 0;
			}

			try {
				score14 = Double.parseDouble(mangoptionsmatch.getScore7two());
			} catch (Exception e) {
				// TODO: handle exception
				score14 = 0;
			}
			System.out.println(score1);
			System.out.println(score2);
			System.out.println(score3);
			System.out.println(score4);
			System.out.println(score5);
			System.out.println(score6);
			System.out.println(score7);
			System.out.println(score8);
			System.out.println(score9);
			System.out.println(score10);
			System.out.println(score11);
			System.out.println(score12);
			System.out.println(score13);
			System.out.println(score14);
			double scorefinalone = score1 + score2 + score3 + score4 + score5 + score6;
			double scorefinaltwo = score8 + score9 + score10 + score11 + score12 + score13;
			double scorefinal = score1 + score2 + score3 + score4 + score5 + score6 + score8 + score9 + score10
					+ score11 + score12 + score13;
			mangoptionsmatch.setScorefinalone(Double.toString(scorefinalone));
			System.out.println("经过计算：" + "第一轮成绩为：" + mangoptionsmatch.getScorefinalone());
			mangoptionsmatch.setScorefinaltwo(Double.toString(scorefinaltwo));
			System.out.println("经过计算：" + "第2轮成绩为：" + mangoptionsmatch.getScorefinaltwo());
			mangoptionsmatch.setScorefinal(Double.toString(scorefinal));
			System.out.println("经过计算：" + "总成绩为：" + mangoptionsmatch.getScorefinal());
		} else if (joinMatchTeamPeople.getJoinmatchlist() == 12) {
			/*
			 * 12.“美嘉欣”遥控四轴飞行器竞时赛
			 */

			double score1 = 0;// 第一轮
								// 起飞
			double score2 = 0;// 第一轮
								// 穿越圆环
			double score3 = 0;// 第一轮
								// 空中翻转
			double score4 = 0;// 第一轮
								// 穿越天井
			double score5 = 0;// 第一轮
								// 空中翻滚
			double score6 = 0;// 第一轮
								// 冲出隧道
			double score7 = 0;// 第一轮
								// 着陆
			double score8 = 0;// 第一轮
								// 时间

			double score9 = 0;// 第二轮
								// 起飞
			double score10 = 0;// 第二轮 穿越圆环
			double score11 = 0;// 第二轮 空中翻转
			double score12 = 0;// 第二轮 穿越天井
			double score13 = 0;// 第二轮 空中翻滚
			double score14 = 0;// 第二轮冲出隧道
			double score15 = 0;// 第二轮 着陆
			double score16 = 0;// 第二轮 时间

			try {
				score1 = Double.parseDouble(mangoptionsmatch.getScore1one());
			} catch (Exception e) {
				// TODO: handle exception
				score1 = 0;
			} finally {

			}

			try {
				score2 = Double.parseDouble(mangoptionsmatch.getScore2one());
			} catch (Exception e) {
				// TODO: handle exception
				score2 = 0;
			} finally {

			}
			try {
				score3 = Double.parseDouble(mangoptionsmatch.getScore3one());
			} catch (Exception e) {
				// TODO: handle exception
				score3 = 0;
			} finally {

			}
			try {
				score4 = Double.parseDouble(mangoptionsmatch.getScore4one());
			} catch (Exception e) {
				// TODO: handle exception
				score4 = 0;
			} finally {

			}
			try {
				score5 = Double.parseDouble(mangoptionsmatch.getScore5one());
			} catch (Exception e) {
				// TODO: handle exception
				score5 = 0;
			} finally {

			}

			try {
				score6 = Double.parseDouble(mangoptionsmatch.getScore6one());
			} catch (Exception e) {
				// TODO: handle exception
				score6 = 0;
			} finally {

			}
			try {
				score7 = Double.parseDouble(mangoptionsmatch.getScore7one());
			} catch (Exception e) {
				// TODO: handle exception
				score7 = 0;
			} finally {

			}
			try {
				score8 = Double.parseDouble(mangoptionsmatch.getScore8one());
			} catch (Exception e) {
				// TODO: handle exception
				score8 = 0;
			} finally {

			}
			try {
				score9 = Double.parseDouble(mangoptionsmatch.getScore1two());
			} catch (Exception e) {
				// TODO: handle exception
				score9 = 0;
			} finally {

			}

			try {
				score10 = Double.parseDouble(mangoptionsmatch.getScore2two());
			} catch (Exception e) {
				// TODO: handle exception
				score10 = 0;
			} finally {

			}
			try {
				score11 = Double.parseDouble(mangoptionsmatch.getScore3two());
			} catch (Exception e) {
				// TODO: handle exception
				score11 = 0;
			} finally {

			}
			try {
				score12 = Double.parseDouble(mangoptionsmatch.getScore4two());
			} catch (Exception e) {
				// TODO: handle exception
				score12 = 0;
			} finally {

			}
			try {
				score13 = Double.parseDouble(mangoptionsmatch.getScore5two());
			} catch (Exception e) {
				// TODO: handle exception
				score13 = 0;
			} finally {

			}

			try {
				score14 = Double.parseDouble(mangoptionsmatch.getScore6two());
			} catch (Exception e) {
				// TODO: handle exception
				score14 = 0;
			} finally {

			}

			try {
				score15 = Double.parseDouble(mangoptionsmatch.getScore7two());
			} catch (Exception e) {
				// TODO: handle exception
				score15 = 0;
			} finally {

			}

			try {
				score16 = Double.parseDouble(mangoptionsmatch.getScore8two());
			} catch (Exception e) {
				// TODO: handle exception
				score16 = 0;
			} finally {

			}
			System.out.println(score1);
			System.out.println(score2);
			System.out.println(score3);
			System.out.println(score4);
			System.out.println(score5);
			System.out.println(score6);
			System.out.println(score7);
			System.out.println(score8);
			System.out.println(score9);
			System.out.println(score10);
			System.out.println(score11);
			System.out.println(score12);
			System.out.println(score13);
			System.out.println(score14);
			System.out.println(score15);
			System.out.println(score16);
			mangoptionsmatch
					.setScorefinalone(Double.toString(score1 + score2 + score3 + score4 + score5 + score6 + score7));
			mangoptionsmatch.setScorefinaltwo(
					Double.toString(score9 + score10 + score11 + score12 + score13 + score14 + score15));
			mangoptionsmatch.setScorefinal(Double.toString(score1 + score2 + score3 + score4 + score5 + score6 + score7
					+ score9 + score10 + score11 + score12 + score13 + score14 + score15));

		} else if (joinMatchTeamPeople.getJoinmatchlist() == 13) {// 一半 未完成
			/*
			 * 13.双桨共轴直升机救援赛
			 */

			double score1 = 0;// 第一轮
								// 分数
			double score2 = 0;// 第一轮
								// 时间

			double score3 = 0;// 第二轮
								// 起飞
			double score4 = 0;// 第二轮
								// 穿越圆环

			try {
				score1 = Double.parseDouble(mangoptionsmatch.getScore1one());
			} catch (Exception e) {
				// TODO: handle exception
				score1 = 0;
			} finally {

			}

			try {
				score2 = Double.parseDouble(mangoptionsmatch.getScore2one());
			} catch (Exception e) {
				// TODO: handle exception
				score2 = 0;
			} finally {

			}
			try {
				score3 = Double.parseDouble(mangoptionsmatch.getScore1two());
			} catch (Exception e) {
				// TODO: handle exception
				score3 = 0;
			} finally {

			}
			try {
				score4 = Double.parseDouble(mangoptionsmatch.getScore2two());
			} catch (Exception e) {
				// TODO: handle exception
				score4 = 0;
			} finally {

			}

			mangoptionsmatch.setScorefinalone(Double.toString(score1));
			mangoptionsmatch.setScorefinaltwo(Double.toString(score3));
			mangoptionsmatch.setScorefinal(Double.toString(score1 + score3));

		} else if (joinMatchTeamPeople.getJoinmatchlist() == 14) {// 一半 未完成
			/*
			 * “空中战士Ⅱ”线操纵飞机积分赛
			 */

			double score1 = Double.parseDouble(mangoptionsmatch.getScore1one());// 第一轮
																				// 1号小球
			double score2 = Double.parseDouble(mangoptionsmatch.getScore2one());// 第一轮
																				// 2号小球
			double score3 = Double.parseDouble(mangoptionsmatch.getScore3one());// 第一轮
																				// 3号小球
			double score4 = Double.parseDouble(mangoptionsmatch.getScore4one());// 第一轮
																				// 扣分
			double score5 = Double.parseDouble(mangoptionsmatch.getScore5one());// 第一轮
																				// 着陆

			double score6 = Double.parseDouble(mangoptionsmatch.getScore1two());// 第一轮1号小球
			double score7 = Double.parseDouble(mangoptionsmatch.getScore2two());// 第一轮
																				// 2号小球
			double score8 = Double.parseDouble(mangoptionsmatch.getScore3two());// 第一轮
																				// 3号小球
			double score9 = Double.parseDouble(mangoptionsmatch.getScore4two());// 第一轮
																				// 扣分
			double score10 = Double.parseDouble(mangoptionsmatch.getScore5two());// 第一轮
																					// 着陆

			mangoptionsmatch.setScorefinalone(Double.toString(score1));
			mangoptionsmatch.setScorefinaltwo(Double.toString(score3));
			mangoptionsmatch.setScorefinal(Double.toString(score1 + score3));

		}
		mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch);

		return mangoptionsmatch;
	}


	
	
	

	// 批次表生產
	public void setTurn1(int matchid, int matchlistid, int gage, int turn) {// turn=批次
																			// 次程序
																			// 慎用！！！
System.out.println("此人的比赛是："+matchid);
System.out.println("此人的项目是："+matchlistid);
System.out.println("此人的组别是："+gage);
System.out.println("此项目批次有："+turn);
		List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService.showSelectPeople(matchid,
				matchlistid, gage);
		Collections.shuffle(joinMatchTeamPeoples);
		Collections.shuffle(joinMatchTeamPeoples);
		Collections.shuffle(joinMatchTeamPeoples);
		int num = joinMatchTeamPeoples.size();// 该组别的人数
		System.out.println("该组别的人数:" + num);
		int numPeople = num / turn;// 每批次应该有的人数
		System.out.println("每批次应该有的人数:" + numPeople);

		int i = 1;
		while (i <= num) {
			System.out.println("开始while循环");
			int j = 1;
			int k = 1;
			int o=1;
			for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
				if (joinMatchTeamPeople.getIsteammatchlist() == null || joinMatchTeamPeople.getIsteammatchlist() == ""
						|| joinMatchTeamPeople.getIsteammatchlist().equals("")
						|| joinMatchTeamPeople.getIsteammatchlist().length() == 0) {
					joinMatchTeamPeople.setIsteammatchlist("0");
				}
				System.out.println("开始for循环");
				Turnmatchlist turnMatchList = new Turnmatchlist();
				
				turnMatchList.setJoingage(joinMatchTeamPeople.getGage());
				turnMatchList.setJoinlist(joinMatchTeamPeople.getJoinmatchlist());
				turnMatchList.setJoinpeopleid(joinMatchTeamPeople.getId());
				turnMatchList.setName(joinMatchTeamPeople.getName());
				turnMatchList.setSn(joinMatchTeamPeople.getPeoplesn());
				turnMatchList.setIsteammatch(Integer.parseInt(joinMatchTeamPeople.getIsteammatchlist()));
				turnMatchList.setTeamname(joinMatchTeamPeople.getTeamname());
				if (k <= numPeople) {
					System.out.println(
							"i<=每批次应该有的人数，所以执行此程序，为每一个" + j + "批次的人加上批次值，" + "此时i的值为：" + i + ",这是这个批次的第" + k + "人");
					turnMatchList.setTurn1(j);
					turnMatchList.setTurn2(j);
					System.out.println("这是第" + i + "个人的记录");

				}
				if (k > numPeople) {
					k = 1;

					j++;
					System.out.println(
							"i>每批次应该有的人数，所以执行此程序，为每一个" + j + "批次的人加上批次值，" + "此时i的值为：" + i + ",这是这个批次的第" + k + "人");
					System.out.println("这是第" + i + "个人的记录");
					turnMatchList.setTurn1(j);
					turnMatchList.setTurn2(j);

				}

				System.out.println("开始写入");
				System.out.println("准备写第" + i + "个人的记录");
				k++;
				i++;
				turnMatchListService.insertSelective(turnMatchList);

			}

		}

	}

	public void setTurn2(int matchid, int matchlistid, int gage, int turn) {// turn=批次
		// 次程序
		// 慎用！！！
		System.out.println("第二轮的批次：");
		System.out.println("此人的比赛是："+matchid);
		System.out.println("此人的项目是："+matchlistid);
		System.out.println("此人的组别是："+gage);
		System.out.println("此项目批次有："+turn);
		List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService.showSelectPeople(matchid,
				matchlistid, gage);
		Collections.shuffle(joinMatchTeamPeoples);
		Collections.shuffle(joinMatchTeamPeoples);
		Collections.shuffle(joinMatchTeamPeoples);
		int num = joinMatchTeamPeoples.size();// 该组别的人数
		System.out.println("该组别的人数:" + num);
		int numPeople = num / turn;// 每批次应该有的人数
		System.out.println("每批次应该有的人数:" + numPeople);

		int i = 1;
		while (i <= num) {
			System.out.println("开始while循环");
			int j = 1;
			int k = 1;
			for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
				if (joinMatchTeamPeople.getIsteammatchlist() == null || joinMatchTeamPeople.getIsteammatchlist() == ""
						|| joinMatchTeamPeople.getIsteammatchlist().equals("")
						|| joinMatchTeamPeople.getIsteammatchlist().length() == 0) {
					joinMatchTeamPeople.setIsteammatchlist("0");
				}
				System.out.println("开始for循环");
				Turnmatchlist turnMatchList = new Turnmatchlist();
				turnMatchList.setJoingage(joinMatchTeamPeople.getGage());
				turnMatchList.setJoinlist(joinMatchTeamPeople.getJoinmatchlist());
				turnMatchList.setJoinpeopleid(joinMatchTeamPeople.getId());
				turnMatchList.setName(joinMatchTeamPeople.getName());
				turnMatchList.setSn(joinMatchTeamPeople.getPeoplesn());
				turnMatchList.setIsteammatch(Integer.parseInt(joinMatchTeamPeople.getIsteammatchlist()));
				turnMatchList.setTeamname(joinMatchTeamPeople.getTeamname());

				if (k <= numPeople) {
					System.out.println(
							"i<=每批次应该有的人数，所以执行此程序，为每一个" + j + "批次的人加上批次值，" + "此时i的值为：" + i + ",这是这个批次的第" + k + "人");
					turnMatchList.setTurn2(j);
					System.out.println("这是第" + i + "个人的记录");

				}
				if (k > numPeople) {
					k = 1;

					j++;
					System.out.println(
							"i>每批次应该有的人数，所以执行此程序，为每一个" + j + "批次的人加上批次值，" + "此时i的值为：" + i + ",这是这个批次的第" + k + "人");
					System.out.println("这是第" + i + "个人的记录");
					turnMatchList.setTurn2(j);

				}

				System.out.println("开始写入");
				System.out.println("准备写第" + i + "个人的记录");
				k++;
				i++;
				turnMatchListService.updateByPrimaryKeySelective(turnMatchList);

			}

		}

	}

	@RequestMapping("showScore")
	public String showScore(Model model) {
		// List<Match> matchs = matchService.findAll();
		// model.addAttribute("matchs", matchs);
		List<MatchList> matchLists = matchListService.findAll();
		matchLists.remove(20);
		model.addAttribute("matchLists", matchLists);
		return "showScore";
	}

	@RequestMapping("showScorethismatchthislistthisgroup")
	public String showthislistgroup(int id, Model model) {
		System.out.println(id);
		List<MatchGroup> thisMatchGroups = matchGroupService.findAll();
		model.addAttribute("thisMatchGroups", thisMatchGroups);
		model.addAttribute("matchListId", id);
		return "showScorethismatchthislistthisgroup";
	}

	@RequestMapping("showthismatchListpeopleScore")
	public String showthismatchListpeopleScore(int matchgroup, int matchListId, Model model) {
		List<JoinMatchTeamPeople> jointhislistPeople = joinMatchTeamPeopleService.showSelectPeople(18, matchListId,
				matchgroup);
		List<Matchlist1> thislistscores = new ArrayList<>();
		for (JoinMatchTeamPeople joinMatchTeamPeople : jointhislistPeople) {
			Matchlist1 thispeopleScore = matchList1Service.findByPeople(joinMatchTeamPeople.getPeopleid());
			if (thispeopleScore != null) {
				thislistscores.add(thispeopleScore);
			}
		}
		System.out.println("此项目的成绩人数为：" + thislistscores.size());
		switch (matchListId) {
		case 1:
			System.out.println("第一项目开始排序");
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {

					int i = (int) (Double.parseDouble(o2.getScore3()) - Double.parseDouble(o1.getScore3()));
					if (i == 0) {
						int k = (int) (Double.parseDouble(o2.getScore2()) - Double.parseDouble(o1.getScore2()));
						if (k == 0) {
							return (int) (Double.parseDouble(o2.getScore1()) - Double.parseDouble(o1.getScore1()));
						}
						return k;
					}
					return i;
				}
			});
			break;
		case 2:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore23()) - Double.parseDouble(o2.getScore23()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore22()) - Double.parseDouble(o2.getScore22()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore21()) - Double.parseDouble(o2.getScore21()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 3:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore33()) - Double.parseDouble(o2.getScore33()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore32()) - Double.parseDouble(o2.getScore32()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore31()) - Double.parseDouble(o2.getScore31()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 4:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore43()) - Double.parseDouble(o2.getScore43()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore42()) - Double.parseDouble(o2.getScore42()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore41()) - Double.parseDouble(o2.getScore41()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 5:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o2.getScore53()) - Double.parseDouble(o1.getScore53()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o1.getScore52()) -
					// Double
					// .parseDouble(o2.getScore52()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o1.getScore51()) -
					// Double
					// .parseDouble(o2.getScore51()));
					// }
					// return k;
					// }
					return i;
				}
			});
			break;
		case 6:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore63()) - Double.parseDouble(o2.getScore63()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore62()) - Double.parseDouble(o2.getScore62()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore61()) - Double.parseDouble(o2.getScore61()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 7:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore73()) - Double.parseDouble(o2.getScore73()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore72()) - Double.parseDouble(o2.getScore72()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore71()) - Double.parseDouble(o2.getScore71()));
						}
						return k;
					}
					return i;
				}
			});
			break;
		case 8:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o2.getScore83()) - Double.parseDouble(o1.getScore83()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o2.getScore82()) -
					// Double
					// .parseDouble(o1.getScore82()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o2.getScore81()) -
					// Double
					// .parseDouble(o1.getScore81()));
					// }
					// return k;
					// }
					return i;
				}

			});
			break;
		case 9:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore93()) - Double.parseDouble(o2.getScore93()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o1.getScore92()) -
					// Double
					// .parseDouble(o2.getScore92()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o1.getScore91()) -
					// Double
					// .parseDouble(o2.getScore91()));
					// }
					// return k;
					// }
					return i;
				}

			});
			break;
		case 10:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore103()) - Double.parseDouble(o2.getScore103()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o1.getScore102()) -
					// Double
					// .parseDouble(o2.getScore102()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o1.getScore101()) -
					// Double
					// .parseDouble(o2.getScore101()));
					// }
					// return k;
					// }
					return i;
				}

			});
			break;
		case 11:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore113()) - Double.parseDouble(o2.getScore113()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o1.getScore112()) -
					// Double
					// .parseDouble(o2.getScore112()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o1.getScore111()) -
					// Double
					// .parseDouble(o2.getScore111()));
					// }
					// return k;
					// }
					return i;
				}

			});
			break;
		case 12:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore123()) - Double.parseDouble(o2.getScore123()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o1.getScore122()) -
					// Double
					// .parseDouble(o2.getScore122()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o1.getScore121()) -
					// Double
					// .parseDouble(o2.getScore121()));
					// }
					// return k;
					// }
					return i;
				}

			});
			break;
		case 13:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore133()) - Double.parseDouble(o2.getScore133()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore132()) - Double.parseDouble(o2.getScore132()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore131()) - Double.parseDouble(o2.getScore131()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 14:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore143()) - Double.parseDouble(o2.getScore143()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore142()) - Double.parseDouble(o2.getScore142()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore141()) - Double.parseDouble(o2.getScore141()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 15:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore153()) - Double.parseDouble(o2.getScore153()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore152()) - Double.parseDouble(o2.getScore152()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore151()) - Double.parseDouble(o2.getScore151()));
						}
						return k;
					}
					return i;
				}
			});
			break;
		case 16:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore163()) - Double.parseDouble(o2.getScore163()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore162()) - Double.parseDouble(o2.getScore162()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore161()) - Double.parseDouble(o2.getScore161()));
						}
						return k;
					}
					return i;
				}
			});
			break;
		case 17:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore173()) - Double.parseDouble(o2.getScore173()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o1.getScore172()) -
					// Double
					// .parseDouble(o2.getScore172()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o1.getScore171()) -
					// Double
					// .parseDouble(o2.getScore171()));
					// }
					// return k;
					// }
					return i;
				}

			});
			break;
		case 18:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore183()) - Double.parseDouble(o2.getScore183()));
					// if (i == 0.0) {
					// int k = (int) (Double.parseDouble(o1.getScore182()) -
					// Double
					// .parseDouble(o2.getScore182()));
					// if (k == 0.0) {
					// return (int) (Double.parseDouble(o1.getScore181()) -
					// Double
					// .parseDouble(o2.getScore181()));
					// }
					// return k;
					// }
					return i;
				}

			});
			break;
		case 19:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore193()) - Double.parseDouble(o2.getScore193()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore192()) - Double.parseDouble(o2.getScore192()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore191()) - Double.parseDouble(o2.getScore191()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 20:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore203()) - Double.parseDouble(o2.getScore203()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore202()) - Double.parseDouble(o2.getScore202()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore201()) - Double.parseDouble(o2.getScore201()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 21:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore213()) - Double.parseDouble(o2.getScore213()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore212()) - Double.parseDouble(o2.getScore212()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore211()) - Double.parseDouble(o2.getScore211()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 22:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore223()) - Double.parseDouble(o2.getScore223()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore222()) - Double.parseDouble(o2.getScore222()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore221()) - Double.parseDouble(o2.getScore221()));
						}
						return k;
					}
					return i;
				}

			});
			break;
		case 23:
			Collections.sort(thislistscores, new Comparator<Matchlist1>() {
				@Override
				public int compare(Matchlist1 o1, Matchlist1 o2) {
					int i = (int) (Double.parseDouble(o1.getScore233()) - Double.parseDouble(o2.getScore233()));
					if (i == 0.0) {
						int k = (int) (Double.parseDouble(o1.getScore232()) - Double.parseDouble(o2.getScore232()));
						if (k == 0.0) {
							return (int) (Double.parseDouble(o1.getScore231()) - Double.parseDouble(o2.getScore231()));
						}
						return k;
					}
					return i;
				}
			});
			break;

		default:
			break;
		}
		for (Matchlist1 matchlist1 : thislistscores) {
			System.out.println(matchlist1.getPeoplename());

			JoinMatchTeamPeople j = joinMatchTeamPeopleService.findme(matchlist1.getPeopleid());

			j.setScore1(Integer.toString((thislistscores.indexOf(matchlist1) + 1)));
			joinMatchTeamPeopleService.updateByPrimaryKeySelective(j);
		}

		model.addAttribute("listid", matchListId);
		model.addAttribute("thislistscores", thislistscores);
		return "showthismatchListpeopleScore";
	}

	
	/*
	 * 单轮单参数项目
	 */
	public List<Twoptionsmatch> sort(Twoptionsmatch twoptionsmatch) {
		/*
		 * 计算(每当有一个人成绩更新时 就开始重新计算所有排名)
		 */
		List<Twoptionsmatch> twoptionsmatchs = twoptionsMatchService.findWhoJoinThisMatchThisListAndHasConfirm(
				twoptionsmatch.getJoinmatch(), twoptionsmatch.getJoinlist(), twoptionsmatch.getJoingage());
		for (Twoptionsmatch twoptionsmatch2 : twoptionsmatchs) {
			double scoreOne2 = 0.0;
			double scoreTwo2 = 0.0;
			double scoreFinal2 = 0.0;
			try {
				scoreOne2 = Double.parseDouble(twoptionsmatch2.getScoreone());
			} catch (Exception e) {

				System.out.println("发现第一轮错误");
			}
			try {
				scoreTwo2 = Double.parseDouble(twoptionsmatch2.getScoretwo());
			} catch (Exception e) {

				System.out.println("发现第二轮错误");
			}
			twoptionsmatch2.setScoreonebytranslate(scoreOne2);
			System.out.println(scoreOne2);
			twoptionsmatch2.setScoretwobytranslate(scoreTwo2);
			scoreFinal2 = Arith.add(scoreOne2, scoreTwo2);
			twoptionsmatch2.setFinalscore(Double.toString(scoreFinal2));
			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatch2);
		}
		Collections.sort(twoptionsmatchs);
		int i = 1;
		int o=1;
		int k=1;
		int a=1;
		double lastscore=0;
		for (Twoptionsmatch twoptionsmatch2 : twoptionsmatchs) {
			if (twoptionsmatchs.size() >= 8) {
				if (((o <= Math.round((twoptionsmatchs.size() * 0.15))))&&(twoptionsmatch2.getFinalscore() !="0.0")) {
					twoptionsmatch2.setReward("一等奖");
				} else if ((o > Math.round(twoptionsmatchs.size() * 0.15)) &&( o < Math.round((twoptionsmatchs.size() * 0.3)))&&(twoptionsmatch2.getFinalscore() !="0.0")) {
					twoptionsmatch2.setReward("二等奖");
					System.out.println(twoptionsmatch2.getName()+"的排名是"+twoptionsmatch2.getRank()+"二等奖的顶范围是："+Math.round((twoptionsmatchs.size() * 0.3)));
				} else if ((o > Math.round(twoptionsmatchs.size() * 0.3)) && (o <= Math.round((twoptionsmatchs.size() * 0.6)))&&(twoptionsmatch2.getFinalscore() !="0.0")) {
					twoptionsmatch2.setReward("三等奖");
				} else if (o > Math.round((twoptionsmatchs.size() * 0.6))) {
					twoptionsmatch2.setReward("");
				}
			}
			/*
			 * 正常排名
			 */
//			
//			if (!(twoptionsmatch2.getScoreone().equals("弃权")&&twoptionsmatch2.getScoretwo().equals("弃权"))) {
//				if (!(lastscore==Double.parseDouble(twoptionsmatch2.getFinalscore()))) {
//					/*
//					 * 不同分数，顺序排
//					 */
//					twoptionsmatch2.setRank(i);
//					k=i;
//					
//				}else if(Double.parseDouble(twoptionsmatch2.getFinalscore())==0){
//					twoptionsmatch2.setRank(i);
//				}else {
//					/*
//					 * 相同分数，与前者一致
//					 */
//					twoptionsmatch2.setRank(k);
//					
//				}
//				i++;
//				
//				
//				lastscore=Double.parseDouble(twoptionsmatch2.getFinalscore());
//				
//				
//			}
			
			/*
			 * 航协要求的排名
			 */
			
			
			
			if (!(twoptionsmatch2.getScoreone().equals("弃权")&&twoptionsmatch2.getScoretwo().equals("弃权"))) {
				if (!(lastscore==Double.parseDouble(twoptionsmatch2.getFinalscore()))) {
					/*
					 * 不同分数，顺序排
					 */
					twoptionsmatch2.setRank(i);
					k=i;
					
				}else if(Double.parseDouble(twoptionsmatch2.getFinalscore())==0){
					
					
					twoptionsmatch2.setRank(a);
					
				}else {
					/*
					 * 相同分数，与前者一致
					 */
					twoptionsmatch2.setRank(k);
					
				}
				a++;
				i=k;
				i++;
				
				lastscore=Double.parseDouble(twoptionsmatch2.getFinalscore());
				
				
			}
		o++;
			twoptionsMatchService.updateByPrimaryKeySelective(twoptionsmatch2);
		}
		twoptionsmatchs = twoptionsMatchService.findWhoJoinThisMatchThisListAndHasConfirm(twoptionsmatch.getJoinmatch(),
				twoptionsmatch.getJoinlist(), twoptionsmatch.getJoingage());
		return twoptionsmatchs;
	}
	public List<Mangoptionsmatch> sort(	Mangoptionsmatch mangoptionsmatch
			) {
		/*
		 * 每当有人成绩更新时 ，整体再计算一遍
		 */
		List<Mangoptionsmatch> mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(
				mangoptionsmatch.getJoinmatch(), mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
		if (mangoptionsmatch.getJoinlist() == 10) {// 美利达
			for (Mangoptionsmatch mangoptionsmatch10 : mangoptionsmatchs) {
				double oneRoundscore1 = 0.0;
				double oneRoundscore2 = 0.0;// 第一轮时间
				double twoRoundscore1 = 0.0;
				double twoRoundscore2 = 0.0;// 第二轮时间
				try {
					oneRoundscore1 = Double.parseDouble(mangoptionsmatch10.getScore1one());// 第一轮圈数
				} catch (Exception e) {

				}
				try {
					oneRoundscore2 = Double.parseDouble(mangoptionsmatch10.getScore2one());// 第一轮时间
				} catch (Exception e) {

				}
				try {
					twoRoundscore1 = Double.parseDouble(mangoptionsmatch10.getScore1two());// 第二轮圈数
				} catch (Exception e) {

				}
				try {
					twoRoundscore2 = Double.parseDouble(mangoptionsmatch10.getScore2two());// 第二轮时间
				} catch (Exception e) {

				}
				
				mangoptionsmatch10.setScoreonebytranslate(oneRoundscore1);// 第一轮圈数
				mangoptionsmatch10.setScoretwobytranslate(twoRoundscore1);// 第二轮圈数
				String firstNum = Double.toString(oneRoundscore1);
				String secondNum = Double.toString(twoRoundscore1);
				mangoptionsmatch10.setScorefinalone(firstNum);
				mangoptionsmatch10.setScorefinaltwo(secondNum);
				mangoptionsmatch10.setScorefinal(firstNum + "+" + secondNum);
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch10);
			
			}
			
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.round((mangoptionsmatchs.size() * 0.15)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.15)) &&( i < Math.round((mangoptionsmatchs.size() * 0.3)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.3)) &&( i <= Math.round((mangoptionsmatchs.size() * 0.6)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.round((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				if (!(Mangoptionsmatchxx.getScore1one().equals("弃权")&&Mangoptionsmatchxx.getScore1two().equals("弃权"))) {
					Mangoptionsmatchxx.setRank(i);
					i++;
				}
				
				/*
				 * 12月5号 更新
				 */
				//Mangoptionsmatchxx.setRank(i);
				//i++;
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 5) {
			/*
			 * 第5个项目，蓝翔二号
			 */
			for (Mangoptionsmatch mangoptionsmatch5 : mangoptionsmatchs) {
				double firstcome = 0.0;
				double firstback = 0.0;
				double secondCome = 0.0;
				double secondBack = 0.0;
				double finaScore = 0.0;
				double firstroundD = 0.0;
				double secondroundD = 0.0;
				try {
					firstcome = Double.parseDouble(mangoptionsmatch5.getScore1one());
				} catch (Exception e) {

				}
				try {
					firstback = Double.parseDouble(mangoptionsmatch5.getScore2one());
				} catch (Exception e) {

				}
				try {
					secondCome = Double.parseDouble(mangoptionsmatch5.getScore1two());
				} catch (Exception e) {

				}
				try {
					secondBack = Double.parseDouble(mangoptionsmatch5.getScore2two());
				} catch (Exception e) {

				}
				firstroundD = Arith.add(firstcome, firstback);// 格式计算第一轮
				secondroundD = Arith.add(secondCome, secondBack);// 格式计算第二轮
				finaScore = Arith.add(firstroundD, secondroundD);// 格式计算总成绩
				mangoptionsmatch5.setScoreonebytranslate(firstroundD);
				mangoptionsmatch5.setScoretwobytranslate(secondroundD);
				String firstround = Double.toString(firstroundD);// 转换成String
				String secondround = Double.toString(secondroundD);// 转换成String
				String finalScore = Double.toString(finaScore);// 转换成String
				mangoptionsmatch5.setScorefinalone(firstround);
				mangoptionsmatch5.setScorefinaltwo(secondround);
				mangoptionsmatch5.setScorefinal(finalScore);
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch5);
			}
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if (((i <= Math.round((mangoptionsmatchs.size() * 0.15))))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.15)) &&( i < Math.round((mangoptionsmatchs.size() * 0.3)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.3)) &&( i <= Math.round((mangoptionsmatchs.size() * 0.6)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.round((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				if (!(Mangoptionsmatchxx.getScore1one().equals("弃权")&&Mangoptionsmatchxx.getScore1two().equals("弃权"))) {
					Mangoptionsmatchxx.setRank(i);
					i++;
				}
//				Mangoptionsmatchxx.setRank(i);
//				i++;
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 11) {
			/*
			 * 第11个项目 天戈
			 */
			for (Mangoptionsmatch mangoptionsmatch11 : mangoptionsmatchs) {
				double firstFly = 0.0;
				double firstcrossHole = 0.0;
				double firstcrossTime = 0.0;
				double firstWatchView = 0.0;
				double firstFlyMon = 0.0;
				double firstLoading = 0.0;
				double secondFly = 0.0;
				double secondcrossHole = 0.0;
				double secondcrossTime = 0.0;
				double secondWatchView = 0.0;
				double secondFlyMon = 0.0;
				double secondLoading = 0.0;

				double firstScore = 0.0;
				double secondScore = 0.0;
				double finalScore = 0.0;

				try {
					firstFly = Double.parseDouble(mangoptionsmatch11.getScore1one());
				} catch (Exception e) {

				}
				try {
					firstcrossHole = Double.parseDouble(mangoptionsmatch11.getScore2one());
				} catch (Exception e) {

				}
				try {
					firstcrossTime = Double.parseDouble(mangoptionsmatch11.getScore3one());
				} catch (Exception e) {

				}
				try {
					firstWatchView = Double.parseDouble(mangoptionsmatch11.getScore4one());
				} catch (Exception e) {

				}
				try {
					firstFlyMon = Double.parseDouble(mangoptionsmatch11.getScore5one());
				} catch (Exception e) {
				}
				try {
					firstLoading = Double.parseDouble(mangoptionsmatch11.getScore6one());
				} catch (Exception e) {
				}
				try {
					secondFly = Double.parseDouble(mangoptionsmatch11.getScore1two());
				} catch (Exception e) {
				}
				try {
					secondcrossHole = Double.parseDouble(mangoptionsmatch11.getScore2two());
				} catch (Exception e) {
				}
				try {
					secondcrossTime = Double.parseDouble(mangoptionsmatch11.getScore3two());
				} catch (Exception e) {
				}
				try {
					secondWatchView = Double.parseDouble(mangoptionsmatch11.getScore4two());
				} catch (Exception e) {
				}
				try {
					secondFlyMon = Double.parseDouble(mangoptionsmatch11.getScore5two());
				} catch (Exception e) {
				}
				try {
					secondLoading = Double.parseDouble(mangoptionsmatch11.getScore6two());
				} catch (Exception e) {
				}
				firstScore = Arith.add(firstFly, firstcrossHole);
				firstScore = Arith.add(firstScore, firstcrossTime);
				firstScore = Arith.add(firstScore, firstWatchView);
				firstScore = Arith.add(firstScore, firstFlyMon);
				firstScore = Arith.add(firstScore, firstLoading);
				secondScore = Arith.add(secondFly, secondcrossHole);
				secondScore = Arith.add(secondScore, secondcrossTime);
				secondScore = Arith.add(secondScore, secondWatchView);
				secondScore = Arith.add(secondScore, secondFlyMon);
				secondScore = Arith.add(secondScore, secondLoading);
				finalScore = Arith.add(firstScore, secondScore);
				mangoptionsmatch11.setScoreonebytranslate(firstScore);
				mangoptionsmatch11.setScoretwobytranslate(secondScore);
				mangoptionsmatch11.setScorefinalone(Double.toString(firstScore));
				mangoptionsmatch11.setScorefinaltwo(Double.toString(secondScore));
				mangoptionsmatch11.setScorefinal(Double.toString(finalScore));
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch11);
			}
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.round((mangoptionsmatchs.size() * 0.15))) &&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.15) )&& (i < Math.round((mangoptionsmatchs.size() * 0.3)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.3)) && (i <= Math.round((mangoptionsmatchs.size() * 0.6)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if ((i > Math.round((mangoptionsmatchs.size() * 0.6)))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				
				if (!(Mangoptionsmatchxx.getScore1one().equals("弃权")&&Mangoptionsmatchxx.getScore1two().equals("弃权"))) {
					Mangoptionsmatchxx.setRank(i);
					i++;
				}
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 12) {
			for (Mangoptionsmatch mangoptionsmatch12 : mangoptionsmatchs) {
				double firstFly = 0.0;
				double firstCross = 0.0;
				double firstcirInAir = 0.0;
				double firstCrossCir = 0.0;
				double firstcirOnAir = 0.0;
				double firstCrossload = 0.0;
				double firstloading = 0.0;
				try {
					firstFly = Double.parseDouble(mangoptionsmatch12.getScore1one());
				} catch (Exception e) {
				}
				try {
					firstCross = Double.parseDouble(mangoptionsmatch12.getScore2one());
				} catch (Exception e) {
				}
				try {
					firstcirInAir = Double.parseDouble(mangoptionsmatch12.getScore3one());
				} catch (Exception e) {
				}
				try {
					firstCrossCir = Double.parseDouble(mangoptionsmatch12.getScore4one());
				} catch (Exception e) {
				}
				try {
					firstcirOnAir = Double.parseDouble(mangoptionsmatch12.getScore5one());
				} catch (Exception e) {
				}
				try {
					firstCrossload = Double.parseDouble(mangoptionsmatch12.getScore6one());
				} catch (Exception e) {
				}
				try {
					firstloading = Double.parseDouble(mangoptionsmatch12.getScore7one());
				} catch (Exception e) {
				}
				double secondFly = 0.0;
				double secondCross = 0.0;
				double secondcirInAir = 0.0;
				double secondCrossCir = 0.0;
				double secondcirOnAir = 0.0;
				double secondCrossload = 0.0;
				double secondloading = 0.0;
				try {
					secondFly = Double.parseDouble(mangoptionsmatch12.getScore1two());
				} catch (Exception e) {
				}
				try {
					secondCross = Double.parseDouble(mangoptionsmatch12.getScore2two());
				} catch (Exception e) {
			}
				try {
					secondcirInAir = Double.parseDouble(mangoptionsmatch12.getScore3two());
				} catch (Exception e) {
				}
				try {
					secondCrossCir = Double.parseDouble(mangoptionsmatch12.getScore4two());
				} catch (Exception e) {
				}
				try {
					secondcirOnAir = Double.parseDouble(mangoptionsmatch12.getScore5two());
				} catch (Exception e) {
				}
				try {
					secondCrossload = Double.parseDouble(mangoptionsmatch12.getScore6two());
				} catch (Exception e) {
				}
				try {
					secondloading = Double.parseDouble(mangoptionsmatch12.getScore7two());
				} catch (Exception e) {
				}
				double firstScore = 0.0;
				double secondScore = 0.0;
				double finalScore = 0.0;
				firstScore = Arith.add(firstFly, firstCross);
				firstScore = Arith.add(firstScore, firstcirInAir);
				firstScore = Arith.add(firstScore, firstCrossCir);
				firstScore = Arith.add(firstScore, firstcirOnAir);
				firstScore = Arith.add(firstScore, firstCrossload);
				firstScore = Arith.add(firstScore, firstloading);
				secondScore = Arith.add(secondFly, secondCross);
				secondScore = Arith.add(secondScore, secondcirInAir);
				secondScore = Arith.add(secondScore, secondCrossCir);
				secondScore = Arith.add(secondScore, secondcirOnAir);
				secondScore = Arith.add(secondScore, secondCrossload);
				secondScore = Arith.add(secondScore, secondloading);
				finalScore = Arith.add(firstScore, secondScore);
				mangoptionsmatch12.setScoreonebytranslate(firstScore);
				mangoptionsmatch12.setScoretwobytranslate(secondScore);
				mangoptionsmatch12.setScorefinalone(Double.toString(firstScore));
				mangoptionsmatch12.setScorefinaltwo(Double.toString(secondScore));
				mangoptionsmatch12.setScorefinal(Double.toString(finalScore));
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch12);
			}
			Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.round((mangoptionsmatchs.size() * 0.15)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.15)) &&( i < Math.round((mangoptionsmatchs.size() * 0.3)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.3)) && (i <= Math.round((mangoptionsmatchs.size() * 0.6)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.round((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				if (!(Mangoptionsmatchxx.getScore1one().equals("弃权")&&Mangoptionsmatchxx.getScore1two().equals("弃权"))) {
					Mangoptionsmatchxx.setRank(i);
					i++;
				}
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;
		} else if (mangoptionsmatch.getJoinlist() == 13) {
			for (Mangoptionsmatch mangoptionsmatch13 : mangoptionsmatchs) {
				double firstHelpScore = 0.0;
				double firstloading = 0.0;
				double secondHelpScore = 0.0;
				double secondloading = 0.0;
				double firstScore = 0.0;
				double secondScore = 0.0;
				double finalScore = 0.0;
				try {
					firstHelpScore = Double.parseDouble(mangoptionsmatch13.getScore1one());
				} catch (Exception e) {

				}
				try {
					firstloading = Double.parseDouble(mangoptionsmatch13.getScore2one());
				} catch (Exception e) {

				}
				try {
					secondHelpScore = Double.parseDouble(mangoptionsmatch13.getScore1two());
				} catch (Exception e) {

				}
				try {
					secondloading = Double.parseDouble(mangoptionsmatch13.getScore2two());
				} catch (Exception e) {

				}

				firstScore = Arith.add(firstHelpScore, firstloading);
				secondScore = Arith.add(secondHelpScore, secondloading);
				finalScore = Arith.add(firstScore, secondScore);

				mangoptionsmatch13.setScoreonebytranslate(firstScore);
				mangoptionsmatch13.setScoretwobytranslate(secondScore);
				mangoptionsmatch13.setScorefinalone(Double.toString(firstScore));
				mangoptionsmatch13.setScorefinaltwo(Double.toString(secondScore));

				mangoptionsmatch13.setScorefinal(Double.toString(finalScore));
				mangoptionsmatchService.updateByPrimaryKeySelective(mangoptionsmatch13);

			}	Collections.sort(mangoptionsmatchs);
			int i = 1;
			for (Mangoptionsmatch Mangoptionsmatchxx : mangoptionsmatchs) {
				if (mangoptionsmatchs.size() >= 8) {
					if ((i <= Math.round((mangoptionsmatchs.size() * 0.15)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("一等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.15)) && (i < Math.round((mangoptionsmatchs.size() * 0.3)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("二等奖");
					} else if ((i > (mangoptionsmatchs.size() * 0.3)) && (i <= Math.round((mangoptionsmatchs.size() * 0.6)))&&(Mangoptionsmatchxx.getScorefinal() !="0.0")) {
						Mangoptionsmatchxx.setReward("三等奖");
					} else if (i > Math.round((mangoptionsmatchs.size() * 0.6))) {
						Mangoptionsmatchxx.setReward("");
					}
				}
				if (!(Mangoptionsmatchxx.getScore1one().equals("弃权")&&Mangoptionsmatchxx.getScore1two().equals("弃权"))) {
					Mangoptionsmatchxx.setRank(i);
					i++;
				}
				mangoptionsmatchService.updateByPrimaryKeySelective(Mangoptionsmatchxx);
			}
			mangoptionsmatchs = mangoptionsmatchService.findWhoJoinThisMatchThisListAndHasConfirm(mangoptionsmatch.getJoinmatch(),
					mangoptionsmatch.getJoinlist(), mangoptionsmatch.getJoingage());
			return mangoptionsmatchs;

		} else if (mangoptionsmatch.getJoinlist() == 14) {
			for (Mangoptionsmatch mangoptionsmatch14 : mangoptionsmatchs) {

			}

		}

		return null;

	}
	public List<Turnmatchlist> sort(Turnmatchlist turnmatchlist){
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&"+"=="+turnmatchlist.getJoinlist());
		List<Turnmatchlist> turnmatchlists=turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(), turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
		System.out.println(turnmatchlists.size());
		System.out.println("turnmatchlist.getJoinlist()==17 || turnmatchlist.getJoinlist()==18"+"===="+(turnmatchlist.getJoinlist()==17 || turnmatchlist.getJoinlist()==18));
		if (turnmatchlist.getJoinlist()==17 || turnmatchlist.getJoinlist()==18) {
			/*
			 *  F3K F3K-U12
			 */
			System.out.println("此条显示说明运行1");
			for (Turnmatchlist turnmatchlist17 : turnmatchlists) {
				System.out.println("此条显示说明运行2");
				double firstfly = 0;
				double secondfly = 0;
				double thirdfly = 0;
				double finalfly = 0;
				
				try {
					firstfly=Double.parseDouble(turnmatchlist17.getOneturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				try {
					secondfly=Double.parseDouble(turnmatchlist17.getOneturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					thirdfly=Double.parseDouble(turnmatchlist17.getOneturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					finalfly=Double.parseDouble(turnmatchlist17.getTwoturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				System.out.println("此条显示说明运行3");
				double firstScore=0.0;
				double secondScore=finalfly;
				firstScore=Arith.add(firstfly, secondfly);
				firstScore=Arith.add(firstScore, thirdfly);
				System.out.println("==================F3K"+firstfly+"+"+secondfly+"+"+thirdfly);
				System.out.println(firstScore);
				turnmatchlist17.setOneturnscore(Double.toString(firstScore));
				turnmatchlist17.setTwoturnscore(Double.toString(secondScore));//两轮原始分录入完毕
				System.out.println(secondScore);
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlist17);
				
			}
			System.out.println("此条显示说明运行4");
			/*
			 * 根据第一轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclac(turnmatchlists);
			/*
			 * 根据第2轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclacinTwo(turnmatchlists);
			/*
			 * 总换算分排序
			 */
			System.out.println("此条显示说明运行5");
				Collections.sort(turnmatchlists);
			int i = 1;
			for (Turnmatchlist turnmatchlistxx : turnmatchlists) {
				if (turnmatchlists.size() >= 8) {
					if ((i <= Math.round((turnmatchlists.size() * 0.15)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("一等奖");
					} else if ((i > (turnmatchlists.size() * 0.15) )&& (i < Math.round((turnmatchlists.size() * 0.3)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("二等奖");
					} else if ((i > (turnmatchlists.size() * 0.3)) && (i <= Math.round((turnmatchlists.size() * 0.6)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("三等奖");
					} else if (i > Math.round((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("");
					}
				}
				if (!(turnmatchlistxx.getOneturnpointmeter().equals("弃权")||turnmatchlistxx.getTwoturnpointmeter().equals("弃权"))) {
					turnmatchlistxx.setRankfinal(i);
					i++;
				}
//				turnmatchlistxx.setRankfinal(i);
//				i++;
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlistxx);
			}
			turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(),
					turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
			System.out.println("此条显示说明运行6");
			return turnmatchlists;
			
			
		}else if(turnmatchlist.getJoinlist()==23){
			for (Turnmatchlist turnmatchlist23 : turnmatchlists) {
				/*
				 * S8C
				 */
				double firstSkyTime=0.0;
				double firstLoading=0.0;
				double secondSkyTime=0.0;
				double secondLoading=0.0;
				
				try {
					firstLoading=Double.parseDouble(turnmatchlist23.getOneturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					firstSkyTime=Double.parseDouble(turnmatchlist23.getOneturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondSkyTime=Double.parseDouble(turnmatchlist23.getTwoturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondLoading=Double.parseDouble(turnmatchlist23.getTwoturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				
				double oneturnscore=0.0;
				double twoturnscore=0.0;
				
				oneturnscore=Arith.add(firstLoading*0.25,firstSkyTime*0.75 );
				twoturnscore=Arith.add(secondLoading*0.25, secondSkyTime*0.75);
				
				turnmatchlist23.setOneturnscore(Double.toString(oneturnscore));
				turnmatchlist23.setTwoturnscore(Double.toString(twoturnscore));
				
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlist23);
				
			}
			
			/*
			 * 根据第一轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclac(turnmatchlists);
			/*
			 * 根据第2轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclacinTwo(turnmatchlists);
			/*
			 * 总换算分排序
			 */
			
				Collections.sort(turnmatchlists);
			int i = 1;
			for (Turnmatchlist turnmatchlistxx : turnmatchlists) {
				if (turnmatchlists.size() >= 8) {
					if ((i <= Math.round((turnmatchlists.size() * 0.15)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("一等奖");
					} else if ((i > (turnmatchlists.size() * 0.15)) && (i < Math.round((turnmatchlists.size() * 0.3)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("二等奖");
					} else if ((i > (turnmatchlists.size() * 0.3)) && (i <= Math.round((turnmatchlists.size() * 0.6)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("三等奖");
					} else if (i > Math.round((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("");
					}
				}
				if (!(turnmatchlistxx.getOneturnpointmeter().equals("弃权")||turnmatchlistxx.getTwoturnpointmeter().equals("弃权"))) {
					turnmatchlistxx.setRankfinal(i);
					i++;
				}
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlistxx);
			}
			turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(),
					turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
			return turnmatchlists;
		}else if(turnmatchlist.getJoinlist()==26 ||turnmatchlist.getJoinlist()==27|turnmatchlist.getJoinlist()==29||turnmatchlist.getJoinlist()==31){
			for (Turnmatchlist turnmatchlist26 : turnmatchlists) {
				double firstSkyTime=0.0;
				double firstPointMeter=0.0;
				double firstPowertime=0.0;
				double firstScore=0.0;
				double secondSkyTime=0.0;
				double secondPointMeter=0.0;
				double secondPowertime=0.0;
				double secondScore=0.0;
				try {
					firstSkyTime=Double.parseDouble(turnmatchlist26.getOneturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					firstPointMeter=Double.parseDouble(turnmatchlist26.getOneturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					firstPowertime=Double.parseDouble(turnmatchlist26.getOneturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondSkyTime=Double.parseDouble(turnmatchlist26.getTwoturnskytime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondPointMeter=Double.parseDouble(turnmatchlist26.getTwoturnpointmeter());
				} catch (Exception e) {
					// TODO: handle exception
				}
				try {
					secondPowertime=Double.parseDouble(turnmatchlist26.getTwoturnpowertime());
				} catch (Exception e) {
					// TODO: handle exception
				}
				if (turnmatchlist.getJoinlist()==26) {
				double firstPointMeterScore =100-4*firstPointMeter;//定点着陆分
				double secondPointMeterScore=100-4*secondPointMeter;
					if (firstPointMeterScore<0 ||firstPointMeter>50) {
						firstPointMeterScore=0;
					}
					if(secondPointMeterScore<0 ||secondPointMeter>50){
						secondPointMeterScore=0;
					}
				double firstSkyTimeScore=	firstSkyTime;
				
				if (firstSkyTime>180 &&firstSkyTime<=210) {
					firstSkyTimeScore=180-(firstSkyTime-180);
				}else if(firstSkyTime<=180 &&firstSkyTime>=30){
					 firstSkyTimeScore=	firstSkyTime;
				}else if(firstSkyTime<30 ||firstSkyTime>210){
					 firstSkyTimeScore=	0;
				}
					firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
					double secondSkyTimeScore=	secondSkyTime;
					
					if (secondSkyTime>180 &&secondSkyTime<=210) {
						secondSkyTimeScore=180-(secondSkyTime-180);
					}else if(secondSkyTime<=180 &&secondSkyTime>=30){
						 secondSkyTimeScore=	secondSkyTime;
					}else if(secondSkyTime<30 ||secondSkyTime>210){
						 secondSkyTimeScore=	0;
					}
						secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);	
				}else if(turnmatchlist.getJoinlist()==27){
					double firstPointMeterScore =100-4*firstPointMeter;//定点着陆分
					double secondPointMeterScore=100-4*secondPointMeter;
						if (firstPointMeterScore<0 ||firstPointMeter>50) {
							firstPointMeterScore=0;
						}
						if(secondPointMeterScore<0 ||secondPointMeter>50){
							secondPointMeterScore=0;
						}
					double firstSkyTimeScore=	firstSkyTime;
					
					if (firstSkyTime>120 &&firstSkyTime<=150) {
						firstSkyTimeScore=120-(firstSkyTime-120);
					}else if(firstSkyTime<=120 &&firstSkyTime>=30){
						 firstSkyTimeScore=	firstSkyTime;
					}else if(firstSkyTime<30 ||firstSkyTime>150){
						 firstSkyTimeScore=	0;
					}
						firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
						double secondSkyTimeScore=	secondSkyTime;
						
						if (secondSkyTime>120 &&secondSkyTime<=150) {
							secondSkyTimeScore=120-(secondSkyTime-120);
						}else if(secondSkyTime<=120 &&secondSkyTime>=30){
							 secondSkyTimeScore=	secondSkyTime;
						}else if(secondSkyTime<30 ||secondSkyTime>150){
							 secondSkyTimeScore=	0;
						}
							secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);	
					
					
				}else if(turnmatchlist.getJoinlist()==29){
					
					double firstPointMeterScore =100-4*firstPointMeter;//定点着陆分
					double secondPointMeterScore=100-4*secondPointMeter;
					double firstPowerTimeScore=firstPowertime;
					double secondPowerTimeScore=secondPowertime;
					if (firstPointMeterScore<0 ||firstPointMeter>50 ||firstPointMeter==0) {
						firstPointMeterScore=0;
					}
					if (secondPointMeterScore<0 ||secondPointMeter>50||secondPointMeter==0) {
						secondPointMeterScore=0;
					}
					double firstSkyTimeScore=	firstSkyTime;
					if (firstSkyTime>300 && firstSkyTime<=330) {
						firstSkyTimeScore=300-(firstSkyTime-300);
					}else if(firstSkyTime <= 300 && firstSkyTime >= 30){
						firstSkyTimeScore=firstSkyTime;
					}else if(firstSkyTime < 30 || firstSkyTime > 330){
						firstSkyTimeScore=0;
					}
					firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
					firstScore=Arith.sub(firstScore, firstPowerTimeScore);
					double secondSkyTimeScore=	secondSkyTime;
					if (secondSkyTime>300 && secondSkyTime<=330) {
						secondSkyTimeScore=300-(secondSkyTime-300);
					}else if(secondSkyTime <= 300 && secondSkyTime >= 30){
						secondSkyTimeScore=secondSkyTime;
					}else if(secondSkyTime < 30 || secondSkyTime > 330){
						secondSkyTimeScore=0;
					}
					secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);
					secondScore=Arith.sub(secondScore, secondPowerTimeScore);
				}else if(turnmatchlist.getJoinlist()==31){
					double firstPointMeterScore =100-(firstPointMeter/10);//定点着陆分
					double secondPointMeterScore=100-(secondPointMeter/10);	
					if (firstPointMeterScore<0) {
						firstPointMeterScore=0;
					}
					if (secondPointMeterScore<0) {
						secondPointMeterScore=0;
					}
					double firstSkyTimeScore=	firstSkyTime;
					if (firstSkyTime > 360 && firstSkyTime <= 390) {
						firstSkyTimeScore=360-(firstSkyTime-360);
					}else if(firstSkyTime<=360){
						firstSkyTimeScore=firstSkyTime;
					}else if(firstSkyTime>390){
						firstSkyTimeScore=0;
					}
					firstScore=Arith.add(firstPointMeterScore, firstSkyTimeScore);
					double secondSkyTimeScore=	secondSkyTime;
					if (secondSkyTime > 360 && secondSkyTime <= 390) {
						secondSkyTimeScore=360-(secondSkyTime-360);
					}else if(secondSkyTime<=360){
						secondSkyTimeScore=secondSkyTime;
					}else if(secondSkyTime>390){
						secondSkyTimeScore=0;
					}
					secondScore=Arith.add(secondPointMeterScore, secondSkyTimeScore);
				}
				
			turnmatchlist26.setOneturnscore(Double.toString(firstScore));
			turnmatchlist26.setTwoturnscore(Double.toString(secondScore));
			}
			/*
			 * 根据第一轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclac(turnmatchlists);
			/*
			 * 根据第2轮原始分排序并录入换算分
			 */
			turnmatchlists=	sortTurnmatchlistclacinTwo(turnmatchlists);
			/*
			 * 总换算分排序
			 */
			
				Collections.sort(turnmatchlists);
			int i = 1;
			for (Turnmatchlist turnmatchlistxx : turnmatchlists) {
				if (turnmatchlists.size() >= 8) {
					if ((i <= Math.round((turnmatchlists.size() * 0.15)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("一等奖");
					} else if ((i > (turnmatchlists.size() * 0.15)) &&( i < Math.round((turnmatchlists.size() * 0.3)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("二等奖");
					} else if ((i > (turnmatchlists.size() * 0.3) )&&( i <= Math.round((turnmatchlists.size() * 0.6)))&&(turnmatchlistxx.getFinalscore()!="0.0")) {
						turnmatchlistxx.setReward("三等奖");
					} else if (i > Math.round((turnmatchlists.size() * 0.6))) {
						turnmatchlistxx.setReward("");
					}
				}
				if (!(turnmatchlistxx.getOneturnpointmeter().equals("弃权")||turnmatchlistxx.getTwoturnpointmeter().equals("弃权"))) {
					turnmatchlistxx.setRankfinal(i);
					i++;
				}
				turnMatchListService.updateByPrimaryKeySelective(turnmatchlistxx);
			}
			turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(turnmatchlist.getJoinmatch(),
					turnmatchlist.getJoinlist(), turnmatchlist.getJoingage());
			return turnmatchlists;
			
		}
		
		
		
		return null;
	}
	
	
	public List<Turnmatchlist> sortTurnmatchlistclac(List<Turnmatchlist> list) {
		Collections.sort(list, new Comparator<Turnmatchlist>() {

			@Override
			public int compare(Turnmatchlist o1, Turnmatchlist o2) {
				double firstRoundScore1 = Double.parseDouble(o1.getOneturnscore());
				double firstRoundScore2 = Double.parseDouble(o2.getOneturnscore());
				double result=firstRoundScore2-firstRoundScore1;
			
			return (int) Math.round(result);

			}
		});
		
		int i = 1;
		double bestyuanshifen=0;
		for (Turnmatchlist turnmatchlist : list) {
			if (i==1) {
				
				bestyuanshifen=Double.parseDouble(turnmatchlist.getOneturnscore());
				turnmatchlist.setScoreinoneturnhascalc(1000.0);
				System.out.println("最好成绩"+bestyuanshifen);
			}
			double myclacScore=0;
			if (bestyuanshifen!=0) {
				myclacScore=Arith.div(Double.parseDouble(turnmatchlist.getOneturnscore()), bestyuanshifen)*1000;
			}
			
			turnmatchlist.setScoreinoneturnhascalc(myclacScore);
			turnmatchlist.setRank1(i);
			turnMatchListService.updateByPrimaryKeySelective(turnmatchlist);
			
			i++;
		}		
		return list;
		
	}
	
	public List<Turnmatchlist> sortTurnmatchlistclacinTwo(List<Turnmatchlist> list) {
		Collections.sort(list, new Comparator<Turnmatchlist>() {
			@Override
			public int compare(Turnmatchlist o1, Turnmatchlist o2) {
				double secondRoundScore1 = Double.parseDouble(o1.getTwoturnscore());
				double secondRoundScore2 = Double.parseDouble(o2.getTwoturnscore());
				double result=secondRoundScore2-secondRoundScore1;
			
			return (int) Math.round(result);

			}
		});
		
		int i = 1;
		double bestyuanshifen=0;
		for (Turnmatchlist turnmatchlist : list) {
			if (i==1) {
				
				bestyuanshifen=Double.parseDouble(turnmatchlist.getTwoturnscore());
				turnmatchlist.setScoreintwoturnhascalc(1000.0);
			}
			double myclacScore=0;
			if(bestyuanshifen!=0){
				myclacScore=Arith.div(Double.parseDouble(turnmatchlist.getTwoturnscore()), bestyuanshifen)*1000;
			}
			
			turnmatchlist.setScoreintwoturnhascalc(myclacScore);
			turnmatchlist.setRank2(i);
			DecimalFormat df = new DecimalFormat("#.00");
            System.out.println();
			;
			double finalScore=Arith.add(Double.parseDouble(df.format( turnmatchlist.getScoreinoneturnhascalc().doubleValue())),Double.parseDouble(df.format( turnmatchlist.getScoreintwoturnhascalc().doubleValue())) );
			System.out.println("第一轮换算分："+turnmatchlist.getScoreinoneturnhascalc());
			System.out.println("第二轮换算分："+turnmatchlist.getScoreintwoturnhascalc());
			turnmatchlist.setFinalscore(Double.toString(finalScore));
			System.out.println("两轮打完，总成绩是："+turnmatchlist.getFinalscore());
			turnMatchListService.updateByPrimaryKeySelective(turnmatchlist);
			
			i++;
		}		
		return list;
		
	}
	public List<Withfriendmatch> sort(Withfriendmatch withfriendmatch){
		List<Withfriendmatch>  withfriendmatchs=withfriendmatchService.findWhoJoinThisMatchThisListAndHasConfirm(withfriendmatch.getJoinmatch(), withfriendmatch.getJoinlist(), withfriendmatch.getJoingagae());
		List<Withfriendmatch> withfriendmatchsneedTosort=new ArrayList<Withfriendmatch>();
		String tempFriendId=null;
		//int i=0;
		for (Withfriendmatch withfriendmatch2 : withfriendmatchs) {
			if (!(withfriendmatch2.getMyteamfriend().equals(tempFriendId))) {
				withfriendmatchsneedTosort.add(withfriendmatch2);
			}
			tempFriendId=withfriendmatch2.getMyteamfriend();
		}
		for (Withfriendmatch withfriendmatch2 : withfriendmatchs) {
			String score1string = withfriendmatch2.getScoreone();
			String score2string = withfriendmatch2.getScoretwo();
			String[] score1old = null;
			String[] score2old = null;
			double score1 = 0;
			double score2 = 0;
			double score11 = 0;
			double score12 = 0;

			if (score1string.contains("+")) {
				score1old = score1string.split("\\+");
				if (score1old[1].endsWith("a") || score1old[1].endsWith("A") || score1old[1].endsWith("B")
						|| score1old[1].endsWith("b") || score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
					if (score1old[1].endsWith("a") || score1old[1].endsWith("A")) {
						score11 = 0.1;

					} else if (score1old[1].endsWith("B") || score1old[1].endsWith("b")) {
						score11 = 0.2;
					} else if (score1old[1].endsWith("c") || score1old[1].endsWith("C")) {
						score11 = 0.3;
					}

					score1 = Double.parseDouble(score1old[0]) + score11;
		
				}
			} else if (!score1string.contains("+")) {

				try {
					score1 = Double.parseDouble(score1string);
				} catch (Exception e) {
					score1=0;
				}
				

			}
			withfriendmatch2.setScoreonebytranslate(score1);
			if (score2string.contains("+")) {
				score2old = score2string.split("\\+");
				if (score2old[1].endsWith("a") || score2old[1].endsWith("A") || score2old[1].endsWith("B")
						|| score2old[1].endsWith("b") || score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
					if (score2old[1].endsWith("a") || score2old[1].endsWith("A")) {
						score12 = 0.1;

					} else if (score2old[1].endsWith("B") || score2old[1].endsWith("b")) {
						score12 = 0.2;
					} else if (score2old[1].endsWith("c") || score2old[1].endsWith("C")) {
						score12 = 0.3;
					}

					score2 = Double.parseDouble(score2old[0]) + score12;
				}
			} else if (!score2string.contains("+")) {
				try {
					score2 = Double.parseDouble(score2string);
				} catch (Exception e) {
					score2=0;
				}
				

			}
			withfriendmatch2.setScoretwobytranslate(score2);
			
			withfriendmatch2.setFinalscore(Double.toString(Arith.add(score1,score2)));
			withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch2);
			
		}
		Collections.sort(withfriendmatchsneedTosort);
		int i = 1;
		for (Withfriendmatch withfriendmatch2 : withfriendmatchsneedTosort) {
			if (withfriendmatchs.size() >= 8) {
				if ((i <= Math.ceil((withfriendmatchs.size() * 0.15)))&&(withfriendmatch.getFinalscore()!="0.0")) {
					withfriendmatch2.setReward("一等奖");
				} else if (i > (withfriendmatchs.size() * 0.15) && i < Math.ceil((withfriendmatchs.size() * 0.3))&&(withfriendmatch.getFinalscore()!="0.0")) {
					withfriendmatch2.setReward("二等奖");
				} else if (i > (withfriendmatchs.size() * 0.3) && i <= Math.ceil((withfriendmatchs.size() * 0.6))&&(withfriendmatch.getFinalscore()!="0.0")) {
					withfriendmatch2.setReward("三等奖");
				} else if (i > Math.ceil((withfriendmatchs.size() * 0.6))) {
					withfriendmatch2.setReward("");
				}
			}
			if(!(withfriendmatch2.getScoreone().equals("弃权")&&withfriendmatch2.getScoretwo().equals("弃权"))){
				
				withfriendmatch2.setRank(i);
				i++;
			}
			
			withfriendmatchService.updateByPrimaryKeySelective(withfriendmatch2);
		}
		withfriendmatchs = withfriendmatchService.findWhoJoinThisMatchThisListAndHasConfirm(withfriendmatch.getJoinmatch(),
				withfriendmatch.getJoinlist(), withfriendmatch.getJoingagae());
		return withfriendmatchs;
	}
	public List<Manyrifmatch> sort(Manyrifmatch manyrifmatch){
		List<Manyrifmatch> manyrifmatchs=manyrifmatchService.findWhoJoinThisMatchThisListAndHasConfirm(manyrifmatch.getJoinmatch(), manyrifmatch.getJoinlist(), manyrifmatch.getJoingage());
	for (Manyrifmatch manyrifmatch2 : manyrifmatchs) {
		double score1one1rid=0;
		try {
			score1one1rid=Double.parseDouble(manyrifmatch2.getScore1one1rid());
		} catch (Exception e) {
			score1one1rid=0.0;
		}
		double score2one1rid=0;
		try {
			score2one1rid=Double.parseDouble(manyrifmatch2.getScore2one1rid());
		} catch (Exception e) {
			score2one1rid=0.0;
		}
		double score3one1rid=0;
		try {
			score3one1rid=Double.parseDouble(manyrifmatch2.getScore3one1rid());
		} catch (Exception e) {
			score3one1rid=0.0;
		}
		double score4one1rid=0;
		try {
			score4one1rid=Double.parseDouble(manyrifmatch2.getScore4one1rid());
		} catch (Exception e) {
			score4one1rid=0;
		}
		double score5one1rid=0;
		try {
			score5one1rid=Double.parseDouble(manyrifmatch2.getScore5one1rid());
		} catch (Exception e) {
			score5one1rid=0;
		}
		double score6one1rid=0;
		try {
			score6one1rid=Double.parseDouble(manyrifmatch2.getScore6one1rid());
		} catch (Exception e) {
			score6one1rid=0;
		}
		double score7one1rid=0;
		try {
			score7one1rid=Double.parseDouble(manyrifmatch2.getScore7one1rid());
		} catch (Exception e) {
			score7one1rid=0;
		}
		double score8one1rid=0;
		try {
			score8one1rid=Double.parseDouble(manyrifmatch2.getScore8one1rid());
		} catch (Exception e) {
			score8one1rid=0;
		}
		double score9one1rid=0;
		try {
			score9one1rid=Double.parseDouble(manyrifmatch2.getScore9one1rid());
		} catch (Exception e) {
			score9one1rid=0;
		}
		double score10one1rid=0;
		try {
			score10one1rid=Double.parseDouble(manyrifmatch2.getScore10one1rid());
		} catch (Exception e) {
			score10one1rid=0;
		}
		double score11one1rid=0;
		try {
			score11one1rid=Double.parseDouble(manyrifmatch2.getScore11one1rid());
		} catch (Exception e) {
			score11one1rid=0;
		}
		double score12one1rid=0;
		try {
			score12one1rid=Double.parseDouble(manyrifmatch2.getScore12one1rid());
		} catch (Exception e) {
			score12one1rid=0;
		}
		double score13one1rid=0;
		try {
			score13one1rid=Double.parseDouble(manyrifmatch2.getScore13on1erid());
		} catch (Exception e) {
			score13one1rid=0;
		}
		double score14one1rid=0;
		try {
			score14one1rid=Double.parseDouble(manyrifmatch2.getScore14one1rid());
		} catch (Exception e) {
			score14one1rid=0;
		}
		double score15one1rid=0;
		try {
			score15one1rid=Double.parseDouble(manyrifmatch2.getScore15one1rid());
		} catch (Exception e) {
			score15one1rid=0;
		}
		double score16one1rid=0;
		try {
			score16one1rid=Double.parseDouble(manyrifmatch2.getScore16one1rid());
		} catch (Exception e) {
			score16one1rid=0;
		}
		double score1one2rid=0;
		try {
			score1one2rid=Double.parseDouble(manyrifmatch2.getScore1one2rid());
		} catch (Exception e) {
			score1one2rid=0.0;
		}
		double score2one2rid=0;
		try {
			score2one2rid=Double.parseDouble(manyrifmatch2.getScore2one2rid());
		} catch (Exception e) {
			score2one2rid=0.0;
		}
		double score3one2rid=0;
		try {
			score3one2rid=Double.parseDouble(manyrifmatch2.getScore3one2rid());
		} catch (Exception e) {
			score3one2rid=0.0;
		}
		double score4one2rid=0;
		try {
			score4one2rid=Double.parseDouble(manyrifmatch2.getScore4one2rid());
		} catch (Exception e) {
			score4one2rid=0;
		}
		double score5one2rid=0;
		try {
			score5one2rid=Double.parseDouble(manyrifmatch2.getScore5one2rid());
		} catch (Exception e) {
			score5one2rid=0;
		}
		double score6one2rid=0;
		try {
			score6one2rid=Double.parseDouble(manyrifmatch2.getScore6one2rid());
		} catch (Exception e) {
			score6one2rid=0;
		}
		double score7one2rid=0;
		try {
			score7one2rid=Double.parseDouble(manyrifmatch2.getScore7one2rid());
		} catch (Exception e) {
			score7one2rid=0;
		}
		double score8one2rid=0;
		try {
			score8one2rid=Double.parseDouble(manyrifmatch2.getScore8one2rid());
		} catch (Exception e) {
			score8one2rid=0;
		}
		double score9one2rid=0;
		try {
			score9one2rid=Double.parseDouble(manyrifmatch2.getScore9one2rid());
		} catch (Exception e) {
			score9one2rid=0;
		}
		double score10one2rid=0;
		try {
			score10one2rid=Double.parseDouble(manyrifmatch2.getScore10one2rid());
		} catch (Exception e) {
			score10one2rid=0;
		}
		double score11one2rid=0;
		try {
			score11one2rid=Double.parseDouble(manyrifmatch2.getScore11one2rid());
		} catch (Exception e) {
			score11one2rid=0;
		}
		double score12one2rid=0;
		try {
			score12one2rid=Double.parseDouble(manyrifmatch2.getScore12one2rid());
		} catch (Exception e) {
			score12one2rid=0;
		}
		double score13one2rid=0;
		try {
			score13one2rid=Double.parseDouble(manyrifmatch2.getScore13one2rid());
		} catch (Exception e) {
			score13one2rid=0;
		}
		double score14one2rid=0;
		try {
			score14one2rid=Double.parseDouble(manyrifmatch2.getScore14one2rid());
		} catch (Exception e) {
			score14one2rid=0;
		}
		double score15one2rid=0;
		try {
			score15one2rid=Double.parseDouble(manyrifmatch2.getScore15one2rid());
		} catch (Exception e) {
			score15one2rid=0;
		}
		double score16one2rid=0;
		try {
			score16one2rid=Double.parseDouble(manyrifmatch2.getScore16one2rid());
		} catch (Exception e) {
			score16one2rid=0;
		}
		double score1one3rid=0;
		try {
			score1one3rid=Double.parseDouble(manyrifmatch2.getScore1one3rid());
		} catch (Exception e) {
			score1one3rid=0.0;
		}
		double score2one3rid=0;
		try {
			score2one3rid=Double.parseDouble(manyrifmatch2.getScore2one3rid());
		} catch (Exception e) {
			score2one3rid=0.0;
		}
		double score3one3rid=0;
		try {
			score3one3rid=Double.parseDouble(manyrifmatch2.getScore3one3rid());
		} catch (Exception e) {
			score3one3rid=0.0;
		}
		double score4one3rid=0;
		try {
			score4one3rid=Double.parseDouble(manyrifmatch2.getScore4one3rid());
		} catch (Exception e) {
			score4one3rid=0;
		}
		double score5one3rid=0;
		try {
			score5one3rid=Double.parseDouble(manyrifmatch2.getScore5one3rid());
		} catch (Exception e) {
			score5one3rid=0;
		}
		double score6one3rid=0;
		try {
			score6one3rid=Double.parseDouble(manyrifmatch2.getScore6one3rid());
		} catch (Exception e) {
			score6one3rid=0;
		}
		double score7one3rid=0;
		try {
			score7one3rid=Double.parseDouble(manyrifmatch2.getScore7one3rid());
		} catch (Exception e) {
			score7one3rid=0;
		}
		double score8one3rid=0;
		try {
			score8one3rid=Double.parseDouble(manyrifmatch2.getScore8one3rid());
		} catch (Exception e) {
			score8one3rid=0;
		}
		double score9one3rid=0;
		try {
			score9one3rid=Double.parseDouble(manyrifmatch2.getScore9one3rid());
		} catch (Exception e) {
			score9one3rid=0;
		}
		double score10one3rid=0;
		try {
			score10one3rid=Double.parseDouble(manyrifmatch2.getScore10one3rid());
		} catch (Exception e) {
			score10one3rid=0;
		}
		double score11one3rid=0;
		try {
			score11one3rid=Double.parseDouble(manyrifmatch2.getScore11one3rid());
		} catch (Exception e) {
			score11one3rid=0;
		}
		double score12one3rid=0;
		try {
			score12one3rid=Double.parseDouble(manyrifmatch2.getScore12one3rid());
		} catch (Exception e) {
			score12one3rid=0;
		}
		double score13one3rid=0;
		try {
			score13one3rid=Double.parseDouble(manyrifmatch2.getScore13one3rid());
		} catch (Exception e) {
			score13one3rid=0;
		}
		double score14one3rid=0;
		try {
			score14one3rid=Double.parseDouble(manyrifmatch2.getScore14one3rid());
		} catch (Exception e) {
			score14one3rid=0;
		}
		double score15one3rid=0;
		try {
			score15one3rid=Double.parseDouble(manyrifmatch2.getScore15one3rid());
		} catch (Exception e) {
			score15one3rid=0;
		}
		double score16one3rid=0;
		try {
			score16one3rid=Double.parseDouble(manyrifmatch2.getScore16one3rid());
		} catch (Exception e) {
			score16one3rid=0;
		}
		double score1two1rid=0;
		try {
			score1two1rid=Double.parseDouble(manyrifmatch2.getScore1two1rid());
		} catch (Exception e) {
			score1two1rid=0.0;
		}
		double score2two1rid=0;
		try {
			score2two1rid=Double.parseDouble(manyrifmatch2.getScore2two1rid());
		} catch (Exception e) {
			score2two1rid=0.0;
		}
		double score3two1rid=0;
		try {
			score3two1rid=Double.parseDouble(manyrifmatch2.getScore3two1rid());
		} catch (Exception e) {
			score3two1rid=0.0;
		}
		double score4two1rid=0;
		try {
			score4two1rid=Double.parseDouble(manyrifmatch2.getScore4two1rid());
		} catch (Exception e) {
			score4two1rid=0;
		}
		double score5two1rid=0;
		try {
			score5two1rid=Double.parseDouble(manyrifmatch2.getScore5two1rid());
		} catch (Exception e) {
			score5two1rid=0;
		}
		double score6two1rid=0;
		try {
			score6two1rid=Double.parseDouble(manyrifmatch2.getScore6two1rid());
		} catch (Exception e) {
			score6two1rid=0;
		}
		double score7two1rid=0;
		try {
			score7two1rid=Double.parseDouble(manyrifmatch2.getScore7two1rid());
		} catch (Exception e) {
			score7two1rid=0;
		}
		double score8two1rid=0;
		try {
			score8two1rid=Double.parseDouble(manyrifmatch2.getScore8two1rid());
		} catch (Exception e) {
			score8two1rid=0;
		}
		double score9two1rid=0;
		try {
			score9two1rid=Double.parseDouble(manyrifmatch2.getScore9two1rid());
		} catch (Exception e) {
			score9two1rid=0;
		}
		double score10two1rid=0;
		try {
			score10two1rid=Double.parseDouble(manyrifmatch2.getScore10two1rid());
		} catch (Exception e) {
			score10two1rid=0;
		}
		double score11two1rid=0;
		try {
			score11two1rid=Double.parseDouble(manyrifmatch2.getScore11two1rid());
		} catch (Exception e) {
			score11two1rid=0;
		}
		double score12two1rid=0;
		try {
			score12two1rid=Double.parseDouble(manyrifmatch2.getScore12two1rid());
		} catch (Exception e) {
			score12two1rid=0;
		}
		double score13two1rid=0;
		try {
			score13two1rid=Double.parseDouble(manyrifmatch2.getScore13two1rid());
		} catch (Exception e) {
			score13two1rid=0;
		}
		double score14two1rid=0;
		try {
			score14two1rid=Double.parseDouble(manyrifmatch2.getScore14two1rid());
		} catch (Exception e) {
			score14two1rid=0;
		}
		double score15two1rid=0;
		try {
			score15two1rid=Double.parseDouble(manyrifmatch2.getScore15two1rid());
		} catch (Exception e) {
			score15two1rid=0;
		}
		double score16two1rid=0;
		try {
			score16two1rid=Double.parseDouble(manyrifmatch2.getScore16two1rid());
		} catch (Exception e) {
			score16two1rid=0;
		}
		double score1two2rid=0;
		try {
			score1two2rid=Double.parseDouble(manyrifmatch2.getScore1two2rid());
		} catch (Exception e) {
			score1two2rid=0.0;
		}
		double score2two2rid=0;
		try {
			score2two2rid=Double.parseDouble(manyrifmatch2.getScore2two2rid());
		} catch (Exception e) {
			score2two2rid=0.0;
		}
		double score3two2rid=0;
		try {
			score3two2rid=Double.parseDouble(manyrifmatch2.getScore3two2rid());
		} catch (Exception e) {
			score3two2rid=0.0;
		}
		double score4two2rid=0;
		try {
			score4two2rid=Double.parseDouble(manyrifmatch2.getScore4two2rid());
		} catch (Exception e) {
			score4two2rid=0;
		}
		double score5two2rid=0;
		try {
			score5two2rid=Double.parseDouble(manyrifmatch2.getScore5two2rid());
		} catch (Exception e) {
			score5two2rid=0;
		}
		double score6two2rid=0;
		try {
			score6two2rid=Double.parseDouble(manyrifmatch2.getScore6two2rid());
		} catch (Exception e) {
			score6two2rid=0;
		}
		double score7two2rid=0;
		try {
			score7two2rid=Double.parseDouble(manyrifmatch2.getScore7two2rid());
		} catch (Exception e) {
			score7two2rid=0;
		}
		double score8two2rid=0;
		try {
			score8two2rid=Double.parseDouble(manyrifmatch2.getScore8two2rid());
		} catch (Exception e) {
			score8two2rid=0;
		}
		double score9two2rid=0;
		try {
			score9two2rid=Double.parseDouble(manyrifmatch2.getScore9two2rid());
		} catch (Exception e) {
			score9two2rid=0;
		}
		double score10two2rid=0;
		try {
			score10two2rid=Double.parseDouble(manyrifmatch2.getScore10two2rid());
		} catch (Exception e) {
			score10two2rid=0;
		}
		double score11two2rid=0;
		try {
			score11two2rid=Double.parseDouble(manyrifmatch2.getScore11two2rid());
		} catch (Exception e) {
			score11two2rid=0;
		}
		double score12two2rid=0;
		try {
			score12two2rid=Double.parseDouble(manyrifmatch2.getScore12two2rid());
		} catch (Exception e) {
			score12two2rid=0;
		}
		double score13two2rid=0;
		try {
			score13two2rid=Double.parseDouble(manyrifmatch2.getScore13two2rid());
		} catch (Exception e) {
			score13two2rid=0;
		}
		double score14two2rid=0;
		try {
			score14two2rid=Double.parseDouble(manyrifmatch2.getScore14two2rid());
		} catch (Exception e) {
			score14two2rid=0;
		}
		double score15two2rid=0;
		try {
			score15two2rid=Double.parseDouble(manyrifmatch2.getScore15two2rid());
		} catch (Exception e) {
			score15two2rid=0;
		}
		double score16two2rid=0;
		try {
			score16two2rid=Double.parseDouble(manyrifmatch2.getScore16two2rid());
		} catch (Exception e) {
			score16two2rid=0;
		}
		double score1two3rid=0;
		try {
			score1two3rid=Double.parseDouble(manyrifmatch2.getScore1two3rid());
		} catch (Exception e) {
			score1two3rid=0.0;
		}
		double score2two3rid=0;
		try {
			score2two3rid=Double.parseDouble(manyrifmatch2.getScore2two3rid());
		} catch (Exception e) {
			score2two3rid=0.0;
		}
		double score3two3rid=0;
		try {
			score3two3rid=Double.parseDouble(manyrifmatch2.getScore3two3rid());
		} catch (Exception e) {
			score3two3rid=0.0;
		}
		double score4two3rid=0;
		try {
			score4two3rid=Double.parseDouble(manyrifmatch2.getScore4two3rid());
		} catch (Exception e) {
			score4two3rid=0;
		}
		double score5two3rid=0;
		try {
			score5two3rid=Double.parseDouble(manyrifmatch2.getScore5two3rid());
		} catch (Exception e) {
			score5two3rid=0;
		}
		double score6two3rid=0;
		try {
			score6two3rid=Double.parseDouble(manyrifmatch2.getScore6two3rid());
		} catch (Exception e) {
			score6two3rid=0;
		}
		double score7two3rid=0;
		try {
			score7two3rid=Double.parseDouble(manyrifmatch2.getScore7two3rid());
		} catch (Exception e) {
			score7two3rid=0;
		}
		double score8two3rid=0;
		try {
			score8two3rid=Double.parseDouble(manyrifmatch2.getScore8two3rid());
		} catch (Exception e) {
			score8two3rid=0;
		}
		double score9two3rid=0;
		try {
			score9two3rid=Double.parseDouble(manyrifmatch2.getScore9two3rid());
		} catch (Exception e) {
			score9two3rid=0;
		}
		double score10two3rid=0;
		try {
			score10two3rid=Double.parseDouble(manyrifmatch2.getScore10two3rid());
		} catch (Exception e) {
			score10two3rid=0;
		}
		double score11two3rid=0;
		try {
			score11two3rid=Double.parseDouble(manyrifmatch2.getScore11two3rid());
		} catch (Exception e) {
			score11two3rid=0;
		}
		double score12two3rid=0;
		try {
			score12two3rid=Double.parseDouble(manyrifmatch2.getScore12two3rid());
		} catch (Exception e) {
			score12two3rid=0;
		}
		double score13two3rid=0;
		try {
			score13two3rid=Double.parseDouble(manyrifmatch2.getScore13two3rid());
		} catch (Exception e) {
			score13two3rid=0;
		}
		double score14two3rid=0;
		try {
			score14two3rid=Double.parseDouble(manyrifmatch2.getScore14two3rid());
		} catch (Exception e) {
			score14two3rid=0;
		}
		double score15two3rid=0;
		try {
			score15two3rid=Double.parseDouble(manyrifmatch2.getScore15two3rid());
		} catch (Exception e) {
			score15two3rid=0;
		}
		double score16two3rid=0;
		try {
			score16two3rid=Double.parseDouble(manyrifmatch2.getScore16two3rid());
		} catch (Exception e) {
			score16two3rid=0;
		}
		
		double scoreone=0.0;
		double scoretwo=0.0;
		double finalscore=0.0;
		double score1=comp(score1one1rid,score1one2rid,score1one3rid);
		double score2=comp(score2one1rid,score2one2rid,score2one3rid);
		double score3=comp(score3one1rid,score3one2rid,score3one3rid);
		double score4=comp(score4one1rid,score4one2rid,score4one3rid);
		double score5=comp(score5one1rid,score5one2rid,score5one3rid);
		double score6=comp(score6one1rid,score6one2rid,score6one3rid);
		double score7=comp(score7one1rid,score7one2rid,score7one3rid);
		double score8=comp(score8one1rid,score8one2rid,score8one3rid);
		double score9=comp(score9one1rid,score9one2rid,score9one3rid);
		double score10=comp(score10one1rid,score10one2rid,score10one3rid);
		double score11=comp(score11one1rid,score11one2rid,score11one3rid);
		double score12=comp(score12one1rid,score12one2rid,score12one3rid);
		double score13=comp(score13one1rid,score13one2rid,score13one3rid);
		double score14=comp(score14one1rid,score14one2rid,score14one3rid);
		double score15=comp(score15one1rid,score15one2rid,score15one3rid);
		double score16=comp(score16one1rid,score16one2rid,score16one3rid);
		double scoreTwo1=comp(score1two1rid,score1two2rid,score1two3rid);
		double scoreTwo2=comp(score2two1rid,score2two2rid,score2two3rid);
		double scoreTwo3=comp(score3two1rid,score3two2rid,score3two3rid);
		double scoreTwo4=comp(score4two1rid,score4two2rid,score4two3rid);
		double scoreTwo5=comp(score5two1rid,score5two2rid,score5two3rid);
		double scoreTwo6=comp(score6two1rid,score6two2rid,score6two3rid);
		double scoreTwo7=comp(score7two1rid,score7two2rid,score7two3rid);
		double scoreTwo8=comp(score8two1rid,score8two2rid,score8two3rid);
		double scoreTwo9=comp(score9two1rid,score9two2rid,score9two3rid);
		double scoreTwo10=comp(score10two1rid,score10two2rid,score10two3rid);
		double scoreTwo11=comp(score11two1rid,score11two2rid,score11two3rid);
		double scoreTwo12=comp(score12two1rid,score12two2rid,score12two3rid);
		double scoreTwo13=comp(score13two1rid,score13two2rid,score13two3rid);
		double scoreTwo14=comp(score14two1rid,score14two2rid,score14two3rid);
		double scoreTwo15=comp(score15two1rid,score15two2rid,score15two3rid);
		double scoreTwo16=comp(score16two1rid,score16two2rid,score16two3rid);
		
		scoreone=score1+
				score2+
				score3+
				score4+
				score5+
				score6+
				score7+
				score8+
				score9+
				score10+
				score11+
				score12+
				score13+
				score14+
				score15+
				score16;
		scoretwo=scoreTwo1+
				scoreTwo2+
				scoreTwo3+
				scoreTwo4+
				scoreTwo5+
				scoreTwo6+
				scoreTwo7+
				scoreTwo8+
				scoreTwo9+
				scoreTwo10+
				scoreTwo11+
				scoreTwo12+
				scoreTwo13+
				scoreTwo14+
				scoreTwo15+
				scoreTwo16;
		finalscore=Arith.add(scoreone, scoretwo);
		manyrifmatch2.setScoreonebytranslate(scoreone);
		manyrifmatch2.setScoretwobytranslate(scoretwo);
		manyrifmatch2.setScorefinal(Double.toString(finalscore));
		manyrifmatchService.updateByPrimaryKeySelective(manyrifmatch2);
	}
	Collections.sort(manyrifmatchs);
	int i = 1;
	for (Manyrifmatch manyrifmatchxx : manyrifmatchs) {
		if (manyrifmatchs.size() >= 8) {
			if ((i <= Math.round((manyrifmatchs.size() * 0.15)))&&(manyrifmatchxx.getScorefinal()!="0.0")) {
				manyrifmatchxx.setReward("一等奖");
			} else if ((i > (manyrifmatchs.size() * 0.15)) &&( i < Math.round((manyrifmatchs.size() * 0.3)))&&(manyrifmatchxx.getScorefinal()!="0.0")) {
				manyrifmatchxx.setReward("二等奖");
			} else if ((i > (manyrifmatchs.size() * 0.3) )&&( i <= Math.round((manyrifmatchs.size() * 0.6)))&&(manyrifmatchxx.getScorefinal()!="0.0")) {
				manyrifmatchxx.setReward("三等奖");
			} else if (i > Math.round((manyrifmatchs.size() * 0.6))) {
				manyrifmatchxx.setReward("");
			}
		}
		if(! (manyrifmatchxx.getScore1one1rid().equals("弃权") && manyrifmatchxx.getScore1two1rid().equals("弃权"))) {
			manyrifmatchxx.setRank(i);
			i++;
		}
		
		manyrifmatchService.updateByPrimaryKeySelective(manyrifmatchxx);
	}
	manyrifmatchs = manyrifmatchService.findWhoJoinThisMatchThisListAndHasConfirm(manyrifmatch.getJoinmatch(),
			manyrifmatch.getJoinlist(), manyrifmatch.getJoingage());
		return manyrifmatchs;
	}
	
	
}