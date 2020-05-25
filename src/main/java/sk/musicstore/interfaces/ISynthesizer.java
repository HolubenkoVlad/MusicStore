package sk.musicstore.interfaces;

/**
 * The interface in which the methods that will be implemented in the Synthesizer class are defined.
 * */

public interface ISynthesizer extends IProduct {
	public void setNumberOfKeys(int numberOfKeys);
	public int getNumberOfKeys();
	public void setTypeOfKeyboard(String typeOfKeyboard);
	public String getTypeOfKeyboard();
	public void setNumberOfTimbres(int numberOfTimbres);
	public int getNumberOfTimbres();
	/**
	 * Default method implementation for return type of product
	 * @return product type - synthesizer
	 * */
	public default String getInsType() {
		return "synthesizer";
	}
}
