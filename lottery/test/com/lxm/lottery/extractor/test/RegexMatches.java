package com.lxm.lottery.extractor.test;

import java.text.SimpleDateFormat;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexMatches {
	public static void main(String args[]) {
		java.util.Date date = new java.util.Date(new Long("1421078220000"));
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:MM:ss");
		System.out.println(sdf.format(date));
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