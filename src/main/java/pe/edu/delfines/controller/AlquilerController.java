package pe.edu.delfines.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.services.HabitacionService;
import pe.edu.delfines.services.TipoService;

public class AlquilerController {

	@Autowired
	private HabitacionService habitacionService;
		
	@Autowired
	private TipoService alquilerService;
	
	
	@GetMapping("/edit/{id}")
	public String actualizarAlquiler(@PathVariable("id") int id, Model model) {
		try {
			Optional<Alquiler> optional = alquilerService.findById(id);
			if (optional.isPresent()) {
				
				List<Habitacion> habitaciones  
					= habitacionService.findAll(); 
				
				model.addAttribute("habitacion", optional.get());
				model.addAttribute("habitacion", habitaciones);
			} else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/aquiler/edit";
	}
	
	@GetMapping("/buscarhabitacion/{id}")
	public String buscarhabitacion(@PathVariable("id") int id, Model model) {
		try {
			Optional<Alquiler> alquiler = alquilerService.findById(id);
			if(alquiler.isPresent()) {
				model.addAttribute("alquiler", alquiler.get());
			} else {
				return "redirect:/alquiler";
			}
		} catch (Exception e) {

		}	
		
		return "/alquiler/info";
	}
	
	@GetMapping("/{id}/nuevoalquiler")
	public String nuevoAlquiler(@PathVariable("id") int id, Model model) {
		Alquiler alquiler = new Alquiler();
		try {
			Optional<Habitacion> habitacion = habitacionService.findById(id);
			if(habitacion.isPresent()) {
				alquiler.setHabitacion(habitacion.get());
				model.addAttribute("alquiler", alquiler);
			} else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitacion/nuevoalquiler";
	}
}
