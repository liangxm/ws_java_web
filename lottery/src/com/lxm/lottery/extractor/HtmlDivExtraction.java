package com.lxm.lottery.extractor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlDivExtraction {

	private Matcher mTag, mDiv;
	private Pattern pTag, pDiv;
	
	private static final String HTML_TAG_PATTERN = "(?i)<div class=\"dataBody unAttention\">(.*?)</div>";
	private static final String HTML_HREF_TAG_PATTERN = "";
	
	public HtmlDivExtraction(){
		pTag = Pattern.compile(HTML_TAG_PATTERN);
		pDiv = Pattern.compile(HTML_HREF_TAG_PATTERN);
	}
	
	public ArrayList<HTMLDivElement> extractHTMLDivs(final String sourceHtml) {
		ArrayList<HTMLDivElement> elements = new ArrayList<HTMLDivElement>();
		
		mTag = pTag.matcher(sourceHtml);
		
		System.out.println("groupCount:"+mTag.groupCount());
		while (mTag.find()) {
			System.out.println("group0:"+mTag.group(0));
			System.out.println("group1:"+mTag.group(1));
		}
		return elements;
	}
}
