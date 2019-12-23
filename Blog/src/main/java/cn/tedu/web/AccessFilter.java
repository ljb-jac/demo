package cn.tedu.web;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cn.tedu.entity.User;

public class AccessFilter implements Filter{

	
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain)throws IOException, ServletException {
		//�����½����ʾ��Ϣ��û�е�½���ض���
		HttpServletRequest request=(HttpServletRequest) req;
		HttpServletResponse response=(HttpServletResponse) res;
		HttpSession session=request.getSession();
		User user=(User) session.getAttribute("user");
		//����û�û�е�½����userֵΪnull
		if(user==null) {
			//�ض��򵽵�¼ҳ��
			System.out.println("�ض��򵽵�¼ҳ��");
			String path=request.getContextPath()+"/ShowLoginServlet";
			response.sendRedirect(path);
		}else {
			//�Ź����󣬽��д�����������
			chain.doFilter(request, response);
			
		}
				
		
	}
	
	
	public void init(FilterConfig filterConfig) throws ServletException {
	}

	
	public void destroy() {
		
	}

}
