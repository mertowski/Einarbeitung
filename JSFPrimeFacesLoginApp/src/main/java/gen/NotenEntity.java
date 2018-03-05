package gen;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Basic;
import javax.persistence.Column;

@Entity
@Table(name = "`LoginApp`", schema = "db", catalog = "LoginAppDB")
public class NotenEntity {

	@Id
	@GeneratedValue
	private Integer id;

	private double note;
	private String matriculationNumber;
	private String studentName;
	private String lecture;

	public NotenEntity(double note, String matriculationNumber, String studentName, String lecture) {
		this.note = note;
		this.matriculationNumber = matriculationNumber;
		this.studentName = studentName;
		this.lecture = lecture;
	}

	public NotenEntity() {
		super();
	}

	@Basic
	@Column(name = "[Note]")
	public double getNote() {
		return note;
	}

	public void setNote(double note) {
		this.note = note;
	}

	@Basic
	@Column(name = "[Matrikulationsnummer]")
	public String getMatriculationNumber() {
		return matriculationNumber;
	}

	public void setMatriculationNumber(String matriculationNumber) {
		this.matriculationNumber = matriculationNumber;
	}

	@Basic
	@Column(name = "[Studentname]")
	public String getStudentName() {
		return studentName;
	}

	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}

	@Basic
	@Column(name = "[Fach]")
	public String getLecture() {
		return lecture;
	}

	public void setLecture(String lecture) {
		this.lecture = lecture;
	}

	@Override
	public String toString() {
		return "NotenEntity{" +
			"note=" + note +
			", matriculationNumber='" + matriculationNumber + '\'' +
			", studentName='" + studentName + '\'' +
			", lecture='" + lecture + '\'' +
			'}';
	}
}
