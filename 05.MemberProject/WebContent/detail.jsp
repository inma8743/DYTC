<%@page import="member.dto.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
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
<% Member member = (Member)request.getAttribute("detail"); %>
<h1>상세페이지</h1><hr>
  <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                <br>
                    <h2>멤버 상세페이지</h2>
                    <hr class="star-primary">
                </div>
            </div>
  
<table class="table">
	<thead>
	</thead> 
		<tbody>
			<tr><th>아이디</th><td><%= member.getId() %></td></tr>
			<tr><th>이름</th><td><%= member.getName() %></td></tr>
			<tr><th>나이</th><td><%= member.getAge() %></td></tr>
			<tr><th>주소</th><td><%= member.getAddr() %></td></tr>
			<tr><th>성별</th><td><%= member.getGender() %></td></tr>
			<tr><th>가입날짜</th><td><%= member.getRegDate() %></td></tr>
		</tbody>
</table>
</div>
</body>
</html>