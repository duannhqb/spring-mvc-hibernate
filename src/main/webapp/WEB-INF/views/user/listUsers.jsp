<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
			<div class="card-header">
				<div class="row">
					<div class="col-md-6">Danh sách người dùng</div>
					<div class="col-md-6">
						<a href="<c:url value='/user/them-user'/>" class="btn btn-success">Thêm người dùng</a>
					</div>
				</div>
			</div>
			<div class="card-body">
				<table class="table">
					<thead>
						<tr>
							<th scope="col">#</th>
							<th scope="col">Tên đăng nhập</th>
							<th scope="col">Mật khẩu</th>
							<th scope="col"></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${listUsers }" var="user">
							<tr>
								<th scope="row">${user.id }</th>
								<td>${user.username }</td>
								<td>${user.password }</td>
								<td>
									<a href="<c:url value='/user/sua-user/${user.id }'/>" class="btn btn-warning">Sửa</a>
									<a href="<c:url value='/user/info-user/${user.id }'/>" class="btn btn-dark">Chi tiết</a>
									<a href="<c:url value='/user/xoa-user/${user.id }'/>" class="btn btn-danger">Xóa</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
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