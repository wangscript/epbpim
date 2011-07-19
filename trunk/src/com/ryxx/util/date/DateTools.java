package com.ryxx.util.date;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang.time.DateFormatUtils;

/**
 * <p>
 * 对日期java.util.Date的操作
 * </p>
 * 
 * @see java.util.Date
 * @author Boysen
 * @version 1.0 2004-11-3
 */
public class DateTools {

	/**
	 * <p>
	 * 用"yyyy-MM-dd HH:mm:ss"格式格式化日期时间
	 * </p>
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return
	 */
	public static String date2string(Date date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <p>
	 * 用"yyyy-MM-dd HH:mm:ss"格式格式化日期时间
	 * </p>
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return
	 */
	public static String date2string(long date) {
		return DateFormatUtils.format(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * <p>
	 * 用指定格式格式化日期时间
	 * </p>
	 * 
	 * @param date
	 *            待格式化的日期
	 * @return
	 */
	public static String date2string(Date date, String format) {
		return DateFormatUtils.format(date, format);
	}

	/**
	 * <p>
	 * 用指定格式格式化日期时间
	 * </p>
	 * 
	 * @param date
	 *            待格式化的long型日期
	 * @return
	 */
	public static String date2string(long date, String format) {
		return DateFormatUtils.format(date, format);
	}

	/**
	 * <p>
	 * 取得系统的当前时间
	 * </p>
	 * 
	 * @return
	 */
	public static long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 将时间字符串转换成Date类型时间
	 * 
	 * @param date
	 *            时间字符串
	 * @param format
	 *            字符串格式
	 * @return 字符串对应的Date类型时间
	 * @author zhongzm(Added on 2007/10/26)
	 */
	public static Date string2Date(String date, String format) {
		Date d = null;
		DateFormat ft = new SimpleDateFormat(format);
		try {
			d = ft.parse(date);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return d;
	}

	/**
	 * 将时间字符串转换成Date类型时间
	 * 
	 * @param date
	 *            yyyy-MM-dd HH:mm:ss 类型的时间字符串
	 * @return 字符串对应的Date类型时间
	 * @author zhongzm(Added on 2007/10/26)
	 */
	public static Date string2Date(String date) {
		return string2Date(date, "yyyy-MM-dd HH:mm:ss");
	}

	/**
	 * 将时间字符串转换成时间对应的毫秒值
	 * 
	 * @param date
	 *            时间字符串
	 * @param format
	 *            字符串格式
	 * @return 字符串对应的时间毫秒值
	 * @author zhongzm(Added on 2007/10/26)
	 */
	public static long string2TimeMillis(String date, String format) {
		long d = 0;
		Date dt = string2Date(date, format);
		if (dt != null) {
			d = dt.getTime();
		}
		return d;
	}

	/**
	 * 将时间字符串转换成时间对应的毫秒值
	 * 
	 * @param date
	 *            yyyy-MM-dd HH:mm:ss 类型的时间字符串
	 * @return 字符串对应的时间毫秒值
	 * @author zhongzm(Added on 2007/10/26)
	 */
	public static long string2TimeMillis(String date) {
		return string2TimeMillis(date, "yyyy-MM-dd HH:mm:ss");
	}

	public static void main(String[] args) {
		// System.out.println(date2string(new Date(),"yyyy-MM-dd HH:mm:ss"));

		DateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		Date d = string2Date("2007-10-09 11:8:0");
		System.out.println(format.format(d));
	}
}
