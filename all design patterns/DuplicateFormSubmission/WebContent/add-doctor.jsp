<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Doctor</title>
	</head>
	<body>
		<h2>Add Doctor</h2>
		<form action="${pageContext.request.contextPath}/add-doctor" method="post">
			Doctor Name: <input type="text" name="doctorName"/><br/>
			Specialization: <input type="text" name="specialization"/><br/>
			Experience: <input type="text" name="experience"/><br/>
			Mobile :<input type="text" name="mobile"/><br/>
			Email :<input type="text" name="email"/>
			<input type="hidden" name="cToken" value="${cToken}"/>
			<input type="submit" value="add"/>
		</form>
	</body>
</html>







