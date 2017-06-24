<%@page import="member.dto.Member"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%@ include file="menu.jsp" %>
<%
	List<Member> list = (List<Member>)request.getAttribute("list");
%>
<div class="container">
	<br><br><br><br><br>
  <h2>회원리스트</h2>            
  <table class="table">
    <thead>
    <tr>
		<th>아이디</th>
		<th>이름</th>
		<th>나이</th>
		<th>성별</th>
	</tr>
    </thead>
    <% for(int i=0; i<list.size(); i++){ 
			Member member = list.get(i);%> 
    <tbody>
  		<tr>
			<td><a href="detail.dytc?id=<%= member.getId() %>"><%= member.getId() %></a></td>
			<td><%= member.getName() %></td>
			<td><%= member.getAge() %></td>
			<td><%= member.getGender() %></td>
		</tr>
    </tbody>
    <%}%>
  </table>
</div>
</body>
</html>