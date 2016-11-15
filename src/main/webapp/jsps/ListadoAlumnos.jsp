<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
      <!-- Custom CSS -->
    <link href="../css/3-col-portfolio.css" rel="stylesheet">

    <!-- Bootstrap Core CSS -->
    <link href="../css/timeLine.css" rel="stylesheet">
    
    
     <!-- jQuery -->
    <script src="../js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    
<title>Listado Alumnos</title>
</head>
<body>
<%@include file="Header.jsp" %>
	<h1 style="text-align:center"> Listado Alumnos</h1>
	<div class="container">
		<h4 style="text-align:center">Tabla 1</h4>
		<table class="table table-striped">
			<caption style="text-align:center">Tabla 1</caption>
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Legajo</th>
					<th>Otros...</th>
				</tr>
			</thead>
		
			<tbody>
				<tr>
					<td>Ramiro Ongaro</td>
					<td>5678</td>
					<td>Saraza...</td>
				</tr>
				<tr>
					<td>Luciano Matsuo</td>
					<td>1234</td>
					<td>Saraza...</td>
				</tr>
			</tbody>
		</table>
		
		<h4 style="text-align:center">Tabla 2</h4>
		<table class="table table-striped">
			<caption style="text-align:center">Tabla 2</caption>
			<thead>
				<tr>
					<th>Nombre</th>
					<th>Legajo</th>
					<th>Otros...</th>
				</tr>
			</thead>
		
			<tbody>
				<tr>
					<td>Ramiro Ongaro</td>
					<td>5678</td>
					<td>Saraza...</td>
				</tr>
				<tr>
					<td>Luciano Matsuo</td>
					<td>1234</td>
					<td>Saraza...</td>
				</tr>
			</tbody>
		</table>
	
	
	
	</div>
	<%@include file="Footer.jsp" %>
</body>
</html>