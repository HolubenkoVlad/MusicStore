package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.musicstore.models.OrderGuitar;
import sk.musicstore.models.OrderUserGuitar;

public interface OrderGuitarRepository extends JpaRepository<OrderUserGuitar, Integer> {

}
