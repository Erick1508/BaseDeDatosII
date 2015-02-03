package clases;

public class Ciudad {
	private String nombreCiudad;
	private String pais;
	
	public Ciudad(String nombreCiudad, String pais) {
		super();
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
	
	
}
