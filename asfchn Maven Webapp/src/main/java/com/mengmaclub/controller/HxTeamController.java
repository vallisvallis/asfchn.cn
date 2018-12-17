package com.mengmaclub.controller;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengmaclub.model.Fee;
import com.mengmaclub.model.FeeType;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;
import com.mengmaclub.model.IsNo;
import com.mengmaclub.model.JoinMatchTeam;
import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.JoinMatchTeamPeopleList;
import com.mengmaclub.model.Match;
import com.mengmaclub.model.MatchGroup;
import com.mengmaclub.model.MatchJob;
import com.mengmaclub.model.MatchList;
import com.mengmaclub.service.FeeService;
import com.mengmaclub.service.FeeTypeService;
import com.mengmaclub.service.HxPeopleService;
import com.mengmaclub.service.HxTeamService;
import com.mengmaclub.service.IsNoService;
import com.mengmaclub.service.JoinMatchTeamPeopleService;
import com.mengmaclub.service.JoinMatchTeamService;
import com.mengmaclub.service.MatchGroupService;
import com.mengmaclub.service.MatchJobService;
import com.mengmaclub.service.MatchListService;
import com.mengmaclub.service.MatchService;
import com.mengmaclub.util.DecideSn;
import com.mengmaclub.util.QRCodeUtil;
import com.mengmaclub.util.WordToPic;
import com.mysql.fabric.xmlrpc.base.Array;

