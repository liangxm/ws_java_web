package com.lxm.lottery.extractor;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlTableExtraction {

	private Matcher tableMacher,trMatcher1,trMatcher2,trMatcher3;
	private Pattern tablePattern,trPattern1,trPattern2,trPattern3;
	
	private String tableStr,trStr1,trStr2,trStr3;
	
	private static final String TABLE_IN_HTML_PATTERN = "(?i)<table class=\"listDataTable1 zebraTable2 mixTable tbNBT\" cellspacing=\"0\" cellpadding=\"0\">(.*?)</table>\\s*</td>\\s*</tr>\\s*</tbody>\\s*</table>";
	private static final String TR_IN_TABLE_PATTERN1 = "(?is)(<tr playtime=[^>]*>)(.*?)(</tr>)";
	private static final String TR_IN_TABLE_PATTERN2 = "(?is)(<tr id=\"opt[^>]*>)(.*?)(</tr>)";
	private static final String TR_IN_TABLE_PATTERN3 = "(?is)(<tr class=\"hide\"[^>]*>)(.*?)(</tr>)";
	
	public HtmlTableExtraction(){
		tablePattern = Pattern.compile(TABLE_IN_HTML_PATTERN);
		trPattern1 = Pattern.compile(TR_IN_TABLE_PATTERN1);
		trPattern2 = Pattern.compile(TR_IN_TABLE_PATTERN2);
		trPattern3 = Pattern.compile(TR_IN_TABLE_PATTERN3);
	}
	
	public ArrayList<HTMLDivElement> extractHTMLDivs(final String sourceHtml) {
		ArrayList<HTMLDivElement> elements = new ArrayList<HTMLDivElement>();
		
		tableMacher = tablePattern.matcher(sourceHtml);
		System.out.println("groupCount1:"+tableMacher.groupCount());
		while (tableMacher.find()) {
			tableStr=tableMacher.group(0);
			System.out.println("tableStr:"+tableStr);
			
			trMatcher1 = trPattern1.matcher(tableStr);
			printContent(trMatcher1,"trMatcher1");
			
			trMatcher2 = trPattern2.matcher(tableStr);
			printContent(trMatcher2,"trMatcher2");
			
			trMatcher3 = trPattern3.matcher(tableStr);
			printContent(trMatcher3,"trMatcher3");
		}
		return elements;
	}
	
	public void printContent(Matcher matcher,String label){
		int count = matcher.groupCount();
		System.out.println(label+"-count:"+count);
		while(matcher.find()){
			for(int i=0;i<count;i++){
				System.out.println(label+"-group-"+i+":"+matcher.group(i));
			}
			System.out.println();
			System.out.println();
		}
	}
}
