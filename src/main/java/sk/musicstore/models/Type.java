package sk.musicstore.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
/**The class is a user type entry in the user type table*/
@Entity
@Table(name="type_of_user")
public class Type implements Serializable{
	@Id
	private int id;
	private String name;
	
	public Type() {}
	public Type(int id, String name) {
		this.id=id;
		this.name=name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
}
