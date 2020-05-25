package sk.musicstore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import sk.musicstore.models.Drum;
import sk.musicstore.repositories.DrumRepository;

/**
 * The class controls the logic of queries to the drums table in the database.
 * @see org.springframework.stereotype.Service
 * */
@Service
public class DrumService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DrumService.class);
	@Autowired
	DrumRepository drumRepository;
	
	/**
	 * Finds all the drums in the database.
	 * @return a list of drums from the database
	 * @see org.springframework.scheduling.annotation.Async
	 * */
	@Async
	public CompletableFuture<List<Drum>> findAll(){
		CompletableFuture<List<Drum>> list=CompletableFuture.completedFuture(drumRepository.findAll());
		LOGGER.info("Request to get a list of drums");
		return list;
	}
	/**Search for a drum by id
	 * @param id - drum position in the table
	 * @return the found drum
	 * */
	public Drum findById(int id) {
		return drumRepository.getOne(id);
	}
	/**Adds a new drum to the database
	 * @param drum - new drum
	 * @throws java.lang.Exception Called if there are problems with adding a drum.
	 * */
	public void addDrum(Drum drum) throws Exception {
		drumRepository.save(drum);
	}
	/**Removes a drum from the database
	 * @param id - id drum that will be deleted
	 * @throws java.lang.Exception Called if there are problems with adding a drum.
	 * */
	public void removeDrum(int id) throws Exception {
		drumRepository.deleteById(id);
	}
}
