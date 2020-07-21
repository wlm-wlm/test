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

//�Ѹ���ע���bean���󣬲�����Ϊ���������
@Controller
//����������һ������ӳ���url��ַ
@RequestMapping("/carctrl")
public class CarController {
	
	@RequestMapping("/add.do")
	public ModelAndView add(ModelAndView mav){
		System.out.println("��ӹ��ﳵ");
		mav.setViewName("success");
		return mav;
	}
	
	//�ϴ�����
	@RequestMapping("/upload.do")
	public ModelAndView upload(ModelAndView mav,MultipartFile upload,HttpServletRequest req) 
			throws IllegalStateException, IOException{
		
		if(upload!=null){//�ļ�����
			String name=upload.getOriginalFilename();//�ļ�����
			if(name!=null&&!name.equals("")){//�ļ��ϴ�
				String path=req.getServletContext().getRealPath("upload");//·��
				File f=new File(path+"/"+name);//·��+�ļ������ļ�����
				upload.transferTo(f);//���Ϊ
				
				mav.addObject("name",name);//�����ļ�����
			}
		}
		mav.setViewName("show");
		
		return mav;
	}

}
