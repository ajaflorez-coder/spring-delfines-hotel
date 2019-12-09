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
@RequestMapping("/api/vendedor")
public class VendedorRest {

	
	@Autowired
	VendedorService _vendedorServ ;
	
	@Autowired
	AlquilerService _alquilerServ ;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > fetchMedicos() {
		try {
			List<Vendedor> medicos = _vendedorServ.findAll();
			return new ResponseEntity<List<Vendedor>>(medicos, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	
	

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > saveMedico(@RequestBody Vendedor medico) {
		try {
			Vendedor newMedico = _vendedorServ.save(medico);
			return new ResponseEntity< Vendedor >(newMedico, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Vendedor >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	@GetMapping(path = "/{id}/vendedor/sueldo")
	public ResponseEntity<List<Vendedor>> fetchMayorSueldo(
			@PathVariable("id") Float id){
		try {
			List<Vendedor> optional = _vendedorServ.fetchMayorTelefono(id);
			
				return new ResponseEntity<List<Vendedor>>(optional, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}/vendedor")
	public ResponseEntity<Vendedor> fetchVendedorXId(
			@PathVariable("id") String id){
		try {
			Optional<Vendedor> optional = _vendedorServ.findById(id);
			if(optional.isPresent()) {
				return new ResponseEntity<Vendedor>(optional.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Vendedor>(
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > updateMedico(@PathVariable("id") String id, 
			@RequestBody Vendedor medico) {
		try {
			if(id.equals(medico.getId())) {
				Optional<Vendedor> optional = _vendedorServ.findById(id);
				if(optional.isPresent()) {
					Vendedor updateMedico = _vendedorServ.update(medico);
					return new ResponseEntity<Vendedor>(updateMedico, 
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
	public ResponseEntity<Vendedor> deleteMedico(@PathVariable("id") String id) {
		try {			
			Optional<Vendedor> optional = _vendedorServ.findById(id);
			if(optional.isPresent()) {
				_vendedorServ.deleteById(id);
				return new ResponseEntity<Vendedor>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	@PostMapping(path = "/{idVendedor}/alquiler",consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Alquiler > saveAlquiler(@RequestBody Alquiler medico,@PathVariable("idVendedor") String id) {
		try {
			Optional<Vendedor> optional = _vendedorServ.findById(id);
			if(optional.isPresent()) {
			medico.setVendedor(optional.get());
			Alquiler newMedico = _alquilerServ.save(medico);
			return new ResponseEntity< Alquiler >(newMedico, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Alquiler>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< Alquiler >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	
	@PutMapping(path = "/{idAlquiler}/alquiler",consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Alquiler > updateAlquiler(@RequestBody Alquiler medico,@PathVariable("idAlquiler") Integer id) {
		try {
			Optional<Alquiler> optional = _alquilerServ.findById(id);
			if(optional.isPresent()) {	
			Alquiler newMedico = _alquilerServ.save(medico);
			return new ResponseEntity< Alquiler >(newMedico, HttpStatus.CREATED);
			}else {
				return new ResponseEntity<Alquiler>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity< Alquiler >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
		
	}
	
	
	
	
	
	@GetMapping(path = "/{id}/alquileres")
	public ResponseEntity<	List<Alquiler>> fetchVendedorAlquiler(
			@PathVariable("id") String id){
		try {
			Optional<Vendedor> optional = _vendedorServ.findById(id);
			if(optional.isPresent()) {
				return new ResponseEntity<List<Alquiler>>(optional.get().getAlquileres(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Alquiler>>(
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Alquiler>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	
	
	
	
	
	
	
}
