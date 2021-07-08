package productos;

import java.util.Date;

public class Producto {
	private String cArticulo;
	private String seccion;
	private String nArticulo;
	private double precio;
	private Date fecha;
	private String importado;
	private String pOrigen;
	public Producto(String cArticulo, String seccion, String nArticulo, double precio, Date fecha, String importado,
			String pOrigen) {
		
		this.cArticulo = cArticulo;
		this.seccion = seccion;
		this.nArticulo = nArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pOrigen = pOrigen;
	}
	
	
	public Producto(String seccion, String nArticulo, double precio, Date fecha, String importado, String pOrigen) {
		
		this.seccion = seccion;
		this.nArticulo = nArticulo;
		this.precio = precio;
		this.fecha = fecha;
		this.importado = importado;
		this.pOrigen = pOrigen;
	}


	@Override
	public String toString() {
		return "Producto [cArticulo=" + cArticulo + ", seccion=" + seccion + ", nArticulo=" + nArticulo + ", precio="
				+ precio + ", fecha=" + fecha + ", importado=" + importado + ", pOrigen=" + pOrigen + "]";
	}


	public String getcArticulo() {
		return cArticulo;
	}
	public void setcArticulo(String cArticulo) {
		this.cArticulo = cArticulo;
	}
	public String getSeccion() {
		return seccion;
	}
	public void setSeccion(String seccion) {
		this.seccion = seccion;
	}
	public String getnArticulo() {
		return nArticulo;
	}
	public void setnArticulo(String nArticulo) {
		this.nArticulo = nArticulo;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getImportado() {
		return importado;
	}
	public void setImportado(String importado) {
		this.importado = importado;
	}
	public String getpOrigen() {
		return pOrigen;
	}
	public void setpOrigen(String pOrigen) {
		this.pOrigen = pOrigen;
	}
	
	
	
	
	
}
