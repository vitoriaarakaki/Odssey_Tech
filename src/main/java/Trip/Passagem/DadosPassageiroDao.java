package Trip.Passagem;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Trip.BancoDados.Conexao;
import Trip.Carrinho.Carrinho;

public class DadosPassageiroDao {
	
	private PreparedStatement preparador;
	private ResultSet result;
	private String query;
	
	public boolean dadosPassageiro(DadosPassageiro dadosPassageiro) {
		boolean result = false;
		Connection conexao = Conexao.conexao();
		
		String sql = "INSERT INTO Dados_Passageiro(nome_completo,data_nascimento,documento,telefone,Reserva_Hotel_id,Passagens_aereas_idPassagens,Cliente_idCliente) VALUES(?,?,?,?,?,?,?)";
		
		try {
			PreparedStatement preparador = conexao.prepareStatement(sql);
			preparador.setString(1, dadosPassageiro.getNomeCompleto());
			preparador.setDate(2, new Date(dadosPassageiro.getDataNascimento().getTime()));
			preparador.setString(3, dadosPassageiro.getDocumento());
			preparador.setString(4, dadosPassageiro.getTelefone());
			preparador.setInt(5, dadosPassageiro.getIdHotel());
			preparador.setInt(6, dadosPassageiro.getIdPassagens());
			preparador.setInt(7, dadosPassageiro.getIdCliente());		
			
			preparador.execute();
			System.out.println("Reserva de VOO feita com Sucesso");
			result = true;
			conexao.close();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	
	public List<Carrinho> usuarioPedidos (int id ){
		List<Carrinho> lista = new ArrayList<>();
		Connection conexao = Conexao.conexao();
		Carrinho c = new Carrinho();
		Carrinho c1 = new Carrinho();
		try {
			
			query = "SELECT * FROM dados_passageiro WHERE Cliente_idCliente=? ORDER BY dados_passageiro.iddados DESC";
			preparador = conexao.prepareStatement(query);
			preparador.setInt(1, id);
			result = preparador.executeQuery();
			while(result.next()) {
				DadosPassageiro dadosP= new DadosPassageiro();
				
				DadosPassageiroDao dpD = new DadosPassageiroDao();
				
				int hotelId = (result.getInt("Reserva_Hotel_id"));
				int passagemId = (result.getInt("Passagens_aereas_idPassagens"));
				System.out.println(hotelId + " " + passagemId);
				lista = dpD.getSingleProduct(hotelId, passagemId);
								
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return lista;
	}
	
	
	
	public List<Carrinho> getSingleProduct(int idHotel, int idPassagem) {
		List<Carrinho> list = new ArrayList<Carrinho>();
		Carrinho row = new Carrinho();
		Carrinho row1 = new Carrinho();
		Connection conexao = Conexao.conexao();
		try {
			query= "SELECT * FROM reserva_hotel WHERE id=?";
			preparador = conexao.prepareStatement(query);
			preparador.setInt(1, idHotel);
			result = preparador.executeQuery();
			while(result.next()) {
				row.setId(result.getInt("id"));
				row.setReserva(result.getString("reserva"));
				row.setLocal(result.getString("destino"));
				row.setDataChekin(result.getDate("data_checkin"));
				row.setDataCheckout(result.getDate("data_checkout"));
				row.setPreco(result.getDouble("preco"));
				list.add(row);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			query= "SELECT * FROM passagens_aereas WHERE idPassagens=?";
			preparador = conexao.prepareStatement(query);
			preparador.setInt(1, idPassagem);
			result = preparador.executeQuery();
			while(result.next()) {
				row1.setId(result.getInt("idPassagens"));
				row1.setReserva(result.getString("reserva"));
				row1.setLocal(result.getString("origem"));
				row1.setLocal2(result.getString("destino"));
				row1.setDataChekin(result.getDate("data_partida"));
				row1.setDataCheckout(result.getDate("data_retorno"));
				row1.setPreco(result.getDouble("preco"));
				list.add(row1);
			}
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	
	
	public void cancelPedido(int idCliente) {
		Connection conexao = Conexao.conexao();
		
		try {
			query = "DELETE FROM dados_passageiro WHERE Cliente_idCliente=?";
			preparador = conexao.prepareStatement(query);
			preparador.setInt(1, idCliente);
			preparador.execute();
			
			
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}

