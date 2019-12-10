package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;


@RunWith(SpringRunner.class)
@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private HabitacionRepository habitacionRespository;
	
	
	
	@Test
	void contextLoads() {
		
		try {
			
			Cliente antiguo = new Cliente();
			antiguo.setId(01);
			antiguo.setNombre("Antiguo");
			antiguo.setFechaNacimiento(new Date(2019, 9, 9));
		antiguo.setLugarNacimiento("Lima");
		//antiguo.setSexo(m);
		antiguo.setObservacion("buena");
			
		Cliente juan = new Cliente();
		juan.setId(01);
		juan.setNombre("Antiguo");
		juan.setFechaNacimiento(new Date(2019, 9, 9));
	juan.setLugarNacimiento("Lima");
	//juan.setSexo(m);
	juan.setObservacion("buena");
	
			
			
			antiguo = clienteRepository.save(antiguo);
			juan = clienteRepository.save(juan);
			//tipo
			
			Tipo tipo1 = new Tipo();
			tipo1.setId("E01");
			tipo1.setNombre("Habitacion Confortable");
			
			
			
			//habitacion
			
			Habitacion habitacion1 = new Habitacion();
			habitacion1.setNumeroCamas(2);
			habitacion1.setDescripcion("habitacion para 2 personas");
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
