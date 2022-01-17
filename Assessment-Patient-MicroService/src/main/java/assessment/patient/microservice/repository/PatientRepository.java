package assessment.patient.microservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import assessment.patient.microservice.entity.Patient;


@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {

//	@Query("from Patient where pid=?101")
//	Patient findByPatientId(int pid);
	
	public int countBydocname(String docname);
	
	@Query("Select pid FROM Patient")
	public List<String> getPatientIds();
	
}
