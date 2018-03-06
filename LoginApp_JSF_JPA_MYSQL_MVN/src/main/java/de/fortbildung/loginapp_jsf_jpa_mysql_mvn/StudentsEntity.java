package de.fortbildung.loginapp_jsf_jpa_mysql_mvn;

import javax.persistence.*;

@Entity
@Table(name = "students", schema = "dbo", catalog = "dbo")
public class StudentsEntity {
	private String matriculationNumber;
	private String name;
	private Integer note;
	private String lecture;

	@Id
	@Column(name = "matriculationNumber", nullable = false, length = 7)
	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(String matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	@Basic
	@Column(name = "name", nullable = true, length = 50)
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Basic
	@Column(name = "note", nullable = true, precision = 0)
	public Integer getNote() {
		return note;
	}

	public void setNote(Integer note) {
		this.note = note;
	}

	@Basic
	@Column(name = "lecture", nullable = true, length = 50)
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		StudentsEntity that = (StudentsEntity) o;

		if (matriculationNumber != null ? !matriculationNumber.equals(that.matriculationNumber) : that.matriculationNumber != null)
			return false;
		if (name != null ? !name.equals(that.name) : that.name != null) return false;
		if (note != null ? !note.equals(that.note) : that.note != null) return false;
		if (lecture != null ? !lecture.equals(that.lecture) : that.lecture != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = matriculationNumber != null ? matriculationNumber.hashCode() : 0;
		result = 31 * result + (name != null ? name.hashCode() : 0);
		result = 31 * result + (note != null ? note.hashCode() : 0);
		result = 31 * result + (lecture != null ? lecture.hashCode() : 0);
		return result;
	}
}
