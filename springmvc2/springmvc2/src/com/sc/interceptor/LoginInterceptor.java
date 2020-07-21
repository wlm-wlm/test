package com.sc.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		System.out.println("3、所有请求完成之后执行");
        
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("2、请求进入控制器方法之后执行");

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("1、请求进入控制器方法之前执行");
		
		HttpSession session=arg0.getSession();
		
		Object obj=session.getAttribute("nowuser");
		if(obj!=null){//用户已登录
			return true;//通过
		}
		
		//用户未登录，重定向到登录页面
		arg1.sendRedirect("../index.jsp?islogin=no");
		return false;//不通过
	}

}
