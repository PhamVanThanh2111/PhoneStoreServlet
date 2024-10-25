<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="jakarta.tags.core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
.formContainer {
	margin-top: 20px;
	margin: 0 auto;
}

table {
	border-collapse: collapse;
	width: 100%;
	display: flex;
}

.container {
	display: flex;
	flex-direction: column;
}

.aContainer {
	display: flex;
	flex-direction: row;
	justify-content: space-evenly;
}

tr th, tr td {
	margin: 10px;
}

th {
	text-align: left;
}
</style>
</head>
<body>
	<div align="center" class="container">
		<h1>Add new phone</h1>
		<div class="aContainer">
			<a href="${pageContext.request.contextPath}/service?action=add">Add
				new phone</a> <a href="${pageContext.request.contextPath}">List all
				phone</a>
		</div>
		<div class="formContainer">
			<form
				action="service?action=${dienThoai != null ? 'update' : 'insert'}"
				method="post" enctype="multipart/form-data">
				<table>
					<tr>
						<th><input type="hidden" name="maDienThoai"
							value="${dienThoai.maDienThoai}"></th>
					</tr>
					<tr>
						<th>Tên điện thoại</th>
						<c:if test="${dienThoai != null}">
							<td><input type="text" name="tenDienThoai"
								value="${dienThoai.tenDienThoai}"></td>
						</c:if>
						<c:if test="${dienThoai == null}">
							<td><input type="text" name="tenDienThoai"></td>
						</c:if>
					</tr>
					<tr>
						<th>Năm sản xuất</th>
						<c:if test="${dienThoai != null}">
							<td><input type="text" name="namSanXuat"
								value="${dienThoai.namSanXuat}"></td>
						</c:if>
						<c:if test="${dienThoai == null}">
							<td><input type="text" name="namSanXuat"></td>
						</c:if>
					</tr>
					<tr>
						<th>Cấu hình</th>
						<c:if test="${dienThoai != null}">
							<td><input type="text" name="cauHinh"
								value="${dienThoai.cauHinh}"></td>
						</c:if>
						<c:if test="${dienThoai == null}">
							<td><input type="text" name="cauHinh"></td>
						</c:if>
					</tr>
					<tr>
						<th>Nhà cung cấp</th>
						<td><select name="nhaCungCap">
								<c:if test="${dienThoai == null}">
									<c:forEach var="nhaCungCap" items="${listNhaCungCap}">
										<option value="${nhaCungCap.maNhaCungCap}">${nhaCungCap.tenNhaCungCap}</option>
									</c:forEach>
								</c:if>
								<c:if test="${dienThoai != null}">
									<c:forEach var="nhaCungCap" items="${listNhaCungCap}">
										<c:if
											test="${nhaCungCap.maNhaCungCap == dienThoai.maNhaCungCap}">
											<option value="${nhaCungCap.maNhaCungCap}" selected>${nhaCungCap.tenNhaCungCap}</option>
										</c:if>
										<c:if
											test="${nhaCungCap.maNhaCungCap != dienThoai.maNhaCungCap}">
											<option value="${nhaCungCap.maNhaCungCap}">${nhaCungCap.tenNhaCungCap}</option>
										</c:if>
									</c:forEach>
								</c:if>
						</select></td>
					</tr>
					<tr>
						<th>Hình ảnh</th>
						<td><input type="file" name="hinhAnh"
							accept=".png, .jpg, .jpeg"></td>
					</tr>
					<tr>
						<c:if test="${dienThoai == null}">
							<td colspan="2"><input type="submit" value="Add"></td>
						</c:if>
						<c:if test="${dienThoai != null}">
							<td colspan="2"><input type="submit" value="Update"></td>
						</c:if>
					</tr>
				</table>
			</form>
		</div>
	</div>
</body>
</html>