package controladores;

import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.Producto;
import modelo.Seccion;

/**
 * Servlet implementation class Principal
 */
@WebServlet("/Principal")
public class Principal extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Principal() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloSeccion ms = new ModeloSeccion();
		ArrayList<Seccion>secciones = new ArrayList<Seccion>();
		ms.conectar();
		secciones=ms.getSecciones();
		ms.cerrar();
		
		request.setAttribute("secciones", secciones);
		request.getRequestDispatcher("AltaProductoForm.jsp").forward(request, response);	
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Producto producto = new Producto();
		ModeloProducto mp = new ModeloProducto();
		Seccion seccion = new Seccion();
		ModeloSeccion ms = new ModeloSeccion();
		
		producto.setCodigo(request.getParameter("codigo"));
		producto.setNombre(request.getParameter("nombre"));
		producto.setCantidad(Integer.parseInt(request.getParameter("cantidad")));
		producto.setPrecio(Double.parseDouble(request.getParameter("precio")));
		
		Date caducidad = null;
		try {
			caducidad = new SimpleDateFormat("yyyy-mm-dd").parse(request.getParameter("caducidad"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		producto.setCaducidad(caducidad);
		producto.setSeccion(ms.seccion(Integer.parseInt(request.getParameter("id_seccion"))));
		mp.AltaProducto(producto);	
		
		request.getRequestDispatcher("VerProductos").forward(request, response);
		
	}

}
