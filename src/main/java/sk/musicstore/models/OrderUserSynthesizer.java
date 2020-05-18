package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderusers")
public class OrderUserSynthesizer extends OrderUser{
	@OneToMany(mappedBy="order",cascade=CascadeType.PERSIST)
	private List<OrderSynthesizer> list=new ArrayList<OrderSynthesizer>();
	
	public List<OrderSynthesizer> getList() {
		return list;
	}
	
	public OrderUserSynthesizer(int id, String address) {
		super(id, address);
	}

	public void setList(List<OrderSynthesizer> list) {
		this.list = list;
	}
	
	public void addToList(OrderSynthesizer orderSynthesizer) {
		list.add(orderSynthesizer);
	}
}

