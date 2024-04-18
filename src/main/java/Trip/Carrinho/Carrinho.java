package Trip.Carrinho;

import Trip.Hotel.Hotel;

public class Carrinho extends Produto{
	
	
	private int Quantity;
	
	public Carrinho() {}
	
	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}
}
