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
    
    <title>Listado carteleras</title>
</head>

<body>

<%@ include file="Header.jsp" %>
<script>
function eliminar(){
	/*lo queres mas lindo???*/
	$("#fila").remove();
	$("#output").removeClass(' alert alert-success');
	//alert($("#a").data("data-custom-value"));
	$("#output").addClass("alert alert-danger animated fadeInUp").html("borrar cartelera "); //buscar como sacar valor del a
}; 
</script>


<!-- Page Content -->
    <div class="container">
     <div id="output"></div>
    
<h1 style="text-align:center"> Listado carteleras</h1>
 
<table class="table table-striped">
  <thead>
    <tr>
      <th>Nombre</th>
      <th>Descripci�n</th>
      <th>Operaciones</th>
    </tr>
  </thead>
  <tbody>
    <tr id="fila">
      <td>Materias</td>
      <td>Informaci�n sobre materias</td>
       <td> 
       <div>
          <a href="AltaCartelera.jsp">
          <span class="glyphicon glyphicon-plus"></span>
        </a>
         </div>
        <div>  
         </div>
          <a href="ModificarCartelera.jsp">
          <span class="glyphicon glyphicon-cog"></span>
        </a>
         <div>  
            
           <a href="#" onclick="eliminar()" data-custom-value="Materias">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
         </div>
      </td>
    </tr>
    <tr id="fila">
      <td>Ofertas laborales</td>
      <td>Informaci�n sobre ofertas laborales</td>
       <td> 
          <div>
          <a href="AltaCartelera.jsp">
          <span class="glyphicon glyphicon-plus"></span>
        </a>
        </div>
        <div>  
          <a href="ModificarCartelera.jsp">
          <span class="glyphicon glyphicon-cog"></span>
        </a>
        </div>
        <div>
           <a href="#" onclick="eliminar()" data-custom-value="Ofertas">
          <span class="glyphicon glyphicon-trash"></span>
        </a>
        </div>
      </td>
    </tr>
    <tr id="fila">
      <td>Otros</td>
      <td>Informaci�n que no se encuentra en el resto de las carteleras</td>
      <td> 
      <div>
          <a href="AltaCartelera.jsp">
          <span class="glyphicon glyphicon-plus"></span>
        </a>       
          </div>
          <div>
          <a href="ModificarCartelera.jsp">
          <span class="glyphicon glyphicon-cog"></span>
        </a>
           </div>
           <div>
           <a href="#" onclick="eliminar()" data-custom-value="Otros">
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