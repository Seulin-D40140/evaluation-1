package fr.fms.entities;

public class Order 
{
	int idOrder;
	String nameOrder;
	String descrOrder;
	String typeOrder;
	double priceOrder;
	
	public Order (String nameOrder , String descrOrder , String typeOrder , double priceOrder )
	{
		this.nameOrder = nameOrder;
		this.descrOrder = descrOrder;
		this.typeOrder = typeOrder;
		this.priceOrder = priceOrder;
	}

	public int getIdOrder() {
		return idOrder;
	}

	public void setIdOrder(int idOrder) {
		this.idOrder = idOrder;
	}

	public String getNameOrder() {
		return nameOrder;
	}

	public void setNameOrder(String nameOrder) {
		this.nameOrder = nameOrder;
	}

	public String getDescrOrder() {
		return descrOrder;
	}

	public void setDescrOrder(String descrOrder) {
		this.descrOrder = descrOrder;
	}

	public String getTypeOrder() {
		return typeOrder;
	}

	public void setTypeOrder(String typeOrder) {
		this.typeOrder = typeOrder;
	}

	public double getPriceOrder() {
		return priceOrder;
	}

	public void setPriceOrder(double priceOrder) {
		this.priceOrder = priceOrder;
	}
	
}
