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
<form method="post" action="Shiftre.do" >

���<input type="date" name="Date" value="${shiftreVO.date}" readonly="readonly"><br>
�Z�O<Select name="shift">
<option value="${shiftreVO.shift}" selected="selected">${shiftreVO.shift}</option>
</Select><br>
���u�s��    <input type="text" name="emp_id" value="${shiftreVO.emp_id}"><br>
�{��<input type="text" name="cash" value="${shiftreVO.cash}"><br>
§��<input type="text" name="coupon" value="${shiftreVO.coupon}"><br>
����<input type="text" name="discount" value="${shiftreVO.discount}"><br>
�s�Ϊ�<input type="text" name="coins" value="${shiftreVO.coins}"><br>
����B<input type="text" name="deal_sum" value="${shiftreVO.deal_sum}"><br>
�������<input  type="text" name="deal_cost" value="${shiftreVO.deal_cost}"><br>
����b�Q<input type="text" name="deal_profit" value="${shiftreVO.deal_profit}"><br>
�������<input type="text" name="deal_num" value="${shiftreVO.deal_num}"><br>
�Z�O�p�p<input type="text" name="shift_sum" value="${shiftreVO.shift_sum}"><br>

<input type="submit" value="�ק�">
<input type="hidden" name="action" value="updateToDB">

</form>
</body>
</html>