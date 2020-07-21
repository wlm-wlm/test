package com.sc.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

public class MyException implements HandlerExceptionResolver {

	@Override
	public ModelAndView resolveException(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2,
			Exception arg3) {
		
		System.out.println("�쳣�ǣ�"+arg3.getMessage());
		
		ModelAndView  mav=new ModelAndView();
		mav.setViewName("error");//  /WEB-INF/error.jsp
		
		return mav;
	}

}
