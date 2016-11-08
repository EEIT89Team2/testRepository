<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>修改員工資料</title>
</head>
<body>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>
<form method="post" action="Company.do" enctype="multipart/form-data">

廠商編號<input type="text" name="com_id" value="${comVO.com_id}" readonly="readonly" style="color: gray;" ><br>
名稱        <input type="text" name="com_name" value="${comVO.com_name}"><br>
統一        <input type="text" name="com_um" value="${comVO.com_um}"><br>
地址        <input type="text" name="com_addr"value="${comVO.com_addr}"><br>
電子信箱    <input type="text" name="com_mail" value="${comVO.com_mail}"><br>
電話        <input type="text" name="com_phone" value="${comVO.com_phone}"><br>
照片<img alt="尚無名片" src="data:image/gif;base64,${comVO.picture}">
<input type="hidden" name="picture" value="${comVO.picture}">
<input  type="file" name="newPicture"><br>
修改人    <input type="text" name="key_id" value="${comVO.key_id}"><br>

<input type="submit" value="修改">
<input type="hidden" name="action" value="updateToDB">

</form>
</body>
</html>