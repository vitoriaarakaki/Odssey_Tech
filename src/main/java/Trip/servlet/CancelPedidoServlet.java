package Trip.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Trip.Cliente.Cliente;
import Trip.Passagem.DadosPassageiro;
import Trip.Passagem.DadosPassageiroDao;


@WebServlet("/CancelPedido")
public class CancelPedidoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()) {
			String id = request.getParameter("id");
			Cliente cl = (Cliente) request.getSession().getAttribute("auth");
			if(id != null) {
				DadosPassageiroDao dpD = new DadosPassageiroDao();
				dpD.cancelPedido(cl.getIdCliente());
			}
			response.sendRedirect("Pedidos.jsp");
		}catch (Exception e) {
			e.printStackTrace();
		}
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
