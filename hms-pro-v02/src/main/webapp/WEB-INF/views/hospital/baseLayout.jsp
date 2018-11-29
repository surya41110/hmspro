<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<table width="100%" border="2" height="100%">
		<tr>
			<td colspan="2" height="25%"><tiles:insertAttribute
					name="header"></tiles:insertAttribute></td>
		</tr>
		<tr height="75%">
			<td><tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</td>
			<td><tiles:insertAttribute name="body"></tiles:insertAttribute>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="25%"><tiles:insertAttribute
					name="footer"></tiles:insertAttribute></td>
		</tr>
	</table>
</body>
</html>