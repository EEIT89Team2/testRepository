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
<form method="post" action="Company.do" enctype="multipart/form-data">

�t�ӽs��<input type="text" name="com_id" value="${comVO.com_id}" readonly="readonly" style="color: gray;" ><br>
�W��        <input type="text" name="com_name" value="${comVO.com_name}"><br>
�Τ@        <input type="text" name="com_um" value="${comVO.com_um}"><br>
�a�}        <input type="text" name="com_addr"value="${comVO.com_addr}"><br>
�q�l�H�c    <input type="text" name="com_mail" value="${comVO.com_mail}"><br>
�q��        <input type="text" name="com_phone" value="${comVO.com_phone}"><br>
�Ӥ�<img alt="�|�L�W��" src="data:image/gif;base64,${comVO.picture}">
<input type="hidden" name="picture" value="${comVO.picture}">
<input  type="file" name="newPicture"><br>
�ק�H    <input type="text" name="key_id" value="${comVO.key_id}"><br>

<input type="submit" value="�ק�">
<input type="hidden" name="action" value="updateToDB">

</form>
</body>
</html>