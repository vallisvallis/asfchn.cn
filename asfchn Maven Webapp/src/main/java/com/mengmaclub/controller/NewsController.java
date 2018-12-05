package com.mengmaclub.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mengmaclub.model.News;
import com.mengmaclub.service.NewsService;

@Controller
@RequestMapping("/")
public class NewsController {
	@Autowired
	private NewsService newsService;

	/**
	 * 1.分页显示所有的新闻
	 * 
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("newsInfo")
	public String getNews(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 5);
		List<News> news = newsService.findAll();
		PageInfo page = new PageInfo(news, 5);
		model.addAttribute("pageInfo", page);
		List<News> newsNumList=newsService.findNews();		
		List<News> reportNumList=newsService.findReport();
		model.addAttribute("newsNum", newsNumList.size());
		model.addAttribute("reportNum", reportNumList.size());
		return "allNews";
	}
	/**
	 *首页显示新闻
	 * @param pn
	 * @param model
	 * @return
	 */
	@RequestMapping("newsList")
	public String getNewsIndex(
			@RequestParam(value = "pn", defaultValue = "1") Integer pn,
			Model model) {
		PageHelper.startPage(pn, 15);
		List<News> news = newsService.findAll();
		PageInfo page = new PageInfo(news, 15);
		model.addAttribute("pageInfo", page);
		for (News n : news) {
			System.out.println("news=======新闻列表" + n);
		}
		return "newsList";
	}
	/**
	 * 2.添加新闻
	 * 
	 * @param model
	 * @param news
	 * @return
	 */
	@RequestMapping("addNews")
	public String addNews(Model model, News news) {
		Date now =new Date();
		news.setAddtime(now);
		int i = newsService.insertSelective(news);
		if (i == 0) {
			return "error";
		} else {
			return "redirect:/newsInfo";
		}
	}
	/**
	 * 3.删除新闻
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("/delNews")
	public String delNews(int id, Model model) {
		model.addAttribute("news", newsService.deleteByPrimaryKey(id));
		return "redirect:/newsInfo";
	}
	/**
	 * 4.修改新闻
	 * 
	 * @param model
	 * @param news
	 * @return
	 */
	@RequestMapping("editNews")
	public String updateNews(Model model, News news) {
		Integer i = newsService.updateByPrimaryKeySelective(news);
		if (i != 0) {
			newsService.selectByPrimaryKey(news.getId());
			model.addAttribute("news", news);
			return "redirect:/newsInfo";
		}
		return "/error";
	}
	/**
	 * 5.跳转到添加新闻页面
	 */
	@RequestMapping("toAddNews")
	public String toAddNews() {
		return "addNews";
	}
	/**
	 * 6.显示单个新闻
	 * 
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("getNews")
	public String getNews(int id, Model model) {
		model.addAttribute("news", newsService.selectByPrimaryKey(id));
		return "editNews";
	}
	/**
	 * 在会员单位上查看新闻
	 * @param id
	 * @param model
	 * @return
	 */
	@RequestMapping("showNewsInTeam")
	public String showNewsInTeam(int id ,Model model){
		return "showNewsInTeam";
	}
	/**
	 * 在首页显示所有的新闻
	 * @param model
	 * @return
	 */
	@RequestMapping("showAllNewsInIndex")
	public String showNewsInIndex(Model model){
		List<News> AllNewsWillShowInIndex=newsService.findAll();
		model.addAttribute("AllNewsWillShowInIndex", AllNewsWillShowInIndex);
		return "showAllNewsInIndex";
	}
	/**
	 * 在首页上展示新闻
	 * @param model
	 * @return
	 */
	@RequestMapping("/")
	public String showNewsIndex(Model model){
		List<News> newsList=newsService.findAll();
		model.addAttribute("newsList", newsList);
		return "index";
	}
}
