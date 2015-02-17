package clases;

import java.sql.Date;

public class FechaAsociada {

	private long fecha_id;
	private Date fecha;
	
	private Promocion promocion;
	
	public FechaAsociada(Date fecha) {
		this.fecha = fecha;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public long getFecha_id() {
		return fecha_id;
	}

	public void setFecha_id(long fecha_id) {
		this.fecha_id = fecha_id;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}
	
	
	
}
