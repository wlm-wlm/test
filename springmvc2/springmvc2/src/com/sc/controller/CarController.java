package com.sc.controller;

import java.io.File;
import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.Users;

//把该类注册成bean对象，并且作为控制器组件
@Controller
//给该类配置一个请求映射的url地址
@RequestMapping("/carctrl")
public class CarController {
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav){
		System.out.println("添加购物车");
		mav.setViewName("success");
		return mav;
	}
	
	//上传方法
	@RequestMapping("/upload.do")
	public ModelAndView upload(ModelAndView mav,MultipartFile upload,HttpServletRequest req) 
			throws IllegalStateException, IOException{
		
		if(upload!=null){//文件对象
			String name=upload.getOriginalFilename();//文件名称
			if(name!=null&&!name.equals("")){//文件上传
				String path=req.getServletContext().getRealPath("upload");//路径
				File f=new File(path+"/"+name);//路径+文件名的文件对象
				upload.transferTo(f);//另存为
				
				mav.addObject("name",name);//设置文件名称
			}
		}
		mav.setViewName("show");
		
		return mav;
	}

}
