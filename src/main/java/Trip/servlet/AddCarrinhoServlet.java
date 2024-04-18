package Trip.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import Trip.Carrinho.Carrinho;
import Trip.Cliente.Cliente;

@WebServlet("/AddCarrinho")
public class AddCarrinhoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@SuppressWarnings("unchecked")
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (PrintWriter out = response.getWriter()) {

			ArrayList<Carrinho> carList = new ArrayList<>();					
			
			int id = Integer.parseInt(request.getParameter("id"));

			Carrinho c = new Carrinho();

			c.setId(id);

			c.setQuantity(1);

			HttpSession session = request.getSession();
			ArrayList<Carrinho> car_List = (ArrayList<Carrinho>) session.getAttribute("cart-list");
			
					
			
			if (car_List == null) {
				carList.add(c);
				session.setAttribute("cart-list", carList);
				
				response.sendRedirect("Index.jsp");
			} else {
				carList = car_List;
				boolean exist = false;

				for (Carrinho h : car_List) {

					if (h.getId() == id) {
						exist = true;
												
						out.println("<script type=\"text/javascript\">");  
						out.println("alert('Item Já existe em seu carrinho ');");  
						out.print("window.location.href = 'Carrinho.jsp';");
						out.println("</script>");	
						
					
					}					
				}
				
				
				
				if (!exist && carList.size() < 2) {
					carList.add(c);
					
					response.sendRedirect("Index.jsp");
				}
				
			}
			
		} 
	
	}

}
