package web_gradle_member_mgn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;


@WebServlet("/Member_get")
public class Member_get extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
	
       
  
    public Member_get() {
    	service = new MemberService();
    	
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id = request.getParameter("id");
		Member member = service.selectMemberById(new Member(id));
		System.out.println(member);
		request.setAttribute("member",member);
		request.getRequestDispatcher("admin/member_update.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
