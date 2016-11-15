<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="clases.Board"%>   
<%@ page import="clasesDAO.FactoryDAO"%>
<%@ page import="org.hibernate.collection.internal.PersistentBag"%>

<!--  new --> <%@ page import="clases.Note"%>   
    <%System.out.println("pizarras CONTENIDOOO "); %>
<% Board pizarra=(Board)session.getAttribute("pizarra"); %>
<%System.out.println("post board!"); %>
<% PersistentBag notas=(PersistentBag)pizarra.getNoteList();%>
<%System.out.println("medio arrays!"); %>
<% PersistentBag pizarras=(PersistentBag)pizarra.getBoardList();%> <!--  LOS GETS ME DABAN COLLECTION OJO... -->
<%System.out.println("pizarras "+pizarras); %>
<!-- LO DEJO EN TRUE PERO ES UN TEMA DE LA NOTA, NO DE LA PIZARRA COMO DECIA ENUNCIADO --> <%session.setAttribute("permiteComentar",true);%><%--<%session.setAttribute("permiteComentar",pizarra.); --%>
<div class="row">
<!--  -->

<% Board pizarraActual=null; %>
<%for(int i=0; i<pizarras.size();i++){%>
			<% pizarraActual=(Board)pizarras.get(i); %>
			<%session.setAttribute("elementoActual",pizarraActual); %>
			<div class="col-md-4 portfolio-item">
            	<%-- <% String vista=pizarraActual.getVista(); --%>  <!--antes era asi ahora lo hardcodeo -->
            	<% String vista="pizarraSimple"; %>
            	 <%@ include file="VisualizacionPizarra.jsp" %>
            	 <%-- <jsp:include page="VisualizacionPizarra.jsp" flush="true" />--%>   
  </div>              
<%}%>  

<% Note notaActual=null; %>
<%for(int i=0; i<notas.size();i++){%>
			<% notaActual=(Note)notas.get(i); %>
			<%session.setAttribute("elementoActual",notaActual); %>
			<div class="col-md-4 portfolio-item">
            	<%--<% String vista=notaActual.getVista(); --%>  <!--  antes era asi -->
            	<% String vista="notaSimple"; %>
                <%@ include file="VisualizacionNota.jsp" %>
            	<%-- <jsp:include page="./VisualizacionNota.jsp" flush="true" />--%>      
  </div>                 
<%}%>            
           
</div>