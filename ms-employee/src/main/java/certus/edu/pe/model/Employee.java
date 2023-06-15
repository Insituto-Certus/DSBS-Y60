package certus.edu.pe.model;

import java.io.Serializable;
import java.util.List;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Entity
@Table(name="employees")

//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

public class Employee implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(name="firstName", nullable = false)
	private String firstName;
	
	@Column(name="lastName", nullable = false)
	private String lastName;
	
	@Column(name="email_adress", nullable = false)
	private String emailId;
	
	

}
