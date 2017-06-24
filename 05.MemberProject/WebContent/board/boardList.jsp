<%@page import="java.util.List"%>
<%@page import="board.dto.Board"%>
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
<style>
	tbody > tr:hover{
		background-color:darkcyan;
	}
</style>
<body>
<%@ include file="../menu.jsp" %>
<% List<Board> boardList = (List<Board>)request.getAttribute("boardList"); %>
  <div class="container">
	<br><br><br><br><br>
  <h2>게시판 리스트</h2>  
<table class="table">
	<thead>
	<tr>
		<th>번호</th>
		<th>아이디</th>
		<th>제목</th>
		<th>작성일</th>
		<th>조회수</th>
		<th>삭제</th>
	</tr>
	</thead>
	<tbody>
	<tr>
		<% for(int i=0; i<boardList.size(); i++){
			 Board board = boardList.get(i);%> 
			<tr>
				<td><%= board.getNumber() %></td>
				<td><a href="detail.dytc2?num=<%= board.getNumber() %>"><%= board.getId() %></a></td>
				<td><%= board.getSubject() %></td>
				<td><%= board.getWriteDate() %></td>
				<td><%= board.getReadCount() %></td>
				<td><a href="delete.dytc2?num=<%= board.getNumber() %>">삭제</a></td> 
			</tr>
 	<%}%> 
 	</tbody>
 	</div> 
</table>
</div>
</body>
</html>