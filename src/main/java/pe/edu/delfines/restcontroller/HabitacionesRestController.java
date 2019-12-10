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
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.services.AlquilerService;
import pe.edu.delfines.services.HabitacionService;

@RestController
@RequestMapping("/api/Habitacion")
public class HabitacionesRestController {
	
	@Autowired
	private HabitacionService HabitacionService;
	
	@Autowired
	private AlquilerService AlquilerService;

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Habitacion> > fetchHabitacions() {
		try {
			List<Habitacion> Habitacion = HabitacionService.findAll();
			return new ResponseEntity<List<Habitacion>>(Habitacion, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Habitacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
	}
	
	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Habitacion > saveHabitacion(@RequestBody Habitacion habitacion) {
		try {
			Habitacion newhabitacion = HabitacionService.save(habitacion);
			return new ResponseEntity< Habitacion >(newhabitacion, HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity< Habitacion >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Habitacion > updateHabitacion(@PathVariable("id") Integer id, 
			@RequestBody Habitacion Habitacion) {
		try {
			if(id.equals(Habitacion.getId())) {
				Optional<Habitacion> optional = HabitacionService.findById(id);
				if(optional.isPresent()) {
					Habitacion updateHabitacion = HabitacionService.update(Habitacion);
					return new ResponseEntity<Habitacion>(updateHabitacion, 
							HttpStatus.OK);
				} else {
					return new ResponseEntity<Habitacion>(HttpStatus.NOT_FOUND);
				}				
			} else {
				return new ResponseEntity<Habitacion>(HttpStatus.BAD_REQUEST);
			}
		} catch (Exception e) {
			return new ResponseEntity<Habitacion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(path = "/{id}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Habitacion> > HabitacionporId(
			@PathVariable("id") Integer id) {
		try {
			List<Habitacion> Habitacion = HabitacionService.fetchporId(id);
			return new ResponseEntity<List<Habitacion>>(Habitacion, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Habitacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Habitacion> deleteHabitacion(@PathVariable("id") Integer id) {
		try {			
			Optional<Habitacion> optional = HabitacionService.findById(id);
			if(optional.isPresent()) {
				HabitacionService.deleteById(id);
				return new ResponseEntity<Habitacion>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Habitacion>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Habitacion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
	@GetMapping(path = "/precio/{precio}", 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Habitacion> > HabitacionporPrecio(
			@PathVariable("precio") float precio) {
		try {
			List<Habitacion> Habitacion = HabitacionService.fetchporPrecio(precio);
			return new ResponseEntity<List<Habitacion>>(Habitacion, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<List<Habitacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@GetMapping(path = "/{id}/alquileres")
	public ResponseEntity<List<Alquiler>> fetchAlquileres(
			@PathVariable("id") Integer id){
		try {
			Optional<Habitacion> optional = HabitacionService.findById(id);
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
			Optional<Habitacion> optional = HabitacionService.findById(id);
			if(optional.isPresent()) {				
				alquiler.setHabitacion(optional.get());
				Alquiler nuevoAlquiler = AlquilerService.save(alquiler);
				return new ResponseEntity<Alquiler>(nuevoAlquiler, 
						HttpStatus.CREATED);
			} else {
				return new ResponseEntity<Alquiler>(HttpStatus.BAD_REQUEST);
			}
			
		} catch (Exception e) {
			return new ResponseEntity< Alquiler >(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
	
}
}
















