<%@ page language="java" contentType="text/html; charset=UTF-8"%>
<%@ page import="java.sql.*"%>
<%@ page import="javax.sql.*" %>
<%@ page import="javax.naming.*" %>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<title>회원관리 시스템 관리자모드(회원 목록 보기)</title>
<link rel="stylesheet" href="css/member_list_style.css">
</head>
<body>


<table border="1">
<h2>회원 목록</h2>
<thead>
<tr>
<td>아이디</td>
<td>이름</td>
<td>나이</td>
<td>성별</td>
<td>이메일</td>
<td>비고</td>
<td>	</td>
</tr>
</thead>
<c:forEach var = "member" items="${list }" >
<tr>
<td>${member.id } </td>
<td>${member.name }</td>
<td>${member.age }</td>
<td>${member.gender }</td>
<td>${member.email }</td>

<td><a href="Member_get?id=${member.id }&name=${member.name}&age=${member.age}&gender=${member.gender}&email=${member.email}">수정 </a></td>
<td><a href="member_delete?id=${member.id }">삭제 </a></td>

</tr>

</c:forEach>

</table>
	<h2><a href="joinForm.jsp">회원추가</a></h2>
	<h2><a href="admin/main.jsp">메인화면으로</a></h2>
</body>
</html>
