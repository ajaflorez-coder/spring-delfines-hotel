package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Vendedor;
import pe.edu.delfines.models.repository.AlquilerRepository;
import pe.edu.delfines.models.repository.VendedorRepository;


@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Test
	void contextLoads() {
		
		try {
			Vendedor test = new Vendedor();
			test.setId("V001");
			test.setNombre("Test Vendedor 1");
			test.setDireccion("av. fierrazo");
			test.setTelefono(4221210);
			test.setSueldo(1500f);
			
			Vendedor vendedor2 = new Vendedor();
			
			vendedor2.setId("V002");
			vendedor2.setNombre("Elvio Castro");
			vendedor2.setDireccion("av. la marina");
			vendedor2.setTelefono(4221210);
			vendedor2.setSueldo(9200f);
			vendedor2.setObservacion("ninguna");
			
			test = vendedorRepository.save(test);
			vendedor2 = vendedorRepository.save(vendedor2);
			
			vendedorRepository.save(test);
			vendedorRepository.save(vendedor2);
			
			Alquiler alquiler1 = new Alquiler();
			alquiler1.setPrecio(160.99);
			alquiler1.setFechaEntrada(new Date(2019, 10 , 10));
			alquiler1.setEstado("activo");
			alquiler1.setObservacion("ninguna");
			alquiler1.setVendedor(vendedor2);
			
			Alquiler megaalquiler = new Alquiler();
			megaalquiler.setPrecio(390.99);
			megaalquiler.setFechaEntrada(new Date(2019, 12 , 6));
			megaalquiler.setEstado("activo");
			megaalquiler.setObservacion("si");
			megaalquiler.setVendedor(vendedor2);
			
			
			alquilerRepository.save(alquiler1);
			alquilerRepository.save(megaalquiler);
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
