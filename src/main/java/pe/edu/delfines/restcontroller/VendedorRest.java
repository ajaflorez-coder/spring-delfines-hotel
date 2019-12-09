package pe.edu.delfines.restcontroller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.services.VendedorService;



@RestController
@RequestMapping("/api/vendedor")
public class VendedorRest {

	
	@Autowired
	VendedorService _vendedorServ ;
	
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
	
	
	
}
