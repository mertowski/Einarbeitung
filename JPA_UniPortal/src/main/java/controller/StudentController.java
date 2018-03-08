/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import model.Student;
import persistence.StudentService;

import javax.ejb.EJB;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;


/**
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

		//myList.add(student);
		studentService.saveStudents(student);
		myList = studentService.getFirstStudent();
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