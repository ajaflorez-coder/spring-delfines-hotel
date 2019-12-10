package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DelfinesApplicationTests {
	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Test
	void contextLoads() {
		try {
			Habitacion habitacion1=new Habitacion();
			habitacion1.setNumeroCamas(10);
			habitacion1.setDescripcion("Habitacion amplia");
			habitacion1.setPrecio((float) 350);
			habitacion1.setObservacion("Tipos de errores");
			habitacionRepository.save(habitacion1);
			
			Habitacion habitacion2=new Habitacion();
			habitacion2.setNumeroCamas(20);
			habitacion2.setDescripcion("habitacion cerrada");
			habitacion2.setPrecio((float)420);
			habitacion2.setObservacion("tipos de errores");
			habitacionRepository.save(habitacion2);
			
			Alquiler alquiler1=new Alquiler();
			alquiler1.setPrecio((float) 300);
			alquiler1.setFecha_entrada(new Date(2019,10,10));
			alquiler1.setFecha_salida(new Date(2019,10,30));
			alquiler1.setEstado("Nuevo");
			alquiler1.setObservacion("Internet");
			
			Alquiler alquiler2=new Alquiler();
			alquiler2.setPrecio((float) 400);
			alquiler2.setFecha_entrada(new Date(2019,10,10));
			alquiler2.setFecha_salida(new Date(2019,10,30));
			alquiler2.setEstado("Nuevo");
			alquiler2.setObservacion("Internet-Cable");
			//Relacion Habitación alquiler
			alquiler1.setHabitacion(habitacion1);
			alquiler2.setHabitacion(habitacion2);
			
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(alquiler2);
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
