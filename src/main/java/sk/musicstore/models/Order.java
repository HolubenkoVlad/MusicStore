/*package sk.musicstore.models;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

import org.hibernate.annotations.Target;

import sk.musicstore.interfaces.IOrder;
import sk.musicstore.interfaces.IProduct;

import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Order<E extends IProduct> implements IOrder<E>{
	@Id
	private int id;
	@ManyToOne(targetEntity=Product.class)
	@JoinColumn(name="id_order")
	private OrderUser<E> order;
	
	private int count=0;
	@Column(name = "price")
	private float totalprice=0;
	@Transient
	private Product product;
	
	public Order() {}
	
	public Order(int quantity, float totalprice) {
		this.totalprice=totalprice;
		this.count=quantity;
	}
	
	public OrderUser<E> getOrder() {
		return order;
	}
	public void setOrder(OrderUser<E> order) {
		this.order = order;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public float getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(float totalprice) {
		this.totalprice = totalprice;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}


}*/
