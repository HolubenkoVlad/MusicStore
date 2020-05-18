package sk.musicstore.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.musicstore.exceptions.UserDataException;
import sk.musicstore.models.User;
import sk.musicstore.repositories.UserRepository;

import java.util.List;

@Service
public class UserService{

	@Autowired
	UserRepository userRepository;
	
	public List<User> findAll(){
		return (List<User>)userRepository.findAll();
	}
	
	public User findByLogin(String login) throws UserDataException{
		if(login.equals("")) throw new UserDataException("Login is empty");
	    return userRepository.findByLogin(login);
	}
	
	public void add(User user) {
		userRepository.saveAndFlush(user);
	}
}
