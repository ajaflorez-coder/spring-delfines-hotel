package pe.edu.delfines.services;

import java.util.List;

import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.services.CrudService;

public interface HabitacionService  extends CrudService<Habitacion, Integer>{

	List<Habitacion> fetchporId(Integer id) throws Exception;
	
	List<Habitacion> fetchporPrecio(Float precio) throws Exception;
}
