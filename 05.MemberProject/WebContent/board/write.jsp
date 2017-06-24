<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<body>
<%@ include file="../menu.jsp" %>
<h1>게시판 글쓰기</h1>
<%

if(id==null){
	response.sendRedirect(request.getContextPath()+"/login.jsp");
}
else{%>
<form action="../write.dytc2" method="post" enctype="multipart/form-data">
	<br><br>
	<fieldset>
		<ul>
			<li> 아이디 : <input type="hidden" name="id" value="<%=id%>"><%=id%>
			<li> 제목 : <input type="text" name="title">
			<li> 내용 : <textarea rows="10" cols="60" name="content" ></textarea >
			<li> 파일 : <input type="file" name ="fileName" value="file">
		</ul>
		<input type = "submit" value="글쓰기">
	</fieldset>
</form>
	<% }%>


</body>
</html>