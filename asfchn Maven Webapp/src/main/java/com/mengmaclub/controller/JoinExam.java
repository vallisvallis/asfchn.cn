package com.mengmaclub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.servlet.support.RequestContext;

import com.mengmaclub.model.Fee;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.JoinExamPeople;
import com.mengmaclub.service.HxPeopleService;
import com.mengmaclub.service.JoinExamPeopleService;



@Controller
@RequestMapping("/")
public class JoinExam {

		
	//开放个人权限（仅有报名比赛的人才能报）✔
	//开放报名入口✔
	//报名界面 选填信息✔
	//报名信息记录✔
	//缴费✔
	//报名成功----报名失败✔
	//生成名单✔
	//证书×
	//秩序册✔
	//成绩册✔
	//比赛项目✔
	@Autowired
	private HxPeopleService hxPeopleService;
	@Autowired
	private JoinExamPeopleService joinExamPeopleService;
	
	@RequestMapping("toJoinExam")//个人页面参加考试
	public String toJoinExam(int id,Model model){
		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute("hxPeople", hxPeople);
		return "toJoinExam";
	}
	
	@RequestMapping("joinExam")
	public String joinExam(String examtype,String examtypelevel,int id,Model model){
		System.out.println(id);
		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(id);
		JoinExamPeople joinExamPeople = new JoinExamPeople();
		joinExamPeople.setName(hxPeople.getName());
		joinExamPeople.setPeoplesn(hxPeople.getSn());
		joinExamPeople.setExamtype(examtype);
		joinExamPeople.setExamtypelevel(examtypelevel);
		joinExamPeople.setTeamid(hxPeople.getBelongteam());
		/*
		 * 考试费用状态：
		 * 0：未交
		 * 1：已交待确认
		 * 2：已交已确认
		 * 
		 */
		joinExamPeople.setFeestatus(0);
		joinExamPeopleService.insert(joinExamPeople);
//		if (examtypelevel.contains(",")) {
//			examtypelevelargs=examtypelevel.split(",");
//		}
	//	int levelNum=examtypelevelargs.length;
		
//		int examFee=300;
//		if (levelNum==2) {
//			examFee=600;
//		}else if(levelNum==3){
//			examFee=900;
//		}
		
		int examFee=300;
		if (hxPeople.getAge()<18) {
			examFee=examFee/2;
		}
		joinExamPeople=joinExamPeopleService.findBySn(joinExamPeople.getPeoplesn());
		joinExamPeople.setFeestatus(7);//标记 目的是为了防止重复报错
		joinExamPeopleService.updateByPrimaryKeySelective(joinExamPeople);
		model.addAttribute("examFee", examFee);
		model.addAttribute("joinExamPeople", joinExamPeople);
	
	return "readyPayforExam";	
	}
	@RequestMapping("payForExam")
	public String payForExam(String id,Model model){
		System.out.println(id+"waaaaaaaaa");
//		int x=Integer.valueOf(id).intValue();
//		System.out.println(x+"=============");
		JoinExamPeople joinExamPeople=joinExamPeopleService.findById(Integer.parseInt(id));
//		System.out.println(joinExamPeople.getPeoplesn());
		System.out.println(joinExamPeople);	
		List<HxPeople> hxPeoples=hxPeopleService.findBySnInOne(joinExamPeople.getPeoplesn());
		int age=0;
		for (HxPeople hxPeople : hxPeoples) {
			 age=hxPeople.getAge();
		}
		joinExamPeople.setFeestatus(1);//已打款待审核。
		joinExamPeopleService.updateByPrimaryKeySelective(joinExamPeople);
		model.addAttribute("joinExamPeople", joinExamPeople);
		//String examtypelevel=joinExamPeople.getExamtypelevel();
		//String[] examtypelevelargs=null;
//		if (examtypelevel.contains(",")) {
//			examtypelevelargs=examtypelevel.split(",");
//		}
//		int levelNum=examtypelevelargs.length;
//		int examFee=300;
//		if (levelNum==2) {
//			examFee=600;
//		}else if(levelNum==3){
//			examFee=900;
//		}
//		if (hxPeople.getAge()<18) {
//			examFee=examFee/2;
//		}
		int examFee=300;
		if (age<18) {
			examFee=examFee/2;
		}
		
		
		model.addAttribute("examFee", examFee);	
		return "payForExam";
	}
	
//	@RequestMapping("checkNumn")
//	public void checkNumn(String num){
//		System.out.println("=========***+++++++++++++========="+num);
//	}
//	@RequestMapping("checkNumr")
//	public void checkNumr(String num){
//		System.out.println("=========***+++++++++++++========="+num);
//	}
//	@RequestMapping("examFeerecordsss")
//	public void examFeerecordsss(@RequestParam("examFeerecord")String examFeerecord){
//		System.out.println("===================**========="+examFeerecord);
//	}
	@RequestMapping("findWhoHasConfirm")
	public String findWhoHasConfirm(Model model){
		List<JoinExamPeople> joinExamPeoplesh=joinExamPeopleService.findWhoHasConfirm();
		model.addAttribute("joinExamPeoplesh", joinExamPeoplesh);
		return "findWhoHasConfirm";
	}
	@RequestMapping("findWhoIsNeedConfirm")
	public String findWhoIsNeedConfirm(Model model){
		List<JoinExamPeople> joinExamPeoplesn=joinExamPeopleService.findWhoIsNeedConfirm();
		model.addAttribute("joinExamPeoplesn", joinExamPeoplesn);
		return "findWhoIsNeedConfirm";
	}
	@RequestMapping("changejoinexamPeopelStuatsToYesInHx")
	public String changejoinexamPeopelStuatsToYesInHx(int id,Model model){
		JoinExamPeople joinExamPeople=joinExamPeopleService.findById(id);
		joinExamPeople.setFeestatus(2);
		joinExamPeopleService.updateByPrimaryKeySelective(joinExamPeople);
		
		return findWhoIsNeedConfirm(model);
	}
	@RequestMapping("changejoinexamPeopelStuatsToNoInHx")
	public String changejoinexamPeopelStuatsToNoInHx(int id,Model model){
		JoinExamPeople joinExamPeople=joinExamPeopleService.findById(id);
		joinExamPeople.setFeestatus(1);
		joinExamPeopleService.updateByPrimaryKeySelective(joinExamPeople);
		
		return findWhoHasConfirm(model);
	}
	
	
	
}
