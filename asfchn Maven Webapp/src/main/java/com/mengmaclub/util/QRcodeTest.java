package com.mengmaclub.util;

public class QRcodeTest {

	
	
	
	
	public static void main(String[] args) throws Exception {
		
		QRCodeUtil qrcout=new QRCodeUtil();
	qrcout.encode("ww","f:/new/", null, false);

	String text="1";
	
	
	QRCodeUtil.encode(text, "d:/"+1+"/"+1+".jpg", "d:/"+1, text, true);
		
		
		
	}
}
