<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>WTS電卓課題</title>
</head>
<body>
    <%= new java.util.Date() %>

<jsp:useBean id="calc" class="jp.co.wintechservice.webCalculator.beans.Calc" scope="session"></jsp:useBean>

<fieldset style="width:450px"><br>
	<form action="IndexServlet" method="POST">

	<table>
	<tr>
		<td colspan="4" style="width:400px; height:50px">${calc.result}</td>>

	<tr>
		<td><input type=submit name="Del" value="CE" style="width:100px; height:100px">
		<td><input type=submit name="Del" value="C" style="width:100px; height:100px">
		<td><input type=submit name="Del" value="戻" style="width:100px; height:100px">
		<td><input type=submit name="operator" value="÷" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="num" value="7" style="width:100px; height:100px">
		<td><input type=submit name="num" value="8" style="width:100px; height:100px">
		<td><input type=submit name="num" value="9" style="width:100px; height:100px">
		<td><input type=submit name="operator" value="×" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="num" value="4" style="width:100px; height:100px">
		<td><input type=submit name="num" value="5" style="width:100px; height:100px">
		<td><input type=submit name="num" value="6" style="width:100px; height:100px">
		<td><input type=submit name="operator" value="-" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="num" value="1" style="width:100px; height:100px">
		<td><input type=submit name="num" value="2" style="width:100px; height:100px">
		<td><input type=submit name="num" value="3" style="width:100px; height:100px">
		<td><input type=submit name="operator" value="+" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="operator" value="±" style="width:100px; height:100px">
		<td><input type=submit name="num" value="0" style="width:100px; height:100px">
		<td><input type=submit name="num" value="." style="width:100px; height:100px">
		<td><input type=submit name="result" value="=" style="width:100px; height:100px">
	</table>
	</form>
</fieldset>
</body>
</html>