package pe.edu.delfines.services;

import java.util.List;

import pe.edu.delfines.models.entity.Habitacion;

public interface HabitacionService extends CrudService<Habitacion, Integer>{
	List<Habitacion> menorAlPrecio(Integer precio) throws Exception;
}
