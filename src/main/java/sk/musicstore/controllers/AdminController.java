package sk.musicstore.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.google.gson.Gson;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.Product;
import sk.musicstore.models.Synthesizer;
import sk.musicstore.models.User;
import sk.musicstore.services.DrumService;
import sk.musicstore.services.GuitarService;
import sk.musicstore.services.ProductService;
import sk.musicstore.services.SynthesizerService;
import sk.musicstore.services.UserService;

@RestController
@RequestMapping(value = "/api")
public class AdminController {
	
	@Autowired
	private DrumService drumService;
	@Autowired
	private GuitarService guitarService;
	@Autowired
	private SynthesizerService synthesizerService;
	@Autowired
	private UserService userService;
	@Autowired
	Gson gson;

	@RequestMapping(value="/drums.do", method=RequestMethod.GET)
	 public List<Drum> getDrums() {
        return drumService.findAll();
    }
	
	@RequestMapping(value="/guitars.do", method=RequestMethod.GET)
	 public List<Guitar> getGuitars() {
       return guitarService.findAll();
   }
	@RequestMapping(value="/synthesizers.do", method=RequestMethod.GET)
	 public List<Synthesizer> getSynthesizers() {
      return synthesizerService.findAll();
  }
	
	@RequestMapping(value="/users.do", method=RequestMethod.GET)
	 public List<User> getUsers() {
     return userService.findAll();
 }
	
	/*@RequestMapping(value="/items/{itemId}.do", method=RequestMethod.GET)
	 public Item getItemById(@PathVariable int itemId) {
       return itemService.getById(itemId);
   }
	
	@RequestMapping(value="/items.do", method=RequestMethod.POST)
	 public JsonResponse addItem(@RequestBody Item item) {
		System.out.println(item.getId());
		itemService.add(item);
		return new JsonResponse(true, "Added!");
   }*/
	
	/*@RequestMapping(value="/items/{itemId}.do", method=RequestMethod.PUT)
	 public JsonResponse updateItem(@RequestBody Item item) {
		System.out.println(item.getName());
		itemService.update(item);
		return new JsonResponse(true, "Updated!");
   }
	
	@RequestMapping(value="/items/{from}/{to}.do", method=RequestMethod.GET)
	 public List<Item> getFilteredItems(@RequestParam float min, @RequestParam float max) {
		return itemService.findLim(min, max);		
  }*/
	
}
