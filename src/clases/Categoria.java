package clases;

public class Categoria {
	
	private String nombreCategoria;
	private String descripcionCat;
	
	public Categoria(String nombreCategoria, String descripcionCat) {
		super();
		this.nombreCategoria = nombreCategoria;
		this.descripcionCat = descripcionCat;
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
