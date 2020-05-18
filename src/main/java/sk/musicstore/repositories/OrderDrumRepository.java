package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.musicstore.models.OrderDrum;
import sk.musicstore.models.OrderUserDrum;

public interface OrderDrumRepository extends JpaRepository<OrderUserDrum, Integer> {

}
