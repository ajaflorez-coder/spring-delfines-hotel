package pe.edu.delfines.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.delfines.models.entity.Habitacion;


@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {

	
	List<Habitacion> findByPrecio(Float precio);
	
	@Query("Select me from Habitacion me where me.precio < :precio")
	List<Habitacion> fetchMenorPrecio(Float precio);
	
	
	
}
