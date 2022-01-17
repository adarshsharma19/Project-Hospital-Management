package assessment.doctor.microservice;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import assessment.doctor.microservice.entity.Doctor;
import assessment.doctor.microservice.repository.DoctorRepository;
import assessment.doctor.microservice.service.DoctorService;



@SpringBootTest
class AssessmentDoctorMicroServiceApplicationTests {

	@Autowired
	private DoctorService service;
	
	@MockBean
	private DoctorRepository repository;
	
	
	@Test
	public void saveDoctorTest() {
		Doctor doc= new Doctor(10,"Rahul", 54, "Male", "Pediatrcian");
		when(repository.save(doc)).thenReturn(doc);
		
		assertEquals(doc, service.saveDoctor(doc));
	}
	
	@Test
	public void getDoctorTest() {
		when(repository.findAll()).thenReturn(Stream
		.of(new Doctor(1,"Adarsh",24,"Male","Surgeon"), new Doctor(2,"Aman",32,"Male","Neurologist")).collect(Collectors.toList()));
		
		assertEquals(2, service.getDoctor().size());
	}
	
	@Test
	public void getDoctorByName() {
		String docname="Adarsh";
        Doctor doctor= new Doctor(3,"Adarsh", 36, "Male", "Physician");
        when(repository.findBydocname(docname)).thenReturn(doctor);
        assertEquals(doctor, service.getDoctorByDocName(docname));
	}


}
