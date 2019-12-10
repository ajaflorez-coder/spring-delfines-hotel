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
	private  ClienteRepository clienteRepository;
	
	@Autowired
	private  TipoRepository tipoRepository;
	
	@Autowired
	private  HabitacionRepository habitacionRepository;
	
	@Autowired
	private  AlquilerRepository alquilerRepository;
	
	@Autowired
	private  VendedorRepository vendedorRepository;
	
	@Test
	public void contextLoads() {
		
		try {
			
			Cliente cliente1  = new Cliente();
			cliente1.setDocumento("12345678");
			cliente1.setNombre("diego");
			cliente1.setFechaNacimiento(new Date(2019, 9, 9));
			cliente1.setLugarNacimiento("Lima");
			cliente1.setSexo('M');
			cliente1.setObservacion("ninguna");
			
			
			
			Cliente cliente2  = new Cliente();
			cliente2.setDocumento("12345456");
			cliente2.setNombre("alex");
			cliente2.setFechaNacimiento(new Date(2010, 9, 9));
			cliente2.setLugarNacimiento("Lima");
			cliente2.setSexo('M');
			cliente2.setObservacion("ninguna");
			
			
			
			cliente1 = clienteRepository.save(cliente1);
			cliente2 = clienteRepository.save(cliente2);
			
			
			
			
			Tipo tipo1 = new Tipo();
			tipo1.setId("1");
			tipo1.setNombre("tipo1");
			
			Tipo tipo2 = new Tipo();
			tipo2.setId("2");
			tipo2.setNombre("tipo1");
			
			
			tipo1 = tipoRepository.save(tipo1);
			tipo2 = tipoRepository.save(tipo2);
			
			
			Vendedor ven1 = new Vendedor();
			
			ven1.setId("1");
			ven1.setNombre("vendedor1");
			ven1.setDireccion("jr.ica");
			ven1.setTelefono("900456789");
			ven1.setObservacion("ninguna");
			ven1.setSueldo(1000f);
			
			
			Vendedor ven2 = new Vendedor();
			
			ven2.setId("2");
			ven2.setNombre("vendedor2");
			ven2.setDireccion("jr.huano");
			ven2.setTelefono("903456789");
			ven2.setObservacion("ninguna");
			ven2.setSueldo(1500f);
			
			ven1 = vendedorRepository.save(ven1);
			ven2 = vendedorRepository.save(ven2);
			
			
			Habitacion h1 = new Habitacion();
			h1.setNumeroCamas(11);
			h1.setDescripcion("ssss");
			h1.setPrecio(100f);
			h1.setObservacion("nim");
			h1.setTipo(tipo1);
			
			
			
			Habitacion h2 = new Habitacion();
			h2.setNumeroCamas(10);
			h2.setDescripcion("aaaa");
			h2.setPrecio(500f);
			h2.setObservacion("nin");
			h2.setTipo(tipo1);
			
			h1 = habitacionRepository.save(h1);
			h2 = habitacionRepository.save(h2);
			
			
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setPrecio("1200");
			alquiler1.setFecha_entrada(new Date(2010, 19, 9));
			alquiler1.setFecha_salida(new Date(2010, 19, 11));
			alquiler1.setEstado("libre");
			alquiler1.setObservacion("ninguna");
			alquiler1.setVendedor(ven1);
			alquiler1.setHabitacion(h1);
			alquiler1.setCliente(cliente1);
			
			
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setPrecio("1000");
			alquiler2.setFecha_entrada(new Date(2011, 9, 9));
			alquiler2.setFecha_salida(new Date(2011, 9, 11));
			alquiler2.setEstado("libertad");
			alquiler2.setObservacion("ninguna2");
			alquiler2.setVendedor(ven2);
			alquiler2.setHabitacion(h2);
			alquiler2.setCliente(cliente2);
			
			alquiler1 = alquilerRepository.save(alquiler1);
			alquiler2 = alquilerRepository.save(alquiler2);
			
			
			//grabar
			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
			vendedorRepository.save(ven1);
			vendedorRepository.save(ven2);
			habitacionRepository.save(h1);
			habitacionRepository.save(h2);
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(alquiler2);
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		
		
	}

}
