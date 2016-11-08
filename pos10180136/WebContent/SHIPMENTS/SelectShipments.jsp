<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>查詢出貨單</title>
</head>
<body>

<h1>出貨單</h1>

<form method="post" action="Shipments.do">

<table border="1">
		<tr>
			<th>日期範圍(起)</th>
			<th>日期範圍(迄)</th>
		</tr>
		<tr>
		    <td><input type="date" name="dateBegin" value="2016-09-16"></td>
			<td><input type="date" name="dateEnd" value="2016-10-16"></td>
		</tr>
		</table>
<br>
<input type="submit" value="送出"/>
<input type="hidden" name="action" value="SelectByDate">

</form>

<hr><hr>
<h3>查詢全部出貨單</h3>
<form method="post" action="Shipments.do" >
<input type="submit"  value="查詢">
<input type="hidden" name="action" value="getAll">

</form>

<hr><hr>
<h3>依出貨單編號查詢</h3>


<form method="post" action="Shipments.do" >
<table border="1">
	<tr>
		<th>出貨單編號</th>
		<th>查詢</th>
	</tr>
	<tr>
		<td><input type="text" name="ship_id"></td>
		<td><input type="submit"  value="送出"></td>
	</tr>
</table>
<input type="hidden" name="action" value="getByShip_id">
</form>


<hr><hr>
<h3>依訂單編號查詢</h3>
<form method="post" action="Shipments.do" >
<table border="1">
	<tr>
		<th>訂單編號</th>
		<th>查詢</th>
	</tr>
	<tr>
		<td><input type="text" name="ord_id"></td>
		<td><input type="submit"  value="送出"></td>
	</tr>
</table>
<input type="hidden" name="action" value="getByOrd_id">
</form>

	<a href="/pos/Index.jsp">回首頁</a>

</body>
</html>