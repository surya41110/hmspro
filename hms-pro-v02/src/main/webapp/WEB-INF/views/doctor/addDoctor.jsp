<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet"
	href="http://netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Products</title>
<jsp:include page="./doctBodyHeader.jsp"></jsp:include>
</head>
<body>
	<section class="container"> <form:form method="post"
		action="./addDoctor" modelAttribute="doctBean" class="form-horizontal">
		<fieldset>
			<legend>Add new Doctor</legend>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name">First
					Name</label>
				<div class="col-lg-10">
					<form:input id="firstName" path="fname" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name">Last
					Name</label>
				<div class="col-lg-10">
					<form:input id="LastName" path="lname" type="text"
						class="form:input-large" />
				</div>
			</div>
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Email</label>
				<div class="col-lg-10">
					<form:input id="email" path="email" type="text"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name">Password</label>
				<div class="col-lg-10">
					<form:input id="password" path="password" type="password"
						class="form:input-large" />
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="name">Confirm
					Password</label>
				<div class="col-lg-10">
					<form:input id="ConfirmPassword" path="cpassword" type="password"
						class="form:input-large" />
				</div>
			</div>


			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Mobile</label>
				<div class="col-lg-10">
					<form:input id="phone" path="mobile" type="text"
						class="form:input-large" />
				</div>
			</div>
			
			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="manufacturer">Role</label>
				<div class="col-lg-10">
					<form:select path="role">
					  <form:option value="Doctor"></form:option>
					</form:select>
				</div>
			</div>

			<div class="form-group">
				<label class="control-label col-lg-2 col-lg-2" for="unitPrice">Status</label>
				<div class="col-lg-10">
					Active
					<form:radiobutton path="status" value="true" />
					InActive
					<form:radiobutton path="status" value="false" />
				</div>
			</div>
			<div class="form-group">
				<div class="col-lg-offset-2 col-lg-10">
					<input type="submit" id="btnAdd" class="btn
btn-primary"
						value="AddDoctor" />
				</div>
			</div>
		</fieldset>
	</form:form> </section>
</body>
</html>