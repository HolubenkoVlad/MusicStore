package sk.musicstore.models;

import java.util.ArrayList;
import java.util.List;

public class Cart {
	public List<Order> list=new ArrayList<Order>();
	
	public void add(Order order) {
        list.add(order);
    }

    public List<Order> getItems(){
        return new ArrayList<Order>(list);
    }
    
    public Order getId(int i) {
    	return list.get(i);
    }

    public int getCount() {
        return list.size();
    }

    public void remove(int pos) {
        list.remove(pos);
    }

	public Float removebyId(int parseInt) {
		float temp;
		for(int i=0;i<list.size();i++) {
    		if(list.get(i).getProduct().getId()==parseInt) {
    			System.out.println("Remoted id "+i);
    			temp=list.get(i).getProduct().getPrice();
    			list.remove(i);
    			return temp;
    		}
    	}
		return null;
	}
	
	public <E> Order findbyId(int id, Class<E> product) {
		for(int i=0;i<list.size();i++) {
    		if(list.get(i).getProduct().getId()==id && product.isAssignableFrom(list.get(i).getClass())) {
    			return  ((Order)list.get(i));   			
    		}
    	}
		return null;
	}

}
