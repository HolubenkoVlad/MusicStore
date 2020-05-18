package sk.musicstore.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import sk.musicstore.interfaces.IProduct;

@MappedSuperclass
public class OrderUser implements Serializable {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "id_user")
	private int loginId;
	private String address;

	public OrderUser(int id, String address) {
		this.loginId=id;
		this.address=address;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
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

}
