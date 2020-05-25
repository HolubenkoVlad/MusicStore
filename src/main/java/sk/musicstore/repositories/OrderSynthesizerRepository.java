package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import sk.musicstore.models.OrderUserSynthesizer;

/**
 * The class gives access to the user order table in the database.
 * @see org.springframework.stereotype.Repository
 * @see org.springframework.data.jpa.repository.JpaRepository
 * */
@Repository
public interface OrderSynthesizerRepository extends JpaRepository<OrderUserSynthesizer, Integer> {

}
