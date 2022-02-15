<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Banco Jacarandá</title>
</head>
<body bgcolor="#E6E6FA">
<div align="center"><img src="banco.jpeg" alt="My money" >

<form method="post" action="adminBanco?action=realizarIngreso">
	<div>Introduce el     dinero a ingresar:<input type="number" id="dinero" name="dinero"
       min="1.0" step="0.01" ></div>
	
	<input type="submit" value="OK">
</form> </div>

</body>
</html>