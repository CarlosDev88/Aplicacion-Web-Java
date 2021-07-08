package productos;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class ControladorProductos
 */
@WebServlet("/ControladorProductos")
public class ControladorProductos extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ModeloProducto modeloProducto;
	@Resource(name = "jdbc/Productos")
	private DataSource mipool;

	@Override
	public void init() throws ServletException {
		// TODO Auto-generated method stub
		super.init();

		try {

			modeloProducto = new ModeloProducto(mipool);

		} catch (Exception e) {
			e.printStackTrace();

		}
	}

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ControladorProductos() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		//obtener la lista de productos
		List<Producto> productos;
		try {
			productos = modeloProducto.getProductos();
			
			//agregar la lista de prodcutos al request
			request.setAttribute("LISTAPRODUCTOS", productos);
			
			//enviar los prodcutos a la vista
			RequestDispatcher dispacher = request.getRequestDispatcher("/ListaProdcutos.jsp");
			
			dispacher.forward(request, response);
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
	
		
	}

}
