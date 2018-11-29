<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <a href="${pageContext.request.contextPath}/superAdmin/doctorMgmt"><button type="button" class="btn btn-link">Doctor Management</button></a></br>
  <a href="${pageContext.request.contextPath}/superAdmin/patientMgmt">
  <button type="button" class="btn btn-link">Patient Management</button>
  </a>
  </br>
  <button type="button" class="btn btn-link">Nurse Management</button></br>
  <button type="button" class="btn btn-link">Pharmasist Management</button></br>
  <a href="${pageContext.request.contextPath}/superAdmin">
  	<button type="button" class="btn btn-link">Role Management</button>
  	</a></br>
	<a href="${pageContext.request.contextPath}/superAdmin/permMgmt">
  <button type="button" class="btn btn-link">Permission Management</button>
  </a></br>
</body>
</html>