@Controller
@RequestMapping("/")
public class HxTeamController {
	@Autowired
	private HxTeamService hxTeamService;
	@Autowired
	private FeeService feeService;
	@Autowired
	private FeeTypeService feeTypeService;
	@Autowired
	private HxPeopleService hxPeopleService;
	@Autowired
	private JoinMatchTeamService joinMatchTeamService;
	@Autowired
	private JoinMatchTeamPeopleService joinMatchTeamPeopleService;
	@Autowired
	private MatchJobService matchJobService;
	@Autowired
	private MatchGroupService matchGroupService;
	@Autowired
	private MatchListService matchListService;
	@Autowired
	private IsNoService isNoService;
	@Autowired
	private MatchService matchService;
	/**
	 * 单个生成二维码
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("createQR")
	public String createQR(Integer id,Model model) throws Exception{	
		JoinMatchTeamPeople joinMatchTeamPeople= joinMatchTeamPeopleService.selectByPrimaryKey(id);
		System.out.println("该会员的二维码");		
		String text=id.toString()+"!"+"60390c7e429e38e8449519011a24f79d";
		System.out.println("该会员的名称为："+joinMatchTeamPeople.getName());
		JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(joinMatchTeamPeople.getJoinwhichjointeam());
		HxTeam hxTeam=hxTeamService.selectByPrimaryKey(joinMatchTeamPeople.getTeamid());
		String filename=hxTeam.getFullname()+joinMatchTeam.getTeamname();
		
		QRCodeUtil.encode(text, "d:/"+filename+"/"+joinMatchTeamPeople.getName()+".jpg", "d:/"+filename, joinMatchTeamPeople.getName(), true);
		return "单个二维码下载页面";
	}
	
	/**
	 * 批量下载二维码
	 * @param id
	 * @param model
	 * @return
	 * @throws Exception
	 */
	@RequestMapping("createAllQR")
	public String createAllQR(Integer id,Model model) throws Exception{
		
//		System.out.println("准备批量生成二维码");
//		JoinMatchTeam thisjoinMatchTeam=joinMatchTeamService.selectByPrimaryKey(id);
//		List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findthisjoinTeamPeople(id);
//		for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
//			String text=joinMatchTeamPeople.getId().toString()+"!"+"60390c7e429e38e8449519011a24f79d";
//			System.out.println("该会员的名称为："+joinMatchTeamPeople.getName());
//			//QRCodeUtil.encode(text, "d:/MyWorkDoc/"+joinMatchTeamPeople.getName()+".jpg", "d:/MyWorkDoc", joinMatchTeamPeople.getName(), true);
//			JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(joinMatchTeamPeople.getJoinwhichjointeam());
//			HxTeam hxTeam=hxTeamService.selectByPrimaryKey(joinMatchTeamPeople.getTeamid());
//			String filename=hxTeam.getFullname()+joinMatchTeam.getTeamname();
//			QRCodeUtil.encode(text, "d:/"+"QR"+"/"+filename+"/"+joinMatchTeamPeople.getName()+".jpg", "d:/"+"QR"+"/"+filename, joinMatchTeamPeople.getName(), true);
//		}
		
		creadQRBylist();
		//credateQQQQQ();
	//	model.addAttribute("thisjoinMatchTeam", thisjoinMatchTeam);
		return "manyJoinPeopledownQR";
	}
	public void creadQRBylist() throws Exception{
		Match match=matchService.selectByPrimaryKey(21);
		//获得本次比赛所有的参赛项目
				String thisMatchAllListInfo=match.getSupportlist();
				System.out.println("本次比赛所有的参赛项目id为：（合并显示）"+thisMatchAllListInfo);
				String[] thisMatchList=thisMatchAllListInfo.split(",");
				List<MatchList> thisMatchListInfo=new ArrayList<>();
				for (int i = 0; i < thisMatchList.length; i++) {
					System.out.println("本次比赛所有的参赛项目id为：（逐条显示）"+thisMatchList[i]);
					MatchList eveymatch=matchListService.selectByPrimaryKey(Integer.parseInt(thisMatchList[i]));
					thisMatchListInfo.add(eveymatch);
				}
		for (MatchList matchList : thisMatchListInfo) {
			List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findThisMatchThisMatchlist(21, matchList.getId());
			for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
				String text=joinMatchTeamPeople.getId().toString()+"!"+"60390c7e429e38e8449519011a24f79d";
				String filename=matchList.getName();
				String filelu="d:/"+"xR"+"/"+filename+"/";
				WordToPic.TextToPic(filelu, joinMatchTeamPeople.getName(), 60, 60, 15);
				QRCodeUtil.encode(text, "d:/"+"xR"+"/"+filename+"/"+joinMatchTeamPeople.getName()+".jpg", "d:/"+"xR"+"/"+filename, joinMatchTeamPeople.getName(), true);
				System.out.println("批量生成完毕");
			}
		}
		
	}
	
	
	public void credateQQQQQ(){
		List<JoinMatchTeam> joinMatchTeams=joinMatchTeamService.findAllWhichIsYesin18();
		joinMatchTeams.size();
		System.out.println("合法的报名表的数目为："+joinMatchTeams.size());
		for (JoinMatchTeam joinMatchTeam1 : joinMatchTeams) {
		
			try {
				System.out.println("准备批量生成二维码");
				
				List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findthisjoinTeamPeople(joinMatchTeam1.getId());
				System.out.println("合法的运动员的数目为："+joinMatchTeamPeoples.size());
				for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
					System.out.println(joinMatchTeamPeople.getJoinmatchlist());
				
					if ((!String.valueOf(joinMatchTeamPeople.getJoinmatchlist()).equals(null))||(!String.valueOf(joinMatchTeamPeople.getJoinmatchlist()).equals(0) )){
						
						
						String text=joinMatchTeamPeople.getId().toString()+"!"+"60390c7e429e38e8449519011a24f79d";
						System.out.println("该会员的名称为："+joinMatchTeamPeople.getName()+"该会员的身份为："+joinMatchTeamPeople.getJobname());
						//QRCodeUtil.encode(text, "d:/MyWorkDoc/"+joinMatchTeamPeople.getName()+".jpg", "d:/MyWorkDoc", joinMatchTeamPeople.getName(), true);
						JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(joinMatchTeamPeople.getJoinwhichjointeam());
						HxTeam hxTeam=hxTeamService.selectByPrimaryKey(joinMatchTeamPeople.getTeamid());
					//p5B 10-17
						
							String filename=hxTeam.getFullname()+joinMatchTeam.getTeamname()+joinMatchTeam.getId();
							String filelu="d:/"+"QR"+"/"+filename+"/";
							System.out.println("filename===="+filename+"======="+"========filelu:"+filelu);
							WordToPic.TextToPic(filelu, joinMatchTeamPeople.getName(), 60, 60, 15);
							QRCodeUtil.encode(text, "d:/"+"xR"+"/"+filename+"/"+joinMatchTeamPeople.getName()+".jpg", "d:/"+"xR"+"/"+filename, joinMatchTeamPeople.getName(), true);
							System.out.println("批量生成完毕");
					
						
					
					}		
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			
			}
		}
		
		
	}
	
	
	/**
	 * 二位码测试
	 * @param joinMatchTeamPeople
	 * @param model
	 * @return
	 */
	@RequestMapping("testQQQ")
	public String testQQQ(JoinMatchTeamPeople joinMatchTeamPeople,Model model){
	joinMatchTeamPeople=joinMatchTeamPeopleService.selectByPrimaryKey(joinMatchTeamPeople.getId());
		
	
		model.addAttribute("joinMatchTeamPeople", joinMatchTeamPeople);
		return "QRtestJoinMatchPeople";
	}
	
	
	/**
	 * 1.显示所有 (会员单位详情)
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("getAllHxTeam")
	public String getAllHxTeam(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 100);
		List<HxTeam> hxTeams = hxTeamService.findAll();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxTeams, 100);
		model.addAttribute("pageInfo", page);
		return "showAllHxTeam";
	}
	
	
	@RequestMapping("addHxPeopleByHxTeamNo")
	public String addHxPeopleByHxTeamNo(){
		return "信息填写有误";
		
	}
/**
 * 航协审核详情
 * @param id
 * @param model
 * @return
 */
	@RequestMapping("getJoinTeamInfo")
	public String getJoinTeamInfo(int id,Model model){
		JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(id);
		List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findthisjoinTeamPeople(id);
		
		model.addAttribute("joinMatchTeam", joinMatchTeam);
		model.addAttribute("joinMatchTeamPeoples", joinMatchTeamPeoples);
		
		
		return "getJoinTeamInfo";
	}
	@RequestMapping("getJoinTeamInfoInAllTeam")
	public String getJoinTeamInfoInAllTeam(int id,Model model){
		JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(id);
		List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findthisjoinTeamPeople(id);	
		model.addAttribute("joinMatchTeam", joinMatchTeam);
		model.addAttribute("joinMatchTeamPeoples", joinMatchTeamPeoples);	
		return "getJoinTeamInfoInAllTeam";
	}
	/**
	 * 在会员单位页面显示该单位的参加队伍
	 * 8.22更新内容-->将不符合的队伍也加进去
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("showMyJoinTeam")//8.22更新
	public String showMyJoinTeam(int id,Model model){
		//List<JoinMatchTeam> joinMatchTeams=  joinMatchTeamService.findMyTeamWhichIsYes(id);
		/*
		 * 9.27更新 ，更新内容： 所有该会员单位的报名队伍
		 */
		List<JoinMatchTeam> joinMatchTeams=joinMatchTeamService.findMyteamInthisMatch(id);
	model.addAttribute("joinMatchTeams", joinMatchTeams);
	return "showMyJoinTeam";
	}
	@RequestMapping("showMyTeamInfo")
	public String showMyTeamInfo(int id,Model model){
		JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(id);
		List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findthisjoinTeamPeople(id);
		
		model.addAttribute("joinMatchTeam", joinMatchTeam);
		model.addAttribute("joinMatchTeamPeoples", joinMatchTeamPeoples);
		return "showMyTeamInfo";
	}
	@RequestMapping("changeMyJoinTeam")
	public String changeMyJoinTeam(int id ,Model model){
		JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(id);
		
		List<JoinMatchTeamPeople> joinMatchTeamPeopless= joinMatchTeamPeopleService.findthisjoinTeamPeople(id);
		model.addAttribute("joinMatchTeam", joinMatchTeam);
		model.addAttribute("joinMatchTeamPeopless", joinMatchTeamPeopless);
		
		Match match=matchService.selectByPrimaryKey(joinMatchTeam.getMatchid());
		//将多余选项发送到容器里
		//获得本次比赛所有的参赛项目
				String thisMatchAllListInfo=match.getSupportlist();
				System.out.println("本次比赛所有的参赛项目id为：（合并显示）"+thisMatchAllListInfo);
				String[] thisMatchList=thisMatchAllListInfo.split(",");
				List<MatchList> thisMatchListInfo=new ArrayList<>();
				for (int i = 0; i < thisMatchList.length; i++) {
					System.out.println("本次比赛所有的参赛项目id为：（逐条显示）"+thisMatchList[i]);
					MatchList eveymatch=matchListService.selectByPrimaryKey(Integer.parseInt(thisMatchList[i]));
					thisMatchListInfo.add(eveymatch);
				}
				for (MatchList matchList : thisMatchListInfo) {
					System.out.println("本次比赛的所有参赛项目为："+matchList.getName());
				}
				//将本次比赛的所有参赛项目发送到页面
				model.addAttribute("allMatchLists", thisMatchListInfo);
		// 将职务发送到页面
				List<MatchJob> allMatchJobs = matchJobService.findAll();
				model.addAttribute("allMatchJobs", allMatchJobs);
//				// 将组别发送到页面
				List<MatchGroup> allMatchGroups = matchGroupService.findAll();
				model.addAttribute("allMatchGroups", allMatchGroups);
				int hxTeamId = joinMatchTeam.getBlongteam();
				// 将已交会费的会员发送到页面
				List<HxPeople> thisTeamPeoples = hxTeamService
						.findPeopleThisTeam(hxTeamId);
				System.out.println("该会员单位共有" + thisTeamPeoples.size() + "名会员");
				List<HxPeople> thisTeamPeopleWhoPay = hxTeamService
						.findPeopleThisTeamWhoPay(hxTeamId);

				if (thisTeamPeopleWhoPay.size() == 0) {
					System.out.println("没有会员交会费");
					return "noPeoplehasPay";
				}
				System.out.println("该会员单位共有" + thisTeamPeopleWhoPay.size() + "名已缴费会员");
				model.addAttribute("thisTeamPeoples", thisTeamPeopleWhoPay);
//				// 将比赛项目发送到此页面
//				List<MatchList> allMatchLists = matchListService.findAll();
//				model.addAttribute("allMatchLists", allMatchLists);

				List<IsNo> allIsNo = isNoService.findAll();
				model.addAttribute("allIsNo", allIsNo);
		return "changeMyJoinTeam";
	}
	
	@RequestMapping("changeSuccesss")
	public  String changeSuccess(int id,String prop1,String teamname,
			JoinMatchTeamPeopleList joinMatchTeamPeopleList, Model model){
		System.out.println("备注为："+prop1);
		System.out.println("队伍名称为："+teamname);
		//检查参数	
		System.out.println("开始检查参数====================================");
		System.out.println("获取到的id为："+id);
		System.out.println("获取到的备注为（prop1）："+prop1);
		System.out.println("获取到的参赛人员名单为："+joinMatchTeamPeopleList);
		//List<JoinMatchTeamPeople> checkList= joinMatchTeamPeopleList.getJoinMatchTeamPeople();
		//System.out.println("获取到的名单列表长度为："+checkList.size());
		//for (JoinMatchTeamPeople joinMatchTeamPeople : checkList) {
			//System.out.println("获取到的更改信息为："+joinMatchTeamPeople);
		//}
		System.out.println("检查结束========================================");
		//检查结束
			JoinMatchTeam joinMatchTeam = joinMatchTeamService
					.selectByPrimaryKey(id);//查看此比赛报名单
			String peopleId = "";
			System.out.println(joinMatchTeam.toString());
			List<JoinMatchTeamPeople> xx = joinMatchTeamPeopleList
					.getJoinMatchTeamPeople();//将页面上的所有人员添加入报名list中
			System.out.println("页面中的人员填入成功！！！===============");
			for (JoinMatchTeamPeople joinMatchTeamPeople : xx) {
				
				
				
				if (joinMatchTeamPeople.getPeopleid() != null) {
					System.out.println("报名成功的人：" + joinMatchTeamPeople);
					int jobId = joinMatchTeamPeople.getJob();
					MatchJob matchJob = matchJobService.selectByPrimaryKey(jobId);
					if (matchJob==null) {
						joinMatchTeamPeople.setJobname(matchJob.getOcc());// 将职务写入
					}else if(matchJob!=null){
						joinMatchTeamPeople.setJobname(matchJob.getOcc());// 将职务写入
					}
//					MatchGroup matchGroup=matchGroupService.selectByPrimaryKey(joinMatchTeamPeople.getGage());
//					if(matchGroup==null){
//						
//					}else if(matchGroup!=null){
//						joinMatchTeamPeople.s
//					}
					
					System.out.println("标记1，查看此处是否出错！！出现了说明没有出错");
					HxPeople hxPeople = hxPeopleService
							.selectByPrimaryKey(joinMatchTeamPeople.getPeopleid());
					joinMatchTeamPeople.setName(hxPeople.getName());// 将名字写入
					joinMatchTeamPeople.setPeoplegender(hxPeople.getGender());//性别写入
					joinMatchTeamPeople.setPeoplesn(hxPeople.getSn());//会员号写入
					MatchList matchList = matchListService
							.selectByPrimaryKey(joinMatchTeamPeople
									.getJoinmatchlist());
				if(matchList==null){
					//joinMatchTeamPeople.setJoinmatchlistinname("无");
				}else {
					joinMatchTeamPeople.setJoinmatchlistinname(matchList.getName());//将参加项目写入
				}
					joinMatchTeamPeople.setTeamid(joinMatchTeam.getBlongteam());//将会员单位的id写入
					
						
					
					joinMatchTeamPeople.setJoinwhichjointeam(joinMatchTeam.getId());//将 属于那个报名单写入
					//joinMatchTeamPeopleService.insertSelective(joinMatchTeamPeople);//写入数据库
					System.out.println("标记2，查看此处是否出错！！出现了说明没有出错");
					//检查数据
					System.out.println("开始执行数据检查");
					
					System.out.println("id="+joinMatchTeamPeople.getId());
					System.out.println("Isteammatchlist="+joinMatchTeamPeople.getIsteammatchlist());
					System.out.println("Jobname="+joinMatchTeamPeople.getJobname());
					System.out.println("Joinmatchlistinname="+joinMatchTeamPeople.getJoinmatchlistinname());
					System.out.println("Matchname="+joinMatchTeamPeople.getMatchname());
					System.out.println("getName="+joinMatchTeamPeople.getName());
					System.out.println("getPeoplegender="+joinMatchTeamPeople.getPeoplegender());
					System.out.println("getPeoplesn="+joinMatchTeamPeople.getPeoplesn());
					System.out.println("getPinlv="+joinMatchTeamPeople.getPinlv());
					System.out.println("getScore1="+joinMatchTeamPeople.getScore1());
					System.out.println("getScore2="+joinMatchTeamPeople.getScore2());
					System.out.println("getScore3="+joinMatchTeamPeople.getScore3());
					System.out.println("getTeamname="+joinMatchTeamPeople.getTeamname());
					System.out.println("getJob="+joinMatchTeamPeople.getJob());
					System.out.println("getJoinmatchlist="+joinMatchTeamPeople.getJoinmatchlist());
					System.out.println("getJoinwhichjointeam="+joinMatchTeamPeople.getJoinwhichjointeam());
					System.out.println("getMatchid="+joinMatchTeamPeople.getMatchid());
					System.out.println("getPeopleid="+joinMatchTeamPeople.getPeopleid());
					System.out.println("getTeamid="+joinMatchTeamPeople.getTeamid());
					
					
					System.out.println("检查结束");
					joinMatchTeamPeopleService.updateByPrimaryKey(joinMatchTeamPeople);//更新数据库
					System.out.println("标记3，查看此处是否出错！！出现了说明没有出错");
			//	List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findAll();
			
//					for (JoinMatchTeamPeople joinMatchTeamPeople2 : joinMatchTeamPeoples) {
//						//peopleId=peopleId+Integer.toString(joinMatchTeamPeople2.getId())+",";
//					}
				}
			}
			
			//System.out.println(peopleId);
			//joinMatchTeam.setPeopleid(peopleId);//将参加比赛人员id写入报名表
			System.out.println(joinMatchTeam.toString());
			joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
			joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(joinMatchTeam.getId());
			Match match=matchService.selectByPrimaryKey(joinMatchTeam.getMatchid());
			joinMatchTeam.setMatchname(match.getName());
			joinMatchTeam.setProp1(prop1);
			joinMatchTeam.setTeamname(teamname);
			joinMatchTeam.setIsconfirm(7); //设置报名表订单的状态为7，意义为  再次编辑待审核
			joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
			List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findthisjoinTeamPeople(joinMatchTeam.getId());		
			for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
				HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(joinMatchTeamPeople.getPeopleid());
				joinMatchTeamPeople.setPeoplegender(hxPeople.getGender());
				joinMatchTeamPeople.setMatchname(match.getName());
				joinMatchTeamPeopleService.updateByPrimaryKeySelective(joinMatchTeamPeople);
				System.out.println("本次比赛报名人的全部信息为："+joinMatchTeamPeople.toString());			
			}
			model.addAttribute("joinMatchTeam", joinMatchTeam);
			model.addAttribute("thisTeamjoinPeoples", joinMatchTeamPeoples);
			
		
		return "changeScuccess";
	}
	
	
	// 7.hx修改个人会员hsadkjhakubiianinisnaijnkninji 
			@RequestMapping("updateHxPeopleInHx")
			public String UpdateHxPeopleInHx(Model model, HxPeople hxPeople, boolean confirm,@RequestParam(value = "pn", defaultValue = "1") Integer pn) {

				if (confirm) {
					Date now = new Date();
					hxPeople.setEligibledat(now);
					hxPeople.setYearfeestatus(2);
				}

				Integer i = hxPeopleService.updateByPrimaryKeySelective(hxPeople);
				if (i != null) {
					hxPeople = hxPeopleService.selectByPrimaryKey(hxPeople.getId());
					model.addAttribute("hxPeople", hxPeople);
					int id=hxPeople.getBelongteam();
					
					
					return ShowTeamPeopleInHx(id, pn, model);
				}

				return "error";
			}	
	
	
	//
	
			// 8.显示该会员单位会员Inhx
			@RequestMapping("showTeamPeopleInHx")
			public String ShowTeamPeopleInHx(int id,
					@RequestParam(value = "pn", defaultValue = "1") Integer pn,
					Model model) {
				HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
				model.addAttribute("hxTeam", hxTeam);
				List<HxPeople> hxPeople = hxTeamService.findPeopleThisTeam(hxTeam
						.getId());
				PageHelper.startPage(pn, 100);
				PageInfo<HxPeople> page = new PageInfo<HxPeople>(hxPeople, 100);
				List<HxPeople> hxPeopleHasFeed = hxTeamService.findPeopleThisTeamWhoPay(id);
				int i = hxPeopleHasFeed.size();
				model.addAttribute("hxPeopleHasFeed", i);
				model.addAttribute("pageInfo", page);
				return "hxPeopleFromThisTeamInfoInhx";
			}
	
	// 8.显示该会员单位会员Inhx
	@RequestMapping("showTeamPeople")
	public String ShowTeamPeople(int id,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
		model.addAttribute("hxTeam", hxTeam);
		List<HxPeople> hxPeople = hxTeamService.findPeopleThisTeam(hxTeam
				.getId());
		PageHelper.startPage(pn, 100);
		PageInfo<HxPeople> page = new PageInfo<HxPeople>(hxPeople, 100);
		List<HxPeople> hxPeopleHasFeed = hxTeamService.findPeopleThisTeamWhoPay(id);
		int i = hxPeopleHasFeed.size();
		
		model.addAttribute("hxPeopleHasFeed", i);
		model.addAttribute("pageInfo", page);
		return "hxPeopleFromThisTeamInfo";
	}

	// 在会员单位页面显示该会员单位的会员

	/**
	 * 3.会员单位增加会员，自动生成会员号
	 * 
	 * @param model
	 * @param hxPeople
	 * @return
	 */
	@RequestMapping("addHxPeopleByHxTeam")
	public String addHxPeopleByTeam(Model model, HxPeople hxPeople,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		
		HxTeam thisTeam = hxTeamService.selectByPrimaryKey(hxPeople
				.getBelongteam());
		int id = 0;
		if (hxPeople != null) {
			int  certExistNum=hxPeopleService.findPeopleCertNumIsExist(hxPeople.getCertnumber());
		
			if (certExistNum>0) {
				return "certnumIsExist";
			}
			
			hxPeopleService.insertSelective(hxPeople);
		
			  hxPeople=hxPeopleService.findPeopleByCertNum(hxPeople.getCertnumber());
//			if(!((hxPeople.getCertnumber().length()==0 ||hxPeople.getCertnumber()==null)&&(hxPeople.getName().length()==0 ||hxPeople.getName()==null))){
//				System.out.println("通过名字和身份证号来查找此会员的id:"+"此会员的名字为："+hxPeople.getName()+"此会员的身份证号为："+hxPeople.getCertnumber());
//				
//				hxPeople = hxPeopleService.findPeopleByNameAndCertNum(hxPeople.getName(), hxPeople.getCertnumber());
//				System.out.println("此会员的id为："+hxPeople.getId());
//			}else if(!(hxPeople.getName().length()==0 ||hxPeople.getName()==null)){
//				System.out.println("通过名字和身份证号来查找此会员的id:"+"此会员的名字为："+hxPeople.getName());
//				hxPeople=hxPeopleService.findPeopleByName(hxPeople.getName());
//			}
						
			String city = hxPeople.getCity();
			DecideSn peopleSn = new DecideSn();
			String citySn = peopleSn.decidePeopleSn(city);
			hxPeople.setSn(citySn + hxPeople.getId());
			id = thisTeam.getId();
			hxPeople.setTeamname(thisTeam.getFullname());
			hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		}
		return ShowTeamPeople(id, pn, model);
	}
	@RequestMapping("HxDelPeopleToConfirm")
	public String toConfirmDel(int id, Model model){
		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute("hxPeople", hxPeople);
		return "HxDelPeopleToConfirm";
	}
	
	
	
	// 6.HX删除单个会员
	@RequestMapping("delHxPeople")
	public String deleteHxPeople(int id, Model model,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(hxPeople
				.getBelongteam());
		hxPeopleService.deleteByPrimaryKey(id);
		//return ShowTeamPeopleInHx(hxTeam.getId(), pn, model);
		return "redirect:/hxPeopleInfo";
	}
	@RequestMapping("delHxPeopleInHxInTeam")
	public String deleteHxPeopleInHxInTeam(int id, Model model,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(hxPeople
				.getBelongteam());
		hxPeopleService.deleteByPrimaryKey(id);
		return ShowTeamPeopleInHx(hxTeam.getId(), pn, model);
		//return "redirect:/hxPeopleInfo";
	}
	/**
	 * 1.1在会员单位页面显示本会员单位的详细信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("showTeamIntroduceByself")
	public String showDig(int id, Model model){
		model.addAttribute("hxTeam", hxTeamService.selectByPrimaryKey(id));
		return "showTeamIntroduceByself";
	}

	/**
	 * 1.3 显示简介
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("showTeamIntroduce")
	public String showDigInHx(int id, Model model) {
		model.addAttribute("hxTeam", hxTeamService.selectByPrimaryKey(id));
		return "showTeamIntroduce";
	}

	/**
	 * 航协页面，显示已交会费的会员单位
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toTeamHasPay")
	public String teamHasPay(Model model) {
		List<HxTeam> teamhasPay = hxTeamService.findWhofeed();

		model.addAttribute("teamhasPay", teamhasPay);
		return "teamHasPay";
	}

	/**
	 * 航协页面，显示未交会费的会员单位
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toTeamHasNoPay")
	public String teamHasNoPay(Model model) {
		List<HxTeam> allHxTeam = hxTeamService.findNotPay();
		model.addAttribute("allHxTeam", allHxTeam);
		int num = allHxTeam.size();
	
		return "teamHasNoPay";
	}

	/**
	 * 1.2在首页显示单个会员单位详细信息
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("showTeamIntroduceInIndex")
	public String showDigIndex(int id, Model model) {
		model.addAttribute("hxTeam", hxTeamService.selectByPrimaryKey(id));
		return "showTeamIntroduceInIndex";
	}

	/**
	 * 2.显示单个会员单位并修改
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("getHxTeam")
	public String getHxTeam(int id, Model model) {
		model.addAttribute("hxTeam", hxTeamService.selectByPrimaryKey(id));
		return "editHxTeam";
	}

	/**
	 * 2.1详细显示单个会员单位
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	// @RequestMapping("showaTeam")
	// public String showAHxTeam(int id, Model model) {
	// model.addAttribute("hxTeam", hxTeamService.selectByPrimaryKey(id));
	// return "showAHxTeam";
	// }

	/**
	 * 3.分页查询
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("hxTeamInfo")
	public String getHxTeam(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 50);
		List<HxTeam> hxTeams = hxTeamService.findAll();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxTeams, 10);
		model.addAttribute("pageInfo", page);
		// 显示为未付费的会员单位
		int num = 0;
		List<HxTeam> whoispay = hxTeamService.findWhofeed();
		// 给每一个付费的会员单位加一个标记 存入数据库
		for (HxTeam hxTeam : whoispay) {
			hxTeam.setStatus(2);
			hxTeamService.updateByPrimaryKeySelective(hxTeam);
		}
		num = whoispay.size();
		model.addAttribute("hxTeamHasFeed", num);
		return "allHxTeam";
	}

	/**
	 * 4.添加会员单位并重定向
	 * 
	 * @param model
	 * @param hxTeam
	 * @return
	 */
	@RequestMapping("addHxTeam")
	public String addHxTeam(Model model, HxTeam hxTeam) {
	
		int tSnNum;
		List<HxTeam> all = hxTeamService.findAll();
		tSnNum = all.size();
		if (hxTeam != null) {
			DecideSn decideHxTeamSn = new DecideSn();
			hxTeam.setSn(decideHxTeamSn.decideCitySN(hxTeam.getCity())
					+ hxTeam.getOrgtype() + (tSnNum + 100));
			hxTeamService.insertSelective(hxTeam);
			return "redirect:/hxTeamInfo";
		}
		return "/error";
	}

	/**
	 * 5.跳到会员单位添加页面
	 * 
	 * 
	 */
	@RequestMapping("toAddHxTeam")
	public String toAddHxTeam() {
		return "addHxTeam";
	}

	/**
	 * 6.会员单位修改会员单位
	 * 
	 * @param model
	 * @param hxTeam
	 * @return
	 */
	@RequestMapping("updateHxTeam")
	public String UpdateHxTeam(Model model, HxTeam hxTeam) {
		
		Integer i = hxTeamService.updateByPrimaryKeySelective(hxTeam);
		if (i != null) {
			hxTeam = hxTeamService.selectByPrimaryKey(hxTeam.getId());

			
			model.addAttribute("hxTeam", hxTeam);
			return "showTeamIntroduceByself";
		}
		return "/error";
	}
	/**
	 * 航协修改 会员单位
	 * 
	 * @param model
	 * @param hxTeam
	 * @return
	 */
	@RequestMapping("updateHxTeamByHx")
	public String UpdateHxTeamByHx(Model model, HxTeam hxTeam, boolean confirm) {

		if (confirm) {
			Date now = new Date();
			hxTeam.setEligibledat(now);
		}
		hxTeamService.updateByPrimaryKeySelective(hxTeam);
		HxTeam hxteamHasUpdate = hxTeamService.selectByPrimaryKey(hxTeam
				.getId());
		model.addAttribute("id", hxteamHasUpdate.getId());
		return "showTeamIntroduce";
	}
	/**
	 * 显示该会员单位的所有已交费会员
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("showPeopleThisTeamWhohasPay")
	public String showPeopleThisTeamWhohasPay(int id,Model model){
		List<HxPeople> thisTeamHxPeopleWhohasPay=hxTeamService.findPeopleThisTeamWhoPay(id);
		HxTeam hxTeam=hxTeamService.selectByPrimaryKey(id);
		model.addAttribute("hxTeam", hxTeam);
		model.addAttribute("thisTeamHxPeopleWhohasPay", thisTeamHxPeopleWhohasPay);
		return "thisTeamHxPeopleWhohasPay";
	}
	
	/**
	 * 显示该会员单位的所有已交费会员
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("showPeopleThisTeamWhohasNotPay")
	public String showPeopleThisTeamWhohasNotPay(int id,Model model){
		List<HxPeople> thisTeamHxPeopleWhohasNotPay=hxTeamService.findPeopleThisTeamWhoNotPay(id);
		HxTeam hxTeam=hxTeamService.selectByPrimaryKey(id);
		model.addAttribute("hxTeam", hxTeam);
		model.addAttribute("thisTeamHxPeopleWhohasNotPay", thisTeamHxPeopleWhohasNotPay);
		return "thisTeamHxPeopleWhohasNotPay";
	}
	
	

	/**
	 * 7.删除单个会员单位
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("delHxTeam")
	public String deleteHxTeam(int id, Model model) {
		model.addAttribute("hxTeam", hxTeamService.deleteByPrimaryKey(id));
		return "redirect:/hxTeamInfo";
	}

	@RequestMapping("todelConfirm")
	public String deleteHxTeamToCinfirm(int id,Model model){
HxTeam hxTeam=hxTeamService.selectByPrimaryKey(id);
model.addAttribute("hxTeam", hxTeam);
return "delToConfirm";
		
	}
	/**
	 * 8.显示飞行营地列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("flyTeam")
	public String showFlyTeam(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 10);
		List<HxTeam> hxFlyTeams = hxTeamService.findFlyTeam();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxFlyTeams, 10);
		//model.addAttribute("pageInfo", page);
		return "showFlyTeamList";
	}

	/**
	 * 9.航协页面下训练单位
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("trainTeam")
	public String showTrainTeam(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 10);
		List<HxTeam> hxTrainTeams = hxTeamService.findTrainTeam();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxTrainTeams, 10);
		//model.addAttribute("pageInfo", page);
		return "showTrainTeamList";
	}

	/**
	 * 10.所有会员单位
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("allTeams")
	public String showAllTeams(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 10);
		List<HxTeam> hxTeams = hxTeamService.findAll();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxTeams, 10);
		model.addAttribute("pageInfo", page);
		return "showAllTeams";
	}

	// 在首页展示查询
	/**
	 * 1.在首页查询训练单位
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("trainTeamIndex")
	public String showTrainTeamIndex(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 100);
		List<HxTeam> hxTrainTeams = hxTeamService.findTrainTeam();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxTrainTeams, 10);
		//model.addAttribute("pageInfo", page);

		return "showTrainTeamListInIndex";
	}

	/**
	 * 会员单位查询自己的缴费记录
	 * 
	 * @param id
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("showFeeRecovd")
	public String showFeeRecovd(int id,
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {

		PageHelper.startPage(pn, 100);
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);
		List<Fee> thisTeamFeeRecovd = feeService.findOldApply(id);
	
//		List<Fee> thisTeamFeePeopleRecovd=feeService.findAll();
//		for (Fee fee : thisTeamFeePeopleRecovd) {
//			HxPeople hxPeople =hxPeopleService.selectByPrimaryKey(fee.getPeople());
//			if (hxPeople.getBelongteam()!=id) {
//				
//			}
//		}
//		
		
		PageInfo<Fee> page = new PageInfo<Fee>(thisTeamFeeRecovd, 100);
		model.addAttribute("pageInfo", page);
		model.addAttribute("hxTeam", hxTeam);
		return "showFeeRecovd";
	}

	/**
	 * 2.在首页显示所有会员单位
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("allTeamsIndex")
	public String showAllTeamsIndex(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 100);
		List<HxTeam> hxTeams = hxTeamService.findAll();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxTeams, 100);
		model.addAttribute("pageInfo", page);
		return "showAllTeamsIndex";
	}

	/**
	 * 3.显示飞行营地列表
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("flyTeamIndex")
	public String showFlyTeamIndex(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 100);
		List<HxTeam> hxFlyTeams = hxTeamService.findFlyTeam();
		PageInfo<HxTeam> page = new PageInfo<HxTeam>(hxFlyTeams, 100);
		//model.addAttribute("pageInfo", page);

		return "showFlyTeamListInIndex";
	}



	/**
	 * 判断是否缴费
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("teamIsFee")
	public String teamIsFee(int id, Model model) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);// 查询该会员单位
	
		
		if (hxTeam.getEligibledat() == null) {
			if (hxTeam.getOrgtype().equals("Q")) {

				Fee fee = new Fee();
				Date today = new Date();
				fee.setAddtime(today);
				fee.setManager(hxTeam.getManagername());
				fee.setTeam(hxTeam.getId());
				fee.setFeetype(1);
				fee.setFeestatus(3);
				FeeType feeType = feeTypeService.selectByPrimaryKey(1);
				double thisPrice = feeType.getPrice();
				fee.setPrice(thisPrice);
				model.addAttribute("hxTeam", hxTeam);
				model.addAttribute("fee", fee);
				return "PreSendFeeToHx";// 跳转到准备缴费页面
			} else if (hxTeam.getOrgtype().equals("X")) {
				Fee fee = new Fee();
				Date today = new Date();
				fee.setAddtime(today);
				fee.setManager(hxTeam.getManagername());
				fee.setTeam(hxTeam.getId());
				fee.setFeetype(2);
				fee.setFeestatus(3);

				FeeType feeType = feeTypeService.selectByPrimaryKey(2);
				double thisPrice = feeType.getPrice();
				fee.setPrice(thisPrice);
				model.addAttribute("hxTeam", hxTeam);
				model.addAttribute("fee", fee);
				return "PreSendFeeToHx";// 跳转到准备缴费页面

			} else if (hxTeam.getOrgtype().equals("H")) {
				Fee fee = new Fee();
				Date today = new Date();
				fee.setAddtime(today);
				fee.setManager(hxTeam.getManagername());
				fee.setTeam(hxTeam.getId());
				fee.setFeetype(3);
				fee.setFeestatus(3);
				FeeType feeType = feeTypeService.selectByPrimaryKey(3);
				double thisPrice = feeType.getPrice();
				fee.setPrice(thisPrice);
				model.addAttribute("hxTeam", hxTeam);
				model.addAttribute("fee", fee);
				return "PreSendFeeToHx";// 跳转到准备缴费页面

			}
			return "meiyoudanweileixing";

		} else {
			Calendar now = Calendar.getInstance();
			int nowYear = now.get(Calendar.YEAR);
			Calendar teamFeeYear = Calendar.getInstance();
			teamFeeYear.setTime(hxTeam.getEligibledat());
			int teamFeeYearNum = teamFeeYear.get(Calendar.YEAR);
			if ((nowYear - teamFeeYearNum) > 0) {
				if (hxTeam.getOrgtype().equals("Q")) {

					Fee fee = new Fee();
					Date today = new Date();
					fee.setAddtime(today);
					fee.setManager(hxTeam.getManagername());
					fee.setTeam(hxTeam.getId());
					fee.setFeetype(1);
					fee.setFeestatus(3);
					fee.setTeamname(hxTeam.getFullname());
					FeeType feeType = feeTypeService.selectByPrimaryKey(1);
					double thisPrice = feeType.getPrice();
					fee.setPrice(thisPrice);
					model.addAttribute("hxTeam", hxTeam);
					model.addAttribute("fee", fee);
					return "PreSendFeeToHx";// 跳转到准备缴费页面
				} else if (hxTeam.getOrgtype().equals("X")) {
					Fee fee = new Fee();
					Date today = new Date();
					fee.setAddtime(today);
					fee.setManager(hxTeam.getManagername());
					fee.setTeam(hxTeam.getId());
					fee.setFeetype(2);
					fee.setFeestatus(3);
					fee.setTeamname(hxTeam.getFullname());
					FeeType feeType = feeTypeService.selectByPrimaryKey(2);
					double thisPrice = feeType.getPrice();
					fee.setPrice(thisPrice);
					model.addAttribute("hxTeam", hxTeam);
					model.addAttribute("fee", fee);
					return "PreSendFeeToHx";// 跳转到准备缴费页面
				} else if (hxTeam.getOrgtype().equals("H")) {
					Fee fee = new Fee();
					Date today = new Date();
					fee.setAddtime(today);
					fee.setManager(hxTeam.getManagername());
					fee.setTeam(hxTeam.getId());
					fee.setFeetype(3);
					fee.setFeestatus(3);
					fee.setTeamname(hxTeam.getFullname());
					FeeType feeType = feeTypeService.selectByPrimaryKey(3);
					double thisPrice = feeType.getPrice();
					fee.setPrice(thisPrice);
					model.addAttribute("hxTeam", hxTeam);
					model.addAttribute("fee", fee);
					return "PreSendFeeToHx";// 跳转到准备缴费页面
				}
				return "meiyoudanweileixing";
			} else if ((nowYear - teamFeeYearNum) > 1) {
				return "manyYearsHasNotPay";
			} else {

				return "hasPay";
			}
		}

	}

	/**
	 * 缴纳单位会费
	 * 
	 * @return
	 */
	@RequestMapping("payTeamYearFee")
	public String payFeeForTeam(int id, Model model) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);// 查询该会员单位

		// 执行缴费过程

		// 判断单位类型来赋予价格
		if (hxTeam.getOrgtype().equals("Q")) {// 如果是企业
			Fee fee = new Fee();
			Date today = new Date();
			fee.setAddtime(today);
			fee.setManager(hxTeam.getFullname());
			fee.setTeam(hxTeam.getId());
			fee.setFeetype(1);
			fee.setFeestatus(6);
			fee.setTeamname(hxTeam.getFullname());
			FeeType feeType = feeTypeService.selectByPrimaryKey(1);
			double thisPrice = feeType.getPrice();
			fee.setPrice(thisPrice);
			System.out.println("此企业发送给航协的完整订单为："+fee.toString());
			feeService.insert(fee);
			// fee.setId(id);
			model.addAttribute("hxTeam", hxTeam);
			model.addAttribute("fee", fee);// 将费用订单发送到会员单位页面
			return "messageIsYearFeeSuccess";
		} else if (hxTeam.getOrgtype().equals("X")) {// 如果是学校
			Fee fee = new Fee();
			Date today = new Date();
			fee.setAddtime(today);
			fee.setManager(hxTeam.getFullname());
			fee.setTeam(hxTeam.getId());
			fee.setFeetype(2);
			fee.setFeestatus(6);
			fee.setTeamname(hxTeam.getFullname());
			FeeType feeType = feeTypeService.selectByPrimaryKey(2);
			double thisPrice = feeType.getPrice();
			fee.setPrice(thisPrice);
			System.out.println("此学校发送给航协的完整订单为："+fee.toString());
			feeService.insert(fee);
			model.addAttribute("hxTeam", hxTeam);
			model.addAttribute("fee", fee);// 将价格发送到会员单位页面
			return "messageIsYearFeeSuccess";
		} else if (hxTeam.getOrgtype().equals("H")) {// 如果是协会
			Fee fee = new Fee();
			Date today = new Date();
			fee.setAddtime(today);
			fee.setManager(hxTeam.getFullname());
			fee.setTeam(hxTeam.getId());
			fee.setFeetype(3);
			fee.setFeestatus(6);
			fee.setTeamname(hxTeam.getFullname());
			FeeType feeType = feeTypeService.selectByPrimaryKey(3);
			double thisPrice = feeType.getPrice();
			fee.setPrice(thisPrice);
			System.out.println("此协会发送给航协的完整订单为："+fee.toString());
			feeService.insert(fee);
			model.addAttribute("hxTeam", hxTeam);
			model.addAttribute("fee", fee);// 将费用订单发送到会员单位页面

			return "messageIsYearFeeSuccess";

		} else {
			return "error";
		}

	}

	/**
	 * 跳转到peopleList
	 * 
	 * @return
	 */
	@RequestMapping("toPayYearFeeForPeople")
	public String toPayYearFeeForPeople(int id, Model model) {
		System.out.println(id);
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);// 查询该会员单位
		if (hxTeam.getEligibledat() == null) {
			model.addAttribute("hxTeam", hxTeam);
			return "hasNotPay";
		}
		Calendar now = Calendar.getInstance();
		int nowYear = now.get(Calendar.YEAR);
		Calendar teamFeeYear = Calendar.getInstance();
		teamFeeYear.setTime(hxTeam.getEligibledat());
		int teamFeeYearNum = teamFeeYear.get(Calendar.YEAR);
		if ((nowYear - teamFeeYearNum) <= 0) {// 判断该单位是否缴会费  成立的是已缴费的

			List<HxPeople> hxPeopleList=hxTeamService.findPeopleThisTeamWhoNotPay(id);
			
			if (hxPeopleList.isEmpty()) {
				
				return "noPeoplenNotfee";
			}
			
			model.addAttribute("hxPeopleList", hxPeopleList);
			model.addAttribute("hxTeam", hxTeam);
			return "showPeopleWhoNotPay";
	
		}
		model.addAttribute("hxTeam", hxTeam);
		return "hasNotPay";

	}

