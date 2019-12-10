package pe.edu.delfines.models.impl;

import java.util.List;
import java.util.Optional;

import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.services.HabitacionServices;

public class HabitacionServicesImpl implements HabitacionServices{
	private HabitacionRepository habitacionRepository;
	@Override
	public List<Habitacion> findAll() throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.findAll();
	}

	@Override
	public Optional<Habitacion> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.findById(id);
	}

	@Override
	public Habitacion save(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.save(entity);
	}

	@Override
	public Habitacion update(Habitacion entity) throws Exception {
		// TODO Auto-generated method stub
		return habitacionRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		habitacionRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		habitacionRepository.deleteAll();
	}

}
