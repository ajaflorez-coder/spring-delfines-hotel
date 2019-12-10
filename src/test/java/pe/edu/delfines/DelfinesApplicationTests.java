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

@RunWith(SpringRunner.class)
@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private ClienteRepository clienteRepository;
	@Autowired
	private HabitacionRepository habitacionRepository;
	@Autowired
	private TipoRepository tipoRepository;
	@Autowired
	private VendedorRepository vendedorRepository;
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Test
	public void contextLoads() {
		
		try {
			//Clientes
			Cliente c1 = new Cliente();
			c1.setId(001);
			c1.setDocumento("00119488");
			c1.setNombre("Markos");
			c1.setFechaNacimiento(new Date(1999, 8, 9));
			c1.setLugarNacimiento("Lima");
			c1.setSexo('M');
			c1.setObservacion("alumno UPN");
			
			Cliente c2 = new Cliente();
			c2.setId(002);
			c2.setDocumento("00176488");
			c2.setNombre("Steven");
			c2.setFechaNacimiento(new Date(1998, 8, 9));
			c2.setLugarNacimiento("Lima");
			c2.setSexo('M');
			c2.setObservacion("alumno UPN");
			
			c1 = clienteRepository.save(c1);
			c2 = clienteRepository.save(c2);
			
			//Tipos
			Tipo t1 = new Tipo();
			t1.setTipo_id("t001");
			t1.setNombre("Normal");
			
			Tipo t2 = new Tipo();
			t2.setTipo_id("t002");
			t2.setNombre("Normal");
			
			t1 = tipoRepository.save(t1);
			t2 = tipoRepository.save(t2);
			
			//Habitaciones
			Habitacion h1 = new Habitacion();
			h1.setId(214);
			h1.setNumeroCamas(2);
			h1.setDescripcion("libre de ratas");
			h1.setPrecio(250f);
			h1.setTipo(t1);
			h1.setObservacion("...");
			
			Habitacion h2 = new Habitacion();
			h2.setId(304);
			h2.setNumeroCamas(1);
			h2.setDescripcion("con piscina inflable");
			h2.setPrecio(350f);
			h2.setTipo(t2);
			h2.setObservacion("...");
			
			h1 = habitacionRepository.save(h1);
			h2 = habitacionRepository.save(h2);
			
			//Vendedores
			Vendedor v1 = new Vendedor();
			v1.setId("v001");
			v1.setNombre("Carlos");
			v1.setDireccion("av. x");
			v1.setTelefono("992485167");
			v1.setObservacion("sin cargos penales");
			v1.setSueldo(40f);			
			
			Vendedor v2 = new Vendedor();
			v2.setId("v002");
			v2.setNombre("Ian");
			v2.setDireccion("av. y");
			v2.setTelefono("993468121");
			v2.setObservacion("sin cargos penales");
			v2.setSueldo(50f);
			
			v1 = vendedorRepository.save(v1);
			v2 = vendedorRepository.save(v2);
			
			//Alquileres
			Alquiler a1 = new Alquiler();
			a1.setId(026);
			a1.setPrecio(500f);
			a1.setFechaI(new Date(2019, 12, 9));
			a1.setFechaF(new Date(2019, 12, 31));
			a1.setEstado("Activo");
			a1.setObservacion("cliente recurrente");
			a1.setVendedor(v1);
			a1.setCliente(c1);
			a1.setHabitacion(h2);
			
			Alquiler a2 = new Alquiler();
			a2.setId(015);
			a2.setPrecio(750f);
			a2.setFechaI(new Date(2019, 12, 5));
			a2.setFechaF(new Date(2019, 12, 31));
			a2.setEstado("Activo");
			a2.setObservacion("cliente recurrente");
			a2.setVendedor(v2);
			a2.setCliente(c2);
			a2.setHabitacion(h2);
			
			a1 = alquilerRepository.save(a1);
			a2 = alquilerRepository.save(a2);
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}


}
