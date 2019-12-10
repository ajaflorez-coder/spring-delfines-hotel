package pe.edu.delfines.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import pe.edu.delfines.models.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {
	
	@Query(value = "select * from vendedores;" , nativeQuery = true )
	List<Vendedor> listavendedores();
	
	//@Query(value = "select * from vendedores where sueldo > :valor ;" , nativeQuery = true )
	//List<Vendedor> listavensuel(double sueldo);
	//List<Vendedor> listavendedores();
	
	
}
