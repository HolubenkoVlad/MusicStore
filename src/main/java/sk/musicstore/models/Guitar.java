package sk.musicstore.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import sk.musicstore.interfaces.IGuitar;


@Entity
@Table(name="guitar")
public class  Guitar extends Product implements IGuitar{
	private int numberOfStrings;
	private String material;
	private String type;

	public void setNumberOfStrings(int numberOfStrings) {
		this.numberOfStrings=numberOfStrings;
	}
	
	public int getNumberOfStrings() {
		return this.numberOfStrings;
	}
	
	public void setMaterial(String material) {
		this.material=material;
	}
	
	public String getMaterial() {
		return this.material;
	}
	
	public void setType(String type) {
		this.type=type;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String toString() {
		return new StringBuilder("Number of strings: ").append(numberOfStrings).
				append("; Material: ").append(material).append("; Type: ").append(type).toString();
	}
}



