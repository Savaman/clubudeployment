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


					<div class="panel-heading"></div>
					<div class="panel-body text-center media-body"
						style="background-color: white; color: grey;">
						<div class="jumbotron">
							<h1>${message}</h1>
							<p>Either the page you are looking for doesn't exist, or you
								do not have access to it.</p>
							<p>
								<a class="btn btn-primary btn-lg" href="#" role="button">Learn
									more</a>
							</p>
						</div>
					</div>


				</div>
			</div>
		</div>

	</div>

</body>
<%@ include file="jspf/footer.jspf"%>
</html>