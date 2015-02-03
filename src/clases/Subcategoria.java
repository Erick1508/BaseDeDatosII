package clases;

public class Subcategoria {
	
	private String nombreSubCat;
	private String descripcionSubCat;
	
	public Subcategoria(String nombreSubCat, String descripcionSubCat) {
		super();
		this.nombreSubCat = nombreSubCat;
		this.descripcionSubCat = descripcionSubCat;
	}
	
	public String getNombreSubCat() {
		return nombreSubCat;
	}
	public void setNombreSubCat(String nombreSubCat) {
		this.nombreSubCat = nombreSubCat;
	}
	public String getDescripcionSubCat() {
		return descripcionSubCat;
	}
	public void setDescripcionSubCat(String descripcionSubCat) {
		this.descripcionSubCat = descripcionSubCat;
	}
	
}
