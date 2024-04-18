package Trip.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Trip.Cliente.Cliente;
import Trip.Cliente.ClienteDao;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		resp.sendRedirect("Index.jsp");

	}

	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		try (PrintWriter out = resp.getWriter()) {
			String usuario = req.getParameter("usuario-login");
			String senha = req.getParameter("senha-login");

			ClienteDao cdao = new ClienteDao();
			Cliente cliente = cdao.clientelogin(usuario, senha);
			if (cliente != null) {
				req.getSession().setAttribute("auth", cliente);
				resp.sendRedirect("Index.jsp");				
			} else {
				out.println("<script type=\"text/javascript\">");  
				out.println("alert('Login Falhou ');"); 
				out.print("window.location.href = 'Index.jsp#loginmodel';");
				out.println("</script>");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}		

	}
}
