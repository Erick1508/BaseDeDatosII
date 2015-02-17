package clases;

import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

public class Compra {

	//id
	//la foranea al vale de promocion
    private int codigo_de_vale;
    //asociacion 1-1 con ValePromocion
    private ValePromocion vale;
    private ValeRegalo valeR;
    
	private int cantidadPromocion;
    private int montoDeCompra;
    private Date fechaCompra;
    
    //asociacion 1-1..2 con metodo de pago
    private MetodoPago metodoPagos;
        
    public Compra(int cantidadPromocion, int montoDeCompra, Date fechaCompra) {
		this.cantidadPromocion = cantidadPromocion;
		this.montoDeCompra = montoDeCompra;
		this.fechaCompra = fechaCompra;
	}

	public int getCantidadPromocion() {
		return cantidadPromocion;
	}

	public void setCantidadPromocion(int cantidadPromocion) {
		this.cantidadPromocion = cantidadPromocion;
	}

	public int getMontoDeCompra() {
		return montoDeCompra;
	}

	public void setMontoDeCompra(int montoDeCompra) {
		this.montoDeCompra = montoDeCompra;
	}

	public Date getFechaCompra() {
		return fechaCompra;
	}

	public void setFechaCompra(Date fechaCompra) {
		this.fechaCompra = fechaCompra;
	}

	public ValePromocion getVale() {
		return vale;
	}

	public void setVale(ValePromocion vale) {
		this.vale = vale;
	}

	public int getCodigo_de_vale() {
		return codigo_de_vale;
	}

	public void setCodigo_de_vale(int codigo_de_vale) {
		this.codigo_de_vale = codigo_de_vale;
	}

	public ValeRegalo getValeR() {
		return valeR;
	}

	public void setValeR(ValeRegalo valeR) {
		this.valeR = valeR;
	}

	public MetodoPago getMetodoPagos() {
		return metodoPagos;
	}

	public void setMetodoPagos(MetodoPago metodoPagos) {
		this.metodoPagos = metodoPagos;
	}    
    
    
}
