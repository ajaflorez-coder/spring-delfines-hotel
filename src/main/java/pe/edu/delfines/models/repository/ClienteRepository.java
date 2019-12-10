package pe.edu.delfines.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.delfines.models.entity.Cliente;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
	
	

	
	@Query(value = "Select * from clientes  where id = :id " , nativeQuery = true)
	List<Cliente> fetchporId(Integer id);
	
	@Query(value = "Select * from clientes  where lugar_nacimiento = :lugar " , nativeQuery = true)
	List<Cliente> fetchporLugarnacimiento(String lugar);
	
}
