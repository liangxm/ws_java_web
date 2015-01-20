package com.lxm.lottery.extractor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTableExtraction {

	private Matcher tableMacher;
	private Pattern tablePattern;
	
	private String tableStr;
	
	private static final String HTML_TAG_PATTERN = "(?i)<table class=\"listDataTable1 zebraTable2 mixTable tbNBT\" cellspacing=\"0\" cellpadding=\"0\">(.*?)</table>\\s*</td>\\s*</tr>\\s*</tbody>\\s*</table>";
	
	public HtmlTableExtraction(){
		tablePattern = Pattern.compile(HTML_TAG_PATTERN);
	}
	
	public ArrayList<HTMLDivElement> extractHTMLDivs(final String sourceHtml) {
		ArrayList<HTMLDivElement> elements = new ArrayList<HTMLDivElement>();
		
		tableMacher = tablePattern.matcher(sourceHtml);
		System.out.println("groupCount:"+tableMacher.groupCount());
		while (tableMacher.find()) {
			tableStr=tableMacher.group(0);
			System.out.println("tableStr:"+tableStr);
		}
		return elements;
	}
}
