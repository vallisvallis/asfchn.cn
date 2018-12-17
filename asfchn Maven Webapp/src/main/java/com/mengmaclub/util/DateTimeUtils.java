package com.mengmaclub.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 日期时间工具类
 * 
 * @date
 * @version 1.0
 */
public class DateTimeUtils {

	public static final String DEFAULT_DATE_FORMAT_PATTERN_SHORT = "yyyy-MM-dd";

	public static final String DEFAULT_DATE_FORMAT_PATTERN_FULL = "yyyy-MM-dd HH:mm:ss";

	private static Map<String, SimpleDateFormat> dateFormatCache = new ConcurrentHashMap<String, SimpleDateFormat>();

	/**
	 * 以yyyy-MM-dd HH:mm:ss形式返回当前时间的字符串
	 * 
	 * @return
	 */
	public static String getCurrentDateTimeString() {
		return getCurrentDateString(DEFAULT_DATE_FORMAT_PATTERN_FULL);
	}

	/**
	 * 以yyyy-MM-dd形式返回当前日期的字符串
	 * 
	 * @return
	 */
	public static String getCurrentDateString() {
		return getCurrentDateString(DEFAULT_DATE_FORMAT_PATTERN_SHORT);
	}

	/**
	 * 返回pattern所指定的当前时间的字符串
	 * 
	 * @param pattern
	 * @return
	 */
	public static String getCurrentDateString(String pattern) {
		if (pattern == null || "".equals(pattern.trim())) {
			return null;
		}
		SimpleDateFormat sdf = null;
		if (dateFormatCache.containsKey(pattern)) {
			sdf = dateFormatCache.get(pattern);
		} else {
			try {
				sdf = new SimpleDateFormat(pattern);
				dateFormatCache.put(pattern, sdf);
			} catch (Exception e) {
				e.printStackTrace();
				sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN_FULL);
			}
		}
		return sdf.format(new Date());
	}

	/**
	 * 返回时间date所指定的日期格式的字符串形式
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String getDateString(Date date, String pattern) {
		if (date == null || pattern == null || "".equals(pattern.trim())) {
			return null;
		}
		SimpleDateFormat sdf = null;
		if (dateFormatCache.containsKey(pattern)) {
			sdf = dateFormatCache.get(pattern);
		} else {
			try {
				sdf = new SimpleDateFormat(pattern);
				dateFormatCache.put(pattern, sdf);
			} catch (Exception e) {
				e.printStackTrace();
				sdf = new SimpleDateFormat(DEFAULT_DATE_FORMAT_PATTERN_FULL);
			}
		}
		return sdf.format(date);
	}

	/**
	 * 将dateTimeString按照格式pattern转换成Date
	 * 
	 * @param dateTimeString
	 * @param pattern
	 * @return
	 */
	public static Date getDateByString(String dateTimeString, String pattern) {
		if (dateTimeString == null || "".equals(dateTimeString.trim()) || pattern == null
				|| "".equals(pattern.trim())) {
			return null;
		}
		SimpleDateFormat sdf = null;
		if (dateFormatCache.containsKey(pattern)) {
			sdf = dateFormatCache.get(pattern);
		} else {
			sdf = new SimpleDateFormat(pattern);
			dateFormatCache.put(pattern, sdf);
		}
		try {
			return sdf.parse(dateTimeString);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 将dateTimeString按照默认格式yyyy-MM-dd HH:mm:ss转换成Date
	 * 
	 * @param dateTimeString
	 * @param pattern
	 * @return
	 */
	public static Date getDateByString(String dateTimeString) {
		return getDateByString(dateTimeString, DEFAULT_DATE_FORMAT_PATTERN_FULL);
	}

	/**
	 * 
	 * 时间加减方法,根据type类型，加减value
	 * 
	 * @param date
	 * @param type
	 *            操作对象，年/月/日/时/分/秒，eg：Calendar.MONTH
	 * @param value
	 *            更新值
	 * @return
	 */
	public static Date getUpdateDateTime(Date date, Integer type, Integer value) {
		if (null == date || null == value || null == type) {
			return null;
		}
		try {
			Calendar calendar = Calendar.getInstance();// 日历对象
			calendar.setTime(date);// 设置当前日期
			calendar.add(type, value);// 时间更改
			return calendar.getTime();
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 日期转化为大写
	 * 
	 * @param date
	 * @return
	 */
	public static String dataToUpper(Date date) {
		Calendar ca = Calendar.getInstance();
		ca.setTime(date);
		int year = ca.get(Calendar.YEAR);
		int month = ca.get(Calendar.MONTH) + 1;
		int day = ca.get(Calendar.DAY_OF_MONTH);
		return numToUpper(year) + "年" + monthToUppder(month) + "月" + dayToUppder(day) + "日";
	}

	/**
	 * 将数字转化为大写
	 * 
	 * @param num
	 * @return
	 */
	public static String numToUpper(int num) {
		// String u[] = {"零","壹","贰","叁","肆","伍","陆","柒","捌","玖"};
		// String u[] = {"零", "一", "二", "三", "四", "五", "六", "七", "八", "九"};
		String u[] = { "〇", "一", "二", "三", "四", "五", "六", "七", "八", "九" };
		char[] str = String.valueOf(num).toCharArray();
		String rstr = "";
		for (int i = 0; i < str.length; i++) {
			rstr = rstr + u[Integer.parseInt(str[i] + "")];
		}
		return rstr;
	}

	/**
	 * 月转化为大写 〈功能详细描述〉
	 * 
	 * @param month
	 * @return
	 */
	public static String monthToUppder(int month) {
		if (month < 10) {
			return numToUpper(month);
		} else if (month == 10) {
			return "十";
		} else {
			return "十" + numToUpper(month - 10);
		}
	}

	/**
	 * 日转化为大写
	 * 
	 * @param day
	 * @return
	 */
	public static String dayToUppder(int day) {
		if (day < 20) {
			return monthToUppder(day);
		} else {
			char[] str = String.valueOf(day).toCharArray();
			if (str[1] == '0') {
				return numToUpper(Integer.parseInt(str[0] + "")) + "十";
			} else {
				return numToUpper(Integer.parseInt(str[0] + "")) + "十" + numToUpper(Integer.parseInt(str[1] + ""));
			}
		}
	}

	/**
	 * 获取指定年份第几周的第一天
	 * 
	 * @param year
	 *            年份
	 * @param week
	 *            第几周
	 * @return 指定年份第几周的第一天
	 */
	public static Date getFirstDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.DATE, (week - 1) * 7);
		return getFirstDayOfWeek(c.getTime());
	}

	/**
	 * 获取指定日期所在周的第一天
	 * 
	 * @param date
	 *            日期
	 * @return 指定日期所在周的第一天
	 */
	public static Date getFirstDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek()); // Monday
		return c.getTime();
	}

	/**
	 * 获取指定年份第几周的最后一天
	 * 
	 * @param year
	 *            年份
	 * @param week
	 *            第几周
	 * @return 指定年份第几周的最后一天
	 */
	public static Date getLastDayOfWeek(int year, int week) {
		Calendar c = new GregorianCalendar();
		c.set(Calendar.YEAR, year);
		c.set(Calendar.MONTH, Calendar.JANUARY);
		c.set(Calendar.DATE, 1);
		c.add(Calendar.DATE, (week - 1) * 7);
		return getLastDayOfWeek(c.getTime());
	}

	/**
	 * 获取指定日期所在周的最后一天
	 * 
	 * @param date
	 *            日期
	 * @return 指定日期所在周的最后一天
	 */
	public static Date getLastDayOfWeek(Date date) {
		Calendar c = new GregorianCalendar();
		c.setFirstDayOfWeek(Calendar.MONDAY);
		c.setTime(date);
		c.set(Calendar.DAY_OF_WEEK, c.getFirstDayOfWeek() + 6); // Sunday
		return c.getTime();
	}
	
    /** 
     * 获得指定日期的前几天 
     *  
     * @param specifiedDay 
     * 				指定的日期字符串
     * @param beforeDays
     * 				往前推几天
     * @return 
     * @throws Exception 
     */  
    public static String getSpecifiedDayBefore(String specifiedDay, int beforeDays) {//可以用new Date().toLocalString()传递参数  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day - beforeDays);  
        String dayBefore = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
        return dayBefore;  
    }  
  
    /** 
     * 获得指定日期的后一天 
     *  
     * @param specifiedDay 
     * 				指定的日期字符串
     * @param afterDays
     * 				往后推迟的天数
     * @return 
     */  
    public static String getSpecifiedDayAfter(String specifiedDay, int afterDays) {  
        Calendar c = Calendar.getInstance();  
        Date date = null;  
        try {  
            date = new SimpleDateFormat("yy-MM-dd").parse(specifiedDay);  
        } catch (ParseException e) {  
            e.printStackTrace();  
        }  
        c.setTime(date);  
        int day = c.get(Calendar.DATE);  
        c.set(Calendar.DATE, day + afterDays);  
        String dayAfter = new SimpleDateFormat("yyyy-MM-dd").format(c.getTime());  
        return dayAfter;  
    }  	

	public static void main(String[] args) {
		String currentDate = getCurrentDateString();
		String beforeDate = getSpecifiedDayBefore(currentDate, 2);
		String afterDate = getSpecifiedDayAfter(currentDate, 2);
		System.out.println(currentDate);
		System.out.println(beforeDate);
		System.out.println(afterDate);
	}
	
	
}
