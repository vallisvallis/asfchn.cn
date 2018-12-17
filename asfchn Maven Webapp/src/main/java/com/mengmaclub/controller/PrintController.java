package com.mengmaclub.controller;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFClientAnchor;
import org.apache.poi.xssf.usermodel.XSSFDrawing;
import org.apache.poi.xssf.usermodel.XSSFPrintSetup;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mengmaclub.model.JoinMatchTeam;
import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.Mangoptionsmatch;
import com.mengmaclub.model.Manyrifmatch;
import com.mengmaclub.model.Match;
import com.mengmaclub.model.MatchGroup;
import com.mengmaclub.model.MatchList;
import com.mengmaclub.model.Turnmatchlist;
import com.mengmaclub.model.Twoptionsmatch;
import com.mengmaclub.model.Withfriendmatch;
import com.mengmaclub.service.JoinMatchTeamPeopleService;
import com.mengmaclub.service.JoinMatchTeamService;
import com.mengmaclub.service.MangoptionsmatchService;
import com.mengmaclub.service.ManyrifmatchService;
import com.mengmaclub.service.MatchGroupService;
import com.mengmaclub.service.MatchListService;
import com.mengmaclub.service.MatchService;
import com.mengmaclub.service.TurnMatchListService;
import com.mengmaclub.service.TwoptionsMatchService;
import com.mengmaclub.service.WithfriendmatchService;

@Controller
public class PrintController {
	/*
	 * 此程序只打印
	 */
	@Autowired
	private MatchService matchService;
	@Autowired
	private MatchListService matchListService;
	@Autowired
	private MatchGroupService matchGroupService;
	@Autowired
	private TwoptionsMatchService twoptionsMatchService;
	@Autowired
	private MangoptionsmatchService mangoptionsmatchService;
	@Autowired
	private TurnMatchListService turnMatchListService;
	@Autowired
	private JoinMatchTeamService joinMatchTeamService;
	@Autowired
	private JoinMatchTeamPeopleService joinMatchTeamPeopleService;
	@Autowired
	private WithfriendmatchService withfriendmatchService;
	@Autowired
	private ManyrifmatchService manyrifmatchService;
	/*
	 * 打印成绩
	 */

	@RequestMapping("readydownloadsingle")
	public String printScore(int matchid, int matchlistid, int gageid, Model model) {
		String bookpath = "";
		Match match = matchService.selectByPrimaryKey(matchid);
		MatchList matchList = matchListService.selectByPrimaryKey(matchlistid);
		MatchGroup matchGroup = matchGroupService.selectByPrimaryKey(gageid);
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(matchGroup.getGroupage());
		XSSFPrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE); // 纸张
		// sheet.setDisplayGridlines(false);
		sheet.setPrintGridlines(false);
		sheet.setMargin(XSSFSheet.TopMargin, (double) 1); // 上边距
		sheet.setMargin(XSSFSheet.BottomMargin, (double) 1); // 下边距
		sheet.setMargin(XSSFSheet.LeftMargin, (double) 1); // 左边距
		sheet.setMargin(XSSFSheet.RightMargin, (double) 1); // 右边距
		XSSFCellStyle cellStyle = workbook.createCellStyle(); // 单元格样式
		Font fontStyle = workbook.createFont(); // 字体样式
		// fontStyle.setBold(true); // 加粗
		fontStyle.setFontName("仿宋"); // 字体
		fontStyle.setFontHeightInPoints((short) 8); // 大小
		// 将字体样式添加到单元格样式中
		cellStyle.setFont(fontStyle);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		XSSFRow headRow = sheet.createRow(0);
		XSSFCell headCell = headRow.createCell(0);
		XSSFCellStyle headstyle1 = workbook.createCellStyle();
		XSSFCellStyle headstyle2 = workbook.createCellStyle();

		String gageName = "";
		switch (gageid) {
		case 1:
			gageName = "小学男子组";
			break;
		case 2:
			gageName = "小学女子组";
			break;
		case 3:
			gageName = "初中男子组";
			break;
		case 4:
			gageName = "初中女子组";
			break;
		case 5:
			gageName = "高中男子组";
			break;
		case 6:
			gageName = "高中女子组";
			break;
		case 7:
			gageName = "教练组";
			break;
		default:
			break;
		}
		headCell.setCellValue(gageName + matchList.getName());
		headstyle1.setAlignment(HorizontalAlignment.LEFT);
		headstyle1.setBorderBottom(BorderStyle.DOUBLE);
		headCell.setCellStyle(headstyle1);
		headCell = headRow.createCell(4);
		headCell.setCellValue("比赛时间：" + "2018-10-22");
		headstyle2.setAlignment(HorizontalAlignment.RIGHT);
		headstyle2.setBorderBottom(BorderStyle.DOUBLE);
		headCell.setCellStyle(headstyle2);

		if (matchlistid == 1 || matchlistid == 2 || matchlistid == 3 || matchlistid == 4 || matchlistid == 6
				|| matchlistid == 7 || matchlistid == 32 || matchlistid == 33 || matchlistid == 19 || matchlistid == 30
				|| matchlistid == 20) {
			CellRangeAddress cra0 = new CellRangeAddress(0, 0, 0, 3);
			sheet.addMergedRegion(cra0);
			CellRangeAddress crax = new CellRangeAddress(0, 0, 4, 8);
			sheet.addMergedRegion(crax);
			XSSFRow firstRow = sheet.createRow(1);
			XSSFRow secondRow = sheet.createRow(2);
			sheet.setColumnWidth(0, 1300);
			sheet.setColumnWidth(1, 5500);
			sheet.setColumnWidth(2, 1500);
			sheet.setColumnWidth(3, 2200);
			sheet.setColumnWidth(4, 2200);
			sheet.setColumnWidth(5, 2200);
			sheet.setColumnWidth(6, 1500);
			sheet.setColumnWidth(7, 1500);
			sheet.setColumnWidth(8, 1500);
			XSSFCell cell = null;

			CellRangeAddress cra1 = new CellRangeAddress(1, 2, 0, 0);
			sheet.addMergedRegion(cra1);// 合并
			CellRangeAddress cra2 = new CellRangeAddress(1, 2, 1, 1);
			sheet.addMergedRegion(cra2);// 合并
			CellRangeAddress cra3 = new CellRangeAddress(1, 2, 2, 2);
			sheet.addMergedRegion(cra3);// 合并
			CellRangeAddress cra4 = new CellRangeAddress(1, 1, 3, 4);
			sheet.addMergedRegion(cra4);
			CellRangeAddress cra5 = new CellRangeAddress(1, 2, 5, 5);
			sheet.addMergedRegion(cra5);
			CellRangeAddress cra6 = new CellRangeAddress(1, 2, 6, 6);
			sheet.addMergedRegion(cra6);
			CellRangeAddress cra7 = new CellRangeAddress(1, 2, 7, 7);
			sheet.addMergedRegion(cra7);
			CellRangeAddress cra8 = new CellRangeAddress(1, 2, 8, 8);
			sheet.addMergedRegion(cra8);

			cell = firstRow.createCell(0);
			cell.setCellValue("编号");
			cell.setCellStyle(cellStyle);
			cell = firstRow.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("单位");
			cell = firstRow.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("姓名");
			cell = firstRow.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("飞行成绩");
			cell = firstRow.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("总成绩");
			cell = firstRow.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("名次");
			cell = firstRow.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("奖项");
			cell = firstRow.createCell(8);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("备注");
			cell = secondRow.createCell(3);
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("第一轮");
			cell = secondRow.createCell(4);
			cell.setCellValue("第二轮");
			cell.setCellStyle(cellStyle);
			
			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);

