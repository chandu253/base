<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Activate Sim</title>
	</head>
	<body style="font-family: consolas; font-size: 18px;">
		<form action="${pageContext.request.contextPath}/activate.htm" method="post">
			Sim: <input type="text" name="simNo"/><br/>
			<input type="submit" value="activate"/>
		</form>
	</body>
</html>