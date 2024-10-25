<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core"%>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Document</title>
<style>
.table-container {
	margin: 0 auto;
	width: 85%;
	text-align: center;
}

table {
	width: 100%;
	border-collapse: collapse;
}

td {
	border: 1px solid black;
	padding: 10px;
}

img {
	width: 100%;
}

a {
	text-decoration: none;
	color: blue;
	padding: 10px;
}

a:hover {
	background-color: lightgray;
}

.content-container {
	height: 470px;
}

.student-info {
	color: blue;
}
</style>
</head>

<body>
	<div class="table-container">
		<table>
			<tr>
				<td><img
					src="${pageContext.request.contextPath}/view/imgs/logo.png"
					alt="logo"></td>
			</tr>
			<tr>
				<td><a href="#">Danh sách sản phẩm</a> <a
					href="${pageContext.request.contextPath}/service?action=add">Thêm
						mới sản phẩm</a> <a
					href="${pageContext.request.contextPath}/service?action=quanLy">Chức
						năng quản lý</a></td>
			</tr>
			<tr class="content-container">
				<td>
					<table>
						<tr>
							<th>Mã điện thoại</th>
							<th>Tên điện thoại</th>
							<th>Năm sản xuất</th>
							<th>Cấu hình</th>
							<th>Mã nhà cung cấp</th>
							<th>Ảnh</th>
						</tr>
						<c:forEach var="dienThoai" items="${listDienThoai}">
							<tr>
								<td><c:out value="${dienThoai.maDienThoai}" /></td>
								<td><c:out value="${dienThoai.tenDienThoai}" /></td>
								<td><c:out value="${dienThoai.namSanXuat}" /></td>
								<td><c:out value="${dienThoai.cauHinh}" /></td>
								<td><c:out value="${dienThoai.maNhaCungCap}" /></td>
								<td><img style="height: 250px; width: 250px;"
									src="${pageContext.request.contextPath}/view/imgs/${dienThoai.hinhAnh}" /></td>
							</tr>
						</c:forEach>
					</table>
				</td>
			</tr>
			<tr>
				<td class="student-info">Phạm Văn Thành - 21089891 -
					DHKTPM17BTT</td>
			</tr>
		</table>
	</div>
</body>

</html>