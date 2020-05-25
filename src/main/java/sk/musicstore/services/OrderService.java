package sk.musicstore.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.musicstore.models.Cart;
import sk.musicstore.models.Order;
import sk.musicstore.models.OrderDrum;
import sk.musicstore.models.OrderGuitar;
import sk.musicstore.models.OrderSynthesizer;
import sk.musicstore.models.OrderUser;
import sk.musicstore.models.OrderUserDrum;
import sk.musicstore.models.OrderUserGuitar;
import sk.musicstore.models.OrderUserSynthesizer;
import sk.musicstore.repositories.OrderDrumRepository;
import sk.musicstore.repositories.OrderGuitarRepository;
import sk.musicstore.repositories.OrderSynthesizerRepository;
/**
 * The class controls the logic of queries to the order user table and order guitar, order drum, order synthesizer in the database.
 * @see org.springframework.stereotype.Service
 * */
@Service
public class OrderService {
	@Autowired
	OrderDrumRepository orderDrumRep;
	@Autowired
	OrderGuitarRepository orderGuitarRep;
	@Autowired
	OrderSynthesizerRepository orderSynthesizerRep;
	
	/**
	 * Adds ordered goods to  tables their order types.
	 * @param orderUser - customer
	 * @param cart - cart with productss
	 * @return general list of ordered products with assigned customer
	 * */
	public List<OrderUser> add(OrderUser orderUser, Cart cart) {
		OrderUserDrum<OrderDrum> orderDrum=new OrderUserDrum<OrderDrum>(orderUser.getLoginId(),orderUser.getAddress());
		OrderUserGuitar<OrderGuitar> orderGuitar=new OrderUserGuitar(orderUser.getLoginId(),orderUser.getAddress());
		OrderUserSynthesizer<OrderSynthesizer> orderSynthesizer=new OrderUserSynthesizer(orderUser.getLoginId(),orderUser.getAddress());
		for(Order or : cart.getItems()) {
			if(or instanceof OrderDrum ) {
				((OrderDrum)or).setOrder(orderDrum);
				orderDrum.addToList((OrderDrum)or);
			}
			else if(or instanceof OrderGuitar ) {
				((OrderGuitar)or).setOrder(orderGuitar);
				orderGuitar.addToList((OrderGuitar)or);
			}
			else if(or instanceof OrderSynthesizer)	{
				((OrderSynthesizer)or).setOrder(orderSynthesizer);
				orderSynthesizer.addToList((OrderSynthesizer)or);
			}
		}
		List<OrderUser> ordersList=new ArrayList<OrderUser>();
		if(orderDrum.getList().size()!=0)
			ordersList.add(orderDrumRep.save(orderDrum));
		if(orderGuitar.getList().size()!=0)
			ordersList.add(orderGuitarRep.save(orderGuitar));
		if(orderSynthesizer.getList().size()!=0)
			ordersList.add(orderSynthesizerRep.save(orderSynthesizer));
		return ordersList;
		}
}
