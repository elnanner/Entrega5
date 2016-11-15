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
    
    <title>Configuraci&oacute;n</title>
    <style>
    	#midiv{
    		border:2px solid black;
    		margin:10px;
    		width:250px;
    		height: 250px;
    	}
    	
    	img{
    		height:33%;
    		width:33%;
    		
    		
    	}
    
    </style>
</head>

<body>
<script>

    	function modo(){
    		if($("#toggle").text()=="Finalizar Configuración"){
    			$("#default").remove();
    			$("#template-div").remove();
    			$("#toggle").text("Editar Página");
    		}else
    			if($("#toggle").text()=="Editar Página"){
    				
		    		$("#btn-toggle").append('<div id="default"></div)');
		    		$("#toggle").text("Finalizar Configuración");
		    		$("#default").append('<button id="" class="" onclick="toggleDefault()">Configuración por defecto</button>');
		    		
		    		
    		}
    	};
    	function toggleDefault(){
    		midiv = '<div class="col-md-4 portfolio-item"></div>';
    		for (var i = 0; i < 3; i++) {
    			
				$(".template-div").append('<div id="midiv" class="col-md-4 portfolio-item"></div>');
			}
    		$("#default").remove();
    		$("#toggle").text("Editar Página"); 
    	};
    
    </script>
<%@ include file="Header.jsp" %>
<h1 style="text-align:center"> Configuraci&oacute;n usuario </h1>

<div class="container">
	
	<form action="#" method="post">
	  <h3>2x2</h3>
	  <div class="row"> <input type="radio" name="gender" value="2x2" checked><img src="<%=request.getContextPath()+"/images/2x2.jpg"%>" alt="" /></div>	
	  
	  <h3>2x3</h3>
	  <div class="row"><input type="radio" name="gender" value="2x3"> <img src="<%=request.getContextPath()+"/images/2x3.jpg"%>" alt="" /></div>
	  
	  <h3>Default</h3>
	  <div class="row"><input type="radio" name="gender" value="3x1"><img src="<%=request.getContextPath()+"/images/3x1.jpg"%>" alt="" /></div>
	  <button class="submit btn btn-success">Aplicar Configuraci&oacute;n</button>
	  </form>
</div>

	<%@include file="Footer.jsp" %>

</body>

</html>