package web_gradle_member_mgn.service;

import java.util.List;

import web_gradle_member_mgn.dao.impl.MemberDaoImpl;
import web_gradle_member_mgn.ds.JndiDS;
import web_gradle_member_mgn.dto.Member;

public class MemberService {
	
	private MemberDaoImpl dao;

	
	public MemberService() {		
		dao = MemberDaoImpl.getInstance();
		dao.setCon(JndiDS.getConnection());
		
		
	}
	public Member selectMemberById(Member member) {
		return dao.selectMemberById(member);
	}
	
	public List<Member> showMembers(){
		return dao.selectMemberByAll();
	}
	
	
	public Member loginMember(Member member) {
		return dao.selectMemberById(member);
	}
	public int joinMember(Member member) {
		return dao.insertMember(member);
	}
	public int deleteMember(Member member) {
		return dao.delMember(member);
	}
	public int updateMember(Member member) {
		return dao.updateMember(member);
	}
	
	
}
