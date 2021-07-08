package productos;

import java.util.ArrayList;

import javax.sql.DataSource;

import java.sql.Connection;
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
			productos.add(new Producto(rs.getString(0), rs.getString(1), rs.getDouble(2), rs.getDate(3),
					rs.getString(4), rs.getString(5)));
		}

		return productos;
	}

}
