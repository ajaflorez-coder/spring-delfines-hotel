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
	private AlquilerRepository alquilerRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;

	@Test
	void contextLoads() {
		try {
			Cliente juan  = new Cliente();
			juan.setNombre("Juan Perez");
			juan.setDocumento("12345678");
			juan.setFechaNacimiento(new Date(1980/05/26));
			juan.setLugarNacimiento("La Victoria");
			juan.setSexo('M');
			juan.setObservacion("adsfasdf");
			
			Cliente pedro  = new Cliente();
			pedro.setNombre("Pedro Loli");
			pedro.setDocumento("12345678");
			pedro.setFechaNacimiento(new Date(1990/07/20));
			pedro.setLugarNacimiento("Barranco");
			pedro.setSexo('M');
			pedro.setObservacion("faedadafe");
			
			juan = clienteRepository.save(juan);
			pedro = clienteRepository.save(pedro);
			
			
			Tipo tipo1 = new Tipo();
			tipo1.setNombre("tipo 1");
			
			Tipo tipo2 = new Tipo();
			tipo1.setNombre("tipo 2");
			
			tipo1 = tipoRepository.save(tipo1);
			tipo2 = tipoRepository.save(tipo2);
			
			Habitacion habitacion1 = new Habitacion();
			habitacion1.setNumeroCamas(3);
			habitacion1.setDescripcion("habitacion 1");
			habitacion1.setPrecio(15.0);
			habitacion1.setTipo(tipo1);
			habitacion1.setObservacion("buen estado");
			
			Habitacion habitacion2 = new Habitacion();
			habitacion2.setNumeroCamas(2);
			habitacion2.setDescripcion("habitacion 2");
			habitacion2.setPrecio(10.0);
			habitacion2.setTipo(tipo2);
			habitacion2.setObservacion("excelente estado");
			
			habitacion1 = habitacionRepository.save(habitacion1);
			habitacion2 = habitacionRepository.save(habitacion2);
			
			Vendedor cielo = new Vendedor();
			cielo.setNombre("Cielo");
			cielo.setDireccion("Av Trapiche");
			cielo.setTelefono("22255588");
			cielo.setObservacion("buena trabajadora, medio floja");
			cielo.setSueldo(2000.0f);
			
			Vendedor fiorella = new Vendedor();
			fiorella.setNombre("Cielo");
			fiorella.setDireccion("San Miguel");
			fiorella.setTelefono("33355557");
			fiorella.setObservacion("gran trabajadora");
			fiorella.setSueldo(2000.0f);
			
			cielo = vendedorRepository.save(cielo);
			fiorella = vendedorRepository.save(fiorella);
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setPrecio(20.0);
			alquiler1.setFecha_entrada(new Date(2019/06/15));
			alquiler1.setFecha_salida(new Date(2019/07/20));
			alquiler1.setObservacion("adsfsadfsad");
			alquiler1.setEstado('B');
			
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setPrecio(20.0);
			alquiler2.setFecha_entrada(new Date(2019/04/12));
			alquiler2.setFecha_salida(new Date(2019/9/20));
			alquiler2.setObservacion("afdsafsaedsad");
			alquiler2.setEstado('C');
			
			alquiler1 = alquilerRepository.save(alquiler1);
			alquiler2 = alquilerRepository.save(alquiler2);
			
			
			
			// Relacion vendedor - alquiler
			fiorella.addAlquiler(alquiler1);
			cielo.addAlquiler(alquiler2);
			
			alquiler1.setVendedor(fiorella);
			alquiler2.setVendedor(cielo);
			
			alquiler1.setCliente(juan);
			alquiler2.setCliente(pedro);
			// Relacion cliente - alquiler
			juan.addAlquiler(alquiler1);
			pedro.addAlquiler(alquiler2);
			
			// Relacion tipo - habitacion  
			tipo1.addHabitacion(habitacion1);
			tipo2.addHabitacion(habitacion1);
			
			habitacion1.setTipo(tipo1);
			habitacion2.setTipo(tipo2);
			// Relacion habitacion - alquiler
			habitacion1.addAlquiler(alquiler1);
			habitacion2.addAlquiler(alquiler2);
			
			alquiler1.setHabitacion(habitacion1);
			alquiler2.setHabitacion(habitacion2);
			
			clienteRepository.save(juan);
			clienteRepository.save(pedro);
			habitacionRepository.save(habitacion1);
			habitacionRepository.save(habitacion2);
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
			vendedorRepository.save(cielo);
			vendedorRepository.save(fiorella);
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(alquiler2);
		}catch(Exception e) {System.out.println(e.getMessage());}
	}

}
