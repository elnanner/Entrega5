<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login cartelera</title>
  <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
 <link href="../css/login.css" rel="stylesheet">
  <!--  <script src="../js/login.js"></script> --> <!--  era el funcionameitno original del ejemplo http://bootsnipp.com/snippets/featured/login-form-layered -->
   <!-- Bootstrap Core JavaScript -->
    <script src="../js/bootstrap.min.js"></script>
    
</head>
<body>

<script>
function error(){
	$("#output").removeClass(' alert alert-success');
	$("#output").addClass("alert alert-danger animated fadeInUp").html("ingresó mal el usuario o contraseña =( ");
	
	//document.getElementById('output').addClass("alert alert-danger animated fadeInUp").html("ingreso mal el usario o contraseña =() ");
	//var d = document.getElementById('output');
	//d.className += " alert alert-danger animated fadeInUp";
	//d.value += "ingreso mal el usuario y/o contraseña =( ";
};
</script>


<div class="container">
	<div class="login-container">
		 <div id="output"></div>
		 <% if(session.getAttribute("error")=="error"){ %>
		      <script> error();</script>
		 <%} %>
	 	<div class="avatar"></div>
		<div class="form-box">
			<form action="../Login" method="post">
        		<input name="user" type="text" placeholder="username" autofocus required>
          	  	<input type="password" placeholder="password">
          		<button class="btn btn-info btn-block login" type="submit">Login</button>
      	 	</form>
    	</div>
 	</div>
</div>


<div>
  <a class="btn btn-info btn-block" href="../Home">ir al home</a>
</div>

</body>
</html>