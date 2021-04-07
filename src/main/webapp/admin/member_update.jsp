<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

</head>
<body>
<form action="Member_update" method="get">
<fieldset>
<legend>회원 정보 수정</legend>
<ul>
<li>
<label for = "id"> 아이디</label>
<input type="text" name="id" size="20" id="id" value="${param.id}"  readonly>
</li>

<li>
<label for = "name"> 이름</label>
<input type="text" name="name" size="20" id="name" value="${param.name}" >
</li>
<li>
<label for = "age"> 나이</label>
<input type="number" name="age" size="20" id="age" value="${param.age}" >
</li>
<li>
<label for = "gender"> 성별</label>
<input type="text" name="gender" size="20" id="gender"value="${param.gender}" >
</li>
<li>
<label for = "email">  이메일</label>
<input type="text" name="email" size="20" id="email" value="${param.email}">
</li>

<li>
	<input type="submit" value="저장"/>
</li>
<li>
<input type = "reset" value = "취소">
</li>
</ul>
</fieldset>
</form>
</body>
</html>