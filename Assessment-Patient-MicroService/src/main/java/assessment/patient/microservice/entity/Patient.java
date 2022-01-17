package assessment.patient.microservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Patient {

	@Id
	int pid;
	String pname;
	int age;
	String dateofvisit;
	String docname;
	String prescription;
	
	public Patient() {}

	public Patient(int pid, String pname,int age, String dateofvisit, String docname, String prescription) {
		super();
		this.pid = pid;
		this.pname = pname;
		this.age=age;
		this.dateofvisit = dateofvisit;
		this.docname = docname;
		this.prescription=prescription;
	}


	public int getPid() {
		return pid;
	}

	public void setPid(int pid) {
		this.pid = pid;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getDateofvisit() {
		return dateofvisit;
	}

	public void setDateofvisit(String dateofvisit) {
		this.dateofvisit = dateofvisit;
	}
	
    public String getDocname() {
		return docname;
	}

	public void setDocname(String docname) {
		this.docname = docname;
	}

	public String getPrescription() {
		return prescription;
	}

	public void setPrescription(String prescription) {
		this.prescription = prescription;
	}

	@Override
	public String toString() {
		return "Patient [pid=" + pid + ", pname=" + pname + ", age=" + age + ", dateofvisit=" + dateofvisit
				+ ", docname=" + docname + ", prescription=" + prescription + "]";
	}

	




	
}
