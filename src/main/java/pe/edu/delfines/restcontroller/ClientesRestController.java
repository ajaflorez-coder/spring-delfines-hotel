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

import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.services.AlquilerService;
import pe.edu.delfines.services.ClienteService;


@RestController
@RequestMapping("/api/clientes")
public class ClientesRestController {
	
	@Autowired
	private ClienteService clienteService;
	
	@Autowired
	private AlquilerService alquilerService;
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Cliente> > fetchCliente() {
		try {
			List<Cliente> clientes = clienteService.findAll();
			return new ResponseEntity<List<Cliente>>(clientes, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Cliente > saveCliente(@RequestBody Cliente cliente) {
		try {
			Cliente newCliente = clienteService.save(cliente);
			return new ResponseEntity< Cliente >(newCliente, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Cliente >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Cliente > updateCliente(@PathVariable("id") Integer id, 
			@RequestBody Cliente cliente) {
		try {
			if(id.equals(cliente.getId())) {
				Optional<Cliente> optional = clienteService.findById(id);
				if(optional.isPresent()) {
					Cliente updateCliente = clienteService.update(cliente);
					return new ResponseEntity<Cliente>(updateCliente, 
							HttpStatus.OK);
				} else {
					return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
				}				
			} else {
				return new ResponseEntity<Cliente>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Cliente> deleteCliente(@PathVariable("id") Integer id) {
		try {			
			Optional<Cliente> optional = clienteService.findById(id);
			if(optional.isPresent()) {
				clienteService.deleteById(id);
				return new ResponseEntity<Cliente>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Cliente>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Cliente>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	/*@GetMapping(path = "/{id}/pacientes")
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
	}*/
}
















