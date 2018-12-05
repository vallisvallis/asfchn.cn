package com.mengmaclub.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengmaclub.model.Fee;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;
import com.mengmaclub.model.JoinExamPeople;
import com.mengmaclub.model.JoinMatchTeam;
import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.Manager;
import com.mengmaclub.model.Mangoptionsmatch;
import com.mengmaclub.model.Manyrifmatch;
import com.mengmaclub.model.Match;
import com.mengmaclub.model.MatchGroup;
import com.mengmaclub.model.MatchList;
import com.mengmaclub.model.Referee;
import com.mengmaclub.model.Turnmatchlist;
import com.mengmaclub.model.Twoptionsmatch;
import com.mengmaclub.model.Withfriendmatch;
import com.mengmaclub.service.FeeService;
import com.mengmaclub.service.HxPeopleService;
import com.mengmaclub.service.HxTeamService;
import com.mengmaclub.service.JoinExamPeopleService;
import com.mengmaclub.service.JoinMatchTeamPeopleService;
import com.mengmaclub.service.JoinMatchTeamService;
import com.mengmaclub.service.ManagerService;
import com.mengmaclub.service.MangoptionsmatchService;
import com.mengmaclub.service.ManyrifmatchService;
import com.mengmaclub.service.MatchGroupService;
import com.mengmaclub.service.MatchListService;
import com.mengmaclub.service.MatchService;
import com.mengmaclub.service.NewsService;
import com.mengmaclub.service.RefereeService;
import com.mengmaclub.service.TurnMatchListService;
import com.mengmaclub.service.TwoptionsMatchService;
import com.mengmaclub.service.WithfriendmatchService;

@Controller
@RequestMapping("/")
public class AdminController {
	@Autowired
	private HxTeamService hxTeamService;
	@Autowired
	private HxPeopleService hxPeopleService;
	@Autowired
	private NewsService newsService;
	@Autowired
	private ManagerService managerService;
	@Autowired
	private FeeService feeServices;
	@Autowired
	private JoinMatchTeamService joinMatchTeamService;
	@Autowired
	private RefereeService refereeService;
	@Autowired
	private JoinMatchTeamPeopleService joinMatchTeamPeopleService;
	@Autowired
	private JoinExamPeopleService joinExamPeopleService;
	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchGroupService matchGroupService;

	@Autowired
	private MatchListService matchListService;
	@Autowired
	private TurnMatchListService turnMatchListService;
	@Autowired
	private MangoptionsmatchService mangoptionsmatchService;
	@Autowired
	private WithfriendmatchService withfriendmatchService;
@Autowired
	private TwoptionsMatchService twoptionsMatchService;
@Autowired
private ManyrifmatchService manyrifmatchService;
	/**
	 * 跳转到login.jsp
	 * 
	 * @return
	 */
	@RequestMapping("login")
	public String toLogin() {
		return "login";
	}

	@RequestMapping("index")
	public String index() {
		return "index";
	}

