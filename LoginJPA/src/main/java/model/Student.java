package model;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

public class Student {

	@Size(min = 3, max = 70)
	private String name;

	private String username;
	private String password;
	private String semester;

	@Size(min = 7, max = 7, message = "Matrikelnummer muss 7 Ziffer haben!")
	private String matriculationNumber;

	@DecimalMax(value = "5.0", message = "Note muss zwischen 1.0 und 5.0 sein!")
	private double note;

	private String lecture;

	public Student(String name, String username, String password, String semester, String matriculationNumber, double note, String lecture) {
		this.name = name;
		this.username = username;
		this.password = password;
		this.semester = semester;
		this.matriculationNumber = matriculationNumber;
		this.note = note;
		this.lecture = lecture;
	}

	public Student() {
	}

	public Student(double note, String matriculationNumber, String name, String lecture) {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
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

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(String matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}
}
