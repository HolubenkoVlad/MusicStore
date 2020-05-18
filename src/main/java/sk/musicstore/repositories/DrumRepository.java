package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.musicstore.models.Drum;

@Repository
public interface DrumRepository extends JpaRepository<Drum, Integer> {
	
}
