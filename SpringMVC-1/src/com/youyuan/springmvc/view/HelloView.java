package com.youyuan.springmvc.view;

import java.util.Date;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.View;

/**
 * 自定义视图,需要实现View接口,视图名称就是类名的第一个字母小写
 * @author zhangyu
 * @date 2018-4-4 下午9:13:24
 */
@Component
public class HelloView implements View {

	@Override
	public String getContentType() {
		// TODO Auto-generated method stub
		return "text/html";
	}

	@Override
	public void render(Map<String, ?> map, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.getWriter().write(new String("自定义视图,实现View接口".getBytes("UTF-8"))+new Date());
	}

}
