package sk.musicstore.interfaces;

/**
 * The interface in which the methods that will be implemented in the Drum class are defined.
 * */

public interface IDrum extends IProduct {
	public void setNumberOfDrums(int numberOfDrums);
	public int getNumberOfDrums();
	public void setColor(String color);
	public String getColor();
	public void setSize(String size);
	public String getSize();
	/**
	 * Default method implementation for return type of product
	 * @return product type - drum
	 * */
	public default String getInsType() {
		return "drum";
	}
}
