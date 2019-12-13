package pe.edu.delfines.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.service.AlquilerService;
@Service
public class AlquilerServiceImpl implements AlquilerService{

	@Autowired
	private AlquilerRepository alquilerRespository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Alquiler> findAll() throws Exception {
		return alquilerRespository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Alquiler> findById(Integer id) throws Exception {
		return alquilerRespository.findById(id);
	}
	@Transactional
	@Override
	public Alquiler save(Alquiler entity) throws Exception {
		return alquilerRespository.save(entity);
	}
	@Transactional
	@Override
	public Alquiler update(Alquiler entity) throws Exception {
		return alquilerRespository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		alquilerRespository.deleteById(id);
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		alquilerRespository.deleteAll();
	}

}
