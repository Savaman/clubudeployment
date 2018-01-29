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
						style="background-color: white; color: teal;">
						<h1>Please Login:</h1>
					</div>
					<div class="panel-body text-center media-body"
						style="background-color: teal; color: white;">
						<form:form
							action="${pageContext.request.contextPath}/authenticateTheUser"
							method="POST">

							<p>
								<input class="form-control" type="text" name="username"
									placeholder="Username" />
							</p>

							<p>
								<input class="form-control" type="password" name="password"
									placeholder="Password" />
							</p>

							<input type="submit"
								style="background-color: white; color: teal;"
								class="btn btn-primary" value="Login" />


						</form:form>
					</div>
					<div class="panel-footer">
						<small>Don't have an account? <a
							href="${pageContext.request.contextPath}/register/">Register
								here.</a></small>
					</div>


				</div>
			</div>
		</div>

	</div>

</body>
<%@ include file="jspf/footer.jspf"%>
</html>

