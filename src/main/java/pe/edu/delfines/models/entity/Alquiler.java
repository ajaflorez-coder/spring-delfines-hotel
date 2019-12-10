package pe.edu.delfines.models.entity;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;




@Entity
@Table(name = "alquileres")
public class Alquiler {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "precio")
	private Integer precio;
	
	@Column(name = "fecha_entrada")
	@Temporal(TemporalType.DATE)
	private Date fechaEntrada;
	
	@Column(name = "fecha_salida")
	@Temporal(TemporalType.DATE)
	private Date fechaSalida;
	
	@Column(name = "estado", length = 30)
	private String estado;
	
	@Column(name = "obversacion", length = 30)
	private String observacion;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "vendedor_id")
	private Vendedor vendedor;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "habitacion_id")
	private Habitacion habitacion;
	
public Alquiler() {
		
	}

public Integer getId() {
	return id;
}

public void setId(Integer id) {
	this.id = id;
}

public Integer getPrecio() {
	return precio;
}

public void setPrecio(Integer precio) {
	this.precio = precio;
}

public Date getFechaEntrada() {
	return fechaEntrada;
}

public void setFechaEntrada(Date fechaEntrada) {
	this.fechaEntrada = fechaEntrada;
}

public Date getFechaSalida() {
	return fechaSalida;
}

public void setFechaSalida(Date fechaSalida) {
	this.fechaSalida = fechaSalida;
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
