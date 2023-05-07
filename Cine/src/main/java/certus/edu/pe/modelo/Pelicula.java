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
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Entity
@Table(name="pelicula")

//Utilizando Lombock
@Data
@EqualsAndHashCode(callSuper=false)
@NoArgsConstructor
@AllArgsConstructor

@NamedQueries({
	@NamedQuery(name = "Pelicula.findAll", query = "SELECT p FROM Pelicula p")
    , @NamedQuery(name = "Pelicula.findByIdPelicula", query = "SELECT p FROM Pelicula p WHERE p.idPelicula = :idPelicula")
    , @NamedQuery(name = "Pelicula.findByNombre", query = "SELECT p FROM Pelicula p WHERE p.nombre = :nombre")
    , @NamedQuery(name = "Pelicula.findByDuracion", query = "SELECT p FROM Pelicula p WHERE p.duracion = :duracion")
    , @NamedQuery(name = "Pelicula.findByClasificacion", query = "SELECT p FROM Pelicula p WHERE p.clasificacion = :clasificacion")
    , @NamedQuery(name = "Pelicula.findByIdioma", query = "SELECT p FROM Pelicula p WHERE p.idioma = :idioma")
    , @NamedQuery(name = "Pelicula.findByGenero", query = "SELECT p FROM Pelicula p WHERE p.genero = :genero")
    , @NamedQuery(name = "Pelicula.findByFormato", query = "SELECT p FROM Pelicula p WHERE p.formato = :formato")
    , @NamedQuery(name = "Pelicula.findBySinopsis", query = "SELECT p FROM Pelicula p WHERE p.sinopsis = :sinopsis")})
	
public class Pelicula implements Serializable{
   
	private static final long serialVersionUID = 1L;
     
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Basic(optional= true)
	private Integer idPelicula;
	
    @Basic(optional = false)
    @Column(name = "nombre")
	private String nombre;
	
    @Column(name = "duracion")
	private String duracion;
	
    @Column(name = "clasificacion")
	private String clasificacion;
	
    @Column(name = "idioma")
	private String idioma;
	
    @Column(name = "genero")
	private String genero;
	
    @Column(name = "formato") 
	private String formato;
	
    @Column(name = "sinopsis")
	private String sinopsis;
  	@OneToMany(cascade = CascadeType.ALL, mappedBy = "pelicula" , fetch=FetchType.LAZY)
    @JsonBackReference(value="pelicula_fun")
    private List<Funciones> funcionesList;
	
}
