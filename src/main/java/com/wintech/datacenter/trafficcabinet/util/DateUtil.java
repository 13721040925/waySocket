package com.wintech.datacenter.trafficcabinet.util;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.log4j.Logger;

//日期处理类
public final class DateUtil {
	private static final String FT = "yyyy-MM-dd HH:mm:ss";
	private static final String FT1 = "yyyy年MM月dd日 HH时mm分ss秒";
	// 当前系统时间
	private static final Date DT = new Date(System.currentTimeMillis());
	private static Logger log = Logger.getLogger(DateUtil.class);

	// 1、把字符串转化成java.util.Date
	public static java.util.Date convertStringToUtilDate(String source) {
		SimpleDateFormat ft = new SimpleDateFormat(FT);
		try {
			java.util.Date date = ft.parse(source);
			return date;
		} catch (Exception e) {
			log.debug(e);
		}
		return null;
	}

	// 2、把字java.util.Date化成符串转
	public static String convertUtilDateToString(java.util.Date source) {
		SimpleDateFormat ft = new SimpleDateFormat(FT);
		try {
			String str = ft.format(source);
			return str;
		} catch (Exception e) {
			log.debug(e);
		}
		return null;
	}

	// 3、把字符串转化成java.sql.Date
	public static java.sql.Date convertStringToSQLDate(String source) {
		SimpleDateFormat ft = new SimpleDateFormat(FT);
		try {
			java.util.Date date = ft.parse(source);
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			return sqldate;
		} catch (ParseException e) {
			log.debug(e);
		}
		return null;
	}

	// 4、把util转成sql
	public static java.sql.Date convertUtilDateToSQLDate(java.util.Date date) {
		try {
			java.sql.Date sqldate = new java.sql.Date(date.getTime());
			return sqldate;
		} catch (Exception e) {
			log.debug(e);
		}
		return null;
	}

	// 5、把util转成TimeStamp
	public static Timestamp convertUtilDateToTimeStamp(java.util.Date date) {
		try {
			Timestamp sqldate = new Timestamp(date.getTime());
			return sqldate;
		} catch (Exception e) {
			log.debug(e);
		}
		return null;
	}

	// 6、把Timestamp数据类型转化成util.Date
	public static java.util.Date convertTimeStampToUtilDate(Timestamp date) {
		try {
			java.util.Date sqldate = new java.util.Date(date.getTime());
			return sqldate;
		} catch (Exception e) {
			log.debug(e);
		}
		return null;
	}

	// 7、根据util.Date生成年龄
	public static Integer convertUtilDateToAge(java.util.Date date) {
		try {
			Calendar now = Calendar.getInstance();
			Integer year = now.get(Calendar.YEAR);
			Calendar target = Calendar.getInstance();
			target.setTime(date);
			Integer targetYear = target.get(Calendar.YEAR);
			return (year - targetYear == 0) ? (year - targetYear + 1) : (year - targetYear);
		} catch (Exception e) {
			log.debug(e);
		}
		return 1;
	}

	// 1、把字符串转化成java.util.Date
	public static Timestamp convertStringToTimestamp(String source) {
		if (source != null) {
			try {
				return new Timestamp(convertStringToUtilDate(source).getTime());
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
