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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.services.HabitacionService;
import pe.edu.delfines.services.TipoService;



public class restcontroller {
	
	@Autowired
	private HabitacionService habitacionService;
	
	@Autowired
	private TipoService tipoService;
	
	@Autowired
	private TipoService alquilerService;
	
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< List<Habitacion> > fetchHabitaciones() {
		try {
			List<Habitacion> habitaciones = habitacionService.findAll();
			return new ResponseEntity<List<Habitacion>>(habitaciones, HttpStatus.OK);   
		} catch (Exception e) {
			return new ResponseEntity<List<Habitacion>>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping(path = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE, 
			produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity< Habitacion > updateHabitacion(@PathVariable("id") Integer id, 
			@RequestBody Habitacion habitacion) {
		try {
			if(id.equals(habitacion.getId())) {
				Optional<Habitacion> optional = habitacionService.findById(id);
				if(optional.isPresent()) {
					Habitacion updateHabitacion = habitacionService.update(habitacion);
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
	
	@DeleteMapping(path = "/{id}")
	public ResponseEntity<Habitacion> deleteMedico(@PathVariable("id") Integer id) {
		try {			
			Optional<Habitacion> optional = habitacionService.findById(id);
			if(optional.isPresent()) {
				habitacionService.deleteById(id);
				return new ResponseEntity<Habitacion>(HttpStatus.OK);
			} else {
				return new ResponseEntity<Habitacion>(HttpStatus.NOT_FOUND);
			}
		} catch (Exception e) {
			return new ResponseEntity<Habitacion>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	

}
