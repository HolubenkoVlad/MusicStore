package sk.musicstore.models;

import javax.persistence.MappedSuperclass;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

import sk.musicstore.interfaces.IProduct;

@MappedSuperclass
public abstract class Product implements IProduct {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	private String name;
	private String feature;
	private float price;
	private String photo;
	
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name=name;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setFeature(String feature) {
		this.feature=feature;
	}
	
	public String getFeature() {
		return this.feature;
	}
	
	public void setPrice(float price) {
		this.price=price;
	}
	
	public float getPrice() {
		return this.price;
	}
	
	public void setPhoto(String photo) {
		this.photo=photo;
	}
	
	public String getPhoto() {
		return this.photo;
	}
}
