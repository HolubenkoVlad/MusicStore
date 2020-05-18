package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderusers")
public class OrderUserDrum extends OrderUser {
	@OneToMany(mappedBy="order",cascade=CascadeType.PERSIST)
	private List<OrderDrum> list=new ArrayList<OrderDrum>();
	
	public OrderUserDrum(int id, String address) {
		super(id, address);
	}
	
	public List<OrderDrum> getList() {
		return list;
	}

	public void setList(List<OrderDrum> list) {
		this.list = list;
	}
	
	public void addToList(OrderDrum orderDrum) {
		list.add(orderDrum);
	}
}
