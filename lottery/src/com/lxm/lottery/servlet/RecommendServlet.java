package com.lxm.lottery.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxm.lottery.model.Match;
import com.lxm.lottery.service.MatchService;
import com.lxm.lottery.service.impl.MatchServiceImpl;

/**
 * Servlet implementation class HallServlet
 */
public class RecommendServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RecommendServlet() {
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
		String dateStr = request.getParameter("betDate");
		List<Match> matchlist = matchService.getDaliyRecommend(dateStr);
		System.out.println("matchList:"+matchlist.size());
		request.setAttribute("list", matchlist);
		request.getRequestDispatcher("/recommend.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
