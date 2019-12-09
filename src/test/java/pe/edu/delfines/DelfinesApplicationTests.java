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
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Test
	void contextLoads() {
		
		try {
			Tipo normal = new Tipo();
			normal.setId("T01");
			normal.setNombre("Habitacion Normal");
			
			Tipo VIP = new Tipo();
			VIP.setId("T02");
			VIP.setNombre("Habitacion VIP");
			
			normal = tipoRepository.save(normal);
			VIP = tipoRepository.save(VIP);
			
			Habitacion habitacion1 = new Habitacion();
			habitacion1.setDescripcion("Habitacion familiar");
			habitacion1.setNumeroCamas(3);
			habitacion1.setPrecio((float) 1000);
			habitacion1.setObservacion("Tiene un hueco en la sala");
			
			Habitacion habitacion2 = new Habitacion();
			habitacion2.setDescripcion("Habitacion para pareja");
			habitacion2.setNumeroCamas(1);
			habitacion2.setPrecio((float) 700);
			habitacion2.setObservacion("Infestacion de ratas");
			
			habitacion1 = habitacionRepository.save(habitacion1);
			habitacion2 = habitacionRepository.save(habitacion2);
			
			Vendedor vendedor1 = new Vendedor();
			vendedor1.setId("V01");
			vendedor1.setNombre("Luis");
			vendedor1.setDireccion("Su casa");
			vendedor1.setTelefono("948739272");
			vendedor1.setObservacion("Buen vendedor");
			vendedor1.setSueldo((float)1000);

			Vendedor vendedor2 = new Vendedor();
			vendedor2.setId("V02");
			vendedor2.setNombre("Alberto");
			vendedor2.setDireccion("Esa casa");
			vendedor2.setTelefono("948742272");
			vendedor2.setObservacion("Iguala sus ventas cada semana");
			vendedor2.setSueldo((float)1500);
			
			vendedor1 = vendedorRepository.save(vendedor1);
			vendedor2 = vendedorRepository.save(vendedor2);
			
			Cliente cliente1 = new Cliente();
			cliente1.setDocumento("73795844");
			cliente1.setNombre("Ese pata");
			cliente1.setFechaNacimiento(new Date(2000, 9, 9));
			cliente1.setLugarNacimiento("Lima");
			cliente1.setSexo('M');
			cliente1.setObservacion("No puede pagar en efectivo");
			
			Cliente cliente2 = new Cliente();
			cliente2.setDocumento("73686264");
			cliente2.setNombre("Adrian");
			cliente2.setFechaNacimiento(new Date(1997, 5, 7));
			cliente2.setLugarNacimiento("Lima");
			cliente2.setSexo('M');
			cliente2.setObservacion("Alquila 2 cuartos");
			
			cliente1 = clienteRepository.save(cliente1);
			cliente2 = clienteRepository.save(cliente2);
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setPrecio((float)1500);
			alquiler1.setFechaEntrada(new Date(2019, 12, 3));
			alquiler1.setFechaSalida(new Date(2019, 12, 5));
			alquiler1.setEstado("En alquiler");
			alquiler1.setObservacion("Alquilado pocos dias");
			
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setPrecio((float)1700);
			alquiler2.setFechaEntrada(new Date(2019, 4, 7));
			alquiler2.setFechaSalida(new Date(2019, 5, 5));
			alquiler2.setEstado("En alquiler");
			alquiler2.setObservacion("Varios dias alquilados");
			
			alquiler1 = alquilerRepository.save(alquiler1);
			alquiler2 = alquilerRepository.save(alquiler2);
			
			habitacion1.setTipo(normal);
			habitacion2.setTipo(VIP);
			
			normal.addHabitacion(habitacion1);
			VIP.addHabitacion(habitacion2);
			
			alquiler1.setHabitacion(habitacion1);
			alquiler1.setHabitacion(habitacion2);
			
			habitacion1.addAlquiler(alquiler1);
			habitacion2.addAlquiler(alquiler2);
			
			alquiler1.setVendedor(vendedor1);
			alquiler2.setVendedor(vendedor2);
			
			vendedor1.addAlquiler(alquiler1);
			vendedor2.addAlquiler(alquiler2);
			
			alquiler1.setCliente(cliente1);
			alquiler2.setCliente(cliente2);
			
			cliente1.addAlquiler(alquiler1);
			cliente2.addAlquiler(alquiler2);
			
			tipoRepository.save(normal);
			tipoRepository.save(VIP);
			habitacionRepository.save(habitacion1);
			habitacionRepository.save(habitacion2);
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			vendedorRepository.save(vendedor1);
			vendedorRepository.save(vendedor2);
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(alquiler2);
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
	}
	}
}
