/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import model.Student;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;


/**
 * @author myu
 */
@Stateless
@Transactional
public class StudentPersistence {

	@PersistenceContext(unitName = "UniPortalDS")
	private EntityManager em;

	public List<Student> getStudent() {

		return (List<Student>) em.createNamedQuery("studentQuery").getResultList();

	}

	public void saveStudentPersistence(Student std) {
		em.persist(std);

	}


}




