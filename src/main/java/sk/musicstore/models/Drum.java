package sk.musicstore.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;

import sk.musicstore.interfaces.IDrum;

@Entity
@Table(name="drum")
//@DiscriminatorValue("1")
public class Drum extends Product implements IDrum, Serializable {
	@Column(name = "number_of_drums")
	private int numberOfDrum;
	private String color;
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
