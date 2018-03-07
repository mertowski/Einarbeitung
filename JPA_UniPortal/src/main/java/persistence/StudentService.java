/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import model.Student;

/**
 *
 * @author myu
 */
@Stateless
public class StudentService {
    
    @EJB
    StudentPersistence studentPersistence;
    
    public Student getFirstStudent() {
        return studentPersistence.getStudent();
    }

    public String getStudentName() {
        return studentPersistence.getStudent().getName();
    }

    public String getMatrikelNummer() {
        return studentPersistence.getStudent().getMatriculationNumber();
    }

    public double getNote() {
        return studentPersistence.getStudent().getNote();
    }

    public String getLecture() {
        return studentPersistence.getStudent().getLecture();
    }
   
}
