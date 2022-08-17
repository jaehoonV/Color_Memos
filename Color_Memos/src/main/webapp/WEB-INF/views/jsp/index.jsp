<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Color Memos</title>
<!-- css -->
<link href="<c:url value="/resources/css/index.css"/>" rel="stylesheet">
<!-- jQuery -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- jQuery.validate 플러그인 삽입 -->
<script src="https://cdn.jsdelivr.net/npm/jquery-validation@1.17.0/dist/jquery.validate.min.js"></script>
<!-- js -->
<script src="<c:url value="/resources/js/index.js"/>"></script>
</head>
<body>
	<div id="back">
		<canvas id="canvas" class="canvas-back"></canvas>
		<div class="backRight"></div>
		<div class="backLeft"></div>
	</div>
	<div id="slideBox">
		<div class="topLayer">
			<div class="left">
				<div class="content">
					<h2>Sign Up</h2>
					<form id="joinForm" method="post" action="/join">
						<div class="inputBox">
      						<input type="text" required="required" id="username" name="username">
      						<span>USER NAME</span>
      						<i></i>
   						</div>
   						<div class="inputBox">
      						<input type="email" required="required" id="email" name="email">
      						<span>ID</span>
      						<i></i>
   						</div>
   						<div class="inputBox">
      						<input type="password" required="required" id="password" name="password">
      						<span>Password</span>
      						<i></i>
   						</div>
   						<div class="inputBox">
      						<input type="password" required="required" id="repassword" name="repassword">
      						<span>Re-Password</span>
      						<i></i>
   						</div>
						
						<div class="form-element form-submit">
							<button id="signUp" class="signup" type="submit" name="signup">Sign up</button>
							<button id="goLeft" class="signup off" type="button">Log In</button>
						</div>
					</form>
				</div>
			</div>
			<div class="right">
				<div class="content">
					<h2>Login</h2>
					<form id="loginForm" method="post" action="/login">
						<div class="inputBox">
      						<input type="text" required="required" name="email">
      						<span>ID</span>
      						<i></i>
   						</div>
   						<div class="inputBox">
      						<input type="password" required="required" name="password">
      						<span>Password</span>
      						<i></i>
   						</div>
						
						<div class="form-element form-submit">
							<button id="logIn" class="login" type="submit" name="login">Log In</button>
							<button id="goRight" class="login off" type="button" name="signup">Sign Up</button>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
</body>
</html>