package com.lxm.lottery.extractor.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	public static void main(String args[]) throws ParseException {
		//java.util.Date date = new java.util.Date(new Long("1422329400000"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		java.util.Date date = sdf.parse("2015-01-21 10:00:00");
		//System.out.println(sdf.format(date));
		System.out.println("date:"+date.getTime());
	}

	public static void test1() {
		// 按指定模式在字符串查找
		String line = "This order was placed for QT3000! OK?";
		String pattern = "(.*)(\\d+)(.*)";

		// 创建 Pattern 对象
		Pattern r = Pattern.compile(pattern);

		// 现在创建 matcher 对象
		Matcher m = r.matcher(line);

		System.out.println("groupCount:" + m.groupCount());
		if (m.find()) {
			System.out.println("Found value: " + m.group(0)); // (.*)
			System.out.println("Found value: " + m.group(1));
			System.out.println("Found value: " + m.group(2));
			System.out.println("Found value: " + m.group(3));
		} else {
			System.out.println("NO MATCH");
		}
	}
}