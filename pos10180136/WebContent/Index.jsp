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

<%-- ���~��C --%>
<c:if test="${not empty errorMsgs}">
	<font color='red'>�Эץ��H�U���~:
	<ul>
		<c:forEach var="message" items="${errorMsgs}">
			<li>${message}</li>
		</c:forEach>
	</ul>
	</font>
</c:if>

<h1>SHIPMENTS</h1>
<a href="SHIPMENTS/addShipments.jsp">�s�W�X�f��</a><br>
<a href="SHIPMENTS/SelectShipments.jsp">�d�ߥX�f��</a>


<h1>EMPLOYEE</h1>

<form method="post" action="Employee.do">
<p>�̭��u�s���j�M</p>
<input type="text" name="emp_id">
<input type="submit" value="�j�M">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Employee.do">
<p>�d�ߥ������u(�R��.�ק�)</p>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Employee.do" enctype="multipart/form-data">
<p>�s�W���u</p>
<!-- �s��:<input type="text" name="emp_id"><br> -->
�K�X<input type="text" name="emp_pwd" value="3310"><br>
�m�W<input type="text" name="emp_name" value="�_�j��"><br>
�ʧO<input type="text" name="emp_sex"value="�k"><br>
������<input type="text" name="emp_idnum" value="A132789952"><br>
�a�}    <input type="text" name="emp_addr" value="�x�_���s�ͥ_�����q�@��"><br>
�q�l�H�c<input type="text" name="emp_mail" value="dadaa@gmail.com"><br>
�q��<input type="text" name="emp_phone" value="0988456877"><br>
�ͤ�<input type="date" name="emp_bday" value="1991-08-26"><br>
��¾��<input type="date" name="emp_reg" value="2016-09-30"><br>
<!-- ��¾��<input type="text" name="emp_due"><br> -->
��¾��<input type="date" name="emp_due"><br>
�Ӥ�<input  type="file" name="picture"><br>
�ק�H<input type="text" name="key_id" value="E00005"><br>
<input type="submit" value="�s�W">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Employee.do">
<p>�m�W����r�d��</p>
<input type="text" name="emp_name"><br>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="selectByName">
</form>
<hr>

<form method="post" action="Employee.do">
<p>�ק��v��</p>
���u�s��<input type="text" name="emp_id"><br>
�v���N��<input type="text" name="pass_code"><br>
<input type="submit" value="�ק�" >
<input type="hidden" name="action" value="setPassCode">
</form>
<br><br><br>
<hr><hr>
<br><br><br>

<h1>COMPANY</h1>

<form method="post" action="Company.do">
<p>�̼t�ӽs���j�M</p>
<input type="text" name="com_id">
<input type="submit" value="�j�M">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Company.do">
<p>�d�ߥ����t��(�R��.�ק�)</p>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Company.do" enctype="multipart/form-data">
<p>�s�W�t��</p>
�W��<input type="text" name="com_name" value="�s���q�l"><br>
�Τ@�s��<input type="text" name="com_um" value="33221354"><br>
�a�}    <input type="text" name="com_addr" value="�x�_���Q����83��5��"><br>
�q�l�H�c<input type="text" name="com_mail" value="dadaa@gmail.com"><br>
�q��<input type="text" name="com_phone" value="0988456877"><br>
�Ӥ�<input  type="file" name="picture"><br>
�ק�H<input type="text" name="key_id" value="E00005"><br>
<input type="submit" value="�s�W">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Company.do">
<p>�t�ӦW������r�d��</p>
<input type="text" name="com_name"><br>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="selectByName">
</form>

<br><br><br>
<hr><hr>
<br><br><br>

<h1>PRODUCT</h1>

<form method="post" action="Product.do">
<p>�̰ӫ~�s���j�M</p>
<input type="text" name="prod_id">
<input type="submit" value="�j�M">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Product.do">
<p>�d�ߥ����ӫ~(�R��.�ק�)</p>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Product.do" enctype="multipart/form-data">
<p>�s�W�ӫ~</p>
�ӫ~�W��<input type="text" name="prod_name" value="LG �G���q�� 23�T"><br>
�t�ӽs��<input type="text" name="com_id" value="C00001"><br>
����    <input type="text" name="prod_group" value="�a�q"><br>
�w��<input type="text" name="prod_mkprice" value="6999"><br>
����<input type="text" name="prod_cost" value="4000"><br>
�w�s<input type="text" name="prod_stock" value="3"><br>
�w���w�s<input type="text" name="prod_q_safty" value="1"><br>
�W��<input type="text" name="prod_spec" value="Full HD"><br>
�ӫ~�Ӥ�<input  type="file" name="picture"><br>
�Ƶ�<input type="text" name="remark" value="�ɴ��P�P"><br>
<input type="submit" value="�s�W">
<input type="hidden" name="status" value="Y">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Product.do">
<p>�ӫ~�W������r�d��</p>
�W��<input type="text" name="prod_name"><br>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="selectByName">
</form>
<hr>

<form method="post" action="Product.do">
<p>�ӫ~��������r�d��</p>
����<input type="text" name="prod_group"><br>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="selectByGroup">
</form>


<br><br><br>
<hr><hr>
<br><br><br>

<h1>SHIFTREPORT</h1>

<form method="post" action="Shiftre.do">
<p>�̯Z�O����j�M</p>
���<input type="date" name="Date"><br>
�Z�O<Select name="shift">
<option value="A">A</option>
<option value="B">B</option>
</Select><br>
<input type="submit" value="�j�M">
<input type="hidden" name="action" value="get_one">
</form>
<hr>

<form method="post" action="Shiftre.do">
<p>�d�ߥ����Z�O����(�R��.�ק�)</p>
<input type="submit" value="�j�M" >
<input type="hidden" name="action" value="get_all">
</form>
<hr>

<form method="post" action="Shiftre.do">
<p>�s�W�Z�O����</p>
���<input type="date" name="Date"><br>
�Z�O<Select name="shift">
<option value="A">A</option>
<option value="B">B</option>
</Select><br>
���u�s��    <input type="text" name="emp_id" value="E00001"><br>
�{��<input type="text" name="cash" value="2000"><br>
§��<input type="text" name="coupon" value="0"><br>
����<input type="text" name="discount" value="0"><br>
�s�Ϊ�<input type="text" name="coins" value="1500"><br>
����B<input type="text" name="deal_sum" value="2000"><br>
�������<input  type="text" name="deal_cost" value="1000"><br>
����b�Q<input type="text" name="deal_profit" value="1000"><br>
�������<input type="text" name="deal_num" value="3"><br>
�Z�O�p�p<input type="text" name="shift_sum" value="2000"><br>
<input type="submit" value="�s�W">
<input type="hidden" name="action" value="insert">
</form>
<hr>

<form method="post" action="Shiftre.do">
<p>�̷Ӥ���d��</p>
���<input type="date" name="Date"><br>
<input type="submit" value="�j�M" >
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