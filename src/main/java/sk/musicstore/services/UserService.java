package sk.musicstore.services;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import sk.musicstore.exceptions.UserDataException;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.User;
import sk.musicstore.repositories.UserRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;
	
	@Async
	public CompletableFuture<List<User>> findAll(){
		CompletableFuture<List<User>> list= CompletableFuture.completedFuture(userRepository.findAll());
		LOGGER.info("Request to get a list of users");
		return list;
	}
	
	public User findByLogin(String login) throws UserDataException{
		if(login.equals("")) throw new UserDataException("Login is empty");
	    return userRepository.findByLogin(login);
	}
	
	public void add(User user) {
		userRepository.saveAndFlush(user);
	}
}
