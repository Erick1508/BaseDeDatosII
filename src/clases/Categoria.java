package clases;

import java.util.HashSet;
import java.util.Set;

public class Categoria {
	
	private String nombreCategoria;
	private String descripcionCat;
	
	private Set<Subcategoria> subcategorias = new HashSet<Subcategoria>(0);
	
	public Categoria(String nombreCategoria, String descripcionCat) {
		this.nombreCategoria = nombreCategoria;
		this.descripcionCat = descripcionCat;
	}
	
	public Set<Subcategoria> getSubcategorias() {
		return subcategorias;
	}

	public void setSubcategorias(Set<Subcategoria> subcategorias) {
		this.subcategorias = subcategorias;
	}

	public String getNombreCategoria() {
		return nombreCategoria;
	}

	public void setNombreCategoria(String nombreCategoria) {
		this.nombreCategoria = nombreCategoria;
	}

	public String getDescripcionCat() {
		return descripcionCat;
	}

	public void setDescripcionCat(String descripcionCat) {
		this.descripcionCat = descripcionCat;
	}
	
	
}
