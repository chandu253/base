<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Book Ticket</title>
	</head>
	<body>
		<h2>Book Ticket</h2>
		<form action="${pageContext.request.contextPath}/bookticket.action" method="post">
			Source : <input type="text" name="source"/><br/>
			Destination : <input type="text" name="destination"/><br/>
			Journey Date : <input type="text" name="journeyDate"/><br/>
			Passengers : <input type="text" name="passengers"/><br/>
			<input type="submit" value="book"/>
		</form>
	</body>
</html>