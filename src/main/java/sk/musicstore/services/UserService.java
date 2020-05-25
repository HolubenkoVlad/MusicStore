package sk.musicstore.services;

/**
 * The class controls the logic of queries to the user table in the database.
 * @see org.springframework.stereotype.Service
 * */
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import sk.musicstore.exceptions.UserDataException;
import sk.musicstore.models.User;
import sk.musicstore.repositories.UserRepository;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@Service
public class UserService{
	
	private static final Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	@Autowired
	UserRepository userRepository;
	/**
	 * Finds all the users in the database.
	 * @return a list of drums from the database
	 * @see org.springframework.scheduling.annotation.Async
	 * */
	@Async
	public CompletableFuture<List<User>> findAll(){
		CompletableFuture<List<User>> list= CompletableFuture.completedFuture(userRepository.findAll());
		LOGGER.info("Request to get a list of users");
		return list;
	}
	/**Search for a user by id
	 * @param login - user login
	 * @throws sk.musicstore.exceptions.UserDataException Occurs if the user did not enter a login during authorization
	 * @return the found user
	 * */
	public User findByLogin(String login) throws UserDataException{
		if(login.equals("")) throw new UserDataException("Login is empty");
	    return userRepository.findByLogin(login);
	}
	/**Adds a new user to the database
	 * @param user - new user
	 * */
	public void add(User user) {
		userRepository.saveAndFlush(user);
	}
	/**Removes a user from the database
	 * @param id - id user that will be deleted
	 * @throws java.lang.Exception Called if there are problems with adding a user.
	 * */
	public void removeUser(int id) throws Exception{
		userRepository.deleteById(id);
	}
}
