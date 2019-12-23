package cn.tedu.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class LoginServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//post���������������
		request.setCharacterEncoding("UTF-8");
		//��ȡ����
		String userName=request.getParameter("name");
		String password=request.getParameter("pwd");
		//��ȡ�Ƿ��ס�û���������
		String rem=request.getParameter("rem");// rem��ֵ��on/null
		//����Dao
		UserDao dao=new UserDao();
		User user=dao.login(userName,password);
		if(user==null) {//��¼ʧ���ض��򵽵�¼ҳ��
			response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
		}else {
			
			if(rem!=null) {//��ס�û���������
				Cookie c1=new Cookie("userName",userName);
				Cookie c2=new Cookie("password",password);
				response.addCookie(c1);
				response.addCookie(c2);
			} 
			
			//ͨ��Sessionʵ���Զ���¼
			//��ȡSession����
			HttpSession session =request.getSession();
			System.out.println(session.getId());
			//�ѵ�¼�ɹ��õ����û����󱣴���Session��
			session.setAttribute("user", user);
			
			
			
			response.sendRedirect(request.getContextPath()+"/HomeServlet");
		}
		
		
		
	}

}
