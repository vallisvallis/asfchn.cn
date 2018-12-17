package com.mengmaclub.test;

import com.mengmaclub.util.DecideSn;

public class Test {

public static void main(String[] args) {
	String city="郑州市";
	 DecideSn decideSn = new DecideSn();
	
	String c=decideSn.decideCitySN(city);
	System.out.println(c);
}
}
