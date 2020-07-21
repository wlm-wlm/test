package com.sc.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.sc.entity.Users;

//�Ѹ���ע���bean���󣬲�����Ϊ���������
@Controller
//����������һ������ӳ���url��ַ
@RequestMapping("/loginctrl")
public class LoginController {
	
	
	//���÷�������һ������ӳ���url��ַ
	@RequestMapping("/login.do")//����url��ַ�ǣ�loginctrl/login.do
	public ModelAndView login(ModelAndView mav,Users u,HttpSession session){//�������Ĳ������ƺ�u�����е���������һ�µ�������ͻ��Զ���ֵ
		System.out.println("����������ĵ�½������");
		System.out.println("�û�����"+u);
		
		if(u.getUname().equals("admin")&&u.getUpass().equals("123")){
			//��½�ɹ�
			session.setAttribute("nowuser", u);//�û��������session
			//����������
			mav.setViewName("redirect:../main.jsp");
		}else{
			//��½ʧ��
			//�����¼ҳ��
			//������ض�����ô��ͼ���������������ã���Ҫд����·��
			mav.setViewName("redirect:../index.jsp?isfail=yes");
		}
		
		return mav;
	}

}
