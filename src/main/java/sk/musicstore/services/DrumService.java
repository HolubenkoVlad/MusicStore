package sk.musicstore.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.CompletableFuture;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Synthesizer;
import sk.musicstore.repositories.DrumRepository;

@Service
public class DrumService {

	private static final Logger LOGGER = LoggerFactory.getLogger(DrumService.class);
	@Autowired
	DrumRepository drumRepository;
	
	@Async
	public CompletableFuture<List<Drum>> findAll(){
		CompletableFuture<List<Drum>> list=CompletableFuture.completedFuture(drumRepository.findAll());
		LOGGER.info("Request to get a list of drums");
		return list;
	}
	
	public Drum findById(int id) {
		return drumRepository.getOne(id);
	}
}
