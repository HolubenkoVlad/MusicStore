package sk.musicstore.models;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import sk.musicstore.interfaces.ISynthesizer;

/**
 * The class is a description of the characteristics of a synthesizer.
 * @see javax.persistence.Entity
 * @see javax.persistence.Table
 * */
@Entity
@Table(name="synthesizer")
public class Synthesizer extends Product implements ISynthesizer, Serializable {
	private int number_of_keys;
	private String type_of_keyboard;
	private int number_of_timbres;
	
	public void setNumberOfKeys(int numberOfKeys) {
		this.number_of_keys=numberOfKeys;
	}
	
	public int getNumberOfKeys() {
		return this.number_of_keys;
	}
	
	public void setTypeOfKeyboard(String typeOfKeyboard) {
		this.type_of_keyboard=typeOfKeyboard;
	}
	
	public String getTypeOfKeyboard() {
		return this.type_of_keyboard;
	}
	
	public void setNumberOfTimbres(int numberOfTimbres) {
		this.number_of_timbres=numberOfTimbres;
	}
	
	public int getNumberOfTimbres() {
		return this.number_of_timbres;
	}
	/**
	 * Returns drum characteristics connected in one line.
	 * */
    @Override
	public String toString() {
		return new StringBuilder("Number of keys: ").append(number_of_keys).
				append("; Type of keyboard: ").append(type_of_keyboard).append("; Number of timbres: ").append(number_of_timbres).toString();
	}
    
	@Override
	public int hashCode() {
		return Objects.hash(number_of_keys, type_of_keyboard, number_of_timbres);
	}
	
}
