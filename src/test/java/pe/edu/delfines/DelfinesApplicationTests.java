package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
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
	private TipoRepository tipoRepository;

	@Autowired
	private HabitacionRepository habitacionRepository;

	@Autowired
	private VendedorRepository vendedorRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private AlquilerRepository alquilerRepository;

	@Test
	public void contextLoads() {

		try {
			/*//Tipos
			Tipo tipo1 = new Tipo();
			tipo1.setId("1");
			tipo1.setNombre("tipo1");
			Tipo tipo2 = new Tipo();
			tipo2.setId("2");
			tipo2.setNombre("tipo2");
			tipo1 = tipoRepository.save(tipo1);
			tipo2 = tipoRepository.save(tipo2);
			
			// ===================================
			
			//Habitaciones
			Habitacion habitacion1 = new Habitacion();
			habitacion1.setId(1);
			habitacion1.setNumeroCamas(3);
			habitacion1.setDescripcion("habitacion1");
			habitacion1.setPrecio(100.00f);
			habitacion1.setTipo(tipo1);
			habitacion1.setObservacion("observacion1");
			Habitacion habitacion2 = new Habitacion();
			habitacion2.setId(2);
			habitacion2.setNumeroCamas(2);
			habitacion2.setDescripcion("habitacion2");
			habitacion2.setPrecio(200.00f);
			habitacion2.setTipo(tipo2);
			habitacion2.setObservacion("observacion2");
			habitacion1 = habitacionRepository.save(habitacion1);
			habitacion2 = habitacionRepository.save(habitacion2);
			
			// ===================================

			//Vendedores
			Vendedor vendedor1 = new Vendedor();
			vendedor1.setId("1");
			vendedor1.setNombre("Vendedor1");
			vendedor1.setDireccion("direccion1");
			vendedor1.setTelefono("123456789");
			vendedor1.setObservacion("observacion1");
			vendedor1.setSueldo(1000f);
			Vendedor vendedor2 = new Vendedor();
			vendedor2.setId("2");
			vendedor2.setNombre("Vendedor2");
			vendedor2.setDireccion("direccion2");
			vendedor2.setTelefono("123456789");
			vendedor2.setObservacion("observacion2");
			vendedor2.setSueldo(1000f);
			vendedor1 = vendedorRepository.save(vendedor1);
			vendedor2 = vendedorRepository.save(vendedor2);

			// ===================================

			//Cliente
			Cliente cliente1 = new Cliente();
			cliente1.setId(1);
			cliente1.setDocumento("1234567");
			cliente1.setNombre("Cliente1");
			cliente1.setFechaNacimiento(new Date(2019, 9, 9));
			cliente1.setLugarNacimiento("Lugar1");
			cliente1.setSexo('M');
			cliente1.setObservacion("observacion1");
			Cliente cliente2 = new Cliente();
			cliente2.setId(2);
			cliente2.setDocumento("1234567");
			cliente2.setNombre("Cliente2");
			cliente2.setFechaNacimiento(new Date(2019, 9, 9));
			cliente2.setLugarNacimiento("Lugar2");
			cliente2.setSexo('F');
			cliente2.setObservacion("observacion2");
			cliente1 = clienteRepository.save(cliente1);
			cliente2 = clienteRepository.save(cliente2);
			
			// ===================================
			
			// Alquileres
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setId(1);
			alquiler1.setPrecio(2000f);
			alquiler1.setFecha_Entrada(new Date(2019, 9, 9));
			alquiler1.setFecha_Salida(new Date(2020, 9, 9));
			alquiler1.setEstado("estado1");
			alquiler1.setObservacion("observacion1");
			alquiler1.setVendedor(vendedor1);
			alquiler1.setCliente(cliente1);
			alquiler1.setHabitacion(habitacion1);
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setId(2);
			alquiler2.setPrecio(3000f);
			alquiler2.setFecha_Entrada(new Date(2019, 9, 9));
			alquiler2.setFecha_Salida(new Date(2020, 9, 9));
			alquiler2.setEstado("estado2");
			alquiler2.setObservacion("observacion2");
			alquiler2.setVendedor(vendedor2);
			alquiler2.setCliente(cliente2);
			alquiler2.setHabitacion(habitacion2);
			alquiler1 = alquilerRepository.save(alquiler1);
			alquiler2 = alquilerRepository.save(alquiler2);
*/

			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
