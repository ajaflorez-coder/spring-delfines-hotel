package pe.edu.delfines.service;

import java.util.List;

import pe.edu.delfines.models.entity.Habitacion;

public interface HabitacionService extends CrudService<Habitacion,Integer>{
List<Habitacion> fetchMenorPrecio(Float precio) throws Exception;

}
