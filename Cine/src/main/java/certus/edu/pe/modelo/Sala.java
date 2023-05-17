package certus.edu.pe.modelo;

import java.io.Serializable;
import java.util.List;




import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import javax.persistence.NamedQueries;

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
