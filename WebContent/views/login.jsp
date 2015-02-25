<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
      <%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">	
	<link rel="stylesheet" type="text/css" href="<%=request.getContextPath()%>/css/login.css">
</head>

<body>
	<div class="container">
		<div class="login">
			<div class="login-screen">
				<div class="login-form">
					<s:form name="login" action="/tss/login" method="post">
						<input type="text" name="username" class="login-field" value="" placeholder="Enter your name" id="login-name">
						<p>
						<p>
						<input type="password" name="password" class="login-field" value="" placeholder="Password" id="login-pass">
						<p>
						<p>
							<input class ="btn btn-primary btn-lg btn-block" name="log" type=submit value="Login">
						<a class="login-link" href="error.jsp">Don't have an account?</a>
					</s:form>
				</div>
			</div>
		</div>
	</div>
	
</body>

</html>