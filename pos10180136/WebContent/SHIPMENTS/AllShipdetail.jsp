<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�������u�򥻸��</title>

</head>
<body>

		<table border="2">
		<tr>
			<th>�X�f��s�� </th>
			<th>�q��s��</th>
			<th>�X�f���</th>
			<th>����H�a�}</th>
			<th>����H�m�W</th>
			<th>�ק�H</th>
			<th>�ק�ɶ�</th>
			<th>�Ƶ�</th>
			<th>�R��</th>
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
			<td><input type="submit" name="action" value="Delete" ></td>
			<input type="hidden" name="ship_id" value="${list.ship_id}">
			
		</tr>
		
</form>
</c:forEach>
	</table>

<body>

		<table border="2">
		<tr>
			<th>�X�f��s�� </th>
			<th>�ӫ~�s��</th>
			<th>�ӫ~�W��</th>
			<th>�ӫ~�ƶq</th>
			<th>�R������</th>
		</tr>
		
<c:forEach var="list" items="${detailList}" varStatus="count">
		<form method="post" action="Shipments.do">
		<tr>
			<td>${list.shipVO.ship_id}</td>
			<td>${list.prodVO.prod_id}</td>
			<td>${list.prod_name}</td>
			<td>${list.prod_quantity}</td>
			<td><input type="submit" value="Delete" ></td>
			<input type="hidden" name="ship_id" value="${list.shipVO.ship_id}">
			<input type="hidden" name="prod_id" value="${list.prodVO.prod_id}">
			<input type="hidden" name="action" value="DeleteDetail">
			
		</tr>
		
</form>
</c:forEach>
	</table>
		
	<a href="/pos/Index.jsp">�^����</a>

</body>
</html>