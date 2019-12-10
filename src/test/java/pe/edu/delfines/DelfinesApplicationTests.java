package pe.edu.delfines;


import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.VendedorRepository;




@SpringBootTest
public class DelfinesApplicationTests {
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;

	
	@Test
	public void contextLoads() {
		
		try {
			
			//cliente 
			Cliente gustavo = new Cliente();
			gustavo.setId(8);
			gustavo.setNombre("Gustavo");
			gustavo.setObservacion("ocupado");
			gustavo.setFechaNacimiento(new Date(1990, 9, 9));
			gustavo.setLugarNacimiento("Lima");
			
			
			Cliente maria = new Cliente();
			maria.setId(8);
			maria.setNombre("Maria");
			maria.setObservacion("ocupado");
			maria.setFechaNacimiento(new Date(1990, 9, 9));
			maria.setLugarNacimiento("Lima");
			
			
			gustavo = clienteRepository.save(gustavo);
			maria = clienteRepository.save(maria);
			
			//alquiler
			Alquiler king = new Alquiler();
			king.setId(100);
			king.setFechaEntrada(new Date(2019, 9, 9));
			king.setEstado("disponible");
			king.setObservacion("Grande");
			
			
			Alquiler queen = new Alquiler();
			queen.setId(120);
			queen.setFechaEntrada(new Date(2019, 9, 15));
			queen.setEstado("no disponible");
			queen.setObservacion("Pequeño");
			
			king = alquilerRepository.save(king);
			queen=alquilerRepository.save(queen);
			
			//vendedor
			Vendedor joselyn= new Vendedor();
			joselyn.setId("20");
			joselyn.setNombre("Maria");
			joselyn.setObservacion("Administrador");
			
			
			Vendedor paolo = new Vendedor();
		    paolo.setId("22");
			paolo.setNombre("Paolo");
			paolo.setObservacion("Conserje");
			
			joselyn= vendedorRepository.save(joselyn);
			paolo=vendedorRepository.save(paolo);
			
			//habitacion
			Habitacion habitacion1=new Habitacion();
			habitacion1.setDescripcion("grande");
			habitacion1.setId(800);
			habitacion1.setNumeroCamas(2);
			
			Habitacion habitacion2=new Habitacion();
			habitacion2.setDescripcion("grande");
			habitacion2.setId(900);
			habitacion2.setNumeroCamas(3);
			
			habitacion1= habitacionRepository.save(habitacion1);
			habitacion2= habitacionRepository.save(habitacion2);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		

	}
	}
