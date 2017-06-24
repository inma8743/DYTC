<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<body>
<%@ include file="menu.jsp" %>
    <!-- Header -->
    <header>
        <div class="container" id="maincontent" tabindex="-1">
            <div class="row">
                <div class="col-lg-12">
                    <img class="img-responsive" src="Resource/img/profile.png" alt="">
                    <div class="intro-text">
                        <h1 class="name">JSP 과제</h1>
                        <hr class="star-light">
                       <%  if(id==null){%>
                    	   <div class="col-lg-8 col-lg-offset-2 text-center">
                           <a href="login.jsp" class="btn btn-lg btn-outline">
                               	로그인
                           </a>
                       </div>
						<%} else{%>
							 <span class="skills"><%=id %>(<%=name %>)님 환영합니다</span>
						<% }%>
                       
                    </div>
                </div>
            </div>
        </div>
    </header>

</body>
    