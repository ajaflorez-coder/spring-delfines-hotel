package pe.edu.delfines.models.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import pe.edu.delfines.models.entity.Alquiler;

@Entity
@Table(name = "vendedores")
public class Vendedor {
	
	@Id	
	@Column(name = "vendedor_id", length = 4)
	private String id;
	
	@Column(name = "nombre", length = 60)
	private String nombre;
	
	@Column(name = "direccion", length = 70)
	private String direccion;

	@Column(name = "telefono", length = 20)
	private String telefono;
	
	@Column(name = "observacion", length = 100)
	private String observacion;
	
	@Column(name = "sueldo")
	private double sueldo;
	
	@JsonIgnoreProperties("vendedor")
	@OneToMany(mappedBy = "vendedor", fetch = FetchType.LAZY)
	private List<Alquiler> alquileres;
	
	public Vendedor() {
		alquileres = new ArrayList<>();
		
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getObservacion() {
		return observacion;
	}

	public void setObservacion(String observacion) {
		this.observacion = observacion;
	}

	public double getSueldo() {
		return sueldo;
	}

	public void setSueldo(double d) {
		this.sueldo = d;
	}

	public List<Alquiler> getAlquileres() {
		return alquileres;
	}

	public void setAlquileres(List<Alquiler> alquileres) {
		this.alquileres = alquileres;
	}
	
}
