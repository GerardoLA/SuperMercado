package modelo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloProducto extends Conector{
	PreparedStatement pst;
	
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

}