			/*
			 * 开始写入成绩
			 */
			List<Twoptionsmatch> twoptionsmatchs = twoptionsMatchService
					.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchlistid, gageid);
			/*
			 * 此处需要排序 升序
			 */
			Collections.sort(twoptionsmatchs);
			int i = 3;
			for (Twoptionsmatch twoptionsmatch : twoptionsmatchs) {

				XSSFRow scoreRow = sheet.createRow(i);
				XSSFCell scoreCell = null;

				scoreCell = scoreRow.createCell(0);
				scoreCell.setCellValue(twoptionsmatch.getNum());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(1);
				scoreCell.setCellValue(twoptionsmatch.getTeamname());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(2);
				scoreCell.setCellValue(twoptionsmatch.getName());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(3);
				scoreCell.setCellValue(twoptionsmatch.getScoreone());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(4);
				scoreCell.setCellValue(twoptionsmatch.getScoretwo());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(5);
				scoreCell.setCellValue(twoptionsmatch.getFinalscore());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(6);
				scoreCell.setCellValue(twoptionsmatch.getRank());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(7);
				scoreCell.setCellValue(twoptionsmatch.getReward());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(8);
				scoreCell.setCellStyle(cellStyle);
				scoreCell.setCellValue("");
				i++;
			}
			bookpath = matchList.getName() + gageName + ".xlsx";
			File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
			try {
				file.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workbook.write(stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (matchlistid == 5 || matchlistid == 10 || matchlistid == 11 || matchlistid == 12 || matchlistid == 13
				|| matchlistid == 14) {
			CellRangeAddress cra0 = new CellRangeAddress(0, 0, 0, 3);
			sheet.addMergedRegion(cra0);
			CellRangeAddress crax = new CellRangeAddress(0, 0, 4, 8);
			sheet.addMergedRegion(crax);
			XSSFRow firstRow = sheet.createRow(1);
			XSSFRow secondRow = sheet.createRow(2);
			sheet.setColumnWidth(0, 1300);
			sheet.setColumnWidth(1, 5500);
			sheet.setColumnWidth(2, 1500);
			sheet.setColumnWidth(3, 2200);
			sheet.setColumnWidth(4, 2200);
			sheet.setColumnWidth(5, 2200);
			sheet.setColumnWidth(6, 1500);
			sheet.setColumnWidth(7, 1500);
			sheet.setColumnWidth(8, 1500);
			XSSFCell cell = null;

			CellRangeAddress cra1 = new CellRangeAddress(1, 2, 0, 0);
			sheet.addMergedRegion(cra1);// 合并
			CellRangeAddress cra2 = new CellRangeAddress(1, 2, 1, 1);
			sheet.addMergedRegion(cra2);// 合并
			CellRangeAddress cra3 = new CellRangeAddress(1, 2, 2, 2);
			sheet.addMergedRegion(cra3);// 合并
			CellRangeAddress cra4 = new CellRangeAddress(1, 1, 3, 4);
			sheet.addMergedRegion(cra4);
			CellRangeAddress cra5 = new CellRangeAddress(1, 2, 5, 5);
			sheet.addMergedRegion(cra5);
			CellRangeAddress cra6 = new CellRangeAddress(1, 2, 6, 6);
			sheet.addMergedRegion(cra6);
			CellRangeAddress cra7 = new CellRangeAddress(1, 2, 7, 7);
			sheet.addMergedRegion(cra7);
			CellRangeAddress cra8 = new CellRangeAddress(1, 2, 8, 8);
			sheet.addMergedRegion(cra8);

			cell = firstRow.createCell(0);
			cell.setCellValue("编号");

			cell.setCellStyle(cellStyle);
			cell = firstRow.createCell(1);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("单位");
			
			cell = firstRow.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("姓名");
			cell = firstRow.createCell(3);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("飞行成绩");
			cell = firstRow.createCell(5);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("总成绩");
			cell = firstRow.createCell(6);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("名次");
			cell = firstRow.createCell(7);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("奖项");
			cell = firstRow.createCell(8);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("备注");
			cell = secondRow.createCell(3);
			
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("第一轮");
			cell = secondRow.createCell(4);
			cell.setCellValue("第二轮");
			cell.setCellStyle(cellStyle);
			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);

			/*
			 * 开始写入成绩
			 */
			List<Mangoptionsmatch> mangoptionsmatchs = mangoptionsmatchService
					.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchlistid, gageid);
			/*
			 * 此处需要排序 升序
			 */
			Collections.sort(mangoptionsmatchs);
			int i = 3;

			for (Mangoptionsmatch mangoptionsmatch : mangoptionsmatchs) {

				XSSFRow scoreRow = sheet.createRow(i);
				XSSFCell scoreCell = null;

				scoreCell = scoreRow.createCell(0);
				scoreCell.setCellValue(mangoptionsmatch.getNum());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(1);
				scoreCell.setCellValue(mangoptionsmatch.getTeamname());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(2);
				scoreCell.setCellValue(mangoptionsmatch.getName());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(3);
				scoreCell.setCellValue(mangoptionsmatch.getScorefinalone());

				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(4);
				scoreCell.setCellValue(mangoptionsmatch.getScorefinaltwo());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(5);
				scoreCell.setCellValue(mangoptionsmatch.getScorefinal());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(6);
				scoreCell.setCellValue(mangoptionsmatch.getRank());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(7);
				scoreCell.setCellValue(mangoptionsmatch.getReward());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(8);
				scoreCell.setCellStyle(cellStyle);
				scoreCell.setCellValue("");
				i++;
			}
			bookpath = matchList.getName() + gageName + ".xlsx";
			// File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" +
			// matchList.getName()+gageName + ".xlsx");
			File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
			try {
				file.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workbook.write(stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (matchlistid == 23 || matchlistid == 26 || matchlistid == 27 || matchlistid == 29 || matchlistid == 31
				|| matchlistid == 17 || matchlistid == 18) {
			CellRangeAddress cra0 = new CellRangeAddress(0, 0, 0, 4);
			sheet.addMergedRegion(cra0);
			CellRangeAddress crax = new CellRangeAddress(0, 0, 5, 10);
			sheet.addMergedRegion(crax);

			/*
			 * 批次项目
			 */
			XSSFRow firstRow = sheet.createRow(1);
			XSSFRow secondRow = sheet.createRow(2);
			secondRow.setHeight((short) 500);
			sheet.setColumnWidth(0, 1300);
			sheet.setColumnWidth(1, 5500);
			sheet.setColumnWidth(2, 1500);
			sheet.setColumnWidth(3, 2000);
			sheet.setColumnWidth(4, 2000);
			sheet.setColumnWidth(5, 2000);
			sheet.setColumnWidth(6, 2000);
			sheet.setColumnWidth(7, 1500);
			sheet.setColumnWidth(8, 1000);
			sheet.setColumnWidth(9, 1500);
			sheet.setColumnWidth(10, 1000);
			XSSFCell cell = null;

			CellRangeAddress cra1 = new CellRangeAddress(1, 2, 0, 0);
			sheet.addMergedRegion(cra1);// 合并
			CellRangeAddress cra2 = new CellRangeAddress(1, 2, 1, 1);
			sheet.addMergedRegion(cra2);// 合并
			CellRangeAddress cra3 = new CellRangeAddress(1, 2, 2, 2);
			sheet.addMergedRegion(cra3);// 合并
			CellRangeAddress cra4 = new CellRangeAddress(1, 1, 3, 4);
			sheet.addMergedRegion(cra4);
			CellRangeAddress cra5 = new CellRangeAddress(1, 1, 5, 6);
			sheet.addMergedRegion(cra5);
			CellRangeAddress cra6 = new CellRangeAddress(1, 2, 7, 7);
			sheet.addMergedRegion(cra6);
			CellRangeAddress cra7 = new CellRangeAddress(1, 2, 8, 8);
			sheet.addMergedRegion(cra7);
			CellRangeAddress cra8 = new CellRangeAddress(1, 2, 9, 9);
			sheet.addMergedRegion(cra8);
			CellRangeAddress cra9 = new CellRangeAddress(1, 2, 10, 10);
			sheet.addMergedRegion(cra9);
			cell = firstRow.createCell(0);
			cell.setCellValue("编号");

			cell.setCellStyle(cellStyle);
			cell = firstRow.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("单位");
			cell = firstRow.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("姓名");
			cell = firstRow.createCell(3);
			cell.setCellStyle(cellStyle);

			cell.setCellValue("第一轮成绩");

			cell = firstRow.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("第二轮成绩");

			cell = firstRow.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("比赛成绩");
			cell = firstRow.createCell(8);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("名次");
			cell = firstRow.createCell(9);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("奖项");
			cell = firstRow.createCell(10);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("备注");
			cell = secondRow.createCell(3);
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cellStyle.setWrapText(true);
			cell.setCellStyle(cellStyle);
			if (matchlistid == 18 || matchlistid == 17) {
				cell.setCellValue("批" + "一飞" + "/" + "二飞" + "/" + "三飞");
			} else {
				cell.setCellValue("批" + "定" + "/" + "动" + "/" + "留");
			}

			cell = secondRow.createCell(4);
			cell.setCellValue("第一轮");
			cell.setCellStyle(cellStyle);
			cell = secondRow.createCell(5);
			if (matchlistid == 18 || matchlistid == 17) {
				cell.setCellValue("批" + "最后飞");
			} else {
				cell.setCellValue("批" + "定" + "/" + "动" + "/" + "留");
			}

			cell.setCellStyle(cellStyle);
			cell = secondRow.createCell(6);
			cell.setCellValue("第二轮");
			cell.setCellStyle(cellStyle);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra9, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra9, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra9, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra9, sheet);
			/*
			 * 开始写入成绩
			 */
			List<Turnmatchlist> turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(matchid,
					matchlistid, gageid);
			/*
			 * 此处需要排序 升序
			 */
			Collections.sort(turnmatchlists);
			int i = 3;

			for (Turnmatchlist turnmatchlist : turnmatchlists) {

				XSSFRow scoreRow = sheet.createRow(i);
				XSSFCell scoreCell = null;

				scoreCell = scoreRow.createCell(0);
				scoreCell.setCellValue(turnmatchlist.getNum());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(1);
				scoreCell.setCellValue(turnmatchlist.getTeamname());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(2);
				scoreCell.setCellValue(turnmatchlist.getName());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(3);
				scoreCell.setCellValue(turnmatchlist.getTurn1() + "/" + turnmatchlist.getOneturnpointmeter() + "/"
						+ turnmatchlist.getOneturnpowertime() + "/" + turnmatchlist.getOneturnskytime());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(4);
				scoreCell.setCellValue(turnmatchlist.getScoreinoneturnhascalc());
				scoreCell.setCellStyle(cellStyle);

				scoreCell = scoreRow.createCell(5);
				scoreCell.setCellValue(turnmatchlist.getTurn2() + "/" + turnmatchlist.getTwoturnpointmeter() + "/"
						+ turnmatchlist.getTwoturnpowertime() + "/" + turnmatchlist.getTwoturnskytime());
				scoreCell.setCellStyle(cellStyle);

				scoreCell = scoreRow.createCell(6);
				scoreCell.setCellValue(turnmatchlist.getScoreintwoturnhascalc());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(7);
				scoreCell.setCellValue(turnmatchlist.getFinalscore());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(8);
				scoreCell.setCellValue(turnmatchlist.getRankfinal());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(9);
				scoreCell.setCellValue(turnmatchlist.getReward());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(10);
				scoreCell.setCellValue("  ");
				scoreCell.setCellStyle(cellStyle);
				i++;
			}
			bookpath = matchList.getName() + gageName + ".xlsx";
			File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
			try {
				file.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workbook.write(stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}

		} else if (matchlistid == 8) {
			CellRangeAddress cra0 = new CellRangeAddress(0, 0, 0, 3);
			sheet.addMergedRegion(cra0);
			CellRangeAddress crax = new CellRangeAddress(0, 0, 4, 8);
			sheet.addMergedRegion(crax);
			XSSFRow firstRow = sheet.createRow(1);
			XSSFRow secondRow = sheet.createRow(2);
			sheet.setColumnWidth(0, 1300);
			sheet.setColumnWidth(1, 5500);
			sheet.setColumnWidth(2, 1500);
			sheet.setColumnWidth(3, 2200);
			sheet.setColumnWidth(4, 2200);
			sheet.setColumnWidth(5, 2200);
			sheet.setColumnWidth(6, 1500);
			sheet.setColumnWidth(7, 1500);
			sheet.setColumnWidth(8, 1500);
			XSSFCell cell = null;

			CellRangeAddress cra1 = new CellRangeAddress(1, 2, 0, 0);
			sheet.addMergedRegion(cra1);// 合并
			CellRangeAddress cra2 = new CellRangeAddress(1, 2, 1, 1);
			sheet.addMergedRegion(cra2);// 合并
			CellRangeAddress cra3 = new CellRangeAddress(1, 2, 2, 2);
			sheet.addMergedRegion(cra3);// 合并
			CellRangeAddress cra4 = new CellRangeAddress(1, 1, 3, 4);
			sheet.addMergedRegion(cra4);
			CellRangeAddress cra5 = new CellRangeAddress(1, 2, 5, 5);
			sheet.addMergedRegion(cra5);
			CellRangeAddress cra6 = new CellRangeAddress(1, 2, 6, 6);
			sheet.addMergedRegion(cra6);
			CellRangeAddress cra7 = new CellRangeAddress(1, 2, 7, 7);
			sheet.addMergedRegion(cra7);
			CellRangeAddress cra8 = new CellRangeAddress(1, 2, 8, 8);
			sheet.addMergedRegion(cra8);

			cell = firstRow.createCell(0);
			cell.setCellValue("编号");

			cell.setCellStyle(cellStyle);
			
			cell = firstRow.createCell(1);
			cell.setCellStyle(cellStyle);
			
			cell.setCellValue("单位");
			cell = firstRow.createCell(2);
			
			cell.setCellStyle(cellStyle);
			cell.setCellValue("姓名");
			cell = firstRow.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("飞行成绩");
			cell = firstRow.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("总成绩");
			cell = firstRow.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("名次");
			cell = firstRow.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("奖项");
			cell = firstRow.createCell(8);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("备注");
			cell = secondRow.createCell(3);
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("第一轮");
			cell = secondRow.createCell(4);
			cell.setCellValue("第二轮");
			cell.setCellStyle(cellStyle);
			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);
			List<Withfriendmatch> withfriendmatchs = withfriendmatchService
					.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchlistid, gageid);
			Collections.sort(withfriendmatchs);
			int i = 3;
			for (Withfriendmatch withfriendmatch : withfriendmatchs) {
				XSSFRow scoreRow = sheet.createRow(i);
				XSSFCell scoreCell = null;

				scoreCell = scoreRow.createCell(0);
				scoreCell.setCellValue(withfriendmatch.getNum());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(1);
				scoreCell.setCellValue(withfriendmatch.getTeamname());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(2);
				scoreCell.setCellValue(withfriendmatch.getName());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(3);
				scoreCell.setCellValue(withfriendmatch.getScoreone());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(4);
				scoreCell.setCellValue(withfriendmatch.getScoretwo());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(5);
				scoreCell.setCellValue(withfriendmatch.getFinalscore());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(6);
				scoreCell.setCellValue(withfriendmatch.getRank());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(7);
				scoreCell.setCellValue(withfriendmatch.getReward());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(8);
				scoreCell.setCellStyle(cellStyle);
				scoreCell.setCellValue("");
				i++;
			}
			bookpath = matchList.getName() + gageName + ".xlsx";
			File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
			try {
				file.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workbook.write(stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} else if (matchlistid == 9 || matchlistid == 25) {
			CellRangeAddress cra0 = new CellRangeAddress(0, 0, 0, 3);
			sheet.addMergedRegion(cra0);
			CellRangeAddress crax = new CellRangeAddress(0, 0, 4, 8);
			sheet.addMergedRegion(crax);
			XSSFRow firstRow = sheet.createRow(1);
			XSSFRow secondRow = sheet.createRow(2);
			sheet.setColumnWidth(0, 1300);
			sheet.setColumnWidth(1, 5500);
			sheet.setColumnWidth(2, 1500);
			sheet.setColumnWidth(3, 2200);
			sheet.setColumnWidth(4, 2200);
			sheet.setColumnWidth(5, 2200);
			sheet.setColumnWidth(6, 1500);
			sheet.setColumnWidth(7, 1500);
			sheet.setColumnWidth(8, 1500);
			XSSFCell cell = null;

			CellRangeAddress cra1 = new CellRangeAddress(1, 2, 0, 0);
			sheet.addMergedRegion(cra1);// 合并
			CellRangeAddress cra2 = new CellRangeAddress(1, 2, 1, 1);
			sheet.addMergedRegion(cra2);// 合并
			CellRangeAddress cra3 = new CellRangeAddress(1, 2, 2, 2);
			sheet.addMergedRegion(cra3);// 合并
			CellRangeAddress cra4 = new CellRangeAddress(1, 1, 3, 4);
			sheet.addMergedRegion(cra4);
			CellRangeAddress cra5 = new CellRangeAddress(1, 2, 5, 5);
			sheet.addMergedRegion(cra5);
			CellRangeAddress cra6 = new CellRangeAddress(1, 2, 6, 6);
			sheet.addMergedRegion(cra6);
			CellRangeAddress cra7 = new CellRangeAddress(1, 2, 7, 7);
			sheet.addMergedRegion(cra7);
			CellRangeAddress cra8 = new CellRangeAddress(1, 2, 8, 8);
			sheet.addMergedRegion(cra8);

			cell = firstRow.createCell(0);
			cell.setCellValue("编号");
			cell.setCellStyle(cellStyle);
			cell = firstRow.createCell(1);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("单位");
			cell = firstRow.createCell(2);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("姓名");
			cell = firstRow.createCell(3);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("飞行成绩");
			cell = firstRow.createCell(5);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("总成绩");
			cell = firstRow.createCell(6);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("名次");
			cell = firstRow.createCell(7);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("奖项");
			cell = firstRow.createCell(8);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("备注");
			cell = secondRow.createCell(3);
			cellStyle.setBorderBottom(BorderStyle.THIN);
			cellStyle.setBorderLeft(BorderStyle.THIN);
			cellStyle.setBorderRight(BorderStyle.THIN);
			cellStyle.setBorderTop(BorderStyle.THIN);
			cell.setCellStyle(cellStyle);
			cell.setCellValue("第一轮");
			cell = secondRow.createCell(4);
			cell.setCellValue("第二轮");
			cell.setCellStyle(cellStyle);
			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

			RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
			RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
			RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);
			List<Manyrifmatch> manyrifmatchs = manyrifmatchService.findWhoJoinThisMatchThisListAndHasConfirm(matchid,
					matchlistid, gageid);
			Collections.sort(manyrifmatchs);
			int i = 3;
			for (Manyrifmatch manyrifmatch : manyrifmatchs) {
				XSSFRow scoreRow = sheet.createRow(i);
				XSSFCell scoreCell = null;
				scoreCell = scoreRow.createCell(0);
				scoreCell.setCellValue(manyrifmatch.getNum());
				scoreCell.setCellStyle(cellStyle);
			
				scoreCell = scoreRow.createCell(1);
				scoreCell.setCellValue(manyrifmatch.getTeamname());
				scoreCell.setCellStyle(cellStyle);
				
				scoreCell = scoreRow.createCell(2);
				scoreCell.setCellValue(manyrifmatch.getName());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(3);
				
				scoreCell.setCellValue(manyrifmatch.getScoreonebytranslate());
				scoreCell.setCellStyle(cellStyle);
				
				scoreCell = scoreRow.createCell(4);
				scoreCell.setCellValue(manyrifmatch.getScoretwobytranslate());
				scoreCell.setCellStyle(cellStyle);
				
				scoreCell = scoreRow.createCell(5);
				scoreCell.setCellValue(manyrifmatch.getScorefinal());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(6);
				
				scoreCell.setCellValue(manyrifmatch.getRank());
				scoreCell.setCellStyle(cellStyle);
				scoreCell = scoreRow.createCell(7);
				
				scoreCell.setCellValue(manyrifmatch.getReward());
				scoreCell.setCellStyle(cellStyle);
				
				scoreCell = scoreRow.createCell(8);
				scoreCell.setCellStyle(cellStyle);
				scoreCell.setCellValue("");
				i++;
				
			}
			// bookpath= matchList.getName() +gageName+ ".xlsx";
			// File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" +
			// matchList.getName() +gageName+ ".xlsx");
			bookpath = matchList.getName() + gageName + ".xlsx";
			File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
			try {
				file.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workbook.write(stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		model.addAttribute("pphh", bookpath);
		return "downloadXlsx";
	}

	/*
	 * 团体赛事
	 */
	@RequestMapping("downloadTeamMatchBook")
	public String downloadTeamMatchBook(int matchid, int gageid, Model model) {
		List<JoinMatchTeam> joinMatchTeams = joinMatchTeamService.findthismatchteam(matchid);

		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("团体赛");
		XSSFPrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE); // 纸张
		// sheet.setDisplayGridlines(false);
		sheet.setPrintGridlines(false);
		sheet.setMargin(XSSFSheet.TopMargin, (double) 1); // 上边距
		sheet.setMargin(XSSFSheet.BottomMargin, (double) 1); // 下边距
		sheet.setMargin(XSSFSheet.LeftMargin, (double) 1); // 左边距
		sheet.setMargin(XSSFSheet.RightMargin, (double) 1); // 右边距
		XSSFCellStyle cellStyle = workbook.createCellStyle(); // 单元格样式
		// XSSFCellStyle cellStylehead = workbook.createCellStyle(); // 单元格样式
		Font fontStyle = workbook.createFont(); // 字体样式
		// fontStyle.setBold(true); // 加粗
		fontStyle.setFontName("仿宋"); // 字体
		fontStyle.setFontHeightInPoints((short) 9); // 大小
		// 将字体样式添加到单元格样式中
		cellStyle.setFont(fontStyle);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);

		for (JoinMatchTeam joinMatchTeam : joinMatchTeams) {
			int teamscore = 0;
			List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService
					.findwhoisTeamMatch(joinMatchTeam.getId());
			for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
				if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
						|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
						|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
						|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
						|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 30
						|| joinMatchTeamPeople.getJoinmatchlist() == 20) {
					Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
							joinMatchTeamPeople.getId());
					teamscore += twoptionsmatch.getRank();
				} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
						|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
						|| joinMatchTeamPeople.getJoinmatchlist() == 13
						|| joinMatchTeamPeople.getJoinmatchlist() == 14) {
					Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService.findByjid(joinMatchTeamPeople.getId());
					teamscore += mangoptionsmatch.getRank();
				} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
						|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
						|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
						|| joinMatchTeamPeople.getJoinmatchlist() == 18) {
					Turnmatchlist turnmatchlist = turnMatchListService.findByJpId(joinMatchTeamPeople.getId());
					teamscore += turnmatchlist.getRankfinal();
				} else if (joinMatchTeamPeople.getJoinmatchlist() == 8) {
					Withfriendmatch withfriendmatch = withfriendmatchService.findByJpId(joinMatchTeamPeople.getId());
					teamscore += withfriendmatch.getRank();
				} else if (joinMatchTeamPeople.getJoinmatchlist() == 9
						|| joinMatchTeamPeople.getJoinmatchlist() == 25) {
					Manyrifmatch manyrifmatch = manyrifmatchService.findByJpId(joinMatchTeamPeople.getId());
					teamscore += manyrifmatch.getRank();
				}
			}

			joinMatchTeam.setTeamscore(teamscore);

		}

		Collections.sort(joinMatchTeams);
		int i = 1;

		for (JoinMatchTeam joinMatchTeam : joinMatchTeams) {
			joinMatchTeam.setTeamrank(i);
			i++;
			joinMatchTeamService.updateByPrimaryKeySelective(joinMatchTeam);
		}

		String bookpath = "";

		XSSFRow headRow = sheet.createRow(0);
		XSSFCell headCell = headRow.createCell(0);
		XSSFCellStyle headstyle1 = workbook.createCellStyle();
		XSSFCellStyle headstyle2 = workbook.createCellStyle();
		String gagename = "";
		if (gageid == 1 || gageid == 2) {
			gagename = "小学组综合团体";
			headCell.setCellValue("小学组综合团体");
		} else if (gageid == 3 || gageid == 4) {
			gagename = "初中组综合团体";
			headCell.setCellValue("初中组综合团体");
		} else if (gageid == 5 || gageid == 6) {
			gagename = "高中组综合团体";
			headCell.setCellValue("高中组综合团体");
		}
		sheet.setColumnWidth(0, 674);
		sheet.setColumnWidth(1, 1472);
		sheet.setColumnWidth(2, 6370);
		sheet.setColumnWidth(3, 7202);
		sheet.setColumnWidth(4, 832);
		sheet.setColumnWidth(5, 1088);
		sheet.setColumnWidth(6, 1216);

		headstyle1.setAlignment(HorizontalAlignment.LEFT);
		headstyle1.setBorderBottom(BorderStyle.DOUBLE);
		headCell.setCellStyle(headstyle1);
		headCell = headRow.createCell(4);
		headCell.setCellValue("比赛时间：" + "2018-10-22");
		headstyle2.setAlignment(HorizontalAlignment.RIGHT);
		headstyle2.setBorderBottom(BorderStyle.DOUBLE);
		headCell.setCellStyle(headstyle2);
		XSSFCellStyle secondheadCellStyle = workbook.createCellStyle();
		secondheadCellStyle.setFont(fontStyle);
		secondheadCellStyle.setAlignment(HorizontalAlignment.CENTER);
		secondheadCellStyle.setVerticalAlignment(VerticalAlignment.CENTER);

		secondheadCellStyle.setBorderLeft(BorderStyle.THIN);
		secondheadCellStyle.setBorderBottom(BorderStyle.THIN);
		secondheadCellStyle.setBorderTop(BorderStyle.DOUBLE);
		secondheadCellStyle.setBorderRight(BorderStyle.THIN);
		XSSFRow secondHeadrow = sheet.createRow(1);
		XSSFCell secondCell = secondHeadrow.createCell(0);
		XSSFCell teamCell = null;
		secondCell.setCellValue("编号");
		secondCell.setCellStyle(secondheadCellStyle);

		secondCell = secondHeadrow.createCell(1);

		secondCell.setCellValue("姓名");
		secondCell.setCellStyle(secondheadCellStyle);
		secondCell = secondHeadrow.createCell(2);
		secondCell.setCellValue("参赛队");
		secondCell.setCellStyle(secondheadCellStyle);
		secondCell = secondHeadrow.createCell(3);
		secondCell.setCellValue("项目");
		secondCell.setCellStyle(secondheadCellStyle);
		secondCell = secondHeadrow.createCell(4);
		secondCell.setCellValue("成绩");
		secondCell.setCellStyle(secondheadCellStyle);
		secondCell = secondHeadrow.createCell(5);
		secondCell.setCellValue("团队分");
		secondCell.setCellStyle(secondheadCellStyle);
		secondCell = secondHeadrow.createCell(6);
		secondCell.setCellStyle(secondheadCellStyle);
		secondCell.setCellValue("名次");
		int recv = 2;
		int k = 2;
		XSSFRow peoplerow = null;
		List<JoinMatchTeamPeople> joinMatchTeamPeoples = new ArrayList<JoinMatchTeamPeople>();
		for (JoinMatchTeam joinMatchTeam : joinMatchTeams) {

			if (gageid == 1 || gageid == 2) {
				joinMatchTeamPeoples = joinMatchTeamPeopleService.findwhoisTeamMatchSmall(joinMatchTeam.getId());
			} else if (gageid == 3 || gageid == 4) {
				joinMatchTeamPeoples = joinMatchTeamPeopleService.findwhoisTeamMatchMiddle(joinMatchTeam.getId());
			} else if (gageid == 5 || gageid == 6) {
				joinMatchTeamPeoples = joinMatchTeamPeopleService.findwhoisTeamMatchHigh(joinMatchTeam.getId());
			}

			for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
				if (null == joinMatchTeamPeople.getJoinmatchlist()) {
					joinMatchTeamPeople.setJoinmatchlist(0);
				}
				if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
						|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
						|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
						|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
						|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 30
						|| joinMatchTeamPeople.getJoinmatchlist() == 20) {
					Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
							joinMatchTeamPeople.getId());
					peoplerow = sheet.createRow(recv);
					XSSFCell peoplecell = peoplerow.createCell(0);
					peoplecell.setCellValue(twoptionsmatch.getNum());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(1);
					peoplecell.setCellValue(twoptionsmatch.getName());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(2);
					peoplecell.setCellValue(twoptionsmatch.getTeamname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(3);
					peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(4);
					peoplecell.setCellStyle(cellStyle);
					peoplecell.setCellValue(twoptionsmatch.getRank());

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
						|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
						|| joinMatchTeamPeople.getJoinmatchlist() == 13
						|| joinMatchTeamPeople.getJoinmatchlist() == 14) {
					Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService.findByjid(joinMatchTeamPeople.getId());
					peoplerow = sheet.createRow(recv);
					XSSFCell peoplecell = peoplerow.createCell(0);
					peoplecell.setCellValue(mangoptionsmatch.getNum());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(1);
					peoplecell.setCellValue(mangoptionsmatch.getName());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(2);
					peoplecell.setCellValue(mangoptionsmatch.getTeamname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(3);
					peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(4);
					peoplecell.setCellStyle(cellStyle);
					peoplecell.setCellValue(mangoptionsmatch.getRank());

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
						|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
						|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
						|| joinMatchTeamPeople.getJoinmatchlist() == 18) {
					Turnmatchlist turnmatchlist = turnMatchListService.findByJpId(joinMatchTeamPeople.getId());
					peoplerow = sheet.createRow(recv);
					XSSFCell peoplecell = peoplerow.createCell(0);
					peoplecell.setCellValue(turnmatchlist.getNum());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(1);
					peoplecell.setCellValue(turnmatchlist.getName());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(2);
					peoplecell.setCellValue(turnmatchlist.getTeamname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(3);
					peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(4);
					peoplecell.setCellValue(turnmatchlist.getRankfinal());
					peoplecell.setCellStyle(cellStyle);

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 8) {
					Withfriendmatch withfriendmatch = withfriendmatchService.findByJpId(joinMatchTeamPeople.getId());
					peoplerow = sheet.createRow(recv);
					XSSFCell peoplecell = peoplerow.createCell(0);
					peoplecell.setCellValue(withfriendmatch.getNum());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(1);
					peoplecell.setCellValue(withfriendmatch.getName());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(2);
					peoplecell.setCellValue(withfriendmatch.getTeamname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(3);
					peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(4);
					peoplecell.setCellValue(withfriendmatch.getRank());
					peoplecell.setCellStyle(cellStyle);

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 9
						|| joinMatchTeamPeople.getJoinmatchlist() == 25) {
					Manyrifmatch manyrifmatch = manyrifmatchService.findByJpId(joinMatchTeamPeople.getId());
					peoplerow = sheet.createRow(recv);
					XSSFCell peoplecell = peoplerow.createCell(0);
					peoplecell.setCellValue(manyrifmatch.getNum());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(1);
					peoplecell.setCellValue(manyrifmatch.getName());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(2);
					peoplecell.setCellValue(manyrifmatch.getTeamname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(3);
					peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(4);
					peoplecell.setCellValue(manyrifmatch.getRank());
					peoplecell.setCellStyle(cellStyle);

				} else {
					peoplerow = sheet.createRow(recv);
					XSSFCell peoplecell = peoplerow.createCell(0);
					peoplecell.setCellValue(joinMatchTeamPeople.getScore2());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(1);
					peoplecell.setCellValue(joinMatchTeamPeople.getName());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(2);
					peoplecell.setCellValue(joinMatchTeamPeople.getTeamname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(3);
					peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
					peoplecell.setCellStyle(cellStyle);
					peoplecell = peoplerow.createCell(4);
					peoplecell.setCellStyle(cellStyle);
					peoplecell.setCellValue("0");

				}
				CellRangeAddress cra1 = new CellRangeAddress(recv, recv + 1, 0, 1);

				CellRangeAddress cra2 = new CellRangeAddress(recv, recv + 1, 1, 2);

				CellRangeAddress cra3 = new CellRangeAddress(recv, recv + 1, 2, 3);

				CellRangeAddress cra4 = new CellRangeAddress(recv, recv + 1, 3, 4);

				RegionUtil.setBorderTop(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

				RegionUtil.setBorderTop(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

				RegionUtil.setBorderTop(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

				RegionUtil.setBorderTop(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

				recv++;

			}

			if (joinMatchTeamPeoples.size() != 0) {
				System.out.println(k);
				System.out.println("joinMatchTeamPeoples.size()" + joinMatchTeamPeoples.size());
				System.out.println((k + joinMatchTeamPeoples.size() - 1));
				CellRangeAddress cra5 = new CellRangeAddress(k, (k + joinMatchTeamPeoples.size() - 1), 5, 5);
				CellRangeAddress cra6 = new CellRangeAddress(k, (k + joinMatchTeamPeoples.size() - 1), 6, 6);
				sheet.addMergedRegion(cra5);
				sheet.addMergedRegion(cra6);
;
System.out.println(peoplerow.getRowNum()+"getRowNum");
	peoplerow=sheet.getRow(k);
				teamCell = peoplerow.createCell(5);
				teamCell.setCellStyle(cellStyle);
				teamCell.setCellValue(joinMatchTeam.getTeamscore());
				//teamCell.setCellValue("nadioaodwi");

				teamCell = peoplerow.createCell(6);
				teamCell.setCellStyle(cellStyle);
				//teamCell.setCellValue(joinMatchTeam.getTeamrank());
				RegionUtil.setBorderTop(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

				RegionUtil.setBorderTop(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

				k = recv;
			}

		}

		bookpath = gagename + ".xlsx";
		File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + bookpath);
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("pphh", bookpath);
		return "downloadXlsx";

	}

	/*
	 * 证书下载
	 */
	@RequestMapping("downloadZhengShu")
	public String downloadZhengShu(int matchid, Model model) {
		XSSFWorkbook workBook = new XSSFWorkbook();

		List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService.findThisMatchjoinPeople(matchid);
		Match match = matchService.selectByPrimaryKey(matchid);
		List<JoinMatchTeamPeople> needlist = new ArrayList<JoinMatchTeamPeople>();
		for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
			if (null == joinMatchTeamPeople.getJoinmatchlist()) {

				joinMatchTeamPeople.setJoinmatchlist(0);

			}
			if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
					|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
					|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
					|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
					|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 20
					|| joinMatchTeamPeople.getJoinmatchlist() == 30) {
				Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
						joinMatchTeamPeople.getId());
				if (null == twoptionsmatch) {
					twoptionsmatch = new Twoptionsmatch();
					twoptionsmatch.setRank(99);
					twoptionsmatch.setReward("0");
				}
				if ((twoptionsmatch.getRank() <= 8 || twoptionsmatch.getReward().length() >= 2)
						&& twoptionsmatch.getRank() != 0) {
					needlist.add(joinMatchTeamPeople);
				}

			} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
					|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
					|| joinMatchTeamPeople.getJoinmatchlist() == 13 || joinMatchTeamPeople.getJoinmatchlist() == 14) {
				Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService
						.findBySnJid(joinMatchTeamPeople.getPeoplesn(), joinMatchTeamPeople.getId());
				if (null == mangoptionsmatch) {
					mangoptionsmatch = new Mangoptionsmatch();
					mangoptionsmatch.setRank(99);
					mangoptionsmatch.setReward("0");
				}
				if ((mangoptionsmatch.getRank() <= 8 || mangoptionsmatch.getReward().length() >= 2)
						&& mangoptionsmatch.getRank() != 0) {
					needlist.add(joinMatchTeamPeople);
				}

			} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
					|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
					|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
					|| joinMatchTeamPeople.getJoinmatchlist() == 18) {
				Turnmatchlist turnmatchlist = turnMatchListService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
						joinMatchTeamPeople.getId());
				if (null == turnmatchlist) {
					turnmatchlist = new Turnmatchlist();
					turnmatchlist.setRankfinal(99);
					turnmatchlist.setReward("0");
				}
				if ((turnmatchlist.getRankfinal() <= 8 || turnmatchlist.getReward().length() >= 2)
						&& turnmatchlist.getRankfinal() != 0) {
					needlist.add(joinMatchTeamPeople);
				}
			}

		}
		System.out.println("needlist:" + needlist.size());
		int i = 1;
		String bookpath = null;
		for (JoinMatchTeamPeople joinMatchTeamPeople : needlist) {
			String sex = "";

			XSSFSheet sheet = workBook.createSheet(Integer.toString(i));
			i++;
			XSSFPrintSetup printSetup = sheet.getPrintSetup();
			printSetup.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE); // 纸张
			// sheet.setDisplayGridlines(false);
			sheet.setPrintGridlines(false);
			sheet.setMargin(XSSFSheet.TopMargin, (double) 1); // 上边距
			sheet.setMargin(XSSFSheet.BottomMargin, (double) 1); // 下边距
			sheet.setMargin(XSSFSheet.LeftMargin, (double) 1); // 左边距
			sheet.setMargin(XSSFSheet.RightMargin, (double) 1); // 右边距

			XSSFRow oneRow = sheet.createRow(1);
			XSSFCell onecell = null;

			XSSFCellStyle oneStyle = workBook.createCellStyle();

			sheet.setColumnWidth(0, 2144);// 7.75
			sheet.setColumnWidth(1, 4193);// 16.38
			sheet.setColumnWidth(2, 1633);// 6.38
			sheet.setColumnWidth(3, 954);// 3.8
			sheet.setColumnWidth(4, 2200);// 8.38
			sheet.setColumnWidth(5, 2780);// 10.25
			sheet.setColumnWidth(6, 1536);// 6
			sheet.setColumnWidth(7, 2000);// 7.75
			sheet.setColumnWidth(8, 1550);// 5.52
			sheet.setColumnWidth(9, 1530);// 5.38
			sheet.setColumnWidth(10, 3600);// 10.13

			XSSFRow temprow = sheet.createRow(18);
			temprow.setHeightInPoints(17.25f);
			XSSFRow temprow1 = sheet.createRow(19);
			temprow1.setHeightInPoints(3.75f);
			XSSFRow headrow = sheet.createRow(0);
			headrow.setHeightInPoints(93.75F);
			// headrow.setHeightInPoints(93.75F);
			XSSFRow firstRow = sheet.createRow(6);
			XSSFCell cell = null;
			cell = firstRow.createCell(2);
			firstRow.setHeightInPoints(52.5F);
			cell.setCellValue(match.getName());

			XSSFCellStyle centerStyle = workBook.createCellStyle();
			Font no1Font = workBook.createFont();
			no1Font.setFontHeightInPoints((short) 16);
			no1Font.setFontName("宋体");
			no1Font.setBold(true);
			// no1Font.setFontHeightInPoints((short)700);

			centerStyle.setFont(no1Font);
			centerStyle.setAlignment(HorizontalAlignment.CENTER);
			centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
			CellRangeAddress region = new CellRangeAddress(6, 6, 2, 10);
			sheet.addMergedRegion(region);

			XSSFCellStyle centerStyle2 = workBook.createCellStyle();

			Font no2Font = workBook.createFont();
			no2Font.setFontHeightInPoints((short) 16);
			no2Font.setFontName("宋体");
			no2Font.setBold(true);
			centerStyle2.setFont(no2Font);
			centerStyle2.setAlignment(HorizontalAlignment.CENTER);
			centerStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
			CellRangeAddress region2 = new CellRangeAddress(7, 7, 6, 7);
			sheet.addMergedRegion(region2);

			cell.setCellStyle(centerStyle);

			XSSFRow firstRow1 = sheet.createRow(7);
			firstRow1.setHeightInPoints(39.75F);
			XSSFCell cell1 = null;
			cell1 = firstRow1.createCell(6);

			cell1.setCellValue(joinMatchTeamPeople.getName());
			cell1.setCellStyle(centerStyle2);

			XSSFCellStyle centerStyle3 = workBook.createCellStyle();

			XSSFCellStyle centerStyle5 = workBook.createCellStyle();

			centerStyle3.setFont(no1Font);

			centerStyle3.setAlignment(HorizontalAlignment.CENTER);
			centerStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
			CellRangeAddress region3 = new CellRangeAddress(8, 8, 2, 10);
			sheet.addMergedRegion(region3);
			CellRangeAddress region4 = new CellRangeAddress(9, 9, 3, 5);
			sheet.addMergedRegion(region4);
			CellRangeAddress region5 = new CellRangeAddress(9, 9, 6, 7);
			sheet.addMergedRegion(region5);
			CellRangeAddress region6 = new CellRangeAddress(9, 9, 8, 10);
			sheet.addMergedRegion(region6);
			CellRangeAddress region7 = new CellRangeAddress(10, 10, 3, 5);
			sheet.addMergedRegion(region7);
			CellRangeAddress region8 = new CellRangeAddress(10, 10, 8, 10);
			sheet.addMergedRegion(region8);

			XSSFRow firstRow2 = sheet.createRow(8);
			firstRow2.setHeightInPoints(22.5F);
			XSSFCell cell2 = null;
			cell2 = firstRow2.createCell(2);
			cell2.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
			cell2.setCellStyle(centerStyle3);

			XSSFRow firstRow3 = sheet.createRow(9);
			firstRow3.setHeightInPoints(18.75F);
			XSSFCell cell3 = null;
			XSSFCellStyle centerStyle4 = workBook.createCellStyle();

			centerStyle4.setFont(no2Font);
			centerStyle4.setAlignment(HorizontalAlignment.CENTER);
			centerStyle4.setVerticalAlignment(VerticalAlignment.CENTER);

			cell3 = firstRow3.createCell(3);
			if (null == joinMatchTeamPeople.getGage()) {
				joinMatchTeamPeople.setGage(7);
			}
			if (joinMatchTeamPeople.getGage().intValue() == 1) {
				sex = "小学男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 2) {
				sex = "小学女子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 3) {
				sex = "初中男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 4) {
				sex = "初中女子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 5) {
				sex = "高中男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 6) {
				sex = "高中女子组";
			} else {
				sex = "教练组";

			}
			cell3.setCellValue(sex);
			cell3.setCellStyle(centerStyle4);
			cell3 = firstRow3.createCell(6);
			if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
					|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
					|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
					|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
					|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 20
					|| joinMatchTeamPeople.getJoinmatchlist() == 30) {
				Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
						joinMatchTeamPeople.getId());
				cell3.setCellValue("第" + twoptionsmatch.getRank().intValue() + "名");
				cell3.setCellStyle(centerStyle4);
				cell3 = firstRow3.createCell(8);
				cell3.setCellStyle(centerStyle4);
				cell3.setCellValue(twoptionsmatch.getFinalscore());
				cell3.setCellStyle(centerStyle4);
			} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
					|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
					|| joinMatchTeamPeople.getJoinmatchlist() == 13 || joinMatchTeamPeople.getJoinmatchlist() == 14) {
				Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService
						.findBySnJid(joinMatchTeamPeople.getPeoplesn(), joinMatchTeamPeople.getId());
				cell3.setCellValue("第" + mangoptionsmatch.getRank().intValue() + "名");
				cell3.setCellStyle(centerStyle4);
				cell3 = firstRow3.createCell(8);
				cell3.setCellStyle(centerStyle4);
				cell3.setCellValue(mangoptionsmatch.getScorefinal());
				cell3.setCellStyle(centerStyle4);
			} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
					|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
					|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
					|| joinMatchTeamPeople.getJoinmatchlist() == 18) {
				Turnmatchlist turnmatchlist = turnMatchListService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
						joinMatchTeamPeople.getId());
				if (null == turnmatchlist.getRankfinal()) {
					turnmatchlist.setRankfinal(99);
				}
				System.out.println(turnmatchlist.getRankfinal());
				cell3.setCellValue("第" + turnmatchlist.getRankfinal() + "名");
				cell3.setCellStyle(centerStyle4);
				cell3 = firstRow3.createCell(8);
				cell3.setCellStyle(centerStyle4);
				cell3.setCellValue(turnmatchlist.getFinalscore());
				cell3.setCellStyle(centerStyle4);
			}

			XSSFRow firstRow4 = sheet.createRow(10);
			firstRow4.setHeightInPoints(57.75F);
			XSSFCell cell4 = null;

			centerStyle5.setFont(no2Font);
			centerStyle5.setAlignment(HorizontalAlignment.CENTER);
			centerStyle5.setVerticalAlignment(VerticalAlignment.CENTER);

			cell4 = firstRow4.createCell(3);
			cell4.setCellValue("2018-10-22");
			cell4.setCellStyle(centerStyle5);
			cell4 = firstRow4.createCell(8);
			cell4.setCellValue("郑州上街 ");
			cell4.setCellStyle(centerStyle5);
			/*
			 * 加入图片
			 */

			// XSSFDrawing drawing=sheet.createDrawingPatriarch();
			// XSSFClientAnchor anchor=new XSSFClientAnchor(dx1, dy1, dx2, dy2,
			// col1, row1, col2, row2);
			//

			// pphh = joinMatchTeamPeople.getJoinmatchlistinname() + sex +
			// "����.xlsx";
			// model.addAttribute("pphh", pphh);
			// System.out.println("����");

			bookpath = "证书" + ".xlsx";
			File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + bookpath);
			// 第19行 19.13
			BufferedImage bfi = null;
			BufferedImage bfi1 = null;
			BufferedImage bfi2 = null;
			try {
				ByteArrayOutputStream byteArryOut = new ByteArrayOutputStream();
				ByteArrayOutputStream byteArryOut1 = new ByteArrayOutputStream();
				ByteArrayOutputStream byteArryOut2 = new ByteArrayOutputStream();
				bfi = ImageIO.read(new File("D:/pictures/hos.png"));
				bfi1 = ImageIO.read(new File("D:/pictures/hos2.png"));
				bfi2 = ImageIO.read(new File("D:/pictures/zhangxinquan.png"));
				ImageIO.write(bfi, "png", byteArryOut);
				XSSFDrawing print = sheet.createDrawingPatriarch();
				XSSFClientAnchor anthor = new XSSFClientAnchor(0, 0, 255, 255, 4, 11, 6, 19);
				print.createPicture(anthor,
						workBook.addPicture(byteArryOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
				ImageIO.write(bfi1, "png", byteArryOut1);
				anthor = new XSSFClientAnchor(0, 0, 255, 255, 7, 11, 10, 20);
				print.createPicture(anthor,
						workBook.addPicture(byteArryOut1.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
				ImageIO.write(bfi2, "png", byteArryOut2);
				anthor = new XSSFClientAnchor(0, 0, 255, 255, 2, 15, 4, 18);
				print.createPicture(anthor,
						workBook.addPicture(byteArryOut2.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
				file.createNewFile();
				FileOutputStream stream = FileUtils.openOutputStream(file);
				workBook.write(stream);
				stream.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			System.out.println("end");

		}

		model.addAttribute("pphh", bookpath);

		return "downloadXlsx";
	}

	@RequestMapping("downloadZS")
	public String downloadZS(int matchid,int matchlistid,String zstype,Model model){
		XSSFWorkbook workBook = new XSSFWorkbook();
		
		
		MatchList matchList=matchListService.selectByPrimaryKey(matchlistid);
XSSFSheet sheet=workBook.createSheet(matchList.getName()+"名次");
XSSFSheet sheet2=workBook.createSheet(matchList.getName()+"等奖");
		List<JoinMatchTeamPeople> joinMatchTeamPeoples = joinMatchTeamPeopleService.findThisMatchThisMatchlist(matchid, matchlistid);
		Match match = matchService.selectByPrimaryKey(matchid);
		List<JoinMatchTeamPeople> mingcineedlist = new ArrayList<JoinMatchTeamPeople>();
		List<JoinMatchTeamPeople> dengjiangneedlist = new ArrayList<JoinMatchTeamPeople>();
		for (JoinMatchTeamPeople joinMatchTeamPeople : joinMatchTeamPeoples) {
			if (null==joinMatchTeamPeople.getGage()) {
				joinMatchTeamPeople.setGage(7);
			}
			if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
					|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
					|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
					|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
					|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 20
					|| joinMatchTeamPeople.getJoinmatchlist() == 30) {
				Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
						joinMatchTeamPeople.getId());
				if (null == twoptionsmatch) {
					twoptionsmatch = new Twoptionsmatch();
					twoptionsmatch.setRank(99);
					twoptionsmatch.setReward("0");
				}
				if ((twoptionsmatch.getRank() <= 8 )
						&& twoptionsmatch.getRank() != 0) {
					mingcineedlist.add(joinMatchTeamPeople);
				}
				if (twoptionsmatch.getReward().length() >= 2) {
					dengjiangneedlist.add(joinMatchTeamPeople);
				}

			} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
					|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
					|| joinMatchTeamPeople.getJoinmatchlist() == 13 || joinMatchTeamPeople.getJoinmatchlist() == 14) {
				Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService
						.findBySnJid(joinMatchTeamPeople.getPeoplesn(), joinMatchTeamPeople.getId());
				if (null == mangoptionsmatch) {
					mangoptionsmatch = new Mangoptionsmatch();
					mangoptionsmatch.setRank(99);
					mangoptionsmatch.setReward("0");
				}
				if ((mangoptionsmatch.getRank() <= 8 )
						&& mangoptionsmatch.getRank() != 0) {
					mingcineedlist.add(joinMatchTeamPeople);
				}
				if (mangoptionsmatch.getReward().length() >= 2) {
					dengjiangneedlist.add(joinMatchTeamPeople);
				}

			} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
					|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
					|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
					|| joinMatchTeamPeople.getJoinmatchlist() == 18) {
				Turnmatchlist turnmatchlist = turnMatchListService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
						joinMatchTeamPeople.getId());
				if (null == turnmatchlist) {
					turnmatchlist = new Turnmatchlist();
					turnmatchlist.setRankfinal(99);
					turnmatchlist.setReward("0");
				}
				if ((turnmatchlist.getRankfinal() <= 8)
						&& turnmatchlist.getRankfinal() != 0) {
					mingcineedlist.add(joinMatchTeamPeople);
				}
				if (turnmatchlist.getReward().length() >= 2) {
					dengjiangneedlist.add(joinMatchTeamPeople);
				}
			}else if(joinMatchTeamPeople.getJoinmatchlist() == 8){
				Withfriendmatch withfriendmatch=withfriendmatchService.findByJpId(joinMatchTeamPeople.getId());
				if (null == withfriendmatch) {
					withfriendmatch = new Withfriendmatch();
					withfriendmatch.setRank(99);
					withfriendmatch.setReward("0");
				}
				if ((withfriendmatch.getRank() <= 8)
						&& withfriendmatch.getRank() != 0) {
					mingcineedlist.add(joinMatchTeamPeople);
				}
				if (withfriendmatch.getReward().length() >= 2) {
					dengjiangneedlist.add(joinMatchTeamPeople);
				}
			}else if(joinMatchTeamPeople.getJoinmatchlist() == 9||joinMatchTeamPeople.getJoinmatchlist() == 25){
				Manyrifmatch manyrifmatch=manyrifmatchService.findByJpId(joinMatchTeamPeople.getId());
				if (null == manyrifmatch) {
					manyrifmatch = new Manyrifmatch();
					manyrifmatch.setRank(99);
					manyrifmatch.setReward("0");
				}
				if ((manyrifmatch.getRank() <= 8)
						&& manyrifmatch.getRank() != 0) {
					mingcineedlist.add(joinMatchTeamPeople);
				}
				if (manyrifmatch.getReward().length() >= 2) {
					dengjiangneedlist.add(joinMatchTeamPeople);
				}
			}
		}
		/*
		 * 名单准备完毕,开始生成excel
		 */
		XSSFRow headrow=sheet.createRow(0);
		XSSFCell headCell=headrow.createCell(0);	
		headCell.setCellValue("名称");
		headCell=headrow.createCell(1);
		headCell.setCellValue("项目");
		headCell=headrow.createCell(2);
		headCell.setCellValue("单位");
		headCell=headrow.createCell(3);
		headCell.setCellValue("组别");
		headCell=headrow.createCell(4);
		headCell.setCellValue("名次");
		headCell=headrow.createCell(5);
		headCell.setCellValue("成绩");
//		headCell=headrow.createCell(6);
//		headCell.setCellValue("等奖");
		XSSFRow headrow2=sheet2.createRow(0);
		XSSFCell headCell2=headrow2.createCell(0);	
		headCell2.setCellValue("名称");
		headCell2=headrow2.createCell(1);
		headCell2.setCellValue("项目");
		headCell2=headrow2.createCell(2);
		headCell2.setCellValue("单位");
		headCell2=headrow2.createCell(3);
		headCell2.setCellValue("组别");
		headCell2=headrow2.createCell(4);
//		headCell2.setCellValue("名次");
//		headCell2=headrow2.createCell(5);
		headCell2.setCellValue("成绩");
		headCell2=headrow2.createCell(5);
		headCell2.setCellValue("等奖");
		System.out.println("needlist:" + mingcineedlist.size());
		int i = 1;
		int j=1;
		String bookpath = null;
		String sex = "";
		for (JoinMatchTeamPeople joinMatchTeamPeople : mingcineedlist) {
		
			if (null == joinMatchTeamPeople.getGage()) {
				joinMatchTeamPeople.setGage(7);
			}
			if (joinMatchTeamPeople.getGage().intValue() == 1) {
				sex = "小学男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 2) {
				sex = "小学女子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 3) {
				sex = "初中男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 4) {
				sex = "初中女子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 5) {
				sex = "高中男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 6) {
				sex = "高中女子组";
			} else {
				sex = "教练组";
			}
			XSSFRow secondRow=sheet.createRow(i);
			XSSFCell peoplecell=secondRow.createCell(0);
			peoplecell.setCellValue(joinMatchTeamPeople.getName());
			 peoplecell=secondRow.createCell(1);
			 peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
			 peoplecell=secondRow.createCell(2);
			 peoplecell.setCellValue(joinMatchTeamPeople.getTeamname());
			 peoplecell=secondRow.createCell(3);
			 peoplecell.setCellValue(sex);
			 peoplecell=secondRow.createCell(4);
				if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
						|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
						|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
						|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
						|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 20
						|| joinMatchTeamPeople.getJoinmatchlist() == 30) {
					Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
							joinMatchTeamPeople.getId());
				
				
						 peoplecell.setCellValue(turnInt(twoptionsmatch.getRank()));
						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(twoptionsmatch.getFinalscore());
						 
					

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
						|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
						|| joinMatchTeamPeople.getJoinmatchlist() == 13 || joinMatchTeamPeople.getJoinmatchlist() == 14) {
					Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService
							.findBySnJid(joinMatchTeamPeople.getPeoplesn(), joinMatchTeamPeople.getId());
					
				
						 peoplecell.setCellValue(turnInt(mangoptionsmatch.getRank()));
						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(mangoptionsmatch.getScorefinal());
						
					

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
						|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
						|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
						|| joinMatchTeamPeople.getJoinmatchlist() == 18) {
					Turnmatchlist turnmatchlist = turnMatchListService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
							joinMatchTeamPeople.getId());
					
				
						 peoplecell.setCellValue(turnInt(turnmatchlist.getRankfinal()));
						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(turnmatchlist.getFinalscore());
					
					
				}else if(joinMatchTeamPeople.getJoinmatchlist() == 8){
					Withfriendmatch withfriendmatch=withfriendmatchService.findByJpId(joinMatchTeamPeople.getId());

					 peoplecell.setCellValue(turnInt(withfriendmatch.getRank()));
					 peoplecell=secondRow.createCell(5);
					 peoplecell.setCellValue(withfriendmatch.getFinalscore());
					
				}else if(joinMatchTeamPeople.getJoinmatchlist() == 9||joinMatchTeamPeople.getJoinmatchlist() == 25){
					Manyrifmatch manyrifmatch=manyrifmatchService.findByJpId(joinMatchTeamPeople.getId());

					 peoplecell.setCellValue(turnInt(manyrifmatch.getRank()));
					 peoplecell=secondRow.createCell(5);
					 peoplecell.setCellValue(manyrifmatch.getScorefinal());
				;
				}
			 i++;
			// peoplecell.setCellValue(joinMatchTeamPeople.getName());
		}
		for (JoinMatchTeamPeople joinMatchTeamPeople : dengjiangneedlist) {
			
			if (null == joinMatchTeamPeople.getGage()) {
				joinMatchTeamPeople.setGage(7);
			}
			if (joinMatchTeamPeople.getGage().intValue() == 1) {
				sex = "小学男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 2) {
				sex = "小学女子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 3) {
				sex = "初中男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 4) {
				sex = "初中女子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 5) {
				sex = "高中男子组";
			} else if (joinMatchTeamPeople.getGage().intValue() == 6) {
				sex = "高中女子组";
			} else {
				sex = "教练组";
			}
			XSSFRow secondRow=sheet2.createRow(j);
			XSSFCell peoplecell=secondRow.createCell(0);
			peoplecell.setCellValue(joinMatchTeamPeople.getName());
			 peoplecell=secondRow.createCell(1);
			 peoplecell.setCellValue(joinMatchTeamPeople.getJoinmatchlistinname());
			 peoplecell=secondRow.createCell(2);
			 peoplecell.setCellValue(joinMatchTeamPeople.getTeamname());
			 peoplecell=secondRow.createCell(3);
			 peoplecell.setCellValue(sex);
			 peoplecell=secondRow.createCell(4);
				if (joinMatchTeamPeople.getJoinmatchlist() == 1 || joinMatchTeamPeople.getJoinmatchlist() == 2
						|| joinMatchTeamPeople.getJoinmatchlist() == 3 || joinMatchTeamPeople.getJoinmatchlist() == 4
						|| joinMatchTeamPeople.getJoinmatchlist() == 6 || joinMatchTeamPeople.getJoinmatchlist() == 7
						|| joinMatchTeamPeople.getJoinmatchlist() == 32 || joinMatchTeamPeople.getJoinmatchlist() == 33
						|| joinMatchTeamPeople.getJoinmatchlist() == 19 || joinMatchTeamPeople.getJoinmatchlist() == 20
						|| joinMatchTeamPeople.getJoinmatchlist() == 30) {
					Twoptionsmatch twoptionsmatch = twoptionsMatchService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
							joinMatchTeamPeople.getId());
				
				
//						 peoplecell.setCellValue(turnInt(twoptionsmatch.getRank()));
//						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(twoptionsmatch.getFinalscore());
						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(twoptionsmatch.getReward());
					

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 5 || joinMatchTeamPeople.getJoinmatchlist() == 10
						|| joinMatchTeamPeople.getJoinmatchlist() == 11 || joinMatchTeamPeople.getJoinmatchlist() == 12
						|| joinMatchTeamPeople.getJoinmatchlist() == 13 || joinMatchTeamPeople.getJoinmatchlist() == 14) {
					Mangoptionsmatch mangoptionsmatch = mangoptionsmatchService
							.findBySnJid(joinMatchTeamPeople.getPeoplesn(), joinMatchTeamPeople.getId());
					
				
//						 peoplecell.setCellValue(turnInt(mangoptionsmatch.getRank()));
//						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(mangoptionsmatch.getScorefinal());
						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(mangoptionsmatch.getReward());
					

				} else if (joinMatchTeamPeople.getJoinmatchlist() == 23 || joinMatchTeamPeople.getJoinmatchlist() == 26
						|| joinMatchTeamPeople.getJoinmatchlist() == 27 || joinMatchTeamPeople.getJoinmatchlist() == 29
						|| joinMatchTeamPeople.getJoinmatchlist() == 31 || joinMatchTeamPeople.getJoinmatchlist() == 17
						|| joinMatchTeamPeople.getJoinmatchlist() == 18) {
					Turnmatchlist turnmatchlist = turnMatchListService.findBySnJid(joinMatchTeamPeople.getPeoplesn(),
							joinMatchTeamPeople.getId());
					
				
//						 peoplecell.setCellValue(turnInt(turnmatchlist.getRankfinal()));
//						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(turnmatchlist.getFinalscore());
						 peoplecell=secondRow.createCell(5);
						 peoplecell.setCellValue(turnmatchlist.getReward());
					
				}else if(joinMatchTeamPeople.getJoinmatchlist() == 8){
					Withfriendmatch withfriendmatch=withfriendmatchService.findByJpId(joinMatchTeamPeople.getId());

//					 peoplecell.setCellValue(turnInt(withfriendmatch.getRank()));
//					 peoplecell=secondRow.createCell(5);
					 peoplecell.setCellValue(withfriendmatch.getFinalscore());
					 peoplecell=secondRow.createCell(5);
					 peoplecell.setCellValue(withfriendmatch.getReward());
				}else if(joinMatchTeamPeople.getJoinmatchlist() == 9||joinMatchTeamPeople.getJoinmatchlist() == 25){
					Manyrifmatch manyrifmatch=manyrifmatchService.findByJpId(joinMatchTeamPeople.getId());

//					 peoplecell.setCellValue(turnInt(manyrifmatch.getRank()));
//					 peoplecell=secondRow.createCell(5);
					 peoplecell.setCellValue(manyrifmatch.getScorefinal());
					 peoplecell=secondRow.createCell(5);
					 peoplecell.setCellValue(manyrifmatch.getReward());
				}
			 j++;
			// peoplecell.setCellValue(joinMatchTeamPeople.getName());
		}
		bookpath = matchList.getName() + "名次等奖.xlsx";
		File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + bookpath);
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workBook.write(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		model.addAttribute("pphh", bookpath);
		return "downloadXlsx";
		
		//return "";
	}

	/*
	 * 成绩册
	 */
	@RequestMapping("downloadAllscore")
	public String printAllScore(int matchid,Model model) {
		
		String bookpath = "";
		Match match = matchService.selectByPrimaryKey(matchid);
		
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet(match.getName()+"成绩册");
		XSSFPrintSetup printSetup = sheet.getPrintSetup();
		printSetup.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE); // 纸张
		// sheet.setDisplayGridlines(false);
		sheet.setPrintGridlines(false);
		sheet.setMargin(XSSFSheet.TopMargin, (double) 1); // 上边距
		sheet.setMargin(XSSFSheet.BottomMargin, (double) 1); // 下边距
		sheet.setMargin(XSSFSheet.LeftMargin, (double) 1); // 左边距
		sheet.setMargin(XSSFSheet.RightMargin, (double) 1); // 右边距
		XSSFCellStyle cellStyle = workbook.createCellStyle(); // 单元格样式
		Font fontStyle = workbook.createFont(); // 字体样式
		// fontStyle.setBold(true); // 加粗
		fontStyle.setFontName("仿宋"); // 字体
		fontStyle.setFontHeightInPoints((short) 8); // 大小
		// 将字体样式添加到单元格样式中
		cellStyle.setFont(fontStyle);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		cellStyle.setBorderTop(BorderStyle.THIN);
		cellStyle.setBorderBottom(BorderStyle.THIN);
		cellStyle.setBorderLeft(BorderStyle.THIN);
		cellStyle.setBorderRight(BorderStyle.THIN);
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
		int i=0;
		String gageName = "";


		for (MatchList matchList : thisMatchListInfo) {
			
		

		List<MatchGroup> matchGroups=matchGroupService.findAll();
		for (MatchGroup matchGroup : matchGroups) {
			
			switch (matchGroup.getId()) {
			case 1:
				gageName = "小学男子组";
				break;
			case 2:
				gageName = "小学女子组";
				break;
			case 3:
				gageName = "初中男子组";
				break;
			case 4:
				gageName = "初中女子组";
				break;
			case 5:
				gageName = "高中男子组";
				break;
			case 6:
				gageName = "高中女子组";
				break;
			case 7:
				gageName = "教练组";
				break;
			default:
				break;
			}
			
			
			if (matchList.getId() == 1 || matchList.getId() == 2 || matchList.getId() == 3 || matchList.getId() == 4 || matchList.getId() == 6
					|| matchList.getId() == 7 || matchList.getId() == 32 || matchList.getId() == 33 || matchList.getId() == 19 || matchList.getId() == 30
					|| matchList.getId() == 20) {
				XSSFRow headRow = sheet.createRow(i);
				XSSFCell headCell = headRow.createCell(0);
				XSSFCellStyle headstyle1 = workbook.createCellStyle();
				XSSFCellStyle headstyle2 = workbook.createCellStyle();
				headCell.setCellValue(gageName + matchList.getName());
				headstyle1.setAlignment(HorizontalAlignment.LEFT);
				headstyle1.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle1);
				headCell = headRow.createCell(4);
				headCell.setCellValue("比赛时间：" + "2018-10-22");
				headstyle2.setAlignment(HorizontalAlignment.RIGHT);
				headstyle2.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle2);
				CellRangeAddress cra0 = new CellRangeAddress(i, i, 0, 3);
				sheet.addMergedRegion(cra0);
				CellRangeAddress crax = new CellRangeAddress(i, i, 4, 8);
				sheet.addMergedRegion(crax);
				i++;
				XSSFRow firstRow = sheet.createRow(i);
				i++;
				XSSFRow secondRow = sheet.createRow(i);
				sheet.setColumnWidth(0, 1300);
				sheet.setColumnWidth(1, 5500);
				sheet.setColumnWidth(2, 1500);
				sheet.setColumnWidth(3, 2200);
				sheet.setColumnWidth(4, 2200);
				sheet.setColumnWidth(5, 2200);
				sheet.setColumnWidth(6, 1500);
				sheet.setColumnWidth(7, 1500);
				sheet.setColumnWidth(8, 1500);
				XSSFCell cell = null;
/*
 * i=2
 */
				CellRangeAddress cra1 = new CellRangeAddress(i-1, i, 0, 0);
				sheet.addMergedRegion(cra1);// 合并
				CellRangeAddress cra2 = new CellRangeAddress(i-1, i, 1, 1);
				sheet.addMergedRegion(cra2);// 合并
				CellRangeAddress cra3 = new CellRangeAddress(i-1, i, 2, 2);
				sheet.addMergedRegion(cra3);// 合并
				CellRangeAddress cra4 = new CellRangeAddress(i-1, i, 3, 4);
				sheet.addMergedRegion(cra4);
				CellRangeAddress cra5 = new CellRangeAddress(i-1, i, 5, 5);
				sheet.addMergedRegion(cra5);
				CellRangeAddress cra6 = new CellRangeAddress(i-1, i, 6, 6);
				sheet.addMergedRegion(cra6);
				CellRangeAddress cra7 = new CellRangeAddress(i-1, i, 7, 7);
				sheet.addMergedRegion(cra7);
				CellRangeAddress cra8 = new CellRangeAddress(i-1, i, 8, 8);
				sheet.addMergedRegion(cra8);

				cell = firstRow.createCell(0);
				cell.setCellValue("编号");

				cell.setCellStyle(cellStyle);
				cell = firstRow.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("单位");
				cell = firstRow.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("姓名");
				cell = firstRow.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("飞行成绩");
				cell = firstRow.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("总成绩");
				cell = firstRow.createCell(6);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("名次");
				cell = firstRow.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("奖项");
				cell = firstRow.createCell(8);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("备注");
				cell = secondRow.createCell(3);
				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN);
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("第一轮");
				cell = secondRow.createCell(4);
				cell.setCellValue("第二轮");
				cell.setCellStyle(cellStyle);
				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);

				/*
				 * 开始写入成绩
				 */
				List<Twoptionsmatch> twoptionsmatchs = twoptionsMatchService
						.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchList.getId(), matchGroup.getId());
				/*
				 * 此处需要排序 升序
				 */
				Collections.sort(twoptionsmatchs);
				 i++;
				for (Twoptionsmatch twoptionsmatch : twoptionsmatchs) {

					XSSFRow scoreRow = sheet.createRow(i);
					XSSFCell scoreCell = null;

					scoreCell = scoreRow.createCell(0);
					scoreCell.setCellValue(twoptionsmatch.getNum());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(1);
					scoreCell.setCellValue(twoptionsmatch.getTeamname());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(2);
					scoreCell.setCellValue(twoptionsmatch.getName());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(3);
					scoreCell.setCellValue(twoptionsmatch.getScoreone());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(4);
					scoreCell.setCellValue(twoptionsmatch.getScoretwo());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(5);
					scoreCell.setCellValue(twoptionsmatch.getFinalscore());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(6);
					scoreCell.setCellValue(twoptionsmatch.getRank());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(7);
					scoreCell.setCellValue(twoptionsmatch.getReward());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(8);
					scoreCell.setCellStyle(cellStyle);
					scoreCell.setCellValue("");
					i++;
				}
