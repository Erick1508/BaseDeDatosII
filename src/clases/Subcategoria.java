package clases;

public class Subcategoria {
	
	private int subcat_id;
	private String nombreSubCat;
	private String descripcionSubCat;
	
	private Categoria categoria;

	public Subcategoria(String nombreSubCat, String descripcionSubCat) {
		this.nombreSubCat = nombreSubCat;
		this.descripcionSubCat = descripcionSubCat;
	}
	
	public int getSubcat_id() {
		return subcat_id;
	}

	public void setSubcat_id(int subcat_id) {
		this.subcat_id = subcat_id;
	}

	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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
