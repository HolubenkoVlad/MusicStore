package sk.musicstore.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;

import sk.musicstore.interfaces.IDrum;
/**
 * The class is a description of the characteristics of a drum.
 * @see javax.persistence.Entity
 * @see javax.persistence.Table
 * */
@Entity
@Table(name="drum")
public class Drum extends Product implements IDrum, Serializable {
	/**
	 * Number of drums
	 * @see javax.persistence.Column
	 * */
	@Column(name = "number_of_drums")
	private int numberOfDrum;
	/**Color*/
	private String color;
	/**Size*/
	private String size;
	public void setNumberOfDrums(int numberOfDrums) {
		this.numberOfDrum=numberOfDrums;
	}
	
	public int getNumberOfDrums() {
		return this.numberOfDrum;
	}
	
	public void setColor(String color) {
		this.color=color;
	}
	
	public String getColor() {
		return this.color;
	}
	
	public void setSize(String size) {
		this.size=size;
	}
	
	public String getSize() {
		return this.size;
	}
	/**
	 * Returns drum characteristics connected in one line.
	 * */
	@Override
	public String toString() {
		return new StringBuilder("Number of drums: ").append(this.numberOfDrum).
				append("; Color: ").append(color).append("; Size: ").append(size).toString();
	}
	@Override
	public int hashCode() {
		return Objects.hash(numberOfDrum, color, size);
	}
	
}
