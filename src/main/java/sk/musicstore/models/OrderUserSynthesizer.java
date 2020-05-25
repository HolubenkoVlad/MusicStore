package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
/**
 * The class is the essence of the user order table.
 * @see javax.persistence.Entity
 * @see javax.persistence.Table
 * */
@Entity
@Table(name="orderusers")
public class OrderUserSynthesizer<T> extends OrderUser{
	/**
	 * The list of products this user is associated with in the table with synthesizer orders.
	 * @see javax.persistence.OneToMany
	 * */
	@OneToMany(mappedBy="order",cascade=CascadeType.PERSIST, targetEntity=OrderSynthesizer.class)
	private List<T> list=new ArrayList<T>();
	
	public List<T> getList() {
		return list;
	}
	
	public OrderUserSynthesizer(int id, String address) {
		super(id, address);
	}

	public void setList(List<T> list) {
		this.list = list;
	}
	
	public void addToList(T orderSynthesizer) {
		list.add(orderSynthesizer);
	}
}

