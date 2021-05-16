package web_gradle_member_mgn.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter("/admin/*")
public class LoginCheckFilter implements Filter {

    public LoginCheckFilter() {
    }

	
	public void destroy() {
	}

	//우리가 적용할거는 http servlertRequest당
	//로그인처리쓰
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		System.out.println("doFilter >>");
		System.out.println("httpRequest.getCotextPath() >" + httpRequest.getContextPath());
		if(session!=null&& session.getAttribute("id") !=null) { //널이아이라는건 로그인했다는뜻
		
			chain.doFilter(request, response);
		}else {
		
//			httpRequest.getRequestDispatcher(httpRequest.getContextPath()+"/loginForm.jsp").forward(request, response);
			//포워딩하지말고 리다이렉션으로
			((HttpServletResponse) response).sendRedirect(httpRequest.getContextPath()+"/loginForm.jsp");
		}
	
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
