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
 * Servlet implementation class BuscarPorNombre
 */
@WebServlet("/BuscarPorNombre")
public class BuscarPorNombre extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BuscarPorNombre() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mp = new ModeloProducto();
		mp.conectar();
		String cadena= request.getParameter("nombre");
		ArrayList<Producto>productos = mp.getProductos();
		ArrayList<Producto>productoBuscado = new ArrayList<Producto>();
		if(request.getParameter("buscador").equals("BuscarCodigo")) {
			for (Producto producto : productos) {
				if(producto.getCodigo().contains(cadena)) {
					productoBuscado.add(producto);
				}
			}
		}else {
				for (Producto producto : productos) {
					if(producto.getNombre().contains(cadena)) {
						productoBuscado.add(producto);
					}
				}
			}
		
		
		
		
		mp.cerrar();
		ModeloSeccion ms = new ModeloSeccion();
		ms.conectar();
		ArrayList<Seccion>secciones = ms.getSecciones();
		
		
		
		request.setAttribute("secciones", secciones);
		request.setAttribute("productos", productoBuscado);
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
