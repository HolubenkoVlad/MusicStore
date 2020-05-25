package sk.musicstore.controllers;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.ResponseWrapper;
import sk.musicstore.models.Synthesizer;
import sk.musicstore.models.User;
import sk.musicstore.services.DrumService;
import sk.musicstore.services.GuitarService;
import sk.musicstore.services.SynthesizerService;
import sk.musicstore.services.UserService;

/**
 * AdminController processes requests that come from the site administrator
 * @see org.springframework.web.bind.annotation.RestController
 * @see org.springframework.web.bind.annotation.RequestMapping
 * */

@RestController
@RequestMapping(value = "/api")
public class AdminController {
	/**
	 * Field where DrumService is injected
	 * @see org.springframework.beans.factory.annotation.Autowired 
	 * */
	@Autowired
	private DrumService drumService;
	/**
	 * Field where GuitarService is injected
	 * @see org.springframework.beans.factory.annotation.Autowired 
	 * */
	@Autowired
	private GuitarService guitarService;
	/**
	 * Field where SynthesizerService is injected
	 * @see org.springframework.beans.factory.annotation.Autowired 
	 * */
	@Autowired
	private SynthesizerService synthesizerService;
	/**
	 * Field where UserService is injected
	 * @see org.springframework.beans.factory.annotation.Autowired 
	 * */
	@Autowired
	private UserService userService;
	/**
	 * Field where Gson is injected
	 * @see org.springframework.beans.factory.annotation.Autowired 
	 * */
	@Autowired
	private Gson gson;

	/**
	 * Calls a method to get a list of all drums
	 * @return a list of drums
	 * @see sk.musicstore.services.DrumService#findAll()
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @throws java.util.concurrent.ExecutionException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * @throws java.lang.InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * */
	@RequestMapping(value="/drums.do", method=RequestMethod.GET)
	 public List<Drum> getDrums() throws InterruptedException, ExecutionException {
        return drumService.findAll().get();
    }
	
	/**
	 * Calls a method to get a list of all guitars
	 * @return a list of guitars
	 * @see sk.musicstore.services.GuitarService#findAll()
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @throws java.util.concurrent.ExecutionException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * @throws java.lang.InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * */
	@RequestMapping(value="/guitars.do", method=RequestMethod.GET)
	 public List<Guitar> getGuitars() throws InterruptedException, ExecutionException {
       return guitarService.findAll().get();
   }
	/**
	 * Calls a method to get a list of all synthesizers
	 * @return a list of synthesizers
	 * @see sk.musicstore.services.SynthesizerService#findAll()
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @throws java.util.concurrent.ExecutionException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * @throws java.lang.InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * */
	@RequestMapping(value="/synthesizers.do", method=RequestMethod.GET)
	 public List<Synthesizer> getSynthesizers() throws InterruptedException, ExecutionException {
      return synthesizerService.findAll().get();
  }
	
