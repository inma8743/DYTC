<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<head>

    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Index</title>

    <!-- Bootstrap Core CSS -->
    <link href="<%=request.getContextPath() %>/Resource/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">

    <!-- Theme CSS -->
    <link href="<%=request.getContextPath() %>/Resource/css/freelancer.min.css" rel="stylesheet">

    <!-- Custom Fonts -->
    <link href="<%=request.getContextPath() %>/Resource/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,700" rel="stylesheet" type="text/css">
    <link href="https://fonts.googleapis.com/css?family=Lato:400,700,400italic,700italic" rel="stylesheet" type="text/css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body id="page-top" class="index">
<% 
	String id = (String) session.getAttribute("id");
	String name = (String) session.getAttribute("name");
	%>
<div id="skipnav"><a href="#maincontent">Skip to main content</a></div>

    <!-- Navigation -->
    <nav id="mainNav" class="navbar navbar-default navbar-fixed-top navbar-custom">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header page-scroll">
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span> Menu <i class="fa fa-bars"></i>
                </button>
                <a class="navbar-brand" href="<%=request.getContextPath() %>/index.jsp">동양미래대학교</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav navbar-right">
                    <li class="hidden">
                        <a href="#page-top"></a>
                    </li>
                    <% if(id==null){%>
                    <li class="page-scroll">
                        <a href="<%=request.getContextPath() %>/login.jsp">로그인</a>
                    </li>
                    <%}else{%>
                    	 <li class="page-scroll">
                        <a href="<%=request.getContextPath() %>/logout.dytc">로그아웃</a>
                    </li>
                    <%} %>
                    
                    <li class="page-scroll">
                        <a href="<%=request.getContextPath() %>/register.jsp">회원가입</a>
                    </li>
                    <li class="page-scroll">
                        <a href="<%=request.getContextPath() %>/list.dytc">회원리스트</a>
                    </li>
                    <li class="page-scroll">
                        <a href="<%=request.getContextPath() %>/board/write.jsp">게시판 글쓰기</a>
                    </li>
                    <li class="page-scroll">
                        <a href="<%=request.getContextPath() %>/list.dytc2">게시판 리스트</a>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
        
     <!-- jQuery -->
    <script src="<%=request.getContextPath() %>/Resource/vendor/jquery/jquery.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="<%=request.getContextPath() %>/Resource/vendor/bootstrap/js/bootstrap.min.js"></script>

    <!-- Plugin JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery-easing/1.3/jquery.easing.min.js"></script>

    <!-- Contact Form JavaScript -->
    <script src="<%=request.getContextPath() %>/Resource/js/jqBootstrapValidation.js"></script>
    <script src="<%=request.getContextPath() %>/Resource/js/contact_me.js"></script>

    <!-- Theme JavaScript -->
    <script src="<%=request.getContextPath() %>/Resource/js/freelancer.min.js"></script>
    </body>