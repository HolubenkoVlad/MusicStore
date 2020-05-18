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
		User user=userService.findByLogin(login);
        if (user.getPassword().equals(password)||user.equals(null)) {
        	//list.add(user);
        	model.addAttribute("login", user);
        	return gson.toJson(new ResponseWrapper(true,"account"));
        } else {
        	return gson.toJson(new ResponseWrapper(false,"Wrong login or password!"));
        }
	}
	
	@RequestMapping(value="/logout.do", method=RequestMethod.POST)
	public String logout(@RequestHeader("Referer") String referer, SessionStatus sessionStatus, 
						   @ModelAttribute("login") List<User> user){
		sessionStatus.setComplete();
    	return redirectBack(referer);
	}
	
	private String redirectBack(String referer){
        if (referer != null && referer.contains("/account")) {
        	return "redirect:/";
        } else {
        	return "redirect:"+referer;
        }
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.GET)
	public String registerGet(RegistrationForm regForm, Model model){
		model.addAttribute("regForm", new RegistrationForm());
		return "signup";
	}
	
	@RequestMapping(value="/signup.do", method=RequestMethod.POST)
	public @ResponseBody String registerPost(Model model, @ModelAttribute RegistrationForm regForm){
		String answer=CheckRegForm(regForm);
		User user;
		if(answer==null) {
			user=new User(regForm.getSurname(), regForm.getEmail(), regForm.getLogin(), regForm.getPassword(), new Type(1,"user"));
	        userService.add(user);
	        model.addAttribute("login", user);
	        return gson.toJson(new ResponseWrapper(true,"account"));
		}
		else return gson.toJson(new ResponseWrapper(false,answer));
	}
	
	public String CheckRegForm(RegistrationForm regForm) {
		if(regForm.getSurname()=="") return "Enter surname";
		else if(regForm.getEmail()=="") return "Enter email";
		else if(regForm.getLogin()=="") return "Enter login";
		else if(regForm.getPassword()=="") return "Enter password";
		else if(regForm.getPassword().equals(regForm.getConfirmPassword())) return "The passwords are different!";
		else return null;
	}
}
