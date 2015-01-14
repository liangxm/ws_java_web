package com.lxm.lottery.servlet;

import java.io.IOException;
import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.lxm.lottery.service.ExtractorService;

/**
 * Servlet implementation class WYExtractor
 */
@WebServlet("/WYExtractor")
public class WYExtractor extends HttpServlet {
	
	private Timer timer = null;
	
	private static final long serialVersionUID = 1L;

	public void init() throws ServletException {  
		timer = new Timer(true);
		timer.schedule(new ExtractorService(), 3000);
    }
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
