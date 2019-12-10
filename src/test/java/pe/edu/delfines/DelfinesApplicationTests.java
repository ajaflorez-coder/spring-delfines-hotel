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
import pe.edu.delfines.services.TipoService;

@SpringBootTest
class DelfinesApplicationTests {
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private TipoRepository tipoRepository;
	
	@SuppressWarnings("deprecation")
	@Test
	void contextLoads() {
		try {
			
			Tipo tipo1= new Tipo();
			tipo1.setId("A001");
			tipo1.setNombre("tipo1");
			tipo1=tipoRepository.save(tipo1);
			//tipoRepository.save(tipo1);
			
			Tipo tipo2= new Tipo();
			tipo2.setId("A002");
			tipo2.setNombre("tipo2");
			tipo2=tipoRepository.save(tipo2);
			//tipoRepository.save(tipo1);
			
			Habitacion h1= new Habitacion();
			h1.setNumeroCamas(23);
			h1.setDescripcion("des1");
			h1.setPrecio(1.2);
			h1.setObservacion("obs1");
			h1.setTipo(tipo1);
			h1=habitacionRepository.save(h1);
			
			Habitacion h2= new Habitacion();
			h2.setNumeroCamas(90);
			h2.setDescripcion("des2");
			h2.setPrecio(1.2);
			h2.setObservacion("obs2");
			h2.setTipo(tipo2);
			h2=habitacionRepository.save(h2);
			
			Vendedor v1 =new Vendedor();
			v1.setId("C001");
			v1.setNombre("vendedor1");
			v1.setDireccion("avenida1");
			v1.setTelefono("5678910");
			v1.setObservacion("obs1");
			v1.setSueldo(10.0);
			v1=vendedorRepository.save(v1);
			
			Vendedor v2 =new Vendedor();
			v2.setId("C002");
			v2.setNombre("vendedor2");
			v2.setDireccion("avenida2");
			v2.setTelefono("5678910");
			v2.setObservacion("obs2");
			v2.setSueldo(12.0);
			v2=vendedorRepository.save(v2);
			
			
			Cliente c1=new Cliente();
			c1.setDocumento("doc1");
			c1.setNombre("nombre1");
			c1.setFechaNacimiento(new Date(2010, 10, 10));
			c1.setLugarNacimiento("lugar1");
			c1.setSexo('M');
			c1.setObservacion("obs1");
			c1=clienteRepository.save(c1);
			
			Cliente c2=new Cliente();
			c2.setDocumento("doc2");
			c2.setNombre("nombre2");
			c2.setFechaNacimiento(new Date(2010, 10, 10));
			c2.setLugarNacimiento("lugar2");
			c2.setSexo('F');
			c2.setObservacion("obs2");
			c2=clienteRepository.save(c2);
			
			Alquiler a1= new Alquiler();
			a1.setPrecio(20.1);
			a1.setFechaentrada(new Date(2020, 10, 10));
			a1.setFechasalida(new Date(2020, 10, 10));
			a1.setEstado("esta1");
			a1.setObservacion("obs1");
			a1.setVendedor(v1);
			a1.setCliente(c1);
			a1.setHabitacion(h1);
			a1=alquilerRepository.save(a1);
			
			Alquiler a2= new Alquiler();
			a2.setPrecio(90.1);
			a2.setFechaentrada(new Date(2010, 10, 10));
			a2.setFechasalida(new Date(2010, 10, 10));
			a2.setEstado("esta2");
			a2.setObservacion("obs2");
			a2.setVendedor(v2);
			a2.setCliente(c2);
			a2.setHabitacion(h2);
			a2=alquilerRepository.save(a2);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

}
