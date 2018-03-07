
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import model.Student;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author myu
 */
public class PersistenceTest {
    
    EntityManager em;
    EntityManagerFactory emf;
    
    @Before
    public void init() {
        emf = Persistence.createEntityManagerFactory("test");
        em = emf.createEntityManager();
    }
    
    @Test
    public void gen() {
        Student st = new Student();
        st.setMatriculationNumber("1234567");
        st.setName("Mert");
        st.setNote(2.5);
        st.setLecture("Verteilte Systeme");
        
        em.getTransaction().begin();

        em.persist(st);

        em.getTransaction().commit();
    }
}
