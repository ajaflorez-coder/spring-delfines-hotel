package pe.edu.delfines.servicesimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.services.HabitacionService;

@Service
public class HabitacionServiceImpl implements HabitacionService{

	@Autowired
	private HabitacionRepository habitacionrepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Habitacion> findAll() throws Exception {
		return habitacionrepository.findAll();
	}
	
	@Transactional(readOnly = true)
	@Override
	public Optional<Habitacion> findById(Integer id) throws Exception {
		
		return habitacionrepository.findById(id);
	}
	
	@Transactional
	@Override
	public Habitacion save(Habitacion entity) throws Exception {
		
		return habitacionrepository.save(entity);
	}

	@Transactional
	@Override
	public Habitacion update(Habitacion entity) throws Exception {

		return habitacionrepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		habitacionrepository.deleteById(id);
		
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		habitacionrepository.deleteAll();
		
	}
}
