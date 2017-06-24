<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<style>
/* CSS 영역  */
	a:link {
		color:orange;
		text=decoration:none;
	}
	a:visited{
		color:orange;
		text=decoration:none;
	}
	a:hover{
		color:red;
		text=decoration:underline;
	}
</style>
<script type="text/javascript">
/* javaScript영역  */
function back(){
	history.back();
}
</script>
</head>
<body>
<%@ include file="menu.jsp" %>
<h1>Error</h1>
<hr>
<%
	String Message = (String)request.getAttribute("errorMessage");
	out.println(Message);
%>
<br>
<a href="javascript:back()">이전 페이지로 이동</a>
</body>
</html>