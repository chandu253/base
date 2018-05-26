<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Add Product</title>
	</head>
	<body>
		<h2>Add Product</h2>
		<form:form>
			<span style="color: red;">
				<form:errors path="*"/>
			</span>
			<br/>
			Title : <form:input path="title"/><br/>
			Description : <form:input path="description"/><br/>
			Category : <form:input path="category"/><br/>
			Brand : <form:input path="brand"/><br/>
			Price : <form:input path="price"/><br/>
			<input type="submit" value="add"/>
		</form:form>
	</body>
</html>