	/**
	 * Calls a method to get a list of all users
	 * @return a list of users
	 * @see sk.musicstore.services.UserService#findAll()
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @throws java.util.concurrent.ExecutionException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * @throws java.lang.InterruptedException Thrown when a thread is waiting, sleeping, or otherwise occupied,and the thread is interrupted, either before or during the activity. 
	 * */
	@RequestMapping(value="/users.do", method=RequestMethod.GET)
	 public List<User> getUsers() throws InterruptedException, ExecutionException {
     return userService.findAll().get();
 }
	/**
	 * Adds a new guitar to the database
	 * @param guitar - guitar data
	 * @return the result of adding a guitar
	 * @see sk.musicstore.services.GuitarService#addGuitar(Guitar guitar)
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @see org.springframework.web.bind.annotation.ResponseBody
	 * @see org.springframework.web.bind.annotation.ModelAttribute
	 * */
	@RequestMapping(value="/addguitar.do", method=RequestMethod.POST)
	 public @ResponseBody String addGuitar(@ModelAttribute Guitar guitar){
		try {
			guitarService.addGuitar(guitar);
		} catch (Exception e) {
			return gson.toJson(new ResponseWrapper(true,"No Guitar Added!"));
		}
    return gson.toJson(new ResponseWrapper(true,"Guitar added!"));
}
	/**
	 * Adds a new drum to the database
	 * @param drum - drum data
	 * @return the result of adding a drum
	 * @see sk.musicstore.services.DrumService#addDrum(Drum drum)
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @see org.springframework.web.bind.annotation.ResponseBody
	 * @see org.springframework.web.bind.annotation.ModelAttribute
	 * */
	@RequestMapping(value="/adddrum.do", method=RequestMethod.POST)
	 public @ResponseBody String addDrum(@ModelAttribute Drum drum){
		try {
			drumService.addDrum(drum);
		} catch (Exception e) {
			return gson.toJson(new ResponseWrapper(true,"No Drum Added!"));
		}
   return gson.toJson(new ResponseWrapper(true,"Drum added!"));
}
	/**
	 * Adds a new synthesizer to the database
	 * @param synthesizer - synthesizer data
	 * @return the result of adding a synthesizer
	 * @see sk.musicstore.services.SynthesizerService#addSynthesizer(Synthesizer synthesizer)
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @see org.springframework.web.bind.annotation.ResponseBody
	 * @see org.springframework.web.bind.annotation.ModelAttribute
	 * */
	@RequestMapping(value="/addsynthesizer.do", method=RequestMethod.POST)
	 public @ResponseBody String addSynthesizer(@ModelAttribute Synthesizer synthesizer){
		try {
			synthesizerService.addSynthesizer(synthesizer);
		} catch (Exception e) {
			return gson.toJson(new ResponseWrapper(true,"No Synthesizer Added!"));
		}
  return gson.toJson(new ResponseWrapper(true,"Synthesizer added!"));
}
	/**
	 * Removes the synthesizer for the given id from the database
	 * @param position - id synthesizer that will be deleted
	 * @param model - used to pass values to render a view
	 * @return link to redirect
	 * @see sk.musicstore.services.SynthesizerService#removeSynthesizer(int id)
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @see org.springframework.web.bind.annotation.ResponseBody
	 * @see org.springframework.web.bind.annotation.ModelAttribute
	 * @see org.springframework.web.servlet.ModelAndView
	 * */
	@RequestMapping(value="/remove_synthesizer.do", method=RequestMethod.GET)
	 public ModelAndView removeSynthesizer(@RequestParam Integer position, ModelMap model){
		try {
			synthesizerService.removeSynthesizer(position);
		} catch (Exception e) {
			System.out.println("Synthesizer not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
}
	/**
	 * Removes the drum for the given id from the database
	 * @param position - id drum that will be deleted
	 * @param model - used to pass values to render a view
	 * @return link to redirect
	 * @see sk.musicstore.services.DrumService#removeDrum(int id)
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @see org.springframework.web.bind.annotation.ResponseBody
	 * @see org.springframework.web.bind.annotation.ModelAttribute
	 * @see org.springframework.web.servlet.ModelAndView
	 * */
	@RequestMapping(value="/remove_drum.do", method=RequestMethod.GET)
	 public ModelAndView removeDrum(@RequestParam Integer position, ModelMap model){
		try {
			drumService.removeDrum(position);
		} catch (Exception e) {
			System.out.println("Drum not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
}
	/**
	 * Removes the guitar for the given id from the database
	 * @param position - id guitar that will be deleted
	 * @param model - used to pass values to render a view
	 * @return link to redirect
	 * @see sk.musicstore.services.GuitarService#removeGuitar(int id)
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @see org.springframework.web.bind.annotation.ResponseBody
	 * @see org.springframework.web.bind.annotation.ModelAttribute
	 * @see org.springframework.web.servlet.ModelAndView
	 * */
	@RequestMapping(value="/remove_guitar.do", method=RequestMethod.GET)
	 public ModelAndView removeGuitar(@RequestParam Integer position, ModelMap model){
		try {
			guitarService.removeGuitar(position);
		} catch (Exception e) {
			System.out.println("Guitar not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
}
	/**
	 * Removes the user for the given id from the database
	 * @param position - id user that will be deleted
	 * @param model - used to pass values to render a view
	 * @return link to redirect
	 * @see sk.musicstore.services.UserService#removeUser(int id)
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * @see org.springframework.web.bind.annotation.ResponseBody
	 * @see org.springframework.web.bind.annotation.ModelAttribute
	 * @see org.springframework.web.servlet.ModelAndView
	 * */
	@RequestMapping(value="/remove_user.do", method=RequestMethod.GET)
	 public ModelAndView removeUser(@RequestParam Integer position, ModelMap model){
		try {
			userService.removeUser(position);
		} catch (Exception e) {
			System.out.println("User not deleted!");
		}
		return new ModelAndView("redirect:/account.jsp", model);
	}	
}
