<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="es">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario alta publicacion</title>
 <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
 
<% String idPizarra=(String)session.getAttribute("idPizarra"); %>

<form class="form-horizontal" action="../agregarPublicacion" method="post"> <!--  supongo que este servlet (AgregarPublicacion) y vistas usa admin, publicador y profesor, el filtro controla esos permisos y deja pasar :) -->
    <input type="hidden" id="idPizarra" name="idPizarra" value=<%=idPizarra %> required readonly>
     <div class="form-group">
         <label for="titulo" class="control-label col-xs-2">Titulo:</label>
         <div class="col-xs-10">
             <input type="text" id="titulo" name="titulo" class="form-control" placeholder="Titulo" required>
             <span class="help-block">Título de la publicación</span>
         </div>
     </div>
     <div class="form-group">
         <label for="descripcion" class="control-label col-xs-2">Descripción:</label>
         <div class="col-xs-10">
             <input type="text" id="descripcion"  name="descripcion" class="form-control" placeholder="Descripción de la publicaicón" required>
             <span class="help-block">Breve resumen sobre lo que trata la publicación</span>
         </div>
     </div>
     
      <div class="form-group">
         <label for="texto" class="control-label col-xs-2">Texto:</label>
         <div class="col-xs-10">
             <!-- <input type="text" name="texto" id="texto" class="form-control" placeholder="Texto de la publicaicón"> -->
             <textarea name="texto" cols="40" rows="5" placeholder="Texto de la publicaicón"  required></textarea> <!--  voy a probar esto que parece mejor... -->
         </div>
     </div>
      <div class="form-group">
         <div class="col-xs-10">
            <input type="checkbox" id="comentarios" name="comentarios" value="1"> Deseo que se pueda comentar en esta publicación 
         </div>
     </div>
     
     
      <div class="form-group">
         <div class="col-xs-offset-2 col-xs-10">
             <button type="submit" class="btn btn-primary">Alta publicación</button>
         </div>
     </div>
</form>

<%@include file="Footer.jsp" %>
</body>
</html>


