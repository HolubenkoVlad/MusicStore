package sk.musicstore.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
/**
 *The class that implements a cart with a list of products and a total amount for products.
 * */
public class Cart implements Serializable{
	/**Total price Attribute*/
	float totalPrice;
	/**Total price getter
	 * @return total price
	 * */
	public float getTotalPrice() {
		return totalPrice;
	}
	/**Total price setter.
	 * @param totalPrice - the price for the product you want to add
	 * */
	public void setTotalPrice(float totalPrice) {
		this.totalPrice += totalPrice;
	}
	/**Product list in cart*/
	List<Order> list=new ArrayList<Order>();
	
	
	/**
	 * Adding a new product to the cart
	 * @param order - new product in the cart
	 * */
	public void add(Order order) {
        list.add(order);
        this.totalPrice+=order.getTotalprice();
    }
	/**Product list getter.
	 * @return order list
	 * */
    public List<Order> getItems(){
        return new ArrayList<Order>(list);
    }
    /**Returns the product by id.
     * @param i - list product number
     * @return Order
     * */
    public Order getId(int i) {
    	return list.get(i);
    }
    /**Number of cart items
     * @return the number of products in the cart
     * */
    public int getCount() {
        return list.size();
    }
    /**Removes products from the cart and takes the price from the total price.
     * @param pos - list product number
     * */
    public void remove(int pos) {
    	this.totalPrice-=list.get(pos).getTotalprice();
        list.remove(pos);
    }

    /**Searches for goods by id and compares product type.
     * @param id - list product number
     * @param <E> - type of product
     * @param product - product for comparison
     * @return the found Orderin the list
     * */
	public <E> Order findbyId(int id, Class<E> product) {
		for(int i=0;i<list.size();i++) {
    		if(list.get(i).getProduct().getId()==id && product.isAssignableFrom(list.get(i).getClass())) {
    			return  ((Order)list.get(i));   			
    		}
    	}
		return null;
	}

}
