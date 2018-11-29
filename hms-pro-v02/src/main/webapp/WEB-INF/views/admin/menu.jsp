<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
  <a href="${pageContext.request.contextPath}/admin/doctorMgmt"><button type="button" class="btn btn-link">Doctor Management</button></a></br>
  <a href="${pageContext.request.contextPath}/admin/patientMgmt">
  <button type="button" class="btn btn-link">Patient Management</button>
  </a>
  </br>
  <a href="${pageContext.request.contextPath}/admin/nurseMgmt">
  <button type="button" class="btn btn-link">Nurse Management</button>
  </a>
  <br>
  <a href="${pageContext.request.contextPath}/admin/pharmMgmt">
  <button type="button" class="btn btn-link">Pharmacist Management</button>
  </a>
</body>
</html>