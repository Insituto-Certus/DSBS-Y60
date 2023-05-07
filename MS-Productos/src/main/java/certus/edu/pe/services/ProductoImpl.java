package certus.edu.pe.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import certus.edu.pe.entidad.Producto;
import certus.edu.pe.repositorio.IProductoRepositorio;

import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@Service

public class ProductoImpl implements IProductoService {
	
	//@Autowired
	private final IProductoRepositorio productRepository; // inyección de dependencia

	@Override
	@Transactional(readOnly = true) // de lectura
	public List<Producto> findAll() {
		return productRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true) // de lectura
	public Producto findById(Long id) {

		return productRepository.findById(id).orElse(null);
	}

}
