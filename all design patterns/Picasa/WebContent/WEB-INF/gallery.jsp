<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>Image Gallery!</title>
	</head>
	<body>
		<table>
			<tr>
				<td colspan="2">
					<img src="${pageContext.request.contextPath}/image?image_id=${img_id}" height="300px" width="500px"/>
				</td>
			</tr>
			<tr>
				<td align="left">
					<a href="${pageContext.request.contextPath}/gallery?action=prev&c_img_id=${img_id}">Prev</a>
				</td>
				<td align="right">
					<a href="${pageContext.request.contextPath}/gallery?action=next&c_img_id=${img_id}">Next</a>
				</td>
			</tr>
		</table>	
	</body>
</html>










