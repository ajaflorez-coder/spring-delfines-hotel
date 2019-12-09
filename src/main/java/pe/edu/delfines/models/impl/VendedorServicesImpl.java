package pe.edu.delfines.models.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.VendedorRepository;
import pe.edu.delfines.models.services.VendedorServices;

public class VendedorServicesImpl implements VendedorServices{
	@Autowired
	private VendedorRepository vendedorRepository;
	@Override
	public List<Vendedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findAll();
	}

	@Override
	public Optional<Vendedor> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.findById(id);
	}

	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.save(entity);
	}

	@Override
	public Vendedor update(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return vendedorRepository.save(entity);
	}

	@Override
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		vendedorRepository.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		vendedorRepository.deleteAll();
	}

}