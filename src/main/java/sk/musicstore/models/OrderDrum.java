package sk.musicstore.models;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
/**
 * The class is the essence of the drum order table.
 * @see javax.persistence.Entity
 * @see javax.persistence.Table
 * */
@Entity
@Table(name="orderdrums")
public class OrderDrum extends Order {
	/**
	 * The field that refers to the user to which this drum is associated.
	 * @see javax.persistence.Id
	 * @see javax.persistence.ManyToOne
	 * @see javax.persistence.JoinColumn
	 * */
	@Id
	@ManyToOne
	@JoinColumn(name="id_order")
	private OrderUserDrum<OrderDrum> order;

	
	public OrderUserDrum<OrderDrum> getOrder() {
		return order;
	}

	public void setOrder(OrderUserDrum<OrderDrum> order) {
		this.order = order;
	}
    /**Drum in order
     * @see javax.persistence.Id
	 * @see javax.persistence.ManyToOne
	 * @see javax.persistence.JoinColumn
     * */
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
	/**Method for comparing objects*/
	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderDrum orderDrum = (OrderDrum) o;
        return  Objects.equals(order, orderDrum.order) &&
                Objects.equals(drum, orderDrum.drum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, drum);
    }

}
