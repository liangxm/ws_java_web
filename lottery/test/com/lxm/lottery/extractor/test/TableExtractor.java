package com.lxm.lottery.extractor.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.junit.Test;

import com.lxm.lottery.extractor.HtmlTableExtraction;
import com.lxm.lottery.html.HttpRequest;

public class TableExtractor {
	
	private HtmlTableExtraction htmlTableExtraction;
	
	@Test
	public void test() throws ParseException{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		java.util.Date date = sdf.parse("2015-01-22 10:00:00");
		System.out.println("date1:"+date.getTime());
		System.out.println("date2:"+sdf.format(new java.util.Date(new Long("1422022149361"))));
		htmlTableExtraction = new HtmlTableExtraction();
		String loadData = HttpRequest.sendGet("http://tools.ecp888.com/jclq/index","id=bhtgg&date=2013-01-10");
		htmlTableExtraction.extractHTMLDivs(loadData);
	}
}
