package Trip.Passagem;

import java.util.Date;

public class DadosPassageiro {

	private Integer IdDados;
	private String NomeCompleto;
	private Date DataNascimento;
	private String Documento;
	private String Telefone;
	private Integer IdHotel;
	private Integer IdPassagens;
	private Integer IdCliente;
	
	
	public DadosPassageiro() {
		
	}

	

	public DadosPassageiro(Integer idDados, String nomeCompleto, Date dataNascimento, String documento, String telefone,
			Integer idHotel, Integer idPassagens, Integer idCliente) {		
		IdDados = idDados;
		NomeCompleto = nomeCompleto;
		DataNascimento = dataNascimento;
		Documento = documento;
		Telefone = telefone;
		IdHotel = idHotel;
		IdPassagens = idPassagens;
		IdCliente = idCliente;
	}
	
	
	
	public Integer getIdDados() {
		return IdDados;
	}


	public void setIdDados(Integer idDados) {
		IdDados = idDados;
	}


	public String getNomeCompleto() {
		return NomeCompleto;
	}


	public void setNomeCompleto(String nomeCompleto) {
		NomeCompleto = nomeCompleto;
	}


	public Date getDataNascimento() {
		return DataNascimento;
	}


	public void setDataNascimento(Date dataNascimento) {
		DataNascimento = dataNascimento;
	}


	public String getDocumento() {
		return Documento;
	}


	public void setDocumento(String documento) {
		Documento = documento;
	}


	public String getTelefone() {
		return Telefone;
	}


	public void setTelefone(String telefone) {
		Telefone = telefone;
	}


	public Integer getIdHotel() {
		return IdHotel;
	}


	public void setIdHotel(Integer idHotel) {
		IdHotel = idHotel;
	}


	public Integer getIdPassagens() {
		return IdPassagens;
	}


	public void setIdPassagens(Integer idPassagens) {
		IdPassagens = idPassagens;
	}


	public Integer getIdCliente() {
		return IdCliente;
	}


	public void setIdCliente(Integer idCliente) {
		IdCliente = idCliente;
	}
	
	
}
