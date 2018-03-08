/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import model.Student;

import java.util.List;

/**
 * @author myu
 */
@Stateless
public class StudentService {

	@EJB
	StudentPersistence studentPersistence;

	public List<Student> getStudent() {
		return studentPersistence.getStudent();
	}

	public void saveStudents(Student std) {
		studentPersistence.saveStudentPersistence(std);
	}

}
