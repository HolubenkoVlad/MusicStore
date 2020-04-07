package sk.musicstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

/*import sk.musicstore.models.Cart;
import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.Order;
import sk.musicstore.models.OrderDrum;
import sk.musicstore.models.OrderGuitar;
import sk.musicstore.models.OrderSynthesizer;*/
import sk.musicstore.models.Product;
import sk.musicstore.models.Synthesizer;
import sk.musicstore.models.User;
import sk.musicstore.services.ProductService;
import sk.musicstore.services.SessionUtils;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

@Controller
@SessionAttributes(value = {"login", "order"})
public class ItemController {
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(method = RequestMethod.GET)
    public String catalog(Model model) {
		model.addAttribute("product", productService.findAll());
        return "catalog";
    }
	
	/*@RequestMapping(value="/add_to_cart.do", method=RequestMethod.POST)
	public @ResponseBody String addToCart(@RequestParam Product product, HttpSession session){
		Order order=null;
		if(product instanceof Drum) 
			order= new OrderDrum<Drum>((Drum)product,1,product.getPrice());
		else if(product instanceof Guitar)
			order=new OrderGuitar<Guitar>((Guitar)product,1,product.getPrice());
		else if(product instanceof Synthesizer)
			order=new OrderSynthesizer<Synthesizer>((Synthesizer)product,1,product.getPrice());
        Cart cart = SessionUtils.getCart(session);
        Order temp=cart.findbyId(product.getId(), Drum.class);
        if(temp==null) {
        	cart.add(order);
        }
        else {
        	temp.setCount(1);
        	temp.setTotalprice(product.getPrice());
        	
        }        
        float p=SessionUtils.getTotalPrice(session)+product.getPrice();
        SessionUtils.storeTotalPrice(session, p);
        return "ok";
	}*/
}
