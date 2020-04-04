package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.musicstore.models.Synthesizer;

@Repository
public interface SynthesizerRepository extends JpaRepository<Synthesizer, Long> {

}
