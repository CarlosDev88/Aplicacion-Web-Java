<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ page import="java.util.*, productos.*" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Vista</title>
</head>

<%
//obteniiendo lista de prodcutos

List<Producto> losProdcutos = (List<Producto>) request.getAttribute("LISTAPRODUCTOS");
%>

<body>
<%= losProdcutos %>
</body>
</html>