//			List<HxPeople> hxPeopleList = hxTeamService.findPeopleThisTeam(id);hxTeamInfo
//			if (hxPeopleList!=null) {
//				for (HxPeople hxPeople : hxPeopleList) {
//					System.out.println(hxPeople);
//				}
//				for (HxPeople hxPeople : hxPeopleList) {// 查找list中的每个会员
//					if (hxPeople.getEligibledat() != null) {
//						Calendar peopleFeeYear = Calendar.getInstance();
//						peopleFeeYear.setTime(hxPeople.getEligibledat());
//						int peopleFeeYearNum = peopleFeeYear.get(Calendar.YEAR);
//						System.out.println("该会员的会员到期时间是" + peopleFeeYearNum);
//						if ((nowYear - peopleFeeYearNum) <= 0) {// 将缴费的移出
//							hxPeopleList.remove(hxPeople);
//						}
//					}
//				}
//				if (hxPeopleList!=null) {
//					model.addAttribute("hxPeopleList", hxPeopleList);// 发送到该页面
//					model.addAttribute("hxTeam", hxTeam);
//					return "showPeopleWhoNotPay";
//				}
//				
////				model.addAttribute("hxTeam", hxTeam);
//				return "noPeoplenNotfee";
//			}else{
//				return "noPeople";
//			}
//			
//		} else {
//			model.addAttribute("hxTeam", hxTeam);
//			return "hasNotPay";
		
	

	////这点有问题
	
	//根据会员获得价格
	public Fee price(HxPeople hxPeople){
		
		Date now=new Date();
		Fee fee=new Fee();
	
		if (hxPeople.getAge()>18) {
			fee.setPeople(hxPeople.getId());
			fee.setFeetype(5);
			fee.setFeestatus(3);
			//fee.setFeedieline(hxPeople.getCertnumber());//6.4更新
			//fee.setTeamname(hxPeople.getTeamname());//6.4更新
			FeeType feeType = feeTypeService.selectByPrimaryKey(5);
			fee.setAddtime(now);
			fee.setPeoplename(hxPeople.getName());
			HxTeam hxTeam=hxTeamService.selectByPrimaryKey(hxPeople.getBelongteam());
			fee.setManager(hxTeam.getFullname());
			fee.setPrice(feeType.getPrice());
			feeService.insertSelective(fee);
			System.out.println("该会员应该费用类型为："+fee.getFeetype()+"应该缴纳："+fee.getPrice());
			return fee;
		}else if(hxPeople.getAge()<=18){
			fee.setPeople(hxPeople.getId());
			fee.setFeetype(4);
			fee.setFeestatus(3);
			//fee.setFeedieline(hxPeople.getCertnumber());//6.4更新		
			//fee.setTeamname(hxPeople.getTeamname());//6.4更新
			FeeType feeType = feeTypeService.selectByPrimaryKey(4);
			fee.setAddtime(now);
			HxTeam hxTeam=hxTeamService.selectByPrimaryKey(hxPeople.getBelongteam());
			fee.setManager(hxTeam.getFullname());
			fee.setPrice(feeType.getPrice());
			fee.setPeoplename(hxPeople.getName());
			feeService.insertSelective(fee);
			System.out.println("该会员应该费用类型为："+fee.getFeetype()+"应该缴纳："+fee.getPrice());
			return fee;
		}
		return fee;
	}
	
	
	
	
	
	/**
	 * 给会员交费
	 * @param peopleList
	 * @param model
	 * @return
	 */
	@RequestMapping("topayYearFeeForPeopleAgain")
	public String payFeeforPeople(String peopleList, Model model){
		double price=0;
		System.out.println(peopleList);
		List<HxPeople> hxPeoplelist= new ArrayList<HxPeople>();
		List<Fee> temFee=new ArrayList<Fee>();
		if (peopleList.contains(",")) {
		String[] people=peopleList.split(",");
			for (int i = 0; i < people.length; i++) {
				HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(Integer.parseInt(people[i]));
				System.out.println(hxPeople);
				hxPeoplelist.add(hxPeople);
				Fee thisPeoplefee=price(hxPeople);
				price+=thisPeoplefee.getPrice();			
				System.out.println("循环中的价格为"+price);
			}
			for (HxPeople hxPeople : hxPeoplelist) {
				System.out.println("会员单位准备给这个人交会费："+hxPeople);
			}
		model.addAttribute("price", price);	
		model.addAttribute("hxPeoplelist", hxPeoplelist);
		model.addAttribute("peopleList", peopleList);
			return "sendhxPeopleListToHx";
		}else if(peopleList.isEmpty()){
		return "noONeSelected";
		}
		int xd=Integer.parseInt(peopleList);
		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(xd);
		Fee thisPeoplefee=price(hxPeople);
		price=thisPeoplefee.getPrice();
		hxPeoplelist.add(hxPeople);
		model.addAttribute("price", price);	
		model.addAttribute("hxPeoplelist", hxPeoplelist);	
		model.addAttribute("peopleList", peopleList);
		return "sendhxPeopleListToHx";
	}
	/**
	 * 给会员提交成功
	 * @return
	 */
	@RequestMapping("messageIsYearFeeSuccessforPeople")
	public String confirmToHx(String peopleList,Model model){
//		List<HxPeople> thisHxPeoplesFormThisTeamWhoIsProToSendHx=feeService.findThisTeamPeopleWhoIsProToSendHx();
//		for (HxPeople hxPeople : thisHxPeoplesFormThisTeamWhoIsProToSendHx) {
//			if (hxPeople.getBelongteam()!=id) {
//				thisHxPeoplesFormThisTeamWhoIsProToSendHx.remove(hxPeople);
//			}
//		}
//		List<HxPeople> hxPeoplelist= new ArrayList<HxPeople>();
//		if (peopleList.contains(",")) {
//			String[] people=peopleList.split(",");
//			for (int i = 0; i < people.length; i++) {
//				HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(Integer.parseInt(people[i]));
//				List<Fee> temFee=feeService.findFeeByPeopleId(Integer.parseInt(people[i]));
//				hxPeoplelist.add(hxPeople);
//				
//				
//			}
//			
//		
//		
//		}
		double price=0;
		System.out.println(peopleList);
		List<HxPeople> hxPeoplelist= new ArrayList<HxPeople>();
		Date now =new Date();
		if (peopleList.contains(",")) {
		String[] people=peopleList.split(",");
			for (int i = 0; i < people.length; i++) {
				HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(Integer.parseInt(people[i]));
				System.out.println(hxPeople);
				hxPeoplelist.add(hxPeople);
				Fee thisPeoplefee=price(hxPeople);
				price+=thisPeoplefee.getPrice();
				thisPeoplefee.setAddtime(now);
				thisPeoplefee.setFeestatus(6);
				feeService.insertSelective(thisPeoplefee);
				System.out.println("循环中的价格为"+price);
			}
			for (HxPeople hxPeople : hxPeoplelist) {
				System.out.println("会员单位准备给这个人交会费："+hxPeople);
			}
		model.addAttribute("price", price);	
		model.addAttribute("hxPeoplelist", hxPeoplelist);
			return "messageIsYearFeeSuccessforPeople";
		}else if(peopleList.isEmpty()){
		return "noONeSelected";
		}
		int xd=Integer.parseInt(peopleList);
		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(xd);
		Fee thisPeoplefee=price(hxPeople);
		price=thisPeoplefee.getPrice();
		thisPeoplefee.setAddtime(now);
		thisPeoplefee.setFeestatus(6);
		feeService.insertSelective(thisPeoplefee);
		hxPeoplelist.add(hxPeople);
		model.addAttribute("price", price);	
		model.addAttribute("hxPeoplelist", hxPeoplelist);	
		return "messageIsYearFeeSuccessforPeople";
	}
	
