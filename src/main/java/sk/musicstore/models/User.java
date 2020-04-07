package sk.musicstore.models;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Table;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;

@Entity
@Table(name="users")
public class User implements Serializable{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	public int getId() {
		return id;
	}
	private String surname;
	private String email;
	public  String login;
	private String password;
	@ManyToOne(fetch = FetchType.EAGER, targetEntity = Type.class)
	@JoinColumn(name = "id_type")
	private Type type;
	
	public User() {
		
	}
	
	public User(String surname, String email, String login, String password, Type type) {
		this.surname=surname;
		this.email=email;
		this.login=login;
		this.password=password;
		this.type=type;
	}
	
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setType(Type type) {
		this.type=type;
	}
	public Type getType() {
		return type;
	}
}
