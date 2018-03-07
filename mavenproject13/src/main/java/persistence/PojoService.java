package persistence;


import model.TestPojo;

import javax.ejb.EJB;
import javax.ejb.Stateless;

@Stateless
public class PojoService {

    @EJB
    PojoPS pojoPS;

    public TestPojo getFirstPojo(){
        return pojoPS.getFirstPojo();
    }
}
