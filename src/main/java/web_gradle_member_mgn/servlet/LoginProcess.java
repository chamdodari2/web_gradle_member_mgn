package web_gradle_member_mgn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;


@WebServlet("/loginProcess")
public class LoginProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private MemberService service = new MemberService();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//	response.getWriter().append("Served at: ").append(request.getContextPath());
	//id=1&pass=1111
	
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		System.out.printf("id : %s,pass : %s",id,pass);
		
		Member loginMember = new Member(id,pass);
		Member result = service.loginMember(loginMember);
		System.out.printf("loginMember : %s %n result : %s",loginMember,result);
		
		if(result!=null) {//계정과 패스워드가 일치하면
			HttpSession session = request.getSession();
			session.setAttribute("id", result.getId());
//			request.getRequestDispatcher("admin/main.jsp").forward(request, response);
			response.sendRedirect("admin/main.jsp");
		}else { //만약 널이면,
			request.getRequestDispatcher("loginForm.jsp").forward(request, response);
			
		}
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
