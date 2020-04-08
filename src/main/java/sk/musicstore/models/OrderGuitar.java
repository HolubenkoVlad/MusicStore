/*package sk.musicstore.models;

import sk.musicstore.interfaces.IProduct;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="orderguitar")
public class OrderGuitar<E extends Product> extends Order<E> {

	
	@ManyToOne
	@JoinColumn(name="id_item")
	private Guitar guitar;
	
	public OrderGuitar() {super();}
	
	public OrderGuitar(Guitar guitar, int quantity, float totalprice) {
		super(quantity, totalprice);
		this.guitar=guitar;
	}

	@Override
	public Guitar getProduct() {
		return guitar;
	}

	public void setProduct(Guitar guitar) {
		this.guitar = guitar;
	}
}*/
