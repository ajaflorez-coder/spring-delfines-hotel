package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
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
	TipoRepository tipoRepository;
	@Autowired
	AlquilerRepository alquilerRepository;
	@Autowired
	HabitacionRepository habitacionRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	VendedorRepository vendedorRepository;
	@Test
	void contextLoads() {
		
		try {
			Tipo duplex = new Tipo();
			duplex.setId("T1");
			duplex.setNombre("duplex");
			Tipo matrimonial = new Tipo();
			matrimonial.setId("T3");
			matrimonial.setNombre("matrimonial");
			
			duplex = tipoRepository.save(duplex);
			matrimonial = tipoRepository.save(matrimonial);
			
			Habitacion habitacionUno = new Habitacion();
			habitacionUno.setNumeroCamas(1);
			habitacionUno.setDescripcion("limpio");
			habitacionUno.setPrecio((float) 51.88);
			habitacionUno.setObservacion("limpio");
			habitacionUno.setTipo(matrimonial);
			
			Habitacion habitacionDos = new Habitacion();
			habitacionDos.setNumeroCamas(3);
			habitacionDos.setDescripcion("limpio");
			habitacionDos.setPrecio((float)51.88);
			habitacionDos.setObservacion("limpio");
			habitacionDos.setTipo(duplex);
			
			habitacionUno = habitacionRepository.save(habitacionUno);
			habitacionDos = habitacionRepository.save(habitacionDos);
			
			Vendedor vendUno= new Vendedor();
			vendUno.setId("V1");
			vendUno.setNombre("juan");
			vendUno.setDireccion("la calle 1");
			vendUno.setTelefono("5555555");
			vendUno.setObservacion("Nada que escribir");
			vendUno.setSueldo((float)1555.88);
			
			Vendedor vendDos= new Vendedor();
			vendDos.setId("V3");
			vendDos.setNombre("julio");
			vendDos.setDireccion("la calle 3");
			vendDos.setTelefono("5555553");
			vendDos.setObservacion("Algo que escribir");
			vendDos.setSueldo((float)1577.88);
			
			vendUno = vendedorRepository.save(vendUno);
			vendDos = vendedorRepository.save(vendDos);
			
			Cliente c1 = new Cliente();
			c1.setId(1);
			c1.setDocumento("DNI");
			c1.setNombre("key cuevas");
			c1.setFechaNacimiento(new Date("2019-05-01"));
			c1.setLugarNacimiento("lima");
			c1.setSexo('m');
			c1.setObservacion("premium");
			
			Cliente c3 = new Cliente();
			c3.setId(3);
			c3.setDocumento("DNI");
			c3.setNombre("abigail cuevas");
			c3.setFechaNacimiento(new Date("2019-04-01"));
			c3.setLugarNacimiento("lima");
			c3.setSexo('f');
			c3.setObservacion("premium");
			
			c1 = clienteRepository.save(c1);
			c3 = clienteRepository.save(c3);
			
			Alquiler a1= new Alquiler();
			a1.setId(1);
			a1.setPrecio((float)15.88);
			a1.setFechaEntrada(new Date("2019-11-11"));
			a1.setFechaSalida(new Date("2019-11-13"));
			a1.setEstado("activo");
			a1.setObservacion("premium");
			a1.setVendedor(vendUno);
			a1.setCliente(c1);
			a1.setHabitacion(habitacionUno);
			
			Alquiler a3= new Alquiler();
			a3.setId(3);
			a3.setPrecio((float)15.88);
			a3.setFechaEntrada(new Date("2019-11-01"));
			a3.setFechaSalida(new Date("2019-11-03"));
			a3.setEstado("activo");
			a3.setObservacion("premium");
			a3.setVendedor(vendUno);
			a3.setCliente(c3);
			a3.setHabitacion(habitacionDos);
			
			a1 = alquilerRepository.save(a1);
			a3 = alquilerRepository.save(a3);
			
			
			tipoRepository.save(duplex);
			tipoRepository.save(matrimonial);
			habitacionRepository.save(habitacionUno);
			habitacionRepository.save(habitacionDos);
			vendedorRepository.save(vendUno);
			vendedorRepository.save(vendDos);
			clienteRepository.save(c1);
			clienteRepository.save(c3);
			alquilerRepository.save(a1);
			alquilerRepository.save(a3);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}

}
