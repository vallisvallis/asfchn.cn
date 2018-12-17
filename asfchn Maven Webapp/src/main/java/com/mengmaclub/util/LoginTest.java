package com.mengmaclub.util;

public class LoginTest {

	
	public static void main(String[] args) {
		String la="ZZS17743";
		String lb="asfchn.cn";

String c=login(la,lb);
System.out.println(c);
}
	
	public static String login(String la,String lb){
		String a="ZZS17743";
		String b="asfchn.cn";

		if (a.equals(la)&&b.equals(lb)) {
			return "success";
		}
		return "fail";
		
	}
}
