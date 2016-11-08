<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>全部員工基本資料</title>

</head>
<body>

		<table border="2">
		<tr>
			<th>出貨單編號 </th>
			<th>訂單編號</th>
			<th>出貨日期</th>
			<th>收件人地址</th>
			<th>收件人姓名</th>
			<th>修改人</th>
			<th>修改時間</th>
			<th>備註</th>
			<th>明細</th>
			<th>刪除</th>
		</tr>
		
<c:forEach var="list" items="${list}" varStatus="count">
		<form method="post" action="Shipments.do">
		<tr>
			<td>${list.ship_id}</td>
			<td>${list.ord_id}</td>
			<td>${list.ship_date}</td>
			<td>${list.rec_addr}</td>
			<td>${list.rec_name}</td>
			<td>${list.key_id}</td>
			<td>${list.key_date}</td>
			<td>${list.remark}</td>
			<td><input type="submit" name="action" value="Detail" ></td>
			<td><input type="submit" name="action" value="Delete" ></td>
			<input type="hidden" name="ship_id" value="${list.ship_id}">
			
		</tr>
		
</form>
</c:forEach>
	</table>
	
	<a href="/pos/Index.jsp">回首頁</a>

</body>
</html>