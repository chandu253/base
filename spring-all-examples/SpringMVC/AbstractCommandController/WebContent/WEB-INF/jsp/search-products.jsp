<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Products</title>
	</head>
	<body>
		<h2>Product Search</h2>
		<form action="${pageContext.request.contextPath}/do-product-search.htm" method="post">
			Product : <input type="text" name="product"/> <br/>
			Category : <input type="text" name="category"/> <br/>
			Brand : <input type="text" name="brand"/> <br/>
			Price Range : <input type="text" name="minPrice"/> - <input type="text" name="maxPrice"/><br/>
			<input type="submit" value="search"/>
		</form>
	</body>
</html>