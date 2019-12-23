package cn.tedu.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.thymeleaf.context.Context;

import cn.tedu.dao.ArticleDao;
import cn.tedu.dao.LinkDao;
import cn.tedu.dao.TagDao;
import cn.tedu.entity.Article;
import cn.tedu.entity.Link;
import cn.tedu.entity.Tag;
import cn.tedu.entity.User;
import cn.tedu.utils.ThUtils;

public class HomeServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//�ж��Ƿ��¼�� ���û������ʾ��¼ҳ��
		HttpSession session =request.getSession();
		User user=(User) session.getAttribute("user");
		if(user==null) {
			response.sendRedirect(request.getContextPath()+"/ShowLoginServlet");
			return; //������벻ִ��
		}
		
		
		Context context=new Context();
		//����ǰ��¼���û�����ӵ�������
		context.setVariable("userName",user.getUserName());//��index��th�û���
		
		ArticleDao dao=new ArticleDao();

		//��ѯ��ҳ�ö�8ƪ����
		List<Article> list=dao.getHomeList();
		//�ѵ�һƪ���´��ݵ�ҳ������ʾ
		context.setVariable("first", list.get(0));

		//�ѵ�2��3��4ƪ���´��ݵ�ҳ��
		List<Article> second=list.subList(1, 4);
		context.setVariable("second", second);

		//��5-8ƪ����
		context.setVariable("third", list.subList(4, list.size()));

		//��ѯ���������б�
		List<Article> newList=dao.getNewList();
		//�����������б��ݵ�ҳ��
		context.setVariable("newList", newList);

		//��ѯ���������б�
		List<Article> commentList=dao.getCommentList();
		context.setVariable("commentList", commentList);

		//��ѯ�������б�
		List<Article> viewList=dao.getViewList();
		context.setVariable("viewList", viewList);
		
		//��ѯʹ�����ı�ǩ
		TagDao tagDao=new TagDao();
		List<Tag> tags=tagDao.getList();
		//�ѱ�ǩ���ݵ�ҳ����
		context.setVariable("tags", tags);
		
		//ʵ���������Ӳ��裺
		//����Linkʵ��(title,address)
		//����LinkDao �ṩfindAll�������ؼ���
		//�ڵ�ǰλ�ô���dao ����ȡ����
		//�Ѽ��ϴ��ݵ�ҳ���У���ҳ���п�����ʾ
		LinkDao ld=new LinkDao();
		List<Link> links=ld.findAll();
//		System.out.println("������������"+links.size());
		context.setVariable("links",links);
		
		ThUtils.write("index", context, response);


	}



}
