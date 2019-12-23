package cn.tedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.utils.ThUtils;

public class ArticleServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String oId=request.getParameter("oId");
		System.out.println("����oId:"+oId);
		//ͨ��oId�����ݿ��в�ѯ��������
		ArticleDao dao=new ArticleDao();
		//ͨ������id��ѯ����������Ϣ
		Article a=dao.findById(oId);
		//������װ�����������ݸ�ҳ��
		Context context=new Context();
		context.setVariable("a",a);
		
		ThUtils.write("article", context, response);
		
	}
	


}
