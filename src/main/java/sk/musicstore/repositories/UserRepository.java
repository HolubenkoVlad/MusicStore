package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.musicstore.models.User;
/**
 * The class gives access to the user table in the database.
 * @see org.springframework.stereotype.Repository
 * @see org.springframework.data.jpa.repository.JpaRepository
 * */
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByLogin(String login);
}
