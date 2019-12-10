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
	private VendedorRepository vendedorrepository;
	@Autowired
	private TipoRepository tiporepository;
	@Autowired
	private ClienteRepository clienterepository;
	@Autowired
	private AlquilerRepository alquilerrepository;
	@Autowired 
	private HabitacionRepository habitacionrepository;
	
	@Test
	void contextLoads() {
		try {
			//tipo1
			Tipo t1= new Tipo();
			t1.setId("01");
			t1.setNombre("tipo1");
			t1=tiporepository.save(t1);
			//tipo2
			Tipo t2= new Tipo();
			t2.setId("02");
			t2.setNombre("tipo2");
			t2=tiporepository.save(t2);
			//habitacion1
			Habitacion h1=new Habitacion();
			h1.setDescripcion("Habitacion1");
			h1.setId(01);
			h1.setNumeroCamas(3);
			h1.setObservacion("Familiar");
			h1.setPrecio(1000.f);
			h1.setTipo(t1);
			h1=habitacionrepository.save(h1);
			//habitacion2
			Habitacion h2=new Habitacion();
			h2.setDescripcion("Habitacion2");
			h2.setId(02);
			h2.setNumeroCamas(1);
			h2.setObservacion("Matrimonial");
			h2.setPrecio(800.f);
			h2.setTipo(t2);
			h2=habitacionrepository.save(h2);
			//vendedor1
			Vendedor v1= new Vendedor();
			v1.setId("01");
			v1.setNombre("Juan");
			v1.setObservacion("obs1");
			v1.setSueldo(1200.f);
			v1.setTelefono("955421365");
			v1=vendedorrepository.save(v1);
			//vendedor2
			Vendedor v2= new Vendedor();
			v2.setId("02");
			v2.setNombre("Carlos");
			v2.setObservacion("obs2");
			v2.setSueldo(1100.f);
			v2.setTelefono("998421455");
			v2=vendedorrepository.save(v2);
			//cliente1
			Cliente c1=new Cliente();
			c1.setId(01);
			c1.setDocumento("75621548");
			c1.setNombre("Diego");
			c1.setFechaNacimiento(new Date(1998,8,10));
			c1.setLugarNacimiento("SJL");
			c1.setSexo('M');
			c1.setObservacion("obs1");
			c1=clienterepository.save(c1);
			//cliente2
			Cliente c2=new Cliente();
			c2.setId(01);
			c2.setDocumento("75723598");
			c2.setNombre("Ana");
			c2.setFechaNacimiento(new Date(2000,9,11));
			c2.setLugarNacimiento("Huancayo");
			c2.setSexo('F');
			c2.setObservacion("obs2");
			c2=clienterepository.save(c2);
			//Alquiler1
			Alquiler a1=new Alquiler();
			a1.setId(01);
			a1.setPrecio("1500");
			a1.setFecha_entrada(new Date(2019,12,10));
			a1.setFecha_salida(new Date(2019,12,15));
			a1.setEstado("Disponible");
			a1.setObservacion("obs1");
			a1.setVendedor(v1);
			a1.setCliente(c1);
			a1.setHabitacion(h1);
			a1=alquilerrepository.save(a1);
			//Alquiler2
			Alquiler a2=new Alquiler();
			a2.setId(02);
			a2.setPrecio("1200");
			a2.setFecha_entrada(new Date(2019,12,16));
			a2.setFecha_salida(new Date(2019,12,21));
			a2.setEstado("Disponible");
			a2.setObservacion("obs2");
			a2.setVendedor(v2);
			a2.setCliente(c2);
			a2.setHabitacion(h2);
			a2=alquilerrepository.save(a2);
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
