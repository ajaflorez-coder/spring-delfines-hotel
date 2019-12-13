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
			
			Cliente ana = new Cliente();
			ana.setNombre("Ana");
			ana.setDocumento("74125953");
			ana.setFechaNacimiento(new Date(1997, 4, 20));
			ana.setLugarNacimiento("Piura");
			ana.setSexo("Femenino");
			ana.setObservacion("ninguna observacion");
			
			Cliente luisa = new Cliente();
			luisa.setDocumento("741258473");
			luisa.setNombre("Luisa");
			luisa.setFechaNacimiento(new Date(1997, 6, 15));
			luisa.setLugarNacimiento("Lima");
			luisa.setSexo("Femenino");
			luisa.setObservacion("ninguna observacion");
			
			ana = clienteRepository.save(ana);
			luisa = clienteRepository.save(luisa);
			
			Tipo matrimonial = new Tipo();
			matrimonial.setId("N01");
			matrimonial.setNombre("Matrimonial");
			
			Tipo estandar = new Tipo();
			estandar.setId("N02");
			estandar.setNombre("Estandar");
			
			matrimonial = tipoRepository.save(matrimonial);
			estandar = tipoRepository.save(estandar);
			
			
			Habitacion one = new Habitacion();
			one.setNumeroCamas(2);
			one.setDescripcion("Habitacion para 2 personas");
			one.setPrecio(1500f);
			one.setTipo(estandar);
			one.setObservacion("Ninguna Observacion");
			
			Habitacion two = new Habitacion();
			two.setNumeroCamas(2);
			two.setDescripcion("Habitacion para 2 personas");
			two.setPrecio(2500f);
			two.setTipo(matrimonial);
			two.setObservacion("Ninguna Observacion");
			
			one = habitacionRepository.save(one);
			two = habitacionRepository.save(two);
			
			Vendedor raul = new Vendedor();
			raul.setId("n01");
			raul.setNombre("Raul");
			raul.setDireccion("jr Alemania 1545");
			raul.setTelefono("987654321");
			raul.setObservacion("ninguna observacion");
			raul.setSueldo("2200");
			
			Vendedor fernando = new Vendedor();
			fernando.setId("n02");
			fernando.setNombre("Fernando");
			fernando.setDireccion("jr Alemania 2051");
			fernando.setTelefono("987654321");
			fernando.setObservacion("ninguna observacion");
			fernando.setSueldo("2000");
			
			raul = vendedorRepository.save(raul);
			fernando = vendedorRepository.save(fernando);
			
			Alquiler primer = new Alquiler();
			primer.setPrecio("200");
			primer.setFecha_entrada("20/05/2020");
			primer.setFecha_salida("22/05/2020");
			primer.setObservacion("Ninguna observacion");
			primer.setEstado("Reserva");
			
			
			
			Alquiler segun = new Alquiler();
			segun.setPrecio("2400");
			segun.setFecha_entrada("24/06/2020");
			segun.setFecha_salida("26/06/2020");
			segun.setObservacion("Ninguna observacion");
			segun.setEstado("Reserva");
			
			primer = alquilerRepository.save(primer);
			segun = alquilerRepository.save(segun);
			
			
	
			
			fernando.addAlquiler(segun);
			fernando.addAlquiler(primer);
			
			primer.setVendedor(fernando);
			segun.setVendedor(fernando);
			
			primer.setCliente(luisa);
			segun.setCliente(ana);
			
			luisa.addAlquiler(primer);
			ana.addAlquiler(segun);
			
			one.setTipo(estandar);
			two.setTipo(matrimonial);
			
			
			one.addAlquiler(primer);
			two.addAlquiler(segun);
			
			
			primer.setHabitacion(one);
			segun.setHabitacion(two);
			
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
