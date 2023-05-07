package certus.edu.pe.services;

import java.util.List;

import certus.edu.pe.entidad.Producto;

public interface IProductoService {
	
	List<Producto> findAll();
	Producto findById(Long id);

}
