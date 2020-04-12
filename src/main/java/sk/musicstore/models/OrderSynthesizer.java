package sk.musicstore.models;
import sk.musicstore.interfaces.IProduct;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


//@Entity
//@Table(name="ordersynthesizer")
public class OrderSynthesizer<E extends Product> extends Order<E> {
	
	
	//@ManyToOne
	//@JoinColumn(name="id_item")
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

}