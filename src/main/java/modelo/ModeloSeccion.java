package modelo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class ModeloSeccion extends Conector{
	PreparedStatement pst;
	
	public ArrayList<Seccion>getSecciones(){
		ArrayList<Seccion>secciones = new ArrayList<Seccion>();
		conectar();
		try {
			pst=getCon().prepareStatement("SELECT * FROM secciones");
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				Seccion seccion = new Seccion();
				seccion.setId(rs.getInt("id"));
				seccion.setNombre(rs.getString("nombre"));
				
				secciones.add(seccion);
				
			}
			getCon().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return secciones;	
	}
	
	public Seccion seccion (int id) {
		conectar();
		Seccion seccion = new Seccion();
		try {
			pst = getCon().prepareStatement("SELECT * from secciones where id=?");
			pst.setInt(1, id);
			ResultSet rs = pst.executeQuery();
			if(rs.next()) {
				seccion.setId(rs.getInt("id"));
				seccion.setNombre(rs.getString("nombre"));
				return seccion;
			}
			return null;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
