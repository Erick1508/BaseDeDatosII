package clases;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

//falta fecha asociada, atributo multivaluado
public class Promocion{
	
	private int promocion_id;
	private String descripcionPromocion;
	private int monto_original;
	private int monto_ofertado;
	private String URL_detalles;
	private Date periodo_vigencia;
	
	// atributo compuesto ubicacionGeografica
	private UbicacionGeografica UbicacionGeo;
	
	//asociacion con empresa
	private Empresa empresa;
	
	//Asociacion con subcategoria
	private Subcategoria subcategoria;
	
	// asociacion con Ciudad * a *
	private Set<Ciudad> ciudades = new HashSet<Ciudad>();
	
	public Promocion(){};
	
	public Promocion(String descripcionPromocion, int monto_original,
			int monto_ofertado, String uRL_detalles, Date periodo_vigencia, UbicacionGeografica ubgeo) {
		this.descripcionPromocion = descripcionPromocion;
		this.monto_original = monto_original;
		this.monto_ofertado = monto_ofertado;
		URL_detalles = uRL_detalles;
		this.periodo_vigencia = periodo_vigencia;
		this.UbicacionGeo = ubgeo;
	}
	
	public int getPromocion_id() {
		return promocion_id;
	}

	public void setPromocion_id(int promocion_id) {
		this.promocion_id = promocion_id;
	}

	public Empresa getEmpresa() {
		return empresa;
	}

	public void setEmpresa(Empresa empresa) {
		this.empresa = empresa;
	}
	
	public String getDescripcionPromocion() {
		return descripcionPromocion;
	}

	public void setDescripcionPromocion(String descripcionPromocion) {
		this.descripcionPromocion = descripcionPromocion;
	}

	public int getMonto_original() {
		return monto_original;
	}

	public void setMonto_original(int monto_original) {
		this.monto_original = monto_original;
	}

	public int getMonto_ofertado() {
		return monto_ofertado;
	}

	public void setMonto_ofertado(int monto_ofertado) {
		this.monto_ofertado = monto_ofertado;
	}

	public String getURL_detalles() {
		return URL_detalles;
	}

	public void setURL_detalles(String uRL_detalles) {
		URL_detalles = uRL_detalles;
	}

	public Date getperiodo_vigencia() {
		return periodo_vigencia;
	}

	public void setperiodo_vigencia(Date periodo_vigencia) {
		this.periodo_vigencia = periodo_vigencia;
	}

	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}

	public Set<Ciudad> getCiudades() {
		return ciudades;
	}

	public void setCiudades(Set<Ciudad> ciudades) {
		this.ciudades = ciudades;
	}

	public UbicacionGeografica getUbicacionGeo() {
		return UbicacionGeo;
	}

	public void setUbicacionGeo(UbicacionGeografica ubicacionGeo) {
		UbicacionGeo = ubicacionGeo;
	}
	
}
