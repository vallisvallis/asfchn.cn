package com.mengmaclub.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.usermodel.Workbook;

import org.apache.poi.ss.usermodel.BorderStyle;

import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
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

import com.mengmaclub.model.JoinMatchTeamPeople;
import com.mengmaclub.model.Mangoptionsmatch;
import com.mengmaclub.model.Match;
import com.mengmaclub.model.Turnmatchlist;
import com.mengmaclub.model.Twoptionsmatch;

public class PrintTest {
	public static void main(String[] args) {
		score();
	}
public void wa(){
	XSSFWorkbook workBook = new XSSFWorkbook();
	String sex = "初中男子组";
	XSSFSheet sheet = workBook.createSheet("证书");
	XSSFRow oneRow = sheet.createRow(1);
	XSSFCell onecell = null;
	XSSFPrintSetup printSetup=sheet.getPrintSetup();
	printSetup.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE); // 纸张
	//sheet.setDisplayGridlines(false);
	sheet.setPrintGridlines(false);
	sheet.setMargin(XSSFSheet.TopMargin,( double )1 ); // 上边距
	sheet.setMargin(XSSFSheet.BottomMargin,( double ) 1 ); // 下边距
	sheet.setMargin(XSSFSheet.LeftMargin,( double )	1 ); // 左边距
	sheet.setMargin(XSSFSheet.RightMargin,( double ) 1 ); // 右边距
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
	XSSFRow firstRow = sheet.createRow(6);
	XSSFCell cell = null;
	cell = firstRow.createCell(2);
	firstRow.setHeightInPoints(52.5F);
	cell.setCellValue("比赛名字");

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

	cell1.setCellValue("运动员");
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
	cell2.setCellValue("参赛项目");
	cell2.setCellStyle(centerStyle3);

	XSSFRow firstRow3 = sheet.createRow(9);
	firstRow3.setHeightInPoints(18.75F);
	XSSFCell cell3 = null;
	XSSFCellStyle centerStyle4 = workBook.createCellStyle();

	centerStyle4.setFont(no2Font);
	centerStyle4.setAlignment(HorizontalAlignment.CENTER);
	centerStyle4.setVerticalAlignment(VerticalAlignment.CENTER);

	cell3 = firstRow3.createCell(3);

	cell3.setCellValue(sex);
	cell3.setCellStyle(centerStyle4);
	cell3 = firstRow3.createCell(6);

