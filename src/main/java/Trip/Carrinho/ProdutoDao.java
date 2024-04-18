package Trip.Carrinho;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import Trip.BancoDados.Conexao;


public class ProdutoDao {

	private String query;
	private PreparedStatement preparador;
	private ResultSet result;
	private Connection conexao;

	public List<Carrinho> getCarrProd(ArrayList<Carrinho> cartList) {
		List<Carrinho> produtos = new ArrayList<Carrinho>();

		try {
			Connection conexao = Conexao.conexao();
			if (cartList.size() > 0) {
				for (Carrinho item : cartList) {
					if (item.getId() < 10) {
						query = "SELECT * FROM reserva_hotel WHERE id=?";
						PreparedStatement preparador = conexao.prepareStatement(query);
						preparador.setInt(1, item.getId());
						result = preparador.executeQuery();
						while (result.next()) {
							Carrinho r = new Carrinho();
							r.setId(result.getInt("id"));
							r.setReserva(result.getString("reserva"));
							r.setLocal(result.getString("destino"));
							r.setDataChekin(result.getDate("data_checkin"));
							r.setDataCheckout(result.getDate("data_checkout"));
							r.setPreco(result.getDouble("preco") * item.getQuantity());
							r.setQuantity(item.getQuantity());
							produtos.add(r);
						}
					} else {
						query = "SELECT * FROM passagens_aereas WHERE idPassagens=?";
						PreparedStatement preparador = conexao.prepareStatement(query);
						int id = item.getId() - 10;
						preparador.setInt(1, id);
						result = preparador.executeQuery();
						while (result.next()) {
							Carrinho r = new Carrinho();
							r.setId(id + 10);
							r.setReserva(result.getString("reserva"));
							r.setLocal(result.getString("origem"));
							r.setLocal2(result.getString("destino"));
							r.setDataChekin(result.getDate("data_partida"));
							r.setDataCheckout(result.getDate("data_retorno"));
							r.setPreco(result.getDouble("preco") * item.getQuantity());
							r.setQuantity(item.getQuantity());
							produtos.add(r);
						}
					}

				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}

		return produtos;
	}

	
	
	
	public double getTotalCartPrice(ArrayList<Carrinho> cartList) {
		double soma = 0;

		try {
			Connection conexao = Conexao.conexao();
			if (cartList.size() > 0) {
				for (Carrinho item : cartList) {
					if(item.getId() < 10) {
						query = "SELECT preco FROM reserva_hotel WHERE id=?";
						PreparedStatement preparador = conexao.prepareStatement(query);
						preparador.setInt(1, item.getId());
						result = preparador.executeQuery();

						while (result.next()) {
							soma += result.getDouble("preco") * item.getQuantity();
						}
					}else {
						int id = item.getId() - 10;
						query = "SELECT preco FROM passagens_aereas WHERE idPassagens=?";
						PreparedStatement preparador = conexao.prepareStatement(query);
						preparador.setInt(1, id);
						result = preparador.executeQuery();

						while (result.next()) {
							soma += result.getDouble("preco") * item.getQuantity();
						}
					}
					
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return Math.round(soma);
	}

}
