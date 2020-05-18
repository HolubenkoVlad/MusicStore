package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import sk.musicstore.models.OrderSynthesizer;
import sk.musicstore.models.OrderUserSynthesizer;

public interface OrderSynthesizerRepository extends JpaRepository<OrderUserSynthesizer, Integer> {

}