//				bookpath = matchList.getName() + gageName + ".xlsx";
//				File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
//				try {
//					file.createNewFile();
//					FileOutputStream stream = FileUtils.openOutputStream(file);
//					workbook.write(stream);
//					stream.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				i++;
			} else if (matchList.getId() == 5 || matchList.getId() == 10 || matchList.getId() == 11 || matchList.getId() == 12 || matchList.getId() == 13
					|| matchList.getId() == 14) {
				XSSFRow headRow = sheet.createRow(i);
				XSSFCell headCell = headRow.createCell(0);
				XSSFCellStyle headstyle1 = workbook.createCellStyle();
				XSSFCellStyle headstyle2 = workbook.createCellStyle();
				headCell.setCellValue(gageName + matchList.getName());
				headstyle1.setAlignment(HorizontalAlignment.LEFT);
				headstyle1.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle1);
				headCell = headRow.createCell(4);
				headCell.setCellValue("比赛时间：" + "2018-10-22");
				headstyle2.setAlignment(HorizontalAlignment.RIGHT);
				headstyle2.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle2);
				CellRangeAddress cra0 = new CellRangeAddress(i, i, 0, 3);
				sheet.addMergedRegion(cra0);
				CellRangeAddress crax = new CellRangeAddress(i, i, 4, 8);
				sheet.addMergedRegion(crax);
				i++;
				XSSFRow firstRow = sheet.createRow(i);
				i++;
				XSSFRow secondRow = sheet.createRow(i);
				sheet.setColumnWidth(0, 1300);
				sheet.setColumnWidth(1, 5500);
				sheet.setColumnWidth(2, 1500);
				sheet.setColumnWidth(3, 2200);
				sheet.setColumnWidth(4, 2200);
				sheet.setColumnWidth(5, 2200);
				sheet.setColumnWidth(6, 1500);
				sheet.setColumnWidth(7, 1500);
				sheet.setColumnWidth(8, 1500);
				XSSFCell cell = null;

				CellRangeAddress cra1 = new CellRangeAddress(i-1, i, 0, 0);
				sheet.addMergedRegion(cra1);// 合并
				CellRangeAddress cra2 = new CellRangeAddress(i-1, i, 1, 1);
				sheet.addMergedRegion(cra2);// 合并
				CellRangeAddress cra3 = new CellRangeAddress(i-1, i, 2, 2);
				sheet.addMergedRegion(cra3);// 合并
				CellRangeAddress cra4 = new CellRangeAddress(i-1,  i, 3, 4);
				sheet.addMergedRegion(cra4);
				CellRangeAddress cra5 = new CellRangeAddress(i-1,  i, 5, 5);
				sheet.addMergedRegion(cra5);
				CellRangeAddress cra6 = new CellRangeAddress(i-1,  i, 6, 6);
				sheet.addMergedRegion(cra6);
				CellRangeAddress cra7 = new CellRangeAddress(i-1,  i, 7, 7);
				sheet.addMergedRegion(cra7);
				CellRangeAddress cra8 = new CellRangeAddress(i-1,  i, 8, 8);
				sheet.addMergedRegion(cra8);

				cell = firstRow.createCell(0);
				cell.setCellValue("编号");

				cell.setCellStyle(cellStyle);
				cell = firstRow.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("单位");
				cell = firstRow.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("姓名");
				cell = firstRow.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("飞行成绩");
				cell = firstRow.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("总成绩");
				cell = firstRow.createCell(6);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("名次");
				cell = firstRow.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("奖项");
				cell = firstRow.createCell(8);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("备注");
				cell = secondRow.createCell(3);
				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN);
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("第一轮");
				cell = secondRow.createCell(4);
				cell.setCellValue("第二轮");
				cell.setCellStyle(cellStyle);
				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);

				/*
				 * 开始写入成绩
				 */
				List<Mangoptionsmatch> mangoptionsmatchs = mangoptionsmatchService
						.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchList.getId(), matchGroup.getId());
				/*
				 * 此处需要排序 升序
				 */
				Collections.sort(mangoptionsmatchs);
				 i++;

				for (Mangoptionsmatch mangoptionsmatch : mangoptionsmatchs) {

					XSSFRow scoreRow = sheet.createRow(i);
					XSSFCell scoreCell = null;

					scoreCell = scoreRow.createCell(0);
					scoreCell.setCellValue(mangoptionsmatch.getNum());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(1);
					scoreCell.setCellValue(mangoptionsmatch.getTeamname());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(2);
					scoreCell.setCellValue(mangoptionsmatch.getName());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(3);
					scoreCell.setCellValue(mangoptionsmatch.getScorefinalone());

					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(4);
					scoreCell.setCellValue(mangoptionsmatch.getScorefinaltwo());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(5);
					scoreCell.setCellValue(mangoptionsmatch.getScorefinal());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(6);
					scoreCell.setCellValue(mangoptionsmatch.getRank());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(7);
					scoreCell.setCellValue(mangoptionsmatch.getReward());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(8);
					scoreCell.setCellStyle(cellStyle);
					scoreCell.setCellValue("");
					i++;
				}
