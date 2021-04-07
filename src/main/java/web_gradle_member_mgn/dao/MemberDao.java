package web_gradle_member_mgn.dao;

import java.util.List;

import web_gradle_member_mgn.dto.Member;

public interface MemberDao {
	
	List<Member> selectMemberByAll();
	
	Member selectMemberById(Member member);
	int insertMember(Member member);
	int delMember(Member member);
	int updateMember(Member member);
	

	
	
}
