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
    
<title>Listado Usuarios</title>
</head>
<body>
<%@include file="Header.jsp" %>
<script>
function eliminarPublicador(){
	/*lo queres mas lindo???*/
	$("#filaP").remove();
	$("#output").removeClass(' alert alert-success');
	//alert($("#a").data("data-custom-value"));
	$("#output").addClass("alert alert-danger animated fadeInUp").html("borrar cartelera "); //buscar como sacar valor del a
}; 
function eliminarAdministrador(){
	/*lo queres mas lindo???*/
	$("#filaA").remove();
	$("#output").removeClass(' alert alert-success');
	//alert($("#a").data("data-custom-value"));
	$("#output").addClass("alert alert-danger animated fadeInUp").html("borrar cartelera "); //buscar como sacar valor del a
}; 

</script>
	<h1 style="text-align:center"> Listado Usuarios</h1>
	<div class="container">
		<h4 style="text-align:center">Publicadores</h4>
		<table class="table table-striped">
			<caption style="text-align:center">Publicadores</caption>
			<thead>
				<tr>
					<th>Nombre usuario</th>
					<th>Perfil</th>
					<th>Operaciones</th>
				</tr>
			</thead>
		
			<tbody>
				<tr id="filaP">
					<td>Ramiro Ongaro</td>
					<td>Docente</td>
					<td><a href="#">
        				 <span class="glyphicon glyphicon-cog"> </span>
        				 </a>
                          <a href="#" onclick="eliminarPublicador()">
         				 <span class="glyphicon glyphicon-trash"></span>
     					   </a>    
     					     <a href="AdministrarPermisosSobrePizarra.jsp">
         				 		<span class="glyphicon glyphicon-sunglasses"></span>
     					   </a>
     			    </td>
				</tr>
				<tr id="filaP">
					<td>Luciano Matsuo</td>
					<td>Publicador</td>
					<td>
					     <a href="#">
        				 <span class="glyphicon glyphicon-cog"> </span>
        				 </a>
                          <a href="#" onclick="eliminarPublicador()">
         				 <span class="glyphicon glyphicon-trash"></span>
     					   </a>    
     					     <a href="AdministrarPermisosSobrePizarra.jsp">
         				 <span class="glyphicon glyphicon-sunglasses"></span>
     					   </a>
					</td>
				</tr>
			</tbody>
		</table>
		
		<h4 style="text-align:center">Administradores</h4>
		<table class="table table-striped">
			<caption style="text-align:center">Administradores</caption>
			<thead>
				<tr >
					<th>Nombre de usuario</th>
					<th>Operaciones</th>
				</tr>
			</thead>
		
			<tbody>
				<tr id="filaA">
					<td>Ramiro Ongaro</td>
					<td><a href="#" onclick="eliminarAdministrador()">
         				 <span class="glyphicon glyphicon-trash"></span>
     					   </a> 
     					     <a href="#">
        				 <span class="glyphicon glyphicon-cog"> </span>
        				 </a>
     			   </td>
				</tr>
				<tr id="filaA">
					<td>Luciano Matsuo</td>
					<td><a href="#" onclick="eliminarAdministrador()">
         				 <span class="glyphicon glyphicon-trash"></span>
     					   </a> 
     					     <a href="#" >
        				 <span class="glyphicon glyphicon-cog"> </span>
        				 </a>
     				</td>
				</tr>
			</tbody>
		</table>
	
	
	
	</div>
	<%@include file="Footer.jsp" %>
</body>
</html>