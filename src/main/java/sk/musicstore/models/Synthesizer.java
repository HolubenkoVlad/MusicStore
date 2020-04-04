package sk.musicstore.models;

import javax.persistence.Entity;
import javax.persistence.Table;

import sk.musicstore.interfaces.ISynthesizer;


@Entity
@Table(name="synthesizer")
public class Synthesizer extends Product implements ISynthesizer {
	private int numberOfKeys;
	private String typeOfKeyboard;
	private int numberOfTimbres;
	
	public void setNumberOfKeys(int numberOfKeys) {
		this.numberOfKeys=numberOfKeys;
	}
	
	public int getNumberOfKeys() {
		return this.numberOfKeys;
	}
	
	public void setTypeOfKeyboard(String typeOfKeyboard) {
		this.typeOfKeyboard=typeOfKeyboard;
	}
	
	public String getTypeOfKeyboard() {
		return this.typeOfKeyboard;
	}
	
	public void setNumberOfTimbres(int numberOfTimbres) {
		this.numberOfTimbres=numberOfTimbres;
	}
	
	public int getNumberOfTimbres() {
		return this.numberOfTimbres;
	}
	
	public String toString() {
		return new StringBuilder("Number of keys: ").append(numberOfKeys).
				append("; Type of keyboard: ").append(typeOfKeyboard).append("; Number of timbres: ").append(numberOfTimbres).toString();
	}
}
