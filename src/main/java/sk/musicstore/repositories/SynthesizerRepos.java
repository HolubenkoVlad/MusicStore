package sk.musicstore.repositories;


import org.springframework.stereotype.Repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import sk.musicstore.models.*;

@Repository

public class SynthesizerRepos {
	@PersistenceContext
    private EntityManager entityManager;
	@SuppressWarnings("unchecked")
	public List<Synthesizer> findAll() {
	    Query query = entityManager.createQuery("SELECT e FROM Synthesizer e");
	    return (List<Synthesizer>) query.getResultList();
    }
}
