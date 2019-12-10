package pe.edu.delfines;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import pe.edu.delfines.models.entity.Alquiler;
import pe.edu.delfines.models.entity.Cliente;
import pe.edu.delfines.models.entity.Habitacion;
import pe.edu.delfines.models.entity.Tipo;
import pe.edu.delfines.models.entity.Vendedor;

@SpringBootTest
class DelfinesApplicationTests {

	@Test
	void contextLoads() {
		
		Cliente cli1 = new Cliente();
		cli1.setNombre("Lucian");
		cli1.setSexo('m');
		
		Vendedor ven1 = new Vendedor();
		ven1.setNombre("Ezreal");
		ven1.setSueldo(500.00f);
		
		Habitacion hab1 = new Habitacion();
		hab1.setDescripcion("Excelente");
		hab1.setNumeroCamas(2);
	
		
		Tipo tipo1 = new Tipo();
		tipo1.setNombre("Camarote");
		tipo1.setNombre("personal");
		
		
		Alquiler alqui1 = new Alquiler();
		alqui1.setObservacion("Pago Responsable");
		alqui1.setPrecio(80);
	}
	
	

}