//	
//	/**
//	 * 给会员交会费
//	 * 
//	 * @param model
//	 * @return
//	 */
//	@SuppressWarnings("null")
//	@RequestMapping("payYearFeeForPeople")
//	public String payYearFeeForPeople(String peopleList, Model model) {
//		double price = 0;
//		
//		System.out.println(peopleList);
//	if (peopleList.contains(",")) {
//		//多个会员
//		List<HxPeople> hxPeoplelist=null;
//	String[] peopleArr=	peopleList.split(",");
//	for (int i = 0; i < peopleArr.length; i++) {
//		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(Integer.parseInt(peopleArr[i]));
//		if ((!(hxPeople.getCertnumber()==null))&&(hxPeople.getCertnumber().length() == 18)) {
//
//			String x = hxPeople.getCertnumber().substring(6, 10);
//			int birthYear = Integer.parseInt(x);
//			Calendar now = Calendar.getInstance();
//			int nowYear = now.get(Calendar.YEAR);
//			int age = nowYear - birthYear;
//			if (age > 18) {// 根据年龄来判断会费
//				Fee fee = new Fee();
//				fee.setPeople(hxPeople.getId());
//				fee.setFeetype(5);
//				fee.setFeestatus(3);
//				FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//				price += feeType.getPrice();
//				
//				} else {
//						Fee fee = new Fee();
//						fee.setPeople(hxPeople.getId());
//						fee.setFeetype(4);
//						fee.setFeestatus(3);
//						FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//						price += feeType.getPrice();
//						
//						}	
//		}else if(!(hxPeople.getBirthday()==null)){
//			
//			Calendar now = Calendar.getInstance();
//			int nowYear = now.get(Calendar.YEAR);
//			Calendar peopleBirthDate = Calendar.getInstance();
//			peopleBirthDate.setTime(hxPeople.getBirthday());
//			int peopleBirthYear = peopleBirthDate.get(Calendar.YEAR);
//			if ((nowYear - peopleBirthYear) > 18) {// 根据年龄来判断会费
//				Fee fee = new Fee();
//				fee.setPeople(hxPeople.getId());
//				fee.setFeetype(5);
//				fee.setFeestatus(3);
//				FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//				price += feeType.getPrice();
//				
//				
//				
//			} else {
//				Fee fee = new Fee();
//				fee.setPeople(hxPeople.getId());
//				fee.setFeetype(4);
//				fee.setFeestatus(3);
//				FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//				price += feeType.getPrice();
//				
//				
//				
//			}
//			
//			
//		}
//		
//		
//		
//		
//		
//		hxPeoplelist.add(hxPeople);
//	}
//	System.out.println(price);
//	model.addAttribute("price", price);	
//	model.addAttribute("hxPeoplelist", hxPeoplelist);				
//	return "sendhxPeopleListToHx";
//		
//		
//	}else if(peopleList==""){
//		//没有会员
//	
//		return "noONeSelected";
//	
//	
//	
//	}		
//		
//		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(Integer.parseInt(peopleList));
//		List<HxPeople> hxPeoplelist=null;
//		if ((!(hxPeople.getCertnumber()==null))&&(hxPeople.getCertnumber().length() == 18)) {
//
//			String x = hxPeople.getCertnumber().substring(6, 10);
//			int birthYear = Integer.parseInt(x);
//			Calendar now = Calendar.getInstance();
//			int nowYear = now.get(Calendar.YEAR);
//			int age = nowYear - birthYear;
//			if (age > 18) {// 根据年龄来判断会费
//				Fee fee = new Fee();
//				fee.setPeople(hxPeople.getId());
//				fee.setFeetype(5);
//				fee.setFeestatus(3);
//				FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//				price = feeType.getPrice();
//				model.addAttribute("price", price);
//				hxPeoplelist.add(hxPeople);
//				model.addAttribute("hxPeoplelist", hxPeoplelist);				
//				return "sendhxPeopleListToHx";
//				} else {
//						Fee fee = new Fee();
//						fee.setPeople(hxPeople.getId());
//						fee.setFeetype(4);
//						fee.setFeestatus(3);
//						FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//						price = feeType.getPrice();
//						model.addAttribute("price", price);
//						hxPeoplelist.add(hxPeople);
//						model.addAttribute("hxPeoplelist", hxPeoplelist);				
//						return "sendhxPeopleListToHx";
//						}	
//		}else if(!(hxPeople.getBirthday()==null)){
//			
//			Calendar now = Calendar.getInstance();
//			int nowYear = now.get(Calendar.YEAR);
//			Calendar peopleBirthDate = Calendar.getInstance();
//			peopleBirthDate.setTime(hxPeople.getBirthday());
//			int peopleBirthYear = peopleBirthDate.get(Calendar.YEAR);
//			if ((nowYear - peopleBirthYear) > 18) {// 根据年龄来判断会费
//				Fee fee = new Fee();
//				fee.setPeople(hxPeople.getId());
//				fee.setFeetype(5);
//				fee.setFeestatus(3);
//				FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//				price = feeType.getPrice();
//				model.addAttribute("price", price);
//				hxPeoplelist.add(hxPeople);
//				model.addAttribute("hxPeoplelist", hxPeoplelist);				
//				return "sendhxPeopleListToHx";
//			} else {
//				Fee fee = new Fee();
//				fee.setPeople(hxPeople.getId());
//				fee.setFeetype(4);
//				fee.setFeestatus(3);
//				FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//				price = feeType.getPrice();
//				model.addAttribute("price", price);
//				hxPeoplelist.add(hxPeople);
//				model.addAttribute("hxPeoplelist", hxPeoplelist);				
//				return "sendhxPeopleListToHx";
//			}
//			
//			
//		}
//	return "请联系航协";
//	
	
	//单个会员
	
	//}
		
