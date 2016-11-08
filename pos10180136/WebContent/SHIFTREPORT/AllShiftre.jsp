<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>全部班別報表</title>

</head>
<body>

		<table border="2">
		<tr>
			<th>日期</th>
			<th>班別</th>
			<th>員工編號</th>
			<th>現金</th>
			<th>禮卷</th>
			<th>折讓</th>
			<th>零用金</th>
			<th>交易額</th>
			<th>交易成本</th>
			<th>交易淨利</th>
			<th>交易次數</th>
			<th>班別小計</th>
			<th>修改</th>
			<th>刪除</th>
		</tr>
		
<c:forEach var="list" items="${list}" varStatus="count">
		<form method="post" action="Shiftre.do">
		<tr>
			<td>${list.date}</td>
			<td>${list.shift}</td>
			<td>${list.emp_id}</td>
			<td>${list.cash}</td>
			<td>${list.coupon}</td>
			<td>${list.discount}</td>
			<td>${list.coins}</td>
			<td>${list.deal_sum}</td>
			<td>${list.deal_cost}</td>
			<td>${list.deal_profit}</td>
			<td>${list.deal_num}</td>
			<td>${list.shift_sum}</td>
			<td><input type="submit" name="action" value="update" ></td>
			<td><input type="submit" name="action" value="delete" ></td>
			<input type="hidden" name="Date" value="${list.date}">
			<input type="hidden" name="shift" value="${list.shift}">
			
		</tr>
		
</form>
<%-- 		${count.index} --%>
</c:forEach>
	</table>
	
	<a href="/pos/Index.jsp">回首頁</a>

</body>
</html>