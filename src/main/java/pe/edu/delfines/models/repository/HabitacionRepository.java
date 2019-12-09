package pe.edu.delfines.models.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.delfines.models.entity.Habitacion;

@Repository
public interface HabitacionRepository extends JpaRepository<Habitacion, Integer> {
	@Query("Select ha from Habitacion ha where ha.precio <:precio")
	List<Habitacion> menorAlPrecio(Integer precio);
}
