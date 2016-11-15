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
    
    <title>Modificar Publicaci&oacute;n</title>
</head>
<body>
	<h1 style="text-align:center">Modificar Publicaci&oacute;n</h1>

<%@ include file="Header.jsp" %>

	<div class="container">
	<!-- Formulario alta de publicación -->
	<form action="ListadoPublicaciones.jsp" method="GET">
	  <div class="form-group">
	    <label for="titulo">T&iacute;tulo </label>
	    <input class="form-control" type="text" id="titulo">
	    <p>T&iacute;tulo de la publicaci&oacute;n</p>
	  </div>
	  
	  <div class="form-group">
	    <label for="descripcion">Descripci&oacute;n </label>
	    <input class="form-control" type="text" id="descripcion">
	    <p>Descripci&oacuten de la publicaci&oacute;n</p>
	  </div>
	  
  	  <div class="form-group">
  	   <label for="texto">Texto</label>
	    <textarea id="texto" class="form-control" rows="6" placeholder="texto de la publicacion"></textarea>
	  </div>
	  
	  <div class="form-group">
	    <label for="inputfile">Subir Archivo</label>
	    <input class="form-control" type="file" id="inputfile">
	    
	  </div>
	  <div class="checkbox">
    <label>
      <input type="checkbox" value="1"> Deseo que se pueda comentar en esta publicaci&oacute;n
    </label>
  </div>
  	<button type="submit" class="btn btn-success">Publicar</button>
	</form>
	</div>
	<%@include file="Footer.jsp" %>
</body>
</html>