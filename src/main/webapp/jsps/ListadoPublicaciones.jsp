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
    
    <title>Listado Publicaciones</title>
</head>

<body>
<script>
function eliminar(){
	/*lo queres mas lindo???*/
	$("#fila").remove();
	$("#output").removeClass(' alert alert-success');
	//alert($("#a").data("data-custom-value"));
	$("#output").addClass("alert alert-danger animated fadeInUp").html("borrar cartelera "); //buscar como sacar valor del a
}; 
</script>	
<%@ include file="Header.jsp" %>

<!-- Page Content -->
    <div class="container">
    <div id="output"></div>
<h1 style="text-align:center"> Listado Publicaciones</h1>

<div> 
  	<a class="btn btn-primary" href="AltaPublicacion.jsp"><span class="glyphicon glyphicon-plus"> </span>Nueva Publicaci&oacute;n</a>
</div>
 
<table class="table table-striped">
  <thead>
    <tr>
      <th>Publicaci&oacute;n</th>
      <th>Descripci&oacute;n</th>
      <th>Operaciones</th>
      
    </tr>
  </thead>
  <tbody>
    <tr id="fila">
      <td>Publicacion 1</td>
      <td>Información sobre cursadas...</td>
       <td> 
        <div>  
         </div>
          <a href="../jsps/ModificarPublicacion.jsp">
          <span class="glyphicon glyphicon-cog"></span>
        </a>
         <div>  
           <a href="#" onclick="eliminar()">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
         </div>
      </td>
    </tr>
    <tr id="fila">
      <td>Publicacion 2 </td>
      <td>Información sobre finales...</td>
       <td> 
        <div>  
         </div>
          <a href="../jsps/ModificarPublicacion.jsp">
          <span class="glyphicon glyphicon-cog"></span>
        </a>
         <div>  
           <a href="#" onclick="eliminar()">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
         </div>
      </td>
    </tr>
    <tr id="fila">
      <td>Publicacion 3</td>
      <td>Información sobre eventos...</td>
       <td> 
        <div>  
         </div>
          <a href="../jsps/ModificarPublicacion.jsp">
          <span class="glyphicon glyphicon-cog"></span>
        </a>
         <div>  
           <a href="#" onclick="eliminar()">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
         </div>
      </td>
    </tr>
  </tbody>
</table>
</div>
<%@include file="Footer.jsp" %>
</body>

</html>