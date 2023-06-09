package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloProducto extends Conector{
	PreparedStatement pst;
	
	public void eliminarProducto(String[]codigos) {
		conectar();
		try {
			pst =getCon().prepareStatement("DELETE FROM productos where codigo =?");
			for (String codigo : codigos) {
				pst.setString(1, codigo);
				pst.execute();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public boolean AltaProducto(Producto producto)  {
		conectar();
		try {
			pst = getCon().prepareStatement("INSERT INTO productos (codigo,nombre,cantidad,precio,caducidad,id_seccion)VALUES(?,?,?,?,?,?)");
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date(producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getSeccion().getId());
			
			pst.execute();
			getCon().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return false;
	}
	
	public  int maxIdProducto() {
		conectar();
		int maxIdProducto=0;
		try {
			pst = getCon().prepareStatement("SELECT max(id) FROM PRODUCTOS");
			ResultSet rs = pst.executeQuery();
			rs.next();
			maxIdProducto = rs.getInt(1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return maxIdProducto;
	}
	
	public boolean AltaProductoSuperMercado(int id_producto,String[]supermercados) {
		conectar();
		try {
			pst = getCon().prepareStatement("INSERT INTO productos_supermercados (id_producto,id_supermercado)VALUES(?,?)");
			pst.setInt(1, id_producto);
			for (String supermercado : supermercados) {
				pst.setInt(2,Integer.parseInt(supermercado));
				pst.execute();
			}
			cerrar();
			return true;
		}catch (Exception e) {
			e.printStackTrace();		}
		return false;
	}
	
	public ArrayList<Supermercado>getSupermercadoProducto(int id_producto){
		ArrayList<Supermercado>supermercados = new ArrayList<Supermercado>();
		conectar();
		try {
			pst = getCon().prepareStatement("SELECT * FROM supermercados where id in(select id from productos_supermercados where id_producto=?)");
			pst.setInt(1, id_producto);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Supermercado supermercado = new Supermercado();
				supermercado.setId(rs.getInt("id"));
				supermercado.setNombre(rs.getString("nombre"));
				supermercados.add(supermercado);
			}
			cerrar();
			return supermercados;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return supermercados;	
	}
	
	public ArrayList<Producto>getProductos(){
		conectar();
		ArrayList<Producto>productos = new ArrayList<Producto>();
		
		try {
			pst = getCon().prepareStatement("Select * from productos");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Producto producto = new Producto();
				producto.setId(rs.getInt("id"));
				producto.setCodigo(rs.getString("codigo"));
				producto.setNombre(rs.getString("nombre"));
				producto.setCantidad(rs.getInt("cantidad"));
				producto.setPrecio(rs.getDouble("precio"));
				producto.setCaducidad(rs.getDate("caducidad"));
				
				ModeloSeccion ms = new ModeloSeccion();
				ms.conectar();
				producto.setSeccion(ms.seccion(rs.getInt("id_seccion")));
				
				productos.add(producto);
			}
			getCon().close();
			return productos;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		return null;
	}
	
	public boolean eliminarproducto(int id) {
		conectar();
		try {
			pst = getCon().prepareStatement("DELETE FROM productos WHERE id=?");
			pst.setInt(1, id);
			pst.execute();
			
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean eliminarProductoSupermercado(int id_producto) {
		conectar();
		try {
			pst = getCon().prepareStatement("DELETE FROM productos_supermercados where id_producto=?");
			pst.setInt(1, id_producto);
			pst.execute();
			cerrar();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean codigoDuplicado(String codigo) {
		conectar();
		boolean  existe=false;
		try {
			pst = getCon().prepareStatement("SELECT codigo from productos where codigo=?");
			pst.setString(1, codigo);
			ResultSet rs = pst.executeQuery();
			rs.next();
			 if(codigo.equals(rs.getString("codigo"))){
				 existe=true;
				 
			 }
			
			cerrar();
			return existe;
		} catch (SQLException e) {
			return existe;
		}
	}
	
	public boolean buscarProductoSuper(int id) {
		conectar();
		boolean encontrado=false;
		try {
			pst = getCon().prepareStatement("SELECT * FROM productos_supermercados where id_producto=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				encontrado=true;
			}
			cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return encontrado;
	}
	public Producto getProducto(int id) {
		conectar();
		Producto producto = new Producto();
		ModeloSeccion ms = new ModeloSeccion();
			
		try {
			pst = getCon().prepareStatement("SELECT * FROM productos where id =?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			rs.next();
			producto.setId(rs.getInt("id"));
			producto.setCodigo(rs.getString("codigo"));
			producto.setNombre(rs.getString("nombre"));
			producto.setCantidad(rs.getInt("cantidad"));
			producto.setPrecio(rs.getDouble("precio"));
			producto.setCaducidad(rs.getDate("caducidad"));
			
			producto.setSeccion(ms.seccion(rs.getInt("id_seccion")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}

	public Producto getProductoNombre(String nombre) {
		conectar();
		Producto producto = new Producto();
		ModeloProducto mp = new ModeloProducto();
		ModeloSeccion ms = new ModeloSeccion();
		 
		try {
			pst = getCon().prepareStatement("SELECT * FROM  productos where nombre=?");
			pst.setString(1, nombre);
			ResultSet rs = pst.executeQuery();
			rs.next();
			producto.setId(rs.getInt("id"));
			producto.setCodigo(rs.getString("codigo"));
			producto.setNombre(rs.getString("nombre"));
			producto.setCantidad(rs.getInt("cantidad"));
			producto.setPrecio(rs.getDouble("precio"));
			producto.setCaducidad(rs.getDate("caducidad"));
			producto.setSeccion(ms.seccion(rs.getInt("id_seccion")));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return producto;
	}
	
	public boolean modificarProducto(Producto producto) {
		conectar();
		try {
			pst = getCon().prepareStatement("UPDATE productos set codigo=?,nombre=?,cantidad=?,precio=?,caducidad=?,id_seccion=? WHERE id=?");
			pst.setString(1, producto.getCodigo());
			pst.setString(2, producto.getNombre());
			pst.setInt(3, producto.getCantidad());
			pst.setDouble(4, producto.getPrecio());
			pst.setDate(5, new Date(producto.getCaducidad().getTime()));
			pst.setInt(6, producto.getSeccion().getId());
			pst.setInt(7, producto.getId());
			pst.execute();
			getCon().close();
			return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
		}
	
	public ArrayList<Supermercado>getSupermercados(){
		conectar();
		ArrayList<Supermercado>supermercados = new ArrayList<Supermercado>();
		try {
			pst = getCon().prepareStatement("SELECT * from supermercados");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Supermercado supermercado = new Supermercado();
				supermercado.setId(rs.getInt("id"));
				supermercado.setNombre(rs.getString("nombre"));
				supermercados.add(supermercado);
				
			}
			cerrar();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return supermercados;
	
	}
	
	
}
	
	



