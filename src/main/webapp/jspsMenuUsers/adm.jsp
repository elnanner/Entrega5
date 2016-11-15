<!-- <li><a href="#">operaciones admin</a></li> -->
<% String[] pathSplitADM=request.getRequestURL().toString().split(request.getRequestURI());%>
<%String pathRootADM=pathSplitADM[0]+request.getContextPath(); %>	

<li class="dropdown"><a href="#" class="dropdown-toggle"
	data-toggle="dropdown" role="button" aria-haspopup="true"
	aria-expanded="false">Operaciones Admin <span class="caret"></span></a>
	<ul class="dropdown-menu">
		<%-- <li><a href="<%=pathRootADM %>/jsps/ListadoCarteleras.jsp">Operaciones Cartelera(ABM)</a></li> --%>
		<li><a href="<%=request.getContextPath()+"/jsps/ListadoCarteleras.jsp"%>">Operaciones Cartelera(ABM)</a></li>
		<li><a href="<%=pathRootADM %>/jsps/ListadoPublicaciones.jsp"">Listado publicaciones</a></li>
		<li><a href="<%=pathRootADM %>/jsps/CrearTemplate.jsp">Crear template</a></li>
		<li><a href="<%=request.getContextPath()+"/jsps/ListadoUsuarios.jsp"%>">Listado Usuarios (BM)</a></li>
		<li><a href="<%=request.getContextPath()+"/jsps/AltaUsuario.jsp"%>">Alta usuarios</a></li>
		<li><a href="<%=request.getContextPath()+"/jsps/AltaPublicacion.jsp"%>">Alta publicacion</a></li>
		<li role="separator" class="divider"></li>
		<li><a href="#">Aqu&iacute; otros...</a></li>
	</ul></li>
	
	<!--  SOLO SE VE EN EL HOME! (NO CUANDO ENTRAMOS A ALTA DE CARTELERA) list, faltaba importar jquery ;)-->