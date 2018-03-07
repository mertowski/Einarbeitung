import model.TestPojo;
import org.junit.Before;
import org.junit.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceTest {

    EntityManager em;
    EntityManagerFactory emf;

    @Before
    public void init(){
        emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
    }

    @Test
    public void gen(){
        TestPojo p = new TestPojo();
        p.setName("Test");

        em.getTransaction().begin();

        em.persist(p);

        em.getTransaction().commit();
    }
}
