package sk.musicstore.interfaces;

public interface ISynthesizer extends IProduct {
	public void setNumberOfKeys(int numberOfKeys);
	public int getNumberOfKeys();
	public void setTypeOfKeyboard(String typeOfKeyboard);
	public String getTypeOfKeyboard();
	public void setNumberOfTimbres(int numberOfTimbres);
	public int getNumberOfTimbres();
}
