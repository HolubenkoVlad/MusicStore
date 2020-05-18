package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.musicstore.models.OrderGuitar;
import sk.musicstore.models.OrderUserGuitar;
@Repository
public interface OrderGuitarRepository extends JpaRepository<OrderUserGuitar, Integer> {

}