//				bookpath = matchList.getName() + gageName + ".xlsx";
//				// File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" +
//				// matchList.getName()+gageName + ".xlsx");
//				File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
//				try {
//					file.createNewFile();
//					FileOutputStream stream = FileUtils.openOutputStream(file);
//					workbook.write(stream);
//					stream.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
i++;
			} else if (matchList.getId() == 23 || matchList.getId() == 26 || matchList.getId() == 27 || matchList.getId() == 29 || matchList.getId() == 31
					|| matchList.getId() == 17 || matchList.getId() == 18) {
				XSSFRow headRow = sheet.createRow(i);
				XSSFCell headCell = headRow.createCell(0);
				XSSFCellStyle headstyle1 = workbook.createCellStyle();
				XSSFCellStyle headstyle2 = workbook.createCellStyle();
				headCell.setCellValue(gageName + matchList.getName());
				headstyle1.setAlignment(HorizontalAlignment.LEFT);
				headstyle1.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle1);
				headCell = headRow.createCell(4);
				headCell.setCellValue("比赛时间：" + "2018-10-22");
				headstyle2.setAlignment(HorizontalAlignment.RIGHT);
				headstyle2.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle2);
				CellRangeAddress cra0 = new CellRangeAddress(i, i, 0, 4);
				sheet.addMergedRegion(cra0);
				CellRangeAddress crax = new CellRangeAddress(i, i, 5, 10);
				sheet.addMergedRegion(crax);

				/*
				 * 批次项目
				 */
				i++;
				XSSFRow firstRow = sheet.createRow(i);
				i++;
				XSSFRow secondRow = sheet.createRow(i);
				secondRow.setHeight((short) 500);
				sheet.setColumnWidth(0, 1000);
				sheet.setColumnWidth(1, 5500);
				sheet.setColumnWidth(2, 1500);
				sheet.setColumnWidth(3, 1500);
				sheet.setColumnWidth(4, 1500);
				sheet.setColumnWidth(5, 1500);
				sheet.setColumnWidth(6, 1500);
				sheet.setColumnWidth(7, 1500);
				sheet.setColumnWidth(8, 1000);
				sheet.setColumnWidth(9, 1500);
				sheet.setColumnWidth(10, 1000);
				XSSFCell cell = null;

				CellRangeAddress cra1 = new CellRangeAddress(i-1, i, 0, 0);
				sheet.addMergedRegion(cra1);// 合并
				CellRangeAddress cra2 = new CellRangeAddress(i-1, i, 1, 1);
				sheet.addMergedRegion(cra2);// 合并
				CellRangeAddress cra3 = new CellRangeAddress(i-1, i, 2, 2);
				sheet.addMergedRegion(cra3);// 合并
				CellRangeAddress cra4 = new CellRangeAddress(i-1, i, 3, 4);
				sheet.addMergedRegion(cra4);
				CellRangeAddress cra5 = new CellRangeAddress(i-1, i, 5, 6);
				sheet.addMergedRegion(cra5);
				CellRangeAddress cra6 = new CellRangeAddress(i-1, i, 7, 7);
				sheet.addMergedRegion(cra6);
				CellRangeAddress cra7 = new CellRangeAddress(i-1, i, 8, 8);
				sheet.addMergedRegion(cra7);
				CellRangeAddress cra8 = new CellRangeAddress(i-1, i, 9, 9);
				sheet.addMergedRegion(cra8);
				CellRangeAddress cra9 = new CellRangeAddress(i-1, i, 10, 10);
				sheet.addMergedRegion(cra9);
				cell = firstRow.createCell(0);
				cell.setCellValue("编号");

				cell.setCellStyle(cellStyle);
				cell = firstRow.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("单位");
				cell = firstRow.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("姓名");
				cell = firstRow.createCell(3);
				cell.setCellStyle(cellStyle);

				cell.setCellValue("第一轮成绩");

				cell = firstRow.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("第二轮成绩");

				cell = firstRow.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("比赛成绩");
				cell = firstRow.createCell(8);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("名次");
				cell = firstRow.createCell(9);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("奖项");
				cell = firstRow.createCell(10);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("备注");
				cell = secondRow.createCell(3);
				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN);
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
				cellStyle.setWrapText(true);
				cell.setCellStyle(cellStyle);
				if (matchList.getId() == 18 || matchList.getId() == 17) {
					cell.setCellValue("批" + "一" + "/" + "二" + "/" + "三");
				} else {
					cell.setCellValue("批" + "定" + "/" + "动" + "/" + "留");
				}

				cell = secondRow.createCell(4);
				cell.setCellValue("第一轮");
				cell.setCellStyle(cellStyle);
				cell = secondRow.createCell(5);
				if (matchList.getId() == 18 || matchList.getId() == 17) {
					cell.setCellValue("批" + "最后飞");
				} else {
					cell.setCellValue("批" + "定" + "/" + "动" + "/" + "留");
				}

				cell.setCellStyle(cellStyle);
				cell = secondRow.createCell(6);
				cell.setCellValue("第二轮");
				cell.setCellStyle(cellStyle);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra9, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra9, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra9, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra9, sheet);
				/*
				 * 开始写入成绩
				 */
				List<Turnmatchlist> turnmatchlists = turnMatchListService.findWhoJoinThisMatchThisListAndHasConfirm(matchid,
						matchList.getId(), matchGroup.getId());
				/*
				 * 此处需要排序 升序
				 */
				Collections.sort(turnmatchlists);
				 i++;

				for (Turnmatchlist turnmatchlist : turnmatchlists) {

					XSSFRow scoreRow = sheet.createRow(i);
					XSSFCell scoreCell = null;

					scoreCell = scoreRow.createCell(0);
					scoreCell.setCellValue(turnmatchlist.getNum());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(1);
					scoreCell.setCellValue(turnmatchlist.getTeamname());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(2);
					scoreCell.setCellValue(turnmatchlist.getName());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(3);
					scoreCell.setCellValue(turnmatchlist.getTurn1() + "/" + turnmatchlist.getOneturnpointmeter() + "/"
							+ turnmatchlist.getOneturnpowertime() + "/" + turnmatchlist.getOneturnskytime());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(4);
					scoreCell.setCellValue(turnmatchlist.getScoreinoneturnhascalc());
					scoreCell.setCellStyle(cellStyle);

					scoreCell = scoreRow.createCell(5);
					scoreCell.setCellValue(turnmatchlist.getTurn2() + "/" + turnmatchlist.getTwoturnpointmeter() + "/"
							+ turnmatchlist.getTwoturnpowertime() + "/" + turnmatchlist.getTwoturnskytime());
					scoreCell.setCellStyle(cellStyle);

					scoreCell = scoreRow.createCell(6);
					scoreCell.setCellValue(turnmatchlist.getScoreintwoturnhascalc());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(7);
					scoreCell.setCellValue(turnmatchlist.getFinalscore());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(8);
					scoreCell.setCellValue(turnmatchlist.getRankfinal());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(9);
					scoreCell.setCellValue(turnmatchlist.getReward());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(10);
					scoreCell.setCellValue("  ");
					scoreCell.setCellStyle(cellStyle);
					i++;
				}
