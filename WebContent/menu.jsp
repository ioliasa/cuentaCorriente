<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="main.banco.controller.AdminBanco" %>
<%@page import="main.banco.Cuenta" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banco Jacarandá</title>
</head>
<body bgcolor="#E6E6FA">


<div align="center"><img src="banco.jpeg" alt="My money" >
<div align="center"><br>
<%
if (request.getAttribute("saldo") != null){
    out.println(request.getAttribute("saldo").toString());
}
%>
<br>
</div>

<table border="1" width="50%" align="center">
	<tr>
		<td align="center"><a href=adminBanco?action=ingresar>Ingresar Dinero</a>
		<td align="center"><a href=adminBanco?action=reintegrar>Sacar Dinero</a>
		<td align="center"><a href=adminBanco?action=saldo>Consultar Saldo</a>
		</td>			
	</tr>
	<tr>
	
</table>
</div>
<br>
<br>


		