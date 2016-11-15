<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
       <%@ page import="clases.Board"%>
       <%@ page import="clasesDAO.FactoryDAO"%>
       <%@ page import="clases.Note"%>
        <%@ page import="clases.User"%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>cartelera virtual informática unlp</title>

    <!-- Bootstrap Core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom CSS -->
    <link href="css/3-col-portfolio.css" rel="stylesheet">

    <!-- Bootstrap Core CSS -->
    <link href="css/timeLine.css" rel="stylesheet">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
</head>

<body>

 <%@ include file="../jsps/Header.jsp" %>
 
 

<% Board pizarraContenedora=(Board)session.getAttribute("pizarra"); %>
<%if (session.getAttribute("pathActual")==null || pizarraContenedora==null){ %>
    <%response.sendRedirect("Home"); %>
<%}%>


    <!-- Page Content -->
    <div class="container">
    
  
     
        <!-- Page Header -->
        <div class="row">
            <div class="col-lg-12">
            <!--  LO COMENTE EL H1!!!!!!!!!! -->
                <%-- - <h1 class="page-header"> <% out.print(" "+pizarraContenedora.getUbicacionActual()); %>         
                    <!-- <small> <% out.print(" "+pizarraContenedora.getPath()); %> </small>     -->           
                </h1> --%>
                  <small>
                    <ol class="breadcrumb">
  					<li><a href="Home">Home</a></li>
  					<li><a href="Materias">Materias</a></li>
  					<li><a href="Ofertas">Ofertas laborales</a></li>
  					<li class="active">Bootstrap 3</li>
  					</ol>
  					</small>
            </div>
        </div>
        <!-- /.row -->
      
        
      <%@ include file="../jsps/contenido.jsp" %>
         <%-- 	 <jsp:include page="../jsps/contenido.jsp" flush="true" />--%>
    
       <!--  <hr> -->
        <hr>

        <!-- Footer -->
        <!-- <footer>
            <div class="row">
                <div class="col-lg-12">
                    <p>Copyright &copy; Your Website 2014</p>
                </div>
            </div>
            /.row
        </footer> -->
        <%@include file="/jsps/Footer.jsp" %>

    </div>
    <!-- /.container -->

    <!-- jQuery -->
    <script src="js/jquery.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="js/bootstrap.min.js"></script>

</body>

</html>
