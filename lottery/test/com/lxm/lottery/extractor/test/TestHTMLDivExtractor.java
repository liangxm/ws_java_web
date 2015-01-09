package com.lxm.lottery.extractor.test;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.BeforeClass;
import org.junit.Test;

import com.lxm.lottery.extractor.HTMLDivElement;
import com.lxm.lottery.extractor.HtmlDivExtraction;
import com.lxm.lottery.html.HttpRequest;

public class TestHTMLDivExtractor {
	
	private static String HTML_DOCUMENT;
	private static HtmlDivExtraction htmlTagExtraction;
	private static String targetURL = "http://caipiao.163.com/order/jclq/";
	
	private String expectedValidation;
	
	
	@BeforeClass
	public static void initialize(){
		htmlTagExtraction = new HtmlDivExtraction();
		HTML_DOCUMENT = HttpRequest.sendGet(targetURL, "from=pzsempz");
	}
	
	@Test
	public void test(){
		System.out.println("Html:"+this.HTML_DOCUMENT);
		ArrayList<HTMLDivElement> divElements = htmlTagExtraction.extractHTMLDivs(this.HTML_DOCUMENT);
		for (int i = 0; i < divElements.size(); i++) {
			HTMLDivElement divElem = divElements.get(i);
			System.out.println();
			assertEquals("Result", this.expectedValidation, divElem.getDivElement());
			assertEquals("Result", this.expectedValidation, divElem.getDivBody());	
		}
	}

}
