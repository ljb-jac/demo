package cn.tedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.utils.ThUtils;

public class SearchServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String keyword=request.getParameter("keyword");
		System.out.println(keyword);
		//����Dao��ѯ�������
		ArticleDao dao=new ArticleDao();
		List<Article> list=dao.findByKeyword(keyword);
		//�Ѳ�ѯ���ļ��ϴ��ݵ�ҳ����
		Context context=new Context();
		context.setVariable("list", list);//����listҳ�� "list"���ܱ�
		
		ThUtils.write("list", context, response);
		
		
	}



}
