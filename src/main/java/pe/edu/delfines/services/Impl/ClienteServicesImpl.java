package pe.edu.delfines.services.Impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.services.ClienteService;


@Service
public class ClienteServicesImpl implements ClienteService {

	@Autowired
	private ClienteRepository clienterepository;
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
	
		return clienterepository.findAll();
	}
	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienterepository.findById(id);
	}
	@Transactional
	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienterepository.save(entity);
	}
	@Transactional
	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienterepository.save(entity);
	}
	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		
		clienterepository.deleteById(id);
		
	}
	@Transactional
	@Override
	public void deleteAll() throws Exception {
		
		clienterepository.deleteAll();
		
	}


}
