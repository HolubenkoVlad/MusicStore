package sk.musicstore.models;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import sk.musicstore.interfaces.IOrderUser;

@MappedSuperclass
public class OrderUser implements IOrderUser,Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 835928731566948557L;

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

}
