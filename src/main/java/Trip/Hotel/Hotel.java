package Trip.Hotel;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Hotel {
	

	private Integer Id;	
	private String Reserva;
	private String Local;
	private String Local2;
	private Date DataChekin;
	private Date DataCheckout;
	private Double Preco;
	
		

	public Hotel(Integer id,  String reserva, String local, Date dataChekin, Date dataCheckout, Double preco) {
		super();
		Id = id;		
		Reserva = reserva;
		Local = local;
		DataChekin = dataChekin;
		DataCheckout = dataCheckout;
		Preco = preco;
	}
	
	
	public Hotel(Integer id,  String reserva, String local, String local2, Date dataChekin, Date dataCheckout, Double preco) {
		super();
		Id = id;		
		Reserva = reserva;
		Local = local;
		Local2 = local2;
		DataChekin = dataChekin;
		DataCheckout = dataCheckout;
		Preco = preco;
	}
	
	
	
	
	public Hotel() {}
	
	
	
	public Integer getId() {
		return Id;
	}


	public void setId(Integer id) {
		Id = id;
	}


	public String getReserva() {
		return Reserva;
	}


	public void setReserva(String reserva) {
		Reserva = reserva;
	}


	public String getLocal() {
		return Local;
	}


	public void setLocal(String local) {
		Local = local;
	}


	public String getLocal2() {
		return Local2;
	}


	public void setLocal2(String local2) {
		Local2 = local2;
	}


	public Date getDataChekin() {
		return DataChekin;
	}


	public void setDataChekin(Date dataChekin) {
		DataChekin = dataChekin;
	}


	public Date getDataCheckout() {
		return DataCheckout;
	}


	public void setDataCheckout(Date dataCheckout) {
		DataCheckout = dataCheckout;
	}


	public Double getPreco() {
		return Preco;
	}


	public void setPreco(Double preco) {
		Preco = preco;
	}


}
