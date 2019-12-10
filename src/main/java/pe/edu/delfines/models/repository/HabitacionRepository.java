package pe.edu.delfines.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.delfines.models.entity.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

	@Query(value ="Select * from habitaciones where id= :id", nativeQuery=true )
	List<Habitacion> fetchporId(Integer id);
	
	@Query(value ="Select * from habitaciones where precio < :precio", nativeQuery=true )
	List<Habitacion> fetchporPrecio(Float precio);
}
