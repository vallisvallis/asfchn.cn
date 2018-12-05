package com.mengmaclub.controller;

import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengmaclub.model.HxPeople;
import com.mengmaclub.model.HxTeam;
import com.mengmaclub.service.HxPeopleService;
import com.mengmaclub.service.HxTeamService;
import com.mengmaclub.util.DecideSn;

@Controller
@RequestMapping("/")
public class HxPeopleController {
	@Autowired
	private HxPeopleService hxPeopleService;
	@Autowired
	private HxTeamService hxTeamService;
	
	
	
	
	private DecideSn decideSn;
	/**
	 * 航协页面，显示已交会费的会员
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toPeopleHasPay")
	public String PeopleHasPay(Model model) {
		List<HxPeople> peoplehasPay = hxPeopleService.findWhoFeed();
		for (HxPeople hxPeople : peoplehasPay) {
			//这个页面在加载的时候很慢
			HxTeam hxTeam = hxTeamService.selectByPrimaryKey(hxPeople.getId());
			if (hxPeople.getTeamname().length() == 0
					|| (hxPeople.getTeamname()) == null) {
				hxPeople.setTeamname(hxTeam.getFullname());
				hxPeopleService.updateByPrimaryKeySelective(hxPeople);
			}
		}
		model.addAttribute("peoplehasPay", peoplehasPay);
		return "peopleHasPay";
	}
@RequestMapping("changePeopelStuatsInHx")
	public String changePeopelStuatsInHx(int id, Model model){
		HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(id);
		DateFormat dateFormat1 = new SimpleDateFormat("yyyy-MM-dd");  
        try {
			Date myDate1 = dateFormat1.parse("2000-01-01");
			hxPeople.setEligibledat(myDate1);
        } catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		hxPeople.setYearfeestatus(1);
		
		hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		
		return PeopleHasPay(model);
	}
@RequestMapping("changePeopelStuatsToYesInHx")
public String changePeopelStuatsToYesInHx(int id, Model model){
	HxPeople hxPeople=hxPeopleService.selectByPrimaryKey(id);
	Date now =new Date(); 
    hxPeople.setEligibledat(now);
	hxPeople.setYearfeestatus(2);
	
	hxPeopleService.updateByPrimaryKeySelective(hxPeople);
	return PeopleHasNoPay(model);
}
	/**
	 * 航协页面，显示未交会费的会员
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping("toPeopleHasNoPay")
	public String PeopleHasNoPay(Model model) {
		// List<HxPeople> allHxPeople = hxPeopleService.findAll();
		// for (HxPeople hxPeople : allHxPeople) {
		// System.out.println(hxPeople.toString());
		// HxTeam
		// hxTeam=hxTeamService.selectByPrimaryKey(hxPeople.getBelongteam());
		// hxPeople.setTeamname(hxTeam.getFullname());
		// hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		// }
		List<HxPeople> allHxPeopleWhoNotPay = hxPeopleService.findWhoNotFeed();

		
		model.addAttribute("allHxPeopleWhoNotPay", allHxPeopleWhoNotPay);
		return "peopleHasNoPay";
	}

	// 1.显示所有会员
	@RequestMapping("getAllHxpeople")
	public String getAllHxPeople(Model model) {
		List<HxPeople> hxPeople = hxPeopleService.findAll();
		model.addAttribute("hxPeopleList", hxPeople);
		return "allHxPeople";
	}

	// 备用显示该会员单位的所有会员

	// public String getTeamHxPeople(HxTeam hxTeam,
	// @RequestParam(value = "pn", defaultValue = "1") Integer pn,
	// Model hxpModel) {
	// System.out.println(hxTeam);
	// List<HxPeople> thisTeamPeople = hxTeamService.findPeopleThisTeam(hxTeam
	// .getId());
	// PageHelper.startPage(pn, 10);
	// PageInfo page = new PageInfo(thisTeamPeople, 10);
	// hxpModel.addAttribute("pageInfo", page);
	// PageHelper.startPage(pn, 10);
	//
	// // 显示未付费的会员
	// List<HxPeople> hxPeopleHasFeed = hxPeopleService.findWhoFeed();
	// for (HxPeople hxPeople : hxPeopleHasFeed) {
	// hxPeople.setYearfeestatus(2);
	// hxPeopleService.updateByPrimaryKeySelective(hxPeople);
	// }
	//
	// int i = hxPeopleHasFeed.size();
	// System.out.println("who is not fee" + i);
	// hxpModel.addAttribute("hxPeopleHasNotFeed", i);
	//
	// return "hxPeopleFromThisTeamInfo";
	//
	// }

	
	
	
	// 2.分页查询
	@RequestMapping("hxPeopleInfo")
	public String getAllHxPeople(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model hxpModel) {
		List<HxPeople> hxPeopleWhoPayInHx = hxPeopleService.findWhoFeed();
		
		int i = hxPeopleWhoPayInHx.size();
		
		hxpModel.addAttribute("hxPeopleWhoPayInHx", i);
		for (HxPeople hxPeople : hxPeopleWhoPayInHx) {
			
			hxPeople.setYearfeestatus(2);
			hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		}int num1=(pn-1)*50;
		int num2=(pn)*50;
		PageHelper.startPage(pn, 50);
		
		//List<HxPeople> allHxPeople = 
		// for (HxPeople hxPeople : allHxPeople) {
		// HxTeam
		// hxTeam=hxPeopleService.findBelongTeam(hxPeople.getBelongteam());
		// hxPeople.setTeamname(hxTeam.getFullname());
		// }
		//
		// for (HxPeople hxPeople : allHxPeople) {
		// HxTeam thisTeam = hxTeamService.selectByPrimaryKey(hxPeople
		// .getBelongteam());
		// hxPeople.setTeamname(thisTeam.getFullname());
		// hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		// }
		PageInfo page = new PageInfo(hxPeopleService.findAll(), 50);

		
		hxpModel.addAttribute("pageInfo", page);
		
		// 显示未付费的会员
		// List<HxPeople> hxPeopleHasNotFeed = hxPeopleService.findWhoNotFeed();

		return "allHxPeople";

	}

	/**
	 * 3.航协增加会员，自动生成会员号
	 * 
	 * @param model
	 * @param hxPeople
	 * @return
	 */
	@RequestMapping("addHxPeople")
	public String addHxPeople(Model model, HxPeople hxPeople) {
		
		if (hxPeople != null) {
			hxPeopleService.insertSelective(hxPeople);
			if (!((hxPeople.getCertnumber().length() == 0 || hxPeople
					.getCertnumber() == null) && (hxPeople.getName().length() == 0 || hxPeople
					.getName() == null))) {
			
				hxPeople =hxPeopleService.findPeopleByCertNum(hxPeople.getCertnumber());
//
//				hxPeople = hxPeopleService.findPeopleByNameAndCertNum(
//						hxPeople.getName(), hxPeople.getCertnumber());
				
			} else if (!(hxPeople.getName().length() == 0 || hxPeople.getName() == null)) {
				
				hxPeople = hxPeopleService.findPeopleByName(hxPeople.getName());
			}
		
		
			String city = hxPeople.getCity();
			DecideSn peopleSn = new DecideSn();
			String citySn = peopleSn.decidePeopleSn(city);
			
			hxPeople.setSn(citySn + hxPeople.getId());
			HxTeam thisTeam = hxTeamService.selectByPrimaryKey(hxPeople
					.getBelongteam());
			if (hxPeople.getTeamname() == null
					|| hxPeople.getTeamname().isEmpty()) {
				
				hxPeople.setTeamname(thisTeam.getFullname());
				hxPeopleService.updateByPrimaryKeySelective(hxPeople);
			}
			hxPeople = hxPeopleService.selectByPrimaryKey(hxPeople.getId());
		}
		
		return "redirect:/hxPeopleInfo";
	}

