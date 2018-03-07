/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.transaction.UserTransaction;

import model.Student;
import org.hibernate.resource.transaction.backend.jta.internal.JtaTransactionAdapterUserTransactionImpl;
import persistence.StudentService;


/**
 *
 * @author myu
 */
@ManagedBean
@ApplicationScoped
public class StudentController {

	private Student student = new Student();
	private List<Student> myList = new ArrayList<Student>();
	private String searchLecture;

	@EJB
	private StudentService studentService;


	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public List<Student> getMyList() {
		return myList;
	}

	public void setMyList(List<Student> myList) {
		this.myList = myList;
	}

	public String getSearchLecture() {
		return searchLecture;
	}

	public void setSearchLecture(String searchLecture) {
		this.searchLecture = searchLecture;
	}



	public void createInformations() {

		student = studentService.getFirstStudent();
		myList.add(student);


	}

	public void updateNote() {
		/*for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getLecture().equals(searchLecture)) {
				myList.set(i, student);
			}
		}*/

	}

	public String save() {
		createInformations();
		return "saved";
	}

	public String cancel() {
		return "canceled";
	}

	public String startPage() {
		return "index";
	}

	public String newData() {
		return "noten";
	}

	public String changeData() {
		updateNote();
		return "saved";
	}

	public List<String> completeText(String query) {
		List<String> results = new ArrayList<String>();

		results.add("Fortgeschrittene Programmierung");
		results.add("Grundlagen der Informatik");
		results.add("Verteilte Systeme");

		return results;
	}


}