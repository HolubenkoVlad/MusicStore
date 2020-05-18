package sk.musicstore.models;

import sk.musicstore.interfaces.IProduct;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="orderdrums")
public class OrderDrum extends Order {
	
	@Id
	@ManyToOne
	@JoinColumn(name="id_order")
	private OrderUserDrum order;


	public OrderUserDrum getOrder() {
		return order;
	}

	public void setOrder(OrderUserDrum order) {
		this.order = order;
	}

	@Id
	@ManyToOne
	@JoinColumn(name="id_item")
	private Drum drum;
	
	public OrderDrum() {}
	
	public OrderDrum(Drum drum, int quantity, float totalprice) {
		super(quantity, totalprice);
		this.drum=drum;
	}

	@Override
	public Drum getProduct() {
		return drum;
	}

	public void setProduct(Drum drum) {
		this.drum = drum;
	}

}
