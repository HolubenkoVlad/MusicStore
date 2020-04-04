package sk.musicstore.interfaces;

public interface IGuitar extends IProduct {
	public void setNumberOfStrings(int numberOfStrings);
	public int getNumberOfStrings();
	public void setMaterial(String material);
	public String getMaterial();
	public void setType(String type);
	public String getType();
}
