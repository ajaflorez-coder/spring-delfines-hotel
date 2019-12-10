package pe.edu.delfines.models.entity;

import java.util.ArrayList;
import java.util.List;

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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pe.edu.delfines.models.entity.Alquiler;

@Entity
@Table(name = "habitaciones")
public class Habitacion {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "habitacion_id")
	private Integer id;
	
	@Column(name = "numeroCamas")
	private Integer numeroCamas;
	
	@Column(name = "descripcion", length = 100)
	private String descripcion;
	
	@Column(name = "precio")
	private double precio;
	
	@JsonIgnore
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "tipo_id")
	private Tipo tipo;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@JsonIgnoreProperties("habitacion")
	@OneToMany(mappedBy = "habitacion", fetch = FetchType.LAZY)
	private List<Alquiler> alquileres;
	
	public Habitacion() {
		alquileres= new ArrayList<>();
		
	}
	

	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Integer getNumeroCamas() {
		return numeroCamas;
	}


	public void setNumeroCamas(Integer numeroCamas) {
		this.numeroCamas = numeroCamas;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public double getPrecio() {
		return precio;
	}


	public void setPrecio(double d) {
		this.precio = d;
	}


	public String getObservacion() {
		return observacion;
	}


	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}


	public List<Alquiler> getAlquileres() {
		return alquileres;
	}


	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}


	public Tipo getTipo() {
		return tipo;
	}

	public void setTipo(Tipo tipo) {
		this.tipo = tipo;
	}
}