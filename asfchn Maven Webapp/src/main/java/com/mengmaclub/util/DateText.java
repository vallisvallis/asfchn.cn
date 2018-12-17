package com.mengmaclub.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.internal.runners.TestMethod;
import org.springframework.ui.Model;

import com.mengmaclub.model.HxTeam;

public class DateText {

//	//查询该会员单位
//	Date date=new Date();
//	System.out.println(date);
//	
//	String city="郑州市";
//	DecideSn o=new DecideSn();
//	System.out.println(o.decidePeopleSn(city));
//	String a="2";
//	if (a!="2") {
//		System.out.println( "budengyu");
//	}else{
//		System.out.println("=");
//	}

//	testMySchedule("2018-06-05", null);

//public static String testMySchedule(String wlldateInweb,Model model){
//	Date wlldate=null;
//	DateFormat format1=new SimpleDateFormat("yyyy-MM-dd");
//	try {
//		wlldate=format1.parse(wlldateInweb);
//	System.out.println(wlldate);
//	} catch (Exception e) {
//		// TODO: handle exception
//	}
//	return "";

	 /**
     * 日期转星期
     * 
     * @param datetime
     * @return
     */
    public static String dateToWeek(String datetime) {
        SimpleDateFormat f = new SimpleDateFormat("yyyy-MM-dd");
        String[] weekDays = { "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六" };
        Calendar cal = Calendar.getInstance(); // 获得一个日历
        Date datet = null;
        try {
            datet = f.parse(datetime);
            cal.setTime(datet);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        int w = cal.get(Calendar.DAY_OF_WEEK) - 1; // 指示一个星期中的某天。
        if (w < 0)
            w = 0;
        return weekDays[w];
    
    }
    
   
    
    public static void main(String[] args) {
    	
    	SimpleDateFormat f=new SimpleDateFormat("yyyy-MM-dd");
    	Date date=null;
    	Calendar ca= Calendar.getInstance();
    	try {
			date=f.parse("2018-06-11");
			ca.setTime(date);
		} catch (Exception e) {
			// TODO: handle exception
		}
   
   
    	
   //     System.out.println(DateText.dateToWeek("2018-06-07"));
        String str=String.format("%tj", date);
        int i=Integer.parseInt(str)/4;
        System.out.println(156%5);
        if ((Integer.parseInt(str)%4)==1) {
			System.out.println("白");
		}else if((Integer.parseInt(str)%4)==2){
			System.out.println("白");
			
		}else if((Integer.parseInt(str)%4)==3){
			System.out.println("夜");
			
		}else{
			System.err.println("休");
			
		}
			
		
        System.out.println(str);
    
    }

	




}
