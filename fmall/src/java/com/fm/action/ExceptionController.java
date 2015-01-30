package com.fm.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class ExceptionController {

	@RequestMapping("/null")
	public void testNullPointerException() {
//		Blog blog = null;
//		//这里就会发生空指针异常，然后就会返回定义在SpringMVC配置文件中的null视图
//		System.out.println(blog.getId());
	}
	
	@RequestMapping("/number")
	public void testNumberFormatException() {
		//这里就会发生NumberFormatException，然后就会返回定义在SpringMVC配置文件中的number视图
		Integer.parseInt("abc");
	}
	
	@RequestMapping("/default")
	public void testDefaultException() {
		if (1==1)
			//由于该异常类型在SpringMVC的配置文件中没有指定，所以就会返回默认的exception视图
			throw new RuntimeException("Error!");
	}
	
}
