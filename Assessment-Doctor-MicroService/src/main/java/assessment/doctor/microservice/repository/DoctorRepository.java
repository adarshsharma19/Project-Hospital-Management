package assessment.doctor.microservice.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import assessment.doctor.microservice.entity.Doctor;


@Repository
public interface DoctorRepository extends JpaRepository<Doctor, Integer> {

	public Doctor findBydocname(String docname);
	
}
