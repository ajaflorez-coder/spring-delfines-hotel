package pe.edu.delfines.services.implement;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.services.ClienteService;

@Service
public class ClienteServiceImplement implements ClienteService{

	@Autowired
	ClienteRepository clienteRepository;
	
	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findAll() throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findAll();
	}

	@Transactional(readOnly = true)
	@Override
	public Optional<Cliente> findById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findById(id);
	}

	@Transactional
	@Override
	public Cliente save(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Transactional
	@Override
	public Cliente update(Cliente entity) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.save(entity);
	}

	@Transactional
	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteById(id);
	}

	@Transactional
	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		clienteRepository.deleteAll();
	}

	@Transactional(readOnly = true)
	@Override
	public List<Cliente> findClienteByLugarNacimiento(String lugar) throws Exception {
		// TODO Auto-generated method stub
		return clienteRepository.findClienteByLugarNacimiento(lugar);
	}

}
