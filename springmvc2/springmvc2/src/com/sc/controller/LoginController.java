package com.sc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.Users;

//把该类注册成bean对象，并且作为控制器组件
@Controller
//给该类配置一个请求映射的url地址
@RequestMapping("/loginctrl")
public class LoginController {
	
	
	//给该方法配置一个请求映射的url地址
	@RequestMapping("/login.do")//完整url地址是：loginctrl/login.do
	public ModelAndView login(ModelAndView mav,Users u,HttpSession session){//如果请求的参数名称和u对象中的属性名称一致的情况，就会自动赋值
		System.out.println("进入控制器的登陆方法了");
		System.out.println("用户对象："+u);
		
		if(u.getUname().equals("admin")&&u.getUpass().equals("123")){
			//登陆成功
			session.setAttribute("nowuser", u);//用户对象存入session
			//进入主界面
			mav.setViewName("redirect:../main.jsp");
		}else{
			//登陆失败
			//进入登录页面
			//如果有重定向，那么视图解析器不再起作用，需要写完整路径
			mav.setViewName("redirect:../index.jsp?isfail=yes");
		}
		
		return mav;
	}

}
