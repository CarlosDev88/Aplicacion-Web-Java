package productos;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.*;

/**
 * Servlet implementation class prueba
 */
@WebServlet("/prueba")
public class prueba extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Resource(name="jdbc/Productos")
	private DataSource mipool;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public prueba() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		PrintWriter salida = response.getWriter();
		response.setContentType("text/plain");
		
		//coneccion con la base de datos
		
		Connection miConexion=null;
		Statement miStatement=null;
		ResultSet rs = null;
		
		try {
			miConexion=mipool.getConnection();
			
			String consulta = "SELECT * FROM productos";
			miStatement = miConexion.createStatement();
			rs=miStatement.executeQuery(consulta);
			
			while(rs.next()) {
				String nArt = rs.getString(3);
				salida.println(nArt);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
