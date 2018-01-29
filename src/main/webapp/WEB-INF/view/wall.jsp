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
					<div class="panel-heading" style="background-color: teal;"></div>
					<div class="panel-body text-center media-body"
						style="background-color: white; color: #536570;">
						<h5 class="panel-title">${wall.wallName}</h5>
						<small class="m-b-md">${wall.wallDescription}</small>
					</div>
				</div>
			</div>
		</div>
		<div class="row">
			<div class="col-md-9">
				<ul class="list-group media-list media-list-stream">

					<!-- Only wall teachers can make posts in this release -->
					<sec:authorize access="hasAuthority('TEACHER')">
						<li class="media list-group-item p-a">
							<form action="addPost" method="post">
								<input type="hidden" name="idWall" value="${wall.id}" />
								<div class="input-group">
									<input type="text" name="post" class="form-control"
										placeholder="Message">
									<div class="input-group-btn">
										<button type="submit" class="btn btn-default"
											style="height: 35px; margin-left: 5px; border-color: teal;">
											<span class="icon icon-chat"></span>
										</button>
									</div>
								</div>
							</form>
						</li>
					</sec:authorize>
					<!-- End of post textbox -->



					<!-- Posts by the instructor starts -->
					<c:forEach items="${posts}" var="tempPost">
						<li class="media list-group-item p-a"><a
							class="media-left media-top" href="#"> <img
								class="media-object" style="margin-top: 30px;"
								src="${pageContext.request.contextPath}/resources/img/profilePic/${tempPost.poster.profilePic}">
						</a>
							<div class="media-body">
								<div class="media-heading">
									<h2>${tempPost.title}:</h2>
									<h5>
										${tempPost.poster.firstName} ${tempPost.poster.lastName} <small
											class="pull-right text-muted">${tempPost.createdAt}</small>
									</h5>
									<hr />
								</div>

								<p>${tempPost.post}</p>

								<!--  Comments for post start -->
								<ul class="media-list m-b">
									<c:forEach var="tempComment" items="${tempPost.comments}">
										<li class="media"><a class="media-left" href="#"> <img
												class="media-object img-circle"
												src="${pageContext.request.contextPath}/resources/img/profilePic/${tempComment.commenter.profilePic}">
										</a>
											<div class="media-body">
												<strong>${tempComment.commenter.firstName}
													${tempComment.commenter.lastName}: </strong> ${tempComment.comment}
											</div></li>
									</c:forEach>
								</ul>
								<!-- End of comments -->
							</div> <c:if test="${wall.allowComments == 1}">
								<li class="media list-group-item p-a">

									<form action="comment/addComment" method="post">
										<input type="hidden" name="idPost" value="${tempPost.id}" />
										<div class="input-group">
											<input type="text" name="comment" class="form-control"
												placeholder="Message">
											<div class="input-group-btn">
												<button type="submit" class="btn btn-default"
													style="height: 35px; margin-left: 5px; border-color: teal;">
													<span class="icon icon-chat"></span>
												</button>
											</div>
										</div>
									</form>

								</li>
							</c:if></li>
					</c:forEach>

					<!-- End of Instructor Posts -->
				</ul>
			</div>


			<div class="col-md-3">
				<sec:authorize access="hasAuthority('TEACHER')">
					<div class="panel panel-default m-b-md hidden-xs">
						<div class="panel-body">
							<div class="list-group">

								<a href="#" class="list-group-item">
									<h4 class="list-group-item-heading">Add A Member</h4>
								</a>

							</div>
						</div>
					</div>
				</sec:authorize>

				<div class="panel panel-default m-b-md hidden-xs">
					<!-- Show the members of the wall -->
					<div class="panel-body">
						<h4 class="m-t-0">Members</h4>
						<small><a style="color: white;" href="#">INSTRUCTOR</a></small>
						<ul class="media-list media-list-stream">
							<li class="media m-b"><a class="media-left" href="#"> <img
									class="media-object img-circle"
									src="${pageContext.request.contextPath}/resources/img/profilePic/${wall.owner.profilePic}">
							</a>
								<div class="media-body">
									<strong>${wall.owner.firstName} ${wall.owner.lastName }</strong>
									@${wall.owner.userName}
								</div></li>
						</ul>
					</div>
					<!-- If show members is active then the members of the wall will show below -->
					<c:if test="${wall.showMembers == 1}">
						<div class="panel-footer">
							<ul class="media-list media-list-stream">
								<!-- ForEach loop for showing all members of wall -->
								<c:forEach var="tempMember" items="${wall.members}">
									<li class="media m-b"><a class="media-left" href="#">
											<img class="media-object img-circle"
											src="${pageContext.request.contextPath}/resources/img/profilePic/${tempMember.user.profilePic}">
									</a>
										<div class="media-body">
											<strong>${tempMember.user.firstName}
												${tempMember.user.lastName }</strong> @${tempMember.user.userName}
										</div></li>
								</c:forEach>
							</ul>
						</div>
					</c:if>
				</div>

				<c:if test="${wall.showRecentPosts == 1}">

					<div class="panel panel-default m-b-md hidden-xs">
						<div class="panel-body">
							<div class="list-group">
								<c:forEach items="${recentPosts}" var="recentPost">
									<a href="#" class="list-group-item">
										<h4 class="list-group-item-heading">${recentPost.title}</h4>
										<p class="list-group-item-text">${recentPost.post}</p>
									</a>
								</c:forEach>
							</div>
						</div>
					</div>

				</c:if>


				<div class="panel panel-default panel-link-list">
					<div class="panel-body">
						Copyright - All rights reserved by <a href="www.cartiae.com"
							style="color: white;">@cartiae</a>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<%@ include file="jspf/footer.jspf"%>
</html>