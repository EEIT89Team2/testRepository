<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>�ק���u���</title>
</head>
<body>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>
<form method="post" action="Employee.do" enctype="multipart/form-data">

���u�s��<input type="text" name="emp_id" value="${empVO.emp_id}" readonly="readonly" style="color: gray;" ><br>
�K�X        <input type="text" name="emp_pwd" value="${empVO.emp_pwd}"><br>
�m�W        <input type="text" name="emp_name" value="${empVO.emp_name}"><br>
�ʧO        <input type="text" name="emp_sex"value="${empVO.emp_sex}"><br>
������    <input type="text" name="emp_idnum" value="${empVO.emp_idnum}"><br>
�a�}        <input type="text" name="emp_addr" value="${empVO.emp_addr}"><br>
�q�l�H�c<input type="text" name="emp_mail" value="${empVO.emp_mail}"><br>
�q��        <input type="text" name="emp_phone" value="${empVO.emp_phone}"><br>
�ͤ�        <input type="date" name="emp_bday" value="${empVO.emp_bday}"><br>
��¾��    <input type="date" name="emp_reg" value="${empVO.emp_reg}"><br>
��¾��    <input type="date" name="emp_due" value="${empVO.emp_due}"><br>
�Ӥ�<img alt="�|�L�j�Y��" src="data:image/gif;base64,${empVO.picture}">
<input type="hidden" name="picture" value="${empVO.picture}">
<input  type="file" name="newPicture"><br>

�ק�H    <input type="text" name="key_id" value="${empVO.key_id}"><br>
<input type="hidden" name="pass_code" value="${empVO.pass_code}">

<input type="submit" value="�ק�">
<input type="hidden" name="action" value="updateToDB">


<%-- <%-- 			<td><img alt="X" src="../images/${empVO.emp_id}.jpg"></td> --%>
<%-- 			<td><img alt="X" src="data:image/gif;base64,${empVO.picture}"></td> --%>
			

</form>
</body>
</html>