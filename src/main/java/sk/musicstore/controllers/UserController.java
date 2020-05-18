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

@Controller
@SessionAttributes(value = {"login", "Cart"})
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	Gson gson;
	
	@RequestMapping(value="/login.do", method=RequestMethod.POST)
	public @ResponseBody String login(@RequestParam String login, @RequestParam String password, Model model){
		//List<User> list=new ArrayList<User>();
		
		User user;
		try {
			user=userService.findByLogin(login);
		}catch(UserDataException ex) {
			return gson.toJson(new ResponseWrapper(false,ex.getMessage()));
		}
        if (user.getPassword().equals(password)) {
        	//list.add(user);
        	model.addAttribute("login", user);
        	return gson.toJson(new ResponseWrapper(true,"account"));
        } else {
        	return gson.toJson(new ResponseWrapper(false,"Wrong login or password!"));
        }
	}
	
	interface RedirectBack{
	    String redirect(String ref);
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.POST)
	public String logout(@RequestHeader("Referer") String referer, SessionStatus sessionStatus, 
						   @ModelAttribute("login") List<User> user){
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
	
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String registerGet(RegistrationForm regForm, Model model){
		model.addAttribute("regForm", new RegistrationForm());
		return "signup";
	}
	
	interface CheckRegForm{
	    String check(RegistrationForm form);
	}
	
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
