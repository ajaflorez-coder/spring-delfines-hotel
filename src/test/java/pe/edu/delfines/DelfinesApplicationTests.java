package pe.edu.delfines;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;

@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private TipoRepository tipoRepository;

	
	@Test
	void contextLoads() {
		
		try {
			
			Tipo  tipo1= new Tipo();
			tipo1.setId("t1");
			tipo1.setNombre("Matrimonial");
			Tipo  tipo2= new Tipo();
			tipo2.setId("t2");
			tipo2.setNombre("Compartido");
			
			Habitacion habitacion1= new Habitacion();
			habitacion1.setNumeroCamas(3);
			habitacion1.setDescripcion("amplia");
			habitacion1.setPrecio(120f);
			habitacion1.setTipo(tipo1);
			habitacion1.setObservacion("esta limpia");
			Habitacion habitacion2= new Habitacion();
			habitacion2.setNumeroCamas(4);
			habitacion2.setDescripcion("individual");
			habitacion2.setPrecio(50f);
			habitacion2.setTipo(tipo2);
			habitacion2.setObservacion("esta  ordenada");
			//grabar
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
			
			habitacionRepository.save(habitacion1);
			habitacionRepository.save(habitacion2);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
		
		
	}

}
