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
						<h1>WELCOME:</h1>
						<h5>
							Site is unfinished, visit this test wall: <a
								href="${pageContext.request.contextPath}/wall/view?wallName=Cartiae"
								style="color: teal;">Click Here.</a>
						</h5>
					</div>
					<div class="panel-body text-center media-body"
						style="background-color: teal; color: white;">
						<div class="jumbotron"
							style="background-color: teal; color: white;">
							<sec:authorize access="hasAuthority('TEACHER')">

								<h1>Because you are a teacher, you may create a wall for
									each of your courses!</h1>
								<p>
									<a class="btn btn-primary btn-lg" href="#" role="button"
										style="background-color: white; color: teal; border: none;">Create
										Wall</a>
								</p>

							</sec:authorize>
							<sec:authorize access="hasAuthority('STUDENT')">
								<h1>Because you are a student, you must have a teacher add
									you to a wall before you see any below.</h1>
							</sec:authorize>
						</div>
					</div>
					<div class="panel-footer">
						<div class="list-group">

							<h1>Your walls:</h1>
							<a href="/wall/view?wallName=${tempWall.wallName}"
								class="list-group-item"
								style="background-color: white; color: teal;"> <c:if
									test="${empty walls}">
									<h3>You currently are not apart of any walls.</h3>
								</c:if> <forEach items="${walls}" var="tempWall">
								<h4 class="list-group-item-heading">${tempWall.wallName}</h4>
								<h5 class="list-group-item-heading">${tempWall.owner.userName}</h5>
								</forEach>
							</a>
						</div>
					</div>


				</div>
			</div>
		</div>

	</div>

</body>
<%@ include file="jspf/footer.jspf"%>
</html>