<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="clases.Board"%> 
 <%@ page import="clases.User"%>
   <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">    
<%Board cartelera= (Board)session.getAttribute("elementoActual"); %>    


<a href=<%="ver/"+cartelera.getUrl()%>> 
	<img class="img-responsive" src=<%="./images/cartelera.jpg" %> width="700" height="400\" alt="">
	<%-- <img class="img-responsive" src=<%=cartelera.getPathImage() %> width="700" height="400\" alt="">--%>
</a>   
<h3>
	<a href=<%="ver/"+cartelera.getUrl()%>> <%=cartelera.getName()%></a> 
	
</h3>
<p><%=cartelera.getDescription() %></p>    
 
 <%User user=(User) session.getAttribute("user"); %>
	<% if(user!=null && user.getType().equals("alu")){ %>   <!--  agregar que no este interesado al if -->
		<br>
		<!-- <a href="Interes.jsp"> me interesa, quiero recibir notificaciones </a> -->
		
		<form method="post" action="#"> <!--  notificar interes .jsp o algo asi -->
			<input type="hidden" value=<%=cartelera.getId() %> required readonly> 
			<input type="submit" class="btn-link" value="me interesa, quiero recibir notificaciones"> 
		</form>
     <%} %>
     
     <% if(user!=null &&  (user.getType().equals("pub")|| user.getType().equals("adm")  || user.getType().equals("doc")     ) ){ %>  
		<br>
		 <!--  <a href="ModificarCartelera.jsp">
          <span class="glyphicon glyphicon-file"></span></a>-->
          
		
		<form method="post" action="redirectFormAltaPublicacion">  <!--  supongo que este servlet (AgregarPublicacion) y vistas usa admin, publicador y profesor, el filtro controla esos permisos y deja pasar :) -->
			<input type="hidden" name="idPizarra" id="idPizarra" value=<%=cartelera.getId() %> required readonly>
			
			 <button  type="submit" class="btn btn-primary"> agregar publicaci&oacute;n  <span class="glyphicon glyphicon-file"> </span></button>
		</form> 
		
     <%} %>
