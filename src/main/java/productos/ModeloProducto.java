package productos;

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

			String cArticulo = rs.getString(1);
			String seccion= rs.getString(2);
			String nArticulo= rs.getString(3);
			double precio= rs.getDouble(4);
			Date fecha= rs.getDate(5);
			String importado= rs.getString(6);
			String pOrigen= rs.getString(7);

			productos.add(new Producto(cArticulo, seccion, nArticulo, precio, fecha, importado, pOrigen));
		}

		return productos;
	}

}
