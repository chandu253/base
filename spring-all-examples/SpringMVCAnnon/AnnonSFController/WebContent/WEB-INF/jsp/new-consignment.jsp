<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>New Consignment</title>
	</head>
	<body style="font-family: consolas; font-size: 18px;">
		<h2>New Consignment</h2>
		<form:form modelAttribute="consignmentForm">
			<table>
				<tr>
					<td colspan="2" style="color: red;">
						<form:errors path="*"/>
					</td>
				</tr>
				<!-- From and To -->
				<tr>
					<td>
						<b>From</b>
						<table style="border-style: dotted;">
							<tr>
								<td>Source :</td>
								<td><form:input path="source"/></td>
							</tr>
							<tr>
								<td>Contact Name :</td>
								<td><form:input path="fromContactName"/></td>
							</tr>
							<tr>
								<td>Apartment/Flat :</td>
								<td><form:input path="fromAddressLine1"/></td>
							</tr>
							<tr>
								<td>Street Address: </td>
								<td><form:input path="fromAddressLine2"/></td>
							</tr>
							<tr>
								<td>City :</td>
								<td><form:input path="fromCity"/></td>
							</tr>
							<tr>
								<td>State :</td>
								<td><form:input path="fromState"/></td>
							</tr>
							<tr>
								<td>Zip :</td>
								<td><form:input path="fromZip"/></td>
							</tr>
							<tr>
								<td>Country :</td>
								<td><form:input path="fromCountry"/></td>
							</tr>
							<tr>
								<td>Mobile :</td>
								<td><form:input path="fromMobile"/></td>
							</tr>
						</table>
					</td>
					<td>
						<b>To</b>
						<table style="border-style: dotted;">
							<tr>
								<td>Destination :</td>
								<td><form:input path="destination"/></td>
							</tr>
							<tr>
								<td>Contact Name :</td>
								<td><form:input path="toContactName"/></td>
							</tr>
							<tr>
								<td>Apartment/Flat :</td>
								<td><form:input path="toAddressLine1"/></td>
							</tr>
							<tr>
								<td>Street Address: </td>
								<td><form:input path="toAddressLine2"/></td>
							</tr>
							<tr>
								<td>City :</td>
								<td><form:input path="toCity"/></td>
							</tr>
							<tr>
								<td>State :</td>
								<td><form:input path="toState"/></td>
							</tr>
							<tr>
								<td>Zip :</td>
								<td><form:input path="toZip"/></td>
							</tr>
							<tr>
								<td>Country :</td>
								<td><form:input path="toCountry"/></td>
							</tr>
							<tr>
								<td>Mobile :</td>
								<td><form:input path="toMobile"/></td>
							</tr>
						</table>
					</td>
				</tr>
				<!-- Consignment Data -->
				<tr>
					<td colspan="2">
						<b>Information</b>
						<table style="border-style: dotted;">
							<tr>
								<td>
									Description:
								</td>
								<td>
									<form:input path="description"/>
								</td>
								<td>
									Shipment Type:
								</td>
								<td>
									<form:select path="shipmentType">
										<form:option value="speed">Speed</form:option>
										<form:option value="regular">Regular</form:option>
									</form:select>
								</td>
							</tr>
							<tr>
								<td>Weight:</td>
								<td>
									<form:input path="weight"/>
								</td>
								<td>Amount:</td>
								<td>
									<form:input path="amount"/>
								</td>
							</tr>
							
						</table>
					</td>
				</tr>
				<tr align="right">
					<td colspan="2">
						<input type="submit" value="book"/>
					</td>
				</tr>
			</table>
		</form:form>
	</body>
</html>

















