<!-- <li><a href="#">operaciones docente</a></li> -->

<li class="dropdown"><a href="#" class="dropdown-toggle"
	data-toggle="dropdown" role="button" aria-haspopup="true"
	aria-expanded="false">Operaciones Docente <span class="caret"></span></a>
	<ul class="dropdown-menu">
		<li><a href="<%=request.getContextPath()+"/jsps/ListadoPublicaciones.jsp"%>">Aqu&iacute; publicaciones</a></li>
		<li><a href="<%=request.getContextPath()+"/jsps/ListadoAlumnos.jsp"%>">Aqu&iacute; Ver lista alumnos</a></li>
		<li role="separator" class="divider"></li>
		<li><a href="<%=request.getContextPath()+"/jsps/AltaPublicacion.jsp"%>">Alta publicacion</a></li>
		<li><a href="#">Aqu&iacute; otros...</a></li>
	</ul></li>