package modelo;

import java.util.Date;

public class Producto {
	private int id;
	private String codigo;
	private int cantidad;
	private Double precio;
	private Date caducidad;
	Seccion seccion;
	
	
	public Producto() {
		super();
	}
	public Producto(int id, String codigo, int cantidad, Double precio, Date caducidad, Seccion seccion) {
		super();
		this.id = id;
		this.codigo = codigo;
		this.cantidad = cantidad;
		this.precio = precio;
		this.caducidad = caducidad;
		this.seccion = seccion;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public Double getPrecio() {
		return precio;
	}
	public void setPrecio(Double precio) {
		this.precio = precio;
	}
	public Date getCaducidad() {
		return caducidad;
	}
	public void setCaducidad(Date caducidad) {
		this.caducidad = caducidad;
	}
	public Seccion getSeccion() {
		return seccion;
	}
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	@Override
	public String toString() {
		return "Producto [id=" + id + ", codigo=" + codigo + ", cantidad=" + cantidad + ", precio=" + precio
				+ ", caducidad=" + caducidad + ", seccion=" + seccion + "]";
	}
	
	
	

}
