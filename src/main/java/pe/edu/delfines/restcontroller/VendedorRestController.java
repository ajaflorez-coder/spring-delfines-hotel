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
@RequestMapping("/api/vendedores")
public class VendedorRestController {

	@Autowired
	private VendedorService vendedorService;
	
	@Autowired
	private AlquilerService alquilerService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Vendedor>> fetchVendedores() {
		try {
			List<Vendedor> vendedores = vendedorService.findAll();
			return new ResponseEntity<List<Vendedor>>(vendedores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vendedor> saveVendedor(@RequestBody Vendedor medico) {
		try {
			Vendedor newVendedor = vendedorService.save(medico);
			return new ResponseEntity<Vendedor>(newVendedor, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	

	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Vendedor> updateVendedor(@PathVariable("id") Integer id, @RequestBody Vendedor vendedor) {
		try {
			if (id.equals(vendedor.getId())) {
				Optional<Vendedor> optional = vendedorService.findById(id);
				if (optional.isPresent()) {
					Vendedor updateVendedor = vendedorService.update(vendedor);
					return new ResponseEntity<Vendedor>(updateVendedor, HttpStatus.OK);
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
	public ResponseEntity<Vendedor> deleteVendedor(@PathVariable("id") Integer id) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if (optional.isPresent()) {
				vendedorService.deleteById(id);
				return new ResponseEntity<Vendedor>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Vendedor>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Vendedor>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/buscarVendedor/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > buscarVendedor(
			@PathVariable("id") Integer id) {
		try {
			List<Vendedor> vendedores = vendedorService.buscarVendedor(id);
			return new ResponseEntity<List<Vendedor>>(vendedores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/mayorsueldo/{sueldo}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Vendedor> > MayorSueldo(
			@PathVariable("sueldo") float sueldo) {
		try {
			List<Vendedor> vendedores = vendedorService.fetchMayorSueldo(sueldo);
			return new ResponseEntity<List<Vendedor>>(vendedores, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Vendedor>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}/alquileres")
	public ResponseEntity<List<Alquiler>> fetchAlquileres(
			@PathVariable("id") Integer id){
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
			@PathVariable("id") Integer id,
			@RequestBody Alquiler alquiler) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
			if(optional.isPresent()) {				
				alquiler.setVendedor( optional.get() );
				Alquiler nuevoAlquiler = alquilerService.save(alquiler);
				return new ResponseEntity<Alquiler>(nuevoAlquiler, 
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Alquiler>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity< Alquiler >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}/alquiler", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Alquiler > updateAlquiler(@PathVariable("id") Integer id,
			@RequestBody Alquiler alquiler) {
		try {
			Optional<Vendedor> optional = vendedorService.findById(id);
				if(optional.isPresent()) {
					Alquiler updateAlquiler = alquilerService.update(alquiler);
					return new ResponseEntity<Alquiler>(updateAlquiler, 
							HttpStatus.OK);		
			} else {
				return new ResponseEntity<Alquiler>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Alquiler>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
/*
	@GetMapping(path = "/cantidad", produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<Integer> CantidadCliente() {
		try {
			Integer cantidad = clienteService.fetchCantidadCliente();
			return new ResponseEntity<Integer>(cantidad.toInteger(), HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<Integer>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(produces = MediaType.TEXT_PLAIN_VALUE)
	public ResponseEntity<List<Cliente>> ListaCliente() {
		try {
			List<Cliente> cliente = clienteService.listacliente();
			return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping(path = "/porNombre/{nombre}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<List<Cliente>> MayorTelefono(@PathVariable("nombre") Integer nombre) {
		try {
			List<Cliente> cliente = clienteService.fetchporNombre(nombre);
			return new ResponseEntity<List<Cliente>>(cliente, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Cliente>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/
}