	// /**
	// * 3.会员单位增加会员，自动生成会员号
	// *
	// * @param model
	// * @param hxPeople
	// * @return
	// */
	// @RequestMapping("addHxPeopleByHxTeam")
	// public String addHxPeopleByTeam(Model model, HxPeople
	// hxPeople,@RequestParam(value = "pn", defaultValue = "1") Integer pn) {
	// System.out.println("newpeople_________________________"+hxPeople);
	// HxTeam
	// thisTeam=hxTeamService.selectByPrimaryKey(hxPeople.getBelongteam());
	// int id=0;
	// if (hxPeople != null) {
	// hxPeopleService.insertSelective(hxPeople);
	// hxPeople=hxPeopleService.findPeopleByName(hxPeople.getName());
	// System.out.println("newpeople_________________________"+hxPeople);
	// System.out.println("city_________________________"+hxPeople.getCity());
	// System.out.println("id"+hxPeople.getId());
	//
	// String city=hxPeople.getCity();
	// DecideSn peopleSn=new DecideSn();
	// String citySn=peopleSn.decidePeopleSn(city);
	// System.out.println("citySn"+citySn);
	// hxPeople.setSn(citySn+ hxPeople.getId());
	//
	// id=thisTeam.getId();
	// hxPeople.setTeamname(thisTeam.getFullname());
	// hxPeopleService.updateByPrimaryKeySelective(hxPeople);
	// }
	//
	// HxTeamController hxc=new HxTeamController();
	// System.out.println(id);
	//
	//
	// return hxc.ShowTeamPeople(id, pn, model);
	// }

