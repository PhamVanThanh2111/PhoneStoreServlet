<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>Quản lý điện thoại</h1>
		<h2>
			<a href="${pageContext.request.contextPath}/service?action=add">Add</a>
			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
				href="${pageContext.request.contextPath}">List all phone</a>
		</h2>
		<table border="1">
			<tr>
				<th>STT</th>
				<th>Tên điện thoại</th>
				<th>Năm sản xuất</th>
				<th>Cấu hình</th>
				<th>Nhà cung cấp</th>
				<th>Hình ảnh</th>
				<th>Chức năng</th>
			</tr>
			<c:forEach var="dienThoai" items="${listDienThoai}"
				varStatus="status">
				<tr>
					<td><c:out value="${status.index + 1}" /></td>
					<td><c:out value="${dienThoai.tenDienThoai}" /></td>
					<td><c:out value="${dienThoai.namSanXuat}" /></td>
					<td><c:out value="${dienThoai.cauHinh}" /></td>
					<td><c:out value="${dienThoai.maNhaCungCap}" /></td>
					<td><img
						src="${pageContext.request.contextPath}/view/imgs/${dienThoai.hinhAnh}"
						alt="hinhAnh" width="100px"></td>
					<td><a
						href="${pageContext.request.contextPath}/service?action=edit&id=${dienThoai.maDienThoai}">Edit</a>
						&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; <a
						href="${pageContext.request.contextPath}/service?action=delete&id=${dienThoai.maDienThoai}"
						onclick="return confirmDelete();" >Delete</a> 
						<script
							type="text/javascript">
							function confirmDelete() {
								return confirm("Bạn có thực sự muốn xóa không?");
							}
						</script>
						</td>

				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>