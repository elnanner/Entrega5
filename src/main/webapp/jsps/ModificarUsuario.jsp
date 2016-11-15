<!DOCTYPE html>
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
    
    <title>Modificar Usuario</title>
</head>

<body>

<%@ include file="Header.jsp" %>
<h1 style="text-align:center"> Modificar Usuario</h1>

<div class="container">
	<form action="#" method="post">
		<div class="form-group">	
			<label for="tipoUsuario">Tipo de Usuario: </label>
			<select>
			  
			  <option  selected value="adm" id="adm" >Administrador</option>
			  <option  value="pub" id="pub" >Publicador</option>
			</select>
			
		</div>	
		<div class="form-group">
			<label for="name">Nombre Completo (Usuario o Empresa):</label>
			<input class="form-control" placeholder="Ingrese Nombre" type="text" id="name" name="name" value="Ramiro Ongaro" required>
		</div>
		<div class="form-group">	
			<label for="descrip">Nombre de Usuario:</label>
			<input type="text"  class="form-control" id="usuario" placeholder="Nombre de usuario"  name="usuario" value="rama64" required>
			 
		</div>	
		<div class="form-group">	
			<label for="descrip">Contrase&ntilde;a:</label>
			<input type="password"  class="form-control" id="password1" placeholder="Aqu&iacute su Contrase&ntildea"  name="password1" value="123456" required>
			 
		</div>	
		<div class="form-group">	
			<label for="descrip">Repetir Contrase&ntilde;a:</label>
			<input type="password"  class="form-control" id="password2" placeholder="Aqu&iacute su Contrase&ntildea"  name="password2" value="123456" required>
			 
		</div>	
	
	<button type="submit" class="btn btn-success">Modificar Usuario</button>
	</form>
</div>

<%@include file="Footer.jsp" %>
</body>

</html>