<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page isELIgnored="false" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Appointments</title>
		<script type="text/javascript">
			function go(action) {
				document.getElementById("action").value=action;
				document.forms['appointmentForm'].submit();
			}
		</script>
		
		
	</head>
	<body>
		<form name="appointmentForm" action="${pageContext.request.contextPath}/appointments" method="post">
			<input type="hidden" value="${currentPage}" name="currentPage"/>
			<input type="hidden" id="action" name="action"/>
		</form>
		<table>
			<tr>
				<th>Appointment No</th>
				<th>Appointment Date</th>
				<th>Doctor Name</th>
				<th>Patient Name</th>
			</tr>
			<c:forEach items="${appointments}" var="appointment">
				<tr>
					<td>${appointment.appointmentNo}</td>
					<td>${appointment.appointmentDate}</td>
					<td>${appointment.doctorName}</td>
					<td>${appointment.patientName}</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="2" align="left">
					<c:if test="${currentPage gt 1}">
						<input type="button" value="&lt;" onclick="go('prev')"/>
					</c:if>				
				</td>
				<td colspan="2" align="right">
					<c:if test="${currentPage lt totalPages}">
						<input type="button" value="&gt;" onclick="go('next')"/>
					</c:if>
				</td>
			</tr>
		</table>
	</body>
</html>










