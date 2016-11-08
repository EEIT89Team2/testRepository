<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部廠商基本資料</title>

</head>
<body>

		<table border="2">
		<tr>
			<th>廠商編號</th>
			<th>廠商名稱</th>
			<th>統一編號</th>
			<th>電話</th>
			<th>地址</th>
			<th>電子信箱</th>
			<th>名片</th>
			<th>修改人</th>
			<th>修改時間</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		
<c:forEach var="list" items="${list}" varStatus="count">
		<form method="post" action="Company.do">
		<tr>
			<td>${list.com_id}</td>
			<td>${list.com_name}</td>
			<td>${list.com_um}</td>
			<td>${list.com_phone}</td>
			<td>${list.com_addr}</td>
			<td>${list.com_mail}</td>
			<td><img alt="尚無名片" src="data:image/gif;base64,${list.picture}"></td>
			<td>${list.key_id}</td>
			<td>${list.key_date}</td>
			<td><input type="submit" name="action" value="update" ></td>
			<td><input type="submit" name="action" value="delete" ></td>
			<input type="hidden" name="com_id" value="${list.com_id}">
			
		</tr>
		
</form>
<%-- 		${count.index} --%>
</c:forEach>
	</table>
	
	<a href="/pos/Index.jsp">回首頁</a>

</body>
</html>