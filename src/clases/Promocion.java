package clases;

import java.util.Date;
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
	
	// asociacion adquiere, es la clase asociacion con Compra
	private Set<Compra> compras = new HashSet<Compra>(0);
	
	// asociacion 1->1..* con FechaAsociada
    private Set<FechaAsociada> fechasAsociadas = new HashSet<FechaAsociada>(0);
	
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

	public Date getPeriodo_vigencia() {
		return periodo_vigencia;
	}

	public void setPeriodo_vigencia(Date periodo_vigencia) {
		this.periodo_vigencia = periodo_vigencia;
	}

	public Set<Compra> getCompras() {
		return compras;
	}

	public void setCompras(Set<Compra> compras) {
		this.compras = compras;
	}

	public Set<FechaAsociada> getFechasAsociadas() {
		return fechasAsociadas;
	}

	public void setFechasAsociadas(Set<FechaAsociada> fechasAsociadas) {
		this.fechasAsociadas = fechasAsociadas;
	}
	
	
}
