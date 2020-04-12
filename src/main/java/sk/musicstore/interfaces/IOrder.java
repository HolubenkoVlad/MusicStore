package sk.musicstore.interfaces;

import sk.musicstore.models.OrderUser;

public interface IOrder<E extends IProduct> {
	public OrderUser<E> getOrder();
	public void setOrder(OrderUser<E> order);
	public int getCount();
	public void setCount(int count);
	public float getTotalprice();
	public void setTotalprice(float totalprice);

}
