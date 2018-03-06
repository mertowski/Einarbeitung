package de.Einarbeitung.NovaTec;



import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

/**
 * @author myu
 */

@Entity
@Table(name = "Noten", schema = "dbo", catalog = "LoginAppDB")
@ManagedBean
@ApplicationScoped
public class Noten {

	@DecimalMax(value = "5.0", message = "Note muss zwischen 1.0 und 5.0 sein!")
	private double note;

	@Id
	@Size(min = 7, max = 7, message = "Matrikelnummer muss 7 Ziffer haben!")
	private String matriculationNumber;

	@Size(min = 3, max = 70)
	private String studentName;

	private String lecture;

	public Noten() {
	}

	public Noten(double note, String matriculationNumber, String studentName, String lecture) {
		this.note = note;
		this.matriculationNumber = matriculationNumber;
		this.studentName = studentName;
		this.lecture = lecture;
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
	@Column(name = "matriculationNumber")
	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(String matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	@Basic
	@Column(name = "studentName")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Basic
	@Column(name = "Lecture")
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

}
