package sk.musicstore.interfaces;

public interface IDrum extends IProduct {
	public void setNumberOfDrums(int numberOfDrums);
	public int getNumberOfDrums();
	public void setColor(String color);
	public String getColor();
	public void setSize(String size);
	public String getSize();
}
