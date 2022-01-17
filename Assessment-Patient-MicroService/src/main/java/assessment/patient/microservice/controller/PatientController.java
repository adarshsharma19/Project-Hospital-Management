package assessment.patient.microservice.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import assessment.patient.microservice.entity.Patient;
import assessment.patient.microservice.response.ResponseTemplate;
import assessment.patient.microservice.service.PatientService;


@RestController
public class PatientController {

	@Autowired
	private PatientService service;
	
	@PostMapping("/addPatient")
	public Patient addPatient(@RequestBody Patient patient) {
		return service.savePatient(patient);
	}
	
	@GetMapping("/patients")
	public List<Patient> getAllPatients(){
		return service.getPatient();
	}
	
	@GetMapping("/patientIds")
	public List<String> getPid() {
		return service.getPid();
	}
	
	@GetMapping("/patientInfo/{pid}")
	public Optional<Patient> getPatientWithId(@PathVariable("pid") int pid) {
		return service.findPatientById(pid);
	}
	
	@GetMapping("/patient/{pid}")
	public @ResponseBody ResponseTemplate checkPatientWithDoctor(@PathVariable("pid") int pid) {
		return service.checkPatientWithDoctor(pid);
	}
	
	@GetMapping("/attendedPatients/docname")
	public int patientsAttendedByDoctorName(@RequestParam String docname) {
		return service.patientsAttendedByDoctorName(docname);
	}
	
	
}
