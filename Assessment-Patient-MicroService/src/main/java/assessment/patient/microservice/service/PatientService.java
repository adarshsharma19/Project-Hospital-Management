package assessment.patient.microservice.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import assessment.patient.microservice.entity.Patient;
import assessment.patient.microservice.repository.PatientRepository;
import assessment.patient.microservice.response.Doctor;
import assessment.patient.microservice.response.ResponseTemplate;

@Service
public class PatientService {
	
    @Autowired
	private PatientRepository repository;
    
    @Autowired
    private RestTemplate restTemplate;
    
    public Patient savePatient(Patient patient) {
        return repository.save(patient);
    }
    
    public List<Patient> getPatient(){
    	return repository.findAll();
    }
    
    public List<String> getPid(){
    	return repository.getPatientIds();
    }
    
    public Optional<Patient> findPatientById(int pid) {
    	return repository.findById(pid);
    }

    public ResponseTemplate checkPatientWithDoctor(int pid) {
    	ResponseTemplate rt=new ResponseTemplate();
    	Patient patient=repository.findById(pid).orElse(null);
    	
    	Doctor doctor= restTemplate.getForObject("http://SERVICE-Doctor/doctor/docname?docname="+patient.getDocname(), Doctor.class);
    	rt.setPatient(patient);
    	rt.setDoctor(doctor);
    	return rt;
    }
    
    public int patientsAttendedByDoctorName(String docname) {
    	return repository.countBydocname(docname);
    }
    
    
    
    
}
