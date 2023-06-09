package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ModeloProducto;
import modelo.Producto;
import modelo.Supermercado;

/**
 * Servlet implementation class EliminarEspecial
 */
@WebServlet("/EliminarEspecial")
public class EliminarEspecial extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EliminarEspecial() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mp = new ModeloProducto();
		Producto producto = mp.getProducto(Integer.parseInt(request.getParameter("id")));
		boolean encontrado = mp.buscarProductoSuper(Integer.parseInt(request.getParameter("id")));
		
		
		if(producto.getCantidad()>0) {
			producto.setCantidad(producto.getCantidad()-1);
			mp.modificarProducto(producto);
		}
		else if (producto.getCantidad()==0 && encontrado==true) {
			mp.eliminarProductoSupermercado(Integer.parseInt(request.getParameter("id")));
		}
		else  if(producto.getCantidad()==0&& encontrado==false) {
			mp.eliminarproducto(Integer.parseInt(request.getParameter("id")));
		}
		request.getRequestDispatcher("VerProductos").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
