package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.musicstore.models.OrderUser;
import sk.musicstore.models.OrderUserDrum;
import sk.musicstore.models.OrderUserGuitar;
@Repository
public interface OrderUserRepository extends JpaRepository<OrderUser, Integer>{

}
