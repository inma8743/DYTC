<%@page import="board.dto.Board"%>
<%@page import="java.util.List"%>
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
 <%@ include file="../menu.jsp" %>
  <br><br><br><br>
  <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                <br>
                    <h2>게시판 상세페이지</h2>
                    <hr class="star-primary">
                </div>
            </div>
  

<% Board board = (Board) request.getAttribute("boardDetail");%>
<ul>
	<li> 작성 날짜 : <%=board.getWriteDate() %>
	<li> 작성자 : <%=board.getId() %>
	<li> 제목 : <%=board.getSubject() %>
	<li> 내용 : <%=board.getContent() %>
	<li> 조회수 : <%=board.getReadCount() %>, 파일 이름 <a href="upload/<%= board.getFileName()%>" download><%=board.getFileName() %></a>
</ul>
</div>
</body>
</html>