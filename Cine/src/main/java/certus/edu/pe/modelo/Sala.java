package certus.edu.pe.modelo;

import java.io.Serializable;
import java.util.List;




import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import jakarta.persistence.NamedQueries;

@Entity
@Table(name="sala")
//@XmlRootElement

//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor


@NamedQueries({
@NamedQuery(name = "Sala.findAll", query = "SELECT s FROM Sala s"),
@NamedQuery(name = "Sala.findByIdSala", query = "SELECT s FROM Sala s WHERE s.idSala = :idSala"), 
@NamedQuery(name = "Sala.findByNombre", query = "SELECT s FROM Sala s WHERE s.nombre = :nombre"),
@NamedQuery(name = "Sala.findByCapacidad", query = "SELECT s FROM Sala s WHERE s.capacidad = :capacidad")})
public class Sala implements Serializable {


    private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional = false)
	@Column(name= "idSala")
	private Integer idSala;
	@Basic(optional = false)
	@Column(name = "nombre")
	private String nombre;
	@Column(name = "capacidad")
	private Integer capacidad;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "sala" , fetch = FetchType.LAZY)
	@JsonBackReference(value = "sala_func")
	private List<Funciones> funcionesList;
	@JoinColumn(name="sede", referencedColumnName = "idSede")
	@ManyToOne(optional = false)
	private Sede sede;
	
	
	
	
	
}
