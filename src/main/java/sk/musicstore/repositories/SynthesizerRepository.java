package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.musicstore.models.Synthesizer;
/**
 * The class gives access to the synthesizer table in the database.
 * @see org.springframework.stereotype.Repository
 * @see org.springframework.data.jpa.repository.JpaRepository
 * */
@Repository
public interface SynthesizerRepository extends JpaRepository<Synthesizer, Integer> {

}

