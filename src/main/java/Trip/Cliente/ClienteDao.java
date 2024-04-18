package Trip.Cliente;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Trip.BancoDados.Conexao;

public class ClienteDao {

	private PreparedStatement preparador;
	private ResultSet result;

	
	
	public void cadastrar(Cliente cliente) {

		Connection conexao = Conexao.conexao();

		String sql = "INSERT INTO Cliente(nome_completo,data_nascimento,email,telefone,documento,usuario,senha) VALUES(?,?,?,?,?,?,?)";

		try {
			preparador = conexao.preparedStatement(sql);
			preparador.setString(1, cliente.getNomeCompleto());
			preparador.setDate(2, new Date(cliente.getDataNascimento().getTime()));
			preparador.setString(3, cliente.getEmail());
			preparador.setString(4, cliente.getTelefone());
			preparador.setString(5, cliente.getDocumento());
			preparador.setString(6, cliente.getUsuario());
			preparador.setString(7, cliente.getSenha());

			preparador.execute();
			System.out.println("Cliente cadastrado com Sucesso!!!");
			conexao.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	
	
	public Cliente clientelogin(String usuario, String senha) {
		Cliente cliente = null;
		String query = "SELECT * FROM Cliente WHERE usuario=? and senha=?";
		Connection conexao = Conexao.conexao();
		try {

			preparador = conexao.prepareStatement(query);
			preparador.setString(1, usuario);
			preparador.setString(2, senha);
			result = preparador.executeQuery();
			if (result.next()) {
				cliente = new Cliente();
				cliente.setIdCliente(result.getInt("idCliente"));
				cliente.setNomeCompleto(result.getString("nome_completo"));
				cliente.setDataNascimento(result.getDate("data_nascimento"));
				cliente.setEmail(result.getString("email"));
				cliente.setTelefone(result.getString("telefone"));
				cliente.setDocumento(result.getString("documento"));
				cliente.setUsuario(result.getString("usuario"));
			}
			
			conexao.close();
		} catch (Exception e) {

			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		return cliente;
	}
	
	
	
}
