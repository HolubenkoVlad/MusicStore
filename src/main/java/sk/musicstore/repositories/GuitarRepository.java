package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.musicstore.models.Guitar;

@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Integer> {
}
