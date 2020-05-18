package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.musicstore.models.OrderUser;
import sk.musicstore.models.OrderUserDrum;
import sk.musicstore.models.OrderUserGuitar;

public interface OrderUserRepository extends JpaRepository<OrderUser, Integer>{

}