//		if (peopleList.contains(",")) {
//			String[] peopleArgs=peopleList.split(",");
//			for (int i = 0; i < peopleArgs.length; i++){//循环找会员
//				HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(Integer.parseInt(peopleArgs[i]));
//				List<HxPeople> hxPeoplelist=null;
//				if (hxPeople.getCertnumber().length() == 18) {
//																String x = hxPeople.getCertnumber().substring(6, 10);
//																int birthYear = Integer.parseInt(x);
//																Calendar now = Calendar.getInstance();
//																int nowYear = now.get(Calendar.YEAR);
//																int age = nowYear - birthYear;
//																if (age > 18) {// 根据年龄来判断会费
//																				Fee fee = new Fee();
//																				fee.setPeople(hxPeople.getId());
//																				fee.setFeetype(5);
//																				fee.setFeestatus(3);
//																				FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//																				price += feeType.getPrice();
//																				} else {
//																						Fee fee = new Fee();
//																						fee.setPeople(hxPeople.getId());
//																						fee.setFeetype(4);
//																						fee.setFeestatus(3);
//																						FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//																						price += feeType.getPrice();
//																						}											
//																}else{
//																		
//																		Calendar now = Calendar.getInstance();
//																		int nowYear = now.get(Calendar.YEAR);
//																		Calendar peopleBirthDate = Calendar.getInstance();
//																		peopleBirthDate.setTime(hxPeople.getBirthday());
//																		int peopleBirthYear = peopleBirthDate.get(Calendar.YEAR);
//																		if ((nowYear - peopleBirthYear) > 18) {// 根据年龄来判断会费
//																			Fee fee = new Fee();
//																			fee.setPeople(hxPeople.getId());
//																			fee.setFeetype(5);
//																			fee.setFeestatus(3);
//																			FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//																			price += feeType.getPrice();
//																		} else {
//																			Fee fee = new Fee();
//																			fee.setPeople(hxPeople.getId());
//																			fee.setFeetype(4);
//																			fee.setFeestatus(3);
//																			FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//																			price += feeType.getPrice();
//																		}
//																	
//																	
//																	
//																	}
//																		
//																		
//																		
//																		
//																		
//																	}
//																	model.addAttribute("price", price);
//																	model.addAttribute("list", hxPeoplelist);
//																	return "sendhxPeopleListToHx";
																	
			
//		}else{}
//		
//		
//		 {
//			
//		if (HxPeople.) {
//			
//		}
//		
//		
//		}
//		
		
