package web_gradle_member_mgn.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import web_gradle_member_mgn.dto.Member;
import web_gradle_member_mgn.service.MemberService;


@WebServlet("/joinProcess")
public class JoinProcess extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberService service = new MemberService();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	String id = request.getParameter("id");
	String pass = request.getParameter("pass");
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age").trim());
	String gender =request.getParameter("gender");
	String email=request.getParameter("email");
	System.out.printf("id : %s, pass : %s, name : %s, age : %d, gender : %s, email : %s",id,pass,name,age,gender,email);
		//Member joinMember = getMember();
	Member member = new Member(id, pass, name, age, gender, email);//1
	int res = service.joinMember(member);//2
	System.out.println("res :  " + res);
	if(res == 1) {  //res가 1이뜨면
		request.getRequestDispatcher("loginForm.jsp").forward(request, response);	
	}else {
		request.getRequestDispatcher("joinForm.jsp").forward(request, response);
	}
	
		
	
	}



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
