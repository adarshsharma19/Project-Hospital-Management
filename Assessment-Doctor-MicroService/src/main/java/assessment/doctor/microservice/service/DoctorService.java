package assessment.doctor.microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import assessment.doctor.microservice.entity.Doctor;
import assessment.doctor.microservice.repository.DoctorRepository;


@Service
public class DoctorService {

	@Autowired
	DoctorRepository repository;
	
	 public Doctor saveDoctor(Doctor doctor) {
	        return repository.save(doctor);
	    }
	    
	    public List<Doctor> getDoctor(){
	    	return repository.findAll();
	    }
	    
	    public Doctor getDoctorByDocName(String docname) {
	    	return repository.findBydocname(docname);
	    }
	    
}
