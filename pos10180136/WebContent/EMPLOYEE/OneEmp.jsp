<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>員工基本資料</title>

</head>
<body>
	<table border="2">
		<tr>
			<th>員編</th>
			<th>密碼</th>
			<th>姓名</th>
			<th>性別</th>
			<th>身分證字號</th>
			<th>地址</th>
			<th>電子信箱</th>
			<th>電話</th>
			<th>生日</th>
			<th>到職日</th>
			<th>離職日</th>
			<th>照片</th>
			<th>修改人</th>
			<th>修改時間</th>
			<th>修改</th>
		</tr>
		<tr>
			<td>${empVO.emp_id}</td>
			<td>${empVO.emp_pwd}</td>
			<td>${empVO.emp_name}</td>
			<td>${empVO.emp_sex}</td>
			<td>${empVO.emp_idnum}</td>
			<td>${empVO.emp_addr}</td>
			<td>${empVO.emp_mail}</td>
			<td>${empVO.emp_phone}</td>
			<td>${empVO.emp_bday}</td>
			<td>${empVO.emp_reg}</td>
			<td>${empVO.emp_due}</td>
<%-- 			<td><img alt="X" src="../images/${empVO.emp_id}.jpg"></td> --%>
			<td><img alt="X" src="data:image/gif;base64,${empVO.picture}"></td>
			
			<td>${empVO.key_id}</td>
			<td>${empVO.key_date}</td>
			<td><input type="button" value="修改"  ></td>
		</tr>
	</table>
	
<!-- 		<table border="2"> -->
		
<%-- <c:forEach var="list" items="${list}"> --%>
<!-- 		<tr> -->
<%-- 			<td>${list.emp_id}</td> --%>
<%-- 			<td>${list.emp_pwd}</td> --%>
<%-- 			<td>${list.emp_name}</td> --%>
<%-- 			<td>${list.emp_sex}</td> --%>
<%-- 			<td>${list.emp_idnum}</td> --%>
<%-- 			<td>${list.emp_addr}</td> --%>
<%-- 			<td>${list.emp_mail}</td> --%>
<%-- 			<td>${list.emp_phone}</td> --%>
<%-- 			<td>${list.emp_bday}</td> --%>
<%-- 			<td>${list.emp_reg}</td> --%>
<%-- 			<td>${list.emp_due}</td> --%>
<%-- 			<td><img alt="X" src="data:image/gif;base64,${list.emp_id}"></td> --%>
<%-- 			<td>${list.key_id}</td> --%>
<%-- 			<td>${list.key_date}</td> --%>
<!-- 		</tr> -->
<%-- </c:forEach> --%>
<!-- 	</table> -->
	
	
</body>
</html>