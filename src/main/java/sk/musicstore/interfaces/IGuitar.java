package sk.musicstore.interfaces;

/**
 * The interface in which the methods that will be implemented in the Guitar class are defined.
 * */

public interface IGuitar extends IProduct {
	public void setNumberOfStrings(int numberOfStrings);
	public int getNumberOfStrings();
	public void setMaterial(String material);
	public String getMaterial();
	public void setType(String type);
	public String getType();
	/**
	 * Default method implementation for return type of product
	 * @return product type - guitar
	 * */
	public default String getInsType() {
		return "guitar";
	}
}
