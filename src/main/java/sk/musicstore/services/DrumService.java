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
		List<Drum> list=drumRepository.findAll();
		System.out.println("number of strings: "+list.get(0).getNumberOfDrums());
		return list;
	}
}
