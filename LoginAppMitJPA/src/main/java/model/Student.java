package model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

@Entity
@Table(name = "`Student`", schema = "dbo", catalog = "myDatabase")
public class Student {

	@Size(min = 3, max = 70)
	private String name;

	private String semester;

	@Id
	@Size(min = 7, max = 7, message = "Matrikelnummer muss 7 Ziffer haben!")
	private String matriculationNumber;

	@DecimalMax(value = "5.0", message = "Note muss zwischen 1.0 und 5.0 sein!")
	private double note;

	private String lecture;

	public Student(String name, String username, String password, String semester, String matriculationNumber, double note, String lecture) {
		this.name = name;
		this.semester = semester;
		this.matriculationNumber = matriculationNumber;
		this.note = note;
		this.lecture = lecture;
	}

	public Student() {
	}

	public Student(double note, String matriculationNumber, String name, String lecture) {
	}

	@Basic
	@Column(name = "Name")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	@Basic
	@Column(name = "Matrikelnummer")
	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(String matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	@Basic
	@Column(name = "Note")
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Basic
	@Column(name = "Fach")
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	@Override
	public String toString() {
		return "Student{" +
			"name='" + name + '\'' +
			", semester='" + semester + '\'' +
			", matriculationNumber='" + matriculationNumber + '\'' +
			", note=" + note +
			", lecture='" + lecture + '\'' +
			'}';
	}
}
