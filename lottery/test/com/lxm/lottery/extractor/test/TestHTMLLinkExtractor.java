package com.lxm.lottery.extractor.test;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.lxm.lottery.extractor.HTMLLinkElement;
import com.lxm.lottery.extractor.HtmlLinkExtraction;

@RunWith(Parameterized.class)
public class TestHTMLLinkExtractor {

	private String HTML_DOCUMENT;
	private static HtmlLinkExtraction htmlTagExtraction;
	private String expectedValidation;

	private static final String HTML = "http://www.javacodegeeks.com/";

	public TestHTMLLinkExtractor(String str, String expectedValidation) {
		this.HTML_DOCUMENT = str;
		this.expectedValidation = expectedValidation;
	}

	@BeforeClass
	public static void initialize() {
		htmlTagExtraction = new HtmlLinkExtraction();
	}

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] {

				{ "Blah blah blah <a href='http://www.javacodegeeks.com/'>JavaCodeGeeks</a> blah blah blah blah", HTML },                         
				{ "Blah blah blah <a HREF='http://www.javacodegeeks.com/'>JavaCodeGeeks</a> blah blah blah blah", HTML },
				{ "Blah blah blah <a target='_blank' HREF='http://www.javacodegeeks.com/'>JavaCodeGeeks</a> blah blah blah blah", HTML } };

		return Arrays.asList(data);
	}

	@Test
	public void test() {

		ArrayList<HTMLLinkElement> linkElements = htmlTagExtraction.extractHTMLLinks(this.HTML_DOCUMENT);
		for (int i = 0; i < linkElements.size(); i++) {
			HTMLLinkElement linkElem = linkElements.get(i);
			System.out.println();
			assertEquals("Result", this.expectedValidation, linkElem.getLinkAddress());	
		}

	}
}