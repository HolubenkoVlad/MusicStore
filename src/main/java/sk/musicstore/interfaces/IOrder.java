package sk.musicstore.interfaces;

import sk.musicstore.models.OrderUser;
import sk.musicstore.models.Product;
/**
 * The interface in which the methods that will be implemented in the Order class are defined.
 * */
public interface IOrder {
	public int getCount();
	public void setCount(int count);
	public float getTotalprice();
	public void setTotalprice(float totalprice);
	public Product getProduct();
	public void setProduct(Product product);

}
