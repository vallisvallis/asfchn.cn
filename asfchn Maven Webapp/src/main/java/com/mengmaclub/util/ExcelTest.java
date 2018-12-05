package com.mengmaclub.util;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import org.apache.poi.xssf.usermodel.XSSFPicture;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelTest {
public static void main(String[] args) {
	
	int f1=1,f2=1,f;
	int M=30;
	System.out.println(1);
	System.out.println(2);
	for(int i=3;i<M;i++) {
		f=f2;
		f2=f1+f2;
		f1=f;
		System.out.println(f2);

}
}
}