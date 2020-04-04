package sk.musicstore.interfaces;

public interface IProduct {
	int getId();
	void setName(String name);
	String getName();
	void setFeature(String feature);
	String getFeature();
	void setPrice(float price);
	float getPrice();
	public String toString();
}
