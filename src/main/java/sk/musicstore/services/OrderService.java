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
import sk.musicstore.repositories.OrderUserRepository;

@Service
public class OrderService {
	@Autowired
	OrderDrumRepository orderDrumRep;
	@Autowired
	OrderGuitarRepository orderGuitarRep;
	@Autowired
	OrderSynthesizerRepository orderSynthesizerRep;
	@Autowired
	OrderUserRepository orderUserRep;
	
	public List<OrderUser> add(OrderUser orderUser, Cart cart) {
		OrderUserDrum<OrderDrum> orderDrum=new OrderUserDrum<OrderDrum>(orderUser.getLoginId(),orderUser.getAddress());
		OrderUserGuitar<OrderGuitar> orderGuitar=new OrderUserGuitar(orderUser.getLoginId(),orderUser.getAddress());
		OrderUserSynthesizer orderSynthesizer=new OrderUserSynthesizer(orderUser.getLoginId(),orderUser.getAddress());
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
