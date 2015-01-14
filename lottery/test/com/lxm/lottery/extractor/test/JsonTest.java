package com.lxm.lottery.extractor.test;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.Test;

import com.lxm.lottery.html.HttpRequest;
import com.lxm.lottery.util.JsonHelper;
import com.lxm.lottery.wangyi.pojo.WYData;
import com.lxm.lottery.wangyi.pojo.WYMatch;

public class JsonTest {

	@Test
	public void test1(){
		String loadData=HttpRequest.sendGet("http://caipiao.163.com/order/preBet_jclqNewMixAllAjax.html", "cache=1420787380503&betDate=");
		try {
			JSONObject jo = new JSONObject(loadData);
			JSONObject matchList = jo.getJSONObject("matchList");
			JSONObject obj = matchList.getJSONObject("201501121301");
			
			
			System.out.println(obj.get("buyEndTime").toString());
			
			
			String jsonStr = jo.toString();
	        WYData data = new WYData();
	        JsonHelper.toJavaBean(data, jsonStr);
	        System.out.println(data.getMatchList());
	        
	        Map matchMap = JsonHelper.toMap(data.getMatchList());
	        
	        List<WYMatch> resultMap = new ArrayList<WYMatch>();
		} catch (JSONException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
	}
}
