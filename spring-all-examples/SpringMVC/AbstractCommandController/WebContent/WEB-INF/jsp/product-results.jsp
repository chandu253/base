<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Products</title>
	</head>
	<body>
		<h2>Products</h2>
		<table>
			<tr>
				<th>Product No</th>
				<th>Title</th>
				<th>Description</th>
			</tr>
			<c:forEach items="${products}" var="product">
				<tr>
					<td>${product.productNo}</td>
					<td>${product.title}</td>
					<td>${product.description}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>















