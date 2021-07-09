package productos;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

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

	
	public ControladorProductos() {
		super();
		// TODO Auto-generated constructor stub
	}


	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//leer el parametro del formulario
		String elComando = request.getParameter("instruccion");
		
		if(elComando==null) {
			elComando="listar";
		}
		
		switch (elComando) {
		case "listar": {
			obtenerProductos(request,response);
		break;
		}
		
		case "insertarBBDD": {
			agregarProductos(request,response);
		break;
		}
		
		case "cargar": {
			try {
				cargaProductos(request,response);
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		break;
		}
		
		case "actualizarBBDD": {
			try {
				actualizarProductos(request,response);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		break;
		}
		
		default:
			obtenerProductos(request,response);
		}
		
	}

	private void actualizarProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String CodArticulo = request.getParameter("CArt");
		String Seccion = request.getParameter("seccion");
		String Nomarticulo = request.getParameter("NArt");
		
		SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
		Date Fecha= null;
		 try {
			Fecha = formatoFecha.parse(request.getParameter("fecha"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			 
		 
		double Precio = Double.parseDouble(request.getParameter("precio"));			
		String Importado = request.getParameter("impor");
		String POrigen = request.getParameter("POri");
		
		 Producto ProductoActualizado = new Producto(CodArticulo, Seccion, Nomarticulo, Precio, Fecha, Importado, POrigen);
		 
		 modeloProducto.actualizarProducto(ProductoActualizado);
		 obtenerProductos(request, response);
		
	}


	private void cargaProductos(HttpServletRequest request, HttpServletResponse response) throws Exception{
		String CodArticulo = request.getParameter("CArticulo");
		
		Producto elProdcuto = modeloProducto.getProducto(CodArticulo);
		
		request.setAttribute("PorductoActualizar",elProdcuto);
		
		RequestDispatcher dispacher = request.getRequestDispatcher("/actualizarProducto.jsp");		
		dispacher.forward(request, response);
	}


	private void agregarProductos(HttpServletRequest request, HttpServletResponse response) {
			String CodArticulo = request.getParameter("CArt");
			String Seccion = request.getParameter("seccion");
			String Nomarticulo = request.getParameter("NArt");
			
			SimpleDateFormat formatoFecha = new SimpleDateFormat("yyyy-MM-dd");
			Date Fecha= null;
			 try {
				Fecha = formatoFecha.parse(request.getParameter("fecha"));
			} catch (ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}			 
			 
			double Precio = Double.parseDouble(request.getParameter("precio"));			
			String Importado = request.getParameter("impor");
			String POrigen = request.getParameter("POri");
			
			 Producto nuevoProducto = new Producto(CodArticulo, Seccion, Nomarticulo, Precio, Fecha, Importado, POrigen);
			 
			 modeloProducto.agregarElNuevoProducto(nuevoProducto);
			 
			 obtenerProductos(request, response);
		
	}


	private void obtenerProductos(HttpServletRequest request, HttpServletResponse response) {
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
