package clases;

import java.util.Date;

public class ValePromocion {
	 	
	//id
	private int codigo_de_vale;
	
	private int cantidadVales;
	private String descripcionVale;
	private String dir_correo;
	private boolean validado_por_mobile;
	private Date fechaVigencia;
	    
	private Compra compra;
	    
	public ValePromocion(){}
	
	public ValePromocion(int cantidadVales,
			String descripcionVale, String dir_correo,
		boolean validado_por_mobile, Date fechaVigencia) {
		this.cantidadVales = cantidadVales;
		this.descripcionVale = descripcionVale;
		this.dir_correo = dir_correo;
		this.validado_por_mobile = validado_por_mobile;
		this.fechaVigencia = fechaVigencia;
	}
	    
	public int getCodigo_de_vale() {
		return codigo_de_vale;
	}
	public void setCodigo_de_vale(int codigo_de_vale) {
		this.codigo_de_vale = codigo_de_vale;
	}
	public int getCantidadVales() {
		return cantidadVales;
	}
	public void setCantidadVales(int cantidadVales) {
		this.cantidadVales = cantidadVales;
	}
	public String getDescripcionVale() {
		return descripcionVale;
	}
	public void setDescripcionVale(String descripcionVale) {
		this.descripcionVale = descripcionVale;
	}
	public String getDir_correo() {
		return dir_correo;
	}
	public void setDir_correo(String dir_correo) {
		this.dir_correo = dir_correo;
	}
	public boolean isValidado_por_mobile() {
		return validado_por_mobile;
	}
	public void setValidado_por_mobile(boolean validado_por_mobile) {
		this.validado_por_mobile = validado_por_mobile;
	}
	public Date getFechaVigencia() {
		return fechaVigencia;
	}
	public void setFechaVigencia(Date fechaVigencia) {
		this.fechaVigencia = fechaVigencia;
	}
	public Compra getCompra() {
		return compra;
	}

	public void setCompra(Compra compra) {
		this.compra = compra;
	}
	    
}
