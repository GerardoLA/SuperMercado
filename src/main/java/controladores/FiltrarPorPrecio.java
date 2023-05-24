package controladores;

import java.io.IOException;
import java.util.ArrayList;

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
 * Servlet implementation class FiltrarPorPrecio
 */
@WebServlet("/FiltrarPorPrecio")
public class FiltrarPorPrecio extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FiltrarPorPrecio() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		double precioMax = Double.parseDouble(request.getParameter("precioMax"));
		double precioMin = Double.parseDouble(request.getParameter("precioMin"));
		ModeloProducto mp = new ModeloProducto();
		ArrayList<Producto>productos = mp.getProductos();
		ArrayList<Producto>productosBuscados = new ArrayList<Producto>();
		for (Producto producto : productos) {
			if(precioMin<producto.getPrecio() && precioMax>producto.getPrecio()) {
				productosBuscados.add(producto);
			
				}
			
			}
			
		ModeloSeccion ms = new ModeloSeccion();
		ArrayList<Seccion>secciones = ms.getSecciones();
		
		request.setAttribute("secciones", secciones);
		request.setAttribute("productos", productosBuscados);
		request.getRequestDispatcher("VerProductos.jsp").forward(request, response);
		
		}
		
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
