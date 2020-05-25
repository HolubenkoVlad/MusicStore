package sk.musicstore.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;

import sk.musicstore.exceptions.UserDataException;
import sk.musicstore.models.RegistrationForm;
import sk.musicstore.models.ResponseWrapper;
import sk.musicstore.models.Type;
import sk.musicstore.models.User;
import sk.musicstore.services.UserService;
/**
 * The class processes requests that are related to the user.
 * @see org.springframework.stereotype.Controller
 * @see org.springframework.web.bind.annotation.SessionAttributes
 * */
@Controller
@SessionAttributes(value = {"login", "Cart"})
public class UserController {
	
	/**
	 * Field where UserService is injected
	 * @see org.springframework.beans.factory.annotation.Autowired 
	 * */
	@Autowired
	UserService userService;
	/**
	 * Field where Gson is injected
	 * @see org.springframework.beans.factory.annotation.Autowired 
	 * */
	@Autowired
	Gson gson;
	
	/**
	 * The method calls the method to find the login in the database and compare the login and password with the entered.
	 * @param login -user login
	 * @param password - user password
	 * @param model - used to pass values to render a view
	 * @return the result of finding the user in the database
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * */
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam String login, @RequestParam String password, Model model){
		User user;
		try {
			user=userService.findByLogin(login);
		}catch(UserDataException ex) {
			return gson.toJson(new ResponseWrapper(false,ex.getMessage()));
		}
        if (user.getPassword().equals(password)) {
        	model.addAttribute("login", user);
        	return gson.toJson(new ResponseWrapper(true,"account"));
        } else {
        	return gson.toJson(new ResponseWrapper(false,"Wrong login or password!"));
        }
	}
	
	interface RedirectBack{
	    String redirect(String ref);
	}
	/**
	 * Method removes user from session and redirect to the main page if the request came from the user’s page.
	 * @param referer - page from which the request came
	 * @param sessionStatus - session status
	 * @return the result of finding the user in the database
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * */
	@RequestMapping(value="/logout.do", method=RequestMethod.POST)
	public String logout(@RequestHeader("Referer") String referer, SessionStatus sessionStatus){
		sessionStatus.setComplete();
		RedirectBack redirectBack = (String ref)-> {
			 if (ref != null && ref.contains("/account")) {
		        	return "redirect:/";
		        } else {
		        	return "redirect:"+ref;
		        }
		};
    	return redirectBack.redirect(referer);
	}
	/**
	 * The method will redirect to the page to fill out the registration form and transfer the form object to it
	 * @param regForm - registration form
	 * @param model - used to pass values to render a view
	 * @return page to redirect
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * */
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String registerGet(RegistrationForm regForm, Model model){
		model.addAttribute("regForm", new RegistrationForm());
		return "signup";
	}
	
	interface CheckRegForm{
	    String check(RegistrationForm form);
	}
	/**
	 * The method checks if all fields in the registration form are filled. If so, calls the method to register a new user.
	 * @param regForm - registration form
	 * @param model - used to pass values to render a view
	 * @return page to redirect
	 * @see org.springframework.web.bind.annotation.RequestMapping
	 * @see org.springframework.web.bind.annotation.RequestMethod
	 * */
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public @ResponseBody String registerPost(Model model, @ModelAttribute RegistrationForm regForm){
		CheckRegForm checkRegForm=(RegistrationForm form)->{
			if(regForm.getSurname()=="") return "Enter surname";
			else if(regForm.getEmail()=="") return "Enter email";
			else if(regForm.getLogin()=="") return "Enter login";
			else if(regForm.getPassword()=="") return "Enter password";
			else if(regForm.getPassword().equals(regForm.getConfirmPassword())) return "The passwords are different!";
			else return null;
		};
		String answer=checkRegForm.check(regForm);
		User user;
		if(answer==null&&!(regForm.getSurname().equals("")||regForm.getEmail().equals("")||regForm.getLogin().equals("")||regForm.getPassword().equals(""))) {
			user=new User(regForm.getSurname(), regForm.getEmail(), regForm.getLogin(), regForm.getPassword(), new Type(1,"user"));
	        userService.add(user);
	        model.addAttribute("login", user);
	        return gson.toJson(new ResponseWrapper(true,"account"));
		}
		else return gson.toJson(new ResponseWrapper(false,answer));
	}
}
