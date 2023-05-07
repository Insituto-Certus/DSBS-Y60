package certus.edu.pe.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import certus.edu.pe.entidad.Producto;
import certus.edu.pe.services.IProductoService;
import lombok.RequiredArgsConstructor;


@RequiredArgsConstructor
@RestController
@RequestMapping("/api/products")
public class ProductoController {

	//@Autowired
	private final IProductoService productoSercice;
	
	@Value("${server.port}")
    private Integer port;
	
	
	@GetMapping
	@ResponseBody
	ResponseEntity<List<Producto>> findAll(){
	List<Producto> products = productoSercice.findAll().stream().
			       map(product -> {product.setPort(port);
			    	                return product;}).collect(Collectors.toList());
	      return ResponseEntity.ok(products);
	}
	
	@GetMapping("/{id}")
	ResponseEntity<Producto> findById(@PathVariable Long id){
		Producto producto = productoSercice.findById(id);
		producto.setPort(port);
		return ResponseEntity.ok(producto);
		
	}
	
	
}
