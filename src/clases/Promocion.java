package clases;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

//falta fecha asociada, atributo multivaluado
public class Promocion {
	
	private int promocion_id;
	private String descripcionPromocion;
	private int monto_original;
	private int monto_ofertado;
	private String URL_detalles;
	private Date fecha_vigencia;
	private double latitud;
	private double longitud;
	private double altitud;
	
	//asociacion con empresa
	private Empresa empresa;
	
	//Asociacion con subcategoria
	private Subcategoria subcategoria;
	
	public Promocion(String descripcionPromocion, int monto_original,
			int monto_ofertado, String uRL_detalles, Date fecha_vigencia,
			double latitud, double longitud, double altitud) {
		this.descripcionPromocion = descripcionPromocion;
		this.monto_original = monto_original;
		this.monto_ofertado = monto_ofertado;
		URL_detalles = uRL_detalles;
		this.fecha_vigencia = fecha_vigencia;
		this.latitud = latitud;
		this.longitud = longitud;
		this.altitud = altitud;
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

	public Date getFecha_vigencia() {
		return fecha_vigencia;
	}

	public void setFecha_vigencia(Date fecha_vigencia) {
		this.fecha_vigencia = fecha_vigencia;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}

	public double getAltitud() {
		return altitud;
	}

	public void setAltitud(double altitud) {
		this.altitud = altitud;
	}
	
	public Subcategoria getSubcategoria() {
		return subcategoria;
	}

	public void setSubcategoria(Subcategoria subcategoria) {
		this.subcategoria = subcategoria;
	}
	
	
	
}
