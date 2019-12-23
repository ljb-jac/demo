package cn.tedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.entity.User;
import cn.tedu.utils.ThUtils;

public class ShowLoginServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�ж�Session���Ƿ���user���� ����˵����¼�ɹ��� ֱ����ʾ��ҳ
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user"); //Session��Ķ�����object�� ��ǿ��
		if(user!=null) {
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
			return;//������벻ִ��
		}
		
		
		Context context=new Context();
		
		//ȡ��cookie�е��û���������
		Cookie[] cookies=request.getCookies();
		for (Cookie cookie : cookies) {
			if(cookie.getName().equals("userName")) {
				//���û�����ӵ�������
				context.setVariable("userName", cookie.getValue());				
			}
			//�жϱ�����Ƿ�������
			if(cookie.getName().equals("password")) {
				//��������ӵ�������
				context.setVariable("password", cookie.getValue());	
			}
		}
		
		ThUtils.write("login", context, response);
	}

	

}
