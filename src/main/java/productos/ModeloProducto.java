package productos;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;

public class ModeloProducto {
	private DataSource origenDatos;

	public ModeloProducto(DataSource origenDatos) {
		this.origenDatos = origenDatos;
	}

	public List<Producto> getProductos() throws Exception {

		List<Producto> productos = new ArrayList<>();
		Connection miConexion = null;
		Statement miStatement = null;
		ResultSet rs = null;

		miConexion = origenDatos.getConnection();// establecer conexion a la DDBB

		String consulta = "SELECT * FROM productos";
		miStatement = miConexion.createStatement();
		rs = miStatement.executeQuery(consulta);

		while (rs.next()) {

			String cArticulo = rs.getString(1);
			String seccion = rs.getString(2);
			String nArticulo = rs.getString(3);
			double precio = rs.getDouble(4);
			Date fecha = rs.getDate(5);
			String importado = rs.getString(6);
			String pOrigen = rs.getString(7);

			productos.add(new Producto(cArticulo, seccion, nArticulo, precio, fecha, importado, pOrigen));
		}

		return productos;
	}

	public void agregarElNuevoProducto(Producto nuevoProducto) {
		Connection miConexion = null;
		PreparedStatement miStatement = null;

		try {

			miConexion = origenDatos.getConnection();

			String consulta = "INSERT INTO productos (CODIGOARTICULO, SECCION, NOMBREARTICULO, PRECIO, FECHA, IMPORTADO, PAISDEORIGEN, FOTO) VALUES (?,?,?,?,?,?,?,'null')";

			miStatement = miConexion.prepareStatement(consulta);
			
			miStatement.setString(1, nuevoProducto.getcArticulo());
			miStatement.setString(2, nuevoProducto.getSeccion());
			miStatement.setString(3, nuevoProducto.getnArticulo());
			miStatement.setDouble(4, nuevoProducto.getPrecio());

			java.util.Date utilDate = nuevoProducto.getFecha();
			java.sql.Date fechaConvertida = new java.sql.Date(utilDate.getTime());
			miStatement.setDate(5, fechaConvertida);

			miStatement.setString(6, nuevoProducto.getImportado());
			miStatement.setString(7, nuevoProducto.getpOrigen());
			
			
			miStatement.execute();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
