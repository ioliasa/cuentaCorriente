<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@page import="main.banco.controller.AdminBanco" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Cuenta corriente</title>
</head>
<body bgcolor="#E6E6FA">
<h1 align="center">Banco Jacaranda</h1>
<div align="center"><img src="banco.jpeg" alt="My money" > 
<form method="post" action="adminBanco?action=empezar">
	<div>Introduce el dddddnúmero de cuenta:<input type="text" id="ncc" name="ncc" ></div>
    <div>Introduce el saldo inicial:<input type="number" id="saldo" name="saldo"
       min="0.0" step="0.01" ></div>
	
	<input type="submit" id = "ok" value="OK">
</form> </div>
</body>
</html>