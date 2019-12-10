package pe.edu.delfines.models.impl;

import java.util.List;
import java.util.Optional;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.services.AlquilerServices;

public class AlquilerServicesImpl implements AlquilerServices{
	private AlquilerRepository alquilerRepository;
	@Override
	public List<Alquiler> findAll() throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findAll();
	}

	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.findById(id);
	}

	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		// TODO Auto-generated method stub
		return alquilerRepository.save(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		alquilerRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		alquilerRepository.deleteAll();
	}

}
