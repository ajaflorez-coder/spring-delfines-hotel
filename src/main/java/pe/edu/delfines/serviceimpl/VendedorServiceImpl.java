package pe.edu.delfines.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.VendedorRepository;
import pe.edu.delfines.services.VendedorService;

@Service
public class VendedorServiceImpl implements VendedorService {

	
	@Autowired
	VendedorRepository _vendedor;
	
	@Override
	public List<Vendedor> findAll() throws Exception {
		// TODO Auto-generated method stub
		return _vendedor.findAll();
	}

	@Override
	public Optional<Vendedor> findById(String id) throws Exception {
		// TODO Auto-generated method stub
		return _vendedor.findById(id);
	}

	@Override
	public Vendedor save(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return _vendedor.save(entity);
	}

	@Override
	public Vendedor update(Vendedor entity) throws Exception {
		// TODO Auto-generated method stub
		return _vendedor.save(entity);
	}

	@Override
	public void deleteById(String id) throws Exception {
		// TODO Auto-generated method stub
		_vendedor.deleteById(id);
	}

	@Override
	public void deleteAll() throws Exception {
		// TODO Auto-generated method stub
		_vendedor.deleteAll();
	}

	@Override
	public List<Vendedor> fetchMayorTelefono(Float sueldo) {
		// TODO Auto-generated method stub
		return _vendedor.fetchMayorTelefono(sueldo);
	}

}
