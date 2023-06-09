package modelo;

import java.util.Date;

public class Producto {
	private int id;
	private String codigo;
	private String nombre;
	private int cantidad;
	private Double precio;
	private Date caducidad;
	private Seccion seccion;
	private Supermercado supermercado;
	
	public int getId() {
		return id;
	}
	
	
	
	public Producto(int id, String codigo, String nombre, int cantidad, Double precio, Date caducidad, Seccion seccion,
			Supermercado supermercado) {
		
		this.id = id;
		this.codigo = codigo;
		this.nombre = nombre;
		this.cantidad = cantidad;
		this.precio = precio;
		this.caducidad = caducidad;
		this.seccion = seccion;
		this.supermercado = supermercado;
	}

	

	public Producto() {
		super();
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
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
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
	public Supermercado getSupermercado() {
		return supermercado;
	}
	public void setSupermercado(Supermercado supermercado) {
		this.supermercado = supermercado;
	}
	
	

		

		

}
