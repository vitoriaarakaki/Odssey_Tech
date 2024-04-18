
<!--<%@ page contentType="text/html; charset=UTF-8"%> -->

	<%@page import="Trip.Cliente.*"%>
	<%@page import="Trip.Carrinho.*"%>
	<%@page import="java.util.*"%>
	<%
		Cliente auth = (Cliente) request.getSession().getAttribute("auth");
		if (auth != null) {
			request.setAttribute("auth", auth);
		}else{
			response.sendRedirect("Index.jsp#loginmodel");
		}
		
		
		ArrayList<Carrinho> car_List = (ArrayList<Carrinho>) session.getAttribute("cart-list");
		List<Carrinho> carrProd = null;
		if(car_List != null){
			ProdutoDao pDao = new ProdutoDao();
			carrProd = pDao.getCarrProd(car_List);
			double total = pDao.getTotalCartPrice(car_List); 
			
			request.setAttribute("cart_list", car_List);	
			request.setAttribute("total", total);
		}
	
	%>


<!DOCTYPE html>
<html>
<head>

	<style type="text/css">
		.table tbody td{
			vertical-align: middle;
		}
		
		.btn-incre, .btn-decre{
			box-shadow: none;
			font-size: 25px;		
		}
		.btn-primary{
		
			background-color: #ffcaa6;
		}
		
		
		
		
	</style>
	<link rel="stylesheet" href="./css/CarrinhoCss.css" />
	
	<meta charset="UTF-8" />
	<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
	
	
<title>Carrinho</title>
</head>
<body>
	<div>
		<%@include file="includes/navbarCarrinho.jsp"%>	
	</div>
	<div class="container">
		<div class="d-flex py-3">
			<h3>Preço total: R$  ${ (total>0)?total:0 }</h3>
			<a class="mx-3 btn btn-primary" href="CheckOut">Finalizar Compra</a>
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
					<th scope="col">Compre agora</th>
					<th scope="col">Cancelar</th>
				</tr>
			</thead>
			<tbody>
				
					<%
					if(car_List != null){
						for(Carrinho c: carrProd){%>
							
								<tr>							
									<% if(c.getLocal2() != null){ 	%>					
										<td> Passagem --  <%=c.getReserva() %> </td>
									<%}else{%>
										<td>Hotel  --  <%=c.getReserva() %></td>
									
									<%}%>
									
									<td><%=c.getLocal() %></td>
									<td><%=c.getLocal2() %></td>
									
									<td><%=c.getDataChekin() %></td>					
									<td><%=c.getDataCheckout() %></td>	
									<td>R$ <%=c.getPreco() %></td>					
									
									
									<td>
										<a class="btn btn-sm btn-danger" href="removeCarrinho?id=<%=c.getId()%>">Remover</a>
									</td>
								</tr>
								
							<%} %>
						<%}%>
					
			</tbody>
		</table>
	</div>
</body>
</html>