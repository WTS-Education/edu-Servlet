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
<fieldset style="width:410px"><br>
	<form action="Calculator" method="POST">

	<input type="text" name="output" style="width:400px; height:70px">

	<table>
	<tr>
		<td><input type=submit name="buttonCE" value="CE" style="width:100px; height:100px">
		<td><input type=submit name="buttonC" value="C" style="width:100px; height:100px">
		<td><input type=submit name="buttonBack" value="戻" style="width:100px; height:100px">
		<td><input type=submit name="button÷" value="÷" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="button7" value="7" style="width:100px; height:100px">
		<td><input type=submit name="button8" value="8" style="width:100px; height:100px">
		<td><input type=submit name="button9" value="9" style="width:100px; height:100px">
		<td><input type=submit name="button×" value="×" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="button4" value="4" style="width:100px; height:100px">
		<td><input type=submit name="button5" value="5" style="width:100px; height:100px">
		<td><input type=submit name="button6" value="6" style="width:100px; height:100px">
		<td><input type=submit name="button-" value="-" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="button1" value="1" style="width:100px; height:100px">
		<td><input type=submit name="button2" value="2" style="width:100px; height:100px">
		<td><input type=submit name="button3" value="3" style="width:100px; height:100px">
		<td><input type=submit name="button+" value="+" style="width:100px; height:100px">

	<tr>
		<td><input type=submit name="button±" value="±" style="width:100px; height:100px">
		<td><input type=submit name="button0" value="0" style="width:100px; height:100px">
		<td><input type=submit name="button." value="." style="width:100px; height:100px">
		<td><input type=submit name="button=" value="=" style="width:100px; height:100px">
	</table>
	</form>
</fieldset>
</body>
</html>