package pe.edu.delfines.services;

import java.util.Optional;

import pe.edu.delfines.models.entity.Usuario;

public interface UsuarioService extends CrudService<Usuario,Long>{
	Optional<Usuario>findByUsername(String username) throws Exception;

}
