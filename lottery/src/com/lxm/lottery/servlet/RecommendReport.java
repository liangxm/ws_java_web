package com.lxm.lottery.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.lxm.lottery.model.Match;
import com.lxm.lottery.service.MatchService;
import com.lxm.lottery.service.impl.MatchServiceImpl;
import com.lxm.lottery.util.JsonHelper;
import com.lxm.lottery.util.UFunction;
import com.lxm.lottery.wangyi.pojo.DataSet;

/**
 * Servlet implementation class HallServlet
 */
public class RecommendReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendReport() {
        super();
    }
    
    @Override
    public void init() throws ServletException {
    	super.init();
    	matchService = new MatchServiceImpl();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//calculate the number of the match
		List<Match> matchList = null;
		List<Match> recommendList = null;
		int failure=0;
		int success=0;
		try {
			recommendList = new ArrayList<Match>();
			matchList = matchService.findAll();
			for(Match match:matchList){
				JSONArray spTabMix = match.getSpTabMix();
				double guestRate1 = spTabMix.getJSONArray(0).getDouble(0);
				double hostRate1 = spTabMix.getJSONArray(0).getDouble(1);
				
				double guestRate2 = spTabMix.getJSONArray(2).getDouble(1);
				double hostRate2 = spTabMix.getJSONArray(2).getDouble(0);
				//主胜
				if(hostRate1<guestRate1 && hostRate2<guestRate2){
					match.setZxAnalysisURL("88888888");
					
					String result = UFunction.getMatchResult(match.getMixBidScore(),0);
					if("主胜".equals(result)){
						match.setHint("88888888");
						success++;
					}else if("主负".equals(result)){
						match.setHint("4444");
						failure++;
					}
					recommendList.add(match);
				}else if(hostRate1>guestRate1 && hostRate2>guestRate2){//主负
					match.setZxAnalysisURL("4444");
					
					String result = UFunction.getMatchResult(match.getMixBidScore(),0);
					if("主负".equals(UFunction.getMatchResult(match.getMixBidScore(),0))){
						match.setHint("88888888");
						success++;
					}else if("主胜".equals(result)){
						match.setHint("4444");
						failure++;
					}
					recommendList.add(match);
				}
			}
		} catch (JSONException e) {
			e.printStackTrace();
		} 
		
		String dateStr = request.getParameter("betDate");
		if(dateStr!=null){
			request.setAttribute("list", recommendList);
			request.getRequestDispatcher("/recommendHistory.jsp").forward(request, response);
		}else{
			
		System.out.println("主胜:"+success);
		System.out.println("主负:"+failure);
		//create the data objects
		DataSet dataSet1 = new DataSet("猜中",String.valueOf(success));
		DataSet dataSet2 = new DataSet("没猜中",String.valueOf(failure));
		
		//create the return JSON object
		JSONObject data = new JSONObject();
		JSONArray arr = new JSONArray();
		JSONObject obj1 = JsonHelper.toJSON(dataSet1);
		JSONObject obj2 = JsonHelper.toJSON(dataSet2);
		arr.put(obj1);
		arr.put(obj2);
		try {
			data.put("data", arr);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		
		//return data what was wrapped
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out = response.getWriter(); 
		out.print(data); 
		out.close();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
