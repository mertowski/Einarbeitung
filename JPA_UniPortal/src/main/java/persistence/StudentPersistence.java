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

import controller.StudentController;
import model.Student;

import java.util.List;

/**
 *
 * @author myu
 */
@Stateless
@Transactional
public class StudentPersistence {

    @PersistenceContext(unitName = "UniPortalDS")
    private EntityManager em;

    StudentController studentController = new StudentController();

    public Student getStudent() {
        /*if (studentController.getMyList() != null) {
            for (int i = 0; i <= studentController.getMyList().size(); i++)*/
               return (Student) em.createQuery("select st from Student st").getResultList().get(1);
    }

}

