<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Search Plans</title>
	</head>
	<body style="font-family: consolas;font-size: 18px;">
		<h2>Search Plans</h2>
		<form action="${pageContext.request.contextPath}/dosearchplans.htm" method="post">
			Plan Name : <input type="text" name="planName"/><br/>
			Plan Type: <select name="planType">
						<option value="recharge">Recharge</option>
						<option value="dataplan">Data Plan</option>
						<option value="infinityplan">Infinity Plan</option>
					    </select><br/>
			Validity: <input type="text" name="validity"/><br/>
			Amount : <input type="text" name="amount"/><br/>
			<input type="submit" value="search"/>
		</form>	
	</body>
</html>















