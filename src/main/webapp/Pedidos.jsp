<!--<%@ page contentType="text/html; charset=UTF-8"%> -->
	<%@page import="Trip.Passagem.DadosPassageiroDao"%>
<%@page import="Trip.Cliente.*"%>	
	<%@page import="Trip.Carrinho.*"%>
	<%@page import="java.util.*"%>
	
		<%
		Cliente auth = (Cliente) request.getSession().getAttribute("auth");
		List<Carrinho> pedidos = null;
		if (auth != null) {
			request.setAttribute("auth", auth);
			pedidos = new DadosPassageiroDao().usuarioPedidos(auth.getIdCliente());
			
		}else{
			response.sendRedirect("Index.jsp#loginmodel");
		}

		ArrayList<Carrinho> car_List = (ArrayList<Carrinho>) session.getAttribute("cart-list");		
		if(car_List != null){			
			request.setAttribute("cart_list", car_List);
		}
		%>
		
		
<!DOCTYPE html>
<html>
<head>
	<%@include file="includes/head.jsp" %>
	<link rel="stylesheet" href="./css/CarrinhoCss.css" />
	
	
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
	<meta charset="UTF-8" />
<title>Pedidos cliente</title>
</head>
<body>
	<%@include file="includes/navbarCarrinho.jsp"%>		
	
	
	<div class="container">
		<div class="d-flex py-3">
		
		</div>
		<table class="table table-loght">
			<thead>
				<tr>
					
					
					<th scope="col">Nome Da reserva</th>
					<th scope="col">Origem</th>
					<th scope="col">Destino</th>
					<th scope="col">Partida</th>
					<th scope="col">Retorno</th>
					<th scope="col">Preço</th>					
					
					<th scope="col">Cancelar</th>
				</tr>
			</thead>
			<tbody>
				
					
					
					
					<%
					if(pedidos != null){
						for(Carrinho c: pedidos){%>
							<% if(c.getId() < 10){ %>
								<tr>
									<% if(c.getLocal2() != null){ 	%>					
										<td>Passagem --  <%=c.getReserva() %> </td>
									<%}else{%>
										<td>Hotel  --  <%=c.getReserva() %></td>
									
									<%}%>
									
									<td><%=c.getLocal() %></td>
									<td><%=c.getLocal2() %></td>
									
									<td><%=c.getDataChekin() %></td>					
									<td><%=c.getDataCheckout() %></td>	
									<td>R$ <%=c.getPreco() %></td>					
									
									
									<td>
										<a class="btn btn-sm btn-danger" href="CancelPedido?id=<%=c.getId()%>">Cancelar</a>
									</td>
								</tr>
								
							<%}%>
						<%}%>
					<%}
					%>
					
			</tbody>
		</table>
	</div>
</body>
</html>