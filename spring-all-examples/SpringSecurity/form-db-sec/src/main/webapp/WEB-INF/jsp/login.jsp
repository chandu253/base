<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Olx</title>
	</head>
	<body style="font-family: consolas; font-size: 18px;">
		<h2>Login</h2>
		<form action="${pageContext.request.contextPath}/s_login.htm" method="post">
			Email Address: <input type="text" name="j_username"/><br/>
			Password : <input type="password" name="j_password"/><br/>
			<input type="submit" value="login"/>
		</form>
	</body>
</html>