/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.Size;

/**
 * @author myu
 */

@Entity
@NamedQueries({@NamedQuery(name = "studentQuery", query = "select s from Student s")})
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Size(min = 3, max = 70)
	private String name;

	@Size(min = 7, max = 7, message = "Matrikelnummer muss 7 Ziffer haben!")
	private String matriculationNumber;

	@DecimalMax(value = "5.0", message = "Note muss zwischen 1.0 und 5.0 sein!")
	private double note;

	private String lecture;

	public Student(String name, String matriculationNumber, double note, String lecture) {
		this.name = name;
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
