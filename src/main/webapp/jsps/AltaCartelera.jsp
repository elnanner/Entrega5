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
    
    <title>Alta cartelera</title>
</head>

<body>

<%@ include file="Header.jsp" %>
<h1 style="text-align:center"> Alta Cartelera</h1>

<div class="container">
	<form action="#" method="post">
	
		<div class="form-group">
			<label for="name">Name:</label>
			<input class="form-control" placeholder="Ingrese Nombre Cartelera" type="text" id="name" name="name" required>
		</div>
		<div class="form-group">	
			<label for="descrip">Descripción:</label>
			<input type="text"  class="form-control" id="descrip" placeholder="Breve descripción de la cartelera"  name="descripcion" required>
			 
		</div>
		<p>La cartelera "padre" la tiene del listado anterior (al cual le diste agregar cartelera)</p>
	
	<button type="submit" class="btn btn-success">Publicar</button>
	</form>
</div>

<%@include file="Footer.jsp" %>
</body>

</html>