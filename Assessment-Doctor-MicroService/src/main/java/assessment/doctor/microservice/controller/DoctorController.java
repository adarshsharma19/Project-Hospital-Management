package assessment.doctor.microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import assessment.doctor.microservice.entity.Doctor;
import assessment.doctor.microservice.service.DoctorService;


@RestController
public class DoctorController {

	
	@Autowired
	DoctorService service;
	
	@PostMapping("/addDoctor")
	public Doctor addDoctor(@RequestBody Doctor doctor) {
		return service.saveDoctor(doctor);
	}
	
	@GetMapping("/doctors")
	public List<Doctor> getAllDocotrs(){
		return service.getDoctor();
	}
	
	@GetMapping(value="/doctor/docname")
	public Doctor getDoctorByDocName(@RequestParam String docname) {
		return service.getDoctorByDocName(docname);
	}

}