	// 4.航协页面添加会员跳转到会员添加页面
	@RequestMapping("toAddHxPeople")
	public String toAddHxPeople(Model model) {
		List<HxTeam> allHxTeamlist = hxTeamService.findAll();
		model.addAttribute("allHxTeamlist", allHxTeamlist);
		return "addHxPeople";
	}

	// 5.显示单个会员
	@RequestMapping("getHxPeople")
	public String getHxPeople(int id, Model model) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute(hxPeople);
		return "editHxPeople";
	}

	// // 5.5会员页面显示会员
	// @RequestMapping("showHxPeopleBySelf")
	// public String showSelf(HxTeam hxTeam, Model model) {
	// List<HxPeople> thisTeamPeople=
	// hxTeamService.findPeopleThisTeam(hxTeam.getId());
	// model.addAttribute("thisTeamPeople", thisTeamPeople);
	// return "showSelf";
	// }
	// // 6.删除单个会员
	// @RequestMapping("/delHxPeople")
	// public String deleteHxPeople(int id, Model model) {
	// model.addAttribute("hxPeople", hxPeopleService.deleteByPrimaryKey(id));
	// return "redirect:/hxPeopleInfo";
	//
	// }

	/**
	 * 航协页面显示所有会员中的详情
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateHxPeople")
	public String toUpdateHxPeople(int id, Model model) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute("hxPeople", hxPeople);

		return "showPeopleIntroduce";
	}

	@RequestMapping("toUpdateHxPeopleInHx")
	public String toUpdateHxPeopleInHx(int id, Model model) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute("hxPeople", hxPeople);

		return "showPeopleIntroduceInHx";
	}
	
	
	
	/**
	 * 会员单位显示所有会员中的详情
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("toUpdateHxPeopleInTeam")
	public String toUpdateHxPeopleInHxTeam(int id, Model model) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute("hxPeople", hxPeople);

		return "showPeopleIntroduceInHxTeam";
	}

	// 7.会员单位修改个人会员
	@RequestMapping("updateHxPeopleInHxTeam")
	public String UpdateHxPeopleInHxTeam(Model model, HxPeople hxPeople) {
		Integer i = hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		HxTeam hxTeam = hxTeamService.selectByPrimaryKey(hxPeople
				.getBelongteam());
		
		if (i != null) {
			hxPeople = hxPeopleService.selectByPrimaryKey(hxPeople.getId());
			model.addAttribute("hxPeople", hxPeople);
			model.addAttribute("id", hxTeam.getId());
			return "redirect:/showTeamPeople";
		}

		return "error";
	}

	/**
	 * 跳转更新
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("updatePeopleself")
	public String toupdatePeopleSelf(int id, Model model) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute("hxPeople", hxPeople);
		return "updatemyself";
	}

	/**
	 * 会员单位添加会员
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("toAddHxPeopleByTeam")
	public String toAddHxPeopleByTeam(int id, Model model) {

		HxTeam thisHxTeam = hxTeamService.selectByPrimaryKey(id);
		model.addAttribute("thisHxTeam", thisHxTeam);
		return "addHxPeopleByTeamTest";
	}

	/**
	 * 更新
	 * 
	 * @param hxPeople
	 * @param model
	 * @return
	 */
	@RequestMapping("updatemyself")
	public String updatePeopleself(HxPeople hxPeople1, Model model) {
	
		int i = hxPeopleService.updateByPrimaryKeySelective(hxPeople1);

		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(hxPeople1
				.getId());

		model.addAttribute("hxPeople", hxPeople);
		return "showme";
	}

	
	// 7.hx修改个人会员
	@RequestMapping("updateHxPeople")
	public String UpdateHxPeople(Model model, HxPeople hxPeople, boolean confirm) {

		if (confirm) {
			Date now = new Date();
			hxPeople.setEligibledat(now);
			hxPeople.setYearfeestatus(2);
		}

		Integer i = hxPeopleService.updateByPrimaryKeySelective(hxPeople);
		if (i != null) {
			hxPeople = hxPeopleService.selectByPrimaryKey(hxPeople.getId());
			model.addAttribute("hxPeople", hxPeople);
			return "redirect:/hxPeopleInfo";
		}

		return "error";
	}

	@RequestMapping("showthisPeople")
	public String showpeople(int id, Model model) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		model.addAttribute("hxPeople", hxPeople);

		return "showme";
	}

	@RequestMapping("findMyTeam")
	public String findBelongTeam(int id, Model model) {
		HxPeople hxPeople = hxPeopleService.selectByPrimaryKey(id);
		if (hxPeople.getBelongteam() != null) {
			HxTeam hxTeam = hxPeopleService.findBelongTeam(hxPeople
					.getBelongteam());
			model.addAttribute("hxTeam", hxTeam);
			return "showTeamIntroduceInHxPeople";
		}
		return "noBelongTeam";

	}

	// @RequestMapping("import")
	// public String impotr(HttpServletRequest request, Model model) throws
	// Exception {
	//
	// //获取上传的文件
	// MultipartHttpServletRequest multipart = (MultipartHttpServletRequest)
	// request;
	// MultipartFile file = multipart.getFile("upfile");
	// String month = request.getParameter("month");
	// InputStream in = file.getInputStream();
	// //数据导入
	// // salaryService.importExcelInfo(in,file,month,adminId);
	// hxPeopleService.importExcelInfo(in, file);
	// in.close();
	// return "redirect:/hxPeopleInfo";
	// }
	//

	// // 数据导入
	// @RequestMapping(value = { "/hxPeopleImport" }, method = {
	// RequestMethod.POST })
	// //@RequestMapping("hxPeopleImport")
	// public Map<String, String> hxPeopleImport(
	// MultipartHttpServletRequest request, HttpServletResponse response)
	// throws IOException {
	// Map<String, String> map = new HashMap<String, String>();
	// MultipartFile file = request.getFile("file");
	// map = parseExcelEntities(file, request);
	// return map;
	// }
	//
	// private Map<String, String> parseExcelEntities(MultipartFile file,
	// MultipartHttpServletRequest request) throws IOException {
	// Map<String, String> map = new HashMap<String, String>();
	// InputStream is = null;
	// int successNumber = 0;
	// int failNumber = 0;
	// String failString = "";
	// try {
	// is = file.getInputStream();
	// List<List<Object>> result = ExcelUtil.importExcel(is);
	// if (!result.isEmpty()) {
	// result.remove(0);
	// int i = 1;
	// for (List<Object> row : result) {
	// i++;
	// HxPeople entity = new HxPeople();
	// Object name = row.get(0);
	// boolean a = true;
	// if (null != name && "".equals(name.toString().trim())) {
	// entity.setName(name.toString().trim());
	// } else {
	// a = false;
	// }
	// Object certnumber = row.get(1);
	// if (null != certnumber
	// && "".equals(certnumber.toString().trim())) {
	// entity.setCertnumber(certnumber.toString().trim());
	// }
	// Object prop3 = row.get(2);
	// if (null != prop3 && "".equals(prop3.toString().trim())) {
	// entity.setProp3(prop3.toString().trim());
	// } else {
	// entity.setProp3(null);
	// }
	// Object gender = row.get(3);
	// if (null != gender && "".equals(gender.toString().trim())) {
	// entity.setGender(gender.toString().trim());
	// } else {
	// entity.setGender(null);
	// }
	// Object city = row.get(4);
	// if (null != city && "".equals(city.toString().trim())) {
	// entity.setCity(city.toString().trim());
	// } else {
	// entity.setCity(null);
	// }
	// Object occupation = row.get(5);
	// if (null != occupation
	// && "".equals(occupation.toString().trim())) {
	// entity.setOccupation(occupation.toString().trim());
	// } else {
	// entity.setOccupation(null);
	// }
	// Boolean judge = true;
	// if (null != certnumber
	// && !"".equals(certnumber.toString().trim())) {
	// List<HxPeople> people = hxPeopleService
	// .selectByCertPeople(entity);
	// if (people.size() > 0) {
	// judge = false;
	// }
	// } else {
	// judge = false;
	// }
	// if (judge && a) {
	// hxPeopleService.insert(entity);
	// successNumber++;
	// } else {
	// failNumber++;
	// failString = addFailData(failString, i);
	// continue;
	// }
	// }
	// }
	// } finally {
	// if (null != is) {
	// is.close();
	// }
	// }
	// String message = "成功导入" + successNumber + "条,失败" + failNumber + "条";
	// if (failNumber > 0) {
	// message = message + ", 失败数据在第 " + failString + " 行.";
	// }
	// map.put("message", message);
	// return map;
	// }

	// // 添加失败数据所在行
	// public String addFailData(String failString, int i) {
	// return !"".equals(failString) ? failString + "," + i : failString + i;
	// }

}