//		List<HxPeople> hxPeoplelist=null;
//		for (HxPeople hxPeople : hxPeoplelist) {
//			if () {
//				String i = hxPeople.getCertnumber().substring(6, 10);
//				int birthYear = Integer.parseInt(i);
//				Calendar now = Calendar.getInstance();
//				int nowYear = now.get(Calendar.YEAR);
//				int age = nowYear - birthYear;
//				if (age > 18) {// 根据年龄来判断会费
//					Fee fee = new Fee();
//					fee.setPeople(hxPeople.getId());
//					fee.setFeetype(5);
//					fee.setFeestatus(3);
//					FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//					price += feeType.getPrice();
//				} else {
//					Fee fee = new Fee();
//					fee.setPeople(hxPeople.getId());
//					fee.setFeetype(4);
//					fee.setFeestatus(3);
//					FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//					price += feeType.getPrice();
//				}
//			} else {
//				Calendar now = Calendar.getInstance();
//				int nowYear = now.get(Calendar.YEAR);
//				Calendar peopleBirthDate = Calendar.getInstance();
//				peopleBirthDate.setTime(hxPeople.getBirthday());
//				int peopleBirthYear = peopleBirthDate.get(Calendar.YEAR);
//				if ((nowYear - peopleBirthYear) > 18) {// 根据年龄来判断会费
//					Fee fee = new Fee();
//					fee.setPeople(hxPeople.getId());
//					fee.setFeetype(5);
//					fee.setFeestatus(3);
//					FeeType feeType = feeTypeService.selectByPrimaryKey(5);
//					price += feeType.getPrice();
//				} else {
//					Fee fee = new Fee();
//					fee.setPeople(hxPeople.getId());
//					fee.setFeetype(4);
//					fee.setFeestatus(3);
//					FeeType feeType = feeTypeService.selectByPrimaryKey(4);
//					price += feeType.getPrice();
//				}
//			}
//		}
//		model.addAttribute("price", price);
//		model.addAttribute("list", hxPeoplelist);
//		return "sendhxPeopleListToHx";
	//}

	// 跳转到报名赛事并判断是否缴纳会费
	@RequestMapping("toJoinMatch")
	public String toJoinMatch(Model model, int id) {
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(id);

		
		
	

		if (hxTeam.getStatus()!=2 ) {
			model.addAttribute("hxTeam", hxTeam);
			return "hasNotPay";
		}
		
		List<Match> allMatchs=matchService.findAll();
		if(allMatchs.size()==0){
			return "noMatch";
		}
		
		model.addAttribute("allMatchs", allMatchs);
		model.addAttribute("hxTeam", hxTeam);
		return "joinMatch";
	}

	// 执行报名操作(加入 队伍名称，会员单位id,会员单位名称),跳转到添加成员页面
	@RequestMapping("addJoinMatchTeamButton")
	public String joinMatch(JoinMatchTeam joinMatchTeam, Model model) {
		
		System.out.println("在报名赛事页面，获取到的报名单为："+joinMatchTeam.toString());
		System.out.println("TeamName"+joinMatchTeam.getTeamname());
		joinMatchTeam.setIsconfirm(3);
		joinMatchTeamService.insertSelective(joinMatchTeam);
		Match match=matchService.selectByPrimaryKey(joinMatchTeam.getMatchid());
		joinMatchTeam.setMatchname(match.getName());
		joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
		joinMatchTeamService.selectByPrimaryKey(joinMatchTeam.getId());
		System.out.println("完善后的报名信息为："+joinMatchTeam.toString());
		List<JoinMatchTeam> allJoinMatchTeams = joinMatchTeamService.findAll();
		int id = 0;
		for (JoinMatchTeam joinMatchTeam2 : allJoinMatchTeams) {
			System.out.println("TeamName"+joinMatchTeam2.getTeamname());
			System.out.println("TeamName"+joinMatchTeam.getTeamname());
			if (joinMatchTeam2.getTeamname()
					.equals(joinMatchTeam.getTeamname())
					&& joinMatchTeam2.getBlongteam().equals(
							joinMatchTeam.getBlongteam())
					&& joinMatchTeam2.getBlongteamname().equals(
							joinMatchTeam.getBlongteamname())) {
				id = joinMatchTeam2.getId();
			}
		}
		joinMatchTeam = joinMatchTeamService.selectByPrimaryKey(id);
		System.out.println("报名单的详情为："+joinMatchTeam);
		//获得本次比赛所有的参赛项目
		String thisMatchAllListInfo=match.getSupportlist();
		System.out.println("本次比赛所有的参赛项目id为：（合并显示）"+thisMatchAllListInfo);
		String[] thisMatchList=thisMatchAllListInfo.split(",");
		List<MatchList> thisMatchListInfo=new ArrayList<>();
		for (int i = 0; i < thisMatchList.length; i++) {
			System.out.println("本次比赛所有的参赛项目id为：（逐条显示）"+thisMatchList[i]);
			MatchList eveymatch=matchListService.selectByPrimaryKey(Integer.parseInt(thisMatchList[i]));
			thisMatchListInfo.add(eveymatch);
		}
		for (MatchList matchList : thisMatchListInfo) {
			System.out.println("本次比赛的所有参赛项目为："+matchList.getName());
		}
		//将本次比赛的所有参赛项目发送到页面
		model.addAttribute("allMatchLists", thisMatchListInfo);
		//获得本次比赛所有的组别
		String thisMatchAllGroupInfo=match.getSupportgroup();
		System.out.println("本次比赛所有的参赛组别id为：（合并显示）"+thisMatchAllGroupInfo);
		String[] thisMatchGroup=thisMatchAllGroupInfo.split(",");
		List<MatchGroup> thisMatchGroupInfo=new ArrayList<>();
		for (int i = 0; i < thisMatchGroup.length; i++) {
			System.out.println("本次比赛所有的参赛组别id为：（逐条显示）"+thisMatchGroup[i]);
			MatchGroup everymatchGroup=matchGroupService.selectByPrimaryKey(Integer.parseInt(thisMatchGroup[i]));
			thisMatchGroupInfo.add(everymatchGroup);
		}
		for (MatchGroup matchGroup : thisMatchGroupInfo) {
			System.out.println("本次比赛的所有参赛组别为："+matchGroup.getGroupage());
		}
		//将本次比赛的所有参赛组别发送到页面
		model.addAttribute("allMatchGroups", thisMatchGroupInfo);
		
		
		
		// 将报名单发送到页面
		model.addAttribute("joinMatchTeam", joinMatchTeam);
		// 将职务发送到页面
		List<MatchJob> allMatchJobs = matchJobService.findAll();
		model.addAttribute("allMatchJobs", allMatchJobs);
//		// 将组别发送到页面
//		List<MatchGroup> allMatchGroups = matchGroupService.findAll();
//		model.addAttribute("allMatchGroups", allMatchGroups);
		int hxTeamId = joinMatchTeam.getBlongteam();
		// 将已交会费的会员发送到页面
		List<HxPeople> thisTeamPeoples = hxTeamService
				.findPeopleThisTeam(hxTeamId);
		System.out.println("该会员单位共有" + thisTeamPeoples.size() + "名会员");
		List<HxPeople> thisTeamPeopleWhoPay = hxTeamService
				.findPeopleThisTeamWhoPay(hxTeamId);

		if (thisTeamPeopleWhoPay.size() == 0) {
			System.out.println("没有会员交会费");
			return "noPeoplehasPay";
		}
		System.out.println("该会员单位共有" + thisTeamPeopleWhoPay.size() + "名已缴费会员");
		model.addAttribute("thisTeamPeoples", thisTeamPeopleWhoPay);
//		// 将比赛项目发送到此页面
//		List<MatchList> allMatchLists = matchListService.findAll();
//		model.addAttribute("allMatchLists", allMatchLists);

		List<IsNo> allIsNo = isNoService.findAll();
		model.addAttribute("allIsNo", allIsNo);
		return "joinMatchToAddPeople";
	}

	// 接受报名人员并转向预览页面
	@RequestMapping("joinMatchInfoShowButton")
	public String joinMatchInfoShow(int id,String prop1,
			JoinMatchTeamPeopleList joinMatchTeamPeopleList, Model model) {
		
		System.out.println("备注为："+prop1);
		
		JoinMatchTeam joinMatchTeam = joinMatchTeamService
				.selectByPrimaryKey(id);//查看此比赛报名单
		String peopleId = "";
		System.out.println(joinMatchTeam.toString());
		List<JoinMatchTeamPeople> xx = joinMatchTeamPeopleList
				.getJoinMatchTeamPeople();//将页面上的所有人员添加入报名list中
		for (JoinMatchTeamPeople joinMatchTeamPeople : xx) {
			if (joinMatchTeamPeople.getPeopleid() != null) {
				System.out.println("报名成功的人：" + joinMatchTeamPeople);
				int jobId = joinMatchTeamPeople.getJob();
				MatchJob matchJob = matchJobService.selectByPrimaryKey(jobId);
				if (matchJob==null) {
					//joinMatchTeamPeople.setJobname(matchJob.getOcc());// 将职务写入
				}else if(matchJob!=null){
					joinMatchTeamPeople.setJobname(matchJob.getOcc());// 将职务写入
				}
//				MatchGroup matchGroup=matchGroupService.selectByPrimaryKey(joinMatchTeamPeople.getGage());
//				if(matchGroup==null){
//					
//				}else if(matchGroup!=null){
//					joinMatchTeamPeople.s
//				}
				
				
				HxPeople hxPeople = hxPeopleService
						.selectByPrimaryKey(joinMatchTeamPeople.getPeopleid());
				joinMatchTeamPeople.setName(hxPeople.getName());// 将名字写入
				joinMatchTeamPeople.setPeoplegender(hxPeople.getGender());//性别写入
				joinMatchTeamPeople.setPeoplesn(hxPeople.getSn());//会员号写入
				MatchList matchList = matchListService
						.selectByPrimaryKey(joinMatchTeamPeople
								.getJoinmatchlist());
			if(matchList==null){
				//joinMatchTeamPeople.setJoinmatchlistinname("无");
			}else {
				joinMatchTeamPeople.setJoinmatchlistinname(matchList.getName());//将参加项目写入
			}
				joinMatchTeamPeople.setTeamid(joinMatchTeam.getBlongteam());//将会员单位的id写入
				
					
				
				joinMatchTeamPeople.setJoinwhichjointeam(joinMatchTeam.getId());//将 属于那个报名单写入
				joinMatchTeamPeopleService.insertSelective(joinMatchTeamPeople);//写入数据库
		//	List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findAll();
				
//				for (JoinMatchTeamPeople joinMatchTeamPeople2 : joinMatchTeamPeoples) {
//					//peopleId=peopleId+Integer.toString(joinMatchTeamPeople2.getId())+",";
//				}
			}
		}
		
		//System.out.println(peopleId);
		//joinMatchTeam.setPeopleid(peopleId);//将参加比赛人员id写入报名表
		System.out.println(joinMatchTeam.toString());
		joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
		joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(joinMatchTeam.getId());
		Match match=matchService.selectByPrimaryKey(joinMatchTeam.getMatchid());
		joinMatchTeam.setMatchname(match.getName());
		joinMatchTeam.setProp1(prop1);
	//	joinMatchTeam.setIsconfirm(1); //设置报名表订单的状态为1
		joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
		List<JoinMatchTeamPeople> joinMatchTeamPeoples=joinMatchTeamPeopleService.findthisjoinTeamPeople(joinMatchTeam.getId());		
		for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
			HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(joinMatchTeamPeople.getPeopleid());
			joinMatchTeamPeople.setPeoplegender(hxPeople.getGender());
			joinMatchTeamPeople.setMatchname(match.getName());
			joinMatchTeamPeopleService.updateByPrimaryKeySelective(joinMatchTeamPeople);
			System.out.println("本次比赛报名人的全部信息为："+joinMatchTeamPeople.toString());			
		}
		model.addAttribute("joinMatchTeam", joinMatchTeam);
		model.addAttribute("thisTeamjoinPeoples", joinMatchTeamPeoples);
		return "joinInfo";
	}
	
	@RequestMapping("showjoinInfoButton")
	public String showjoinInfo(int id) {
		JoinMatchTeam joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(id);
		Date now =new Date();
		joinMatchTeam.setAddtime(now);
		joinMatchTeam.setIsconfirm(1);
		joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
		return "ToHX";
	}
	
