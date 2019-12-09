package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

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
		// Vendedor 1
		Vendedor VendedorYair = new Vendedor();
		VendedorYair.setId("V01");
		VendedorYair.setNombre("Yair Luciano");
		VendedorYair.setDireccion("Brena127");
		VendedorYair.setTelefono("123456789");
		VendedorYair.setObservacion("Vendedor humilde");
		VendedorYair.setSueldo(930f);
		
		// Vendedor 2
		Vendedor VendedorGabriel = new Vendedor();
		VendedorGabriel.setId("V02");
		VendedorGabriel.setNombre("Gabriel Quispe");
		VendedorGabriel.setDireccion("Ugarte 250");
		VendedorGabriel.setTelefono("55555555");
		VendedorGabriel.setObservacion("Vendedor Nuevo");
		VendedorGabriel.setSueldo(1200f);
		
		VendedorYair = vendedorRepository.save(VendedorYair);
		VendedorGabriel = vendedorRepository.save(VendedorGabriel);
		
		
		// Cliente 1
		Cliente ClienteCarlos = new Cliente();
		ClienteCarlos.setDocumento("12345678");
		ClienteCarlos.setNombre("Cliente Carlos");
		ClienteCarlos.setFechaNacimiento(new Date(1966, 9, 9));
		ClienteCarlos.setLugarNacimiento("Puente Piedra");
		ClienteCarlos.setSexo('M');
		ClienteCarlos.setObservacion("Cliente Nuevo");
		
		// Cliente 2
		Cliente ClienteJuan = new Cliente();
		ClienteJuan.setDocumento("78524136");
		ClienteJuan.setNombre("Juan Cliente");
		ClienteJuan.setFechaNacimiento(new Date(1980, 9, 9));
		ClienteJuan.setLugarNacimiento("Pueble Libre");
		ClienteJuan.setSexo('M');
		ClienteJuan.setObservacion("Cliente Antiguo");
		
		ClienteCarlos = clienteRepository.save(ClienteCarlos);
		ClienteJuan = clienteRepository.save(ClienteJuan);
		
		
		// Tipo 1
		Tipo TipoUno = new Tipo();
		TipoUno.setId("T01");
		TipoUno.setNombre("Matrimonial");
		
		// Tipo 2
		Tipo TipoDos = new Tipo();
		TipoDos.setId("T02");
		TipoDos.setNombre("Basico");
		
		TipoUno = tipoRepository.save(TipoUno);
		TipoDos = tipoRepository.save(TipoDos);
		
		// Habitaciones 1
		Habitacion HabitacionUno = new Habitacion();
		HabitacionUno.setNumeroCamas(2);
		HabitacionUno.setDescripcion("Amplia habitacion");
		HabitacionUno.setPrecio(50.0f);
		HabitacionUno.setObservacion("mantenimiento");
		
		// Habitaciones 2
		Habitacion HabitacionDos = new Habitacion();
		HabitacionDos.setNumeroCamas(4);
		HabitacionDos.setDescripcion("Pequena habitacion");
		HabitacionDos.setPrecio(100.0f);
		HabitacionDos.setObservacion("Disponible");
		
		HabitacionUno = habitacionRepository.save(HabitacionUno);
		HabitacionDos = habitacionRepository.save(HabitacionDos);
		
		
		//Alquileres 1
		
		Alquiler AlquilerUno = new Alquiler();
		AlquilerUno.setPrecio(150.5f);
		AlquilerUno.setFechaEntrada("2019-12-09");
		AlquilerUno.setFechaSalida("2019-12-09");
		AlquilerUno.setEstado("Disponible");
		AlquilerUno.setObservacion("por 3 hrs");
		
		
		//Alquileres 2
		
		Alquiler AlquilerDos = new Alquiler();
		AlquilerDos.setPrecio(450.5f);
		AlquilerDos.setFechaEntrada("2019-12-09");
		AlquilerDos.setFechaSalida("2019-12-09");
		AlquilerDos.setEstado("Disponible 2");
		AlquilerDos.setObservacion("por 5 hrs");
		
		AlquilerUno = alquilerRepository.save(AlquilerUno);
		AlquilerDos = alquilerRepository.save(AlquilerDos);
		
		
		// Relacion Alquiler-Vendedor
		AlquilerUno.setVendedor(VendedorYair);		
		
		// Relacion Vendedor-Alquiler
		VendedorGabriel.addAlquiler(AlquilerDos);
		
		// Relacion Alquiler-Clientes
		AlquilerUno.setCliente(ClienteJuan);	
		
		// Relacion clientes-Alquiler
		ClienteCarlos.addAlquiler(AlquilerDos);
		
		// Relacion Alquiler-habitaciones
		AlquilerUno.setHabitacion(HabitacionUno);
		
		// Relacion habitaciones-Alquiler
		HabitacionDos.addAlquiler(AlquilerDos);
		
		
		// grabar
		alquilerRepository.save(AlquilerUno);
		alquilerRepository.save(AlquilerDos);
		
		vendedorRepository.save(VendedorYair);
		vendedorRepository.save(VendedorGabriel);
		
		clienteRepository.save(ClienteCarlos);
		clienteRepository.save(ClienteJuan);
		
		habitacionRepository.save(HabitacionUno);
		habitacionRepository.save(HabitacionDos);
		
		
		
		
		
		
		
		
		
		
	} catch (Exception e) {
		System.out.println(e.getMessage());
	}
	}

}
