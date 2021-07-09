<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, productos.*" %> 
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
   
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista</title>

<style type="text/css">
.cabecera{
	font-size:1.2em;
	font-weight:bold;
	color:#ffffff;
	background-color: #08088A;
}

.fila{
	text-align:center;
	background-color:#5882fa;
	
}

</style>
</head>

<%
//obteniiendo lista de prodcutos

List<Producto> losProdcutos = (List<Producto>) request.getAttribute("LISTAPRODUCTOS");
%>

<body>


<table>
<tr>
<td class="cabecera">CODIGO ARTICULO</td>
<td class="cabecera">SECCION</td>
<td class="cabecera">NOMBRE ARTICULO</td>
<td class="cabecera">FECHA</td>
<td class="cabecera">PRECIO</td>
<td class="cabecera">IMPORTADO</td>
<td class="cabecera">PAIS DE ORIGEN</td>

</tr>

<c:forEach var="temp" items="${LISTAPRODUCTOS}">
<tr>
<td class="fila">${temp.cArticulo}</td>
<td class="fila">${temp.seccion}</td>
<td class="fila">${temp.nArticulo}</td>
<td class="fila">${temp.precio}</td>
<td class="fila">${temp.fecha}</td>
<td class="fila">${temp.importado}</td>
<td class="fila">${temp.pOrigen}</td>
</tr>

</c:forEach>

</table>
</body>
</html>