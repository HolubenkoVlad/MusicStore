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

@Service
public class SynthesizerService {

	private static final Logger LOGGER = LoggerFactory.getLogger(SynthesizerService.class);
	@Autowired
	SynthesizerRepository synthesizerRepository;
	
	@Async
	public CompletableFuture<List<Synthesizer>> findAll(){
		CompletableFuture<List<Synthesizer>> list= CompletableFuture.completedFuture(synthesizerRepository.findAll());
		LOGGER.info("Request to get a list of synthesizers");
		return list;
	}
	
	public Synthesizer findById(int id) {
		System.out.println("synth id: "+id);
		return synthesizerRepository.getOne(id);
	}
	
	public void addSynthesizer(Synthesizer synthesizer) throws Exception {
		synthesizerRepository.save(synthesizer);
	}
	
	public void removeSynthesizer(int id) throws Exception {
		synthesizerRepository.deleteById(id);
	}
}
