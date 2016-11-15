<%@ page import="clases.User"%>
  <!-- Bootstrap Core CSS -->
    <link href="../css/bootstrap.min.css" rel="stylesheet">
<% String[] pathSplit=request.getRequestURL().toString().split(request.getRequestURI());%>
<%String pathRoot=pathSplit[0]+request.getContextPath(); %>	
 <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
<ul class="nav navbar-nav">						
<li><a href="<%=pathRoot%>">Home</a></li> <!--  todos tienen el link el home -->
<%User usuario=(User) session.getAttribute("user"); %>              
                    <%if(usuario!=null){ %>	
                    	<!--  -<li ><a href="#"><%=  usuario.getName() %></a></li>
                    	<li class="pull-right"><a href="<%=pathRoot %>/Logout">Logout</a></li>
                    	->
                    	<% String typeUser= usuario.getType();%> <%-- hablar si deja switch o poner en el usuario el path...(a corto plazo mejor switch mepa (no jerarquia users por ahora)  --%>
                    	<%switch(typeUser){ 
                     	   case "adm":%><%@include file="/jspsMenuUsers/adm.jsp"%><%
                      		  break; 
                      	   case "doc":%><%@include file="/jspsMenuUsers/doc.jsp"%><%
                       	   		break; 
                      	   case "alu":%><%@include file="/jspsMenuUsers/alu.jsp"%><%
                           		break; 
                      	   case "pub":%><%@include file="/jspsMenuUsers/pub.jsp"%><%
                            	   	break; 
                       	   default :%> <!-- default no agrega nada al menu(no es de ningun tipo...) --><%
                       	        System.out.println("no es de ningun tipo "+typeUser);
                        		break; 
                    	}  %>                       
                    <% }else{%>
							<li><a href="<%=pathRoot %>/Login">Login</a></li>
						<%} %>
</ul>



<ul class="nav navbar-nav navbar-right">						
                    <%if(usuario!=null){ %>	
                    	<li ><a href="#"><%=  usuario.getName() %></a></li>
                    	<li><a href="<%=pathRoot %>/Logout">Logout</a></li>
                    	<li> <a href="<%=request.getContextPath()+"/jsps/ConfigTemplateUser.jsp"%>"> <span class="glyphicon glyphicon-edit"></span></a>
                    	<% }%>                                      
</ul>
</div>
<!--  nota de rama para orden elementos despues http://www.bootply.com/SlF4kleQfG  -->


