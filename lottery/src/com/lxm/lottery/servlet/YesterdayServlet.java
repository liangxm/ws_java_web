package com.lxm.lottery.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxm.lottery.service.MatchService;
import com.lxm.lottery.service.impl.MatchServiceImpl;

/**
 * Servlet implementation class HallServlet
 */
public class YesterdayServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MatchService matchService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public YesterdayServlet() {
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
		if(dateStr!=null){
			request.setAttribute("list", matchService.getMatchListByDate(dateStr));
		}else{
			request.setAttribute("list", matchService.getYesterdayMatchList());
		}
		request.getRequestDispatcher("/yesterday.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
