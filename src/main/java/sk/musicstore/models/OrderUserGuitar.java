package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="orderusers")
public class OrderUserGuitar<T> extends OrderUser{
	@OneToMany(mappedBy="order",cascade=CascadeType.PERSIST, targetEntity=OrderGuitar.class)
	private List<T> list=new ArrayList<T>();
	
	public List<T> getList() {
		return list;
	}
	
	public OrderUserGuitar(int id, String address) {
		super(id, address);
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public void addToList(T orderGuitar) {
		list.add(orderGuitar);
	}
}

