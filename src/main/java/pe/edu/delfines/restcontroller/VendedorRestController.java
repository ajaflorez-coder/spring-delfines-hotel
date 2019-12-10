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
@RequestMapping("/api/vendedores")
public class VendedorRestController {
	
	@Autowired
	private VendedorService vendedorService;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > fetchVendedor() {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			return new ResponseEntity<List<Vendedor>>(vendedores, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Vendedor > saveMedico(@RequestBody Vendedor vendedor) {
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
			@RequestBody Vendedor vendedor) {
		try {
			if(id.equals(vendedor.getId())) {
				Optional<Vendedor> optional = vendedorService.findById(id);
				if(optional.isPresent()) {
					Vendedor updateVendedor = vendedorService.update(vendedor);
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
	public ResponseEntity<Vendedor> deleteMedico(@PathVariable("id") String id) {
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
	
	@GetMapping(path = "/{id}",produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vendedor> fetchVendedor(@PathVariable("id") String id){
		
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if(optional.isPresent()) {
				return new ResponseEntity<Vendedor>(optional.get(), HttpStatus.OK);
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>( HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		
	}
	
}



	/*
	@GetMapping(path = "/{id}/pacientes")
	public ResponseEntity<List<Paciente>> fetchPaciente(
			@PathVariable("id") Integer id){
		try {
			Optional<Medico> optional = medicoService.findById(id);
			if(optional.isPresent()) {
				return new ResponseEntity<List<Paciente>>(
						optional.get().getPacientes(), HttpStatus.OK);
			} else {
				return new ResponseEntity<List<Paciente>>(
						HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<List<Paciente>>(
					HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	/*
	@PostMapping( path = "/{id}/pacientes",
			consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Paciente > savePaciente(
			@PathVariable("id") Integer id,
			@RequestBody Paciente paciente) {
		try {
			Optional<Medico> optional = medicoService.findById(id);
			if(optional.isPresent()) {				
				paciente.setMedico( optional.get() );
				Paciente nuevoPaciente = pacienteService.save(paciente);
				return new ResponseEntity<Paciente>(nuevoPaciente, 
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Paciente>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity< Paciente >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
	
	/*
	@GetMapping(path = "/mayortelefono/{telefono}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Medico> > MayorTelefono(
			@PathVariable("telefono") Integer telefono) {
		try {
			List<Medico> medicos = medicoService.fetchMayorTelefono(telefono);
			return new ResponseEntity<List<Medico>>(medicos, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Medico>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@GetMapping(path = "/cantidad", produces = MediaType.TEXT_PLAIN_VALUE )
	public ResponseEntity<String> CantidadMedico() {
		try {
			Integer cantidad = medicoService.fetchCantidadMedico();
			return new ResponseEntity<String>(cantidad.toString(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
*/