	@RequestMapping("toUpload")
	public String toUpload(int id, Model model) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
		model.addAttribute("hxTeam", hxTeam);
		return "toUpload";
	}

	/**
	 * 同意参赛队伍
	 * 
	 * @param id
	 * @return
	 */
	@RequestMapping("toYesJoinTeam")
	public String toYesJoinTeam(int id) {
		JoinMatchTeam joinMatchTeam = joinMatchTeamService
				.selectByPrimaryKey(id);
		joinMatchTeam.setIsconfirm(2);// 2是确认
		joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
		return "redirect:/joinTeamConfirm";
	}

	@RequestMapping("hxTeamUi")
	public String hxTeamUi(int id, Model model) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
		model.addAttribute("hxTeam", hxTeam);
		return "hxTeamUi";
	}

	/**
	 * 拒绝参赛队伍
	 * 
	 * @param id
	 * @return
	 * 
	 *         2为已审核队伍 1为未审核队伍 3为审核未通过的队伍 7为 再次审核待编辑
	 */
	@RequestMapping("toNoJoinTeam")
	public String toNoJoinTeam(int id) {
		JoinMatchTeam joinMatchTeam = joinMatchTeamService
				.selectByPrimaryKey(id);
		joinMatchTeam.setIsconfirm(3);// 3是审核未通过
		joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
		// joinMatchTeamService.deleteByPrimaryKey(id);
		return "redirect:/joinTeamConfirm";
	}

	@RequestMapping("delJoinTeamWhichIsSuccess")
	public String delJoinTeamWhichIsSuccess(int id) {
		joinMatchTeamService.deleteByPrimaryKey(id);
		return "redirect:/allTeamsButton";
	}

	@RequestMapping("simpleFileupload")
	public String upLoad(int id, HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
		// 1、创建一个DiskFileItemFactory工厂
		DiskFileItemFactory factory = new DiskFileItemFactory();
		// 2、创建一个文件上传解析器
		ServletFileUpload upload = new ServletFileUpload(factory);
		// 解决上传文件名的中文乱码
		upload.setHeaderEncoding("UTF-8");
		factory.setSizeThreshold(1024 * 500);// 设置内存的临界值为500K
		File linshi = new File("D:\\linshi");// 当超过500K的时候，存到一个临时文件夹中
		factory.setRepository(linshi);
		upload.setSizeMax(1024 * 1024 * 5);// 设置上传的文件总的大小不能超过5M
		try {
			// 1. 得到 FileItem 的集合 items
			List<FileItem> /* FileItem */items = upload.parseRequest(request);
			// 2. 遍历 items:
			for (FileItem item : items) {
				// 若是一个一般的表单域, 打印信息
				if (item.isFormField()) {
					String name = item.getFieldName();
					String value = item.getString("utf-8");
					System.out.println(name + ": " + value);
				}
				// 若是文件域则把文件保存到 e:\\files 目录下.
				else {
					String fileName = item.getName();
					long sizeInBytes = item.getSize();
					System.out.println(fileName);
					System.out.println(sizeInBytes);
					InputStream in = item.getInputStream();
					byte[] buffer = new byte[1024];
					int len = 0;
					fileName = "d:\\HxPeoplefiles\\" + fileName;// 文件最终上传的位置
					System.out.println(fileName);
					OutputStream out = new FileOutputStream(fileName);
					while ((len = in.read(buffer)) != -1) {
						out.write(buffer, 0, len);
					}
					out.close();
					in.close();
				}
			}
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		return "error";
	}

	/**
	 * 登录验证
	 * 
	 * @param o
	 * @return
	 */
	@RequestMapping("loginWithName")
	public String login(@RequestParam String username,
			@RequestParam String password, Model model) {
		List<HxTeam> hxTeamList = hxTeamService.findAll();
		List<HxPeople> hxPeopleList = hxPeopleService.findAll();
		List<Manager> managerList = managerService.findAll();
		List<Referee> refereeList = refereeService.findAll();
		List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService
				.findwhocanjoinexam();
		// 裁判登录
		for (Referee referee : refereeList) {
			System.out.println(referee);
			String refereeName = referee.getName();
			String refereePassword = referee.getPassword();
			boolean i = refereeName.equals(username)
					&& refereePassword.equals(password);
			if (i) {
				model.addAttribute("referee", referee);
				return "hxRefereeUi";
			}
		}
		for (Manager manager : managerList) {
			if (manager.getSn().equals(username)
					&& manager.getPassword().equals(password)) {
				List<Fee> feeNeedToconfirm = feeServices
						.findNeedToConfirmAboutPeople();
				List<JoinMatchTeam> joinMatchTeams = joinMatchTeamService
						.findAllWhichIsNo();
				List<JoinExamPeople> joinExamPeoplesh = joinExamPeopleService
						.findWhoHasConfirm();
				List<JoinExamPeople> joinExamPeoplesn = joinExamPeopleService
						.findWhoIsNeedConfirm();

				if (feeNeedToconfirm.isEmpty() == false
						|| joinMatchTeams.isEmpty() == false) {
					model.addAttribute("joinMatchTeams", joinMatchTeams.size());
					model.addAttribute("haveFeeNeedToConfirm",
							feeNeedToconfirm.size());
					model.addAttribute("manager", manager);
					model.addAttribute("joinExamPeoplesh",
							joinExamPeoplesh.size());
					model.addAttribute("joinExamPeoplesn",
							joinExamPeoplesn.size());

					return "hxUi";
				}
				return "hxUi";
			}
		}
		for (HxTeam hxTeam : hxTeamList) {
			if (hxTeam.getSn().equals(username)
					&& hxTeam.getPassword().equals(password)) {
				model.addAttribute("hxTeam", hxTeam);
				return "hxTeamUi";
			}
		}

		System.out.println("開始審查 參加考試的人員" + "有資格的人數為："
				+ joinMatchTeamPeoples.size());
		for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
			System.out.println("在list中 具備參加資格的人有："
					+ joinMatchTeamPeople.getName()
					+ joinMatchTeamPeople.getPeoplesn());
			// HxPeople
			// hxPeople=hxPeopleService.findBySn(joinMatchTeamPeople.getPeoplesn());
			// System.out.println("數據庫中的密碼是：======="+hxPeople.getPassword());
			String peoplepasswordj = "asfchn.cn";// hxPeople.getPassword();
			System.out.println("username======登陸==============" + username);
			System.out.println("password=======登陸=======" + password);

			if (joinMatchTeamPeople.getPeoplesn().equals(username)
					&& peoplepasswordj.equals(password)) {
				HxPeople hxPeople = hxPeopleService
						.findBySn(joinMatchTeamPeople.getPeoplesn());
				model.addAttribute("hxPeople", hxPeople);
				return "hxPeopleUi";
			}

		}
		for (HxPeople hxPeople : hxPeopleList) {
			System.out.println(hxPeople);
			String PeopleSn = hxPeople.getSn();
			String Peoplepassword = hxPeople.getPassword();

			boolean i = PeopleSn.equals(username)
					&& Peoplepassword.equals(password);
			System.out.println(i);
			if (PeopleSn.equals(username) && Peoplepassword.equals(password)) {
				model.addAttribute("hxPeople", hxPeople);
				return "NoPeopleUi";
			}
			// return "loginError";
		}

		// List<Referee> refereelist=refereeService.findAll();
		//
		//
		// for (Referee referee : refereelist) {
		// String refereeName=referee.getName();
		// String refereePassword=referee.getPassword();
		// if (refereeName.equals(refereeName) &&
		// refereePassword.equals(refereePassword)) {
		// model.addAttribute("referee", referee);
		// return "hxRefereeUi";
		// }
		// return "loginError";
		// }
		return "loginError";

		// if (usename != null && password != null) {
		// for (HxPeople hxPeople2 : hxPeopleList) {
		// if (hxPeople2.getSn().equals(usename)
		// && hxPeople2.getPassword().equals(password)) {
		// model.addAttribute("hxPeople2", hxPeople2);
		// public String void int (){
		// nihnknxunaunkjw
		// return "hxPeopleUi";
		// } else {
		// for (HxTeam hxTeam : hxTeamList) {
		// if (hxTeam.getSn().equals(usename)
		// && hxTeam.getPassword().equals(password)) {
		// model.addAttribute("hxTeam", hxTeam);
		// return "hxTeamUi";
		// } else {
		// for (Manager manager : managerList) {
		// if (manager.getSn().equals(usename)
		// && manager.getPassword().equals(
		// password)) {
		// System.out.println("manager.getSn()"
		// + manager.getSn() + "/n"
		// + "manager.getPassword()"
		// + manager.getPassword());
		// return "hxUi";
		// } else {
		// return "error";
		// }
		// }
		//
		// }
		// }
		//
		// }
		// }
		//
		// }

	}

	@RequestMapping("showJoinExamPeople")
	public String showJoinExamPeople(Model model) {
		List<JoinExamPeople> joinExamPeoplesh = joinExamPeopleService
				.findWhoHasConfirm();
		List<JoinExamPeople> joinExamPeoplesn = joinExamPeopleService
				.findWhoIsNeedConfirm();

		model.addAttribute("joinExamPeoplesh", joinExamPeoplesh.size());
		model.addAttribute("joinExamPeoplesn", joinExamPeoplesn.size());
		return "showJoinExamPeople";

	}

	@RequestMapping("search")
	public String search(String str,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		List<HxTeam> allHxTeam = hxTeamService.findAll();
		PageHelper.startPage(pn, 50);
		List<HxTeam> hxTeams = new ArrayList<>();
		for (HxTeam hxTeam : allHxTeam) {
			if (hxTeam.getManagername().equals(str)
					|| hxTeam.getSn().equals(str)
					|| hxTeam.getFullname().contains(str)) {
				System.out.println(hxTeam.toString());
				hxTeams.add(hxTeam);
				PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxTeams, 10);
				model.addAttribute("PageInfo", page);
				return "allHxTeam";
			}
		}
		return "allHxTeam";
	}

	/**
	 * 显示会员单位
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("showAllHxTeam")
	public String findTeam(Model model) {
		List<HxTeam> allHxTeam = hxTeamService.findAll();
		model.addAttribute("allHxTeam", allHxTeam);
		return "showAllHxTeam";
	}

	/**
	 * 显示飞行营地
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("showAllFlyTeam")
	public String findFlyTeam(Model model) {
		List<HxTeam> allFlyHxTeam = hxTeamService.findFlyTeam();
		model.addAttribute("allFlyHxTeam", allFlyHxTeam);
		return "showAllFlyTeam";
	}

	/*
	 * 对会费的查看
	 */
	/**
	 * 查看feelist中所有fee
	 * 
	 * @param list
	 * @param mdoel
	 * @return
	 */
	@RequestMapping("yearFeeNeedConfirm")
	public String getYearFeeWhichNeedToConfirm(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		List<Fee> feeList = feeServices.findNeedToConfirmAboutPeople();
		PageHelper.startPage(pn, 100);
		PageInfo<Fee> page = new PageInfo<Fee>(feeList, 100);
		model.addAttribute("pageInfo", page);
		return "yearFeeNeedConfirm";
	}

	/**
	 * 航协同意
	 * 
	 * @param fee
	 * @param model
	 * @return
	 */
	@RequestMapping("updateFeeStatusYes")
	public String updateFeeStatusYes(Fee fee, Model model) {
		Fee feenow = feeServices.selectByPrimaryKey(fee.getId());
		Integer people = feenow.getPeople();
		Integer team = feenow.getTeam();
		if (people != null) {
			feenow.setFeestatus(4);
			feeServices.updateByPrimaryKeySelective(feenow);
			int id = feenow.getPeople();
			HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
			if (hxPeople != null) {
				Date now = new Date();
				hxPeople.setEligibledat(now);
				hxPeople.setYearfeestatus(2);
				hxPeopleService.updateByPrimaryKeySelective(hxPeople);
				return "redirect:/yearFeeNeedConfirm";
			}
		} else if (team != null) {
			feenow.setFeestatus(4);
			feeServices.updateByPrimaryKeySelective(feenow);
			int id = feenow.getTeam();
			HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
			Date now = new Date();
			hxTeam.setEligibledat(now);
			hxTeam.setStatus(2);
			hxTeamService.updateByPrimaryKeySelective(hxTeam);
			return "redirect:/yearFeeNeedConfirm";
		}
		return "redirect:/yearFeeNeedConfirm";
	}

	/**
	 * 显示所有待审核的队伍
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("joinTeamConfirm")
	public String joinTeamConfirm(Model model) {
		List<JoinMatchTeam> joinMatchTeams = joinMatchTeamService
				.findAllWhichIsNo();
		model.addAttribute("joinMatchTeams", joinMatchTeams);
		return "joinTeamConfirm";
	}

	/**
	 * 航协拒绝
	 * 
	 * @param fee
	 * @param model
	 * @return
	 */
	@RequestMapping("updateFeeStatusNo")
	public String updateFeeStatusNo(Fee fee, Model model) {
		fee.setFeestatus(1);
		// if (fee.getPeople()!=0) {
		// HxPeople
		// hxPeople=hxPeopleService.selectByPrimaryKey(fee.getPeople());
		// hxPeople.setEligibledat(null);
		// // hxPeople.set
		// // hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		// }
		feeServices.updateByPrimaryKeySelective(fee);
		return "redirect:/yearFeeNeedConfirm";
	}

	/**
	 * 显示训练基地
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("showAllTrainTeam")
	public String findTrainTeam(Model model) {
		List<HxTeam> allTrainTeam = hxTeamService.findTrainTeam();
		model.addAttribute("allTrainTeam", allTrainTeam);
		return "showAllTrainTeam";
	}

	/**
	 * 查看会员单位已缴费的订单
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("teamYearFeeHistory")
	public String teamYearFeeHistory(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		List<Fee> teamYearFeeHistory = feeServices.findTeam();
		PageHelper.startPage(pn, 100);
		PageInfo<Fee> page = new PageInfo<Fee>(teamYearFeeHistory, 100);
		model.addAttribute("pageInfo", page);
		return "teamYearFeeHistory";
	}

	/**
	 * 查看会员单位已缴费的订单
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("peopleYearFeeHistory")
	public String peopleYearFeeHistory(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		List<Fee> peopleYearFeeHistory = feeServices.findPeople();
		PageHelper.startPage(pn, 100);
		PageInfo<Fee> page = new PageInfo<Fee>(peopleYearFeeHistory, 100);
		model.addAttribute("pageInfo", page);
		return "peopleYearFeeHistory";
	}

	/**
	 * 意见反馈
	 * 
	 * @return
	 */
	@RequestMapping("feedback")
	public String feedback() {
		return "feedback";
	}

	/**
	 * 帮助文档
	 * 
	 * @return
	 */
	@RequestMapping("helpword")
	public String helpword() {
		return "helpword";
	}

	/**
	 * 修改会员单位密码
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("tochangewordforHxTeam")
	public String toChangeWordforHxTeam(int id, Model model) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
		model.addAttribute("hxTeam", hxTeam);
		return "changeWordforTeam";
	}

	/**
	 * 修改裁判密码
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("tochangewordforReferee")
	public String toChangeWordforReferee(int id, Model model) {
		Referee referee = refereeService.selectByPrimaryKey(id);
		model.addAttribute("referee", referee);
		return "changeWordforReferee";
	}

	/**
	 * 跳转到航协修改密码页面、修改航协密码
	 * 
	 * @return
	 */
	@RequestMapping("tochangeword")
	public String toChangeWord(int id, Model model) {
		Manager manager = managerService.selectByPrimaryKey(id);
		model.addAttribute("manager", manager);
		return "changeWordforHx";
	}

	/**
	 * 
	 * 执行修改
	 * 
	 * @return
	 */
	@RequestMapping("changeHxPassword")
	public String changeHxPassword(int id, String password, String newPassword,
			String newPassword2, Model model) {
		Manager manager = managerService.selectByPrimaryKey(id);
		if (manager.getPassword().equals(password)) {
			if (newPassword.equals(newPassword2)) {
				manager.setPassword(newPassword);
				managerService.updateByPrimaryKeySelective(manager);
				return "changeWordSuccess";
			}
			return "twopasswordIsNo";
		}
		return "passworderror";
	}

	@RequestMapping("allTeamsButton")
	public String joinTeam(Model model) {
		List<JoinMatchTeam> matchteams = joinMatchTeamService
				.findAllWhichIsYes();
		model.addAttribute("matchteams", matchteams);
		return "allTeams";
	}

	@RequestMapping("getPasswordtoChange")
	public String changepasswordforTeam(int id, String password,
			String newPassword, String newPassword2, Model model) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
		if (hxTeam.getPassword().equals(password)) {
			if (newPassword.equals(newPassword2)) {
				hxTeam.setPassword(newPassword);
				hxTeamService.updateByPrimaryKeySelective(hxTeam);
				return "changeWordSuccess";
			}
			return "twopasswordIsNo";
		}
		return "passworderror";
	}

	@RequestMapping("getRefreePasswordtoChange")
	public String changepasswordforReferee(int id, String password,
			String newPassword, String newPassword2, Model model) {
		Referee referee = refereeService.selectByPrimaryKey(id);
		if (referee.getPassword().equals(password)) {
			if (newPassword.equals(newPassword2)) {
				referee.setPassword(newPassword);
				refereeService.updateByPrimaryKeySelective(referee);
				return "changeWordSuccess";
			}
			return "twopasswordIsNo";
		}
		return "passworderror";
	}

	// /**
	// * 修改密码
	// *
	// * @param username
	// * @param password
	// * @param newPassword
	// * @param newPassword2
	// * @param model
	// * @return
	// */
	// @RequestMapping("changeWord")
	// public String changePassword(String username, String password,
	// String newPassword, String newPassword2, Model model) {
	// System.out.println("获取到的用户名为："+username+"获取到的该用户的密码为："+password+"获取到的新密码为："+newPassword+"获取到的重复新密码为："+newPassword2);
	// List<HxTeam> hxTeamList = hxTeamService.findAll();
	// List<HxPeople> hxPeopleList = hxPeopleService.findAll();
	// List<Manager> managerList = managerService.findAll();
	//
	// for (Manager manager : managerList) {
	// if (manager.getSn().equals(username)
	// && manager.getPassword().equals(password)
	// && newPassword.equals(newPassword2)) {
	// manager.setPassword(newPassword);
	// managerService.updateByPrimaryKeySelective(manager);
	//
	// return "hxUi";
	// }
	// return "hxUi";
	// }
	//
	// for (HxTeam hxTeam : hxTeamList) {
	// if (hxTeam.getSn().equals(username)
	// && hxTeam.getPassword().equals(password)
	// && newPassword.equals(newPassword2)) {
	// System.out.println("会员单位的用户名是"+username+"会员单位的密码是"+password+"新修改的密码为："+newPassword+"重复修改的新密码为："+newPassword2);
	// hxTeam.setPassword(newPassword);
	// hxTeamService.updateByPrimaryKeySelective(hxTeam);
	// model.addAttribute("hxTeam", hxTeam);
	//
	// return "hxTeamUi";
	// }
	// }
	// for (HxPeople hxPeople : hxPeopleList) {
	// if (hxPeople.getSn().equals(username)
	// && hxPeople.getPassword().equals(password)
	// && newPassword.equals(newPassword2)) {
	//
	// hxPeople.setPassword(newPassword2);
	// hxPeopleService.updateByPrimaryKeySelective(hxPeople);
	//
	// model.addAttribute("hxPeople", hxPeople);
	//
	// return "hxPeopleUi";
	// }
	// }
	// return "loginError";
	//
	// }
	//
	// @RequestMapping("mjadasjndakdknawudasdjnan")
	// public String Love(){
	// return "mkojhdsjkahdjahskd";
	// }
	//

	@RequestMapping("nameList")
	public String nameList(int id, Model model) {
		model.addAttribute("id", id);
		return "nameList";

	}

	@RequestMapping("knoinn")
	public String knoinn(int id, Model model) {
		model.addAttribute("id", id);
		return "nameList";

	}

	@RequestMapping("readyShowOrder")
	public String nameLis22t(int id, Model model) {
		Match match = matchService.selectByPrimaryKey(id);
		model.addAttribute("match", match);
		String thisMatchAllListInfo = match.getSupportlist();
		System.out.println("本次比赛所有的参赛项目id为：（合并显示）" + thisMatchAllListInfo);
		String[] thisMatchList = thisMatchAllListInfo.split(",");
		List<MatchList> thisMatchListInfo = new ArrayList<>();
		for (int i = 0; i < thisMatchList.length; i++) {
			System.out.println("本次比赛所有的参赛项目id为：（逐条显示）" + thisMatchList[i]);
			MatchList eveymatch = matchListService.selectByPrimaryKey(Integer
					.parseInt(thisMatchList[i]));
			thisMatchListInfo.add(eveymatch);
		}
		for (MatchList matchList : thisMatchListInfo) {
			System.out.println("本次比赛的所有参赛项目为：" + matchList.getName());
		}
		// 将本次比赛的所有参赛项目发送到页面
		model.addAttribute("allMatchLists", thisMatchListInfo);
		String thisMatchAllGroupInfo = match.getSupportgroup();
		System.out.println("本次比赛所有的参赛组别id为：（合并显示）" + thisMatchAllGroupInfo);
		String[] thisMatchGroup = thisMatchAllGroupInfo.split(",");
		List<MatchGroup> thisMatchGroupInfo = new ArrayList<>();
		for (int i = 0; i < thisMatchGroup.length; i++) {
			System.out.println("本次比赛所有的参赛组别id为：（逐条显示）" + thisMatchGroup[i]);
			MatchGroup everymatchGroup = matchGroupService
					.selectByPrimaryKey(Integer.parseInt(thisMatchGroup[i]));
			thisMatchGroupInfo.add(everymatchGroup);
		}
		for (MatchGroup matchGroup : thisMatchGroupInfo) {
			System.out.println("本次比赛的所有参赛组别为：" + matchGroup.getGroupage());
		}
		// 将本次比赛的所有参赛组别发送到页面
		model.addAttribute("allMatchGroups", thisMatchGroupInfo);

		return "matchlistorder";

	}

	public String teamMatchSort() {// 团体
		return "";
	}

	@RequestMapping("allcertificate")
	public String allcertificate(int matchid, Model model) {
		Match match = matchService.selectByPrimaryKey(matchid);
		model.addAttribute("match", match);
		String thisMatchAllListInfo = match.getSupportlist();
		System.out.println("本次比赛所有的参赛项目id为：（合并显示）" + thisMatchAllListInfo);
		String[] thisMatchList = thisMatchAllListInfo.split(",");
		List<MatchList> thisMatchListInfo = new ArrayList<>();
		for (int i = 0; i < thisMatchList.length; i++) {
			System.out.println("本次比赛所有的参赛项目id为：（逐条显示）" + thisMatchList[i]);
			MatchList eveymatch = matchListService.selectByPrimaryKey(Integer
					.parseInt(thisMatchList[i]));
			thisMatchListInfo.add(eveymatch);
		}
		for (MatchList matchList : thisMatchListInfo) {
			System.out.println("本次比赛的所有参赛项目为：" + matchList.getName());
		}
		// 将本次比赛的所有参赛项目发送到页面
		model.addAttribute("allMatchLists", thisMatchListInfo);
		String thisMatchAllGroupInfo = match.getSupportgroup();
		System.out.println("本次比赛所有的参赛组别id为：（合并显示）" + thisMatchAllGroupInfo);
		String[] thisMatchGroup = thisMatchAllGroupInfo.split(",");
		List<MatchGroup> thisMatchGroupInfo = new ArrayList<>();
		for (int i = 0; i < thisMatchGroup.length; i++) {
			System.out.println("本次比赛所有的参赛组别id为：（逐条显示）" + thisMatchGroup[i]);
			MatchGroup everymatchGroup = matchGroupService
					.selectByPrimaryKey(Integer.parseInt(thisMatchGroup[i]));
			thisMatchGroupInfo.add(everymatchGroup);
		}
		for (MatchGroup matchGroup : thisMatchGroupInfo) {
			System.out.println("本次比赛的所有参赛组别为：" + matchGroup.getGroupage());
		}
		// 将本次比赛的所有参赛组别发送到页面
		model.addAttribute("allMatchGroups", thisMatchGroupInfo);

		return "allcertificate";
	}

	@RequestMapping("certificateTogage")
	public String certificateTogage(int matchid, int matchlist, int gage) {

		return "";
	}

	public String numadd(int i) {

		String num = null;
		if (i < 10) {
			num = "00" + i;
		} else if (i >= 10 && i < 100) {
			num = "0" + i;
		} else if (i > 100) {
			num = Integer.toString(i);
		}

		return num;
	}

	@RequestMapping("orderNameList")
	// 秩序册生成
	public String orderNameList(int id, Model model) {
		System.out.println("zhixing");
		XSSFWorkbook workBook = new XSSFWorkbook();
		Match match = matchService.selectByPrimaryKey(id);
		List<JoinMatchTeam> joinMatchTeams = joinMatchTeamService
				.findthismatchteam(id);// 本次比賽參賽隊伍
		XSSFSheet sheet = workBook.createSheet(match.getName());
		
		XSSFPrintSetup printSetup=sheet.getPrintSetup();
		printSetup.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE); // 纸张
		sheet.setDisplayGridlines(false);
		sheet.setPrintGridlines(false);
		sheet.setMargin(XSSFSheet.TopMargin,( double )1 ); // 上边距
		sheet.setMargin(XSSFSheet.BottomMargin,( double ) 1 ); // 下边距
		sheet.setMargin(XSSFSheet.LeftMargin,( double )	1 ); // 左边距
		sheet.setMargin(XSSFSheet.RightMargin,( double ) 1 ); // 右边距
		
		
		
		// 創建第一行
		XSSFRow firstRow = sheet.createRow(0);
		XSSFCell cell = null;
		cell = firstRow.createCell(0);
		
		XSSFCellStyle namestyle=workBook.createCellStyle();
		Font font=workBook.createFont();
		//font.setBold(true); // 加粗
		font.setFontName("宋体"); // 字体
		font.setFontHeightInPoints((short) 11); // 大小
		namestyle.setFont(font);
		
		int num1111 = 1;
		int i = 2;
		for (JoinMatchTeam joinMatchTeam : joinMatchTeams) {
			List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService
					.findthisjoinTeamPeople(joinMatchTeam.getId());
			// for (JoinMatchTeamPeople joinMatchTeamPeople :
			// joinMatchTeamPeoples) {
			// joinMatchTeamPeople.setScore2("");
			// joinMatchTeamPeopleService.updateByPrimaryKeySelective(joinMatchTeamPeople);
			// }
			int k = 0;
			XSSFRow nameRow = sheet.createRow(i);// 创建队伍名称的那一行
			XSSFCell cell1 = null;
			XSSFCell cell2 = null;
			CellRangeAddress region = new CellRangeAddress(i, i, 0,4 );
			sheet.addMergedRegion(region);
			cell1 = nameRow.createCell(k);// 这一行的第一个单元格
			

			cell1.setCellValue(joinMatchTeam.getBlongteamname()+joinMatchTeam.getTeamname());
			
			i++;
			XSSFRow job2Row = sheet.createRow(i);
			XSSFCell celljob2 = job2Row.createCell(0);

			celljob2.setCellValue("领队：");
			List<JoinMatchTeamPeople> p2 = joinMatchTeamPeopleService
					.findjob2(joinMatchTeam.getId());
			int job2 = 1;
			for (JoinMatchTeamPeople joinMatchTeamPeople : p2) {
				XSSFCell cell12 = job2Row.createCell(job2);

				if (joinMatchTeamPeople.getJoinmatchlist() != null) {
					joinMatchTeamPeople.setScore2(numadd(num1111));
					joinMatchTeamPeopleService
							.updateByPrimaryKeySelective(joinMatchTeamPeople);
					num1111++;
				}
				cell12.setCellValue(joinMatchTeamPeople.getName()
						+ joinMatchTeamPeople.getScore2());

				job2++;
			}
			i++;
			XSSFRow job1Row = sheet.createRow(i);
			XSSFCell celljob1 = job1Row.createCell(0);
			celljob1.setCellValue("教练：");

			List<JoinMatchTeamPeople> p1 = joinMatchTeamPeopleService
					.findjob1(joinMatchTeam.getId());
			int job1 = 1;
			for (JoinMatchTeamPeople joinMatchTeamPeople : p1) {

				XSSFCell cell11 = job1Row.createCell(job1);
				if (joinMatchTeamPeople.getJoinmatchlist() != null) {
					joinMatchTeamPeople.setScore2(numadd(num1111));
					joinMatchTeamPeopleService
							.updateByPrimaryKeySelective(joinMatchTeamPeople);
					num1111++;
				}
				cell11.setCellValue(joinMatchTeamPeople.getName()
						+ joinMatchTeamPeople.getScore2());

				job1++;
			}
			i++;
			XSSFRow job3Row = sheet.createRow(i);
			XSSFCell celljob3 = job3Row.createCell(0);
			celljob3.setCellValue("运动员：");

			List<JoinMatchTeamPeople> p3 = joinMatchTeamPeopleService
					.findjob3(joinMatchTeam.getId());
			int job3 = 1;
			System.out.println(joinMatchTeam.getBlongteamname()+"有"+p3.size()+"人");
			int cut=0;
			XSSFCell cell13 =null;
			XSSFRow nextRow=null;
			XSSFRow centerRow=null;
			int testrow=i;
			for (JoinMatchTeamPeople joinMatchTeamPeople : p3) {
				
				
				if(job3<8){
					if (cut==0) {
						nextRow=job3Row;
					}
					
						cell13= nextRow.createCell(job3);
					//System.out.println("此人写入成功");
					
					joinMatchTeamPeople.setScore2(numadd(num1111));
				}else if (job3==8) {
					cut++;
					testrow++;
					centerRow=sheet.createRow(testrow);
					nextRow=centerRow;
					job3=0;
					cell13=nextRow.createCell(job3);
					joinMatchTeamPeople.setScore2(numadd(num1111));
					
				}
			
				joinMatchTeamPeopleService
						.updateByPrimaryKeySelective(joinMatchTeamPeople);
				cell13.setCellValue(joinMatchTeamPeople.getName()
						+ joinMatchTeamPeople.getScore2());
				num1111++;
				job3++;
			}

			
			
			i = i + cut+2;
		}

		// 創建文件
		// Tomcat 8.5/webapps/ROOT/allQR/
		File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + "秩序册.xlsx");
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workBook.write(stream);
			stream.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		String pphh = "秩序册.xlsx";
		model.addAttribute("pphh", pphh);

		System.out.println("下载");
		return "downloadXlsx";
	}

	@RequestMapping("logout")
	public ModelAndView logout(HttpSession session) {
		session.removeAttribute("hxTeam");
		session.removeAttribute("manager");
		ModelAndView mav = new ModelAndView();
		mav.setViewName("redirect:/login.jsp");
		return mav;
	}

	// Dont down

	@RequestMapping("TestMySchedule")
	// wll 現在值班表計算器
	public String TestMySchedule(String wlldateInweb, Model model) {
		SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
		Date date = null;
		Calendar ca = Calendar.getInstance();
		String result = "";
		try {
			date = f.parse(wlldateInweb);
			ca.setTime(date);
		} catch (Exception e) {

		}

		// System.out.println(DateText.dateToWeek("2018-06-07"));
		String str = String.format("%tj", date);
		System.out.println("天数为：" + str);

		if ((Integer.parseInt(str.trim()) % 4) == 1) {
			result = "据我估计，这天你是白班";
			System.out.println("白");
		} else if ((Integer.parseInt(str.trim()) % 4) == 2) {
			result = "据我估计，这天你是白班";
			System.out.println("白");

		} else if ((Integer.parseInt(str.trim()) % 4) == 3) {
			result = "据我估计，这天你是夜班";
			System.out.println("夜");

		} else {
			result = "据我估计，这天你是休息日";
			System.err.println("休");

		}

		System.out.println(str);

		model.addAttribute("result", result);

		return "mygirlsDate";
	}

}
