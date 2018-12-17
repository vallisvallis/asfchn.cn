package com.mengmaclub.util;

import java.util.HashMap;
import java.util.Map;



public class DecideSn {
	Map<String, String> cityWord = new HashMap<String, String>();
	Map<String, String> citySn = new HashMap<String, String>();
	Map<String, String> orgType = new HashMap<String, String>();

	public void cityData() {
		// 城市车牌号
		cityWord.put("郑州市", "A");
		cityWord.put("开封市", "B");
		cityWord.put("洛阳市", "C");
		cityWord.put("平顶山市", "D");
		cityWord.put("安阳市", "E");
		cityWord.put("鹤壁市", "F");
		cityWord.put("新乡市", "G");
		cityWord.put("焦作市", "H");
		cityWord.put("濮阳市", "J");
		cityWord.put("许昌市", "K");
		cityWord.put("漯河市", "L");
		cityWord.put("三门峡市", "M");
		cityWord.put("商丘市", "N");
		cityWord.put("周口市", "P");
		cityWord.put("驻马店市", "Q");
		cityWord.put("南阳市", "R");
		cityWord.put("信阳市", "S");
		cityWord.put("济源市", "U");
		// 城市缩写
		citySn.put("郑州市", "ZZS");
		citySn.put("开封市", "KFS");
		citySn.put("洛阳市", "LYS");
		citySn.put("平顶山市", "PDSS");
		citySn.put("安阳市", "AYS");
		citySn.put("鹤壁市", "HBS");
		citySn.put("新乡市", "XXS");
		citySn.put("焦作市", "JZS");
		citySn.put("濮阳市", "PYS");
		citySn.put("许昌市", "XCS");
		citySn.put("漯河市", "LHS");
		citySn.put("三门峡市", "SMXS");
		citySn.put("商丘市", "SQS");
		citySn.put("周口市", "ZKS");
		citySn.put("驻马店市", "ZMDS");
		citySn.put("南阳市", "NYS");
		citySn.put("信阳市", "XYS");
		citySn.put("济源市", "JYS");
	}

	// 生成 城市车牌+城市首字母缩写
	public String decideCitySN(String city) {
		cityData();
		boolean cityIsExist = citySn.containsKey(city)
				&& cityWord.containsKey(city);
		if ((city != null) && cityIsExist) {
			return cityWord.get(city) + citySn.get(city);
		}
		return "未知";

	}

	public String decidePeopleSn(String city) {
		cityData();
		boolean cityIsExist = citySn.containsKey(city);
		if (cityIsExist && (city != null)) {
			return citySn.get(city);
		}
		return "未知";
	}

}