//				bookpath = matchList.getName() + gageName + ".xlsx";
//				File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
//				try {
//					file.createNewFile();
//					FileOutputStream stream = FileUtils.openOutputStream(file);
//					workbook.write(stream);
//					stream.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
i++;
			} else if (matchList.getId() == 8) {XSSFRow headRow = sheet.createRow(i);
			XSSFCell headCell = headRow.createCell(0);
			XSSFCellStyle headstyle1 = workbook.createCellStyle();
			XSSFCellStyle headstyle2 = workbook.createCellStyle();
				headCell.setCellValue(gageName + matchList.getName());
				headstyle1.setAlignment(HorizontalAlignment.LEFT);
				headstyle1.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle1);
				headCell = headRow.createCell(4);
				headCell.setCellValue("比赛时间：" + "2018-10-22");
				headstyle2.setAlignment(HorizontalAlignment.RIGHT);
				headstyle2.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle2);
				CellRangeAddress cra0 = new CellRangeAddress(i, i, 0, 3);
				sheet.addMergedRegion(cra0);
				CellRangeAddress crax = new CellRangeAddress(i, i, 4, 8);
				sheet.addMergedRegion(crax);
				i++;
				XSSFRow firstRow = sheet.createRow(i);
				i++;
				XSSFRow secondRow = sheet.createRow(i);
				sheet.setColumnWidth(0, 1300);
				sheet.setColumnWidth(1, 5500);
				sheet.setColumnWidth(2, 1500);
				sheet.setColumnWidth(3, 2200);
				sheet.setColumnWidth(4, 2200);
				sheet.setColumnWidth(5, 2200);
				sheet.setColumnWidth(6, 1500);
				sheet.setColumnWidth(7, 1500);
				sheet.setColumnWidth(8, 1500);
				XSSFCell cell = null;

				CellRangeAddress cra1 = new CellRangeAddress(i-1, i, 0, 0);
				sheet.addMergedRegion(cra1);// 合并
				CellRangeAddress cra2 = new CellRangeAddress(i-1, i, 1, 1);
				sheet.addMergedRegion(cra2);// 合并
				CellRangeAddress cra3 = new CellRangeAddress(i-1, i, 2, 2);
				sheet.addMergedRegion(cra3);// 合并
				CellRangeAddress cra4 = new CellRangeAddress(i-1, i, 3, 4);
				sheet.addMergedRegion(cra4);
				CellRangeAddress cra5 = new CellRangeAddress(i-1, i, 5, 5);
				sheet.addMergedRegion(cra5);
				CellRangeAddress cra6 = new CellRangeAddress(i-1, i, 6, 6);
				sheet.addMergedRegion(cra6);
				CellRangeAddress cra7 = new CellRangeAddress(i-1, i, 7, 7);
				sheet.addMergedRegion(cra7);
				CellRangeAddress cra8 = new CellRangeAddress(i-1, i, 8, 8);
				sheet.addMergedRegion(cra8);

				cell = firstRow.createCell(0);
				cell.setCellValue("编号");

				cell.setCellStyle(cellStyle);
				cell = firstRow.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("单位");
				cell = firstRow.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("姓名");
				cell = firstRow.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("飞行成绩");
				cell = firstRow.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("总成绩");
				cell = firstRow.createCell(6);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("名次");
				cell = firstRow.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("奖项");
				cell = firstRow.createCell(8);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("备注");
				cell = secondRow.createCell(3);
				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN);
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("第一轮");
				cell = secondRow.createCell(4);
				cell.setCellValue("第二轮");
				cell.setCellStyle(cellStyle);
				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);
				List<Withfriendmatch> withfriendmatchs = withfriendmatchService
						.findWhoJoinThisMatchThisListAndHasConfirm(matchid, matchList.getId(), matchGroup.getId());
				Collections.sort(withfriendmatchs);
				 i++;
				for (Withfriendmatch withfriendmatch : withfriendmatchs) {
					XSSFRow scoreRow = sheet.createRow(i);
					XSSFCell scoreCell = null;

					scoreCell = scoreRow.createCell(0);
					scoreCell.setCellValue(withfriendmatch.getNum());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(1);
					scoreCell.setCellValue(withfriendmatch.getTeamname());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(2);
					scoreCell.setCellValue(withfriendmatch.getName());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(3);
					scoreCell.setCellValue(withfriendmatch.getScoreone());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(4);
					scoreCell.setCellValue(withfriendmatch.getScoretwo());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(5);
					scoreCell.setCellValue(withfriendmatch.getFinalscore());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(6);
					scoreCell.setCellValue(withfriendmatch.getRank());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(7);
					scoreCell.setCellValue(withfriendmatch.getReward());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(8);
					scoreCell.setCellStyle(cellStyle);
					scoreCell.setCellValue("");
					i++;
				}
