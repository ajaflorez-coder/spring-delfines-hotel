package pe.edu.delfines;

import java.util.Date;

import org.junit.jupiter.api.Test;

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


@SpringBootTest
class DelfinesApplicationTests {

	@Autowired
	private AlquilerRepository alquilerRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private HabitacionRepository habitacionRepository;
	
	@Autowired
	private TipoRepository tipoRepository;
	
	@Autowired
	private VendedorRepository vendedorRepository;
	
	@Test
	void contextLoads() {
		
		try {
			
			Vendedor raul = new Vendedor();
			raul.setId("N01");
			raul.setNombre("Raul");
			raul.setDireccion("jr Alemania 1545");
			raul.setTelefono("987654321");
			raul.setObservacion("ninguna observacion");
			raul.setSueldo("2200");
			
			raul = vendedorRepository.save(raul);
			
			Vendedor fernando = new Vendedor();
			fernando.setId("N01");
			fernando.setNombre("Fernando");
			fernando.setDireccion("jr Alemania 2051");
			fernando.setTelefono("987654321");
			fernando.setObservacion("ninguna observacion");
			fernando.setSueldo("2000");
			
			
			fernando = vendedorRepository.save(fernando);
			
			
			Cliente ana = new Cliente();
			ana.setDocumento("74125953");
			ana.setNombre("Ana");
			ana.setFechaNacimiento(new Date(1997, 4, 20));
			ana.setLugarNacimiento("Piura");
			ana.setSexo("Femenino");
			ana.setObservacion("ninguna observacion");
			ana = clienteRepository.save(ana);
			
			Cliente luisa = new Cliente();
			luisa.setDocumento("741258473");
			luisa.setNombre("Luisa");
			luisa.setFechaNacimiento(new Date(1997, 6, 15));
			luisa.setLugarNacimiento("Lima");
			luisa.setSexo("Femenino");
			luisa.setObservacion("ninguna observacion");
			
			luisa = clienteRepository.save(luisa);
			
			
			
			Tipo matrimonial = new Tipo();
			matrimonial.setId("N01");
			matrimonial.setNombre("Matrimonial");
			
			matrimonial = tipoRepository.save(matrimonial);
			
			Tipo estandar = new Tipo();
			estandar.setId("N02");
			estandar.setNombre("Estandar");
			
			estandar = tipoRepository.save(estandar);
			
			Habitacion one = new Habitacion();
			one.setNumeroCamas(2);
			one.setDescripcion("Habitacion para 2 personas");
			one.setPrecio(1500f);
			one.setObservacion("Ninguna Observacion");
			one.setTipo(estandar);
			
			one = habitacionRepository.save(one);
			
			Habitacion two = new Habitacion();
			two.setNumeroCamas(2);
			two.setDescripcion("Habitacion para 2 personas");
			two.setPrecio(2500f);
			two.setObservacion("Ninguna Observacion");
			two.setTipo(matrimonial);
			
			
			two = habitacionRepository.save(two);
			
			Alquiler primer = new Alquiler();
			primer.setPrecio("2000");
			primer.setFecha_entrada("20/05/2020");
			primer.setFecha_salida("22/05/2020");
			primer.setEstado("Reserva");
			primer.setObservacion("Ninguna observacion");
			primer.setVendedor(fernando);
			primer.setCliente(luisa);
			primer.setHabitacion(one);
			
			primer = alquilerRepository.save(primer);
			
			Alquiler segun = new Alquiler();
			segun.setPrecio("2400");
			segun.setFecha_entrada("24/06/2020");
			segun.setFecha_salida("26/06/2020");
			segun.setEstado("Reserva");
			segun.setObservacion("Ninguna observacion");
			segun.setVendedor(fernando);
			segun.setCliente(ana);
			segun.setHabitacion(two);
			
			segun = alquilerRepository.save(segun);
			
			

		
			
		
			
			
		
			
			
			
			
			
			
			
		
			
			
			
			
			
			alquilerRepository.save(primer);
			alquilerRepository.save(segun);
			vendedorRepository.save(raul);
			vendedorRepository.save(fernando);
			clienteRepository.save(ana);
			clienteRepository.save(luisa);
			tipoRepository.save(matrimonial);
			tipoRepository.save(estandar);
			habitacionRepository.save(one);
			habitacionRepository.save(two);
			
			
			
			
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	
	

}
