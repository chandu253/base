<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Matching Plans</title>
	</head>
	<body style="font-family: consolas;font-size: 18px;">
		<h2>Matching Plans</h2>
		<c:forEach items="${plans}" var="plan">
			${plan.planNo} - ${plan.planName} - ${plan.provider} - ${plan.validity} - ${plan.amount} <br/>
		</c:forEach>	
	</body>
</html>


















