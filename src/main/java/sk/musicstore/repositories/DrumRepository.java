package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.musicstore.models.Drum;
/**
 * The class gives access to the drum table in the database.
 * @see org.springframework.stereotype.Repository
 * @see org.springframework.data.jpa.repository.JpaRepository
 * */
@Repository
public interface DrumRepository extends JpaRepository<Drum, Integer> {
	
}
