package certus.edu.pe.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Pelicula;
import certus.edu.pe.repositorio.PeliculaRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class PeliculasServicio {
	
	@Autowired // Inyección de dependencia
	private PeliculaRepositorio repositorio;
	
	public PeliculasServicio() {
		
	}
	
	public List<Pelicula> buscarTodo(){
		return (List<Pelicula>) repositorio.findAll();
	}

	public Pelicula crear(Pelicula pelicula) {
		return repositorio.save(pelicula);
		
	}
	
	public Pelicula actualizar(Pelicula peliculaActualizar) {
		
		// primero realizamos la búsqueda de películas
		Pelicula peliculaActual = repositorio.findById(peliculaActualizar.getIdPelicula()).get();
		
		peliculaActual.setIdPelicula(peliculaActualizar.getIdPelicula());
		peliculaActual.setNombre(peliculaActualizar.getNombre());
		peliculaActual.setDuracion(peliculaActualizar.getDuracion());
		peliculaActual.setClasificacion(peliculaActualizar.getClasificacion());
		peliculaActual.setIdioma(peliculaActualizar.getIdioma());
		peliculaActual.setGenero(peliculaActualizar.getGenero());
		peliculaActual.setFormato(peliculaActualizar.getFormato());
		peliculaActual.setSinopsis(peliculaActualizar.getSinopsis());
		
		Pelicula peliculaActualizado = repositorio.save(peliculaActual);
		return peliculaActualizado;
	}
	
	public Pelicula buscarPorId(Integer id) {
		
		return repositorio.findById(id).get();
		
	}
	
	public void borrarPorId(Integer id) {
		
		repositorio.deleteById(id);
	}
	
	
}
