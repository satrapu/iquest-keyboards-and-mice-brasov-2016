package ro.satrapu.iqkm.demo.persons;

import ro.satrapu.iqkm.demo.persons.Person;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

/**
 * Manages the persistence of {@link Person} entities.
 */
@Stateless
public class PersonPersistenceService {
    @PersistenceContext
    private EntityManager entityManager;

    /**
     * Fetches all available {@link Person} entities from the underlying database.
     *
     * @return A list of {@link Person} entities.
     */
    public List<Person> getPersons() {
        List<Person> result = new ArrayList<>();
        result.addAll(entityManager.createQuery("SELECT p FROM Person p", Person.class).getResultList());
        return result;
    }
}
