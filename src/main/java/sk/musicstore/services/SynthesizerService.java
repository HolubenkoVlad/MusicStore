package sk.musicstore.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Synthesizer;
import sk.musicstore.repositories.SynthesizerRepository;

@Service
public class SynthesizerService {

	@Autowired
	SynthesizerRepository synthesizerRepository;
	
	public List<Synthesizer> findAll(){
		return (List<Synthesizer>)synthesizerRepository.findAll();
	}
	
	public Synthesizer findById(int id) {
		System.out.println("synth id: "+id);
		return synthesizerRepository.getOne(id);
	}
}
