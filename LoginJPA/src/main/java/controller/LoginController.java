package controller;

import model.Admin;
import model.Professor;
import model.Student;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class LoginController implements Serializable {

	private static final long serialVersionUID = 1L;

	private Admin administrator = new Admin();
	private Student student = new Student();
	private Professor prof = new Professor();

	private String username;
	private String password;

	public LoginController() {
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String controlPasswort() {
		if (student.getPassword().equals("123") && student.getUsername().equals("mert")) {
			return "success";
		} else if (administrator.getPassword().equals("123") && administrator.getUsername().equals("admin")) {
			return "admin";
		} else if (prof.getPassword().equals("123") && prof.getUsername().equals("schmollinger")) {
			return "prof";
		} else {
			FacesMessage msg = new FacesMessage();
			msg.setSeverity(FacesMessage.SEVERITY_INFO);
			msg.setSummary("Username oder Passwort ist falsch!");
			FacesContext.getCurrentInstance().addMessage(null, msg);
			return "index";
		}
	}



}
