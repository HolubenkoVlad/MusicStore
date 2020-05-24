package sk.musicstore.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import sk.musicstore.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
	User findByLogin(String login);
}
