package sk.musicstore.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.Product;
import sk.musicstore.models.RegistrationForm;
import sk.musicstore.models.ResponseWrapper;
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
	 public List<Drum> getDrums() throws InterruptedException, ExecutionException {
        return drumService.findAll().get();
    }
	
	@RequestMapping(value="/guitars.do", method=RequestMethod.GET)
	 public List<Guitar> getGuitars() throws InterruptedException, ExecutionException {
       return guitarService.findAll().get();
   }
	@RequestMapping(value="/synthesizers.do", method=RequestMethod.GET)
	 public List<Synthesizer> getSynthesizers() throws InterruptedException, ExecutionException {
      return synthesizerService.findAll().get();
  }
	
	@RequestMapping(value="/users.do", method=RequestMethod.GET)
	 public List<User> getUsers() throws InterruptedException, ExecutionException {
     return userService.findAll().get();
 }
	
	@RequestMapping(value="/addguitar.do", method=RequestMethod.POST)
	 public @ResponseBody String addGuitar(@ModelAttribute Guitar guitar){
		try {
			guitarService.addGuitar(guitar);
		} catch (Exception e) {
			return gson.toJson(new ResponseWrapper(true,"No Guitar Added!"));
		}
    return gson.toJson(new ResponseWrapper(true,"Guitar added!"));
}
	
	@RequestMapping(value="/adddrum.do", method=RequestMethod.POST)
	 public @ResponseBody String addDrum(@ModelAttribute Drum drum){
		try {
			drumService.addDrum(drum);
		} catch (Exception e) {
			return gson.toJson(new ResponseWrapper(true,"No Drum Added!"));
		}
   return gson.toJson(new ResponseWrapper(true,"Drum added!"));
}
	
	@RequestMapping(value="/addsynthesizer.do", method=RequestMethod.POST)
	 public @ResponseBody String addSynthesizer(@ModelAttribute Synthesizer synthesizer){
		try {
			synthesizerService.addSynthesizer(synthesizer);
		} catch (Exception e) {
			return gson.toJson(new ResponseWrapper(true,"No Synthesizer Added!"));
		}
  return gson.toJson(new ResponseWrapper(true,"Synthesizer added!"));
}
	
	@RequestMapping(value="/remove_synthesizer.do", method=RequestMethod.GET)
	 public ModelAndView removeSynthesizer(@RequestParam Integer position, ModelMap model){
		try {
			synthesizerService.removeSynthesizer(position);
		} catch (Exception e) {
			System.out.println("Synthesizer not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
}
	
	@RequestMapping(value="/remove_drum.do", method=RequestMethod.GET)
	 public ModelAndView removeDrum(@RequestParam Integer position, ModelMap model){
		try {
			drumService.removeDrum(position);
		} catch (Exception e) {
			System.out.println("Drum not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
}
	
	@RequestMapping(value="/remove_guitar.do", method=RequestMethod.GET)
	 public ModelAndView removeGuitar(@RequestParam Integer position, ModelMap model){
		try {
			guitarService.removeGuitar(position);
		} catch (Exception e) {
			System.out.println("Guitar not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
}
	
	@RequestMapping(value="/remove_user.do", method=RequestMethod.GET)
	 public ModelAndView removeUser(@RequestParam Integer position, ModelMap model){
		try {
			userService.removeUser(position);
		} catch (Exception e) {
			System.out.println("User not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
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
