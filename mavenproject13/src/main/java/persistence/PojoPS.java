package persistence;

import model.TestPojo;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Stateless
@Transactional
public class PojoPS {

    @PersistenceContext(unitName = "TestDS")
    private EntityManager em;

    public TestPojo getFirstPojo(){
        return (TestPojo) em.createQuery("select p from TestPojo p").getResultList().get(0);
    }


}
