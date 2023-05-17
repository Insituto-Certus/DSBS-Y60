package certus.edu.pe.servicios;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import certus.edu.pe.modelo.Funciones;
import certus.edu.pe.repositorio.FuncionesRepositorio;
import javax.transaction.Transactional;

@Service
@Transactional
public class FuncionesServicio {

	
	@Autowired // Inyección de dependencia
	public FuncionesRepositorio funcionesRepositorio;
	
	public FuncionesServicio() {
			
	}
	
	public List<Funciones> buscarTodo(){
		return (ArrayList<Funciones>) funcionesRepositorio.findAll();

	}
	
	public Funciones buscarPorId(Integer id) {
		return funcionesRepositorio.findById(id).get();
	}
	
	public Funciones crear(Funciones funciones) {
		return funcionesRepositorio.save(funciones); // Registra una función en BD
	}
	
	public Funciones actualizar (Funciones funcionActualizar) {
		Funciones funcionActual = funcionesRepositorio.findById(funcionActualizar.getIdFunciones()).get();
		funcionActual.setIdFunciones(funcionActualizar.getIdFunciones());
		funcionActual.setHoraInicio(funcionActualizar.getHoraInicio());
		funcionActual.setHoraFin(funcionActualizar.getHoraFin());
		funcionActual.setPrecio(funcionActualizar.getPrecio());
		
		Funciones funcionesActualizado= funcionesRepositorio.save(funcionActual); // Actualiza en BD
		return funcionesActualizado;
		
	}
	
	public void eliminarFunciones(Integer id) {
		funcionesRepositorio.deleteById(id);
		
	}
	
	public void actualizar(int id, Funciones funcion) {
		
		Funciones funcionActual = funcionesRepositorio.findById(id).get();
		
		funcionActual.setIdFunciones(funcion.getIdFunciones());
		funcionActual.setHoraInicio(funcion.getHoraInicio());
		funcionActual.setHoraFin(funcion.getHoraFin());
		funcionActual.setPrecio(funcion.getPrecio()); 
		funcionActual.setPelicula(funcion.getPelicula()); // Aquí trae los datos de la entidad Película
		//funcionActual.setSala(funcion.getSala());// Aquí trae los datos de la entidad Sala
		
		funcionesRepositorio.save(funcionActual);
		
		
	}
	
	
	
}
