/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import model.Student;

/**
 *
 * @author myu
 */
@Stateless
@Transactional
public class StudentPersistence {
    
    @PersistenceContext(unitName = "UniPortalDS")
    private EntityManager em;
    
    public Student getStudent() {
        return (Student) em.createQuery("select st from Student st").getResultList().get(0);
    }
    
}
