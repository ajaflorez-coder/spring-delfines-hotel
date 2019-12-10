package pe.edu.delfines.restcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.services.AlquilerService;
import pe.edu.delfines.services.VendedorService;





@RestController
@RequestMapping("/api/Vendedors")
public class VendedorRestController {
	
	@Autowired
	private AlquilerService alquilerService;
	@Autowired
	private VendedorService vendedorService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > fetchVendedors() {
		try {
			List<Vendedor> Vendedors = vendedorService.findAll();
			return new ResponseEntity<List<Vendedor>>(Vendedors, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > saveVendedor(@RequestBody Vendedor vendedor) {
		try {
			Vendedor newvendedor = vendedorService.save(vendedor);
			return new ResponseEntity< Vendedor >(newvendedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Vendedor >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > updatevendedor(@PathVariable("id") String id, 
			@RequestBody Vendedor vendedor) {
		try {
			if(id.equals(vendedor.getId())) {
				Optional<Vendedor> optional = vendedorService.findById(id);
				if(optional.isPresent()) {
					Vendedor updatevendedor = vendedorService.update(vendedor);
					return new ResponseEntity<Vendedor>(updatevendedor, 
							HttpStatus.OK);
				} else {
					return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
				}				
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Vendedor> deletevendedor(@PathVariable("id") String id) {
		try {			
			Optional<Vendedor> optional = vendedorService.findById(id);
			if(optional.isPresent()) {
				vendedorService.deleteById(id);
				return new ResponseEntity<Vendedor>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE )
	public ResponseEntity<List<Vendedor>> ListaVendedor() {
		try {
			List<Vendedor> Vendedor = vendedorService.listaVendedores();
			return new ResponseEntity<List<Vendedor>>(Vendedor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping(path = "/{id}/alquileres")
	public ResponseEntity<List<Alquiler>> fetchAlquileres(
			@PathVariable("id") String id){
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if(optional.isPresent()) {
				return new ResponseEntity<List<Alquiler>>(
						optional.get().getAlquileres(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Alquiler>>(
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Alquiler>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping( path = "/{id}/alquiler",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Alquiler > saveAlquiler(
			@PathVariable("id") String id,
			@RequestBody Alquiler alquiler) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if(optional.isPresent()) {				
				alquiler.setVendedor(optional.get());
				Alquiler nuevoAlquiler = alquilerService.save(alquiler);
				return new ResponseEntity<Alquiler>(nuevoAlquiler, 
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Alquiler>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity< Alquiler >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
	/*
	@GetMapping(path = "/cantidad", produces = MediaType.TEXT_PLAIN_VALUE )
	public ResponseEntity<String> CantidadVendedor() {
		try {
			Integer cantidad = VendedorService.fetchCantidadVendedor();
			return new ResponseEntity<String>(cantidad.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping(path = "/porNombre/{nombre}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > MayorTelefono(
			@PathVariable("nombre") String nombre) {
		try {
			List<Vendedor> Vendedor = VendedorService.fetchporNombre(nombre);
			return new ResponseEntity<List<Vendedor>>(Vendedor, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
}
}
















