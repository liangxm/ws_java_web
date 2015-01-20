package com.lxm.lottery.extractor.test;

import org.junit.Test;

import com.lxm.lottery.extractor.HtmlTableExtraction;
import com.lxm.lottery.html.HttpRequest;

public class TableExtractor {
	
	private HtmlTableExtraction htmlTableExtraction;
	
	@Test
	public void test(){
		htmlTableExtraction = new HtmlTableExtraction();
		String loadData = HttpRequest.sendGet("http://tools.ecp888.com/jclq/index","id=bhtgg&date=2013-01-10");
		htmlTableExtraction.extractHTMLDivs(loadData);
	}
}
