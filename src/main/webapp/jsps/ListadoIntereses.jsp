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



<!-- Page Content -->
    <div class="container">
     <div id="output"></div>
    
<h1 style="text-align:center"> Listado intereses</h1>
 
<table class="table table-striped">
  <thead>
    <tr>
      <th>Pizarra</th>
      <th>Estado</th>
      <th>Operaciones</th>
    </tr>
  </thead>
  <tbody>
    <tr id="fila">
      <td>Materias</td>
      <td> Interesa</td>
       <td> 
      
         <div>  
            
            <a href="#">
          <span class="glyphicon glyphicon-eye-open"></span>
        </a>
         </div>
      </td>
    </tr>
    <tr id="fila">
      <td>Ofertas laborales</td>
      <td>Interesa</td>
       <td> 
        
       
        <div>
            <a href="#">
          <span class="glyphicon glyphicon-eye-open"></span>
        </a>
        </div>
      </td>
    </tr>
    <tr id="fila">
      <td>Otros</td>
      <td> No interesa</td>
      <td> 
        
           <div>
           <a href="#">
          <span class="glyphicon glyphicon-eye-close"></span>
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