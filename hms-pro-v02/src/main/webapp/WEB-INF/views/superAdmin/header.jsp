<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css"/>
<title>Insert title here</title>
<script type="text/javascript">
  function manageProfile(option){
	  if(option == "Logout"){
		  alert("Do you wants to Logout Really?");
		  window.location="./logout";
	  }
  }
</script>
</head>
<body>
<nav class="navbar navbar-primary">
  <div class="container-fluid">
    <!-- Brand and toggle get grouped for better mobile display -->
    <div class="navbar-header">
      <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
        <span class="sr-only">Toggle navigation</span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
        <span class="icon-bar"></span>
      </button>
      <a class="navbar-brand" href="#">HmsPro-V02</a>
    </div>

	<div class="page-header">
			<h1>Welcome to Super Admin Board</h1>
		</div>
   <div>
     <security:authorize access="isRememberMe()">
       <h3>Remember-Me Authentication</h3>
     </security:authorize>
     <security:authorize access="isFullyAuthenticated()">
       <h3>Full Authentication</h3>
     </security:authorize>
   </div>
    <!-- Collect the nav links, forms, and other content for toggling -->
    <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
      <ul class="nav navbar-nav navbar-right">
      <image src="" class="glyphicon glyphicon-user">
        <select name="searchOption" class="btn btn-default" onchange="manageProfile(this.value)">
        <option></option>
    <option value="viewUser">View profile</option>
    <option>update profile</option>
    <option value="Logout">Logout</option>
  </select>
  </image>
      </ul>
    </div><!-- /.navbar-collapse -->
  </div><!-- /.container-fluid -->
</nav>
</body>
</html>