package Trip.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Trip.Carrinho.Carrinho;

@WebServlet("/removeCarrinho")
public class RemoveFCarrinho extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		try(PrintWriter out = response.getWriter()){
			String id = request.getParameter("id");
			
			int id2 = Integer.parseInt(id);
			
			if(id != null) {
				ArrayList<Carrinho> car_List = (ArrayList<Carrinho>) request.getSession().getAttribute("cart-list");
				if(car_List != null) {
					
					for(Carrinho c: car_List) {
						if( c.getLocal2() != null) {
							id2 = id2 - 10;
						}
						
						if(c.getId() == id2) {
							
							car_List.remove(car_List.indexOf(c));
							
							break;
						}						
					}
					response.sendRedirect("Carrinho.jsp");
				}
				
			}else {
				response.sendRedirect("Carrinho.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