//				bookpath = matchList.getName() + gageName + ".xlsx";
//				File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" + matchList.getName() + gageName + ".xlsx");
//				try {
//					file.createNewFile();
//					FileOutputStream stream = FileUtils.openOutputStream(file);
//					workbook.write(stream);
//					stream.close();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
				i++;
			} else if (matchList.getId() == 9 || matchList.getId() == 25) {
				XSSFRow headRow = sheet.createRow(i);
				XSSFCell headCell = headRow.createCell(0);
				XSSFCellStyle headstyle1 = workbook.createCellStyle();
				XSSFCellStyle headstyle2 = workbook.createCellStyle();
				headCell.setCellValue(gageName + matchList.getName());
				headstyle1.setAlignment(HorizontalAlignment.LEFT);
				headstyle1.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle1);
				headCell = headRow.createCell(4);
				headCell.setCellValue("比赛时间：" + "2018-10-22");
				headstyle2.setAlignment(HorizontalAlignment.RIGHT);
				headstyle2.setBorderBottom(BorderStyle.DOUBLE);
				headCell.setCellStyle(headstyle2);
				CellRangeAddress cra0 = new CellRangeAddress(i, i, 0, 3);
				sheet.addMergedRegion(cra0);
				CellRangeAddress crax = new CellRangeAddress(i, i, 4, 8);
				sheet.addMergedRegion(crax);
				i++;
				XSSFRow firstRow = sheet.createRow(i);
				i++;
				XSSFRow secondRow = sheet.createRow(i);
				sheet.setColumnWidth(0, 1300);
				sheet.setColumnWidth(1, 5500);
				sheet.setColumnWidth(2, 1500);
				sheet.setColumnWidth(3, 2200);
				sheet.setColumnWidth(4, 2200);
				sheet.setColumnWidth(5, 2200);
				sheet.setColumnWidth(6, 1500);
				sheet.setColumnWidth(7, 1500);
				sheet.setColumnWidth(8, 1500);
				XSSFCell cell = null;

				CellRangeAddress cra1 = new CellRangeAddress(i-1, i, 0, 0);
				sheet.addMergedRegion(cra1);// 合并
				CellRangeAddress cra2 = new CellRangeAddress(i-1, i, 1, 1);
				sheet.addMergedRegion(cra2);// 合并
				CellRangeAddress cra3 = new CellRangeAddress(i-1, i, 2, 2);
				sheet.addMergedRegion(cra3);// 合并
				CellRangeAddress cra4 = new CellRangeAddress(i-1, i, 3, 4);
				sheet.addMergedRegion(cra4);
				CellRangeAddress cra5 = new CellRangeAddress(i-1, i, 5, 5);
				sheet.addMergedRegion(cra5);
				CellRangeAddress cra6 = new CellRangeAddress(i-1, i, 6, 6);
				sheet.addMergedRegion(cra6);
				CellRangeAddress cra7 = new CellRangeAddress(i-1, i, 7, 7);
				sheet.addMergedRegion(cra7);
				CellRangeAddress cra8 = new CellRangeAddress(i-1, i, 8, 8);
				sheet.addMergedRegion(cra8);

				cell = firstRow.createCell(0);
				cell.setCellValue("编号");

				cell.setCellStyle(cellStyle);
				cell = firstRow.createCell(1);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("单位");
				cell = firstRow.createCell(2);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("姓名");
				cell = firstRow.createCell(3);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("飞行成绩");
				cell = firstRow.createCell(5);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("总成绩");
				cell = firstRow.createCell(6);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("名次");
				cell = firstRow.createCell(7);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("奖项");
				cell = firstRow.createCell(8);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("备注");
				cell = secondRow.createCell(3);
				cellStyle.setBorderBottom(BorderStyle.THIN);
				cellStyle.setBorderLeft(BorderStyle.THIN);
				cellStyle.setBorderRight(BorderStyle.THIN);
				cellStyle.setBorderTop(BorderStyle.THIN);
				cell.setCellStyle(cellStyle);
				cell.setCellValue("第一轮");
				cell = secondRow.createCell(4);
				cell.setCellValue("第二轮");
				cell.setCellStyle(cellStyle);
				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra1, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra1, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra1, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra2, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra2, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra2, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra3, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra3, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra3, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra4, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra4, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra4, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra5, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra5, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra5, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra6, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra6, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra6, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra7, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra7, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra7, sheet);

				RegionUtil.setBorderTop(BorderStyle.DOUBLE, cra8, sheet);
				RegionUtil.setBorderRight(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderLeft(BorderStyle.THIN, cra8, sheet);
				RegionUtil.setBorderBottom(BorderStyle.THIN, cra8, sheet);
				List<Manyrifmatch> manyrifmatchs = manyrifmatchService.findWhoJoinThisMatchThisListAndHasConfirm(matchid,
						matchList.getId(), matchGroup.getId());
				Collections.sort(manyrifmatchs);
			 i++;
				for (Manyrifmatch manyrifmatch : manyrifmatchs) {
					XSSFRow scoreRow = sheet.createRow(i);
					XSSFCell scoreCell = null;

					scoreCell = scoreRow.createCell(0);
					scoreCell.setCellValue(manyrifmatch.getNum());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(1);
					scoreCell.setCellValue(manyrifmatch.getTeamname());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(2);
					scoreCell.setCellValue(manyrifmatch.getName());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(3);
					scoreCell.setCellValue(manyrifmatch.getScoreonebytranslate());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(4);
					scoreCell.setCellValue(manyrifmatch.getScoretwobytranslate());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(5);
					scoreCell.setCellValue(manyrifmatch.getScorefinal());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(6);
					scoreCell.setCellValue(manyrifmatch.getRank());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(7);
					scoreCell.setCellValue(manyrifmatch.getReward());
					scoreCell.setCellStyle(cellStyle);
					scoreCell = scoreRow.createCell(8);
					scoreCell.setCellStyle(cellStyle);
					scoreCell.setCellValue("");
					i++;
				}
				i++;
		}
			
		}

		}
		bookpath = match.getName() + "成绩册.xlsx";
		File file = new File("d:/Tomcat 8.5/webapps/ROOT/allQR/" +match.getName() +   "成绩册.xlsx");
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("pphh", bookpath);

		return "downloadXlsx";
		

		
		
		
	}
	public String turnInt(int m){
		switch (m) {
		case 1:
			return "第一名";
		case 2:
			return "第二名";
		case 3:
			return "第三名";
		case 4:
			return "第四名";
		case 5:
			return "第五名";
		case 6:
			return "第六名";
		case 7:
			return "第七名";
		case 8:
			return "第八名";
			

		default:
			return "无";
		}
		
	}
}
