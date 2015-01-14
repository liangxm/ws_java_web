package com.lxm.lottery.servlet;

import java.util.Timer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import com.lxm.lottery.service.ExtractorService;

/**
 * Servlet implementation class WYExtractor
 */
public class WYExtractor extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private Timer timer;
	private static final int delay = 1000*5;
	private static final int minutes = 1000*60*60;
	
	@Override
	public void init() throws ServletException {  
		super.init();
		timer = new Timer();
		timer.schedule(new ExtractorService(), delay, minutes);
    }
	
	@Override
	public void destroy() {
		super.destroy();
		timer.cancel();
	}
	
}
