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
<form method="post" action="Shiftre.do" >

日期<input type="date" name="Date" value="${shiftreVO.date}" readonly="readonly"><br>
班別<Select name="shift">
<option value="${shiftreVO.shift}" selected="selected">${shiftreVO.shift}</option>
</Select><br>
員工編號    <input type="text" name="emp_id" value="${shiftreVO.emp_id}"><br>
現金<input type="text" name="cash" value="${shiftreVO.cash}"><br>
禮卷<input type="text" name="coupon" value="${shiftreVO.coupon}"><br>
折讓<input type="text" name="discount" value="${shiftreVO.discount}"><br>
零用金<input type="text" name="coins" value="${shiftreVO.coins}"><br>
交易額<input type="text" name="deal_sum" value="${shiftreVO.deal_sum}"><br>
交易成本<input  type="text" name="deal_cost" value="${shiftreVO.deal_cost}"><br>
交易淨利<input type="text" name="deal_profit" value="${shiftreVO.deal_profit}"><br>
交易次數<input type="text" name="deal_num" value="${shiftreVO.deal_num}"><br>
班別小計<input type="text" name="shift_sum" value="${shiftreVO.shift_sum}"><br>

<input type="submit" value="修改">
<input type="hidden" name="action" value="updateToDB">

</form>
</body>
</html>