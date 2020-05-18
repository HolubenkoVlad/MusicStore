package sk.musicstore.interfaces;

import sk.musicstore.models.OrderUser;
import sk.musicstore.models.Product;

public interface IOrder {
	public int getCount();
	public void setCount(int count);
	public float getTotalprice();
	public void setTotalprice(float totalprice);

}
