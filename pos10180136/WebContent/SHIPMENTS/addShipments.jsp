<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>新增出貨單</title>
</head>
<body>

<h1>出貨單</h1>

<form method="post" action="Shipments.do" id="form1">

<table border="0">
	<tr>
		<td>出貨單編號 <input type="text" name="ship_id" value="由資料庫產生" readonly="readonly" /></td></tr>
		<tr><td>訂單編號<input type="text" name="ord_id" value="OR2016092900003"></td></tr>
		<tr><td>出貨日期<input type="date" name="ship_date" value="2016-10-16"></td></tr>
		<tr><td>收件人地址<input type="text" name="rec_addr" value="台北市安和路一段五號"></td></tr>
		<tr><td>收件人姓名<input type="text" name="rec_name" value="陳世宏"></td></tr>
		<tr><td>修改人員<input type="text" name="key_id" value="E00003"></td></tr>
		<tr><td>備註<input type="text" name="remark" value="早上到貨"></td></tr>
</table>
<hr><hr>
<input type="button" value="新增明細" id="addNewDetail">
<input type="submit" value="送出"/>
<input type="hidden" name="action" value="insert">
<table border="0">
	<tr>
		<td>出貨單編號 <input type="text" name="ship_id1" value="由資料庫產生" readonly="readonly" /></td></tr>
		<tr><td>商品編號<input type="text" name="prod_id1" value="P00001"></td></tr>
		<tr><td>商品名稱<input type="text" name="prod_name1" value="iphone 6 16G 黑色"></td></tr>
		<tr><td>商品數量<input type="text" name="prod_quantity1" value="1"></td></tr>
</table>

</form>

<script src="../js/jquery-3.1.1.min.js"></script>

	<script>
		$(function() {   
			var a=2;
			$("#addNewDetail").click(function() {$("#form1").append(
					"</br><table border='0'>"
					+"<tr><td>出貨單編號 <input type='text' name='ship_id"+a+"' value='由資料庫產生' readonly='readonly'/></td></tr>"
					+"<tr><td>商品編號<input type='text' name='prod_id"+a+"' /></td></tr>"
					+"<tr><td>商品名稱<input type='text' name='prod_name"+a+"'/ ></td></tr>"
					+"<tr><td>商品數量<input type='text' name='prod_quantity"+a+"'/></td></tr>"
					+"</table>")
					a=a+1;
			})

		})
		
	</script>

</body>
</html>