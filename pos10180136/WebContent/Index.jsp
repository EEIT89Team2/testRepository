<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="BIG5"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=BIG5">
<title>POS test</title>
</head>
<body>

<%-- 錯誤表列 --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>請修正以下錯誤:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<h1>SHIPMENTS</h1>
<a href="SHIPMENTS/addShipments.jsp">新增出貨單</a><br>
<a href="SHIPMENTS/SelectShipments.jsp">查詢出貨單</a>


<h1>EMPLOYEE</h1>

<form method="post" action="Employee.do">
<p>依員工編號搜尋</p>
<input type="text" name="emp_id">
<input type="submit" value="搜尋">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Employee.do">
<p>查詢全部員工(刪除.修改)</p>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Employee.do" enctype="multipart/form-data">
<p>新增員工</p>
<!-- 編號:<input type="text" name="emp_id"><br> -->
密碼<input type="text" name="emp_pwd" value="3310"><br>
姓名<input type="text" name="emp_name" value="柯大中"><br>
性別<input type="text" name="emp_sex"value="男"><br>
身分證<input type="text" name="emp_idnum" value="A132789952"><br>
地址    <input type="text" name="emp_addr" value="台北市新生北路五段一號"><br>
電子信箱<input type="text" name="emp_mail" value="dadaa@gmail.com"><br>
電話<input type="text" name="emp_phone" value="0988456877"><br>
生日<input type="date" name="emp_bday" value="1991-08-26"><br>
到職日<input type="date" name="emp_reg" value="2016-09-30"><br>
<!-- 離職日<input type="text" name="emp_due"><br> -->
離職日<input type="date" name="emp_due"><br>
照片<input  type="file" name="picture"><br>
修改人<input type="text" name="key_id" value="E00005"><br>
<input type="submit" value="新增">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Employee.do">
<p>姓名關鍵字查詢</p>
<input type="text" name="emp_name"><br>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="selectByName">
</form>
<hr>

<form method="post" action="Employee.do">
<p>修改權限</p>
員工編號<input type="text" name="emp_id"><br>
權限代號<input type="text" name="pass_code"><br>
<input type="submit" value="修改" >
<input type="hidden" name="action" value="setPassCode">
</form>
<br><br><br>
<hr><hr>
<br><br><br>

<h1>COMPANY</h1>

<form method="post" action="Company.do">
<p>依廠商編號搜尋</p>
<input type="text" name="com_id">
<input type="submit" value="搜尋">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Company.do">
<p>查詢全部廠商(刪除.修改)</p>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Company.do" enctype="multipart/form-data">
<p>新增廠商</p>
名稱<input type="text" name="com_name" value="龍祥電子"><br>
統一編號<input type="text" name="com_um" value="33221354"><br>
地址    <input type="text" name="com_addr" value="台北市松江路83巷5號"><br>
電子信箱<input type="text" name="com_mail" value="dadaa@gmail.com"><br>
電話<input type="text" name="com_phone" value="0988456877"><br>
照片<input  type="file" name="picture"><br>
修改人<input type="text" name="key_id" value="E00005"><br>
<input type="submit" value="新增">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Company.do">
<p>廠商名稱關鍵字查詢</p>
<input type="text" name="com_name"><br>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="selectByName">
</form>

<br><br><br>
<hr><hr>
<br><br><br>

<h1>PRODUCT</h1>

<form method="post" action="Product.do">
<p>依商品編號搜尋</p>
<input type="text" name="prod_id">
<input type="submit" value="搜尋">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Product.do">
<p>查詢全部商品(刪除.修改)</p>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Product.do" enctype="multipart/form-data">
<p>新增商品</p>
商品名稱<input type="text" name="prod_name" value="LG 液晶電視 23吋"><br>
廠商編號<input type="text" name="com_id" value="C00001"><br>
分類    <input type="text" name="prod_group" value="家電"><br>
定價<input type="text" name="prod_mkprice" value="6999"><br>
成本<input type="text" name="prod_cost" value="4000"><br>
庫存<input type="text" name="prod_stock" value="3"><br>
安全庫存<input type="text" name="prod_q_safty" value="1"><br>
規格<input type="text" name="prod_spec" value="Full HD"><br>
商品照片<input  type="file" name="picture"><br>
備註<input type="text" name="remark" value="檔期促銷"><br>
<input type="submit" value="新增">
<input type="hidden" name="status" value="Y">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Product.do">
<p>商品名稱關鍵字查詢</p>
名稱<input type="text" name="prod_name"><br>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="selectByName">
</form>
<hr>

<form method="post" action="Product.do">
<p>商品分類關鍵字查詢</p>
分類<input type="text" name="prod_group"><br>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="selectByGroup">
</form>


<br><br><br>
<hr><hr>
<br><br><br>

<h1>SHIFTREPORT</h1>

<form method="post" action="Shiftre.do">
<p>依班別報表搜尋</p>
日期<input type="date" name="Date"><br>
班別<Select name="shift">
<option value="A">A</option>
<option value="B">B</option>
</Select><br>
<input type="submit" value="搜尋">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Shiftre.do">
<p>查詢全部班別報表(刪除.修改)</p>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Shiftre.do">
<p>新增班別報表</p>
日期<input type="date" name="Date"><br>
班別<Select name="shift">
<option value="A">A</option>
<option value="B">B</option>
</Select><br>
員工編號    <input type="text" name="emp_id" value="E00001"><br>
現金<input type="text" name="cash" value="2000"><br>
禮卷<input type="text" name="coupon" value="0"><br>
折讓<input type="text" name="discount" value="0"><br>
零用金<input type="text" name="coins" value="1500"><br>
交易額<input type="text" name="deal_sum" value="2000"><br>
交易成本<input  type="text" name="deal_cost" value="1000"><br>
交易淨利<input type="text" name="deal_profit" value="1000"><br>
交易次數<input type="text" name="deal_num" value="3"><br>
班別小計<input type="text" name="shift_sum" value="2000"><br>
<input type="submit" value="新增">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Shiftre.do">
<p>依照日期查詢</p>
日期<input type="date" name="Date"><br>
<input type="submit" value="搜尋" >
<input type="hidden" name="action" value="selectByDate">
</form>
<hr>






<form method="post" action="AEmployee.do">
<p>test</p>
<input type="submit" value="test" >
<input type="hidden" name="action" value="test">
</form>
<hr>

</body>
</html>