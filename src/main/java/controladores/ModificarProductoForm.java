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
 * Servlet implementation class ModificarProductoForm
 */
@WebServlet("/ModificarProductoForm")
public class ModificarProductoForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ModificarProductoForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Producto producto = new Producto();
		ModeloProducto mp = new ModeloProducto();
		ModeloSeccion ms = new ModeloSeccion();
		
		int id = Integer.parseInt(request.getParameter("id"));
		ArrayList<Seccion>secciones = new ArrayList<Seccion>();
		
		producto = mp.getProducto(id);
		mp.cerrar();
		secciones = ms.getSecciones();
		ms.cerrar();
		
		
		request.setAttribute("producto", producto);
		request.setAttribute("secciones", secciones);
		
	request.getRequestDispatcher("ModificarProducto.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
