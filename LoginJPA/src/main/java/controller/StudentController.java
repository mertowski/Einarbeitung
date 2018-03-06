package controller;

import model.Student;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@ApplicationScoped
public class StudentController {

	private Student student;
	private List<Student> myList = new ArrayList<Student>();
	private String searchLecture;

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
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("LoginAppDB");

		EntityManager entitymanager = emfactory.createEntityManager();
		entitymanager.getTransaction().begin();

		myList.add(new Student(student.getNote(), student.getMatriculationNumber(), student.getName(), student.getLecture()));

		entitymanager.persist(myList);
		entitymanager.getTransaction().commit();

		entitymanager.close();
		emfactory.close();

	}

	public void updateNote() {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getLecture().equals(searchLecture)) {
				myList.set(i, new Student(student.getNote(), student.getMatriculationNumber(), student.getName(), student.getLecture()));
			}
		}
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
