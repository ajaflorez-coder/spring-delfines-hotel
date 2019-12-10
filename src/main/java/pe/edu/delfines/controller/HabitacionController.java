package pe.edu.delfines.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.services.AlquilerService;
import pe.edu.delfines.services.HabitacionService;


@Controller
@RequestMapping("/habitacion")
@SessionAttributes( {"habitacion","alquiler"})
public class HabitacionController {
	@Autowired 
	private HabitacionService habitacionService;
	@Autowired
	private AlquilerService alquilerService;

	
	@GetMapping
	public String inicio(Model model) {
		try {
			List<Habitacion> habitacion = habitacionService.findAll();
			model.addAttribute("habitacion", habitacion);
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitacion/inicio";
	}
	
	@GetMapping("/edit/{id}")
	public String editar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> optional = habitacionService.findById(id);
			if (optional.isPresent()) {
				model.addAttribute("habitacion", optional.get());

			} else {
				return "redirect:/medico";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		return "/habitacion/edit";
	}
	
	@PostMapping("/save")
	public String save(@ModelAttribute("habitacion") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionService.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitacion";
	}
	@GetMapping("/nuevo")
	public String nuevo(Model model) {
		Habitacion habitacion = new Habitacion();
		model.addAttribute("habitacion", habitacion);
		
		return "/habitacion/nuevo";
	}
	@GetMapping("/del/{id}")
	public String eliminar(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitacion = habitacionService.findById(id);
			if(habitacion.isPresent()) {
				habitacionService.deleteById(id);
			}
		} catch (Exception e) {
			
			model.addAttribute("dangerDel", "ERROR - Violación contra el principio de Integridad referencia");
			try {
				List<Habitacion> habitacion = habitacionService.findAll();
				model.addAttribute("habitacion", habitacion);
			} catch (Exception e2) {
				// TODO: handle exception
			} 
			return "/medico/inicio";
		}
		return "redirect:/medico";
	}
	@GetMapping("/info/{id}")
	public String info(@PathVariable("id") int id, Model model) {
		try {
			Optional<Habitacion> habitacion = habitacionService.findById(id);
			if(habitacion.isPresent()) {
				model.addAttribute("medico", habitacion.get());
			} else {
				return "redirect:/medico";
			}
		} catch (Exception e) {

		}	
		
		return "/habitacion/info";
	}
	
	@GetMapping("/{id}/nuevahabitacion")
	public String nuevoPaciente(@PathVariable("id") int id, Model model) {
		Habitacion paciente = new Habitacion();
		try {
			Optional<Habitacion> medico = habitacionService.findById(id);
			if(medico.isPresent()) {
				paciente.setId(id);
				
			} else {
				return "redirect:/habitacion";
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "/habitacion/nuevahabitacion";
	}
	
	@PostMapping("/savehabitacion")
	public String savePaciente(@ModelAttribute("habitacion") Habitacion habitacion, 
			Model model, SessionStatus status) {
		try {
			habitacionService.save(habitacion);
			status.setComplete();
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return "redirect:/habitacion/info/" + habitacion.getId();
	}
	
}
