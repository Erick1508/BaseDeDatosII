package clases;

import java.sql.Date;

//falta fecha asociada, atributo multivaluado
public class Promocion {

	private String descripcionPromocion;
	private int monto_original;
	private int monto_ofertado;
	private String URL_detalles;
	private Date fecha_vigencia;
	private float latitud;
	private float longiud;
	private float altitud;
	
	public Promocion(String descripcionPromocion, int monto_original,
			int monto_ofertado, String uRL_detalles, Date fecha_vigencia,
			float latitud, float longiud, float altitud) {
		this.descripcionPromocion = descripcionPromocion;
		this.monto_original = monto_original;
		this.monto_ofertado = monto_ofertado;
		URL_detalles = uRL_detalles;
		this.fecha_vigencia = fecha_vigencia;
		this.latitud = latitud;
		this.longiud = longiud;
		this.altitud = altitud;
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

	public float getLatitud() {
		return latitud;
	}

	public void setLatitud(float latitud) {
		this.latitud = latitud;
	}

	public float getLongiud() {
		return longiud;
	}

	public void setLongiud(float longiud) {
		this.longiud = longiud;
	}

	public float getAltitud() {
		return altitud;
	}

	public void setAltitud(float altitud) {
		this.altitud = altitud;
	}
	
	
	
	
}
