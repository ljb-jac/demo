package cn.tedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.UserDao;
import cn.tedu.entity.User;

public class RegServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String userName=request.getParameter("name");
		String email=request.getParameter("email");
		String password=request.getParameter("pwd"); //rpwdǰ�˿�ʵ����֤�����ٷ�����ѹ��
		//��װ
		User user=new User(0,userName,password,email);
		//ͨ��Daoȥ����
		UserDao dao=new UserDao();
		dao.save(user);
		//�ض��򵽵�¼ҳ��
		response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
		
	}


}
