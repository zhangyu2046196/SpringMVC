package com.youyuan.springmvc.handler;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorld {

	/**
	 * 1、@requestMapping配置视图解析器的请求url
	 * 2、配置视图解析器(springMVC.xml中的InternalResourceViewResolver),handler方法的返回结果解析成实际物理视图地址
	 * 		p:prefix指定物理地址的路径前缀(WEB-INF/views/)
	 * 		p:suffix指定物理地址文件的后缀名(.jsp)
	 * 	例如:此处理器(handler)的返回值success的物理视图地址/WEB-INF/views/success.jsp
	 * @return
	 */
	@RequestMapping("/helloWorld")
	public String hw(){
		System.out.println("SpringMVC第一个程序");
		return "success";
	}
}
