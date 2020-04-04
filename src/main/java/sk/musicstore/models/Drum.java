package sk.musicstore.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import sk.musicstore.interfaces.IDrum;

@Entity
@Table(name="drum")
public class Drum extends Product implements IDrum {
	private int numberOfDrums;
	private String color;
	private String size;
	
	public void setNumberOfDrums(int numberOfDrums) {
		this.numberOfDrums=numberOfDrums;
	}
	
	public int getNumberOfDrums() {
		return this.numberOfDrums;
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
	
	public String toString() {
		return new StringBuilder("Number of drums: ").append(numberOfDrums).
				append("; Color: ").append(color).append("; Size: ").append(size).toString();
	}
}
