package sk.musicstore.models;
import sk.musicstore.interfaces.IProduct;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="ordersynthesizers")
public class OrderSynthesizer extends Order{

	@Id
	@ManyToOne
	@JoinColumn(name="id_order")
	private OrderUserSynthesizer order;

	@Id
	@ManyToOne
	@JoinColumn(name="id_item")
	private Synthesizer synthesizer;
	
	
	public OrderSynthesizer() {
		super();
	}

	public OrderSynthesizer(Synthesizer synthesizer, int quantity, float totalprice) {
		super(quantity, totalprice);
		this.synthesizer=synthesizer;
	}
	
	public Synthesizer getProduct() {
		return synthesizer;
	}

	public void setProduct(Synthesizer synthesizer) {
		this.synthesizer = synthesizer;
	}

	public OrderUserSynthesizer getOrder() {
		return order;
	}

	public void setOrder(OrderUserSynthesizer order) {
		this.order = order;
	}
	
	/*@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrderSynthesizer orderSyn = (OrderSynthesizer) o;
        return  Objects.equals(order, orderSyn.order) &&
                Objects.equals(synthesizer, orderSyn.synthesizer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(order, synthesizer);
    }*/

}