<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Recharge Orders</title>
	</head>
	<body style="font-family: consolas; font-size: 18px;">
		<h2>Recharge History</h2>
		<table>
			<tr>
				<th>Order No</th>
				<th>Ordered Date</th>
				<th>Mobile Nbr</th>
				<th>Amount</th>
				<th>status</th>
			</tr>
			<c:forEach items="${rechargeOrders}" var="order">
				<tr>
					<td>${order.orderNo}</td>
					<td>${order.orderedDate}</td>
					<td>${order.mobileNumber}</td>
					<td>${order.amount}</td>
					<td>${order.status}</td>
				</tr>
			</c:forEach>
		</table>	
	</body>
</html>













