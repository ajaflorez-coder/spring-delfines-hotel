package pe.edu.delfines.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.delfines.models.entity.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
    List<Cliente> findByNombre(String nombre);
	
	List<Cliente> findByDocumento(String documento);
	
	@Query("Select me from Medico me where me.documento > :documento")
	List<Cliente> fetchMayorDocumento(Integer documento);
	

}