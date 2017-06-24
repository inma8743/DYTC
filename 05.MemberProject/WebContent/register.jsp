<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%@ include file="menu.jsp" %>
    <section id="Register">
        <div class="container">
            <div class="row">
                <div class="col-lg-12 text-center">
                <br>
                    <h2>회원 가입</h2>
                    <hr class="star-primary">
                </div>
            </div>
            <div class="row">
                <div class="col-lg-8 col-lg-offset-2">
                    <!-- To configure the contact form email address, go to mail/contact_me.php and update the email address in the PHP file on line 19. -->
                    <!-- The form should work on most web servers, but if the form is not working you may need to configure your web server differently. -->
                    <form action="register.dytc">
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="id">id</label>
                                <input type="text" name="id" class="form-control" placeholder="Id" id="id" required data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="password">password</label>
                                <input type="password" name="pw" class="form-control" placeholder="Password" id="password" required data-validation-required-message="Please enter your password.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="Name">Name</label>
                                <input type="text"name="name" class="form-control" placeholder="Name" id="name" required data-validation-required-message="Please enter your name.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="Age">Age</label>
                                <input type="number"name="age" class="form-control" placeholder="Age" id="age" required data-validation-required-message="Please enter your age.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                       <div class="row control-group">
                       	<div class="form-group col-xs-12 floating-label-form-group controls">
						    <h2 class="form-control" >Gender</h2>
						      <input type="radio" name="gender" value="남자">남자
						      <input type="radio" name="gender" value="여자">여자
						   
						    <p class="help-block text-danger"></p>
						    </div>
						</div>
                         <div class="row control-group">
                            <div class="form-group col-xs-12 floating-label-form-group controls">
                                <label for="Address">Address</label>
                                <input type="text" name="addr"class="form-control" placeholder="Addr" id="addr" required data-validation-required-message="Please enter your address.">
                                <p class="help-block text-danger"></p>
                            </div>
                        </div>
                        <br>
                        <div id="success"></div>
                        <div class="row">
                            <div class="form-group col-xs-12">
                                <button type="submit" class="btn btn-success btn-lg">Send</button>
                            </div>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </section>
</body>
</html>