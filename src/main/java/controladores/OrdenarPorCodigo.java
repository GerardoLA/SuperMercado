package controladores;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.ComparatorProductoCodigo;
import modelo.ModeloProducto;
import modelo.ModeloSeccion;
import modelo.Producto;

/**
 * Servlet implementation class OrdenarPorCodigo
 */
@WebServlet("/OrdenarPorCodigo")
public class OrdenarPorCodigo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public OrdenarPorCodigo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ModeloProducto mp = new ModeloProducto();
		ComparatorProductoCodigo cp = new ComparatorProductoCodigo();
		ModeloSeccion ms = new ModeloSeccion();
		ArrayList<Producto>productos = mp.getProductos();
		
		if(request.getParameter("ordenator").equals("Ascendente")){
				productos.sort(cp);
		}
		else {
			productos.sort(cp.reversed());
		}
		request.setAttribute("secciones", ms.getSecciones());
		request.setAttribute("productos", productos);
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
