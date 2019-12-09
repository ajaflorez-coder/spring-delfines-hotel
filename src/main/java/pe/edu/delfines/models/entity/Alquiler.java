package pe.edu.delfines.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	
	@Column
	private Float precio;
	
	@Column
	private String estado;
	
	@Column
	private String observacion;
	
	@JsonIgnoreProperties("alquileres")
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor; 
	
	@JsonIgnoreProperties("alquileres")
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "cliente_id")
	private Cliente cliente; 
	
	@JsonIgnoreProperties("alquileres")
	@ManyToOne(fetch =FetchType.LAZY )
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;

	
	public Alquiler() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Float getPrecio() {
		return precio;
	}

	public void setPrecio(Float precio) {
		this.precio = precio;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public void setVendedor(Vendedor vendedor) {
		this.vendedor = vendedor;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Habitacion getHabitacion() {
		return habitacion;
	}

	public void setHabitacion(Habitacion habitacion) {
		this.habitacion = habitacion;
	} 
	
	
	
}
