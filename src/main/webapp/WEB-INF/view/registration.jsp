<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Class Connect</title>
<%@ include file="jspf/header.jspf"%>
</head>

<body class="with-top-navbar">

	<%@ include file="jspf/navbar.jspf"%>

	<div class="container p-t-md">
		<div class="row">
			<div class="col-md-12">
				<div class="panel panel-default panel-profile"
					style="background-color: transparent;">

					<div class="panel-heading"
						style="background-color: white; color: teal; padding: 50px;">
						<h1>Registration Form:</h1>
					</div>
					<div class="panel-body text-center media-body"
						style="background-color: teal; color: white;">

						<form:form action="${pageContext.request.contextPath}/register/"
							modelAttribute="user">
							<fieldset>

								<div class="form-group">
									<form:input path="userName" type="text" class="form-control"
										id="userNameInput" placeholder="Enter a username" />
									<!-- Error -->
									<br />
									<form:errors path="userName"
										cssClass="alert alert-dismissible alert-danger" />
									<br />

									<!-- End of Error -->
								</div>
								<!-- First name -->
								<div class="form-group">
									<form:input path="firstName" type="text" class="form-control"
										id="firstNameInput" placeholder="Enter first name" />
									<!-- Error -->
									<br />
									<form:errors path="firstName"
										cssClass="alert alert-dismissible alert-danger" />
									<br />
									<!-- End of Error -->
								</div>
								<!-- Last name -->
								<div class="form-group">
									<form:input path="lastName" type="text" class="form-control"
										id="lastNameInput" placeholder="Enter Last Name" />
									<!-- Error -->
									<br />
									<form:errors path="lastName"
										cssClass="alert alert-dismissible alert-danger" />
									<br />
									<!-- End of Error -->
								</div>
								<!-- Email -->
								<div class="form-group">
									<form:input path="email" type="email" class="form-control"
										id="emailInput" aria-describedby="emailHelp"
										placeholder="Enter school email" />
									<!-- Error -->
									<br />
									<form:errors path="email"
										cssClass="alert alert-dismissible alert-danger" />
									<br />

									<!-- End of Error -->

								</div>
								<!-- Password -->
								<div class="form-group">
									<form:input path="password" type="password"
										class="form-control" id="passwordInput"
										placeholder="Enter Password" />
									<!-- Error -->
									<br />
									<form:errors path="password"
										cssClass="alert alert-dismissible alert-danger" />
									<br />
									<!-- End of Error -->

								</div>
								<div class="form-group">
									<form:input path="confirmPassword" type="password"
										class="form-control" id="confirmPasswordInput"
										placeholder="Enter Password Again" />
									<form:errors path="confirmPassword"
										cssClass="alert alert-dismissible alert-danger" />
								</div>
								<form:hidden path="userRole" value="STUDENT" />
								<button type="submit"
									style="background-color: white; color: teal;"
									class="btn btn-primary">Register</button>
							</fieldset>
						</form:form>

					</div>
					<div class="panel-footer">
						<small>Already have an account? <a
							href="${pageContext.request.contextPath}/login/">Login here.</a></small>
					</div>


				</div>
			</div>
		</div>

	</div>

</body>
<%@ include file="jspf/footer.jspf"%>
</html>
