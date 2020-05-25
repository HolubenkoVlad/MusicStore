package sk.musicstore.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import sk.musicstore.interfaces.IOrder;
/**
 * The class that describes common fields for Entities Orders
 * @see javax.persistence.MappedSuperclass
 * */
@MappedSuperclass
public abstract class Order implements IOrder, Serializable{
	/**Quantity of products of one type*/
	private int count=0;
	/**Total price*/
	@Column(name = "price")
	private float totalprice=0;
	@Transient
	private Product product;
	
	public Order() {}
	
	public Order(int quantity, float totalprice) {
		this.totalprice=totalprice;
		this.count=quantity;
	}
	
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count += count;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice += totalprice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}
