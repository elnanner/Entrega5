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
    
<title>Administrar permisos sobre carteleras</title>
</head>
<body>
<%@include file="Header.jsp" %>
	<h1 style="text-align:center"> Administrar permisos sobre carteleras</h1>
	<div class="container">
	<form method="post" action="#">
		<h4 style="text-align:center">       Nombre de usuario <%--<% if(session.getAttribute("userName")==null){ 
		                                             Nombre de usuario
		                                       <% }else{ %>
		                                               <%= session.getAttribute("userName") %>
		                                        <%} %> --%>
		 </h4>                       
		<table class="table table-striped">
			<thead>
				<tr>
					<th>Nombre pizarra</th>
					<th>Descripcion</th>
					<th>Permisos</th>
				</tr>
			</thead>
		
			<tbody>
				<tr>
					<td>Materias</td>
					<td>Descricion pizarras materias</td>
					<td><input type="checkbox" value="1">Asingar permisos sobre la cartelera</td>
				</tr>
				<tr>
					<td>Ofertas labortales</td>
					<td>Descripcion pizarras materias</td>
					<td><input type="checkbox" value="1">Asingar permisos sobre la cartelera</td>
				</tr>
			</tbody>
		</table>
		
	
		<button type="submit" class="btn btn-success">Guardar permisos</button>
	</form>
	
	</div>
	<%@include file="Footer.jsp" %>
</body>
</html>