package cn.tedu.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import cn.tedu.dao.ArticleDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.User;

public class SendActionServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//��ȡ����
		String title=request.getParameter("title");
		String abs=request.getParameter("abs");
		String content=request.getParameter("content");
		String imgName=request.getParameter("imgName");
		String putTop=request.getParameter("putTop");
		int isTop = putTop==null?0:1;
		//�����ݷ�װ��������
		Article a =new Article(0, title, abs, 0, 0, isTop, 0, 0, imgName, null);
		a.setContent(content);//���ĺ����¶������
		ArticleDao dao=new ArticleDao();
		
		//ȡ��Session�е�user����
		User user=(User) request.getSession().getAttribute("user");		
		
		dao.save(a,user);
		//�ض����б�ҳ��
		response.sendRedirect(request.getContextPath()+"/ListServlet");
	}



}