	cell3.setCellValue("第" + 1 + "名");
	cell3.setCellStyle(centerStyle4);
	cell3 = firstRow3.createCell(8);
	cell3.setCellStyle(centerStyle4);
	cell3.setCellValue("最终排名");
	cell3.setCellStyle(centerStyle4);

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
	String bookpath = "测试证书.xlsx";
	// File file = new File("d:/testEXCEL/" + "229测试证书.xlsx");
	// try
	// {
	// file.createNewFile();
	// FileOutputStream stream = FileUtils.openOutputStream(file);
	// workBook.write(stream);
	// stream.close();
	// }
	// catch (Exception e)
	// {
	// e.printStackTrace();
	// }
	// System.out.println("end");
	File file = new File("d:/testEXCEL/123/" + "证书21示ss例" + sex + ".xlsx");
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
		print.createPicture(anthor, workBook.addPicture(byteArryOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));
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
	public void nis() {

		XSSFWorkbook wb = new XSSFWorkbook();
		XSSFSheet sheet = wb.createSheet("sheetTest");
		ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
		BufferedImage bufferImg = null;
		try {
			bufferImg = ImageIO.read(new File("D:/" + "pictures/" + "hos.png"));
			ImageIO.write(bufferImg, "png", byteArrayOut);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		XSSFDrawing patriarch = sheet.createDrawingPatriarch();
		XSSFClientAnchor anchor = new XSSFClientAnchor(0, 15, 15, 0, 5, 5, 15, 13);
		patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), wb.PICTURE_TYPE_PNG));
		File file = new File("d:/ni.xlsx");
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			wb.write(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");

	}

	public static void score() {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("此处是sheet名称");
		XSSFPrintSetup printSetup=sheet.getPrintSetup();
		printSetup.setPaperSize(XSSFPrintSetup.A4_PAPERSIZE); // 纸张
		//sheet.setDisplayGridlines(false);
		sheet.setPrintGridlines(false);
		sheet.setMargin(XSSFSheet.TopMargin,( double )1 ); // 上边距
		sheet.setMargin(XSSFSheet.BottomMargin,( double ) 1 ); // 下边距
		sheet.setMargin(XSSFSheet.LeftMargin,( double )	1 ); // 左边距
		sheet.setMargin(XSSFSheet.RightMargin,( double ) 1 ); // 右边距
		XSSFRow headRow = sheet.createRow(0);
		headRow.setHeight((short) 499);
		XSSFRow firstRow = sheet.createRow(1);
		XSSFRow secondRow = sheet.createRow(2);
		XSSFCell cell = null;
		XSSFCellStyle cellStyle = workbook.createCellStyle(); // 单元格样式
		Font fontStyle = workbook.createFont(); // 字体样式
		fontStyle.setBold(true); // 加粗
		fontStyle.setFontName("宋体"); // 字体
		fontStyle.setFontHeightInPoints((short) 9); // 大小
		// 将字体样式添加到单元格样式中
		cellStyle.setFont(fontStyle);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		sheet.setColumnWidth(0, 1300);
		sheet.setColumnWidth(1, 5500);
		sheet.setColumnWidth(2, 1500);
		sheet.setColumnWidth(3, 2200);
		sheet.setColumnWidth(4, 2200);
		sheet.setColumnWidth(5, 2200);
		sheet.setColumnWidth(6, 1500);
		sheet.setColumnWidth(7, 1500);
		sheet.setColumnWidth(8, 1500);
		XSSFCell headCell = null;

		XSSFCellStyle headstyle1 = workbook.createCellStyle();
		XSSFCellStyle headstyle2 = workbook.createCellStyle();

		headCell = headRow.createCell(0);
		headCell.setCellValue("比赛");
		headstyle1.setAlignment(HorizontalAlignment.LEFT);

		headCell.setCellStyle(headstyle1);

		headCell = headRow.createCell(4);
		headCell.setCellValue("比赛时间：");
		headstyle2.setAlignment(HorizontalAlignment.RIGHT);
		headCell.setCellStyle(headstyle2);

		CellRangeAddress cra0 = new CellRangeAddress(0, 0, 0, 4);
		sheet.addMergedRegion(cra0);
		CellRangeAddress crax = new CellRangeAddress(0, 0, 5, 10);
		sheet.addMergedRegion(crax);
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
		File file = new File("d:/testprint.xlsx");
		try {
			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workbook.write(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("end");
	}

	public void getBOOK() {

		// JoinMatchTeamPeople joinMatchTeamPeople =
		// this.joinMatchTeamPeopleService.selectByPrimaryKey(twoptionsmatch.getJoinpeopleid());

		System.out.println("zhixing");
		XSSFWorkbook workBook = new XSSFWorkbook();
		// Match match =
		// this.matchService.selectByPrimaryKey(Integer.valueOf(matchid));
		// List<JoinMatchTeam> joinMatchTeams = this.joinMatchTeamService
		// .findAllWhichIsYesin18();

		XSSFSheet sheet = workBook.createSheet("名字");

		XSSFRow oneRow = sheet.createRow(1);
		XSSFCell onecell = null;

		XSSFCellStyle oneStyle = workBook.createCellStyle();

		sheet.setColumnWidth(0, 2144);
		sheet.setColumnWidth(1, 4352);
		sheet.setColumnWidth(2, 1792);
		sheet.setColumnWidth(3, 6400);
		sheet.setColumnWidth(4, 3840);
		sheet.setColumnWidth(5, 7424);

		XSSFRow headrow = sheet.createRow(0);
		// headrow.setHeightInPoints(93.75F);
		XSSFRow firstRow = sheet.createRow(6);
		XSSFCell cell = null;
		cell = firstRow.createCell(2);
		firstRow.setHeightInPoints(52.5F);
		cell.setCellValue("比赛名字");

		XSSFCellStyle centerStyle = workBook.createCellStyle();
		Font no1Font = workBook.createFont();
		no1Font.setFontHeightInPoints((short) 14);
		no1Font.setFontName("宋体");
		no1Font.setBold(true);
		centerStyle.setFont(no1Font);
		centerStyle.setAlignment(HorizontalAlignment.CENTER);
		centerStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		// centerStyle.setVerticalAlignment(HorizontalAlignment.CENTER);
		CellRangeAddress region = new CellRangeAddress(6, 6, 2, 5);
		sheet.addMergedRegion(region);

		XSSFCellStyle centerStyle2 = workBook.createCellStyle();

		Font no2Font = workBook.createFont();
		no2Font.setFontHeightInPoints((short) 16);
		no2Font.setFontName("宋体");
		no2Font.setBold(true);
		centerStyle2.setFont(no2Font);
		centerStyle2.setAlignment(HorizontalAlignment.CENTER);
		centerStyle2.setVerticalAlignment(VerticalAlignment.CENTER);
		CellRangeAddress region2 = new CellRangeAddress(7, 7, 2, 5);
		sheet.addMergedRegion(region2);

		cell.setCellStyle(centerStyle);

		XSSFRow firstRow1 = sheet.createRow(7);
		firstRow1.setHeightInPoints(39.75F);
		XSSFCell cell1 = null;
		cell1 = firstRow1.createCell(2);
		cell1.setCellValue("名字");
		cell1.setCellStyle(centerStyle2);

		XSSFCellStyle centerStyle3 = workBook.createCellStyle();

		XSSFCellStyle centerStyle5 = workBook.createCellStyle();

		centerStyle3.setFont(no1Font);

		centerStyle3.setAlignment((HorizontalAlignment.CENTER));
		centerStyle3.setVerticalAlignment(VerticalAlignment.CENTER);
		CellRangeAddress region3 = new CellRangeAddress(8, 8, 2, 5);
		sheet.addMergedRegion(region3);

		XSSFRow firstRow2 = sheet.createRow(8);
		firstRow2.setHeightInPoints(22.5F);
		XSSFCell cell2 = null;
		cell2 = firstRow2.createCell(2);
		cell2.setCellValue("项目名称");
		cell2.setCellStyle(centerStyle3);

		XSSFRow firstRow3 = sheet.createRow(9);
		firstRow3.setHeightInPoints(18.75F);
		XSSFCell cell3 = null;
		XSSFCellStyle centerStyle4 = workBook.createCellStyle();

		centerStyle4.setFont(no2Font);
		centerStyle4.setAlignment(HorizontalAlignment.CENTER);
		centerStyle4.setVerticalAlignment(VerticalAlignment.CENTER);

		cell3 = firstRow3.createCell(3);
		String sex = "组别";
		// if (joinMatchTeamPeople.getGage().intValue() == 1) {
		// sex = "����������";
		// } else if (joinMatchTeamPeople.getGage().intValue() == 2) {
		// sex = "����������";
		// } else if (joinMatchTeamPeople.getGage().intValue() == 3) {
		// sex = "����������";
		// } else if (joinMatchTeamPeople.getGage().intValue() == 4) {
		// sex = "����������";
		// } else if (joinMatchTeamPeople.getGage().intValue() == 5) {
		// sex = "����������";
		// } else if (joinMatchTeamPeople.getGage().intValue() == 6) {
		// sex = "����������";
		// }
		cell3.setCellValue(sex);
		cell3.setCellStyle(centerStyle4);
		cell3 = firstRow3.createCell(4);

		cell3.setCellValue("名次");
		cell3.setCellStyle(centerStyle4);
		cell3 = firstRow3.createCell(5);
		cell3.setCellStyle(centerStyle4);
		cell3.setCellValue("最终得分");
		cell3.setCellStyle(centerStyle4);
		XSSFRow firstRow4 = sheet.createRow(10);
		firstRow4.setHeightInPoints(57.75F);
		XSSFCell cell4 = null;

		centerStyle5.setFont(no2Font);
		centerStyle5.setAlignment(HorizontalAlignment.CENTER);
		// centerStyle5.setVerticalAlignment((short)1);

		cell4 = firstRow4.createCell(3);
		cell4.setCellValue("时间");
		cell4.setCellStyle(centerStyle5);
		cell4 = firstRow4.createCell(5);
		cell4.setCellValue("郑州 ");
		cell4.setCellStyle(centerStyle5);

		File file = new File("d:/" + "证书示例" + sex + ".xlsx");

		BufferedImage bfi = null;
		try {
			ByteArrayOutputStream byteArryOut = new ByteArrayOutputStream();
			bfi = ImageIO.read(new File("D:/pictures/hos.png"));
			ImageIO.write(bfi, "png", byteArryOut);
			XSSFDrawing print = sheet.createDrawingPatriarch();
			XSSFClientAnchor anthor = new XSSFClientAnchor(0, 0, 255, 255, 5, 6, 5, 6);
			print.createPicture(anthor, workBook.addPicture(byteArryOut.toByteArray(), XSSFWorkbook.PICTURE_TYPE_JPEG));

			file.createNewFile();
			FileOutputStream stream = FileUtils.openOutputStream(file);
			workBook.write(stream);
			stream.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		// pphh = joinMatchTeamPeople.getJoinmatchlistinname() + sex +
		// "����.xlsx";
		// model.addAttribute("pphh", pphh);

		System.out.println("end");
	}

}
