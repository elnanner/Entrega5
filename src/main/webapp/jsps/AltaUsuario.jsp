<!DOCTYPE html>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.ArrayList"%>
<%@page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>
<html lang="es">
<head>
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
    
    <title>Alta Usuario</title>
</head>

<body>


<%@ include file="Header.jsp" %>
<h1 style="text-align:center"> Alta Usuario</h1>

<% String mensajeError=(String)session.getAttribute("mensajeError"); 
%>
<% if(mensajeError!=null && mensajeError.equals("") ){ %>
         <div class ='alert alert-success'><p style='text-align:center'>Se ha Ingresado Correctamente al Usuario</p></div>
<%}else{ %>
        <%if (mensajeError!=null){ %>
       		<div class ='alert alert-danger'><p style='text-align:center'>
       		<%-- <%for (String valor: mensajeError.split("-")) {%> --%>
                <%=mensajeError%><br>
           <% %></p></div>  
       	<%} %>
<% } %>

<div class="container">
	<form action="AltaUsuario" method="post">
		<div class="form-group">	
			<label for="tipoUsuario">Tipo de Usuario: </label>
			<select name="tipoUsuario">
			<option selected value="">Elegir tipo</option>
			  <option value="adm" id="adm" >Administrador</option>
			  <option value="pub" id="pub" >Publicador</option>
			   <option value="alu" id="alu" >Alumno</option>
			    <option value="pro" id="pro" >Profesor</option>
			     <!--   <option value="sec" id="sec" >Secretario</option>-->
			</select>
			 
		</div>	
		<!--  <div class="form-group">
			<label for="name">Nombre Completo (Usuario o Empresa):</label>
			<input class="form-control" placeholder="Ingrese Nombre" type="text" id="name" name="name" required>
		</div>-->
		<div class="form-group">	
			<label for="descrip">Nombre de Usuario:</label>
			<input type="text"  class="form-control" id="usuario" placeholder="Nombre de usuario"  name="usuario" >
			 
		</div>	
		<div class="form-group">	
			<label for="descrip">Contrase&ntilde;a:</label>
			<input type="password"  class="form-control" id="password1" placeholder="Aqu&iacute; su Contrase&ntilde;a"  name="password1" >
			 
		</div>	
		<div class="form-group">	
			<label for="descrip">Repetir Contrase&ntilde;a:</label>
			<input type="password"  class="form-control" id="password2" placeholder="Aqu&iacute; su Contrase&ntilde;a"  name="password2">
			 
		</div>	
		
		<div class="form-group">
			<label for="email">Email:</label>
			<input class="form-control" placeholder="Ingrese mail" type="email" id="email" name="email" >
		</div>
	
	<button type="submit" class="btn btn-success">Registrar Usuario</button>
	</form>
</div>

<%@include file="Footer.jsp" %>
</body>

</html>