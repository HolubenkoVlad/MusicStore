package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sk.musicstore.models.Guitar;
/**
 * The class gives access to the guitar table in the database.
 * @see org.springframework.stereotype.Repository
 * @see org.springframework.data.jpa.repository.JpaRepository
 * */
@Repository
public interface GuitarRepository extends JpaRepository<Guitar, Integer> {
}
