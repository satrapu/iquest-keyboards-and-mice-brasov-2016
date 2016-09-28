package ro.satrapu.iqkm.demo.persons;

import ro.satrapu.iqkm.demo.persons.Person;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.stream.IntStream;

/**
 * Populates the underlying database with a bunch of entities.
 */
@Startup
@Singleton
public class DatabaseInitializer {
    private static final int AMOUNT_OF_PERSONS_TO_PERSIST = 5;

    @PersistenceContext
    private EntityManager entityManager;

    @PostConstruct
    public void initializeDatabase() {
        persistPersons(AMOUNT_OF_PERSONS_TO_PERSIST);
    }

    /**
     * Persists a fixed amount of {@link Person} entities.
     *
     * @param amount
     */
    private void persistPersons(int amount) {
        IntStream
                .rangeClosed(1, amount)
                .forEach(index -> {
                    Person person = new Person();
                    person.setFirstName("FirstName_" + index);
                    person.setMiddleName("MiddleName_" + index);
                    person.setLastName("LastName_" + index);

                    entityManager.persist(person);
                });
    }
}
