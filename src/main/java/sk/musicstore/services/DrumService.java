package sk.musicstore.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import sk.musicstore.models.Drum;
import sk.musicstore.repositories.DrumRepository;

@Service
public class DrumService {

	@Autowired
	DrumRepository drumRepository;
	
	List<Drum> findAll(){
		return (List<Drum>)drumRepository.findAll();
	}
}
