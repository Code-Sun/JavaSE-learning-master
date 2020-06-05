
/**
 * @Description: TODO(用一句话描述该文件做什么)
 * @author markzgwu
 * @date 2018年4月28日
 * @version V1.0
 */

package com.edu.sunyifeng.Utils;

import cn.hutool.core.date.DateTime;
import cn.hutool.log.LogFactory;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author markzgwu
 *
 */
public class TimeUtil {
	public static final String yyyyMMddHHmmss = "yyyy-MM-dd HH:mm:ss";

	public static final String yyyyMMddHHmm_CN = "yyyy年MM月dd日HH时mm分";

	public static final String yyyyMMdd = "yyyy-MM-dd";
	public static final String HHmmss = "HH:mm:ss";

	public static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	public static final String[] weekDays = {"星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};

	public static String now() {
		final DateTime now = DateTime.now();
		final String key = now.toString();
		return key;
	}

	public static String parse(long time, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		Date date = new Date(time);
		return formatter.format(date);
	}

	public static String parse(Date date, String format) {
		SimpleDateFormat formatter = new SimpleDateFormat(format);
		return formatter.format(date);
	}

	public static String toDateTimeString(Date date) {
		return formatter.format(date);
	}

	/**
	 * 获取日期在星期列表weekDays中的索引
	 * @param date
	 * @return
	 */
	public static int weekDayIndex(Date date) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(date);
		return cal.get(Calendar.DAY_OF_WEEK) - 1;
	}

	/**
	 * 获取 2019-05-23 14:23:02（星期四）
	 * @param date
	 * @return
	 */
	public static String getDateTimeDay(Date date) {
		int dayIdx = weekDayIndex(date);
		return TimeUtil.toDateTimeString(date) + "（" + weekDays[dayIdx] +"）";
	}

	/**
	 * 获取 2019年05月23日14时23分（星期四）
	 * @param date
	 * @return
	 */
	public static String getDateTimeDay_CN(Date date) {
		int dayIdx = weekDayIndex(date);
		SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMddHHmm_CN);
		String format = formatter.format(date);
		return format + "（" + weekDays[dayIdx] +"）";
	}

	public static Date parse(String dateStr){
		try {
			return formatter.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * "2018-09-01 01:09:12" --> "2018-09-01"
	 * 
	 * @param date
	 * @return
	 * @throws ParseException
	 */
	public static Date toShortDate(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMdd);
		String strDate = formatter.format(date);
		try {
			date = formatter.parse(strDate);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * "2018-09-01 01:09:12" --> "2018-09-01"
	 *
	 * @param date
	 * @return
	 * @throws
	 */
	public static String toShortDateStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMdd);
		return  formatter.format(date);
	}

	/**
	 *  短日期2018-09-01字符串 -->data对象
	 * @param date
	 * @return
	 */
	public static Date toShortDate(String date) {
		SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMdd);
		try {
			return  formatter.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * "2018-09-01" --> date
	 *
	 * @param date
	 * @return
	 * @throws
	 */
	public static String toDateStr(Date date) {
		SimpleDateFormat formatter = new SimpleDateFormat(yyyyMMdd);
		return  formatter.format(date);
	}

	/**
	 *
	 * @param hms "12:12:12" 转化为 129192ms
	 * @return
	 * @throws ParseException
	 */
	public static int hhmmssToMillis(String hms) {
		String[] hhmmss = hms.split(":");
		int millis = Integer.valueOf(hhmmss[0]) * (3600 * 1000) + Integer.valueOf(hhmmss[1]) * (60 * 1000)
				+ Integer.valueOf(hhmmss[2]) * (1000);
		return millis;
	}
	/**
	 *
	 * @param hms "12:12:12" 转化为 1291minutes
	 * @return
	 * @throws ParseException
	 */
	public static int hhmmssToMinutes(String hms) {
		String[] hhmmss = hms.split(":");
		int minutes = Integer.valueOf(hhmmss[0]) * (60) + Integer.valueOf(hhmmss[1]);
		return minutes;
	}

	public static void timeLogger(Class<?> clazz, String msg) {
		LogFactory.get(clazz).info("system  time: [ " + TimeUtil.parse(System.currentTimeMillis(),TimeUtil.yyyyMMddHHmmss)  + "];     " + msg);
	}

	/**
	 * 判断时间是否在时间段内
	 * 
	 * @param nowTime
	 * @param beginTime
	 * @param endTime
	 * @return
	 */
	public static boolean belongCalendar(final Date nowTime, final Date beginTime, final Date endTime) {
		return nowTime.getTime() >= beginTime.getTime() && nowTime.getTime() <= endTime.getTime();
	}
	
	public static boolean belongTime(final Date nowTime, final int beginTime, final int endTime) {
		final SimpleDateFormat df = new SimpleDateFormat("HH");
		final int date= Integer.parseInt((df.format(nowTime)));
		return date >= beginTime && date <= endTime;
	}

	/**
	 *  比较传入的字符串日期2019-01-12 与系统时间的大小
	 * @return
	 */
	public static boolean largeThanNow(String dateStr) {
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		try{
			long t1 = formatter.parse(dateStr).getTime();
			Calendar cal = Calendar.getInstance();
			String now = cal.get(Calendar.YEAR) + "-" + (cal.get(Calendar.MONTH) + 1) + "-" + cal.get(Calendar.DAY_OF_MONTH);
			LogFactory.get().info("dateStr:" + dateStr  + ";  now:" + now );
			long t2 = formatter.parse(now).getTime();
			return t1 > t2;
		}catch (ParseException e){
			e.printStackTrace();
		}
		return false;
	}

	public static String secondToDate(long second,String patten) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTimeInMillis(second * 1000);
		Date date = calendar.getTime();
		SimpleDateFormat format = new SimpleDateFormat(patten);
		String dateString = format.format(date);
		return dateString;
	}

    public static void main(String[] args) {
    	System.out.println(belongTime(new Date(),0,24));
    }
	
}
