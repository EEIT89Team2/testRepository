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
			<th>���s</th>
			<th>�K�X</th>
			<th>�m�W</th>
			<th>�ʧO</th>
			<th>�����Ҧr��</th>
			<th>�a�}</th>
			<th>�q�l�H�c</th>
			<th>�q��</th>
			<th>�ͤ�</th>
			<th>��¾��</th>
			<th>��¾��</th>
			<th>�Ӥ�</th>
			<th>�ק�H</th>
			<th>�ק�ɶ�</th>
			<th>�v��</th>
			<th>�ק�</th>
			<th>�R��</th>
		</tr>
		
<c:forEach var="list" items="${list}" varStatus="count">
		<form method="post" action="Employee.do">
		<tr>
			<td>${list.emp_id}</td>
			<td>${list.emp_pwd}</td>
			<td>${list.emp_name}</td>
			<td>${list.emp_sex}</td>
			<td>${list.emp_idnum}</td>
			<td>${list.emp_addr}</td>
			<td>${list.emp_mail}</td>
			<td>${list.emp_phone}</td>
			<td>${list.emp_bday}</td>
			<td>${list.emp_reg}</td>
			<td>${list.emp_due}</td>
			<td><img alt="�|�L�j�Y��" src="data:image/gif;base64,${list.picture}"></td>
			<td>${list.key_id}</td>
			<td>${list.key_date}</td>
			<td>${list.pass_code}</td>
			<td><input type="submit" name="action" value="update" ></td>
			<td><input type="submit" name="action" value="delete" ></td>
			<input type="hidden" name="emp_id" value="${list.emp_id}">
			
		</tr>
		
</form>
<%-- 		${count.index} --%>
</c:forEach>
	</table>
	
	<a href="/pos/Index.jsp">�^����</a>

</body>
</html>