package sk.musicstore.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import sk.musicstore.interfaces.IGuitar;

/**
 * The class is a description of the characteristics of a guitar.
 * @see javax.persistence.Entity
 * @see javax.persistence.Table
 * */
@Entity
@Table(name="guitar")
public class  Guitar extends Product implements IGuitar, Serializable{
	/**Number of strings*/
	private int number_of_strings;
	/**Material*/
	private String material;
	/**Type*/
	private String type;

	public void setNumberOfStrings(int numberOfStrings) {
		this.number_of_strings=numberOfStrings;
	}
	
	public int getNumberOfStrings() {
		return this.number_of_strings;
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
	
	/**
	 * Returns guitar characteristics connected in one line.
	 * */
	@Override
	public String toString() {
		return new StringBuilder("Number of strings: ").append(number_of_strings).
				append("; Material: ").append(material).append("; Type: ").append(type).toString();
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(number_of_strings, material, type);
	}
}



