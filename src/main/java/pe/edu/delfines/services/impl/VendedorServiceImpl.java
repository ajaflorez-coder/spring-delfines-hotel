package pe.edu.delfines.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.VendedorRepository;
import pe.edu.delfines.services.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

	@Autowired
	private VendedorRepository vendedorRepository;

	@Transactional(readOnly = true)
	@Override
	public List<Vendedor> findAll() throws Exception {
		return vendedorRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Vendedor> findById(Integer id) throws Exception {
		return vendedorRepository.findById(id);
	}

	@Transactional
	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Transactional
	@Override
	public Vendedor update(Vendedor entity) throws Exception {
		return vendedorRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		this.vendedorRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		this.vendedorRepository.deleteAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Vendedor> buscarVendedor(Integer id) throws Exception {
		return vendedorRepository.buscarVendedor(id);
	}
	
	@Transactional(readOnly = true)
	@Override
	public List<Vendedor> fetchMayorSueldo(float sueldo) throws Exception {
		return vendedorRepository.fetchMayorSueldo(sueldo);
	}
}
