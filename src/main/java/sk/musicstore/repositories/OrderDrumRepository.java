package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.musicstore.models.OrderDrum;
import sk.musicstore.models.OrderUserDrum;
@Repository
public interface OrderDrumRepository extends JpaRepository<OrderUserDrum, Integer> {

}
