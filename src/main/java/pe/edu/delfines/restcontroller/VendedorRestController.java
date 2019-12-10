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

import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.services.VendedorService;

@RestController
@RequestMapping("/api/vendedor")
public class VendedorRestController {
	
	@Autowired
	private VendedorService vendedorService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > fetchVendedors() {
		try {
			List<Vendedor> Vendedores = vendedorService.findAll();
			return new ResponseEntity<List<Vendedor>>(Vendedores, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > saveVendedor(@RequestBody Vendedor vendedor) {
		try {
			Vendedor newVendedor = vendedorService.save(vendedor);
			return new ResponseEntity< Vendedor >(newVendedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Vendedor >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > updateVendedor(@PathVariable("id") String id, 
			@RequestBody Vendedor Vendedor) {
		try {
			if(id.equals(Vendedor.getId())) {
				Optional<Vendedor> optional = vendedorService.findById(id);
				if(optional.isPresent()) {
					Vendedor updateVendedor = vendedorService.update(Vendedor);
					return new ResponseEntity<Vendedor>(updateVendedor, 
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
	public ResponseEntity<Vendedor> deleteVendedor(@PathVariable("id") String id) {
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
	@GetMapping(path = "/mayorsueldo/{sueldo}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > MayorSueldo(
			@PathVariable("Sueldo") Float sueldo) {
		try {
			List<Vendedor> vendedores = vendedorService.fetchMayorsueldo(sueldo);
			return new ResponseEntity<List<Vendedor>>(vendedores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
















