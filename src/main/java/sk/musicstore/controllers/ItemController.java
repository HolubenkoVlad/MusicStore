package sk.musicstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.google.gson.Gson;

import sk.musicstore.models.Cart;
import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.Order;
import sk.musicstore.models.OrderDrum;
import sk.musicstore.models.OrderGuitar;
import sk.musicstore.models.OrderSynthesizer;
import sk.musicstore.models.OrderUser;
/*import sk.musicstore.models.Cart;
import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.Order;
import sk.musicstore.models.OrderDrum;
import sk.musicstore.models.OrderGuitar;
import sk.musicstore.models.OrderSynthesizer;*/
import sk.musicstore.models.Product;
import sk.musicstore.models.ResponseWrapper;
import sk.musicstore.models.Synthesizer;
import sk.musicstore.models.User;
import sk.musicstore.services.DrumService;
import sk.musicstore.services.GuitarService;
import sk.musicstore.services.OrderService;
import sk.musicstore.services.ProductService;
import sk.musicstore.services.SessionUtils;
import sk.musicstore.services.SynthesizerService;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.function.Function;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Controller
@SessionAttributes(value = {"login", "order"})
public class ItemController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private DrumService drumService;
	@Autowired
	private GuitarService guitarService;
	@Autowired
	private SynthesizerService synthesizerService;
	@Autowired
	Gson gson;
	@Autowired
	private OrderService orderService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String catalog(Model model) throws InterruptedException, ExecutionException {
		CompletableFuture<List<Product>> products=productService.findAll();
		model.addAttribute("product", products);
        return "catalog";
    }
	
	@RequestMapping(value="/erase_cart.do", method=RequestMethod.GET)
	public String eraseCart(HttpSession session){
		SessionUtils.clearCart(session);
		session.setAttribute("totalprice", (float)0);
		return "redirect:account.jsp";
	}
	
	@RequestMapping(value="/add_to_cart.do", method=RequestMethod.POST)
	public @ResponseBody String addToCart(@RequestParam int id,@RequestParam String type, HttpSession session){
		Order order=null;
		Order temp=null;
		Product product=null;
        Cart cart = SessionUtils.getCart(session);
        System.out.println("count cart: "+cart.getCount());
		if(type.equals("drum")) {
			product=drumService.findById(id);
			order= new OrderDrum((Drum)product,1,product.getPrice());
			temp=cart.findbyId(product.getId(), OrderDrum.class);
		}
		else if(type.equals("guitar")) {
			product=guitarService.findById(id);
			order=new OrderGuitar((Guitar)product,1,product.getPrice());
			temp=cart.findbyId(product.getId(), OrderGuitar.class);
		}	
		else if(type.equals("synthesizer")) {
			product=synthesizerService.findById(id);
			order=new OrderSynthesizer((Synthesizer)product,1,product.getPrice());
			temp=cart.findbyId(product.getId(), OrderSynthesizer.class);
		}
        if(temp==null) {
        	cart.add(order);
        	SessionUtils.storeCart(cart, session);
        }
        else {
        	temp.setCount(1);
        	temp.setTotalprice(product.getPrice());
        	cart.setTotalPrice(product.getPrice());
        	SessionUtils.storeCart(cart, session);
        }  
        return "ok";
	}
	
	@RequestMapping(value="/remove_from_cart.do", method=RequestMethod.GET)
	public String removeFromCart(@RequestParam Integer position, HttpSession session){
		Cart cart = SessionUtils.getCart(session);
	    cart.remove(position);
	    SessionUtils.storeCart(cart, session);
		return "redirect:account.jsp";
	}
	
	@RequestMapping(value="/add_order.do", method=RequestMethod.POST)
	public @ResponseBody String order(@RequestParam String address,
			@ModelAttribute("login") User user, Model model,HttpSession session) {
		Cart cart=SessionUtils.getCart(session);
		if(cart.getCount()==0) {
			return gson.toJson(new ResponseWrapper(false,"Empty cart"));
		}
		if(address=="") {
			return gson.toJson(new ResponseWrapper(false,"No address or card is entered"));
		}	
		OrderUser order=new OrderUser(user.getId(),address);
		List<OrderUser> ordersList= orderService.add(order, cart);
		session.setAttribute("orderob",ordersList);
		StringBuilder order_number=new StringBuilder();
		order_number.append("Order № ");
		for(int i=0;i<ordersList.size();i++) {
			order_number.append(ordersList.get(i).getId());
			if(i!=ordersList.size()-1)
				order_number.append(", ");
		}
		session.setAttribute("orderNumbers",order_number);
		return gson.toJson(new ResponseWrapper(true, "orderpage"));
	}
}
