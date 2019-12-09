package pe.edu.delfines;

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
public class DelfinesApplicationTests {
	
	@Autowired
	VendedorRepository _vendedorRepo;
	
	@Autowired
	ClienteRepository _clienteRepo;
	
	@Autowired
	AlquilerRepository _alquilerRepo;
	
	@Autowired
	TipoRepository _tipoRepo;
	
	@Autowired
	HabitacionRepository _habitacionRepo;
	
	@Test
	void contextLoads() {
		
		try {
			
			Habitacion _habita = new Habitacion();
			_habita.setNumeroCamas(5);
			_habita.setDescripcion("PA DOS");
			
			Habitacion _habita2 = new Habitacion();
			_habita.setNumeroCamas(3);
			_habita.setDescripcion("PA tres");
			
			_habita =_habitacionRepo.save(_habita);
			_habita2 =_habitacionRepo.save(_habita2);
			
			_habitacionRepo.save(_habita); 
			
			Cliente _cliente = new Cliente();
			_cliente.setDocumento("DNI");
			_cliente.setNombre("Pedraza");
			
			Cliente _cliente2 = new Cliente();
			_cliente2.setDocumento("DNI");
			_cliente2.setNombre("Pedraza");
			
			_clienteRepo.save(_cliente);
			_clienteRepo.save(_cliente2);
			
			Vendedor _vendedor = new Vendedor();
			_vendedor.setNombre("Roberto");
			_vendedor.setId("N001");
			

			Vendedor _vendedor2 = new Vendedor();
			_vendedor2.setNombre("cAMILA");
			_vendedor2.setId("N002");
			
			_vendedorRepo.save(_vendedor);
			_vendedorRepo.save(_vendedor2);
			
		   Tipo _tipo = new Tipo();
		   _tipo.setId("N01");
		   _tipo.setNombre("MATRIMONIAL");
			

		   Tipo _tipo1 = new Tipo();
		   _tipo.setId("N02");
		   _tipo.setNombre("DUPLO");
		   
		   _tipoRepo.save(_tipo);
		   _tipoRepo.save(_tipo1);
		   
		   Alquiler _alquiler = new Alquiler();
		   _alquiler.setPrecio((float)500.0);
		   _alquiler.setVendedor(_vendedor);
		   
		   Alquiler _alquiler2 = new Alquiler();
		   _alquiler2.setPrecio((float)800.0);
		   _alquiler2.setVendedor(_vendedor2);
		   
		   _alquilerRepo.save(_alquiler2);
		   _alquilerRepo.save(_alquiler);
		   
		}catch (Exception e) {
			// TODO: handle exception
		}
	}

}
