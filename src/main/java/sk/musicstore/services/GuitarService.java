package sk.musicstore.services;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import sk.musicstore.models.Drum;
import sk.musicstore.models.Guitar;
import sk.musicstore.repositories.GuitarRepository;

@Service
public class GuitarService {

	@Autowired
	GuitarRepository guitarRepository;
	
	public List<Guitar> findAll(){
		return (List<Guitar>)guitarRepository.findAll();
	}
	
	public Guitar findById(int id) {
		return guitarRepository.getOne(id);
	}
}
