package clases;

import java.util.HashSet;
import java.util.Set;

public class Ciudad {
	
	private String nombreCiudad;
	private String pais;
	
	// asociacion muchos a muchos.. con promocion
	private Set<Promocion> promociones = new HashSet<Promocion>();
	
	public Ciudad(String nombreCiudad, String pais) {
		this.nombreCiudad = nombreCiudad;
		this.pais = pais;
	}
	
	public String getNombreCiudad() {
		return nombreCiudad;
	}
	public void setNombreCiudad(String nombreCiudad) {
		this.nombreCiudad = nombreCiudad;
	}
	public String getPais() {
		return pais;
	}
	public void setPais(String pais) {
		this.pais = pais;
	}

	public Set<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<Promocion> promociones) {
		this.promociones = promociones;
	}
	
	
}
