<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-default">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header"> 
     <a class="navbar-brand" href="#">Nurses List</a>
    </div>
</div>

  <form class="navbar-form navbar-left" role="search" action="${pageContext.request.contextPath}/admin/nurseMgmt/searchNurse">
  <div class="form-group">
    <input name="searchValue" type="text" class="form-control" placeholder="Search">
  </div>
  <select name="searchOption" class="btn btn-default">
    <option value="Name">Name</option>
    <option value="Email">Email</option>
  </select>
  <button type="submit" class="btn btn-default">Submit</button>
  
</form>
  <a href="${pageContext.request.contextPath}/admin/nurseMgmt/addNurseDefn" class="btn btn-default">Add Nurse</a>
 
</nav>
</body>
</html>