<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insertar Producto</title>
</head>
<body>

<h2 style="text-align:center">Incertar productos</h3>

<div style="margin-left:500px">

<form name="forml" method="get" action="ControladorProductos">
<input type="hidden" name="instruccion" value="insertarBBDD">

<table>

<tr>
<td>Codigo Articulo</td>
<td> <input type="text" name="CArt" id="CArt"></td>
</tr>

<tr>
<td>Seccion</td>
<td> <input type="text" name="seccion" id="seccion"></td>
</tr>

<tr>
<td>Nombre Articulo</td>
<td> <input type="text" name="NArt" id="NArt"></td>
</tr>

<tr>
<td>Fecha</td>
<td> <input type="text" name="fecha" id="fecha"></td>
</tr>

<tr>
<td>Precio</td>
<td> <input type="text" name="precio" id="precio"></td>
</tr>

<tr>
<td>Importado</td>
<td> <input type="text" name="impor" id="impor"></td>
</tr>

<tr>
<td>Pais Origen</td>
<td> <input type="text" name="POri" id="POri"></td>
</tr>

<tr>
<td><input type="submit" name="envio" id="envio" Value="Enviar"></td>
<td><input type="reset" name="borrar" id="borrar" Value="Reestablecer"></td>
</tr>

</table>

</form>

</div>

</body>
</html>