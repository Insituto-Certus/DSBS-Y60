package certus.edu.pe.modelo;

import java.io.Serializable;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;



@Entity
@Table(name="funciones")

// Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
	@NamedQuery (name = "Funciones.findAll", query = "SELECT f FROM Funciones f")
	,@NamedQuery(name="Funciones.findByIdFunciones", query = "SELECT f FROM Funciones f WHERE f.idFunciones = :idFunciones")
	,@NamedQuery(name = "Funciones.findByHoraInicio", query = "SELECT f FROM Funciones f WHERE f.horaInicio = :horaInicio")
    ,@NamedQuery(name = "Funciones.findByHoraFin", query = "SELECT f FROM Funciones f WHERE f.horaFin = :horaFin")
    ,@NamedQuery(name = "Funciones.findByPrecio", query = "SELECT f FROM Funciones f WHERE f.precio = :precio")})	
public class Funciones implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= false)
	@Column(name = "idFunciones")
	private Integer idFunciones;
	
	@Basic(optional=false)
	@Column(name="horaInicio")
	private String horaInicio;
	
	@Basic(optional= false)
	@Column(name="horaFin")
	private String horaFin;
	
	@Basic(optional= false)
	@Column(name="precio")
	private String precio;
	
	
	@JoinColumn(name = "pelicula", referencedColumnName = "idPelicula")
	@ManyToOne(optional=false)
	private Pelicula pelicula;
	
	@JoinColumn(name="sala", referencedColumnName = "idSala")
	@ManyToOne(optional=false)
	private Sala sala;
	
	
}
