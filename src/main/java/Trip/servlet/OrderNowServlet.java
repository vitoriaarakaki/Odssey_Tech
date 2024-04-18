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
import Trip.Cliente.Cliente;
import Trip.Passagem.DadosPassageiro;
import Trip.Passagem.DadosPassageiroDao;

@WebServlet("/OrderNow")
public class OrderNowServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try (PrintWriter out = response.getWriter()){
			Cliente cl = (Cliente) request.getSession().getAttribute("auth");
			
			if(cl != null) {
				
				String Id = request.getParameter("id");
				int id1 = Integer.parseInt(Id);
				if(id1 > 10) {
					id1 = id1 - 10;
				}
				DadosPassageiro dP = new DadosPassageiro();
				dP.setNomeCompleto(cl.getNomeCompleto());
				dP.setDataNascimento(cl.getDataNascimento());
				dP.setDocumento(cl.getDocumento());
				dP.setTelefone(cl.getTelefone());
				dP.setIdHotel(id1);
				dP.setIdPassagens(id1);
				dP.setIdCliente(cl.getIdCliente());
				
				
				DadosPassageiroDao dPDao = new DadosPassageiroDao();
				
				boolean result = dPDao.dadosPassageiro(dP);
				if(result) {
					
					ArrayList<Carrinho> car_List = (ArrayList<Carrinho>) request.getSession().getAttribute("cart-list");
					if(car_List != null) {
						for(Carrinho c: car_List) {
							if(c.getId() == id1) {
								car_List.remove(car_List.indexOf(c));
								break;
							}						
						}						
					}					
					response.sendRedirect("Pedidos.jsp");
				}else {
					out.print("Pedido falhou");
				}
				
			}else {
				response.sendRedirect("Index.jsp#loginmodel");				
			}
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
