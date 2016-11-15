<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date" %>
<%SimpleDateFormat datef = new SimpleDateFormat("yyyy"); %>
<footer class="bs-docs-footer">

	<div class="container">
		<p>
			Cartelera Virtual Inform&aacute;tica UNLP &copy;
			<%=datef.format(new Date())%></p>
		<ul class="">
			<li><a href="#">Contacto</a></li>
			<li><a href="#">About</a></li>
		</ul>
	</div>

</footer>