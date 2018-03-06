package de.Einarbeitung.NovaTec;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 * @author myu
 */
@ManagedBean
@SessionScoped
public class Login implements Serializable {

	private static final long serialVersionUID = 1L;
	Noten noten = new Noten();
	private String username;
	private String passwort;
	private String status;
	private String validation;
	private String searchLecture;
	private List<Noten> myList = new ArrayList<>();

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPasswort() {
		return passwort;
	}

	public void setPasswort(String passwort) {
		this.passwort = passwort;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public List<Noten> getMyList() {
		return myList;
	}

	public void setMyList(List<Noten> myList) {
		this.myList = myList;
	}

	public String getValidation() {
		return validation;
	}

	public void setValidation(String validation) {
		this.validation = validation;
	}

	public String getSearchLecture() {
		return searchLecture;
	}

	public void setSearchLecture(String searchLecture) {
		this.searchLecture = searchLecture;
	}

	public String controlPasswort() {
		if (passwort.equals("nt")) {
			return "success";
		} else {
			FacesMessage msg = new FacesMessage();
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			msg.setSummary("Falsches Username oder Passwort!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "index";
		}
	}

	public String controlUsernameAndPasswort() {
		if ((passwort.equals("123")) && username.equals("schmollinger")) {
			return "prof";
		} else if (username.equals("admin")) {
			return "admin";
		} else {
			return controlPasswort();
		}
	}

	public void createInformations() {
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory( "LoginAppDB" );

		EntityManager entitymanager = emfactory.createEntityManager( );
		entitymanager.getTransaction( ).begin( );

		myList.add(new Noten(noten.getNote(), noten.getMatriculationNumber(), noten.getStudentName(), noten.getLecture()));

		entitymanager.persist(myList);
		entitymanager.getTransaction( ).commit( );

		entitymanager.close( );
		emfactory.close( );

	}

	public void updateNote() {
		for (int i = 0; i < myList.size(); i++) {
			if (myList.get(i).getLecture().equals(searchLecture)) {
				myList.set(i, new Noten(noten.getNote(), noten.getMatriculationNumber(), noten.getStudentName(), noten.getLecture()));
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

	public Noten getNoten() {
		return noten;
	}

	public void setNoten(Noten noten) {
		this.noten = noten;
	}

	public List<String> completeText(String query) {
		List<String> results = new ArrayList<>();

		results.add("Fortgeschrittene Programmierung");
		results.add("Grundlagen der Informatik");
		results.add("Verteilte Systeme");

		return results;
	}
}
