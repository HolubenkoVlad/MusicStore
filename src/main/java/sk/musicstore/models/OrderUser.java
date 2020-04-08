/*package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sk.musicstore.interfaces.IProduct;

@Entity
@Table(name="orderusers")
public class OrderUser<E extends IProduct> {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_user")
	private int loginId;
	private String card;
	private String address;
	
	@OneToMany(mappedBy="order",cascade=CascadeType.PERSIST, targetEntity=Product.class)
	private List<E> list=new ArrayList<E>();

	public OrderUser(int id, String card, String address, List<E> list) {
		this.loginId=id;
		this.card=card;
		this.address=address;
		this.list=list;
	}
	
	public OrderUser() {
		
	}
	
	public int getId() {
		return id;
	}

	public int getLoginId() {
		return loginId;
	}

	public void setLoginId(int loginid) {
		this.loginId = loginid;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<E> getList() {
		return list;
	}

	public void setList(List<E> list) {
		this.list = list;
	}
	
	/*public float getTotal() {
		float sum = 0;
		for (E item : list) {
			sum += ((E)item).getItem().getPrice()*item.getCount();
		}
		return sum;
	}*/
	
	/*public List<String> getListItems() {
		List<String> items=new ArrayList<String>();
		for (E item : list) {
			items.add(item.getItem().getName());
		}
		return items;
	}*/

//}
