package com.lxm.lottery.servlet;

import java.util.Timer;
import java.util.TimerTask;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;

import org.json.JSONException;
import org.json.JSONObject;

import com.lxm.lottery.html.HttpRequest;
import com.lxm.lottery.service.MatchService;
import com.lxm.lottery.service.impl.MatchServiceImpl;

/**
 * Servlet implementation class WYExtractor
 */
public class WYExtractor extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private Timer timer;
	private static final int delay = 1000*5;
	private static final int minutes = 1000*60*1;
	private MatchService matchService;

	public void init() throws ServletException {
		super.init();
		this.timer = new Timer();
		this.timer.schedule(new ExtractorService(), delay,
				minutes);
	}

	public void destroy() {
		super.destroy();
		this.timer.cancel();
	}

	class ExtractorService extends TimerTask {

		public void run() {
			matchService = new MatchServiceImpl();
			System.out.println("data extractor runing");
			String loadData = HttpRequest
					.sendGet(
							"http://caipiao.163.com/order/preBet_jclqNewMixAllAjax.html",
							"");
			try {
				JSONObject jo = new JSONObject(loadData);
				matchService.addMatch(jo);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
	}

}
