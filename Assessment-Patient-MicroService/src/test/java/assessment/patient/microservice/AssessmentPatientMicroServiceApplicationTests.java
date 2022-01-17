package assessment.patient.microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import assessment.patient.microservice.entity.Patient;
import assessment.patient.microservice.repository.PatientRepository;
import assessment.patient.microservice.service.PatientService;

@SpringBootTest
class AssessmentPatientMicroServiceApplicationTests {

	@Autowired
	private PatientService service;
	
	@MockBean
	private PatientRepository repository;
	
	@Test
	public void savePatientTest() {
		Patient patient= new Patient(1,"Harsh", 54, "12-01-2021", "Adarsh", "Bedrest");
		when(repository.save(patient)).thenReturn(patient);
		
		assertEquals(patient, service.savePatient(patient));
	}
	
	@Test
	public void getPatientTest() {
		when(repository.findAll()).thenReturn(Stream
		.of(new Patient(10,"Muskan", 24, "16-01-2022", "Rahul", "Paracetamol"), 
		    new Patient(11,"Nikhil", 32, "12-12-2021", "Adarsh", "Combiflame")).collect(Collectors.toList()));
		
		assertEquals(2, service.getPatient().size());
	}
	
	@Test
	public void getPatientIdsTest() {
       int pid=101;
       Optional<Patient> patient= Optional.of(new Patient(101,"Shivam", 50, "16-11-2021", "Richa", "Citrazen"));
       when(repository.findById(pid)).thenReturn(patient);
       
       assertEquals(patient, service.findPatientById(pid));
    }

}
