package web_gradle_member_mgn.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;

@WebServlet("/Member_list")
public class Member_list extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service;
       

    public Member_list() {
    	service = new MemberService();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Member> list = service.showMembers();
		list.stream().forEach(System.out::println);
		request.setAttribute("list",list);
		System.out.println("list --> " + list);
		request.getRequestDispatcher("admin/member_list.jsp").forward(request, response);
	

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
