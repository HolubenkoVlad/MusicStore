package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderusers")
public class OrderUserGuitar extends OrderUser{
	@OneToMany(mappedBy="order",cascade=CascadeType.PERSIST)
	private List<OrderGuitar> list=new ArrayList<OrderGuitar>();
	
	public List<OrderGuitar> getList() {
		return list;
	}
	
	public OrderUserGuitar(int id, String address) {
		super(id, address);
	}

	public void setList(List<OrderGuitar> list) {
		this.list = list;
	}
	
	public void addToList(OrderGuitar orderGuitar) {
		list.add(orderGuitar);
	}
}

