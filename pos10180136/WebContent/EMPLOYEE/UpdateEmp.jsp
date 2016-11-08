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
<form method="post" action="Employee.do" enctype="multipart/form-data">

員工編號<input type="text" name="emp_id" value="${empVO.emp_id}" readonly="readonly" style="color: gray;" ><br>
密碼        <input type="text" name="emp_pwd" value="${empVO.emp_pwd}"><br>
姓名        <input type="text" name="emp_name" value="${empVO.emp_name}"><br>
性別        <input type="text" name="emp_sex"value="${empVO.emp_sex}"><br>
身分證    <input type="text" name="emp_idnum" value="${empVO.emp_idnum}"><br>
地址        <input type="text" name="emp_addr" value="${empVO.emp_addr}"><br>
電子信箱<input type="text" name="emp_mail" value="${empVO.emp_mail}"><br>
電話        <input type="text" name="emp_phone" value="${empVO.emp_phone}"><br>
生日        <input type="date" name="emp_bday" value="${empVO.emp_bday}"><br>
到職日    <input type="date" name="emp_reg" value="${empVO.emp_reg}"><br>
離職日    <input type="date" name="emp_due" value="${empVO.emp_due}"><br>
照片<img alt="尚無大頭照" src="data:image/gif;base64,${empVO.picture}">
<input type="hidden" name="picture" value="${empVO.picture}">
<input  type="file" name="newPicture"><br>

修改人    <input type="text" name="key_id" value="${empVO.key_id}"><br>
<input type="hidden" name="pass_code" value="${empVO.pass_code}">

<input type="submit" value="修改">
<input type="hidden" name="action" value="updateToDB">


<%-- <%-- 			<td><img alt="X" src="../images/${empVO.emp_id}.jpg"></td> --%>
<%-- 			<td><img alt="X" src="data:image/gif;base64,${empVO.picture}"></td> --%>
			

</form>
</body>
</html>