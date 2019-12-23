package cn.tedu.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CookieServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//����Cookie���󲢱�������
		Cookie c1=new Cookie("msg1", "HelloWorld");
		//�����Ҫ����������Ҫ����url����
		Cookie c2=new Cookie("msg2",URLEncoder.encode("��Һ�", "UTF-8"));
		//����ʱ�� ��������� ����ֻ������������ڴ��У��ر�����������
		//����ʱ��� ���ݻᱣ���ڴ����У���ָ��ʱ����ɾ��
		c1.setMaxAge(60*60*24*30);//����һ����
		//��cookie�·��������
		response.addCookie(c1);
		response.addCookie(c2);
		//��ʾ������
		response.setContentType("text/html;charset=utf-8");
		PrintWriter pw=response.getWriter();
		pw.print("�����ɣ�");
		pw.close();
	}

}
