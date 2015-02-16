package clases;

import java.sql.Date;

public class ValeRegalo extends ValePromocion{

	private Date fechaEnvio;
	
	public ValeRegalo(int cantidadVales, String descripcionVale,
			String dir_correo, boolean validado_por_mobile, Date fechaVigencia, Date fechaEnvio) {
		super(cantidadVales, descripcionVale, dir_correo, validado_por_mobile,
				fechaVigencia);
		this.fechaEnvio = fechaEnvio;				
	}

	public Date getFechaEnvio() {
		return fechaEnvio;
	}

	public void setFechaEnvio(Date fechaEnvio) {
		this.fechaEnvio = fechaEnvio;
	}
	
	
	
}