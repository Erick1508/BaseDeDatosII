package clases;

import java.util.HashSet;
import java.util.Set;

public class Empresa {
	
	private String nombreEmpresa;
	private String direccionFisica;
	private int estimadoCliente;
	
	private Telefono telefonoEmpresa;
	
	private Set<Promocion> promociones = new HashSet<Promocion>(0); //La empresa tiene un set de promociones
	
	public Empresa(String nombreEmpresa, String direccionFisica,
			int estimadoCliente, Telefono tlf) {
		this.nombreEmpresa = nombreEmpresa;
		this.direccionFisica = direccionFisica;
		this.estimadoCliente = estimadoCliente;
		this.telefonoEmpresa = tlf;
	}

	
	public Set<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<Promocion> promociones) {
		this.promociones = promociones;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getDireccionFisica() {
		return direccionFisica;
	}

	public void setDireccionFisica(String direccionFisica) {
		this.direccionFisica = direccionFisica;
	}

	public int getEstimadoCliente() {
		return estimadoCliente;
	}

	public void setEstimadoCliente(int estimadoCliente) {
		this.estimadoCliente = estimadoCliente;
	}

	public Telefono getTelefonoEmpresa() {
		return telefonoEmpresa;
	}
	
	public void setTelefonoEmpresa(Telefono telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}
	
}
