package clases;

import java.util.HashSet;
import java.util.Set;

public class Subcategoria {
	
	private int subcat_id;
	private String nombreSubCat;
	private String descripcionSubCat;
	
	// asociacion con categoria
	private Categoria categoria;
	
	//asociacion con promocion
	private Set<Promocion> promociones = new HashSet<Promocion>(0);
	
	public Subcategoria(){}
	
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

	public Set<Promocion> getPromociones() {
		return promociones;
	}

	public void setPromociones(Set<Promocion> promociones) {
		this.promociones = promociones;
	}
	
}
