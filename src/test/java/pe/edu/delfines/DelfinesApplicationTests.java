package pe.edu.delfines;

import java.sql.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
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
			Tipo tipo1 = new Tipo();
			tipo1.setId("T1");
			tipo1.setNombre("Matrimonial");
			
			Tipo tipo2 = new Tipo();
			tipo2.setId("T2");
			tipo2.setNombre("Personal");
			
			tipo1 = tipoRepository.save(tipo1);
			tipo2 = tipoRepository.save(tipo2);
			tipoRepository.save(tipo1);
			tipoRepository.save(tipo2);
			
			Vendedor vendedor1 = new Vendedor();
			vendedor1.setId("V1");
			vendedor1.setNombre("Enzo");
			vendedor1.setObservacion("Bueno");
			vendedor1.setSueldo(800.0f);
			vendedor1.setTelefono("989279695");
			
			Vendedor vendedor2 = new Vendedor();
			vendedor2.setId("V2");
			vendedor2.setNombre("Jhon");
			vendedor2.setObservacion("Bueno");
			vendedor2.setSueldo(850.0f);
			vendedor2.setTelefono("989279696");
			
			vendedor1 = vendedorRepository.save(vendedor1);
			vendedor2 = vendedorRepository.save(vendedor2);
			vendedorRepository.save(vendedor1);
			vendedorRepository.save(vendedor2);
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setId(1);
			alquiler1.setPrecio(100.0f);
			alquiler1.setFechaEntrada(new Date(2019,12,9));
			alquiler1.setFechaSalida(new Date(2019,12,10));
			alquiler1.setEstado("Activo");
			alquiler1.setObservacion("Bueno");
			
			Alquiler alquiler2 = new Alquiler();
			alquiler2.setId(1);
			alquiler2.setPrecio(150.0f);
			alquiler2.setFechaEntrada(new Date(2019,12,8));
			alquiler2.setFechaSalida(new Date(2019,12,10));
			alquiler2.setEstado("Activo");
			alquiler2.setObservacion("Bueno");
			
			alquiler1 = alquilerRepository.save(alquiler1);
			alquiler2 = alquilerRepository.save(alquiler2);
			
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(alquiler2);
			
		} catch (Exception e) {
			// TODO: handle exception
		}
	}

}
