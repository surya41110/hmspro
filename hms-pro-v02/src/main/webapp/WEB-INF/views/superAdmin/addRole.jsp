<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
<jsp:include page="./roleBodyHeader.jsp"></jsp:include>
</head>
<body>
	<section class="container"> <form:form method="post"
		action="./addRole" modelAttribute="roleBean" class="form-horizontal">
		<fieldset>
			<legend>Add new Role</legend>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name">Role</label>
				<div class="col-lg-10">
					<form:input id="role" path="role" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<!-- <label class="control-label col-lg-2 col-lg-2" for="name">Role</label> -->
				<div class="col-lg-10">
				<form:checkboxes items="${permListBox}" path="permissions"/>
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn
btn-primary"
						value="Add Role" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>