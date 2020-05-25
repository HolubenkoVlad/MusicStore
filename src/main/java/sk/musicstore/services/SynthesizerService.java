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
import sk.musicstore.repositories.SynthesizerRepository;
/**
 * The class controls the logic of queries to the synthesizers table in the database.
 * @see org.springframework.stereotype.Service
 * */
@Service
public class SynthesizerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SynthesizerService.class);
	@Autowired
	SynthesizerRepository synthesizerRepository;
	/**
	 * Finds all the synthesizers in the database.
	 * @return a list of drums from the database
	 * @see org.springframework.scheduling.annotation.Async
	 * */
	@Async
	public CompletableFuture<List<Synthesizer>> findAll(){
		CompletableFuture<List<Synthesizer>> list= CompletableFuture.completedFuture(synthesizerRepository.findAll());
		LOGGER.info("Request to get a list of synthesizers");
		return list;
	}
	/**Search for a synthesizer by id
	 * @param id - synthesizer position in the table
	 * @return the found guitar
	 * */
	public Synthesizer findById(int id) {
		return synthesizerRepository.getOne(id);
	}
	/**Adds a new synthesizer to the database
	 * @param synthesizer - new synthesizer
	 * @throws java.lang.Exception Called if there are problems with adding a synthesizer.
	 * */
	public void addSynthesizer(Synthesizer synthesizer) throws Exception {
		synthesizerRepository.save(synthesizer);
	}
	/**Removes a synthesizer from the database
	 * @param id - id synthesizer that will be deleted
	 * @throws java.lang.Exception Called if there are problems with adding a synthesizer.
	 * */
	public void removeSynthesizer(int id) throws Exception {
		synthesizerRepository.deleteById(id);
	}
}
