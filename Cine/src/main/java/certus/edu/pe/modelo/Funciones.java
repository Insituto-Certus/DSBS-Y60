package certus.edu.pe.modelo;

import java.io.Serializable;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
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
