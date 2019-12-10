package pe.edu.delfines.services;

import java.util.List;

import pe.edu.delfines.models.entity.Cliente;

public interface ClienteService extends CrudService<Cliente, Integer>{

	List<Cliente> findClienteByLugarNacimiento(String lugar) throws Exception;
}
