package clases;

import java.util.HashSet;
import java.util.Set;

public class Empresa {
	
	private String nombreEmpresa;
	private String direccionFisica;
	private int codigoPais;
	private int telefono;
	private int estimadoCliente;
	
	private Set<Promocion> promociones = new HashSet<Promocion>(0); //La empresa tiene un set de promociones
	
	public Empresa(String nombreEmpresa, String direccionFisica,
			int codigoPais, int telefono, int estimadoCliente) {
		this.nombreEmpresa = nombreEmpresa;
		this.direccionFisica = direccionFisica;
		this.codigoPais = codigoPais;
		this.telefono = telefono;
		this.estimadoCliente = estimadoCliente;
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

	public int getCodigoPais() {
		return codigoPais;
	}

	public void setCodigoPais(int codigoPais) {
		this.codigoPais = codigoPais;
	}

	public int getTelefono() {
		return telefono;
	}

	public void setTelefono(int telefono) {
		this.telefono = telefono;
	}

	public int getEstimadoCliente() {
		return estimadoCliente;
	}

	public void setEstimadoCliente(int estimadoCliente) {
		this.estimadoCliente = estimadoCliente;
	}
	
	
}
