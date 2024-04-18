package Trip.Cliente;

import java.util.Date;

import Trip.Hotel.Hotel;

public class Cliente {
	
	private Integer IdCliente;
	


	private String NomeCompleto;
	private Date DataNascimento;
	private String Email;
	private String Telefone;
	private String Documento;
	private String Usuario;
	private String Senha;
	
	
	private Hotel Hotel;
	
	
	
	
	public Cliente(Integer idCliente, String nomeCompleto, Date dataNascimento,  String email, String telefone, String documento, String usuario, String senha, 
			Trip.Hotel.Hotel hotel) {
		super();
		IdCliente = idCliente;
		NomeCompleto = nomeCompleto;
		DataNascimento = dataNascimento;
		Email = email;
		Telefone = telefone;
		Documento = documento;
		Usuario = usuario;
		Senha = senha;
		Hotel = hotel;

	}
	
	


	public Cliente(String nomeCompleto, Date dataNascimento,String email, String telefone, String documento,  
			String usuario, String senha
			 ) {
		super();
		
		NomeCompleto = nomeCompleto;
		DataNascimento = dataNascimento;
		Email = email;
		Telefone = telefone;		
		Documento = documento;		
		Usuario = usuario;
		Senha = senha;
	}
	
	
	public Cliente() {
		
	}


	public Integer getIdCliente() {
		return IdCliente;
	}




	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}

	public String getNomeCompleto() {
		return NomeCompleto;
	}
	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}
	public String getSenha() {
		return Senha;
	}
	public void setSenha(String senha) {
		Senha = senha;
	}
	public String getUsuario() {
		return Usuario;
	}
	public void setUsuario(String usuario) {
		Usuario = usuario;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getDocumento() {
		return Documento;
	}
	public void setDocumento(String documento) {
		Documento = documento;
	}
	public Date getDataNascimento() {
		return DataNascimento;
	}
	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}
	public String getTelefone() {
		return Telefone;
	}
	public void setTelefone(String telefone) {
		Telefone = telefone;
	}
	
	public Hotel getHotel() {
		return Hotel;
	}
	public void setHotel(Hotel hotel) {
		Hotel = hotel;
	}
	
	
	
	public void CadastrarCliente(Cliente cliente)
	{
		
	}
}
