package certus.edu.pe.model.exceptions;

import java.util.Date;

import certus.edu.pe.model.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

public class ErrorDetails {
	private Date timestamp;
	private String message;
	private String details;

}
