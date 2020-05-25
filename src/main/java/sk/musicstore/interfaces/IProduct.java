package sk.musicstore.interfaces;
/**
 * The interface in which the methods that will be implemented in the Product class are defined.
 * */
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
