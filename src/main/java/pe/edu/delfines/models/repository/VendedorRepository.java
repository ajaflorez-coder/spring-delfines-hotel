package pe.edu.delfines.models.repository;



import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.delfines.models.entity.Vendedor;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, String> {
	@Query(value ="select * from vendedores where sueldo>1000", nativeQuery=true)
	List<Vendedor> fetchMayorSueldo(Float sueldo);
}
