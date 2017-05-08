package com.latewind.practice.concurrent.share;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
/**
 * use the ThreadLocal to make thread safe
 * every thread has a copy of the simpleDateFormate 
 * 
 * @author hasee
 *
 */
public class DateParseUtil {
	private static final String PATTERN = "yyyy-MM-dd";
	private static ThreadLocal<SimpleDateFormat> formater = new ThreadLocal<SimpleDateFormat>() {
		protected SimpleDateFormat initialValue() {
			return new SimpleDateFormat(PATTERN);
		}

	};

	public static SimpleDateFormat getSimpleDateFormat() {
		return formater.get();
	}

	public static Date parse(String dateStr) {

		try {
			return getSimpleDateFormat().parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return null;
	}

}
