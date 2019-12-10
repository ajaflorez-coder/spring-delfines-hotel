package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
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
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	

	@Test
	void contextLoads() {
		try {
			Vendedor vendedor1 = new Vendedor();
			vendedor1.setId("A1");
			vendedor1.setNombre("Guillermo Nakamura");
			vendedor1.setObservacion("Guapo");
			vendedor1.setSueldo(15000.0f);
			vendedor1.setTelefono("942052385");
			
			Vendedor vendedor2 = new Vendedor();
			vendedor2.setId("A2");
			vendedor2.setNombre("Cariel Emilse");
			vendedor2.setObservacion("Bonita");
			vendedor2.setSueldo(2000.0f);
			vendedor2.setTelefono("942052322");
			
			vendedor1 = vendedorRepository.save(vendedor1);
			vendedor2 = vendedorRepository.save(vendedor2);
			
			vendedorRepository.save(vendedor1);
			vendedorRepository.save(vendedor1);
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setId(21);
			alquiler1.setPrecio(100.0f);
			alquiler1.setFecha_entrada(new Date(2019,12,9));
			alquiler1.setFecha_salida(new Date(2019,12,11));
			alquiler1.setEstado("Activo");
			alquiler1.setObservacion("Bueno");
			
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setId(22);
			alquiler2.setPrecio(100.0f);
			alquiler2.setFecha_entrada(new Date(2019,12,9));
			alquiler2.setFecha_salida(new Date(2019,12,11));
			alquiler2.setEstado("Inactivo");
			alquiler2.setObservacion("Regular");
			
			alquiler1 = alquilerRepository.save(alquiler1);
			alquiler2 = alquilerRepository.save(alquiler2);

			vendedorRepository.save(vendedor1);
			vendedorRepository.save(vendedor2);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
