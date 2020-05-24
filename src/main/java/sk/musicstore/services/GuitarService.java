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

@Service
public class GuitarService {

	private static final Logger LOGGER = LoggerFactory.getLogger(GuitarService.class);
	@Autowired
	GuitarRepository guitarRepository;
	
	@Async
	public CompletableFuture<List<Guitar>> findAll(){
		CompletableFuture<List<Guitar>> list= CompletableFuture.completedFuture(guitarRepository.findAll());
		LOGGER.info("Request to get a list of guitars");
		return list;
	}
	
	public Guitar findById(int id) {
		return guitarRepository.getOne(id);
	}
	
	public void addGuitar(Guitar guitar) throws Exception {
		guitarRepository.save(guitar);
	}
	
	public void removeGuitar(int id) throws Exception {
		guitarRepository.deleteById(id);
	}
}
