package clases;

import java.util.Date;
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
    private double montoDeCompra;
    private Date fechaCompra;
    
    //asociacion 1-1..2 con metodo de pago
    private MetodoPago metodoPagos;
    
    //asociacion *-* con Usuario
    private Set<Usuario> usuariosCompartir = new HashSet<Usuario>();
    
    //CLASE asociacion, requiero hacer una par de many to one
    // se supone que esta clase debe cumplir ademas con el many to many de las otras, de ahi el hecho de t
    // tener las dos private many to one.
    private Usuario usuario;
    private Promocion promocion;
    
    public Compra(){}
    
    public Compra(int cantidadPromocion, double montoDeCompra, Date fechaCompra) {
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

	public double getMontoDeCompra() {
		return montoDeCompra;
	}

	public void setMontoDeCompra(double montoDeCompra) {
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Promocion getPromocion() {
		return promocion;
	}

	public void setPromocion(Promocion promocion) {
		this.promocion = promocion;
	}

	public Set<Usuario> getUsuariosCompartir() {
		return usuariosCompartir;
	}

	public void setUsuariosCompartir(Set<Usuario> usuariosCompartir) {
		this.usuariosCompartir = usuariosCompartir;
	}    
    
	
    
}
