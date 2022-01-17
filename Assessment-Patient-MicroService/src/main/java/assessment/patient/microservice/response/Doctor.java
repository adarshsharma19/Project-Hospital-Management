package assessment.patient.microservice.response;

public class Doctor {

	int docid;
	String docname;
	int age;
	String gender;
	String speciality;
	
	
	public Doctor() {}


	public Doctor(int docid, String docname, int age, String gender, String speciality) {
		super();
		this.docid = docid;
		this.docname = docname;
		this.age = age;
		this.gender = gender;
		this.speciality = speciality;
	}


	public int getDocid() {
		return docid;
	}


	public void setDocid(int docid) {
		this.docid = docid;
	}


	public String getDocname() {
		return docname;
	}


	public void setDocname(String docname) {
		this.docname = docname;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getSpeciality() {
		return speciality;
	}


	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}
	
	
	
}
