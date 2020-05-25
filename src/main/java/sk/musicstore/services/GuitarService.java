package sk.musicstore.services;


import java.util.List;
import java.util.concurrent.CompletableFuture;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.models.Synthesizer;
import sk.musicstore.repositories.GuitarRepository;
/**
 * The class controls the logic of queries to the guitars table in the database.
 * @see org.springframework.stereotype.Service
 * */
@Service
public class GuitarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GuitarService.class);
	@Autowired
	GuitarRepository guitarRepository;
	/**
	 * Finds all the guitars in the database.
	 * @return a list of drums from the database
	 * @see org.springframework.scheduling.annotation.Async
	 * */
	@Async
	public CompletableFuture<List<Guitar>> findAll(){
		CompletableFuture<List<Guitar>> list= CompletableFuture.completedFuture(guitarRepository.findAll());
		LOGGER.info("Request to get a list of guitars");
		return list;
	}
	/**Search for a guitar by id
	 * @param id - guitar position in the table
	 * @return the found guitar
	 * */
	public Guitar findById(int id) {
		return guitarRepository.getOne(id);
	}
	/**Adds a new guitar to the database
	 * @param guitar - new guitar
	 * @throws java.lang.Exception Called if there are problems with adding a guitar.
	 * */
	public void addGuitar(Guitar guitar) throws Exception {
		guitarRepository.save(guitar);
	}
	/**Removes a guitar from the database
	 * @param id - id guitar that will be deleted
	 * @throws java.lang.Exception Called if there are problems with adding a guitar.
	 * */
	public void removeGuitar(int id) throws Exception {
		guitarRepository.deleteById(id);
	}
}
