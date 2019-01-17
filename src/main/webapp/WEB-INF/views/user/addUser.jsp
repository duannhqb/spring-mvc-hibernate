<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<div class="card">
			<div class="card-header">Thêm người dùng</div>
			<div class="card-body">
				<c:url value='/user/them-user' var="url"/>
				<form:form action="${url }" modelAttribute="user" method="post">
					<div class="form-group">
					    <label>Tên người dùng</label>
					    <form:input class="form-control" placeholder="Nhập tên người dùng" path="username"/>
					    <form:errors path="username" cssStyle="color:red"/>
					</div>
					
					<div class="form-group">
					    <label>Mật khẩu</label>
					    <form:input class="form-control" type="password" placeholder="Nhập mật khẩu" path="password"/>
					    <form:errors path="password" cssStyle="color:red"/>
					</div>

					<input type="submit" class="btn btn-primary" value="Thêm người dùng"/>
				</form:form>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>