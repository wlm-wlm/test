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
		System.out.println("3�������������֮��ִ��");
        
	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		System.out.println("2������������������֮��ִ��");

	}

	@Override
	public boolean preHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2) throws Exception {
		System.out.println("1������������������֮ǰִ��");
		
		HttpSession session=arg0.getSession();
		
		Object obj=session.getAttribute("nowuser");
		if(obj!=null){//�û��ѵ�¼
			return true;//ͨ��
		}
		
		//�û�δ��¼���ض��򵽵�¼ҳ��
		arg1.sendRedirect("../index.jsp?islogin=no");
		return false;//��ͨ��
	}

}
