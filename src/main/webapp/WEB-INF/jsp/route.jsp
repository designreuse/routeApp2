<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="/WEB-INF/jsp/includes.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Route Management</title>
</head>
<body>
<h1>Routes Data</h1>
<form:form action="route.do" method="POST" commandName="route">
	<table>
		<tr>
			<td>Route ID</td>
			<td><form:input path="id" /></td>
		</tr>
		<tr>
			<td>Name</td>
			<td><form:input path="name" /></td>
		</tr>
		<tr>
			<td>Vehicle ID</td>
			<td><form:input path="vehicleId" /></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" />
				<input type="submit" name="action" value="Edit" />
				<input type="submit" name="action" value="Delete" />
				<input type="submit" name="action" value="Search" />
			</td>
		</tr>
	</table>
</form:form>
<br>
<table border="1">
	<th>ID</th>
	<th>Name</th>
	<th>Vehicle</th>
	<c:forEach items="${routes}" var="route">
		<tr>
			<td>${route.id}</td>
			<td>${route.name}</td>
			<td>${route.vehicleId}</td>
		</tr>
	</c:forEach>
</table>
</body>
</html>