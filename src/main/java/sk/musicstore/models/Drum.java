package sk.musicstore.models;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Column;
import sk.musicstore.interfaces.IDrum;

@Entity
@Table(name="drum")
public class Drum extends Product implements IDrum {
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
}
