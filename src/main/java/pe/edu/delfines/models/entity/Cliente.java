package pe.edu.delfines.models.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "clientes")
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "documento", length = 8)
	private String documento;
	
	@Column(name = "nombre", length = 60)
	private String nombre;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "fecha_nacimiento")	
	private Date fechaNacimiento;
	
	@Column(name = "lugar_nacimiento", length = 50)
	private String lugarNacimiento;
	
	@Column(name = "sexo", length = 1)
	private char sexo;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	
	
	public Cliente() {
		
	}
	
}