//	
//	public String showMyTeamAllPeopleWhoArePayToHxToConfirm(Model model){
//		
//		
//		
//	}
////展示并提交
//	@RequestMapping("showjoinInfoButton")
//	public String showjoinInfo(JoinMatchTeam joinMatchTeam,Model model) {
//		Date now =new Date();
//		joinMatchTeam.setAddtime(now);
//		joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
//		joinMatchTeam=joinMatchTeamService.selectByPrimaryKey(joinMatchTeam.getId());
//		String peoplelist=joinMatchTeam.getPeopleid();
//		if (peoplelist.contains(",")) {
//			String[] joinPeopleList=peoplelist.split(",");
//			
//			for (int i = 0; i < joinPeopleList.length; i++) {
//				
//			}
//		}else if(peoplelist.length()<0){
//			
//			return "noPeopleInThisTeamJoinThisMatch";
//		}
//		
//		JoinMatchTeamPeople  joinMatchTeamPeople =  joinMatchTeamPeopleService.selectByPrimaryKey(Integer.parseInt(peoplelist));
//		
//		
//		
//		model.addAttribute("joinMatchTeam", joinMatchTeam);
//			
//		return "redayToHX";
//	}

	// 参加比赛第三步
	public String joinMatchThirdStep() {

		return "joinMatchfourthStep";
	}

	// 判断比赛是否参加成功（由航协判断）
	public String isJoinMatch() {
		if (true) {
			return "succes";
		}
		return "fail";
	}
}