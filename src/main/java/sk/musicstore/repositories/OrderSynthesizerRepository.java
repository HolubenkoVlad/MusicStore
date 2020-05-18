package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.musicstore.models.OrderSynthesizer;
import sk.musicstore.models.OrderUserSynthesizer;
@Repository
public interface OrderSynthesizerRepository extends JpaRepository<OrderUserSynthesizer, Integer> {

}
