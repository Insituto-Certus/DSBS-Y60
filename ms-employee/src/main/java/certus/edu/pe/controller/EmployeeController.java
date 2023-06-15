package certus.edu.pe.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import certus.edu.pe.model.Employee;
import certus.edu.pe.model.exceptions.ResorceNotFoundException;
import certus.edu.pe.repository.EmployeeRepository;

//@CrossOrigin(origins = "http://localhost:4200") // para conectarse a un proyecto Angular
//@CrossOrigin(origins = "http://localhost:3000") // para conectarse a un proyecto React
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

	//inyección de dependencia
	@Autowired
	private EmployeeRepository employeeRepository; //repository
	
	@GetMapping("/employees")
	public List<Employee> getAllEmployees()
	{
		return employeeRepository.findAll();
	}
	
	@GetMapping("/employees/{id}")
	public ResponseEntity<Employee> getEmployeeId(@PathVariable(value = "id") Long employeeId)
	throws  ResorceNotFoundException{
		
		Employee employee = employeeRepository.findById(employeeId).orElseThrow(() ->
		new ResorceNotFoundException("Employee not found for this id : :" + employeeId));
		return ResponseEntity.ok(employee);
		
	}
	
	@PostMapping("employees")
	public Employee createEmployee(@Validated @RequestBody Employee employee) {
		return employeeRepository.save(employee);
	}	
		
	@PutMapping("/employees/{id}")
	public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") Long employeeId,
			@Validated @RequestBody Employee employeeDetails) throws ResorceNotFoundException{
		    Employee employee = employeeRepository.findById(employeeId)
		    .orElseThrow(() -> new ResorceNotFoundException("Employee not found for this id :  :" + employeeId)); 		
		    
		    employee.setFirstName(employeeDetails.getFirstName());
		    employee.setLastName(employeeDetails.getLastName());
		    employee.setEmailId(employeeDetails.getEmailId());
		    
		    final Employee updateEmployee = employeeRepository.save(employee);
		    return ResponseEntity.ok(updateEmployee);
		    
		    	
	}
   
	@DeleteMapping("/employees/{id}")
	public Map<String, Boolean> deleteEmployee (@PathVariable (value = "id") Long employeeId)
	    throws ResorceNotFoundException{
		Employee employee = employeeRepository.findById(employeeId)
				.orElseThrow(() -> new ResorceNotFoundException("Employee not found for this id :  :" + employeeId)); 		
	    employeeRepository.delete(employee);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		 return response;
	
	}
	
	
	
	


}








