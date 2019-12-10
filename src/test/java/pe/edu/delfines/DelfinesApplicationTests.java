package pe.edu.delfines;

import java.util.Date;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.ClienteRepository;
import pe.edu.delfines.models.repository.HabitacionRepository;
import pe.edu.delfines.models.repository.TipoRepository;
import pe.edu.delfines.models.repository.VendedorRepository;

@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private AlquilerRepository alquilerrepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private HabitacionRepository habitacionrepository;
	@Autowired
	private TipoRepository tiporepository;
	@Autowired
	private VendedorRepository vendedorrepository;
	

	@Test
	void contextLoads() {
		
		try {
			
			//Tipo
			Tipo presidencial = new Tipo();
			presidencial.setId("P001");
			presidencial.setNombre("Presidencial");
			
			Tipo normal = new Tipo();
			normal.setId("N001");
			normal.setNombre("Normal");
			
			presidencial = tiporepository.save(presidencial);
			normal = tiporepository.save(normal);
			
			//Habitacion
			Habitacion habitacion1 = new Habitacion();
			habitacion1.setNumeroCamas(03);
			habitacion1.setDescripcion("Camas amplias");
			habitacion1.setPrecio((float)25.5);
			habitacion1.setObservacion("maximo de 4 personas");
			
			Habitacion habitacion2 = new Habitacion();
			habitacion2.setNumeroCamas(04);
			habitacion2.setDescripcion("Contiene litera");
			habitacion2.setPrecio((float)90.05);
			habitacion2.setObservacion("maximo de 6 personas");
			
			
			habitacion1 = habitacionrepository.save(habitacion1);
			habitacion2 = habitacionrepository.save(habitacion2);
			
			//Vendedor
			
			Vendedor vendedor1 = new Vendedor();
			vendedor1.setId("V001");
			vendedor1.setNombre("Pepe");
			vendedor1.setDireccion("Jr.Breña");
			vendedor1.setTelefono("956874321");
			vendedor1.setObservacion("Buena presentacion");
			vendedor1.setSueldo((float)951.00);
			
			Vendedor vendedor2 = new Vendedor();
			vendedor2.setId("V002");
			vendedor2.setNombre("Alvaro");
			vendedor2.setDireccion("Jr.Bolognesi");
			vendedor2.setTelefono("932697541");
			vendedor2.setObservacion("Alto conocimiento");
			vendedor2.setSueldo((float)1200.50);
			
			
			vendedor1 = vendedorrepository.save(vendedor1);
			vendedor2 = vendedorrepository.save(vendedor2);
			
			
			//Cliente
			
			Cliente cliente1 = new Cliente();
			cliente1.setDocumento("49687325");
			cliente1.setNombre("Pedrito");
			cliente1.setFechaNacimiento(new Date(1999,14,9));
			cliente1.setLugarNacimiento("Trujillo");
			cliente1.setSexo('M');
			cliente1.setObservacion("Alto");
			
			Cliente cliente2 = new Cliente();
			cliente2.setDocumento("36425698");
			cliente2.setNombre("Alexandra");
			cliente2.setFechaNacimiento(new Date(1997,20,10));
			cliente2.setLugarNacimiento("Lima");
			cliente2.setSexo('F');
			cliente2.setObservacion("Baja estatura");
			
			
			cliente1 = clienterepository.save(cliente1);
			cliente2 = clienterepository.save(cliente2);
			
			//Alquiler
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setPrecio((float)500.00);
			alquiler1.setFechaEntrada(new Date(2019,03,21));
			alquiler1.setFechaSalida(new Date(2019,04,22));
			alquiler1.setEstado("Vendido");
			alquiler1.setObservacion("Vendido a Pedrito");
			
			
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setPrecio((float)700.00);
			alquiler2.setFechaEntrada(new Date(2019,05,21));
			alquiler2.setFechaSalida(new Date(2019,06,22));
			alquiler2.setEstado("Reservado");
			alquiler2.setObservacion("Reservado a Alexandra");
			
			
			alquiler1 = alquilerrepository.save(alquiler1);
			alquiler2 = alquilerrepository.save(alquiler2);
			
			//Relacion Habitacion-Tipo
			habitacion1.setTipo(normal);
			habitacion2.setTipo(presidencial);
			
			//Relacion Tipo-Habitacion
			presidencial.addHabitacion(habitacion2);
			normal.addHabitacion(habitacion1);
		
			habitacion1.addAlquiler(alquiler1);
			habitacion2.addAlquiler(alquiler2);
			
			//Relacion Alquiler-Habitacion
			alquiler1.setHabitacion(habitacion1);
			alquiler2.setHabitacion(habitacion2);
			
			
			vendedor1.addAlquiler(alquiler1);
			vendedor2.addAlquiler(alquiler2);
			
			
			//Relacion Alquiler-Vendedor
			alquiler1.setVendedor(vendedor1);
			alquiler2.setVendedor(vendedor2);
			
			
			cliente1.addAlquiler(alquiler1);
			cliente2.addAlquiler(alquiler2);
			
			//Relacion Alquiler-Cliente
			alquiler1.setCliente(cliente1);
			alquiler2.setCliente(cliente2);
			
			
			tiporepository.save(presidencial);
			tiporepository.save(normal);
			
			habitacionrepository.save(habitacion1);
			habitacionrepository.save(habitacion2);
			
			vendedorrepository.save(vendedor1);
			vendedorrepository.save(vendedor2);
			
			clienterepository.save(cliente1);
			clienterepository.save(cliente2);
			
			alquilerrepository.save(alquiler1);
			alquilerrepository.save(alquiler2);
			
		
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
