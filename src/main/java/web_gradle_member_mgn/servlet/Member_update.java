package web_gradle_member_mgn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;


@WebServlet("/Member_update")
public class Member_update extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
       

    public Member_update() {
       service = new MemberService();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id =request.getParameter("id");
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		String gender = request.getParameter("gender");
		String email = request.getParameter("email");
		
		Member member = new Member(id, name, age, gender, email);
		System.out.println(service.updateMember(member));
		System.out.println(member);
		
		response.sendRedirect("Member_list");
	
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
